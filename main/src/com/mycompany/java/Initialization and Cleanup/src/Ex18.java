public class Ex18 {
    public Ex18(String type){
        System.out.println(type);
    }

    public static void main(String[] args) {
        Ex18[] arr = new Ex18[5];
        for(int i = 0; i< arr.length; i++){
            arr[i] = new Ex18("Doi so thu " + (i + 1));
        }
    }
}
