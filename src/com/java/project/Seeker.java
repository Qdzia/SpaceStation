package com.java.project;

import java.util.LinkedList;

public class Seeker {

	LinkedList<Room> open = new LinkedList<Room>();
	LinkedList<Room> close = new LinkedList<Room>();
	
	HeapSort ob = new HeapSort();
	Grid grid = Grid.getInstance();
	Vector3 cal = new Vector3(0,0,0);
	Path path = new Path();
	Printer printer = Printer.getInstance();
	int limitLoop = grid.gridSize*grid.gridSize*grid.gridSize;
	
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
		Room node = grid.node;
		grid.node = node;
		open.add(node);
		Vector3 targetVek = grid.targetVek;
		
		
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
			//grid.AddRoom(current.vek);
			
	    	   
	    	//Checking neighbor fields
			pos = new Vector3(0,0,0);
		    pos = pos.EqlVector(pos,  current.vek);
		    
		    printer.currentRooms += String.format("-> %d, %d, %d \n",current.vek.x,current.vek.y, current.vek.z);
		    
			for(int i = 0;i<6;i++) 
			{
				pos = cal.AddVector(pos, dir[i]);
						
				//Check is valid or is in close list
				if( grid.CheckBorders(current.vek,pos) && grid.isRoom(pos) )
				{
					//check if in open list, if not create if yes checks shortest way
					if(isInList(pos,open))
					{			
								int num = getRoomOfVec(pos);
								if(open.get(num).s_cost > current.s_cost+1) 
									open.get(num).tail = current;
					}
					else
					{
						open.add(new Room(pos.x,pos.y,pos.z,current));
					}
				}		
				pos = cal.SubVector(pos, dir[i]);
			}
				
				
			if(current.vek.x == targetVek.x && current.vek.y == targetVek.y && current.vek.z == targetVek.z)
			{
				grid.target = current;
				printer.DrawPath(current);
				end= false;
			}		
			ob.sort(open);
			petla++;
		    if(petla > limitLoop) end= false;
		}
		
		try {
		printer.Print();
		}catch(Exception e) {
			System.out.println("Nie uda³o siê zapisaæ do pliku" + e);
		}
		
		System.out.println("End of Program\n");   	
	} 
				
			

	void printArray(LinkedList<Room> list) 
    { 
        int n = list.size(); 
        for (int i=0; i<n; ++i) 
            System.out.print(list.get(i).value+" "); 
        
        System.out.println();
        
        for (int i=0; i<n; ++i) 
            System.out.print(list.get(i).e_cost+"  "); 
        System.out.println();
    }
	
	boolean isInList(Vector3 vek, LinkedList<Room> list)
	{
		for (Room room : list) 
		{ 
		    if(room.vek.x == vek.x && room.vek.y == vek.y && room.vek.z == vek.z)
			    return true;
		}
		printer.checkedRooms += String.format("-> %d, %d, %d \n", vek.x,vek.y,vek.z);
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
