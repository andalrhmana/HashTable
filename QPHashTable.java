import java.util.Random;

public class QPHashTable extends OAHashTable {
	
	public ModHash Func;
	private int m;

	public QPHashTable(int m, long p) {
		super(m);
		this.Func = ModHash.GetFunc(m, p);
		this.m = m;
	}
	
	@Override
	public int Hash(long x, int i) {
		int val = (Func.Hash(x) + (i * i)) % m;
		return val;
	}
}
