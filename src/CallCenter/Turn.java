package CallCenter;

import Clients.Clients;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.currentThread;

public class Turn {
    private List<Clients> reserve;
    private static final int maxClients = 50;
    private static final int minClients = 0;
    private int clientsCounter = 0;


    public Turn() {
        reserve = new ArrayList<>();
    }
    public synchronized boolean add(Clients person) {

        try {
            if (clientsCounter < maxClients) {
                notifyAll();
                reserve.add(person);
                String info = String.format("Client in the turn: ", currentThread().getName());
                System.out.println(info);
                clientsCounter++;

            } else {
                System.out.println("Turn is full: " + currentThread().getName());
                wait();
                return false;
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public synchronized Clients get(int clientInt) {
        try {
            if (clientsCounter > minClients) {
                notifyAll();
                for (Clients clients : reserve) {
                    if (clients.getCount() == clientInt) {
                        clientsCounter--;
                        System.out.println("- The client is taken from the turn: " + currentThread().getName());
                        reserve.remove(clients);
                        return clients;
                    }
                }
            }

            System.out.println("0 < There are no clients in the turn");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

