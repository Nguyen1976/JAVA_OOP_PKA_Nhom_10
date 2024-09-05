package Ex3;

abstract class Base {
    // Phương thức trừu tượng print()
    public abstract void print();

    //Constructor
    public Base(){
        //Gọi phương thức print() trong constructor
        System.out.println("Base constructor is calling print():");
        print();
    }
}
