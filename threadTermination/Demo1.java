package threadTermination;

import java.math.BigInteger;

public class Demo1 {
    public static void main(String args[]){
        Thread thread = new Thread(new LongComputationTask(new BigInteger("10000"), new BigInteger("5000000")));
        
        //see below in pow method for explanation 
        thread.setDaemon(true);
        thread.start();
        thread.interrupt();
    }

    private static class LongComputationTask implements Runnable{
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power){
            this.base = base;
            this.power = power;
        }

        public void run(){
            System.out.println(base+"^"+power+" = "+ pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power){
            BigInteger result = BigInteger.ONE;

            for(BigInteger i=BigInteger.ZERO; i.compareTo(power) != 0; i= i.add(BigInteger.ONE)){
                //we can set only simply set thread.setDaemon(true) instead of this if conditional.
                /*if(Thread.currentThread().isInterrupted()){
                    System.out.println( "Prematurely interrupted computation.");
                    return BigInteger.ZERO;
                }*/
                result  = result.multiply(base);
            }
        return result;
        }
    }

}
