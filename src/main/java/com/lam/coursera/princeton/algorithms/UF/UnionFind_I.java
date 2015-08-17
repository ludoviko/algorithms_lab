package com.lam.coursera.princeton.algorithms.UF;

public interface UnionFind_I {

	void union(int p, int q);
	boolean areConnected(int p, int q);

	int getRoot(int p);
}
