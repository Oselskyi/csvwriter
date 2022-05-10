package com.learning.csv.service;

import com.learning.csv.entity.Interaction;
import com.learning.csv.entity.Person;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVWriterTest {

    CSVWriter csvWriter;

    private static final Interaction INTERACTION = new Interaction("1", Time.valueOf(LocalTime.now().minusHours(1)),
            Time.valueOf(LocalTime.now()), "src/java/com/learning",
            "HP", List.of("1", "2", "3"));
    @Test
    void IsPathNotEmptyWhenWeWroteIt() {

        csvWriter = new CSVWriter("path");
        csvWriter.write("hello");
        assertFalse(csvWriter.path.isEmpty());
    }

    @Test
    @Disabled
    void returnedWriterWhenPathIsNotNull() {

        String expectedString = "Data has written into path";
        csvWriter = new CSVWriter("path");
        csvWriter.write("hello");

//        assertEquals(expectedString, csvWriter.write("hello"));
    }

    @Test
    void IsPathNullWhenWeWroteNothing() {

        csvWriter = new CSVWriter();
        csvWriter.write("hello");
        assertNull(csvWriter.path);
    }

    @Test
    void returnedWriterWhenPathIsNull() {

        String expectedString = "hello";
        csvWriter = new CSVWriter();
        csvWriter.write("hello");

//        assertEquals(expectedString);
    }

    @Test
    void IsFileCreateIfWritePath() {

        csvWriter = new CSVWriter("path.csv");
        csvWriter.write("hello");

        assertNotNull(csvWriter.writtenFile);
    }

    @Test
    void IsFileHasCorrectType() {

        csvWriter = new CSVWriter("path.csv");
        csvWriter.write("hello");

        String endPath = csvWriter.writtenFile.getAbsolutePath().split("\\.")[1];
        assertEquals("csv", endPath);
    }

    @Test
    void IsFileHasCorrectName() {

        csvWriter = new CSVWriter("path.csv");
        csvWriter.write("hello");

        boolean path = csvWriter.writtenFile.getAbsolutePath().endsWith("path.csv");

        assertTrue(path);
    }

//    @ParameterizedTest
////    @MethodSource("com.learning.junit.service.UserServiceTest#getArgumentsForLoginTest")
//    @CsvFileSource(resources = "/test.csv", delimiter = ',', numLinesToSkip = 1)
//    void loginParametrizedTest(String id, String startTime, String stopTime, String archivingLocation, String initiator,String participants) {
//String str =  id + "," +  startTime + "," + stopTime + "," + archivingLocation + "," + initiator + "," + participants;
//        assertEquals(str, INTERACTION.toString());
//
//    }

}