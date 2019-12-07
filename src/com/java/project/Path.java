package com.java.project;

public class Path {

	Grid grid = Grid.getInstance();
	Room node = grid.node;
	Room target = grid.target;
	
	public void GeneratePath(Room current)
	{
		String way="";
		//Room current = target;
		
		while(current.tail!=null)
		{	
			way += "->";
			way += Integer.toString(current.vek.x);
			way += Integer.toString(current.vek.y);
			way += Integer.toString(current.vek.z);
		
			current = current.tail;
		}
		System.out.println(way);
	}
}
