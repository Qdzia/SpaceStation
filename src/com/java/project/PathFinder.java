package com.java.project;

import java.util.LinkedList;

public class PathFinder {

	
	public static void main(String[] args) {
	
		int size = 5;
		Room current;
		Vector3 pos;
		Vector3 cor;
		
		Vector3[] dir = new Vector3[6];
		
		dir[0]= new Vector3(1,0,0);
		dir[1]= new Vector3(0,1,0);
		dir[2]= new Vector3(0,0,1);
		dir[3]= new Vector3(-1,0,0);
		dir[4]= new Vector3(0,-1,0);
		dir[5]= new Vector3(0,0,-1);
		
		
		Room[][][] ar = new Room[size][size][size];
		
		
		ar[0][0][0] = new Room(0);
		
		ar[3][3][3] = new Room(3,3,3,null);
		
		
		LinkedList<Room> list = new LinkedList<Room>();
		
		list.add(new Room(2));
		list.add(new Room(5));
		list.add(new Room(1));
		list.add(new Room(1));
		list.add(new Room(4));
		
		current = ar[3][3][3];
		
		pos = current.vek;
		
		//list.set(0,list.get(2));
		
		//int arr[] = {12, 11, 13, 6, 6, 7}; 
        
  
        HeapSort ob = new HeapSort(); 
        ob.sort(list); 
  
        //System.out.println("Sorted array is"); 
       printArray(list);
		
		/*
		if(current.toFinishPoint != 0)
		{
			for(int i = 0;i<6;i++) 
			{
				cor = new Vector3(pos.x+ dir[i].x,pos.y+ dir[i].y,pos.z+ dir[i].z);
				if(ar[cor.x][cor.y][cor.z]!=null)
				{
					if(current.value +1 <ar[cor.x][cor.y][cor.z].value)
					{
						ar[cor.x][cor.y][cor.z].tail = current;
						ar[cor.x][cor.y][cor.z].Calculate();
					}
					
				}
				else
				{
					ar[cor.x][cor.y][cor.z] = new Room(cor.x,cor.y,cor.z,current);
					
				}
			}
			
		}
		else System.out.println("I got it!");
		*/
		
	}
	
	static void printArray(LinkedList<Room> list) 
    { 
        int n = list.size(); 
        for (int i=0; i<n; ++i) 
            System.out.print(list.get(i).value+" "); 
        System.out.println(); 
    }

}
