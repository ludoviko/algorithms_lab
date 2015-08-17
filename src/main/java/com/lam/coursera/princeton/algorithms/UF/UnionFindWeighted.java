package com.lam.coursera.princeton.algorithms.UF;

import java.util.Arrays;


// XXX Add java docs
public class UnionFindWeighted implements UnionFind_I {
	private int[] array;
	private int[] deepness;
    
	public UnionFindWeighted(int n) {
		this.array = new int[n];
		for (int i = 0; i < n; i++) {
			this.array[i] = i;
		}

		this.deepness = new int[n];
		Arrays.fill(this.deepness, 1);
	}

	// Link the root of the smaller tree to the root of the larger one if not
	// linked between them.
	public void union(int p, int q) {
		if (!areConnected(p, q)) {

			int rootP = this.getRoot(p);
			int rootQ = this.getRoot(q);

			if (this.deepness[q] <= this.deepness[p]) {
				this.array[rootQ] = rootP;
				deepness[rootP] += deepness[rootQ];
			} else {
				this.array[rootP] = rootQ;
				deepness[rootQ] += deepness[rootP];
			}

		}
	}

	public boolean areConnected(int p, int q) {
		return this.getRoot(p) == this.getRoot(q);
	}

//	public int size() {
//		return 0;
//	}

	public int getRoot(int p) {
		this.validate(p);

		while (this.array[p] != p) {
			this.array[p] = this.array[this.array[p]];
			p = this.array[p];
		}

		return p;
	}

	// validate that p is a valid index
	private void validate(int p) {
		if (p < 0 || p >= array.length) {
			throw new IndexOutOfBoundsException("index " + p
					+ " is not between 0 and " + array.length);
		}
	}

//	public int getFreeNodes() {
//		return freeNodes;
//	}

}
