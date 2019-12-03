package com.java.project;

import java.util.LinkedList;

public class Seeker {

	LinkedList<Room> open = new LinkedList<Room>();
	LinkedList<Room> close = new LinkedList<Room>();
	
	HeapSort ob = new HeapSort();
	Grid grid = Grid.getInstance();
	
	public void SeekerLoop()
	{
		//Vector table
		Vector3[] dir = new Vector3[6];
		
		dir[0]= new Vector3(1,0,0);
		dir[1]= new Vector3(0,1,0);
		dir[2]= new Vector3(-1,0,0);
		dir[3]= new Vector3(0,-1,0);
		dir[4]= new Vector3(0,0,-1);
		dir[5]= new Vector3(0,0,1);
		
		//Add node to open
		Room ini = new Room(3);
		Room node = new Room(3,5,1,ini);
		open.add(node);
		Room target = new Room(1,1,1,ini);
		
	//Main loop starts
		Room current = node;
		Vector3 pos;
		
		
		//security
		int petla = 0;    
	    boolean end = true;
	    
		while(end)
		{
			current = open.get(0); 
			open.remove(0);
			close.add(current);
			ob.sort(open);
		
			
	    	   
	    	//Checking neighbor fields
		    pos = current.vek;
		    	  
			for(int i = 0;i<6;i++) 
			{
				pos = pos.AddVector(pos, dir[i]);
						
				System.out.println("Position: " + current.vek.x + current.vek.y + current.vek.z);
						
				//Check is valid or is in close list
				if( !(isInList(pos,close) || grid.CheckBorders(current.vek,pos)) )
				{
					//check if in open list, if not create if yes checks shortest way
					if(isInList(pos,open))
					{
								int num = getRoomOfVec(pos);
								if(open.get(num).toStartPoint > current.toStartPoint+1) 
									open.get(num).tail = current;
					}
					else
					{
						open.add(new Room(pos.x,pos.y,pos.z,current));
						System.out.println("Dodano:   " + pos.x + pos.y + pos.z);
					}
				}
						
				pos = pos.SubVector(pos, dir[i]);
			}
				
				
					
			ob.sort(open);
			printArray(open);
			petla++;
		    if(petla > 20) end= false;
		    System.out.println("========================= " + petla);
			
		}

	       	
		System.out.println("End of Program");   	
	} 
				
			

	void printArray(LinkedList<Room> list) 
    { 
        int n = list.size(); 
        for (int i=0; i<n; ++i) 
            System.out.print(list.get(i).value+" "); 
        
        System.out.println();
        
        for (int i=0; i<n; ++i) 
            System.out.print(list.get(i).toFinishPoint+" "); 
        System.out.println();
    }
	
	boolean isInList(Vector3 vek, LinkedList<Room> list)
	{
		for (Room room : list) 
		{ 
		    if(room.vek.x == vek.x && room.vek.y == vek.y && room.vek.z == vek.z)
			    return true;
		}
		return false;
	}
	
	int getRoomOfVec(Vector3 vek)
	{
		Room room;
		for (int i=0;i<open.size();i++) 
		{ 
			room = open.get(i);
		    if(room.vek.x == vek.x && room.vek.y == vek.y && room.vek.z == vek.z)
			    return i;
		}
		return -1;
		
	}
}
