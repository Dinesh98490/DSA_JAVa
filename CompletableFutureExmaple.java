
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
public class CompletableFutureExmaple {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        CompletableFuture<Integer> sumfuture  = CompletableFuture.supplyAsync(() -> sum(list));

        CompletableFuture<Integer> sqfuture = sumfuture.thenApplyAsync(res -> res*res);

        CompletableFuture<Void> future = sqfuture.thenAcceptAsync(res->System.out.println(res));
        System.out.println("abc");
        future.join();
    
    }    

    static int sum(List<Integer> list) {
        int sum =0;
        for(Integer i : list){
            sum+=i;
        }
        try{
            Thread.sleep(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return sum;

    }
}
