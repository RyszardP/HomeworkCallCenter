package Clients;

public class Clients {
    private String name;
    private String id;
    private int count;



    public Clients(String getRandomName) {
    }

    public boolean countCheck() {
        if (count >= id.length()) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public Clients(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void add(int count) {
        this.count += count;
    }
}
