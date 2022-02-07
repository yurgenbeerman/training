package com.aggregator.suits;

import com.aggregator.duplicates.impl.Java8AggregatorDuplicatesTest;
import com.aggregator.sum.impl.Java8AggregatorSumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.aggregator.frequency.impl.Java8AggregatorFrequencyTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Java8AggregatorFrequencyTest.class,
        Java8AggregatorSumTest.class,
        Java8AggregatorDuplicatesTest.class,
})
public class TestJava8Aggregator {
}
