public class PassObject {

    static void f(Number m){ 
        // giá trị 15 cho thuộc tính 'i' của đối tượng m
        m.i = 15;
    }
    public static void main(String[] args) {
        //Tạo đối tượng number
        Number n = new Number();

        // Gán giá trị 14 cho thuộc tính 'i' của đối tượng n
        n.i = 14;

        // Gọi phương thức 'f' và truyền đối tượng n vào
        f(n); //n.i = 15

        // In giá trị của thuộc tính 'i' của đối tượng n ra màn hình
        System.out.println(n.i);
    }
}