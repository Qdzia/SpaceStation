package com.java.project;


public class PathFinder {

	
	public static void main(String[] args) {
	
		ReadFile r = new ReadFile();
		
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
			grid.DrawGrid();
			
		}

	}
}
		
