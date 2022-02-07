package com.aggregator.suits;

import com.aggregator.duplicates.impl.Java7ParallelAggregatorDuplicatesTest;
import com.aggregator.sum.impl.Java7ParallelAggregatorSumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.aggregator.frequency.impl.Java7ParallelAggregatorFrequencyTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Java7ParallelAggregatorFrequencyTest.class,
        Java7ParallelAggregatorSumTest.class,
        Java7ParallelAggregatorDuplicatesTest.class,
})
public class TestJava7ParallelAggregator {
}
