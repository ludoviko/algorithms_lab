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

	public int getRootOld(int p) {
		this.validate(p);

		while (this.array[p] != p) {
			p = this.array[p];
		}

		return p;
	}

    /**
     * <p>Method for finding the root of a given note.</p>
     *
     * <p>The search is done recursively.
     * For each node traversed path compression is applied.
     *
     * Return the index of the root node.</p>
     *
     * @param p: the index of the queried note.
     * @return the root of the given note.
     */
	public int getRoot(int p) {
        this.validate(p);

		if ( p == this.array[p] ) {
			return p;
		} else {
            int root = getRoot(this.array[p]);
            // Path compression.
            array[p] = root;
            return root;
		}
	}

	// Validate that p is a valid index
	private void validate(int p) {
		if (p < 0 || p >= array.length) {
			throw new IndexOutOfBoundsException("index " + p
					+ " is not between 0 and " + array.length);
		}
	}


}
