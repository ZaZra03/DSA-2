package finals_lab_exam;

public class Array<T> {
	// Class fields
	private Object array[];
	private int size;
	private int capacity;
	
	
	// Constructors
	public Array(int size) {
		this.setArray(new Object[size]);
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

	
	public void addObject(Object object) {
		if (capacity == 0)
			increaseCapacity();
		array[size - capacity] = object;
		capacity--;
	}
	
	public void increaseCapacity() {
		Object[] newArray = new Object[size + 10];
		int index = 0;
		for (Object value : this.getArray()) {
			newArray[index] = value;
			index++;
		}
		this.setArray(newArray);
		this.setSize(this.getSize() + 10);
		this.setCapacity(this.getCapacity() + 10);
	}

	public Object[] getArray() {
		return array;
	}

	public void setArray(Object array[]) {
		this.array = array;
	}
}
