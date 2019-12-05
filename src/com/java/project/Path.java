package com.java.project;

public class Path {

	Grid grid = Grid.getInstance();
	Room node = grid.node;
	Room target = grid.target;
	
	public void GeneratePath()
	{
		boolean end = true;
		int petla = 0;
		String way="";
		Room current = target;
		
		while(end)
		{
			System.out.println(current.vek.x + current.vek.y + current.vek.z + "##");
			way += Integer.toString(current.vek.x);
			way += Integer.toString(current.vek.y);
			way += Integer.toString(current.vek.z);
			way += "->";
			
			
			
			petla++;
			if(current.vek.x == node.vek.x && current.vek.y == node.vek.y && current.vek.z == node.vek.z) end= false;
			if(petla>20) end = false;
			
			
			current = current.tail;
		}
		System.out.println(way);
	}
}
