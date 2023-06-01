package finals_lab_exam;

public class Array<T> {
	// Class fields
	private T array[];
	private int size;
	private int capacity;
	
	// Constructors
	@SuppressWarnings("unchecked")
	public Array(int size) {
		this.array = (T[]) new Object[size];
		this.setSize(size);
		this.setCapacity(size);
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public T[] getArray() {
		return array;
	}

	public void setArray(T array[]) {
		this.array = array;
	}
}
