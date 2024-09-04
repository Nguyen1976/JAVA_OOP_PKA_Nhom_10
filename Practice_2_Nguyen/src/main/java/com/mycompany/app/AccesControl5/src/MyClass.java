
public class MyClass {
    // Các trường với các mức độ truy cập khác nhau
    public int publicField = 1;
    private int privateField = 2;
    protected int protectedField = 3;
    int packageAccessField = 4; // package-access, không có từ khóa

    // Các phương thức với các mức độ truy cập khác nhau
    public void publicMethod() {
        System.out.println("Public Method");
    }

    private void privateMethod() {
        System.out.println("Private Method");
    }

    protected void protectedMethod() {
        System.out.println("Protected Method");
    }

    void packageAccessMethod() {
        System.out.println("Package-Access Method");
    }
}