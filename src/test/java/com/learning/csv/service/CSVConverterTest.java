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

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CSVConverterTest {
    private static final Interaction INTERACTION = new Interaction("1", Time.valueOf(LocalTime.now().minusHours(1)),
            Time.valueOf(LocalTime.now()), "src/java/com/learning",
            "HP", List.of("1", "2", "3"));
    private static final Person ANTOHA = new Person(1, "Antoha", "MC", 15);
    private static final Person MAX = new Person(2, "Max", "Last", 43);
    private static final Person VICTOR = new Person(3, "Victor", "Shtil", 32);
    String expectedPersonHeader = "id,firstName,lastName,age";
    String expectedInteractionHeader = "id,startTime,stopTime,archivingLocation,initiator,participants";
    List<Interaction> list;
    Converter<Interaction> interactionConverter = new CSVConverter<>(new CSVWriter());
    Converter<Person> personConverter = new CSVConverter<>(new CSVWriter());

    @Test
    void throwExceptionIfListIsEmpty() {

        list = List.of();
        assertAll(
                () -> {
                    var exception = assertThrows(NullPointerException.class, () -> interactionConverter.convert(list.toArray(list.toArray(new Interaction[0]))));
                    assertThat(exception.getMessage()).isEqualTo("List is Empty!");
                    assertEquals("List is Empty!", exception.getMessage());
                }
        );

    }

    @Test
    @Disabled
    void CheckInteractionHeader() {

        list = List.of(new Interaction());

        interactionConverter.convert(list.toArray(list.toArray(new Interaction[0])));

//        assertEquals(expectedInteractionHeader, actualHeader);
    }
    @Test
    void CheckPersonHeader() {

        List<Person> listPerson = List.of(new Person());

        personConverter.convert(listPerson.toArray(listPerson.toArray(new Person[0])));

//        assertEquals(expectedPersonHeader, actualHeader);
    }
//
    @Test
    void CheckDataIfAddedAnEmptyItem() {

        String str = expectedInteractionHeader + "\n"
                + new Interaction() + "\n";

        list = List.of(new Interaction());
//        assertEquals(str, interactionConverter.convert(list.toArray(list.toArray(new Interaction[0]))));
    }
    @Test
    void CheckDataIfAddedAnItem() {

        String str = expectedInteractionHeader + "\n"
                + INTERACTION + "\n";

        list = List.of(INTERACTION);
//        assertEquals(str, interactionConverter.convert(list));
    }
//
    @Test
    void CheckDataIfAddedTwoItems() {

        String str = expectedInteractionHeader + "\n"
                + INTERACTION + "\n"
                + new Interaction() + "\n";

        list = List.of(INTERACTION, new Interaction());
//        assertEquals(str, interactionConverter.convert(list));
    }
//
    @Test
    void CheckDataIfAddedMoreThenTwoItems() {

        String str = expectedInteractionHeader + "\n"
                + INTERACTION + "\n"
                + new Interaction() + "\n"
                + new Interaction() + "\n"
                + new Interaction() + "\n";

        list = List.of(INTERACTION,
                new Interaction(),
                new Interaction(),
                new Interaction());
//        assertEquals(str, interactionConverter.convert(list));
    }
//
    @Test
    void stringIfConvertOneElement() {

         personConverter.convert(ANTOHA);

        String expected = expectedPersonHeader + "\n"
                + ANTOHA + "\n";

//        assertEquals(expected, actual);
    }
//
    @Test
    void stringIfConvertElementWithEmptyFields() {
         personConverter.convert(new Person());
        String expected = expectedPersonHeader + "\n" +
                new Person() + "\n";

//        assertEquals(expected, actual);
    }
//
    @ParameterizedTest
    @CsvFileSource(resources = "/test.csv", delimiter = ',', numLinesToSkip = 1)
    void stringIfConvertFewElement(int id, String name, String surname, int age) {

        Person anton = new Person(1, "Antoha", "MC", 15);
        Person antoha = new Person(id, name, surname, age);

//        Converter<Person> personConverter = new CSVConverter<>(new CSVWriter("src/test/resources/test.csv"));
//        personConverter.convert(anton);


        assertEquals(anton, antoha);
    }



}