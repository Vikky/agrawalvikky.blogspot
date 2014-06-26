package SortingTechniques;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author vikky.agrawal
 * 
 */
public class HeapSort {

	int arr[] = new int[] { 3, 43, 4, 65, 23, 87, 2, 11, 33, 99, 25};
	
	ArrayList<Integer> array=new ArrayList<Integer>();
	
	
	HeapSort(){
		for(int i=0;i<10;i++){
			array.add(((int)(Math.random()*100)));
		}
		
		System.out.println("array before :");
		Iterator<Integer> itr=array.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next()+" ");
		}
	}
	
	

	public int getLeft(int index) {
		if ((index * 2) + 1 < array.size()) {
			return (index * 2) + 1;
		} else {
			return -1;
		}
	}

	public int getRight(int index) {
		if ((index * 2) + 2 < array.size()) {
			return (index * 2) + 2;
		} else {
			return -1;
		}
	}

	public int getParent(int index) {
		if (index < array.size()) {
			if (index % 2 == 0) {
				return (index / 2) - 1;
			} else {
				return index / 2;
			}
		} else
			return -1;
	}

	public ArrayList<Integer> heapify(ArrayList<Integer> array,int index) {
		int left=this.getLeft(index);
		int right=this.getRight(index);
		
		int largest=array.get(index);
		int temp=index;
		
		if(left != -1 && array.get(left)>largest){
			largest=array.get(left);
			temp=left;
		}
		
		if(right !=-1 && array.get(right) >largest){
			largest=array.get(right);
			temp=right;
		}
		
		if(temp!=index){
			int tempo=array.get(index);
			array.remove(index);
			array.add(index, array.get(temp));
			array.remove(temp);
			array.add(temp, tempo);
		}
		//heapify(arr,temp);
				
		return array;
	}

	
	
	public void heap(){
		for(int i=array.size()/2; i>=0; i--){
			this.array=this.heapify(array, i);
		}
		
		System.out.println("Array after max heapify");
		
		Iterator<Integer> itr=array.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next()+" ");
		}
		
		
		//System.out.println("Array aftre heapsort");
		
		
		
	}
	
	public void heapsort(int arr[],int len){
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new HeapSort().heap();
		
	}
	
	
	
}
