
public abstract class OAHashTable implements IHashTable {
	
	public HashTableElement [] table;
	private static  final long inf = -1;
	
	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		// TODO add to constructor as needed
	}
	
	
	@Override
	public HashTableElement Find(long key) {
		int m = table.length;
		int j;
		for(int i = 0; i < m; i++) {
			j = Hash(key, i);
			if(table[j] == null) {
				return null;				
			}
			if(table[j].GetKey() == key) {
				return table[j];
			}
		}
		return null;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		int m = table.length;
		int j;
		for(int i = 0; i < m; i++) {
			j = Hash(hte.GetKey(), i);
			if(table[j] == null) {
				table[j] = hte;	
				break;
			}
			if(table[j].GetKey() == inf) {	
				if(Find(hte.GetKey()) == null) {
					table[j] = hte;	
					break;
				}	
			}
			if(table[j].GetKey() == hte.GetKey()) {
				throw new KeyAlreadyExistsException(hte);
			}
			if(i == m - 1 && table[j].GetKey() != hte.GetKey()) {
				throw new TableIsFullException(hte);
			}
		}
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		int m = table.length;
		int j;
		HashTableElement infindex = new HashTableElement(inf, 0);
		for(int i = 0; i < m; i++) {
		    j = Hash(key, i);
		    if(table[j] == null) {
		    	throw new KeyDoesntExistException(key);
		    }
		    else {
		    	if(table[j].GetKey() == key) {
		    		table[j] = infindex;	
		    		break;
		    	}
		    }	
		}	
	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
