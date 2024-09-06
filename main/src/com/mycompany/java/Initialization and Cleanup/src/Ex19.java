public class Ex19 {
    //Phuong thuc nhan vararg kieu String
    static void printStrings(String...strings){
        for(String s : strings){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        // Truyền một danh sách các chuỗi phân cách bởi dấu phẩy
        printStrings("Hello", "World", "Java");

        // Truyền một mảng String[]
        String[] stringArray = {"Huy", "dep", "trai", "..."};
        printStrings(stringArray);
    }
}
//Phương thức printStrings nhận một vararg String... strings, cho phép truyền một hoặc nhiều chuỗi vào.
//Khi gọi printStrings với danh sách chuỗi hoặc mảng String[], cả hai cách đều hoạt động và in các phần tử ra màn hình.
