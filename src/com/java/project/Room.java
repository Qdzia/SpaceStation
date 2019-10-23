package com.java.project;

public class Room {
	public int toStartPoint;
	public int toFinishPoint;
	public int value;
	public Room tail;
	int x,y,z;
	
	public Room(int x,int y,int z,Room tail) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.tail = tail;
		Calculate();
		
	}
	
	public Room(int inf) {
		this.x = inf;
		this.y = inf;
		this.z = inf;
		this.tail = null;
	}
	
	void DistanceTSP()
	{
		if(tail.toStartPoint == -1) toStartPoint =1;
		else toStartPoint = tail.toStartPoint +1;
	}
	
	public void Calculate()
	{
		if(tail!=null)
		{
			DistanceTSP();
			toFinishPoint = x+y+z-3;
			value = toFinishPoint + toStartPoint;
		}
		else System.out.println("Calculate! Tail not set");	
	}

}
