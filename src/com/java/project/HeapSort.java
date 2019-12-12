package com.java.project;

import java.util.LinkedList;

public class HeapSort {

	 public void sort(LinkedList<Room> list) 
	    { 
	    
	        int n = list.size(); 
	  
	        // Build heap (rearrange array) 
	        for (int i = n / 2 - 1; i >= 0; i--) 
	            heapify(list, n, i); 
	  
	        // One by one extract an element from heap 
	        for (int i=n-1; i>=0; i--) 
	        { 
	            // Move current root to end
	        	Room temp = list.get(0);
	            list.set(0,list.get(i));
	            list.set(i, temp);
	  
	            // call max heapify on the reduced heap 
	            heapify(list, i, 0); 
	        } 
	    } 
	  
	    // To heapify a subtree rooted with node i which is 
	    // an index in arr[]. n is size of heap 
	    void heapify(LinkedList<Room> list, int n, int i) 
	    { 
	    	
	        int largest = i;  // Initialize largest as root 
	        int l = 2*i + 1;  // left = 2*i + 1 
	        int r = 2*i + 2;  // right = 2*i + 2 
	        
	        // If left child is larger than root 
	        if (l < n && (list.get(l).value > list.get(largest).value 
	        		|| list.get(l).value == list.get(largest).value &&  list.get(l).e_cost > list.get(largest).e_cost))
	            largest = l; 
	      
	        // If right child is larger than largest so far 
		        if (r < n && (list.get(r).value > list.get(largest).value 
		        		|| list.get(r).value == list.get(largest).value && list.get(r).e_cost > list.get(largest).e_cost))
		            largest = r; 
	        
	        // If largest is not root 
	        if (largest != i) 
	        { 
	            Room swap = list.get(i);
	            list.set(i,list.get(largest));
	            list.set(largest, swap);
	            
	            // Recursively heapify the affected sub-tree 
	            heapify(list, n, largest); 
	        } 
	    }
}   
	 