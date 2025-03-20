import java.util.concurrent.TimeUnit;

public class RetryLibThree implements retryInterface {
    @Override
    public boolean retry(SimulateFailure failureSim) throws IllegalAccessException, InterruptedException {
        boolean result = false;
        int retryCount = 0;
        int retryLimit = 5;
        String spinner = "|/-\\";
        while (true) {
            try {
                result = failureSim.sleepRandom();
                break;
            } catch (IllegalAccessException | InterruptedException e) {
                retryCount++;
                TimeUnit.SECONDS.sleep(1);
                System.out.print("\r running " + spinner.charAt(retryCount % spinner.length()));
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
