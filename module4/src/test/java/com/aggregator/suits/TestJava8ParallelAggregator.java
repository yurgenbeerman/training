package com.aggregator.suits;

import com.aggregator.duplicates.impl.Java8ParallelAggregatorDuplicatesTest;
import com.aggregator.sum.impl.Java8ParallelAggregatorSumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.aggregator.frequency.impl.Java8ParallelAggregatorFrequencyTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Java8ParallelAggregatorFrequencyTest.class,
        Java8ParallelAggregatorSumTest.class,
        Java8ParallelAggregatorDuplicatesTest.class,
})
public class TestJava8ParallelAggregator {
}
