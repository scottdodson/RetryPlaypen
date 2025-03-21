import java.lang.reflect.Method;

public class Connect {
    private final RetryStrategy retryStrategy;



    public Connect(SimpleRetryStrategy retryStrategy) {
        this.retryStrategy = retryStrategy;
    }

    public void connectRandomFail() throws IllegalAccessException {
        int attempts = 0;
        while (retryStrategy.retry(attempts, null)) {
            try {

                if (SimulateFailure.failRandom()) {
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