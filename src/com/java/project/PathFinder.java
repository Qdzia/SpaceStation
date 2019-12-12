package com.java.project;


public class PathFinder {

	
	public static void main(String[] args) {
	
		ReadFile r = new ReadFile();
		Printer printer = new Printer();
		
		r.LoadFile();
		
		for (String path : r.gates) 
		{
			Grid grid = Grid.getInstance();
			Seeker seeker = new Seeker();
			
			grid.CreateGrid();
			r.openFile(path);
			r.Read();
			r.CloseFile();
			
			seeker.SeekerLoop();
			printer.DrawPath();
			
		}

	}
}
		
