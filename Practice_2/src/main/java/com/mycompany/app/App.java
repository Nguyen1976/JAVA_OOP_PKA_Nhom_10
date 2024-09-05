public class App {
    public static void main(String[] args) {
        // Tạo một đối tượng Book
        Book b1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 180);

        // In đối tượng b1, Java sẽ gọi phương thức toString()
        System.out.println(b1);
    }
}