package com.aggregator.sum.impl;

import com.aggregator.Java7ParallelAggregator;
import com.aggregator.sum.JavaAggregatorSumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java7ParallelAggregatorSumTest extends JavaAggregatorSumTest {

    public Java7ParallelAggregatorSumTest() {
        super(new Java7ParallelAggregator());
    }
}
