
import java.util.Scanner;

public class Test {
	public static void addSentence(String sentence, LinkedList ll, AVLTree tree) {
		String[] wordArray = sentence.split(" ");
		for (int i = 0; i < wordArray.length; i++) {
			ll.insertAtBack(wordArray[i]);
		}
		sentence = sentence.replaceAll("\\p{Punct}", "").replaceAll("“", "").replaceAll("”", "").toLowerCase();
		wordArray = sentence.split(" ");
		for (int i = 0; i < wordArray.length; i++) {
			tree.setRoot(tree.insert(tree.getRoot(), wordArray[i]));
		}
	}

	public static void contains(String word, AVLTree tree) {
		System.out.println("Does this paragraph contain \"" + word + "\"?");
		if (tree.search(word))
			System.out.println("Yes, amount of word \"" + word + "\" in the paragraph is "
					+ tree.returnNode(word).getCount() + ".");
		else
			System.out.println("No, there is not such a word like " + word + ".");
	}

	public static void clearAll(LinkedList ll, AVLTree tree) {
		ll.deleteList();
		tree.deleteTree();
		System.out.println("All paragraphs removed from the list.");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList ll = new LinkedList();
		AVLTree tree = new AVLTree();

		System.out.println("---WORD SEARCHING SYSTEM---\nPlease enter your text in a single paragraph:");
		String prg = sc.nextLine();
		addSentence(prg, ll, tree);

		System.out.println(
				"\nSELECT OPERATOR:\n1) Add new paragraph\n2) Display word list\n3) Search keyword\n4) Clear list\n5) EXIT");
		String choice = sc.next();

		while (true) {
			if (choice.equals("1")) {
				System.out.println("Enter a paragraph:");
				sc.nextLine();
				prg = sc.nextLine();
				addSentence(prg, ll, tree);
			} else if (choice.equals("2")) {
				System.out.println("---WORD LIST & COUNTS---");
				tree.inOrder(tree.getRoot());
			} else if (choice.equals("3")) {
				System.out.print("Enter the word you want to search for: ");
				String word = sc.next();
				contains(word, tree);
			} else if (choice.equals("4")) {
				clearAll(ll, tree);
			} else if (choice.equals("5")) {
				System.out.println("Program terminated.");
				break;
			} else {
				System.out.println("INVALID OPERATOR! Please try again and select a valid operator:");
				System.out.println(
						"1) Add new paragraph\n2) Display word list\n3) Search keyword\n4) Clear list\n5) EXIT");
				choice = sc.next();
				continue;
			}
			System.out.println(
					"\nSELECT NEXT OPERATOR:\n1) Add new paragraph\n2) Display word list\n3) Search keyword\n4) Clear list\n5) EXIT");
			choice = sc.next();
		}
	}
}
