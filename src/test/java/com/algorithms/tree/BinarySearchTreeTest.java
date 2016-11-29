package com.algorithms.tree;

import java.util.Comparator;

import junit.framework.TestCase;

import org.junit.Ignore;
import org.junit.Test;

import com.algorithms.sortStd.comparator.NaturalComparator;

@Ignore
public class BinarySearchTreeTest extends TestCase {

	private Node<String> a;
	private Node<String> d;
	private Node<String> f;
	private Node<String> h;
	private Node<String> i;
	private Node<String> k;
	private Node<String> l;
	private Node<String> m;
	private Node<String> p;
	
    private Node<String> root;
	
	private BinarySearchTree<String> tree;
	
	@SuppressWarnings("unchecked")
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.a = new Node<String>("A");
		this.h = new Node<String>("H");
		this.k = new Node<String>("K");
		this.p = new Node<String>("P");
		this.f = new Node<String>("F", null, this.h);
		this.m = new Node<String>("M", null, this.p);
		this.d = new Node<String>("D", this.a, this.f);
		this.l = new Node<String>("L", this.k, this.m);
		this.i = new Node<String>("I", this.d, this.l);
        this.root = this.i;		
        
        this.tree = new BinarySearchTree<String>((Comparator<String>) NaturalComparator.INSTANCE);
        this.tree.insert(this.i.getValue());
        this.tree.insert(this.d.getValue());
        this.tree.insert(this.l.getValue());
        this.tree.insert(this.a.getValue());
        this.tree.insert(this.f.getValue());
        this.tree.insert(this.k.getValue());
        this.tree.insert(this.m.getValue());
        this.tree.insert(this.h.getValue());
        this.tree.insert(this.p.getValue());
  }

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	    this.a = this.h = this.k = this.p = this.f = this.m = this.d = this.l = this.i = this.root = null;
	    this.tree = null;
	}

	@Test
	public void testInsert() {
		BinarySearchTreeTest.assertEquals("Error ", this.root, this.tree.getRoot());
	};
	
	@Test
	public void testSearch() {
		BinarySearchTreeTest.assertEquals("Error ", this.a, this.tree.search(this.a.getValue()));
		BinarySearchTreeTest.assertEquals("Error ", this.d, this.tree.search(this.d.getValue()));
		BinarySearchTreeTest.assertEquals("Error ", this.f, this.tree.search(this.f.getValue()));
		BinarySearchTreeTest.assertEquals("Error ", this.h, this.tree.search(this.h.getValue()));
		BinarySearchTreeTest.assertEquals("Error ", this.i, this.tree.search(this.i.getValue()));
		BinarySearchTreeTest.assertEquals("Error ", this.k, this.tree.search(this.k.getValue()));
		BinarySearchTreeTest.assertEquals("Error ", this.l, this.tree.search(this.l.getValue()));
		BinarySearchTreeTest.assertEquals("Error ", this.m, this.tree.search(this.m.getValue()));
		BinarySearchTreeTest.assertEquals("Error ", this.p, this.tree.search(this.p.getValue()));
		
		BinarySearchTreeTest.assertNull(this.tree.search("Unknown"));
	};
	
	@Test
	public void testDeleteLeafNode() {
		Node<String> deleted = this.tree.delete(this.h.getValue());
		BinarySearchTreeTest.assertNotNull(deleted);
		BinarySearchTreeTest.assertEquals(this.h.getValue(), deleted.getValue());
		BinarySearchTreeTest.assertEquals(this.h, deleted);
		
		this.f.setLarger(null);
		BinarySearchTreeTest.assertEquals("Error ", this.root, this.tree.getRoot());
	}

	@Test
	public void testDeleteNodeWithOneChild() {
		Node<String> deleted = this.tree.delete(this.m.getValue());
		BinarySearchTreeTest.assertNotNull(deleted);
		BinarySearchTreeTest.assertEquals(this.m.getValue(), deleted.getValue());
		this.l.setLarger(this.p);
		BinarySearchTreeTest.assertEquals("Error ", this.root, this.tree.getRoot());
	}

	@Test
	public void testDeleteNodeWithTwoChildren() {
		Node<String> deleted = this.tree.delete(this.i.getValue());
		BinarySearchTreeTest.assertNotNull(deleted);
		BinarySearchTreeTest.assertEquals(this.i.getValue(), deleted.getValue());
		this.root.setValue(this.k.getValue());
		this.l.setSmaller(null);
		this.l.setParent(this.k);
		BinarySearchTreeTest.assertEquals("Error ", this.root, this.tree.getRoot());
	}
//	
//	@Test
//	public void testDeleteRootNodeUntilTreeIsEmpty() {
//       while (tree.getRoot() != null) {
//    	   Object key = tree.getRoot().getValue();
//    	   Node<String> deleted = tree.delete(key);
//   		   BinarySearchTreeTest.assertNotNull(deleted);
//   		   BinarySearchTreeTest.assertEquals(key, deleted.getValue());
//    	   
//       };
//	}
	
}
