package com.java.project;

import java.util.LinkedList;

public class PathFinder {

	
	public static void main(String[] args) {
	
		int size = 5;
		Room current;
		Vector3 pos;
		Vector3 cor;
		boolean end = true;
		
		Vector3[] dir = new Vector3[6];
		
		dir[0]= new Vector3(1,0,0);
		dir[1]= new Vector3(0,1,0);
		dir[2]= new Vector3(0,0,1);
		dir[3]= new Vector3(-1,0,0);
		dir[4]= new Vector3(0,-1,0);
		dir[5]= new Vector3(0,0,-1);
		
		
		Room[][][] ar = new Room[size][size][size];
		LinkedList<Room> list = new LinkedList<Room>();
		
		ar[3][3][3] = new Room(3);
		list.add(ar[3][3][3]);
		
		/*list.add(new Room(2));
		list.add(new Room(5));
		list.add(new Room(1));
		list.add(new Room(1));
		list.add(new Room(4));*/
		
		current = ar[3][3][3];
		
		
		int petla = 0;
        HeapSort ob = new HeapSort(); 

	while(end)
	{
       if(current.toFinishPoint != 0)
		{
    	   current = list.get(0);
    	   pos = current.vek;
    	   //System.out.println("Wybra³em: " + current.vek.x + current.vek.y + current.vek.z );
    	   
    	   
			for(int i = 0;i<6;i++) 
			{
				cor = new Vector3(pos.x+ dir[i].x,pos.y+ dir[i].y,pos.z+ dir[i].z);
				
				if(ar[cor.x][cor.y][cor.z]!=null)
				{
					//System.out.println("Exsist");
					if(current.toStartPoint +1 <ar[cor.x][cor.y][cor.z].toStartPoint)
					{
						ar[cor.x][cor.y][cor.z].tail = current;
						ar[cor.x][cor.y][cor.z].Calculate();
						//System.out.println("Calculate agian");
					}
					
				}
				else
				{
					ar[cor.x][cor.y][cor.z] = new Room(cor.x,cor.y,cor.z,current);
					//System.out.println("new room: " +cor.x +cor.y + cor.z + " Value: " 
					//+ ar[cor.x][cor.y][cor.z].value );
					System.out.println("new room: " +cor.x +cor.y + cor.z + " to start: " 
					+ ar[cor.x][cor.y][cor.z].toFinishPoint );
					
					list.add(ar[cor.x][cor.y][cor.z]);
				}
			}
			
			
			ob.sort(list);
		    //printArray(list);
			
			
		}
		else end= false;
		
       petla++;
       if(petla > 15) end= false;
	} 
			System.out.println("I got it!");
		
	}
	
	static void printArray(LinkedList<Room> list) 
    { 
        int n = list.size(); 
        for (int i=0; i<n; ++i) 
            System.out.print(list.get(i).value+" "); 
        System.out.println(); 
    }

}
