package mk.finki.ukim.mk.lab.Service;

import mk.finki.ukim.mk.lab.model.TicketOrder;

public interface TicketOrderService {

    TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets);

}
