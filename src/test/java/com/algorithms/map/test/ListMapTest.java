package com.algorithms.map.test;

import com.algorithms.map.ListMap;
import com.algorithms.map.Map;

/**
 */
public class ListMapTest extends AbstractMapTestCase {
    protected Map createMap() {
        return new ListMap();
    }
}
