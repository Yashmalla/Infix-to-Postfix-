
public class LinkedList extends Node implements List{
	private Node top;
	private int index = 0;
	
	public boolean isEmpty(){
		return(this.index == 0);
	}
	@Override
	public int getSize() {
		return index;
	}
	@Override
	public void insertFront(Object item) {
		Node newNode = new Node(item);
		if (isEmpty()) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
		index++;
	}

	@Override
	public void insertBack(Object item) {
		Node newNode = new Node(item);
		if (isEmpty()) {
			top = newNode;
		} else {
			Node tail = this.getTail();
			tail.next = newNode;
		}
		index++;
	}

	@Override
	public Object removeFront() {
		Object data = top.data;
		top = top.next;
		index--;
		return data;
	}

	@Override
	public Object removeBack() {
		Node current = top;
		Object data;
		for (int i = 1; i <index -1; i++) {
		
			current = current.next;
		}
		data = current.next.data;
		current.next = null;
		index--;
		return data;
	}

	@Override
	public Object get(int index) {
		if (index <= this.index) {
			Node current = top;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			return current.data;
		}
		else{
			return null;
		}
	}
	public Node getTail(){
		Node current = top;
		for (int i = 1; i < index; i++) {
			current = current.next;
		}
		return current;
	}
	public Node getHead(){
		return this.top;
	}

}
