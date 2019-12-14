package com.java.project;


public class PathFinder {

	
	public static void main(String[] args) {
	
		ReadFile r = new ReadFile();
		Grid grid = Grid.getInstance();
		Printer printer = Printer.getInstance();
		
		
		r.LoadFile();
		
		for (String path : r.gates) 
		{
			
			Seeker seeker = new Seeker();
			printer.Initialize();
			
			grid.CreateGrid();
			r.openFile(path);
			r.Read();
			r.CloseFile();
			
			seeker.SeekerLoop();
			
			
		}

	}
}
		
