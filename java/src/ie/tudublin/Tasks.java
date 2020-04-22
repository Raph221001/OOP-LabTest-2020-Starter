package ie.tudublin;

import processing.data.TableRow;

public class Tasks {
    private String Tasks;
    private int Starttime;
    private int Endtime;

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
    public Tasks(String tasks, int starttime, int endtime){
        this.Tasks = tasks;
        this.Starttime = starttime;
        this.Endtime = endtime;
    }
    public Tasks(TableRow tr){
        this(tr.getString("Task"), tr.getInt("Start"), tr.getInt("End"));
    }
}
