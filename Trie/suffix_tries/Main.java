package suffix_tries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		SuffixTrie trie = new SuffixTrie();
		int value;
		
//		trie.insert("bear");
//		trie.insert("sell");
//		for(int i = 0; i<trie.getRoot().getChild().length; i++) {
//			System.out.println(trie.getRoot().getChild()[i].getData());
//		}
		
		System.out.print("How many strings? ");
		value = Integer.parseInt(in.readLine());
		System.out.println("Enter " + value + " strings:");
		for(int i = 0; i < value; i++) {
			String text = in.readLine();
			trie.insert(text);
		}
		System.out.println("Standard trie created!");
		System.out.println();
		
		while(true) {

		}
	}

}
