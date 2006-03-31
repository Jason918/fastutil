package test.it.unimi.dsi.fastutil.objects;

import it.unimi.dsi.fastutil.objects.ReferenceArraySet;
import it.unimi.dsi.fastutil.objects.ReferenceOpenHashSet;
import junit.framework.TestCase;

public class ReferenceArraySetTest extends TestCase {
	
	public void testSet() {
		ReferenceArraySet<Object> s = new ReferenceArraySet<Object>( new Object[ 5 ] );
		Integer one = new Integer( 1 ), two = new Integer( 2 ), three = new Integer( 3 );
		assertTrue( s.add( one ) );
		assertEquals( 1, s.size() );
		assertTrue( s.contains( one ) );
		assertFalse( s.contains( new Integer( 1 ) ) );
		assertTrue( s.add(  two  ) );
		assertTrue( s.contains( two ) );
		assertFalse( s.contains( new Integer( 2 ) ) );
		assertEquals( 2, s.size() );
		assertFalse( s.add( one ) );
		assertFalse( s.remove( three ) );
		assertEquals( new ReferenceOpenHashSet<Object>( new Object[] { one, two } ), new ReferenceOpenHashSet<Object>( s.iterator() ) );
		assertEquals( 2, s.size() );
		assertTrue( s.remove( one ) );
		assertEquals( 1, s.size() );
		assertFalse( s.contains( one ) );
		assertTrue( s.remove( two ) );
		assertEquals( 0, s.size() );
		assertFalse( s.contains( one ) );
	}

}
