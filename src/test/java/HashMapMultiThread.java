import java.util.HashMap;
import java.util.Map;

public class HashMapMultiThread {

    static Map<String,String> map = new HashMap<>();

    public static class AddThread implements Runnable{

        int start;
        public AddThread(int start){
            this.start=start;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            //添加元素
            for(int i = start ; i<10000000;i+=2){
                map.put(Integer.toString(i),Integer.toBinaryString(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //开启两个线程
        Thread t1 = new Thread(new AddThread(0));
        Thread t2 = new Thread(new AddThread(1));
        t1.start();
        t2.start();
        //主线程等待两个线程执行完
        t1.join();
        t2.join();
        System.out.println(map.size());
    }
}