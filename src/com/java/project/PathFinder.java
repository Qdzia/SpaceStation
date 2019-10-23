package com.java.project;

public class PathFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 5;
		Room current;
		
		Room[][][] ar = new Room[size][size][size];
		
		
		ar[0][0][0] = new Room(0);
		
		ar[4][0][0] = new Room(-1);
		
		
		
		current = ar[4][0][0];
		
		for(int i =4;i>=0;i--)
		{
			System.out.print(current.x);
			if(current.x == 4) break;
			ar[i][0][0] = new Room(i,0,0,current);
			current = ar[i][0][0];
			
			
		}
		
	}
		
	

}
