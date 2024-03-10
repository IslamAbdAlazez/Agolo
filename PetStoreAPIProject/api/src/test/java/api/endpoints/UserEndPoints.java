package api.endpoints;

import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Created to perform CRUD operations in the USER api
public class UserEndPoints {

    public static Response createUser(JSONObject payload)
    {
        Response response = RestAssured.given()
                                            .baseUri(Routes.base_uri)
                                            .basePath(Routes.create_user_post_basePath)
                                            .contentType(ContentType.JSON)
                                            .accept(ContentType.ANY)
                                            .body("{\"username\":\"" + payload.getString("username") + "\",\"password\":\"" + payload.getString("password") + "\"}")
                                        .when()
                                            .post();
        return response;
    }
    
    public static Response login(JSONObject payload)
    {
        Response response = RestAssured.given()
                                            .baseUri(Routes.base_uri)
                                            .basePath(Routes.login_post_basePath)
                                            .contentType(ContentType.JSON)
                                            .accept(ContentType.ANY)
                                            .body("{\"username\":\"" + payload.getString("username") + "\",\"password\":\"" + payload.getString("password") + "\"}")
                                        .when()
                                            .post();
        return response;
    }
}
