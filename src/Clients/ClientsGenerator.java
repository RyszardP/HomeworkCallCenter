package Clients;

import CallCenter.Turn;

import java.util.Random;

public class ClientsGenerator implements Runnable {

    private Turn turn;
    private int clientCount;

    public ClientsGenerator(Turn turn, int clientCount) {
        this.turn = turn;
        this.clientCount = clientCount;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < clientCount) {
            Thread.currentThread().setName(" Clients generator");
            count++;
            turn.add(new Clients(getRandomName()));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

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

