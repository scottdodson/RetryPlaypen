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
            attempts++;
            try {
                boolean success = simFault.failRandom();
                if (success) {
                    System.out.println("success");
                    break;
                }
            } catch (IllegalAccessException e) {
                if (retryStrategy.retry(attempts, null)) {
                    System.out.print("fail ");
                } else {
                    System.out.println("failed");
                }
            }
        }
    }

    public void connectWithDelay() throws IllegalAccessException, InterruptedException {
        int attempts = 0;
        while (retryStrategy.retry(attempts, null)) {
            attempts++;
            try {
                boolean success = simFault.sleepRandom();
                if (success) {
                    System.out.println("success");
                    break;
                }
            } catch (IllegalAccessException e) {
                if (retryStrategy.retry(attempts, null)) {
                    System.out.print("fail ");
                } else {
                    System.out.println("failed");
                }
            }

        }

    }
}