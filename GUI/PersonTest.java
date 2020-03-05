import static org.junit.jupiter.api.Assertions.*;


import java.util.regex.Pattern;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PersonTest {

  private Person TestingPerson;

  @BeforeEach
  void setUp(){
    TestingPerson = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
  }

  @Test
  void getFirstName() {
    //
    String firstName = TestingPerson.getFirstName();
    assertEquals("test",firstName);
  }

  @Test
  void getLastName() {
    
    String lastName = TestingPerson.getLastName();
    assertEquals("test",lastName);
  }

  @Test
  void getAddress() {
    
    String address = TestingPerson.getAddress();
    assertEquals("123 Test",address);
  }

  @Test
  void getCity() {
    
    String city = TestingPerson.getCity();
    assertEquals("Test",city);
  }

  @Test
  void getState() {
    
    String state = TestingPerson.getState();
    assertEquals("Test",state);
  }

  @Test
  void getZip() {
    
    String zip = TestingPerson.getZip();
    assertEquals("Test",zip);
  }

  @Test
  void getPhone() {
    
    String phone = TestingPerson.getPhone();
    assertEquals("Test",phone);

  }

//  @Test
//  void toString() {
//  }

  @Test
  void containsString() {
    String test = "test";
    Pattern pa = Pattern.compile(Pattern.quote(test), Pattern.CASE_INSENSITIVE);
    Person person = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
    boolean found =
        pa.matcher(person.getFirstName()).find()
            || pa.matcher(person.getLastName()).find()
            || pa.matcher(person.getAddress()).find()
            || pa.matcher(person.getCity()).find()
            || pa.matcher(person.getState()).find()
            || pa.matcher(person.getZip()).find()
            || pa.matcher(person.getPhone()).find();
    assertTrue(found);

  }

  @ParameterizedTest
  @ValueSource(ints = { -1,0,1,2,3,4,5,6,7 })
  void getField(int field) {
    
    switch (field) {
      case 0:
        assertEquals("test",TestingPerson.getFirstName());
        break;
      case 1:
        assertEquals("test",TestingPerson.getLastName());
        break;
      case 2:
        assertEquals("123 Test",TestingPerson.getAddress());
        break;
      case 3:
        assertEquals("Test",TestingPerson.getCity());
        break;
      case 4:
        assertEquals("Test",TestingPerson.getState());
        break;
      case 5:
        assertEquals("Test",TestingPerson.getZip());
        break;
      case 6:
        assertEquals("Test",TestingPerson.getPhone());
        break;
      default:
        assertThrows(IllegalArgumentException.class, () -> {
          TestingPerson.getField(field);
        });
    }
  }
}
