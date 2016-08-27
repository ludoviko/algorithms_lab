package com.algorithms.graph.bfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// Source: Grooking Algorithms, page 107.
// Breadth-first search.
public class BFS_PersonSeller {
	private Map<IPerson, List<IPerson>> mapNodes;
	private List<IPerson> searchedNodes;
	private Queue<IPerson> queue;

	public BFS_PersonSeller() {
		mapNodes = new HashMap<IPerson, List<IPerson>>();
		queue = new PriorityQueue<IPerson>();
		searchedNodes = new LinkedList<IPerson>();
	}

	private void addToQueue(List<IPerson> people) {
		for (IPerson p : people) {
			this.queue.offer(p);
		}
	}

	public void addToMap(IPerson key, List<IPerson> nodes) {
		this.mapNodes.put(key, nodes);
	}
	
	/**
	 * 
	 * @param root: The starting or root node.
	 * @return the person who is a seller.
	 */
	public IPerson findSeller(IPerson root) {
		IPerson p = null;
		this.addToQueue(mapNodes.get(root));

		while (!this.queue.isEmpty()) {
			IPerson next = this.queue.poll();

			if ( ! searchedNodes.contains(next)) {
				if (next.isSeller()) {
					p = next;
					break;
				} else {
					if (mapNodes.containsKey(next)) {
						this.addToQueue(mapNodes.get(next));
					}
				}
				searchedNodes.add(next);
			} else {
			}
		}
		return p;
	}
	
	public static void main(String[] strings) {
		BFS_PersonSeller bfs = new BFS_PersonSeller();
		
		IPerson main = new Person("Bruce Lee");
		IPerson bob = new Person("Bob");
		IPerson alice = new Person("Alice");
		IPerson claire = new Person("Claire");
		IPerson anuj = new Person("Anuj");
		IPerson peggy = new Person("Peggy");
//		Person tom = new Person("Thom");
		IPerson tom = new Person("Thom", true);
		IPerson jonny = new Person("Jonny");
		
		bfs.addToMap(main, Arrays.asList(bob, claire, alice));
		bfs.addToMap(bob, Arrays.asList(anuj, peggy));
		bfs.addToMap(alice, Arrays.asList(peggy));
		bfs.addToMap(claire, Arrays.asList(tom, jonny));
		
		IPerson seller = bfs.findSeller(main);
		// Thom expected.
		System.out.println(seller);
	}
}
