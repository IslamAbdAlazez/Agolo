package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import api.endpoints.UserEndPoints;

public class UserTests {
    public Logger logger;   
    
    @DataProvider(name = "userDataProvider")
    public Object[][] provideUserData(Method method) {
    	String filePath = "testData/userPayload.json";
        Object[][] userData = null;
        if (method.getName().equals("testCreateUser")) {
        	userData = readUserDataFromJsonFile(filePath, "createUser");
		}
		else if (method.getName().equals("testLogin")) {
			userData = readUserDataFromJsonFile(filePath, "login");
		}
        return userData;
    }

    public Object[][] readUserDataFromJsonFile(String filePath, String dataKey) {
        try {
            String jsonContent = FileUtils.readFileToString(new File(getClass().getClassLoader().getResource(filePath).getFile()), "UTF-8");
            JSONObject jsonObject = new JSONObject(jsonContent);

            JSONArray dataArray = jsonObject.getJSONArray(dataKey);
            Object[][] userData = new Object[dataArray.length()][2]; // Assuming each user has username and password

            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject userObject = dataArray.getJSONObject(i);
                userData[i][0] = userObject.getString("username");
                userData[i][1] = userObject.getString("password");
            }

            return userData;
        } catch (IOException e) {
            e.printStackTrace();
            return new Object[0][0]; // Return empty array in case of exception
        }
    }
    
    @BeforeClass
    public void setup()
    {   
        //Logs
        logger = LogManager.getLogger(this.getClass());
    }

    //This test will run twice because its Json data contains 2 objects one for testing
    // creating the user for the first time and the other one for testing creating
    // Another user with the same 
    @Test(priority = 1, dataProvider = "userDataProvider")
    public void testCreateUser(String username, String password)
    {
        logger.info("*********Creating User*************");
     // Create a JSON object with the provided username and password
        JSONObject userPayload = new JSONObject();
        userPayload.put("username", username);
        userPayload.put("password", password);
        
        Response response = UserEndPoints.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("****************User is created************");
    }    
    
    //This test will run twice because its Json data contains 2 objects one 
    //for testing logging with already created user for the first time and the other
    //one for testing login with not existing user 
    @Test(priority = 1, dataProvider = "userDataProvider")
    public void testLogin(String username, String password)
    {
        logger.info("*********Creating User*************");
        // Create a JSON object with the provided username and password
        JSONObject userPayload = new JSONObject();
        userPayload.put("username", username);
        userPayload.put("password", password);
        
        Response response = UserEndPoints.login(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("****************User is created************");
    }
}
