import CallCenter.Operator;
import CallCenter.Turn;
import Clients.ClientsGenerator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Available number of operators " + Runtime.getRuntime().availableProcessors());

        Turn turn = new Turn();


        ClientsGenerator clientsGenerator = new ClientsGenerator(turn, 10);

        Operator operator1 = new Operator(turn, 2);


        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(clientsGenerator);
        service.execute(operator1);


        service.shutdown();
    }
}

