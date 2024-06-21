public class Test extends  Thread {
    @Override
   public void run() {
    for(int i = 0; i <10; i++){
        System.out.println("execuating task2 job "+i);
        }
    }
    public static void main(String[] args) {
        Test t = new Test();
        t.start();
        System.out.println("Starting application");
        for(int i = 0; i <10; i++){
            System.out.println("execuating task1 job "+i);
        }
        
        System.out.println("finished application");

    }    
}
