package Ex18;
/*
* Tạo một class với một trường (field) static final và một trường final.
Minh họa sự khác biệt giữa hai loại trường này
* */
public class FinalFields {
    // Trường static final: Chỉ khởi tạo một lần và dùng chung cho tất cả các đối tượng
    static final int STATIC_FINAL_FIELD = 10;

    // Trường final: Phải khởi tạo cho mỗi đối tượng riêng biệt
    final int instanceFinalField;

    public FinalFields(int value){
        this.instanceFinalField = value;// Trường final được khởi tạo tại đây
    }
}
