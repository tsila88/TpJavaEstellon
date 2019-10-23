package fr.licinfo.rangeArray;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RangeArray<T> implements Iterable<T> {

	private int indexMin;
	private int indexMax;
	private Map<Integer,T> array;
	private int size;

	public int getIndexMin() {
		return indexMin;
	}

	public void setIndexMin(int indexMin) {
		this.indexMin = indexMin;
	}

	public int getIndexMax() {
		return indexMax;
	}

	public void setIndexMax(int indexMax) {
		this.indexMax = indexMax;
	}

	public void set(int index, T value) {
		
		array.put(index, value);
		
	}
	 public T get(int index) {
		 //return intArray[index];
		 return array.get(index);
	 }
	
	public RangeArray(int indexMin, int indexMax) {

		this.indexMin = indexMin;
		this.indexMax = indexMax;
		this.array = new HashMap<Integer, T>();

	}

	public int rangeSize() {

		int size = Math.abs( (this.getIndexMax() - this.getIndexMin()) + 1);
		this.size = size;
		return size;

	}

	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
