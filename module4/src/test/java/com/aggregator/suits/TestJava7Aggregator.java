package com.aggregator.suits;

import com.aggregator.duplicates.impl.Java7AggregatorDuplicatesTest;
import com.aggregator.sum.impl.Java7AggregatorSumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.aggregator.frequency.impl.Java7AggregatorFrequencyTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Java7AggregatorFrequencyTest.class,
        Java7AggregatorSumTest.class,
        Java7AggregatorDuplicatesTest.class,
})
public class TestJava7Aggregator {
}
