package test.coherence.model;

import java.io.Serializable;

/*
 * Because the objects needs to be moved across the network, classes that are stored within the data grid need to be serializable. 
 * In this case we have opted for the simplest solution and made the class implement the java.io.Serializable interface. 
 * This is not optimal, both from performance and memory utilization perspective, and Coherence provides several more suitable approaches to serialization. 
 * 
 * We have implemented the toString method that prints out an object's state in a friendly format. 
 * While this is not a Coherence requirement, implementing toString properly for both keys and values that you put into the cache will help a lot 
 * when debugging, so you should get into a habit of implementing it for your own classes.
 */

public class Country implements Serializable, Comparable<Country> {

	private static final long serialVersionUID = 1948773048499835863L;
	
	private String code;
	private String name;
	private String capital;

	public Country() {
	}

	public Country(String code, String name, String capital) {
		this.code = code;
		this.name = name;
		this.capital = capital; 
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String toString() {
		return "Country(" + "Code = " + code + ", " + "Name = " + name + ", " + "Capital = " + capital + ")";
	}

	public int compareTo(Country o) {
		Country other = (Country) o;
		return this.name.compareTo(other.name);
	}
}
