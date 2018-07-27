import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class ApiTests {

    private static final String lukeSkywalker_Url = "https://swapi.co/api/people/1/";
    private String homeWorld_Url;
    private ArrayList<String> filmsList;

    @Test
    public void testTask1(){
        //find the person by id and check his name
        get(lukeSkywalker_Url)
                .then()
                .assertThat()
                .body("name", equalTo("Luke Skywalker"));
    }

    @Test
    public void testTask2(){
        //get homeworld link from person's data
        homeWorld_Url = get(lukeSkywalker_Url)
                .then()
                .extract()
                .path("homeworld");

        //check name and population of homeworld
        get(homeWorld_Url)
               .then()
               .body("name", equalTo("Tatooine"))
               .body("population", equalTo("200000"));
    }

    @Test
    public void TestTask3(){
        //get homeworld link from person's data
        homeWorld_Url = get(lukeSkywalker_Url)
                .then()
                .extract()
                .path("homeworld");

        //get list with films from homeworld page
        filmsList = get(homeWorld_Url)
                .then()
                .extract()
                .path("filmsList");

        //check characters and planets of film
        get(filmsList.get(0))
                .then()
                .body("title", equalTo("Attack of the Clones"))
                .body("characters", hasItem(lukeSkywalker_Url))
                .body("planets", hasItem(homeWorld_Url));
    }
}
