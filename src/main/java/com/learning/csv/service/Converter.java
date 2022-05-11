package com.learning.csv.service;

import com.learning.csv.entity.ConverterEntity;

public interface Converter<T extends ConverterEntity>{
//    void convert(List<T> list);
    String convert(T... objects);
}
