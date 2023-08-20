package org.example;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int d1 = t1.getTimeTo() - t1.getTimeFrom();
        int d2 = t2.getTimeTo() - t2.getTimeFrom();

        if (d1 < d2) {
            return -1;
        } else if (d1 > d2) {
            return 1;
        } else {
            return 0;
        }
    }
}
