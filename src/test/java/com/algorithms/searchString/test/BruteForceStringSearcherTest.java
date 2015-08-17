package com.algorithms.searchString.test;

import org.junit.Ignore;

import com.algorithms.searchString.BruteForceStringSearcher;
import com.algorithms.searchString.StringSearcher;

/**
 * Concrete test class for {@link BruteForceStringSearcher}.
 *
 */
@Ignore
public class BruteForceStringSearcherTest extends AbstractStringSearcherTestCase {
    @Override
	protected StringSearcher createSearcher(CharSequence pattern) {
        return new BruteForceStringSearcher(pattern);
    }
}
