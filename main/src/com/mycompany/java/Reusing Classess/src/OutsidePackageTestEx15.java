import Ex15.Base;

public class OutsidePackageTestEx15 {
    public static void main(String[] args) {
        Base base = new Base();
        // Không thể gọi phương thức protected từ ngoài package, sẽ gây lỗi biên dịch
       // base.protectedMethod(); // Uncomment dòng này sẽ gây lỗi biên dịch
    }
}
/*
* Phương thức protectedMethod() có phạm vi truy cập protected,
* nghĩa là chỉ có thể truy cập được từ các class trong cùng package hoặc từ các class con kế thừa.
* Bởi vì OutsidePackageTest không thuộc cùng package và không kế thừa từ Base,
* nó không thể truy cập được phương thức protectedMethod().
* */
