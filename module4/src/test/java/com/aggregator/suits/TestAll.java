package com.aggregator.suits;

import com.aggregator.duplicates.impl.Java7AggregatorDuplicatesTest;
import com.aggregator.duplicates.impl.Java7ParallelAggregatorDuplicatesTest;
import com.aggregator.duplicates.impl.Java8AggregatorDuplicatesTest;
import com.aggregator.duplicates.impl.Java8ParallelAggregatorDuplicatesTest;
import com.aggregator.sum.impl.Java7AggregatorSumTest;
import com.aggregator.sum.impl.Java7ParallelAggregatorSumTest;
import com.aggregator.sum.impl.Java8AggregatorSumTest;
import com.aggregator.sum.impl.Java8ParallelAggregatorSumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.aggregator.frequency.impl.Java7AggregatorFrequencyTest;
import com.aggregator.frequency.impl.Java7ParallelAggregatorFrequencyTest;
import com.aggregator.frequency.impl.Java8AggregatorFrequencyTest;
import com.aggregator.frequency.impl.Java8ParallelAggregatorFrequencyTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Java7AggregatorFrequencyTest.class,
        Java7AggregatorSumTest.class,
        Java7AggregatorDuplicatesTest.class,

        Java8AggregatorFrequencyTest.class,
        Java8AggregatorSumTest.class,
        Java8AggregatorDuplicatesTest.class,

        Java7ParallelAggregatorFrequencyTest.class,
        Java7ParallelAggregatorSumTest.class,
        Java7ParallelAggregatorDuplicatesTest.class,

        Java8ParallelAggregatorFrequencyTest.class,
        Java8ParallelAggregatorSumTest.class,
        Java8ParallelAggregatorDuplicatesTest.class,
})
public class TestAll {
}
