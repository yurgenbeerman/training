package com.aggregator.frequency.impl;

import com.aggregator.Java8Aggregator;
import com.aggregator.frequency.JavaAggregatorFrequencyTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java8AggregatorFrequencyTest extends JavaAggregatorFrequencyTest {

    public Java8AggregatorFrequencyTest() {
        super(new Java8Aggregator());
    }
}

