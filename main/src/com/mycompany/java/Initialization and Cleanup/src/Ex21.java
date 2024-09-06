public class Ex21 {
    public enum Currency {
        VND, DOLLAR, NDT, Pounds
    }

    public static void main(String[] args) {
        for (Currency currency : Currency.values()) {
            
            System.out.println("Currency: " + currency + ", Ordinal: " + currency.ordinal());
        }
    }
}
