package suffix_tries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static SuffixTrie trie = new SuffixTrie();


	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		// TODO Auto-generated method stub
//		trie.insert("bear");
//		trie.insert("bell");
//		trie.insert("bid");
//		trie.insert("bull");
//		trie.insert("buy");
//		trie.insert("sell");
//		trie.insert("stock");
//		trie.insert("stop");
//
		while(true) {
			System.out.print("How many strings? ");
			int value = Integer.parseInt(in.readLine());
			System.out.println("Enter " + value + " strings:");
			if(initializedTrie(value, "")) {
				System.out.println("Standard trie created!");
				System.out.println();

				while (true) {
					String search = "";
					Node temp = trie.getRoot();
					System.out.print("Select child node from root node (" + trie.displayChild(temp) + "): ");
					String character = in.readLine();
					search += character + " ";
//					System.out.println("Display: " + search);
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
							while(children.length() == 1 && !(temp.isLastCharacter())) {
								temp = temp.getChild()[trie.hashKey(children.charAt(0))];
								search += children.charAt(0) + " ";
								children = trie.displayChild(temp);
							}
							if(temp.isLastCharacter() && temp.isChildEmpty()) {
								System.out.println("Display: " + search);
								break;
							}
							
							System.out.println("Display: " + search);
							System.out.print("Select child node from " + temp.getData() + " (" + children + "): ");
							character = in.readLine();
							if(character.equals("terminate")) {
								System.out.println("Display: " + search);
								break;
							}
							search += character + " ";
							temp = temp.getChild()[trie.hashKey(character.charAt(0))];
						} 
					}

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
		}
	}

	static boolean initializedTrie (int value, String text) throws NumberFormatException, IOException {
		for (int i = 0; i < value; i++) {
			text = in.readLine();
			if(trie.isChildFull()) {
				if(trie.getRoot().getChild()[0].getData() == text.charAt(0) || trie.getRoot().getChild()[1].getData() == text.charAt(0)) {
					trie.insert(text);
				} else {
					trie = new SuffixTrie();
					return false;
				}
			} else trie.insert(text);
		}
		return true;
	}
}
