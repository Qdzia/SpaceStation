package com.java.project;

public class Cell {

	public boolean isRoom = false;
	public boolean isClose = false;
	
	public boolean closedDoor[]  = new boolean[6];
	
	public Cell(int k )
	{
		for(int i = 0;i<6;i++) 
			closedDoor[i] =true;
		
		closedDoor[k] =false;
		isRoom = false;
		isClose = true;
	}
	
	public Cell(boolean isRoom)
	{
		for(int i = 0;i<6;i++) 
			closedDoor[i] =true;
		
		isRoom = true;
		isClose = false;
	}
	
	public void CloseDoor(int i)
	{
		closedDoor[i] = false;
	}
}
