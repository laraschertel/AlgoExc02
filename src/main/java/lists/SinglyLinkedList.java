package lists;

public class SinglyLinkedList<T> implements Listable<T> {

	private Node head = null;

	private class Node {
		T data = null;
		Node next = null;
	}

	@Override
	public void add(T data) {
		Node node = new Node();
		node.data = data;
		node.next = null;

		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
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
				temp.data = data;
				temp.next = node;

		}

	}

	@Override
	public void addFirst(T data) {
		Node memorized = head;
		head = new Node();
		head.data = data;
		head.next = memorized;

	}

	@Override
	public void addLast(T data) {
		Node node = new Node();
		node.data = data;
		node.next = null;

		if(head == null){
			head = node;
		}else {
			Node temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = node;
		}
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

	@Override
	public void clear() {
		head = null;
	}

	@Override
	public boolean isEmpty() {

		return (head == null);
	}


	@Override
	public void remove(int index)  throws NullPointerException{
		Node temp = head;
		if(index == 0 && temp.next != null){
			head = temp.next;
		}
		int counter = 0;
		while(temp != null){
			if(counter == (index-1)){
				temp.next = temp.next.next;
				break;
			} else{
				temp = temp.next;
				counter++;
			}
		}
	}

	@Override
	public T get(int index)  throws NullPointerException{
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
	public void set(int index, T data)  throws NullPointerException{
		Node temp = head;
		for (int i = 0; i < (index); i++) {
			temp = temp.next;
		}
		temp.data = data;
	}

}
