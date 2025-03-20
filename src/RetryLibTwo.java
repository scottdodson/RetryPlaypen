public class RetryLibTwo implements retryInterface {

    @Override
    public boolean retry(SimulateFailure failureSim) throws IllegalAccessException {
        boolean result = false;
        int retryCount = 0;
        int retryLimit = 5;
        while (true) {
            try {
                result = failureSim.sleepRandom();
                break;
            } catch (IllegalAccessException | InterruptedException e) {
                retryCount++;
                //System.out.print("caught: " + retryCount + ", ");
                if (retryCount >= retryLimit) {
                    //System.out.println("retry failed, ");
                    break;
                }
            }
        }
        return result;
    }
}
