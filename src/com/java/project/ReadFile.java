package com.java.project;

import java.io.*;
import java.util.*;

public class ReadFile {

	Scanner x;
	Grid grid = Grid.getInstance();
	
	public void openFile()
	{
		try {
			x = new Scanner(new File("D:\\Documents\\EclipseWorkspace\\SpaceStation\\src\\com\\java\\project\\DoorList.txt"));
		}
		catch(Exception e) {
			System.out.println("file not found");
		}
	}
	
	public void Read() 
	{
		ConvertData converter = new ConvertData();
		
		while(x.hasNext()) 
		{
			String a = x.next();
			String b = x.next();
			
			Vector3 v1 = converter.CheckPattern(a);
			Vector3 v2 = converter.CheckPattern(b);
			
			grid.CloseGate(v1,v2);
			System.out.println("v1: " + v1.x + v1.y + v1.z + " v2: " + v2.x + v2.y + v2.z);
		}
		
	}
	
	public void CloseFile()
	{
		x.close();
	}
}
