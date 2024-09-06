public class Ex9 {
    //Hàm tạo 1
    public Ex9(){
        this("huy");
    }
    public Ex9(String message){
        System.out.println("Ham tao 2");
        System.out.println(message);
    }

    public static void main(String[] args) {
        Ex9 obj = new Ex9();
    }
}
