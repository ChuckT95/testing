import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AddressBookTest {

  private List<Person> persons = new ArrayList<>();
  private Person TestingPerson;
  private Person TestingPerson2;


  @BeforeEach
  void setUp(){
    TestingPerson = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
    TestingPerson2 = new Person("test2","test","123 Test", "Test", "Test", "Test", "Test");
  }


  @Test
  void getPersons() {
    persons.add(TestingPerson);
    persons.add(TestingPerson2);
    Person[] pArr = new Person[] {TestingPerson,TestingPerson2};
    assertArrayEquals(pArr,persons.toArray());
  }

  @Test
  void add() {
    persons.add(TestingPerson);
    assertEquals(persons.size(),1);
  }

  @Test
  void set() {
    persons.add(TestingPerson);
    persons.set(0,TestingPerson2);
    assertEquals("test2",persons.get(0).getFirstName());
  }

  @Test
  void remove() {
    persons.add(TestingPerson);
    persons.remove(0);
    assertEquals(0,persons.size());
  }

  @ParameterizedTest
  @ValueSource(ints = {0,1})
  void get(int index) {
    persons.add(TestingPerson);
    persons.add(TestingPerson2);

    if(index == 0){
      assertEquals(TestingPerson,persons.get(index));
    }
    else{
      assertEquals(TestingPerson2,persons.get(index));
    }
  }

  @Test
  void clear() {
    persons.add(TestingPerson);
    persons.clear();
    assertEquals(0,persons.size());
  }

  @Test
  void getRowCount() {
    persons.add(TestingPerson);
    persons.add(TestingPerson2);

    assertEquals(2,persons.size());
  }

  @Test
  void getColumnCount() {
    assertEquals(7,Person.fields.length);
  }

  @Test
  void getValueAt() {
    int row = 0, col = 4;
    persons.add(TestingPerson);

    assertEquals("Test",persons.get(row).getField(col));
  }

  @Test
  void getColumnName() {
    int col = 3;

    assertEquals("City",Person.fields[col]);
  }
}