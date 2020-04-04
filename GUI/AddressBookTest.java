import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.jmock.junit5.*;



class AddressBookTest {

  private List<Person> persons = new ArrayList<>();
  private Person TestingPerson;
  private Person TestingPerson2;


  //Execute this method before each test method is executed
  //This creates two new Person Objects
  @BeforeEach
  void setUp(){
    TestingPerson = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
    TestingPerson2 = new Person("test2","test","123 Test", "Test", "Test", "Test", "Test");

  }


  @Test
  void getPersons() {
    persons.add(TestingPerson); //Add person to list
    persons.add(TestingPerson2); //Add another person to list
    Person[] pArr = new Person[] {TestingPerson,TestingPerson2}; //Create array containing all Persons
    assertArrayEquals(pArr,persons.toArray()); //Check if both arrays are equivalent
  }

  @Test
  //Test the add method
  void add() {
    persons.add(TestingPerson); //Add Person to list
    assertEquals(persons.size(),1); //Check that the size of the new list contains one Person
  }

  @Test
  void set() {
    persons.add(TestingPerson); //Add Person to list
    persons.set(0,TestingPerson2); //Replace the 1st element in list with new Person
    //Check that the list now contains the second Person object instead of the first Person
    assertEquals("test2",persons.get(0).getFirstName());
  }

  @Test
  void remove() {
    persons.add(TestingPerson); //Add Person to list
    persons.remove(0); //Remove the Person that was just added
    assertEquals(0,persons.size()); //Check that there are now no elements in the list
  }

  @ParameterizedTest
  @ValueSource(ints = {0,1})
  void get(int index) {
    persons.add(TestingPerson); //Add Person 1 to list
    persons.add(TestingPerson2); //Add Person 2 to list

    //If we are testing 0, we should get the first person in the list
    //If we are testing 1, we should get the second person in the list
    if(index == 0){
      assertEquals(TestingPerson,persons.get(index));
    }
    else{
      assertEquals(TestingPerson2,persons.get(index));
    }
  }

  @Test
  void clear() {
    persons.add(TestingPerson); //Add Person to list
    persons.clear(); //Clear the list
    assertEquals(0,persons.size()); //Check that list contains 0 elements
  }

  @Test
  void getRowCount() {
    persons.add(TestingPerson); //Add Person 1 to list
    persons.add(TestingPerson2); //Add Person 2 to list

    assertEquals(2,persons.size()); //Check that 2 Persons were added to list
  }

  @Test
  void getColumnCount() {
    assertEquals(7,Person.fields.length); //Check that the Person has 7 attributes to it
  }

  @Test
  void getValueAt() {
    int row = 0, col = 4; //Take an arbitrary value
    persons.add(TestingPerson); //Add Person to list

    assertEquals("Test",persons.get(row).getField(col)); //Check we get the right value at that row, col input
  }

  @Test
  void getColumnName() {
    int col = 3; //Take arbitrary column

    assertEquals("City",Person.fields[col]); //Check the arbitrary column matches
  }

}