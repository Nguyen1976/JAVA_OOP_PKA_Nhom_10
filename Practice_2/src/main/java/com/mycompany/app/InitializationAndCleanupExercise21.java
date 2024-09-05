public class InitializationAndCleanupExercise21 {
    public enum Currency {
        VND, DOLLAR, NDT, RUBY, BANG_ANH
    }

    public static void main(String[] args) {
        for (Currency currency : Currency.values()) {
            
            System.out.println("Currency: " + currency + ", Ordinal: " + currency.ordinal());
        }
    }
}
//enum được định nghĩa bằng các từ khóa enum các giá trị của nó là các hằng số được khai bao trong enum và là chữ viết hoa
