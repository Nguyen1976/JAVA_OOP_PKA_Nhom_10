package Ex2;
// Class mới kế thừa từ Detergent
public class NewDetergent extends Detergent{
    // Override phương thức scrub()
    //ke thua tu class Detergent va Override phuong thuc scrub() de thay doi hanh vi cua no
    @Override
    public void scrub(){
        System.out.println("New Hello");
    }

    //them phuong thuc sterilize()
    public void sterilize(){
        System.out.println("Hello new");
    }
}

