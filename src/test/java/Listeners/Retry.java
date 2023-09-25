package Listeners;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class Retry implements IRetryAnalyzer {

    int retryCount = 0;
    int maxRetryCount = 2;
    @Override
    public boolean retry(ITestResult result) {
        if(!result.isSuccess()) {                         //Check if test is failed

            if(retryCount<maxRetryCount) {                //Check if the maximum number of test execution is reached
                System.out.println("Retrying Test : Re-running " + result.getName() +
                        " for " + (retryCount+1) + " time(s)."); //Print the number of Retry attempts

                retryCount++;                             //Increase the maxRetryCount by 1

                result.setStatus(ITestResult.FAILURE);    //Mark test as failed
                return true;                                 //Rerun the failed test
            } else {
                result.setStatus(ITestResult.FAILURE);    //TestNG marks last run as failed, if last run is max retry
            }
        } else {
            result.setStatus(ITestResult.SUCCESS);    //TestNG parks test as passed when the test passes

        }

        return false;
    }
}
