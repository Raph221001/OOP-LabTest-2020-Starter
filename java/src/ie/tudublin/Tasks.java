package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

//Create public class called task
public class Tasks {
    //Creating variables
    private String Tasks;
    private int Starttime;
    private int Endtime;

    //Use Getter and Setter for variables
    public String getTasks() {
        return Tasks;
    }

    public void setTask(String tasks) {
        Tasks = tasks;
    }

    public int getStart() {
        return Starttime;
    }

    public void setStart(int starttime) {
        Starttime = starttime;
    }

    public int getEndtime() {
        return Endtime;
    }

    public void setEnd(int endtime) {
        Endtime = endtime;
    }

    //Task Constructor with parameters
    public Tasks(String tasks, int starttime, int endtime){
        this.Tasks = tasks;
        this.Starttime = starttime;
        this.Endtime = endtime;
    }
    public Tasks(TableRow tr){
        this(tr.getString("Task"), tr.getInt("Start"), tr.getInt("End"));
    }

    public static void main (String...args){
        PApplet.main("ie.tudublin.Tasks");
    }
}
