package com.algorithms.searchString.test;

import junit.framework.TestCase;

import org.junit.Ignore;

import com.algorithms.searchString.StringMatch;
import com.algorithms.searchString.StringSearcher;

/**
 * Abstract base class for testing implementations of {@link StringMatch}.
 *
 */
@Ignore
public abstract class AbstractStringSearcherTestCase extends TestCase {
    protected abstract StringSearcher createSearcher(CharSequence pattern);

    public void testNotFoundInAnEmptyText() {
        StringSearcher searcher = this.createSearcher("NOT FOUND");

        assertNull(searcher.search("", 0));
    }

    public void testFindAtTheStart() {
        String text = "Find me at the start";
        String pattern = "Find";

        StringSearcher searcher = this.createSearcher(pattern);

        StringMatch match = searcher.search(text, 0);
        assertNotNull(match);
        assertEquals(text, match.getText());
        assertEquals(pattern, match.getPattern());
        assertEquals(0, match.getIndex());

        assertNull(searcher.search(text, match.getIndex() + 1));
    }

    public void testFindAtTheEnd() {
        String text = "Find me at the end";
        String pattern = "end";

        StringSearcher searcher = this.createSearcher(pattern);

        StringMatch match = searcher.search(text, 0);
        assertNotNull(match);
        assertEquals(text, match.getText());
        assertEquals(pattern, match.getPattern());
        assertEquals(15, match.getIndex());

        assertNull(searcher.search(text, match.getIndex() + 1));
    }

    public void testFindInTheMiddle() {
        String text = "Find me in the middle of the text";
        String pattern = "middle";

        StringSearcher searcher = this.createSearcher(pattern);

        StringMatch match = searcher.search(text, 0);
        assertNotNull(match);
        assertEquals(text, match.getText());
        assertEquals(pattern, match.getPattern());
        assertEquals(15, match.getIndex());

        assertNull(searcher.search(text, match.getIndex() + 1));
    }

    public void testFindOverlapping() {
        String text = "abcdefffff-fedcba";
        String pattern = "fff";

        StringSearcher searcher = this.createSearcher(pattern);

        StringMatch match = searcher.search(text, 0);
        assertNotNull(match);
        assertEquals(text, match.getText());
        assertEquals(pattern, match.getPattern());
        assertEquals(5, match.getIndex());

        match = searcher.search(text, match.getIndex() + 1);
        assertNotNull(match);
        assertEquals(text, match.getText());
        assertEquals(pattern, match.getPattern());
        assertEquals(6, match.getIndex());

        match = searcher.search(text, match.getIndex() + 1);
        assertNotNull(match);
        assertEquals(text, match.getText());
        assertEquals(pattern, match.getPattern());
        assertEquals(7, match.getIndex());

        assertNull(searcher.search(text, match.getIndex() + 1));
    }
}
