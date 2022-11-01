import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RandThread implements Runnable {

  private volatile int random_num;
  private volatile static ArrayList<Integer> numList = new ArrayList<Integer>();

  public int getRandomNum() {
    return this.random_num;
  }

  public ArrayList<Integer> getNumList() {
    return this.numList;
  }

  @Override
  public void run() {
    // generate random values from 1-100
    Random rand = new Random(); // instance of random class
    int upperbound = 99;
    int rn = rand.nextInt((upperbound - 1) + 1);
    this.random_num = rn;
    System.out.println("Random number " + this.random_num);
    numList.add(rn);
  }

  public static void main(String[] args) {

    // RandThread r1 = new RandThread();
    // Thread t1 = new Thread(r1);
    // RandThread r2 = new RandThread();
    // Thread t2 = new Thread(r2);
    // RandThread r3 = new RandThread();
    // Thread t3 = new Thread(r3);
    // RandThread r4 = new RandThread();
    // Thread t4 = new Thread(r4);
    // RandThread r5 = new RandThread();
    // Thread t5 = new Thread(r5);

    // t1.start();

    // try {
    // t1.join();
    // t2.start();
    // t2.join();
    // t3.start();
    // t3.join();
    // t4.start();
    // t4.join();
    // t5.start();
    // t5.join();

    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }

    // int sum = r1.getRandomNum() + r2.getRandomNum() + r3.getRandomNum() +
    // r4.getRandomNum() + r5.getRandomNum();

    // System.out.println("The sum is : " + sum);

    ExecutorService executor = Executors.newFixedThreadPool(5);

    for (int i = 0; i < 5; i++) {
      RandThread rand_worker = new RandThread();
      executor.execute(rand_worker);
    }
    executor.shutdown();
    while (!executor.isTerminated()) {
    }

    System.out.println("finished all threads");

    int pool_sum = 0;
    for (int pool_num : numList) {
      pool_sum += pool_num;
    }

    System.out.println("The total sum for the pool of workers is " + pool_sum);

    // int sum_collect = 0;
    // int j = 1;
    // for (Integer num_collect : r1.getNumList()) {
    // System.out.println("Number " + j + " in colection list " + num_collect);
    // sum_collect += num_collect;
    // j++;
    // }

    // System.out.println("The sum from collections is :" + sum_collect);

  }

}
