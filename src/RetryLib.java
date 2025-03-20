import java.util.concurrent.TimeUnit;

interface retryInterface {
    boolean retry(SimulateFailure failureSim) throws IllegalAccessException, InterruptedException;
}

public class RetryLib implements retryInterface {

    @Override
    public boolean retry(SimulateFailure failureSim) throws IllegalAccessException {
        boolean result = false;
        int retryCount = 0;
        int retryLimit = 5;
        int retryInterval = 1000;
        while (true) {
            try {
                // System.out.println(failureSim.failRandom());
                result = failureSim.failRandom();
                break;
            } catch (IllegalAccessException e) {
                retryCount++;
                //System.out.print("caught: " + retryCount + ", ");
                if (retryCount >= retryLimit) {
                    //System.out.print("retry failed, ");
                    break;
                }
            }
        }
        return result;
    }
}

