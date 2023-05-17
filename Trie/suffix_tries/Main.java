
/**
 * The Main class serves as the entry point and user interface for interacting
 * with the SuffixTrie data structure. It prompts the user to input the number
 * of strings to insert into the trie and then allows the user to traverse the
 * trie by selecting child nodes from the root node. The program displays the
 * current path during the traversal and provides options to retry or terminate
 * the program. The initializedTrie method handles the insertion of strings into
 * the trie, checking for compatibility with existing child nodes. Overall, the
 * Main class provides a user-friendly way to create and navigate a suffix trie,
 * allowing users to explore and interact with the data structure.
 *
 * @class Main
 *
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Hans Neil Emnacin
 * @author Marc Ryzon Elomina
 * @author Mark Cedrick De Vera
 * @author Rizaldy Cantalejo
 * 
 * @see Node
 * @see SuffixTrie
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static SuffixTrie trie = new SuffixTrie();

	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		while (true) {
			System.out.print("How many strings? ");
			try {
				int value = Integer.parseInt(in.readLine());
				System.out.println("Enter " + value + " strings:");
				if (initializedTrie(value, "")) {
					System.out.println("Standard trie created!");
					System.out.println();

					while (true) {
						String search = "";
						Node temp = trie.getRoot();
						System.out.print("Select child node from root node (" + trie.displayChild(temp) + "): ");
						String character = in.readLine();
						search += character + " ";

						// Traverse the trie based on user input.
						if (temp.getChild()[0].getData() == character.charAt(0))
							temp = temp.getChild()[0];
						else
							temp = temp.getChild()[1];

						while (temp != null) {
							String children = trie.displayChild(temp);
							if (children.length() != 1) {
								System.out.println("Display: " + search);
								System.out.print("Select child node from " + character + " (" + children + "): ");
								character = in.readLine();
								search += character + " ";
								temp = temp.getChild()[trie.hashKey(character.charAt(0))];
								continue;

							} else {
								// Traverse the trie until a terminating node is reached.
								while (children.length() == 1 && !(temp.isLastCharacter())) {
									temp = temp.getChild()[trie.hashKey(children.charAt(0))];
									search += children.charAt(0) + " ";
									children = trie.displayChild(temp);
								}
								if (temp.isLastCharacter() && temp.isChildEmpty()) {
									System.out.println("Display: " + search);
									break;
								}

								System.out.println("Display: " + search);
								System.out.print("Select child node from " + temp.getData() + " (" + children + "): ");
								character = in.readLine();

								// Handle termination condition.
								if (character.equals("terminate")) {
									System.out.println("Display: " + search);
									break;
								}
								search += character + " ";
								temp = temp.getChild()[trie.hashKey(character.charAt(0))];
							}
						}

						// Ask user if they want to try again or exit the program.
						System.out.print("Try again? ");
						String response = in.readLine().toUpperCase();

						switch (response) {
						case "Y":
							System.out.println();
							break;
						case "N":
							System.out.println("Program will be terminated");
							for (int i = 0; i < 3; i++) {
								Thread.sleep(1000);
								System.out.print(".");
							}
							System.out.println("Program terminated.");
							System.exit(0);
							break;
						default:
							System.out.println("Invalid choice!\n");
						}
					}

				} else {
					System.out.println("Error. Please try again.");
					System.out.println();
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid integer.");
				System.out.println();
			}
		}
	}

	/**
	 * Initializes the suffix trie by inserting the specified number of strings into
	 * it. Returns true if the trie is successfully initialized, or false otherwise.
	 * 
	 * @param value The number of strings to insert into the trie.
	 * @param text  A placeholder variable for reading user input.
	 * @return True if the trie is successfully initialized, false otherwise.
	 * @throws NumberFormatException If the input string cannot be parsed as an
	 *                               integer.
	 * @throws IOException           If an I/O error occurs while reading the input.
	 */
	static boolean initializedTrie(int value, String text) throws NumberFormatException, IOException {
		try {
			for (int i = 0; i < value; i++) {
				text = in.readLine();
				if (trie.isChildFull()) {
					if (trie.getRoot().getChild()[0].getData() == text.charAt(0)
							|| trie.getRoot().getChild()[1].getData() == text.charAt(0)) {
						trie.insert(text);
					} else {
						trie = new SuffixTrie();
						return false;
					}
				} else {
					trie.insert(text);
				}
			}
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
}
