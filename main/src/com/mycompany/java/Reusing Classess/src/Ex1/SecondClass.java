package Ex1;

public class SecondClass {
    private SimpleClass simpleClass; //Tham chieu den doi tuong SimpleClass

    //Su dung lazy initialization de khoi tao SimpleClass
    public SimpleClass getSimpleClass(){
        if (simpleClass == null) { //kiem tra neu ch khoi tao
            simpleClass = new SimpleClass(); //Khoi tao doi tuong
        }
        return simpleClass;
    }
}
