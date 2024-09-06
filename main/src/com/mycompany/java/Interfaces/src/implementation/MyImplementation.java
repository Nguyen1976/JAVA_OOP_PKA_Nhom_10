package implementation;

import Ex5.MyInterface;

public class MyImplementation implements MyInterface {
    @Override
    public void methodOne(){
        System.out.println("Method One implemented.");
    }
    @Override
    public void methodTwo() {
        System.out.println("Method Two implemented.");
    }

    @Override
    public void methodThree() {
        System.out.println("Method Three implemented.");
    }
}
