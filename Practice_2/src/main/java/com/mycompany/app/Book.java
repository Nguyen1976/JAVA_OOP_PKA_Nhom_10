public class Book {
    String title;
    String author;
    int numPages;

    Book() {
    }; // default constructor

    public Book(String t, String a, int p) {
        title = t;
        author = a;
        numPages = p;
    }

    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Number of Pages: " + numPages;
    }

    public static void main(String[] args) {
        Book myObj = new Book("a", "b", 2); // New book
        System.out.println(myObj);
    }
}