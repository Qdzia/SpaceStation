package com.java.project;

import java.util.LinkedList;

public class PathFinder {

	
	public static void main(String[] args) {
	
		ReadFile r = new ReadFile();
		Room current;
		Vector3 pos;
		boolean end = true;
		
		Vector3[] dir = new Vector3[6];
		
		dir[0]= new Vector3(1,0,0);
		dir[1]= new Vector3(0,1,0);
		dir[2]= new Vector3(-1,0,0);
		dir[3]= new Vector3(0,-1,0);
		dir[4]= new Vector3(0,0,-1);
		dir[5]= new Vector3(0,0,1);
	
		LinkedList<Room> open = new LinkedList<Room>();
		LinkedList<Room> close = new LinkedList<Room>();
		
		Room ini = new Room(3);
		Room node = new Room(3,5,1,ini);
		node.isNode = true;
		current = node;
		open.add(node);

		r.openFile();
		r.Read();
		r.CloseFile();
		
		int petla = 0;
        HeapSort ob = new HeapSort(); 
        end = false;
	while(end)
	{
	//Checking the shortest way
       if(open.get(0).vek.Sum() > 0)
		{
    	  //Getting rid of evaluated arguments 
    	   do {
    		   if(open.get(0).evaluated) 
    		   {
        		   close.add(current);
        		   open.remove(0);
        		   ob.sort(open);
        	   }
        	   
    		   current = open.get(0);
    		   
    		   
           	} while (current.evaluated);
    	   
    	   current.evaluated = true;
    	   System.out.println("current: " + current.vek.x + current.vek.y + current.vek.z);
    	   
    	   //Checking neighbor fields
    	   	pos = current.vek;
    	  
			for(int i = 0;i<6;i++) 
			{
				pos = pos.AddVector(pos, dir[i]);
				
				System.out.println("Position: " + current.vek.x + current.vek.y + current.vek.z);
				
				if(pos.CheckBorders(pos, 10)) 
				{
					open.add(new Room(pos.x,pos.y,pos.z,current));
					System.out.println("Dodano:   " + pos.x + pos.y + pos.z);
					
				}
				
				pos = pos.SubVector(pos, dir[i]);
			}
			
			
				
			ob.sort(open);
			printArray(open);
		
		}
       	else
       	{
    	   end=false;
    	   System.out.println("Got it");
       	}
       
       //Security
       	petla++;
       	if(petla > 20) end= false;
       	
       	System.out.println("========================= " + petla);
	} 
			
		System.out.println("End of Program");
		
//end main		
}
	
//Printing a list
	static void printArray(LinkedList<Room> list) 
    { 
        int n = list.size(); 
        for (int i=0; i<n; ++i) 
            System.out.print(list.get(i).value+" "); 
        
        System.out.println();
        
        for (int i=0; i<n; ++i) 
            System.out.print(list.get(i).toFinishPoint+" "); 
        System.out.println();
    }
	

//end class
}

