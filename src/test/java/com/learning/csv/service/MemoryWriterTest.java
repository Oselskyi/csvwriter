package com.learning.csv.service;

import com.learning.csv.Collector;
import com.learning.csv.entity.Interaction;
import com.learning.csv.entity.Person;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryWriterTest {

    MemoryWriter memoryWriter = new MemoryWriter();

    Converter<Interaction> interactionConverter = new CSVConverter<>(new MemoryWriter());
    Converter<Person> personConverter = new CSVConverter<>(new MemoryWriter());
    String expectedInteractionHeader = "id,startTime,stopTime,archivingLocation,initiator,participants";
    String expectedPersonHeader = "id,firstName,lastName,age";
    List<Person> people = List.of(
            new Person(1, "Antoha", "MC", 15),
            new Person(2, "Max", "Last", 43),
            new Person(3, "Victor", "Shtil", 32));
    private static final Interaction INTERACTION = new Interaction("1", Time.valueOf(LocalTime.now().minusHours(1)),
            Time.valueOf(LocalTime.now()), "src/java/com/learning",
            "HP", List.of("1", "2", "3"));

    @Test
    void getStringIfEmptyParameters() {
        interactionConverter.convert();
        assertEquals("header is null because has no objects", memoryWriter.getShouldBeenWritten());
    }

    @Test
    void getStringIfWeWriteEmptyObject() {
        interactionConverter.convert(new Interaction());
        String str = expectedInteractionHeader + "\n"
                + new Interaction() + "\n";
        assertEquals(str, memoryWriter.getShouldBeenWritten());
    }

    @Test
    void getStringIfWeWriteAnObject() {
        interactionConverter.convert(INTERACTION);
        String str = expectedInteractionHeader + "\n"
                + INTERACTION + "\n";
        assertEquals(str, memoryWriter.getShouldBeenWritten());
    }

    @Test
    void getStringIfWeWriteFewObjects() {
        interactionConverter.convert(INTERACTION, new Interaction());
        String str = expectedInteractionHeader + "\n"
                + INTERACTION + "\n"
                + new Interaction() + "\n";
        assertEquals(str, memoryWriter.getShouldBeenWritten());
    }

    @Test
    void getStringIfWeWriteEmptyList() {
        personConverter.convert(new ArrayList<Person>().toArray(new Person[0]));
        String str = expectedPersonHeader + "\n"
                + new Person(1, "Antoha", "MC", 15) + "\n"
                + new Person(2, "Max", "Last", 43) + "\n"
                + new Person(3, "Victor", "Shtil", 32) + "\n";
        assertEquals("header is null because has no objects", memoryWriter.getShouldBeenWritten());
    }

    @Test
    void getStringIfWeWriteListWithOneObject() {
        personConverter.convert(List.of(new Person(1, "Antoha", "MC", 15)).toArray(new Person[0]));
        String str = expectedPersonHeader + "\n"
                + new Person(1, "Antoha", "MC", 15) + "\n";
        assertEquals(str, memoryWriter.getShouldBeenWritten());
    }

    @Test
    void getStringIfWeWriteListOfObjects() {
        personConverter.convert(people.toArray(new Person[0]));
        String str = expectedPersonHeader + "\n"
                + new Person(1, "Antoha", "MC", 15) + "\n"
                + new Person(2, "Max", "Last", 43) + "\n"
                + new Person(3, "Victor", "Shtil", 32) + "\n";
        assertEquals(str, memoryWriter.getShouldBeenWritten());
    }


}