//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InterruptedException {
        SimulateFailure simFailure = new SimulateFailure();
        RetryLib retryLib = new RetryLib();
        RetryLibTwo retryLibTwo = new RetryLibTwo();
        RetryLibThree retryLibThree = new RetryLibThree();

        System.out.println("Each test makes five attempts with 'true' indicating a success'");

        System.out.println("try random fail");
        for (int i = 1; i <= 5; i++) {
            try {
                System.out.println(simFailure.failRandom());
            } catch (IllegalAccessException e) {
                System.out.println("caught failure");
            }

        }
        System.out.println();

        System.out.println("try random fail with retry");
        for (int i = 1; i <= 5; i++) {
            System.out.println(retryLib.retry(simFailure));
        }
        System.out.println();

        System.out.println("try timed fail with simple retry");
        for (int i = 1; i <= 5; i++) {
            System.out.println(retryLibTwo.retry(simFailure));
        }
        System.out.println();

        System.out.println("try timed fail with retry and wait");
        for (int i = 1; i <= 5; i++) {
            System.out.println(retryLibThree.retry(simFailure));
        }
        System.out.println();
    }
}