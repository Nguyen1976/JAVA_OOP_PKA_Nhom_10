

class Shared {
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;
    
    public Shared() {
        System.out.println("Creating " + this);
    }
    
    public void addRef() {
        refcount++;
    }
    
    protected void dispose() {
        if(--refcount == 0)
        	System.out.println("Disposing " + this);
    }
    
    @Override
    public String toString() {
        return "Shared " + id;
    }
    
    @Override
    protected void finalize() {
    	System.out.println("Finalizing " + this);
        // Đảm bảo rằng dispose() được gọi nếu chưa được gọi
        if (refcount > 0) {
            dispose();
        }
    }
}

class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;
    
    public Composing(Shared shared) {
    	System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }
    
    protected void dispose() {
    	System.out.println("disposing " + this);
        shared.dispose();
    }
    
    @Override
    public String toString() {
        return "Composing " + id;
    }
    
    @Override
    protected void finalize() {
    	System.out.println("Finalizing " + this);
        dispose();
    }
}

public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composing = {
            new Composing(shared),
            new Composing(shared),
        };
        
        for (Composing c : composing)
            c.dispose();//Mỗi lần dispose gọi sẽ --1
        
        // Yêu cầu thu gom rác
        System.gc();
        // Tạm dừng để đảm bảo việc thu gom rác diễn ra
        try { 
        	Thread.sleep(500); //Cho hệ thống ngủ 500ms để đảm bảo việc dọn dẹp hoàn thành
        } catch (InterruptedException e) { 
        	e.printStackTrace(); 
        }
    }
}