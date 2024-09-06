public class Ex22 {
    public enum Currency {
        VND, DOLLAR, NDT, RUBY, BANG_ANH
    }

    public static void main(String[] args) {
        for(Currency currency : Currency.values()) {
            switch(currency) {
                case VND:
                    System.out.println("Tien Viet (VND)");
                    break;
                case DOLLAR:
                    System.out.println("Tien  my");
                    break;
                case NDT:
                    System.out.println("Nhan dan te cua tq");
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
