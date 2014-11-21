package test.java.util;

import static org.junit.Assert.*;

import java.util.TreeMap;

import org.junit.Test;

public class TreeMapTest {

	@Test(expected = NullPointerException.class)
	public void putSuccessAndThrowOnPutNull_jdk6_andHigher() {
		int mark = 0;
		try {
			TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();
			m.put(1,2);  
			mark = 1;
			m.put(null, null);// throws NPE
		} catch (NullPointerException e) {
			assertEquals(1, mark);
			throw e;
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void putNullThrowNPE_jdk7_andHigher() {
		TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();
		m.put(null, null);
	}
	
}