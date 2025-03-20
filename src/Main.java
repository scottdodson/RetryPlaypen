//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InterruptedException {
        SimulateFailure simFailure = new SimulateFailure();
        RetryLib retryLib = new RetryLib();
        RetryLibTwo retryLibTwo = new RetryLibTwo();
        RetryLibThree retryLibThree = new RetryLibThree();

        System.out.println("Each test makes five attempts with 'true' indicating a success'");

        System.out.println("\ntry random fail\n-");
        int send = 5;
        int count = 0;
        boolean success = false;
        for (int i = 1; i <= send; i++) {
            try {
                success = simFailure.failRandom();
                if (success) {
                    //System.out.println("success");
                    count++;
                }
            } catch (IllegalAccessException e) {
                //System.out.println("caught failure");
            }

        }
        System.out.println("-\nsuccess ratio:" + count + "/" + send + "\n");

        System.out.println("try random fail with retry\n-");
        count = 0;
        success = false;
        for (int i = 1; i <= send; i++) {
            success = retryLib.retry(simFailure);
            if (success) {
                //System.out.println("success");
                count++;
            }
        }
        System.out.println("-\nsuccess ratio:" + count + "/" + send + "\n");

        System.out.println("try timed fail with simple retry\n-");
        count = 0;
        success = false;
        for (int i = 1; i <= send; i++) {
            success = retryLibTwo.retry(simFailure);
            if (success) {
                //System.out.println("success");
                count++;
            }
        }
        System.out.println("-\nsuccess ratio:" + count + "/" + send + "\n");

        System.out.println("try timed fail with retry and wait\n-");
        count = 0;
        success = false;
        for (int i = 1; i <= send; i++) {
            success = retryLibThree.retry(simFailure);
            if (success) {
                //System.out.println("success");
                count++;
            }
        }
        System.out.println("\n-\nsuccess ratio:" + count + "/" + send + "\n");
    }
}