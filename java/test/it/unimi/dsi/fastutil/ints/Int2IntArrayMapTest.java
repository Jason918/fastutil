package test.it.unimi.dsi.fastutil.ints;

import it.unimi.dsi.fastutil.ints.AbstractInt2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntArrayMap;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;

import java.util.Map.Entry;

import junit.framework.TestCase;

public class Int2IntArrayMapTest extends TestCase {
	
	public void testMap() {
		Int2IntArrayMap m = new Int2IntArrayMap( new int[ 5 ], new int[ 5 ] );
		assertEquals( 0, m.put( 1, 1 ) );
		assertEquals( 1, m.size() );
		assertTrue( m.containsKey( 1 ) );
		assertTrue( m.containsValue( 1 ) );
		assertEquals( 0, m.put(  2, 2  ) );
		assertTrue( m.containsKey( 2 ) );
		assertTrue( m.containsValue( 2 ) );
		assertEquals( 2, m.size() );
		assertEquals( 1, m.put( 1, 3 ) );
		assertTrue( m.containsValue( 3 ) );
		assertEquals( 0, m.remove( 3 ) );
		assertEquals( new IntOpenHashSet( new int[] { 1, 2 } ), new IntOpenHashSet( m.keySet().iterator() ) );
		assertEquals( new IntOpenHashSet( new int[] { 3, 2 } ), new IntOpenHashSet( m.values().iterator() ) );

		for( Entry<Integer, Integer> e: m.entrySet() ) assertEquals( e.getValue(), m.get( e.getKey() ) );
		
		assertTrue( m.entrySet().contains( new AbstractInt2IntMap.BasicEntry( 1, 3 ) ) );
		assertTrue( m.entrySet().contains( new AbstractInt2IntMap.BasicEntry( 2, 2 ) ) );
		assertFalse( m.entrySet().contains( new AbstractInt2IntMap.BasicEntry( 1, 2 ) ) );
		assertFalse( m.entrySet().contains( new AbstractInt2IntMap.BasicEntry( 2, 1 ) ) );
		
		assertEquals( 2, m.size() );
		assertEquals( 3, m.remove( 1 ) );
		assertEquals( 1, m.size() );
		assertFalse( m.containsKey( 1 ) );
		assertEquals( 2, m.remove( 2 ) );
		assertEquals( 0, m.size() );
		assertFalse( m.containsKey( 1 ) );
	}

}
