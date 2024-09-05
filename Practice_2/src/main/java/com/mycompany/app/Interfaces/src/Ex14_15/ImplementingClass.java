package Ex14_15;

class ImplementingClass extends AbstractBase implements CombinedInterface {
    @Override
    public void abstractMethod1() {
        System.out.println("Implementing abstractMethod1.");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("Implementing abstractMethod2.");
    }

    @Override
    public void method1A() {
        System.out.println("Implementing method1A.");
    }

    @Override
    public void method1B() {
        System.out.println("Implementing method1B.");
    }

    @Override
    public void method2A() {
        System.out.println("Implementing method2A.");
    }

    @Override
    public void method2B() {
        System.out.println("Implementing method2B.");
    }

    @Override
    public void method3A() {
        System.out.println("Implementing method3A.");
    }

    @Override
    public void method3B() {
        System.out.println("Implementing method3B.");
    }

    @Override
    public void newMethod() {
        System.out.println("Implementing newMethod.");
    }
}

