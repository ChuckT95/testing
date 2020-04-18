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
    TestingPerson = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
  }

  @Test
  public void personConstructorTest(){
    Assertions.assertEquals("test", TestingPerson.getFirstName());
    Assertions.assertEquals("test", TestingPerson.getLastName());

    Assertions.assertThrows(IllegalArgumentException.class, () -> {Person TestingPerson2 = new Person(null, "test","123 Test", "Test", "Test", "Test", "Test");});
    Assertions.assertThrows(IllegalArgumentException.class, () -> {Person TestingPerson2 = new Person( "test", null,"123 Test", "Test", "Test", "Test", "Test");});
    Assertions.assertThrows(IllegalArgumentException.class, () -> {Person TestingPerson2 = new Person( "", "","123 Test", "Test", "Test", "Test", "Test");});
    Assertions.assertThrows(IllegalArgumentException.class, () -> {Person TestingPerson2 = new Person( "test", "","123 Test", "Test", "Test", "Test", "Test");});

  }


  @Test
  void getFirstName() {
    String firstName = TestingPerson.getFirstName(); //Get First name of Person
    Assertions.assertEquals("test",firstName); //Check first name matches
  }

  @Test
  void getLastName() {
    
    String lastName = TestingPerson.getLastName(); //Get last name of Person
    Assertions.assertEquals("test",lastName); //Check last name matches
  }

  @Test
  void getAddress() {
    
    String address = TestingPerson.getAddress(); //Get address  of Person
    Assertions.assertEquals("123 Test",address);//Check address matches
  }

  @Test
  void getCity() {
    
    String city = TestingPerson.getCity(); //Get city of Person
    Assertions.assertEquals("Test",city); //Check city matches
  }

  @Test
  void getState() {
    
    String state = TestingPerson.getState(); //Get state of Person
    Assertions.assertEquals("Test",state); //Check state matches
  }

  @Test
  void getZip() {
    
    String zip = TestingPerson.getZip(); //Get zip of Person
    Assertions.assertEquals("Test",zip); //Check zip matches
  }

  @Test
  void getPhone() {
    
    String phone = TestingPerson.getPhone(); //Get phone of Person
    Assertions.assertEquals("Test",phone); //Check phone matches

  }


  @Test
  public void toStringTest(){
    assertEquals("test, test", TestingPerson.toString());
  }

  @Test
  void containsStringTest() {

    Person stringPerson = new Person("this","is", "a", "test", "person", "for", "testing");
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
