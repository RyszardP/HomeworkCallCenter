package CallCenter;


import java.util.Random;
import java.util.concurrent.Semaphore;

public class Operator implements Runnable {
    public static int operators;
    public int operatorId;
    private static final boolean[] freeOperator = new boolean[operators];
    private static final Semaphore semaphore = new Semaphore(operators, true);

    public Operator(Turn turn, int i) {
    }


    @Override
    public void run() {
        try {
            semaphore.acquire();

            //Ищем свободное место
            synchronized (freeOperator) {
                for (int i = 0; i < operators; i++) {
                    if (!freeOperator[i]) {
                        freeOperator[i] = true;
                        operatorId = i;
                        System.out.println("Клиент " + getRandomName() + " обслуживается оператором номер " + i);
                        break;
                    }
                }
            }

            Thread.sleep(talkTime);
            synchronized (freeOperator) {
                if (operatorId != -1) {
                    freeOperator[operatorId] = false;
                } else {
                    System.out.println(operatorId);
                }
            }

            semaphore.release();
            System.out.println("Client " + getRandomName() + " is finish talk");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    Random rand = new Random();
    int talkTime = rand.nextInt(50) * 2000;


    private static String[] Beginning = {"Kr", "Ca", "Ra", "Mrok", "Cru",
            "Ray", "Bre", "Zed", "Drak", "Mor", "Jag", "Mer", "Jar", "Mjol",
            "Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro",
            "Mar", "Luk"};
    private static String[] Middle = {"air", "ir", "mi", "sor", "mee", "clo",
            "red", "cra", "ark", "arc", "miri", "lori", "cres", "mur", "zer",
            "marac", "zoir", "slamar", "salmar", "urak"};
    private static String[] End = {"d", "ed", "ark", "arc", "es", "er", "der",
            "tron", "med", "ure", "zur", "cred", "mur"};


    public String getRandomName() {
        Random rand = new Random();
        return Beginning[rand.nextInt(Beginning.length)] +
                Middle[rand.nextInt(Middle.length)] +
                End[rand.nextInt(End.length)];
    }

}