
public class LPHashTable extends OAHashTable {
	
	private ModHash Func;
	private int m;
	
	public LPHashTable(int m, long p) {
		super(m);
		this.Func = ModHash.GetFunc(m, p);
		this.m = m;
	}
	
	@Override
	public int Hash(long x, int i) {
		int val = (Func.Hash(x) + i) % m;
		return val;
	}
	
}
