
public class LinkedList {
	private NodeLL first;
	private NodeLL last;

	public LinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertAtBack(String sentence) {
		if (isEmpty())
			first = last = new NodeLL(sentence, first);
		else {
			last.setLink(new NodeLL(sentence));
			last = last.getLink();
		}
	}

	public void deleteList() {
		first = null;
	}

	public void outputList() {
		NodeLL position = first;
		while (position != null) {
			System.out.println(position.getItem());
			position = position.getLink();
		}
	}

}

