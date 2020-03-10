import static org.junit.jupiter.api.Assertions.*;


import java.util.regex.Pattern;
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
  void getFirstName() {
    String firstName = TestingPerson.getFirstName(); //Get First name of Person
    assertEquals("test",firstName); //Check first name matches
  }

  @Test
  void getLastName() {
    
    String lastName = TestingPerson.getLastName(); //Get last name of Person
    assertEquals("test",lastName); //Check last name matches
  }

  @Test
  void getAddress() {
    
    String address = TestingPerson.getAddress(); //Get address  of Person
    assertEquals("123 Test",address);//Check address matches
  }

  @Test
  void getCity() {
    
    String city = TestingPerson.getCity(); //Get city of Person
    assertEquals("Test",city); //Check city matches
  }

  @Test
  void getState() {
    
    String state = TestingPerson.getState(); //Get state of Person
    assertEquals("Test",state); //Check state matches
  }

  @Test
  void getZip() {
    
    String zip = TestingPerson.getZip(); //Get zip of Person
    assertEquals("Test",zip); //Check zip matches
  }

  @Test
  void getPhone() {
    
    String phone = TestingPerson.getPhone(); //Get phone of Person
    assertEquals("Test",phone); //Check phone matches

  }


  @Test
  void containsString() {
    String test = "test"; //Vlaue to test whether or not the Person contains this attribute
    Pattern pa = Pattern.compile(Pattern.quote(test), Pattern.CASE_INSENSITIVE); //Setup pattern

    //Check each attribute of Person to see if there is a match
    boolean found =
        pa.matcher(TestingPerson.getFirstName()).find()
            || pa.matcher(TestingPerson.getLastName()).find()
            || pa.matcher(TestingPerson.getAddress()).find()
            || pa.matcher(TestingPerson.getCity()).find()
            || pa.matcher(TestingPerson.getState()).find()
            || pa.matcher(TestingPerson.getZip()).find()
            || pa.matcher(TestingPerson.getPhone()).find();
    assertTrue(found); //Return true if we found at least one value

  }

  @ParameterizedTest
  @ValueSource(ints = { -1,0,1,2,3,4,5,6,7 })
  void getField(int field) {
    
    switch (field) {
      case 0:
        assertEquals("test",TestingPerson.getFirstName()); //Check first name
        break;
      case 1:
        assertEquals("test",TestingPerson.getLastName()); //Check last name
        break;
      case 2:
        assertEquals("123 Test",TestingPerson.getAddress()); //Check address
        break;
      case 3:
        assertEquals("Test",TestingPerson.getCity()); //Check city
        break;
      case 4:
        assertEquals("Test",TestingPerson.getState()); //Check state
        break;
      case 5:
        assertEquals("Test",TestingPerson.getZip()); //Check zip
        break;
      case 6:
        assertEquals("Test",TestingPerson.getPhone()); //Check phone
        break;
      default:
        //Out of bounds, check we throw an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
          TestingPerson.getField(field);
        });
    }
  }
}
