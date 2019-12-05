package com.java.project;

import java.util.LinkedList;

public class Seeker {

	LinkedList<Room> open = new LinkedList<Room>();
	LinkedList<Room> close = new LinkedList<Room>();
	
	HeapSort ob = new HeapSort();
	Grid grid = Grid.getInstance();
	Vector3 cal = new Vector3(0,0,0);
	
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
		Room node = new Room(3,3,3,ini);
		grid.node = node;
		open.add(node);
		Room target = new Room(1,1,1,ini);
		grid.target = target;
		
	//Main loop starts
		Room current = node;
		Vector3 pos;
		
		grid.grid[1][1][4] = false;
		grid.grid[1][2][3] = false;
		
		//security
		int petla = 0;    
	    boolean end = true;
	    
		while(end)
		{
			current = open.get(0); 
			open.remove(0);
			close.add(current);
			ob.sort(open);
			grid.AddRoom(current.vek);
			
	    	   
	    	//Checking neighbor fields
			pos = new Vector3(0,0,0);
		    pos = pos.EqlVector(pos,  current.vek);
		    
		    System.out.println("current: " + current.vek.x + current.vek.y + current.vek.z);
		    
			for(int i = 0;i<6;i++) 
			{
				pos = cal.AddVector(pos, dir[i]);
				
				System.out.println("Position: " + pos.x + pos.y + pos.z);
						
				//Check is valid or is in close list
				if( grid.CheckBorders(current.vek,pos) && grid.isRoom(pos) )
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
				pos = cal.SubVector(pos, dir[i]);
			}
				
				
			if(current.vek.x == target.vek.x && current.vek.y == target.vek.y && current.vek.z == target.vek.z)
			{
				System.out.println("current: " + current.vek.x + current.vek.y + current.vek.z);
				grid.target = current;
				end= false;
			}		
			ob.sort(open);
			printArray(open);
			petla++;
		    if(petla > 27) end= false;
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
            System.out.print(list.get(i).toFinishPoint+"  "); 
        System.out.println();
    }
	
	boolean isInList(Vector3 vek, LinkedList<Room> list)
	{
		for (Room room : list) 
		{ 
		    if(room.vek.x == vek.x && room.vek.y == vek.y && room.vek.z == vek.z)
			    return true;
		}
		System.out.println("Not in list");
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
