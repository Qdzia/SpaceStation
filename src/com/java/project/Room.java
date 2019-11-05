package com.java.project;

public class Room {
	public int toStartPoint;
	public int toFinishPoint;
	public int value;
	public Room tail;
	public Vector3 vek;
	public boolean evaluated;
	public boolean isNode;
	
	public Room(int x,int y,int z,Room tail) {
		this.vek = new Vector3(x,y,z);
		this.tail = tail;
		this.evaluated = false;
		Calculate();
		
	}
	
	public Room(int inf) {
		this.vek = new Vector3(inf,inf,inf);
		this.tail = null;
		this.toStartPoint = 0;
		this.toFinishPoint = vek.Sum();
		this.evaluated = false;
		this.value = 100;
	}
	
	void DistanceTSP()
	{
		if(tail.toStartPoint == -1) toStartPoint =1;
		else toStartPoint = tail.toStartPoint +1;
	}
	
	public void Calculate()
	{
		if(tail!=null) DistanceTSP();
		else System.out.println("Calculate! Tail not set");	
		
		toFinishPoint = vek.Sum();
		value = toFinishPoint;
	}
	
}
