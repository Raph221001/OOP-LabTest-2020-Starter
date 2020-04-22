package ie.tudublin;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import java.util.ArrayList;

public class Gantt extends PApplet
{
	//ArrayList created
	ArrayList<Tasks> tasks = new ArrayList<Tasks>();

	public void settings() {
		size(800, 600);
	}

	//Loading tasks from csv file and stores in array
	public void loadTasks() {
		Table table = loadTable("tasks.csv", "header");
		for(TableRow row:table.rows()) {
			Tasks tr = new Tasks(row);
			tasks.add(tr);
		}
	}

	//Prints tasks
	public void printTasks() {
		for(Tasks tr:tasks)
		{
			println(tr);
		}
	}

	public void mousePressed() {
		println("Mouse pressed");
	}

	public void mouseDragged() {
		println("Mouse dragged");
	}



	public void setup() {

	}

	public void draw() {
		background(0);
	}
}

