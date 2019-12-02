package com.java.project;

public class Vector3 {
	
	public int x ,y, z;
	
	
	Vector3(int x,int y,int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	
	int Sum()
	{
		return x+y+z;
	}
	
	boolean CheckBorders(Vector3 vek,int size)
	{
		
		if(vek.x <0 || vek.x>size) return false;
		if(vek.y <0 || vek.y>size) return false;
		if(vek.z <0 || vek.z>size) return false;
		return true;
	}
	
	Vector3 AddVector(Vector3 first, Vector3 second)
	{
		Vector3 sum = new Vector3(0,0,0);
		sum.x = first.x + second.x;
		sum.y = first.y + second.y;
		sum.z = first.z + second.z;
		return sum;
		
	}
	
	Vector3 EqlVector(Vector3 first, Vector3 second)
	{
		first.x = second.x;
		first.y = second.y;
		first.z =  second.z;
		return first;
		
	}
	
	Vector3 SubVector(Vector3 first, Vector3 second)
	{
		Vector3 div = new Vector3(0,0,0);
		div.x = first.x - second.x;
		div.y = first.y - second.y;
		div.z = first.z - second.z;
		return div;
		
	}
	
	void Multiply(int n)
	{
		x *=n;
		y *=n;
		z *=n;
	}
	
	void Divide(int n)
	{
		x /=n;
		y /=n;
		z /=n;
	}
	
	void Minus(int n)
	{
		x -=n;
		y -=n;
		z -=n;
	}
	
	void Plus(int n)
	{
		x +=n;
		y +=n;
		z +=n;
	}

}
