import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class AddressBookTest {
  private List<Person> persons = new ArrayList<>();

  @Test
  void getPersons() {
    
  }

  @Test
  void add() {
    Person p = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
    persons.add(p);
    assertEquals(persons.size(),1);
  }

  @Test
  void set() {
    Person p = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
    persons.add(p);
    Person p2 = new Person("test2","test","123 Test", "Test", "Test", "Test", "Test");
    persons.set(0,p2);
    assertEquals("test2",persons.get(0).getFirstName());
  }

  @Test
  void remove() {
  }

  @Test
  void get() {
  }

  @Test
  void clear() {
  }

  @Test
  void getRowCount() {
  }

  @Test
  void getColumnCount() {
  }

  @Test
  void getValueAt() {
  }

  @Test
  void getColumnName() {
  }
}