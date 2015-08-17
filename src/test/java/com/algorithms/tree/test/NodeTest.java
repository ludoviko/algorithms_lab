package com.algorithms.tree.test;

import org.junit.Test;

import com.algorithms.tree.Node;

import junit.framework.TestCase;

public class NodeTest extends TestCase {
	private Node<String> a;
	private Node<String> d;
	private Node<String> f;
	private Node<String> h;
	private Node<String> i;
	private Node<String> k;
	private Node<String> l;
	private Node<String> m;
	private Node<String> p;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		a =new Node<String>("A");
		h =new Node<String>("H");
		k =new Node<String>("K");
		p =new Node<String>("P");
		f =new Node<String>("F", null, h);
		m =new Node<String>("M", null, p);
		d =new Node<String>("D", a, f);
		l =new Node<String>("L", k, m);
		i =new Node<String>("I", d, l);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
        a = h = k = p = f = m = d = l = i = null;
	};

	@Test
   public void testMinimum() {
		NodeTest.assertSame(a, a.minimum());	
		NodeTest.assertSame(a, d.minimum());	
		NodeTest.assertSame(f, f.minimum());	
		NodeTest.assertSame(h, h.minimum());	
		NodeTest.assertSame(a, i.minimum());	
		NodeTest.assertSame(k, k.minimum());	
		NodeTest.assertSame(k, l.minimum());	
		NodeTest.assertSame(m, m.minimum());
		NodeTest.assertSame(p, p.minimum());	
	} 
	
	@Test
	   public void testMaximum() {
			NodeTest.assertSame(a, a.maximum());	
			NodeTest.assertSame(h, d.maximum());	
			NodeTest.assertSame(h, f.maximum());	
			NodeTest.assertSame(h, h.maximum());	
			NodeTest.assertSame(p, i.maximum());	
			NodeTest.assertSame(k, k.maximum());	
			NodeTest.assertSame(p, l.maximum());	
			NodeTest.assertSame(p, m.maximum());
			NodeTest.assertSame(p, p.maximum());	
		} 

	   @Test
	   public void testSuccessor() {
			NodeTest.assertSame(d, a.successor());	
			NodeTest.assertSame(f, d.successor());	
			NodeTest.assertSame(h, f.successor());	
			NodeTest.assertSame(i, h.successor());	
			NodeTest.assertSame(k, i.successor());	
			NodeTest.assertSame(l, k.successor());	
			NodeTest.assertSame(m, l.successor());	
			NodeTest.assertSame(p, m.successor());	
			NodeTest.assertNull(p.successor());	
		} 

	   @Test
	   public void testPredecessor() {
			NodeTest.assertSame(a, d.predecessor());	
			NodeTest.assertSame(d, f.predecessor());	
			NodeTest.assertSame(f, h.predecessor());	
			NodeTest.assertSame(h, i.predecessor());	
			NodeTest.assertSame(i, k.predecessor());	
			NodeTest.assertSame(k, l.predecessor());	
			NodeTest.assertSame(l, m.predecessor());	
			NodeTest.assertSame(m, p.predecessor());	
			NodeTest.assertNull(a.predecessor());	
		};

		@Test
		public void isSmaller() {
			NodeTest.assertTrue(a.isSmaller());
			NodeTest.assertTrue(d.isSmaller());
			NodeTest.assertFalse(f.isSmaller());
			NodeTest.assertFalse(h.isSmaller());
			NodeTest.assertFalse(i.isSmaller());
			NodeTest.assertTrue(k.isSmaller());
			NodeTest.assertFalse(l.isSmaller());
			NodeTest.assertFalse(m.isSmaller());
			NodeTest.assertFalse(p.isSmaller());
		};
		
		@Test
		public void isLarger() {
			NodeTest.assertTrue(a.isLarger());
			NodeTest.assertTrue(d.isLarger());
			NodeTest.assertTrue(f.isLarger());
			NodeTest.assertTrue(h.isLarger());
			NodeTest.assertTrue(i.isLarger());
			NodeTest.assertTrue(k.isLarger());
			NodeTest.assertTrue(l.isLarger());
			NodeTest.assertTrue(m.isLarger());
			NodeTest.assertTrue(p.isLarger());
		};

		@Test
		public void testSize() {
			NodeTest.assertEquals(1, a.size());
			NodeTest.assertEquals(4, d.size());
			NodeTest.assertEquals(2, f.size());
			NodeTest.assertEquals(1, h.size());
			NodeTest.assertEquals(9, i.size());
			NodeTest.assertEquals(1, k.size());
			NodeTest.assertEquals(4, l.size());
			NodeTest.assertEquals(2, m.size());
			NodeTest.assertEquals(1, p.size());
		};
		
		@Test
		public void testIsLeafNode() {
			NodeTest.assertTrue(a.isLeaf());
			NodeTest.assertFalse(d.isLeaf());
		}

		@Test
		public void testEqual() {
		    Node<String> aa =new Node<String>("A");
		    Node<String> hh =new Node<String>("H");
		    Node<String> kk =new Node<String>("K");
		    Node<String> pp =new Node<String>("P");
		    Node<String> ff =new Node<String>("F", null, hh);
		    Node<String> mm =new Node<String>("M", null, pp);
		    Node<String> dd =new Node<String>("D", aa, ff);
		    Node<String> ll =new Node<String>("L", kk, mm);
		    Node<String> ii =new Node<String>("I", dd, ll);

		    NodeTest.assertEquals(a, aa);
		    NodeTest.assertEquals(d, dd);
		    NodeTest.assertEquals(f, ff);
		    NodeTest.assertEquals(h, hh);
		    NodeTest.assertEquals(i, ii);
		    NodeTest.assertEquals(k, kk);
		    NodeTest.assertEquals(l, ll);
		    NodeTest.assertEquals(m, mm);
		    NodeTest.assertEquals(p, pp);
		    
		    NodeTest.assertFalse(i.equals(null));
		    NodeTest.assertFalse(f.equals(d));
			
		}
		   
}
