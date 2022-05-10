package com.learning.csv.service;

import com.learning.csv.entity.ConverterEntity;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVConverter<T extends ConverterEntity> implements Converter<T> {

    private final Writer writer;

    public CSVConverter(Writer writer) {
        this.writer = writer;
    }

//    @Override
//    public void convert(List<T> list) {
//
//        StringBuilder sb = new StringBuilder();
//        String header;
//
//        if (list.size() == 0) {
//            throw new NullPointerException("List is Empty!");
//        } else {
//            header = getHeader(list.get(0));
//        }
//
//        sb.append(header);
//        sb.append('\n');
//
//        for (T element :
//                list) {
//            sb.append(element);
//            sb.append('\n');
//        }
//        csvWriter.write(sb.toString());
//        //System.out.println(sb);
//
////        return sb.toString();
//    }

    @SafeVarargs
    @Override
    public final void convert(T... objects) {

        StringBuilder sb = new StringBuilder();

        if (objects.length == 0) {
            sb.append("header is null because has no objects");
        } else {
            sb.append(getHeader(objects[0]));
            sb.append('\n');
        }
        for (T element :
                objects) {
            sb.append(element);
            sb.append('\n');
        }
        writer.write(sb.toString());
    }

    private String getHeader(T obj) {

        Field[] fields = obj.getClass().getDeclaredFields();

        return Arrays.stream(fields)
                .map(Field::getName)
                .collect(Collectors.joining(","));
    }

}
