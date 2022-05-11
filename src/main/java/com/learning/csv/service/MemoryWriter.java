package com.learning.csv.service;

public class MemoryWriter implements Writer {

    private static String shouldBeenWritten = "";


    @Override
    public void write(String str) {
        shouldBeenWritten += str;
    }

    public String getShouldBeenWritten() {
        return shouldBeenWritten;
    }


}
