//Create a class with a String field that is initialized(khoi tao) at the point of
//definition, and another one that is initialized by the constructor. What is the difference
//between the two approaches
public class Ex2 {
    //khoi tao tai dinh nghia
    String a = "dinh nghia";

    //khoi tao string trong constructo(phuong thuc)
    String b;

    //Constructor
    public Ex2(){
        b = "Constructor";
    }

    public static void main(String[] args) {
        Ex2 ex2 = new Ex2();
        System.out.println("a: " + ex2.a);
        System.out.println("b: " + ex2 .b);
    }
}
//khoi tao tai dinh nghia la khi minh khoi tao ra thi no co luon gtri do
//khoi tao = constructor thi khi constructor dc goi thi gia tri moi dc gan bien
/*
* Khởi tạo tại điểm định nghĩa là cách nhanh chóng để gán giá trị mặc định cho một biến,
* khởi tạo trong constructor linh hoạt hơn vì có thể sử dụng tham số hoặc logic phức tạp để xác định giá trị ban đầu cho biến.
* */