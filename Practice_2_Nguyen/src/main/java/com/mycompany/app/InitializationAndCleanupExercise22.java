public class InitializationAndCleanupExercise22 {
    public enum Currency {
        VND, DOLLAR, NDT, RUBY, BANG_ANH
    }

    public static void main(String[] args) {
        for(Currency currency : Currency.values()) {
            switch(currency) {
                case VND:
                    System.out.println("Vietnamese Dong (VND)");
                    break;
                case DOLLAR:
                    System.out.println("Tien cua my");
                    break;
                case NDT:
                    System.out.println("Nhan dan te cua tau");
                    break;
                case RUBY:
                    System.out.println("Ngoai te ruby");
                    break;
                case BANG_ANH:
                    System.out.println("Bang anh");
                    break;
                default:
                    System.out.println("ERROR");
            }
        }
    }
}
