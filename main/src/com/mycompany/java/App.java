package com.mycompany.java;

public class App {
    public static void main(String[] args) {
        Book myBook = new Book("Huy", "DucHuy", 74);
        System.out.println("Book title: " + myBook.title);
        System.out.println("Author: " + myBook.author);
        System.out.println("Number Page: " + myBook.numPages);

        NNCollection collection = new NNCollection();

        collection.insert(new NameNumber("Huy", "23010298"));
        collection.insert(new NameNumber("Nguyen", "12345678"));
        System.out.println("Huy number: " + collection.findNumber("Huy"));
        System.out.println("Nguyen number: " + collection.findNumber("Nguyen"));

        Recursion recursion = new Recursion();
        System.out.println("Factorial: " + recursion.factorial(4));
        System.out.println("Hello");
        Time time = new Time(7, 40, 45);
        System.out.println("Time: " + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());
        
    }
}
