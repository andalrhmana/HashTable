import java.util.Random;

public class AQPHashTable extends OAHashTable {
	
	private ModHash Func;
	private int m;

	public AQPHashTable(int m, long p) {
		super(m);
		this.Func = ModHash.GetFunc(m, p);
		this.m = m;
	}
	
	@Override
	public int Hash(long x, int i) {
		int val = (int) ((Func.Hash(x) + (Math.pow(-1, i) * i * i)) % m);
		if(val < 0) {
			val += m;
		}
		return val;
	}
}
