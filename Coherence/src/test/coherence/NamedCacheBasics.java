package test.coherence;

import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

import test.coherence.model.Country;

/*
 * As a matter of fact, NamedCache is an interface that extends Java's Map interface, 
 * so you will be immediately familiar not only with get and put methods, 
 * but also with other methods from the Map interface, such as clear, remove, putAll, size, and so on.
 */

@SuppressWarnings("unchecked")
public class NamedCacheBasics {
	
	NamedCache cacheCountries;
	
	@Before
	public void init(){
		/*
		 * There is one Coherence node here — the CoherenceWorkshop application. 
		 * As soon as the CacheFactory.getCache method gets invoked, Coherence services will start within the application's JVM 
		 * and it will either join the existing cluster or create a new one, if there are no other nodes on the network.
		 */
		cacheCountries = CacheFactory.getCache("countries");
	}
	
	@Test
	public void test(){
		putIntoNamedCache();
		readAllFromNamedCache();
	}
	
	public void putIntoNamedCache() {
		cacheCountries.put("USA", new Country("USA", "United States", "Washington"));
		cacheCountries.put("TR", new Country("TR", "Turkey", "Ankara"));
		cacheCountries.put("RUS", new Country("RUS", "Russia", "Moscow")); 
		cacheCountries.put("JPN", new Country("JPN", "Japan", "Tokyo")); 
		cacheCountries.put("FRA", new Country("FRA", "France", "Paris"));
		cacheCountries.put("ITA", new Country("ITA", "Italy", "Rome")); 
	}
		
	public void readAllFromNamedCache(){		
		for(Map.Entry<String, Country> entry : (Set<Map.Entry<String, Country>>) cacheCountries.entrySet()){
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
	
	public void printNamedCacheUtilities(){
		System.out.println("count of countries in cache: " + cacheCountries.size());
	}
	
	
}
 