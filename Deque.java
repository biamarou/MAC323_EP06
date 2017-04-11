import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private class Node {
	Item item;
	Node next;

	private Node (Item item) {
	    this.item = item;
	}
    }

    private class LinearIterator implements Iterator<Item> {
	private Node it = head;

	public boolean hasNext() {
	    return it != null;
	}

	public Item next() {
	    Node tmp = it;
	    it = it.next;
	    return tmp.item;
	}

	public void remove(){}
    }

    Node head;
    Node tail;
    int size;

    public Deque() {
	head = null;
        tail = null;
	size = 0;
    } // construct an empty deque

    public boolean isEmpty() {
	return head == null;
    } // is the deque empty?

    public int size() {
	return size;
    } // return the number of items on the deque

    public void addFirst(Item item) {
	Node integrate = new Node(item);
	Node temporary;

	if (head == null) {
	    head = integrate;
	    tail = head;
	}

	else {
	    temporary = head;
	    head = integrate;
	    head.next = temporary;
	}

	size++;
	
    } // add the item to the front

    public void addLast(Item item) {
	Node integrate = new Node(item);

	if (tail == null) {
	    tail = integrate;
	    head = tail;
	}

	else {
	    tail.next = integrate;
	    tail = tail.next;
	}

	size++;
	
    } // add the item to the end
    
    public Item removeFirst() {
	Node temporary;
	Item remove;
	
	if (head == null) return null;

	else {
	    temporary = head;
	    remove = head.item;
	    head = head.next;
	    temporary = null;
	}

	size--;
	return remove;
    } // remove and return the item from the front

    public Item removeLast() {
	Item remove;
	if (tail == null) return null;

	else {
	    Node i;
	    for (i = head; i.next != tail; i = i.next){}
	    tail = i;
	    remove = tail.next.item;
	    tail.next = null;
	}

	size--;
	return remove;
    } // remove and return the item from the end

    public Iterator<Item> iterator() {
	return new LinearIterator();
    } // return an iterator over items in order from front to end

    public static void main(String[] args) {
	Deque<String> dq = new Deque<String>();
	String comando, palavra;

	while (!StdIn.isEmpty()) {
	    comando = StdIn.readString();
	    

	    switch (comando) {
	        case "isEmpty":
		   StdOut.println(dq.isEmpty());
		   break;
	        case "size":
		   StdOut.println(dq.size());
		   break;
	        case "addFirst":
		   palavra = StdIn.readString();
		   dq.addFirst(palavra);
		   break;
	        case "addLast":
		   palavra = StdIn.readString();
		   dq.addLast(palavra);
		   break;
	        case "removeFirst":
		   StdOut.println(dq.removeFirst());
		   break;
	        case "removeLast":
		   StdOut.println(dq.removeLast());
		   break;
	        case "iterator":
		    Iterator<String> ite = dq.iterator();
		    while(ite.hasNext())
			StdOut.println(ite.next());
		    break;
	   }
       }

   }  // unit testing (required)
}
