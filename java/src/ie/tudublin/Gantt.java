package ie.tudublin;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import java.util.ArrayList;

public class Gantt extends PApplet
{
	//ArrayList created
	ArrayList<Tasks> tasks = new ArrayList<Tasks>();

	private float leftGap;
	private float margin;

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

	public void displayTasks() {
		float lines;
		int Days = 30;
		float y;
		float rectHeight = 30;
		float rectStart;
		float rectEnd;
		float rectWidth;
		float border = width * 0.05f;
		colorMode(HSB);

		fill(255);
		stroke(255);

		textAlign(CENTER, CENTER);

		for (int i = 1; i <= Days; i++) {
			lines = map(i, 0, Days, 30, width);
			text(i, lines,height - 540);
			line(lines, 100, lines, height - 50);
		}

		textAlign(LEFT, CENTER);
		float radius = 3;

		for (int i = 0; i < tasks.size(); i++){
			Tasks words = tasks.get(i);
			y = map(tasks.get(i).getStart(), 0, 30, border, width - border);
			text(words.getTasks(), border/2, y );

			rectStart = map(tasks.get(i).getStart(), 1, 30, leftGap, width - margin);
			rectEnd = map(tasks.get(i).getEndtime(), 1, 30, leftGap, width - margin);
			rectWidth = rectEnd - rectStart;
			rect(rectStart, y - rectHeight / 2, rectWidth, rectHeight, radius);
		}
	}

	public void mousePressed() {
		println("Mouse pressed");
	}

	public void mouseDragged() {
		println("Mouse dragged");
	}



	public void setup() {
		loadTasks();
		printTasks();
	}

	public void draw() {
		background(0);
		displayTasks();
	}

	public static void main (String...args){
		PApplet.main("ie.tudublin.Gantt");
	}
}

