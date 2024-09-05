public class Shared {
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;
    
    public Shared() {
        System.out.println("Creating " + this);
    }
    
    
    public void addRef() { 
    	refcount++; 
    }
    
    //Loại bỏ
    protected void dispose() {
        if (--refcount == 0)
        	System.out.println("Disposing " + this);
    }
    
    public String toString() { 
    	return "Shared " + id; 
    }
}
