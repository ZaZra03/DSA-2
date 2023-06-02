/**
 * The Array class is a generic, dynamic array implementation in Java that
 * automatically manages its size and capacity. It features constructors, and
 * setter methods for size and capacity, as well as methods to add objects and
 * increase capacity as needed. When adding an object, the class checks if there
 * is enough capacity and increases it if necessary. The increaseCapacity()
 * method creates a new array with an increased size and copies the elements
 * from the old array to the new one. The class provides access to the
 * underlying object array using getter and setter methods.
 *
 * @class Array
 *
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Hans Neil Emnacin
 * @author Marc Ryzon Elomina
 * @author Mark Cedrick De Vera
 * @author Rizaldy Cantalejo
 * 
 * @see Item
 * @see Main
 * @see Transaction
 */
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

	// Getters and Setters
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

	public Object[] getArray() {
		return array;
	}

	public void setArray(Object array[]) {
		this.array = array;
	}

	/**
	 * Adds a new object to the array and resizes the array if needed.
	 *
	 * @param object the new object to be added to the array
	 */
	public void addObject(Object object) {
		if (capacity == capacity - size + 1)
			increaseCapacity();
		array[size - capacity] = object;
		capacity--;
	}

	/**
	 * Increases the capacity of the underlying object array by creating a larger
	 * new array and copying the data over.
	 */
	public void increaseCapacity() {
		Object[] newArray = new Object[size + 10];
		int index = 0;
		for (Object value : this.getArray()) {
			newArray[index] = value;
			index++;
		}
		this.setArray(newArray);
	}
}
