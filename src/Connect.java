import java.lang.reflect.Method;

public class Connect {
    private final RetryStrategy retryStrategy;
    private final SimulateFailure simFault = new SimulateFailure();

    public Connect(RetryStrategy retryStrategy) {
        this.retryStrategy = retryStrategy;
    }

    public void connectRandomFail() throws IllegalAccessException, InterruptedException {
        int attempts = 0;
        while (retryStrategy.retry(attempts, null)) {
            try {
                boolean success = simFault.failRandom();
                if (success) {
                    System.out.println("success");
                    break;
                }
            } catch (IllegalAccessException e) {
                System.out.print("fail ");
            }
            attempts++;
        }
    }

    public void connectWithDelay() throws IllegalAccessException, InterruptedException {
        int attempts = 0;
        while (retryStrategy.retry(attempts, null)) {
            try {
                boolean success = simFault.sleepRandom();
                if (success) {
                    System.out.println("success");
                    break;
                }
            } catch (IllegalAccessException e) {
                System.out.print("fail ");
            }
            attempts++;
        }

    }
}