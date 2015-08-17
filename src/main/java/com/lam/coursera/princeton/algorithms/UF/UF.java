package com.lam.coursera.princeton.algorithms.UF;

public class UF implements UnionFind_I {
	private int[]	array;

	public UF(int n) {
		this.array = new int[n];
		for (int i = 0; i < n; i++) {
			this.array[i] = i;
		}

	}

	public void union(int p, int q) {
		if (!areConnected(p, q)) {
			this.array[this.getRoot(p)] = this.getRoot(q);
		}

	}

	public boolean areConnected(int p, int q) {
		return this.getRoot(p) == this.getRoot(q);
	}

	public int size() {
		return 0;
	}

	public int getRoot(int p) {
		this.validate(p);
		while (this.array[p] != p) {
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


}
