

public class Main {
    public static void main(String[] args) throws Exception {

        SimpleRetryStrategy simple = new SimpleRetryStrategy(2);
        Connect connection = new Connect(simple);
        connection.connectRandomFail();



    }


}