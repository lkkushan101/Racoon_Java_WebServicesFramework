package Test;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Reusable_Requests.*;
import Utility.JSONReader;
import ExtentReport.ExtentReport;

public class test_delete {
	
	@Test
	public void post_test_req() throws FileNotFoundException, IOException, ParseException
	{
		String response;
		ExtentReport extRpt = new ExtentReport();
		JSONReader _JSONRead = new JSONReader();
		DeleteRequest _postReq = new DeleteRequest();
		extRpt.setUpReport();
		extRpt.startTestCase("Test Get Request : Racoon");
		String Req_URL = _JSONRead.ReadJSONFile("Request_Delete", ".\\Data\\wsData.json");
	    response = _postReq.deleteRequest(Req_URL);

	    Assert.assertEquals(response.contains("204") , true , "Request is successful");
	    extRpt.logEvents("Response received" + response);
	    extRpt.createFinalReport();
	    
	}


}
