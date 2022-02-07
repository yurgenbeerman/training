package com.aggregator.sum.impl;

import com.aggregator.Java8Aggregator;
import com.aggregator.sum.JavaAggregatorSumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java8AggregatorSumTest extends JavaAggregatorSumTest {

    public Java8AggregatorSumTest() {
        super(new Java8Aggregator());
    }
}

