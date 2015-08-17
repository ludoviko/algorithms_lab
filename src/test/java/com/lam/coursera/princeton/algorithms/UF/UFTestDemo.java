package com.lam.coursera.princeton.algorithms.UF;

import com.lam.coursera.princeton.algorithms.UF.UF;
import com.lam.coursera.princeton.algorithms.UF.UnionFind_I;


public class UFTestDemo extends UnionFindTestAbstract {

	@Override
	protected UnionFind_I createUF(int n) {
		return new UF(n);
	}

}
