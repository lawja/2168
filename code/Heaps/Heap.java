public class Heap{

	private int[] heap;
	private int size;

	public Heap(int capacity){
		heap = new int[capacity];
		size = 0;
	}

	public void insert(int i){
		size++;
		heap[size] = i;
		shift();
	}

	private void shiftUp(){
		i = size;
		while(i >= 2){
			if(heap[i] > heap)
		}
	}

	private int leftChildIndex(int i){
		return i * 2;
	}

	private int leftChild(int i){
		return a[leftChildIndex(i*2)];
	}

	private boolean hasLeftChild(int i){

	}

	private boolean hasParent(int i){
		return i > 1;
	}

	private int parentIndex(int i){
		return i/2;
	}

	private int parent(int i){
		return heap[parentIndex(i)];
	}
}