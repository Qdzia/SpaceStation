package com.java.project;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
	public String currentRooms,checkedRooms,encounteredGates,gatesList,pathImage,path,raport;
	public List<String> filenames = new ArrayList<String>();
	String line;
	

	public void Initialize()
	{
		line = "==";
		line = line.repeat(grid.gridSize);
		path="1.Shortest Path is: \n";
		currentRooms = "2.Current Rooms List: \n";
		checkedRooms = "3.Checked Rooms List: \n";
		gatesList = "4.Readed Gates: \n";
		encounteredGates = "5.Encountered Gates List: \n";
		pathImage = "6.Image of Path: \n";
		
	}
	
	public void WriteToFile(String fileName) throws IOException 
	{
		fileName = "Output_"+fileName;
		 FileWriter fileWriter = new FileWriter(fileName);
		 PrintWriter printWriter = new PrintWriter(fileWriter);
		 printWriter.println(raport);
		 printWriter.close();
	}
	
	public void Print() throws IOException
	{	
		DrawPath();
		raport = String.format("%s\n%s\n%s\n%s\n%s\n%s\n",path,currentRooms,checkedRooms,gatesList,encounteredGates,pathImage);
		System.out.println(raport);
		WriteToFile(filenames.get(0));
		filenames.remove(0);
		
	}
	
	public void DrawPath(Room current)
	{
		while(current.tail!=null)
		{	
			path += String.format("-> %d, %d, %d \n",current.vek.x,current.vek.y, current.vek.z);
			current = current.tail;
		}
		path += String.format("-> %d, %d, %d \n",grid.node.vek.x,grid.node.vek.y, grid.node.vek.z);
		
	}
	
	public void DrawGrid()
	{	
		int size = grid.size;
		boolean[][][] ar= Grid.getInstance().grid;

		PrintArray(0,size,1,ar,line);
	}
	
	public void DrawRooms()
	{	
		int size = grid.size;
		boolean[][][] ar= Grid.getInstance().grid;

		PrintArray(1,size,2,ar,line);
		
	}
	
	public void DrawPath()
	{	
		int gridSize = grid.gridSize;
		boolean[][][] ar= new boolean[gridSize][gridSize][gridSize];
		Room last = grid.target;
		
		if(last.tail == null) throw new IllegalArgumentException("Unable to read tail");
		
		for(int k=0;k<gridSize;k++) {
    		for(int j=0;j<gridSize;j++) {
    			Arrays.fill(ar[k][j], true);
    		}
		}
		
		while(last.tail != null)
		{
			ar[last.vek.x-1][last.vek.y-1][last.vek.z-1]=false;
			last=last.tail;
		}
		
		PrintArray(0,gridSize,1,ar,line);
		
	}
	
	void PrintArray(int ini,int n,int hop,boolean[][][] ar,String line)
	{
		
		for(int k=ini;k<n;k+=hop) {
    		for(int j=ini;j<n;j+=hop) {
    			for(int i =ini;i<n;i+=hop) {
    				if(ar[i][j][k]==true) pathImage += "  "; 
    				else pathImage += "# ";
    			}
    			pathImage += "\n";
    		}
    		
    		pathImage += line;
    		pathImage += "==[ "+ k + " ]==\n";
    	}
		pathImage += "\n";
	}
	

}

