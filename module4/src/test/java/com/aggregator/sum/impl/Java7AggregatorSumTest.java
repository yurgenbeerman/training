package com.aggregator.sum.impl;

import com.aggregator.Java7Aggregator;
import com.aggregator.sum.JavaAggregatorSumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java7AggregatorSumTest extends JavaAggregatorSumTest {

    public Java7AggregatorSumTest() {
        super(new Java7Aggregator());
    }

}
