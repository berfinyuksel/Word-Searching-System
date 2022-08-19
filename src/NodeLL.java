
public class NodeLL {
	private String sentence;
	private NodeLL link;

	public NodeLL() {
		sentence = null;
		link = null;
	}

	public NodeLL(String sentence) {
		this.sentence = sentence;
		link = null;
	}

	public NodeLL(String sentence, NodeLL link) {
		this.sentence = sentence;
		this.link = link;
	}

	public String getItem() {
		return sentence;
	}

	public NodeLL getLink() {
		return link;
	}

	public void setLink(NodeLL link) {
		this.link = link;
	}
}
