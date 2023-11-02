package mk.finki.ukim.mk.lab.Repository;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.model.TicketOrder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketOrderRepository {
    public static List<TicketOrder> ticketorders = new ArrayList<>();

    @PostConstruct
    public void init ()
    {
        Long tempticketnumber = 4L;

        TicketOrder order = new TicketOrder("Inception", "Petre Petrevski", "0:0:0:0:1", tempticketnumber);
        ticketorders.add(order);
        tempticketnumber = 5L;
        TicketOrder order1 = new TicketOrder("Pulp Fiction", "Petre Mitrevski", "0:0:0:0:2", tempticketnumber);
        ticketorders.add(order);
        tempticketnumber = 10L;
        TicketOrder order2 = new TicketOrder("Inception", "Petre Petrevski", "0:0:0:0:3", tempticketnumber);
        ticketorders.add(order);
    }

    public List<TicketOrder> findAllTickets()
    {
        return ticketorders;
    }

    public List<TicketOrder> HighestTicketNum()
    {
        return ticketorders;
    }
}
