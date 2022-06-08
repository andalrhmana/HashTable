import java.util.Random;

public class ModHash {
	
	private long a;
	private long b;
	private int m;
	private long p;
	
	public 	ModHash(int m, long p) {
		Random  rand = new Random();
		this.a = rand.nextLong(1, p);
		this.b = rand.nextLong(0, p);
		this.m = m;
		this.p = p;	
	}
	
	public static ModHash GetFunc(int m, long p){
		ModHash Func = new ModHash(m, p);
		return Func;
	}
	
	public int Hash(long key) {
		int val = (int) (((a * key + b) % p) % m);
		return val;
	}
}
