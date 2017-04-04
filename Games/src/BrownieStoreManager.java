import java.util.ArrayList;
import java.util.Iterator;

public class BrownieStoreManager {
	static int MAX_STORES = 6;
	ArrayList<BrownieStore> brownieStores;
	Iterator<BrownieStore> storeIterator;

	BrownieStoreManager() {
		brownieStores = new ArrayList<BrownieStore>();
		for (int i = 1; i < MAX_STORES + 1; i++) {
			brownieStores.add(new BrownieStore("Store " + Integer.toString(i)));
		}
		storeIterator = brownieStores.iterator();
	}

	public BrownieStore getNextStore() {
		if (storeIterator.hasNext()) {
			return storeIterator.next();
		} else {
			return null;
		}
	}
	
	
	public BrownieStore getStoreWithName(String storeName) {
		storeIterator = brownieStores.iterator();
		while (storeIterator.hasNext()) {
			BrownieStore store = storeIterator.next();
			if (store.name.equals(storeName)) {
				return store;
			}
		}
		return null;
	}
}
