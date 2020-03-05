import static org.junit.jupiter.api.Assertions.*;


import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

class PersonTest {

  @Test
  void getFirstName() {
    Person p = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
    String firstName = p.getFirstName();
    assertEquals("test",firstName);
  }

  @Test
  void getLastName() {
    Person p = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
    String lastName = p.getLastName();
    assertEquals("test",lastName);
  }

  @Test
  void getAddress() {
    Person p = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
    String address = p.getAddress();
    assertEquals("123 Test",address);
  }

  @Test
  void getCity() {
    Person p = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
    String city = p.getCity();
    assertEquals("Test",city);
  }

  @Test
  void getState() {
    Person p = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
    String state = p.getState();
    assertEquals("Test",state);
  }

  @Test
  void getZip() {
    Person p = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
    String zip = p.getZip();
    assertEquals("Test",zip);
  }

  @Test
  void getPhone() {
    Person p = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
    String phone = p.getPhone();
    assertEquals("Test",phone);

  }

//  @Test
//  void toString() {
//  }

  @Test
  void containsString() {
    String test = "test";
    Pattern p = Pattern.compile(Pattern.quote(test), Pattern.CASE_INSENSITIVE);
    Person person = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
    boolean found =
        p.matcher(person.getFirstName()).find()
            || p.matcher(person.getLastName()).find()
            || p.matcher(person.getAddress()).find()
            || p.matcher(person.getCity()).find()
            || p.matcher(person.getState()).find()
            || p.matcher(person.getZip()).find()
            || p.matcher(person.getPhone()).find();
    assertTrue(found);

  }


  void getField() {

  }
}