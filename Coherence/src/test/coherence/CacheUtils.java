package test.coherence;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

public class CacheUtils {
	
	public static NamedCache getCache(String name){
		return CacheFactory.getCache("countries");
	}
}
