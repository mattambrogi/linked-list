package listClasses;

import java.util.Comparator;

public class SortedLinkedList<T> extends BasicLinkedList<T> {

	Comparator<T> comparator;

	/*
	 * call super and declare comparator
	 */
	public SortedLinkedList(java.util.Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	public SortedLinkedList<T> add(T element) {
		Node newNode = new Node(element);
		if (size == 0) {
			head = newNode;
			tail = newNode;
			size++;
			return this;
		}
		else if (comparator.compare(tail.data, element) < 0) {
			tail.next = newNode;
			tail = newNode;
			size++;
			return this;
		} else {
			Node curr = head;
			Node prev = null;
			while (curr != null) {
				// if item is greater than or equal to element, insert
				if (comparator.compare(curr.data, element) >= 0) {
					// if first thing in the list bigger
					// point to head and reassign head
					if (prev == null) {
						newNode.next = head;
						head = newNode;
						size++;
						return this;
					}
					// otherwise, insert in between
					else {
						prev.next = newNode;
						newNode.next = curr;
						size++;
						return this;
					}

				}
				// increment
				prev = curr;
				curr = curr.next;
			}
		}

		return this;

	}

	/*
	 * calls super method to 
	 * remove target data
	 */
	public SortedLinkedList<T> remove(T targetData) {
		return (SortedLinkedList<T>) super.remove(targetData, comparator);
	}

	//throws unsupported operation exception
	public BasicLinkedList<T> addToEnd(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");

	}

	//throws unsupported operation exception
	public BasicLinkedList<T> addToFront(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");

	}

}