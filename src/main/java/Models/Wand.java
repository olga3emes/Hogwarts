package Models;

public class Wand {

    private  int id;
    private String wood, core;
    private double length;

    public Wand(){}

    public Wand( String wood, String core, double length) {
        this.id = id;
        this.core = core;
        this.wood = wood;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWood() {
        return wood;
    }

    public void setWood(String wood) {
        this.wood = wood;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }


    public String toString() {
        return "Wand[" +
                "id=" + id +
                ", wood='" + wood + '\'' +
                ", core='" + core + '\'' +
                ", length=" + length +
                ']';
    }
}
