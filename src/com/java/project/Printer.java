package com.java.project;

public class Printer {

	public void DrawGrid()
	{	
		int size = Grid.getInstance().size;
		boolean[][][] grid= Grid.getInstance().grid;

    	for(int k=0;k<size;k++) {
    		for(int j=0;j<size;j++) {
    			for(int i =0;i<size;i++) {
    				if(grid[i][j][k]==true) System.out.print("  "); 
    				else System.out.print("# ");
    			
    			}
    			System.out.println("");
    		}
    		
    		System.out.println("===============================================[ "+ k + " ]====");
    	}
    	
    	System.out.println("");
		
	}
	
	public void DrawRooms()
	{	
		int size = Grid.getInstance().size;
		boolean[][][] grid= Grid.getInstance().grid;

    	for(int k=1;k<size-1;k+=2) {
    		for(int j=1;j<size-1;j+=2) {
    			for(int i =1;i<size-1;i+=2) {
    				if(grid[i][j][k]==true) System.out.print("0 "); 
    				else System.out.print("# ");
    			
    			}
    			System.out.println("");
    		}
    		
    		System.out.println("===============================================[ "+ k + " ]====");
    	}
    	
    	System.out.println("");
		
	}
	
	public void DrawPath()
	{	
		int gridSize = Grid.getInstance().gridSize;
		boolean[][][] grid= new boolean[gridSize][gridSize][gridSize];
		Room last = Grid.getInstance().target;
		
		if(last.tail == null) throw new IllegalArgumentException("Ÿle odczytano ostatni pokój");
		
		while(last.tail != null)
		{
			grid[last.vek.x-1][last.vek.y-1][last.vek.z-1]=true;
			last=last.tail;
		}
		for(int k=0;k<gridSize;k++) {
    		for(int j=0;j<gridSize;j++) {
    			for(int i =0;i<gridSize;i++) {
    				if(grid[i][j][k]==true) System.out.print("0 "); 
    				else System.out.print("# ");
    			
    			}
    			System.out.println("");
    		}
    		
    		System.out.println("===============================================[ "+ k + " ]====");
    	}
    	
    	System.out.println("");
		
	}
	
	
}
