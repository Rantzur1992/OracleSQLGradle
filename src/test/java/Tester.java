import io.testproject.Action.TestSQLConnectionAction;
import io.testproject.Action.SendSQLQueryAction;
import io.testproject.java.enums.AutomatedBrowserType;
import io.testproject.java.sdk.v2.Runner;


import java.io.IOException;

public class Tester {

    private static Runner runner;
    private final static String devToken = "iw2wttdhyvddCbT-1-pktCyAa0QeIaLw62lacDiFjds1";

    public static void init() throws InstantiationException {
        runner = Runner.createWeb(devToken, AutomatedBrowserType.Chrome);
    }

    public static void tearDown() throws IOException {
        runner.close();
    }

    public static void main(String[] args) throws Exception {
        init();

        // Create actions.
        TestSQLConnectionAction test = new TestSQLConnectionAction();
        SendSQLQueryAction send = new SendSQLQueryAction();

        // CONNECTION TEST. -- WORKS.
        // Set Params for test.
        test.host = "localhost";
        test.password = "1234";
        test.username = "SYSTEM";
        test.port = "1521";
        test.SID = "xe";
        test.Service = "xe";
        runner.run(test);


        // Set Params for send.
        send.host = "localhost";
        send.password = "1234";
        send.username = "SYSTEM";
        send.port = "1521";
        // Queries.
        send.query = "CREATE TABLE PersonsAFTERSID (\n" +
                "    PersonID int,\n" +
                "    LastName varchar(255),\n" +
                "    FirstName varchar(255),\n" +
                "    Address varchar(255),\n" +
                "    City varchar(255)\n" +
                ")";
        //TABLE CREATION QUERY. -- WORKS.
        send.query = "SELECT * FROM PERSONSXXX";

        send.Service = "xe";
        send.SID = "xe";
        // Run.
       // runner.run(send);


        tearDown();
    }
}

