import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class testhash {
	
	public static void main(String[] args) throws IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException, IHashTable.KeyDoesntExistException {
		
		DoubleHashTable h = new DoubleHashTable(10000019, 1000000007);
		Random rand = new Random();
		for(int k = 0; k < 6;k++) {
			Set<Integer> d = new HashSet<Integer>();
		long starttime = System.currentTimeMillis();
			
		for(int i = 0; i < 5000009; i++) {
			int b = rand.nextInt(100); 
			int a = 100 * i + b;
			d.add(a);
			HashTableElement m = new HashTableElement(a, i);
			h.Insert(m);
		}
		for(int t : d) {
			h.Delete(t);
		}
		long endtime = System.currentTimeMillis();
		long s = endtime - starttime;
		System.out.println(s);
		}
		
		
	}
}	