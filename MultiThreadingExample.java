

class  DownloadImage{
    synchronized void  download(int n, String imagename){
        for (int i=0; i<n; i++){
            System.out.println("downloading image "  + imagename + i+ ".jpg" );

        }
            

    
    }
    
}
class myThread extends Thread{
    DownloadImage dref;
    public myThread(DownloadImage deref){
        this.dref = deref;
    }

    @Override
    public void run(){
        dref.download(10, "dog ");
    }
}



class yourThread extends Thread{
    DownloadImage dref;
    public yourThread(DownloadImage deref){
        this.dref = deref;
    }

    @Override
    public void run(){
        dref.download(10, "cat ");
    }
}
public class MultiThreadingExample {
    public static void main(String[] args) {
        DownloadImage d = new DownloadImage();
        myThread t1 =  new myThread(d);
        yourThread t2 =  new yourThread(d);

        t1.start();
        t2.start();
        // try{
        //  t1.join(); t1.join();
        // }
        // catch(Exception e){e.printStackTrace();}
        // t2.start();
        
    }   
}