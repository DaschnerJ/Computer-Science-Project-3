package Q2;

import java.util.ArrayList;

public class MyPriorityQueue
{
	
	private ArrayList<Integer>binMinHeap;
	
	public MyPriorityQueue( )
	{
		binMinHeap = new ArrayList<Integer>();
	}
	
	// Adds item to priority queue
	public void enqueue(Integer item){
		binMinHeap.add(item);
		bubbleUp(binMinHeap.size()-1);
	}
	
	// Removes and returns item in priority queue with smallestpriority
	public Integer dequeue(){
		if(!(binMinHeap.size() == 0))
		{
			Integer toReturn = binMinHeap.get(0);
			binMinHeap.remove(0);
			bubbleDown(1);
			return toReturn;
		}
		else 
			return null;
	}
	
	//Swaps the elements at index1 and index2 of the binary min heap
	private void swap(int index1, int index2)
	{
		int a = binMinHeap.get(index1);
		int b = binMinHeap.get(index2);
		binMinHeap.set(index1, b);
		binMinHeap.set(index2, a);
	}
	
	//Bubbles up the element in the binary min heap array list at given index
	private void bubbleUp (int index)
	{
		while(index-1 > -1 && binMinHeap.get(index) < binMinHeap.get(index-1))
		{
			swap(index, index-1);
			index = index-1;
		}
	}
	
	//Bubbles down the element in the binary min heap array list at given index
	private void bubbleDown (int index)
	{
		int n = binMinHeap.size();
		while(index * 2 < n && binMinHeap.get(index) >
		binMinHeap.get(index * 2)){
			swap(index, index * 2);
			index = index * 2;
		}
	}
	
}