package com.java.project;

public class Room {
	
	public int s_cost;
	public int e_cost;
	public int value;
	public Room tail;
	public Vector3 vek;
	
	
	public Room(int x,int y,int z,Room tail) {
		this.vek = new Vector3(x,y,z);
		this.tail = tail;
		Calculate();
		Grid.getInstance().grid[x*2-1][y*2-1][z*2-1]= false;
		
	}
	
	public Room(int x,int y,int z) {
		this.vek = new Vector3(x,y,z);
		this.tail = null;
		this.s_cost = 0;
		this.e_cost = 0;
		this.value = 100;
		Grid.getInstance().grid[x*2-1][y*2-1][z*2-1]= false;
	}
	
	void DistanceTSP()
	{
		if(tail.s_cost == -1) s_cost =1;
		else s_cost = tail.s_cost +1;
	}
	
	void DistanceTFP()
	{	Vector3 tar = Grid.getInstance().targetVek;
		e_cost = 0;
		e_cost += Math.abs(tar.x-vek.x);
		e_cost += Math.abs(tar.y-vek.y);
		e_cost += Math.abs(tar.z-vek.z);
	}
	
	public void Calculate()
	{
		if(tail!=null) DistanceTSP();
		else System.out.println("Calculate! Tail not set");	
		
		DistanceTFP();
		value = e_cost + s_cost;
	}
	
}
