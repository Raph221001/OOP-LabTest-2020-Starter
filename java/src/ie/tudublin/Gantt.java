package ie.tudublin;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import java.util.ArrayList;

public class Gantt extends PApplet
{
	//ArrayList created
	ArrayList<Tasks> tasks = new ArrayList<Tasks>();

	private float leftEdge;
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
		//creating variables
		float lines;
		int Days = 30;
		float y;
		float rectHeight = 30;
		float rectStart;
		float rectEnd;
		float rectWidth;
		float colour;
		colorMode(HSB);

		fill(255);
		stroke(255);

		textAlign(CENTER, CENTER);

		//Lines and numbers drawn
		for (int i = 1; i <= Days; i++) {
			lines = map(i, 1, Days, 30, width);
			text(i, lines, height - 540);
			line(lines, 100, lines, height - 50);
		}

		//places text to left
		textAlign(LEFT, CENTER);

		//Displaying tasks
		for (int i = 0; i < tasks.size(); i++){
			fill(255);
			y = map(i, 0, tasks.size(), 2 * margin, height - margin);
			text(tasks.get(i).getTasks(), margin, y);
			noStroke();
			colour = map(i, 0, tasks.size(), 0, 255);
			fill(colour, 255, 255);

			//rectangles are drawn
			rectStart = map(tasks.get(i).getStart(), 1, 30, leftEdge, width - margin);
			rectEnd = map(tasks.get(i).getEndtime(), 1, 30, leftEdge, width - margin);
			rectWidth = rectEnd - rectStart;

			rect(rectStart, y - rectHeight / 2, rectWidth, rectHeight);
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
		leftEdge = width / 4;
		margin = width / 10;
	}

	public void draw() {
		background(0);
		displayTasks();
	}

	public static void main (String...args){
		PApplet.main("ie.tudublin.Gantt");
	}
}

