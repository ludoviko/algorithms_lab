package com.lam.coursera.princeton.algorithms.UF;

import com.lam.coursera.princeton.algorithms.UF.UnionFindWeighted;
import com.lam.coursera.princeton.algorithms.UF.UnionFind_I;

public class UnionFindWeightedTest extends
		UnionFindTestAbstract {

	@Override
	protected UnionFind_I createUF(int n) {
		return new UnionFindWeighted(n);
	}

}
