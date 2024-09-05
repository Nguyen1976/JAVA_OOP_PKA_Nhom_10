// Định nghĩa các trạng thái khác nhau của cảnh báo
class AlertStatus {
    public void alert() {}
}

class GreenAlert extends AlertStatus {
    @Override
    public void alert() { 
    	System.out.println("Green Alert"); 
    }
}

class YellowAlert extends AlertStatus {
    @Override
    public void alert() { 
    	System.out.println("Yellow Alert"); 
    }
}

class RedAlert extends AlertStatus {
    @Override
    public void alert() { 
    	System.out.println("Red Alert"); 
    }
    
}

class Starship {
    private AlertStatus alertStatus = new GreenAlert(); // Khởi tạo với trạng thái Green Alert
    
    public void changeAlertStatus(AlertStatus newStatus) {
        alertStatus = newStatus; // Thay đổi trạng thái cảnh báo
    }
    
    public void signal() {
        alertStatus.alert(); // Kêu gọi hành vi hiện tại
    }
}

public class Transmogrify {
    public static void main(String[] args) {
        Starship starship = new Starship();
        starship.signal(); // Hiển thị Green Alert
        
        starship.changeAlertStatus(new YellowAlert()); // Thay đổi thành Yellow Alert
        starship.signal(); // Hiển thị Yellow Alert
        
        starship.changeAlertStatus(new RedAlert()); // Thay đổi thành Red Alert
        starship.signal(); // Hiển thị Red Alert
    }
}