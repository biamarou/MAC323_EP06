import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class Subset {
    public static void main(String[] args) {
	RandomizedQueue<String> rd = new RandomizedQueue<String>();
	int k = Integer.parseInt(args[0]);

	while (!StdIn.isEmpty()) {
	    rd.enqueue(StdIn.readString());
	}
	
	Iterator<String> it = rd.iterator();
	for (int i = 0; i < k && it.hasNext(); i++){
	    StdOut.println(it.next());
	}
    }
}
