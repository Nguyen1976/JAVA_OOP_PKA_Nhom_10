public class Ex8 {
    public void method1(){
        method2();
        this.method2();
    }

    public void method2(){
        System.out.println("method 2");
    }

    public static void main(String[] args) {
        Ex8 obj = new Ex8();
        obj.method1();
    }
}
//Nó hoạt động giống nhau việc sử dụng this chỉ để chỉ rõ nó thuộc về đối tượng hiện tại
