import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class testh {
	public static void main(String[] args) throws IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException, IHashTable.KeyDoesntExistException {
		DoubleHashTable s1 = new DoubleHashTable(10000019, 1000000007);
		int b;
		Random random = new Random();
		long st = System.currentTimeMillis(); 
 		for(int i = 0; i<5000009; i++) {
 			b = random.nextInt(0,100);
 			HashTableElement m = new HashTableElement(100*i + b, i);
			s1.Insert(m);
		}
 		long end = System.currentTimeMillis();
 		System.out.print(end - st);
	}	

}
