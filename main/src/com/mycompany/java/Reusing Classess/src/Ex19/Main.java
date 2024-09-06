package Ex19;

public class Main {
    public static void main(String[] args) {
        FinalReference ref1 = new FinalReference(10);
        ref1.useEx19();

        FinalReference ref2 = new FinalReference();
        ref2.useEx19();
    }
}
