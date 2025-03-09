package fr.ynov.java.medium;

import java.time.LocalDate;

public class Person {
    enum Nationality {
        BRITISH, FRENCH, AMERICAN, CANADIAN, CHINESE, GERMAN, JAPANESE;
    }

    private String name;
    private final LocalDate dateOfBirth;
    private String gender;
    private float height;
    private float weight;
    private Nationality nationality;

    public Person(String name, LocalDate dateOfBirth, String gender, float height, float weight, Nationality nationality) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.nationality = nationality;
    }

    public void showPerson() {
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
        System.out.println("Nationality: " + nationality);
    }

    public int getAge() {
        int year = this.dateOfBirth.getYear();
        int month = this.dateOfBirth.getMonthValue();
        int day = this.dateOfBirth.getDayOfMonth();
        LocalDate currentDate = LocalDate.now();
        return currentDate.compareTo(this.dateOfBirth);

    }

    public static void main(String[] args) {
        Person louis = new Person("Louis", LocalDate.of(2005, 1, 14), "Male", 1.80f, 65, Nationality.BRITISH);
        louis.showPerson();
        System.out.println(louis.getAge());
    }
}
    /*
    Class:
    A class defines an object in Java.
    It can contain attributes, methods, constructors.
    A class can be instantiated multiple times
     */

    /*
    Enum:
    An enum is a special class that represents a group of constants.
    Enums are used to define a set of predefined values.
    Enums are final.
    Each enum constant is a unique instance
     */

    /*
    Records are like classes, but they are made for holding immutable data.
    All fields of a record are final by default.
    Some methods are generated automatically, like equals(),toString().
     */

