package Fach_5_ParalleleProgrammierung.Basis;

/**
 * Siehe TEST-Klasse CounterThreadTest!
 */
public class CounterThread extends Thread {

    String counterName;

    public CounterThread(String counterName) {
        this.counterName = counterName;
    }

    // das in der run() Methode kann parallel ablaufen
    @Override
    public void run() {
        for (int i=1;  i<=10; i++) {
            System.out.println(counterName +", Zaehler: " +i);
            try {
                // 1 Sekunde warten
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

