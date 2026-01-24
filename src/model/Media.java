package model;

public abstract class Media implements Playable {

    protected int id;
    protected String title;
    protected int duration;

    public Media(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    // getters,setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
    // abstract methods
    public abstract String getType();
    public abstract void play();

    //common method
    public void printInfo() {
        System.out.println(title + " (" + duration + " sec)");
    }
}
