package Ex18;

public class Main {
    public static void main(String[] args) {
        FinalFields obj1 = new FinalFields(5);
        FinalFields obj2 = new FinalFields(15);

        System.out.println("Obj1- Static-final-field: " + obj1.STATIC_FINAL_FIELD);
        System.out.println("Obj2 - instanceFinalField: " + obj1.instanceFinalField);

        System.out.println("Object 2 - STATIC_FINAL_FIELD: " + obj2.STATIC_FINAL_FIELD);
        System.out.println("Object 2 - instanceFinalField: " + obj2.instanceFinalField);

        // Kiểm tra truy cập trực tiếp qua class
        System.out.println("Access STATIC_FINAL_FIELD directly from class: " + FinalFields.STATIC_FINAL_FIELD);
    }
}

/*
* STATIC_FINAL_FIELD có cùng giá trị cho cả hai đối tượng (10), chứng tỏ rằng nó được chia sẻ giữa các đối tượng và không thay đổi.
instanceFinalField có giá trị khác nhau (5 cho obj1 và 15 cho obj2),
*  cho thấy rằng trường final này là thuộc về mỗi đối tượng và có thể được khởi tạo khác nhau cho từng đối tượng.
* */

/*
static final: Là một hằng số thuộc về class, dùng chung cho tất cả các đối tượng và không thể thay đổi sau khi được khởi tạo.
final: Là một hằng số thuộc về đối tượng, phải được khởi tạo cho mỗi đối tượng riêng biệt và có thể có giá trị khác nhau cho từng đối tượng.
* */
