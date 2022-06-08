

public class DoubleHashTable extends OAHashTable {
	
	public ModHash Func1;
	public ModHash Func2;
	private int m;
	
	public DoubleHashTable(int m, long p) {
		super(m);
		this.Func1 = ModHash.GetFunc(m, p);
		this.Func2 = ModHash.GetFunc(m - 1, p);
		this.m = m;
	}
	
	@Override
	public int Hash(long x, int i) {
		int val = (Func1.Hash(x) + i * (Func2.Hash(x) + 1)) % m;
		if(val < 0) {
			val = m + val;
		}
		return val;
	}
	
}
