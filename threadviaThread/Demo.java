package threadviaThread;

public class Demo {
    public static void main(String args[]){
        /*Thread thread = new Thread(new Runnable(){
            public void run(){
                System.out.println("Hello from " + Thread.currentThread().getName() );
            }
        });*/

        Thread thread = new NewThread();
        thread.setName("Temporary thread");
        thread.start();
    }

    private static class NewThread extends Thread{
        public void run(){
            System.out.println("Hello from " + Thread.currentThread().getName() );
        }
    }
}
