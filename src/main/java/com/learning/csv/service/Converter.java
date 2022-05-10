package com.learning.csv.service;

import com.learning.csv.entity.ConverterEntity;

import java.util.List;

public interface Converter<T extends ConverterEntity>{
//    void convert(List<T> list);
    void convert(T... objects);
}
