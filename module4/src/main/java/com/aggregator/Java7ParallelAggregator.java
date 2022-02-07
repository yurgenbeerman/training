package com.aggregator;

import java.util.List;

import javafx.util.Pair;

public class Java7ParallelAggregator implements Aggregator {
    //TODO нужно реализовать как минимум первые 3 метода интерфейса
    @Override
    public int sum(List<Integer> numbers) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Pair<String, Long>> getMostFrequentWords(List<String> words, long limit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> getDuplicates(List<String> words, long limit) {
        throw new UnsupportedOperationException();
    }
}
