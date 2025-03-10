# Java Training Exercises

## Introduction

This repository contains the exercises for the Java training. The aim is to discover the Java programming language and its features.
For each exercise, don't forget to create a main method to test/run your code.  

## Getting Started

1. Fork this project on Github (not on Gitea)
2. Clone the repository on your computer
3. Open the folder with your favorite IDE (IntelliJ IDEA, Eclipse, etc.) as a Java project
3. Add the code of the exercises in the corresponding package `fr.ynov.java.XXXX`
4. For each exercice you will need to add a `public static void main(String[] args)` method in the created class  
Note that is not the best practice, but it's easier for the training.

## Exercises - Easy

For all exercises, create a new Java class inside the `fr.ynov.java.easy` package.

### 1. Hello World

Create a simple Java program that prints "Hello, World!" to the console.
Add a class "HelloWorld" in the package.

### 2. Loops

Create a Java program that prints the numbers from 1 to 10 using a `for` loop. 
Add a class "For" in the package. 

Do the same using a `while` loop.  
Add a class "While" in the package.

Do the same using a `do while` loop.  
Add a class "DoWhile" in the package.

### 3. Arrays

Create a Java program that creates an array of integers and prints the elements of the array.  
- You can create an empty array with fixed length and put integers inside each index
- or you can create and instance an array with values directly

Add a class "Arrays" in the package.

Use standard for and modern for loops to print the elements of the array.

### 4. Scanners

Create a Java program that asks the user for his name and age and prints them.  
Add a class "ScanMe" in the package.

Create a Java program that asks the user for a number and prints if this number is even or odd.  
Add a class "EvenOrOdd" in the package.

### 5. Main args

Create a Java program that takes 2 number from main arguments, then use a Scanner to ask the user for an operator (+, -, *, /) and prints the result of the operation.  
Add a class "Calculator" in the package.

To run this program, you'll need to update your run configuration to add the arguments or running manually from the command line.
You can try to verify if the arguments are present before using them, verify their type, etc.

## Exercises - Medium

For all exercises, create a new Java class in the `fr.ynov.java.medium` package.

### 1. Methods

Create a Java program that contains a method that takes a number as a parameter and returns the square of this number.
Add a class "Square" in the package.

The method should be static.

Updates the program to read the number from the user OR from the arguments (you choose). Then call the method and print the result.

Reflexion: What is the difference between a static method and a non-static method?

### 2. Classes and Enum

Create a class `Person` with the following attributes:
- `name` (String)
- `age` (int)
- `gender` (String)
- `height` (float)
- `weight` (float)
- `nationality` (Enum)

Find the documentation about Enum and create a Nationality enum with data for at least 3 countries.
Create a constructor that takes all the attributes as parameters.  
Create a method that prints all the attributes of the person.  

Add a class "Person" in the package.

After that, commit and push before starting the next part of this exercise.  
Updates the `Person` class to remove the age attribute and add a `birthDate` attribute (Date).
Create a method that calculates the age of the person based on the birthdate.  
Hint: You can use LocalDate & Period for this.

Reflexion: Looks on the JavaDoc the Record class. What is the difference between a Record and a Class and a Enum?

### 3. Quality of Objects

Create a Java class `Quality` with the following attributes:
- `id` (int)
- `name` (String)

On a main class, create 2 Quality objects with the same id and name and compare them using the `==` operator, then using the `equals` method.

After that, override the `equals` and `hashCode` methods to ensure that two `Quality` objects are considered equal if they have the same `id` and `name`.

Add a class "Quality" in the package.

#### 4. Reading files

Create a Java program that reads a file and prints its content. The file must be created by yourself and contain some text.

Add a class "ReadFile" in the package.  

Update the methods to create a folder that contains multiples files and read all the files in the folder.

#### 5. Writing files

Create a Java program that reads a file and write its content in another file. The reading file must be created by yourself and contain some text. 
The output file must be created by the program, don't forget to close the file after writing.  

#### 6. Palindrome

Create a Java program that reads a word from the user and prints if this word is a palindrome or not.  
A palindrome is a word that reads the same backward as forward.  

Add a class "Palindrome" in the package.

#### 7. Rock Paper Scissors game

Create a Java program that plays the Rock Paper Scissors game.  
The program should ask the user to choose between Rock, Paper, and Scissors. 
Then the program should randomly choose one of the three options and print the result.  

Put all the classes (records, enums, classes, etc.) in the package `fr.ynov.java.game`.  

Try to separate the logic of the game from the main class. Use class attributes to store the game state. 

It can also be interested to have a Player class that contains the name and the score of the player. 
It can be useful to ask the user to enter his name at the beginning of the game.  

Write a beautiful code with comments, good structure, good naming methods, good visibility, etc.

Bonus : you can save the best score in a file and read it at the beginning of the game. Like a leaderboard.  

## Mini-Project - A car rental system

For this project, create your classes into the `fr.ynov.java.car` package.  
You should respect the Java naming conventions and the best practices (avoid public fields, use getters and setters when needed, etc.).  

Commit and push your code as soon as possible to keep track of your work (and avoid losing it).  
Use abstract classes, interfaces, enums, etc. when needed or when you think it's a good idea.

### 1. CarType Enum

Create an enum `CarType` that contains the following values:
- `SEDAN`
- `SUV`
- `SPORT`
- `TRUCK`
- `VAN`

### 2. Vehicle Class

Create a class `Vehicle` with the following attributes:
- `plate` (String)
- `brand` (String or Brand enum if you want to create it)
- `model` (String)
- `type` (CarType)
- `year` (int)

### 3. Car, Truck, Van, SportCar, Sedan, SUV Classes

Create classes that extend the `Vehicle` class for each type of vehicle. You should call a super constructor with the attributes of the vehicle.

### 4. Rentable Interface

Create an interface `Rentable` with the following methods:
- `double getDailyPrice()` that returns the daily price of the vehicle

Makes the `Vehicle` class implement the `Rentable` interface. This will force you to implement the `getDailyPrice` method in each concrete `Vehicle` class.

### 5. Renting System

Create a class `RentingSystem` that manages the renting of vehicles.

The class should contain a List of vehicles that can be rented (= fleet).

We should be able to manage the fleet of vehicles (add, remove, update) and rent a vehicle.

We should be able to display the list of available vehicles and the list of rented vehicles.

We should be able to rent a vehicle for a given number of days and calculate the total price of the rent.

In this class, you can create a main method to test your code (init the system, classes, adding vehicles, renting vehicles, etc.).

### 6. Advanced

Add a new Customer class that contains the name, the age, and the driver license of the customer.  
Each customer can rent a vehicle on given dates, but can only have 1 vehicle at a time.  
Add a method to the RentingSystem to rent a vehicle with a customer.  

For each vehicle, add a list of dates where the vehicle is rented.  
For each customer or given customer, be able to retrieve the list of rented vehicles and the total price of the rent. 
As each vehicle has it's plate, you can set a status for the vehicle (rented or not) and update it when the vehicle is rented.  
The system should not allow 2 vehicles to have the same plate.  

With Scanner, updates your main method (maybe it's preferable to create a new class for the main method) to display a menu to the user to interact with the system.  
The user should be able to add a vehicle, rent a vehicle, display the list of vehicles, etc.
