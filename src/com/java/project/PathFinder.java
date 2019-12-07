package com.java.project;

import java.util.LinkedList;

public class PathFinder {

	
	public static void main(String[] args) {
	
		ReadFile r = new ReadFile();
		Grid grid = Grid.getInstance();
		Seeker seeker = new Seeker();
		
		
		grid.CreateGrid();
		r.openFile();
		r.Read();
		r.CloseFile();
		
		seeker.SeekerLoop();
		
		
		
		//grid.DrawGrid();
		
		
	}
}
		
