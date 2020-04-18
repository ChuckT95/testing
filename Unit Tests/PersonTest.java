import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PersonTest {

  private Person TestingPerson;


  //Create a new Person before each testing method is executed
  @BeforeEach
  void setUp(){
    //Create new Person
    TestingPerson = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
  }

  @Test
  public void personConstructorTest(){
    //Test that the Person we created has the right first name
    Assertions.assertEquals("test", TestingPerson.getFirstName());

    //Should throw IllegalArgumentException if no name was passed for first or last name
    Assertions.assertThrows(IllegalArgumentException.class, () -> {Person TestingPerson2 = new Person(null, "test","123 Test", "Test", "Test", "Test", "Test");});
    Assertions.assertThrows(IllegalArgumentException.class, () -> {Person TestingPerson2 = new Person( "test", null,"123 Test", "Test", "Test", "Test", "Test");});
    Assertions.assertThrows(IllegalArgumentException.class, () -> {Person TestingPerson2 = new Person( "", "","123 Test", "Test", "Test", "Test", "Test");});
    Assertions.assertThrows(IllegalArgumentException.class, () -> {Person TestingPerson2 = new Person( "test", "","123 Test", "Test", "Test", "Test", "Test");});

  }


  @Test
  void getFirstName() {
    //Get First name of Person
    String firstName = TestingPerson.getFirstName();
    //Check first name matches
    Assertions.assertEquals("test",firstName);
  }

  @Test
  void getLastName() {
    //Get last name of Person
    String lastName = TestingPerson.getLastName();
    //Check last name matches
    Assertions.assertEquals("test",lastName);
  }

  @Test
  void getAddress() {
    //Get address  of Person
    String address = TestingPerson.getAddress();
    //Check address matches
    Assertions.assertEquals("123 Test",address);
  }

  @Test
  void getCity() {
    //Get city of Person
    String city = TestingPerson.getCity();
    //Check city matches
    Assertions.assertEquals("Test",city);
  }

  @Test
  void getState() {
    //Get state of Person
    String state = TestingPerson.getState();
    //Check state matches
    Assertions.assertEquals("Test",state);
  }

  @Test
  void getZip() {
    //Get zip of Person
    String zip = TestingPerson.getZip();
    //Check zip matches
    Assertions.assertEquals("Test",zip);
  }

  @Test
  void getPhone() {
    //Get phone of Person
    String phone = TestingPerson.getPhone();
    //Check phone matches
    Assertions.assertEquals("Test",phone);

  }


  @Test
  public void toStringTest(){
    //Should return string in form of "LastName, FirstName"
    assertEquals("test, test", TestingPerson.toString());
  }

  @Test
  void containsStringTest() {
    //Create a new Person
    Person stringPerson = new Person("this","is", "a", "test", "person", "for", "testing");
    //Check to see that each string is contained in the Person
    assertTrue(stringPerson.containsString("this"));
    assertTrue(stringPerson.containsString("is"));
    assertTrue(stringPerson.containsString("a"));
    assertTrue(stringPerson.containsString("test"));
    assertTrue(stringPerson.containsString("person"));
    assertTrue(stringPerson.containsString("for"));
    assertTrue(stringPerson.containsString("testing"));
    assertFalse(stringPerson.containsString("fail"));
  }


  @ParameterizedTest
  @ValueSource(ints = { -1,0,1,2,3,4,5,6,7 })
  void getFieldTest(int field) {
    //go through all test inputs, should go through each case
    switch (field) {
      case 0:
        Assertions.assertEquals("test",TestingPerson.getField(field)); //Check first name
        break;
      case 1:
        Assertions.assertEquals("test",TestingPerson.getField(field)); //Check last name
        break;
      case 2:
        Assertions.assertEquals("123 Test",TestingPerson.getField(field)); //Check address
        break;
      case 3:
        Assertions.assertEquals("Test",TestingPerson.getField(field)); //Check city
        break;
      case 4:
        Assertions.assertEquals("Test",TestingPerson.getField(field)); //Check state
        break;
      case 5:
        Assertions.assertEquals("Test",TestingPerson.getField(field)); //Check zip
        break;
      case 6:
        Assertions.assertEquals("Test",TestingPerson.getField(field)); //Check phone
        break;
      default:
        //Out of bounds, check we throw an IllegalArgumentException
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
          TestingPerson.getField(field);
        });
    }
  }
}
