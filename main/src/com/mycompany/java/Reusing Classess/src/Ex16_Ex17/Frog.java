package Ex16_Ex17;

public class Frog extends Amphibian{
    // Frog kế thừa tất cả các phương thức từ Amphibian mà không cần phải override
    //Ex17
    @Override
    public void swim(){
        System.out.println("frog swim");
    }

    @Override
    public void walk(){
        System.out.println("frog walk");
    }

    @Override
    public void  makeVoice(){
        System.out.println("frog keu");
    }
}

