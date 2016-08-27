package com.algorithms.graph.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

// See http://codeforces.com/blog/entry/18423 .
//Source: Grooking Algorithms, page 107.

public class DijkstraAlgorithm {
	// Costs from a given node to other nodes.
	private Map<String, Map<String, Integer>> mapNodeWeights;
	// Costs from root.
	private Map<String, Integer> costs;
	private Map<String, String> parents;
	private List<String> processedNodes;

	public DijkstraAlgorithm() {
		this.mapNodeWeights = new HashMap<String, Map<String, Integer>>();
		this.costs = new HashMap<String, Integer>();
		this.parents = new HashMap<String, String>();
		this.processedNodes = new LinkedList<String>();
	}

	public void addToMap(String key, Map<String, Integer> nodeWeight) {
		this.mapNodeWeights.put(key, nodeWeight);
	}

	public void addProcessed(String node) {
		this.processedNodes.add(node);
	}

	/**
	 * The cost it takes to get to that node from the root.
	 * 
	 * @param node
	 *            : the node destination.
	 * @param value
	 *            : the cost it takes to get to from root.
	 */
	public void addCost(String node, Integer value) {
		this.costs.put(node, value);
	}

	public void addParent(String node, String parent) {
		this.parents.put(node, parent);
	}

	private String findLowestCostNode() {
		String s = null;
		Integer min = Integer.MAX_VALUE;

		for (String key : costs.keySet()) {
			if (costs.get(key) != null && !this.processedNodes.contains(key)) {
				if (costs.get(key) < min) {
					min = costs.get(key);
					s = key;
				}
			}
		}

		return s;
	}
	
	public Integer find() {
		String node = findLowestCostNode();
		Integer cost;
		Integer fullCost;
		Map<String, Integer> neighbours;

		while (node != null) {
			cost = costs.get(node);
			neighbours = mapNodeWeights.get(node);
			if (neighbours != null) {

				for (String key : neighbours.keySet()) {
					fullCost = neighbours.get(key) + cost;
					if ( costs.get(key) == null || costs.get(key) > fullCost) {
						// Update the costs for that neighbour node.
						costs.put(key, fullCost);
						// Update the parents map.
						parents.put(key, node);
					}
				}

				this.processedNodes.add(node);
				node = findLowestCostNode();
			} else {
				processedNodes.add(node);
				node = null;
			}
		}

		return this.costs.get(this.processedNodes.get(this.processedNodes.size() - 1));
	}

	public static void main(String[] strings) {
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();

		Map<String, Integer> weights = new HashMap<String, Integer>();
		weights.put("a", 6);
		weights.put("b", 2);
		dijkstra.addToMap("root", weights);

		weights = new HashMap<String, Integer>();
		weights.put("end", 1);
		dijkstra.addToMap("a", weights);

		weights = new HashMap<String, Integer>();
		weights.put("a", 3);
		weights.put("end", 5);
		dijkstra.addToMap("b", weights);

		dijkstra.addToMap("end", null);

		dijkstra.addCost("a", 6);
		dijkstra.addCost("b", 2);
		dijkstra.addCost("end", null);

		dijkstra.addParent("a", "root");
		dijkstra.addParent("b", "root");
		dijkstra.addParent("end", null);
		dijkstra.addParent("start", null);

		System.out.println();
		System.out.println(dijkstra.find());


		//
		dijkstra = new DijkstraAlgorithm();
		
		weights = new HashMap<String, Integer>();
		dijkstra.addToMap("root", weights);
		weights.put("a", 5);
		weights.put("c", 2);

		weights = new HashMap<String, Integer>();
		dijkstra.addToMap("a", weights);
		weights.put("b", 4);
		weights.put("d", 2);

		weights = new HashMap<String, Integer>();
		dijkstra.addToMap("c", weights);
		weights.put("a", 8);
		weights.put("d", 7);
		
		weights = new HashMap<String, Integer>();
		dijkstra.addToMap("b", weights);
		weights.put("end", 3);
		weights.put("d", 6);

		weights = new HashMap<String, Integer>();
		dijkstra.addToMap("d", weights);
		weights.put("end", 1);
	
		dijkstra.addToMap("end", null);

		dijkstra.addCost("a", 5);
		dijkstra.addCost("c", 2);
		dijkstra.addCost("b", null);
		dijkstra.addCost("d", null);
		dijkstra.addCost("end", null);

		dijkstra.addParent("a", "root");
		dijkstra.addParent("c", "root");
		dijkstra.addParent("b", null);
		dijkstra.addParent("d", null);
		dijkstra.addParent("end", null);
		dijkstra.addParent("start", null);

		System.out.println();
		System.out.println(dijkstra.find());

		// 
		dijkstra = new DijkstraAlgorithm();
		
		weights = new HashMap<String, Integer>();
		dijkstra.addToMap("root", weights);
		weights.put("a", 10);

		weights = new HashMap<String, Integer>();
		dijkstra.addToMap("a", weights);
		weights.put("c", 20);

		weights = new HashMap<String, Integer>();
		dijkstra.addToMap("c", weights);
		weights.put("end", 30);
		weights.put("b", 1);
		
		weights = new HashMap<String, Integer>();
		dijkstra.addToMap("b", weights);
		weights.put("a", 1);
	
		dijkstra.addToMap("end", null);

		dijkstra.addCost("a", 10);
		dijkstra.addCost("c", null);
		dijkstra.addCost("b", null);
		dijkstra.addCost("end", null);

		dijkstra.addParent("a", "root");
		dijkstra.addParent("c", "root");
		dijkstra.addParent("b", null);
		dijkstra.addParent("end", null);
		dijkstra.addParent("start", null);

		System.out.println();
		System.out.println(dijkstra.find());

      // 6, 8, 60.
	}
}
