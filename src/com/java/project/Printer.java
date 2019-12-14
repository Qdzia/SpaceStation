package com.java.project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Printer {
	
	 private static Printer INSTANCE;
	
		private Printer() {
	    }
	
	    public static Printer getInstance() {
	        if(INSTANCE == null) {
	            INSTANCE = new Printer();
	        }
	        return INSTANCE;
	    }
    
	Grid grid = Grid.getInstance();
	public String currentRooms,checkedRooms,encounteredGates,gatesList;
	public List<String> filenames = new ArrayList<String>();

	public void Initialize()
	{
		currentRooms = "Current Rooms List: \n";
		checkedRooms = "Checked Rooms List: \n";
		encounteredGates = "Encountered Gates List: \n";
		gatesList = "Read Gates: \n";
		
	}
	public void WriteToFile(String fileName) throws IOException 
	{
		fileName = "Output_"+fileName;
		 FileWriter fileWriter = new FileWriter(fileName);
		 PrintWriter printWriter = new PrintWriter(fileWriter);
		 printWriter.println(gatesList);
		 printWriter.println(encounteredGates);
		 printWriter.println(currentRooms);
		 printWriter.println(checkedRooms);
		 printWriter.close();
	}
	
	public void Print() throws IOException
	{
		System.out.println(gatesList);
		System.out.println(encounteredGates);
		System.out.println(currentRooms); 	
		System.out.println(checkedRooms); 
		DrawPath();
		for(String el : filenames) System.out.println(el);
		
		WriteToFile(filenames.get(0));
		filenames.remove(0);
		
	}
	public void DrawPath(Room current)
	{
		String way="Shortes Path is: \n";
		//Room current = target;
		
		while(current.tail!=null)
		{	
			way += String.format("-> %d, %d, %d \n",current.vek.x,current.vek.y, current.vek.z);
			current = current.tail;
		}
		way += String.format("-> %d, %d, %d \n",grid.node.vek.x,grid.node.vek.y, grid.node.vek.z);
		
		System.out.println(way);
	}

	
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
		boolean[][][] ar= Grid.getInstance().grid;

    	for(int k=1;k<size-1;k+=2) {
    		for(int j=1;j<size-1;j+=2) {
    			for(int i =1;i<size-1;i+=2) {
    				if(ar[i][j][k]==true) System.out.print("0 "); 
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
		boolean[][][] ar= new boolean[gridSize][gridSize][gridSize];
		Room last = Grid.getInstance().target;
		
		if(last.tail == null) throw new IllegalArgumentException("Ÿle odczytano ostatni pokój");
		
		while(last.tail != null)
		{
			ar[last.vek.x-1][last.vek.y-1][last.vek.z-1]=true;
			last=last.tail;
		}
		for(int k=0;k<gridSize;k++) {
    		for(int j=0;j<gridSize;j++) {
    			for(int i =0;i<gridSize;i++) {
    				if(ar[i][j][k]==true) System.out.print("0 "); 
    				else System.out.print("# ");
    			
    			}
    			System.out.println("");
    		}
    		
    		System.out.println("===============================================[ "+ k + " ]====");
    	}
    	
    	System.out.println("");
		
	}
	

}

