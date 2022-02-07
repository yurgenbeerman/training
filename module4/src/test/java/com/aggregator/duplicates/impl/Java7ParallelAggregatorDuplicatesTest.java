package com.aggregator.duplicates.impl;

import com.aggregator.Java7ParallelAggregator;
import com.aggregator.duplicates.JavaAggregatorDuplicatesTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java7ParallelAggregatorDuplicatesTest extends JavaAggregatorDuplicatesTest {

    public Java7ParallelAggregatorDuplicatesTest() {
        super(new Java7ParallelAggregator());
    }
}
