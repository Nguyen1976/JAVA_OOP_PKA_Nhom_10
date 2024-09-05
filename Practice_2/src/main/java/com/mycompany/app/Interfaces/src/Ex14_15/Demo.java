package Ex14_15;

public class Demo {

    public static void processInterface1(Interface1 obj) {
        obj.method1A();
        obj.method1B();
    }

    public static void processInterface2(Interface2 obj) {
        obj.method2A();
        obj.method2B();
    }

    public static void processInterface3(Interface3 obj) {
        obj.method3A();
        obj.method3B();
    }

    public static void processCombinedInterface(CombinedInterface obj) {
        obj.method1A();
        obj.method1B();
        obj.method2A();
        obj.method2B();
        obj.method3A();
        obj.method3B();
        obj.newMethod();
    }


    public static void main(String[] args) {
        ImplementingClass obj = new ImplementingClass();
        processInterface1(obj);
        processInterface2(obj);
        processInterface3(obj);
        processCombinedInterface(obj);
    }
}
