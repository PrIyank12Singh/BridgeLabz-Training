import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class ThreadStateMonitorV1 extends Thread {

    private Thread[] monitoredThreads;
    private Set<Thread.State> observedStates = new HashSet<>();

    public ThreadStateMonitorV1(Thread... threads) {
        this.monitoredThreads = threads;
    }

    @Override
    public void run() {

        boolean allTerminated = false;

        while (!allTerminated) {

            allTerminated = true;

            for (Thread t : monitoredThreads) {

                Thread.State state = t.getState();
                observedStates.add(state);

                System.out.println("[Monitor] " + t.getName() +
                        " is in " + state +
                        " state at " + LocalTime.now());

                if (state != Thread.State.TERMINATED) {
                    allTerminated = false;
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Summary: Threads went through " +
                observedStates.size() + " different states.");
    }
}
