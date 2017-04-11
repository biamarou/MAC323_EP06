import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {   

    Item[] array;
    int size;
    int length;
    
    public RandomizedQueue() {
	array = null;
	size = 0; 
    } // construct an empty deque

    private class RandomIterator implements Iterator<Item> {
	int[] random = new int[size];
	int index = 0;
	public RandomIterator() {
	    for (int i = 0; i < size; i++)
	    random[i] = i;

	    StdRandom.shuffle(random);
	}

	public boolean hasNext() {
	    return index == size;
	}

	public Item next() {
	    Item next = array[random[index]];
	    index++;
	    return next;
	}

	public void remove(){}
    }


    public boolean isEmpty() {
	return size == 0;
    } // is the deque empty?

    public int size() {
	return size;
    } // return the number of items on the deque

    public void enqueue(Item item) {

	if (array == null) {
	    length = 8;
	    //array = new Item[length];
	    array = (Item[]) new Object[length];
	    array[size] = item; 
	}

	else if (size < length) {
	    array[size] = item;
	}

	else {
	    resize(2*length);
	    length *= 2;
	    array[size] = item;
	}

	size++;
    } // add the item

    public Item dequeue() {
	int remove = StdRandom.uniform(size);
	Item removed = array[remove];
	
	for (int i = remove; i < size - 1; i++) {
	    array[i] = array[i + 1];
	}
	size--;

	return(removed);
    } // remove and return a random item

    private void resize(int n) {
	Item[] new_array = new Item[n];

	for (int i = 0; i < size; i++)
	    new_array[i] = array[i];

	array = new_array;
    }

    public Item sample() {
	int sample = StdRandom.uniform(size);
	return (array[sample]);
    } // return a random item (but do not remove it)

    public Iterator<Item> iterator() {
	return new RandomIterator();
    } // return an independent iterator over items in random order

    public static void main(String[] args) {
	RandomizedQueue<String> dq = new RandomizedQueue<String>();
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
	        case "enqueue":
		   palavra = StdIn.readString();
		   dq.enqueue(palavra);
		   break;
	        case "dequeue":
		    StdOut.println(dq.dequeue());
		   break;
	        case "sample":
		   StdOut.println(dq.sample());
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
