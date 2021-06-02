package lists;

public class DoublyLinkedList<T> implements Listable<T> {

	private Node head = null;
	private Node tail = null;
	
	private class Node {
		T data = null;
		Node next = null;
		Node prev = null;
	}
	
	@Override
	public void add(T data) {
		addLast(data);

	}

	@Override
	public void add(int index, T data) throws NullPointerException {
		if(index == size() ){
			addLast(data);
		}else if(index == 0){
		addFirst(data);
		} else {
			Node temp = head;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			Node node = new Node();
			node.data = temp.data;
			node.next = temp.next;
			node.prev = temp;
			temp.data = data;
			temp.next = node;

		}
	}
	@Override
	public void addFirst(T data) {
		Node memorized = head;
		Node node = new Node();
		node.data = data;
		node.next = memorized;
		head = node;
		if(memorized == null) {
			tail = node;
		}
		memorized.prev = head;
		}

	@Override
	public void addLast(T data) {
		Node memorized = tail;
		Node node = new Node();
		node.data = data;
		node.prev = memorized;
		tail = node;
		if(memorized == null) {
			head = node;
		}else{
			memorized.next = node;
		}

	}

	@Override
	public void remove(int index) throws NullPointerException{
		Node temp = head;
		if(index == 0 && temp.next != null){
			head = temp.next;
		}
		int counter = 0;
		while(temp != null){
			if(counter == (index)){
				temp.prev.next = temp.next;
				break;
			} else{
				temp = temp.next;
				counter++;
			}
		}
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
	}

	@Override
	public T get(int index)throws NullPointerException {
		if ((head == null)) {
			return null;
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	@Override
	public void set(int index, T data) throws NullPointerException{
		Node temp = head;
		for (int i = 0; i < (index); i++) {
			temp = temp.next;
		}
		temp.data = data;
	}
	@Override
	public boolean isEmpty() {
		return ((head == null) && (tail == null));
	}

	@Override
	public int size() {
		int counter = 0;
		Node temp = head;
		while (temp != null) {
			counter++;
			temp = temp.next;
		}
		return counter;
	}

	@Override
	public void printAll() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}


}
