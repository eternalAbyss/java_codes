package sync;

class MyPool {
    int n;
    boolean BS;
    // Specifically for Producer
    synchronized void put(int i) {
    while(BS) {
    try {
    wait();
    }catch(InterruptedException e){
    System.out.println("Producer Thread Interrupted");
    }
    }
    n = i;
    BS = true;
    System.out.println("Produced: "+n);
    notify();
    }
    // Specifically for Consumer
    synchronized int get() {
    while(!BS) {
    try {
    wait();
    }catch(InterruptedException e){
    System.out.println("Consumer Thread Interrupted");
    }
    }
    System.out.println("Consumed: "+n);
    BS = false;
    notify();
    return n;
    }
    }
    class MyProducer implements Runnable {
    Thread t;
    MyPool q;
    public MyProducer(MyPool q) {
    this(q,"Producer");
    }
    public MyProducer(MyPool q, String name) {
    this.q = q;
    new Thread(this, name).start();
    }
    public void run() {
    int i=0;
    // Producer task
    while(true)
    q.put(i++);
    }
    }
    class MyConsumer implements Runnable {
    Thread t;
    MyPool q;
    public MyConsumer(MyPool q) {
    this(q,"Consumer");
    }
    public MyConsumer(MyPool q, String name) {
    this.q = q;
    new Thread(this,name).start();
    }
    public void run() {
    while(true)
    q.get();
    }
    }
    public class ProducerConsumer {
    public static void main(String[] args) {
    MyPool sharedPool = new MyPool();
    MyProducer p = new MyProducer(sharedPool);
    MyConsumer c = new MyConsumer(sharedPool);
    }
    }