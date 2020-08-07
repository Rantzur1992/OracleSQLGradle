package io.testproject.Action;

import io.testproject.java.annotations.v2.Action;
import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.enums.ParameterDirection;
import io.testproject.java.sdk.v2.addons.GenericAction;
import io.testproject.java.sdk.v2.addons.WebAction;
import io.testproject.java.sdk.v2.addons.helpers.AddonHelper;
import io.testproject.java.sdk.v2.addons.helpers.WebAddonHelper;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.Base.TestSQLConnectionActionBase;

@Action(name = "Test SQL Connection (Oracle Database)", description = "Test the connection to the Oracle database")
public class TestSQLConnectionAction extends TestSQLConnectionActionBase implements GenericAction {

    @Parameter(description = "Host or IP address")
    public String host = "";

    @Parameter(description = "Port (Default: 1521)")
    public String port = "";

    @Parameter(description = "User (Default: root)")
    public String username = "";

    @Parameter(description = "Password")
    public String password = "";

    @Parameter(description = "SID (Default: None)")
    public String SID = "";

    @Parameter(description = "Service Name (Default: None)")
    public String Service = "";

    @Parameter(description = "\"true\" if the connection is fine, \"false\" if not", direction = ParameterDirection.OUTPUT)
    public String isConnected = "";

    public TestSQLConnectionAction() {
        super("sqlserver", "oracle.jdbc.driver.OracleDriver", 1521);
    }

    @Override
    public ExecutionResult execute(AddonHelper helper) throws FailureException {
        registerFields(host, port, username, password, SID, Service);
        ExecutionResult result = executeBase(helper);
        isConnected = super.m_isConnected;
        return result;
    }
}
