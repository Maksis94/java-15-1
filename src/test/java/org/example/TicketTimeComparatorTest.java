package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketTimeComparatorTest {
    @Test
    public void shouldCompareElementsByDuration() {
        Ticket ticket1 = new Ticket("Город отправления", "Город назначения", 10000, 1000, 1300);
        Ticket ticket2 = new Ticket("Город отправления", "Город назначения", 15000, 1400, 1600);
        Ticket ticket3 = new Ticket("Город отправления", "Город назначения", 9000, 1500, 1900);
        Ticket ticket4 = new Ticket("Город отправления", "Город назначения", 10000, 700, 1000);

        TicketTimeComparator comparator = new TicketTimeComparator();
        Assertions.assertEquals(comparator.compare(ticket1, ticket2), 1);
        Assertions.assertEquals(comparator.compare(ticket1, ticket3), -1);
        Assertions.assertEquals(comparator.compare(ticket1, ticket4), 0);
    }
}