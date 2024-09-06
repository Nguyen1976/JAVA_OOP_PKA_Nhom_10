package Ex19;
//Blank final là một trường final không được khởi tạo tại thời điểm khai báo mà phải được khởi tạo bên trong mỗi constructor của class.
public class Ex19 {
    private int value;

    public Ex19(int value){
        this.value = value;
    }

    public void printValue(){
        System.out.println(value);
    }
}
