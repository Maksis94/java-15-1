package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    AviaSouls manager = new AviaSouls();

    Ticket ticket1 = new Ticket("Город 1", "Город 2", 10000, 1000, 1300);
    Ticket ticket2 = new Ticket("Город 5", "Город 3", 15000, 1400, 1600);
    Ticket ticket3 = new Ticket("Город 3", "Город 2", 9000, 1500, 1900);
    Ticket ticket4 = new Ticket("Город 1", "Город 5", 10000, 700, 1000);
    Ticket ticket5 = new Ticket("Город 1", "Город 5", 15000, 730, 900);
    Ticket ticket6 = new Ticket("Город 3", "Город 2", 8000, 730, 1200);

    @Test
    public void shouldSearchTicketsAndSortByPrice() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Assertions.assertArrayEquals(manager.search("Город 1", "Город 2"), new Ticket[]{ticket1});
        Assertions.assertArrayEquals(manager.search("Город 1", "Город 5"),
                new Ticket[]{ticket4, ticket5});
        Assertions.assertArrayEquals(manager.search("Город 3", "Город 2"),
                new Ticket[]{ticket6, ticket3});
        Assertions.assertArrayEquals(manager.search("Город 6", "Город 7"), new Ticket[]{});
    }

    @Test
    public void shouldSearchEmptyManager() {
        Assertions.assertArrayEquals(manager.search("Город 2", "Город 5"), new Ticket[]{});
    }

    @Test
    public void shouldSearchTicketsAndSortByDuration() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Assertions.assertArrayEquals(manager.searchAndSortBy("Город 1", "Город 2", timeComparator),
                new Ticket[]{ticket1});
        Assertions.assertArrayEquals(manager.searchAndSortBy("Город 1", "Город 5", timeComparator),
                new Ticket[]{ticket5, ticket4});
        Assertions.assertArrayEquals(manager.searchAndSortBy("Город 3", "Город 2", timeComparator),
                new Ticket[]{ticket3, ticket6});
        Assertions.assertArrayEquals(manager.searchAndSortBy("Город 6", "Город 7", timeComparator),
                new Ticket[]{});
    }
}
