package listClasses;

import java.util.ArrayList;
import java.util.Iterator;

public class BasicLinkedList<T> extends java.lang.Object implements java.lang.Iterable<T> {

	protected int size;
	protected Node head, tail;

	// node inner class defines node
	protected class Node {
		protected T data;
		protected Node next;

		protected Node(T data) {
			this.data = data;
			next = null; /* do we really need to do this? */
		}
	}

	/*
	 * define empty linked list with null head and tail and size of 0
	 */
	public BasicLinkedList() {
		head = null;
		tail = null; // why not
		size = 0;
	}

	// return list size
	public int getSize() {
		return size;
	}

	/*
	 * Add element to end of list and return list
	 * 
	 */
	public BasicLinkedList<T> addToEnd(T data) {
		// assign tail to new node
		Node newNode = new Node(data);
		tail = newNode;

		// if item is only one in list, also assign head
		if (size == 0) {
			head = tail;
		} else {
			// otherwise, go through list
			// and make sure previous last item points to new tail
			Node curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = tail;
		}
		size++;

		return this;
	}

	// add to front
	public BasicLinkedList<T> addToFront(T data) {
		Node newNode = new Node(data);
		// if only node, assign tail to node
		if (size == 0) {
			tail = newNode;
		}
		// assign new node as head
		newNode.next = head;
		head = newNode;
		size++;
		return this;
	}

	/*
	 * return first item/head If null, return head
	 */
	public T getFirst() {
		if (head == null) {
			return null;
		}
		return head.data;
	}

	/*
	 * return last item if list empty or head is null, return null
	 */
	public T getLast() {
		if (head == null) {
			return null;
		}
		return tail.data;
	}

	/*
	 * return first element of list and remove from list
	 */
	public T retrieveFirstElement() {
		Node curr = head;
		if (head == null) {
			return null;
		}
		head = head.next;
		size--;
		return curr.data;
	}

	/*
	 * return last element of list and remove from list
	 */
	public T retrieveLastElement() {
		Node prev = null, curr = head;
		while (curr.next != null) { // .next?
			prev = curr;
			curr = curr.next;
		}

		Node last = curr;
		prev.next = null; // now previous is end
		prev = tail;
		size--;
		// saved what was tail and return that
		return last.data;
	}

	/*
	 * remove all instances of target data traverse list once use provided
	 * comparator return new list
	 */
	public BasicLinkedList<T> remove(T targetData, java.util.Comparator<T> comparator) {

		Node prev = null, curr = head;

		while (curr != null) {
			if (comparator.compare(curr.data, targetData) == 0) {
				// if the same, remove
				if (curr == head) {
					curr = head.next;
					head = head.next;
				} else if (curr == tail) {
					tail = prev; // reassign tail
				} else {
					prev.next = curr.next;
					curr = curr.next;
				}

			} else {
				// otherwise, step up the list
				prev = curr;
				curr = curr.next;
			}
		}
		return this;
	}

	/*
	 * use anonymous inner class that defines iterator should be able to call
	 * hasNext as many times as want w/o changing what the next element is. hasNext
	 * and next don't need to implement remove method, throw unsupported exception
	 */
	public Iterator<T> iterator() {

		return new Iterator<T>() {

			Node curr = head;

			public boolean hasNext() {
				// check if there is a current object
				if (curr != null) {
					return true;
				}
				return false;
			}

			public T next() {
				// return current object and increment
				Node store = curr;
				curr = curr.next;
				return store.data;
			}
		};
	}

	// return ArrayList of LinkedList Items in reverse order
	public ArrayList<T> getReverseArrayList() {
		ArrayList<T> answer = new ArrayList<T>();
		// call auxiliary method
		getReverseAux(head, answer);
		return answer;

	}

	// Auxiliary helper method
	public void getReverseAux(Node headAux, ArrayList<T> answerAux) {

		if (headAux == null) {
			return;
		}
		answerAux.add(0, headAux.data);
		getReverseAux(headAux.next, answerAux);
	}

	/*
	 * return new list with elements in reverse order
	 */
	public BasicLinkedList<T> getReverseList() {

		BasicLinkedList<T> reverseList = new BasicLinkedList<T>();
		getReverseListAux(head, reverseList);
		return reverseList;
	}

	// Auxiliary helper method
	public void getReverseListAux(Node headAux, BasicLinkedList<T> reverseListAux) {
		if (headAux == null) {
			return;
		}
		reverseListAux.addToFront(headAux.data);
		getReverseListAux(headAux.next, reverseListAux);
	}

}
