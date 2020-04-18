import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.jmock.junit5.*;



class AddressBookTest {

  private AddressBook addressBook;
  private Person TestingPerson;
  private Person TestingPerson2;


  //Execute this method before each test method is executed
  //This creates two new Person Objects
  @BeforeEach
  void setUp(){
    addressBook = new AddressBook();
    TestingPerson = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
    TestingPerson2 = new Person("test2","test","123 Test", "Test", "Test", "Test", "Test");

  }


  @Test
  void getPersonsTest() {
    addressBook.add(TestingPerson);
    addressBook.add(TestingPerson2);
    Person[] pArr = new Person[] {TestingPerson,TestingPerson2}; //Create array containing all Persons
    assertArrayEquals(pArr, addressBook.getPersons()); //Check if both arrays are equivalent
  }

  @Test
  //Test the add method
  void add() {
    addressBook.add(TestingPerson); //Add Person to list
    assertEquals(addressBook.getRowCount(),1); //Check that the size of the new list contains one Person
  }

  @Test
  void set() {
    addressBook.add(TestingPerson); //Add Person to list
    addressBook.set(0,TestingPerson2); //Replace the 1st element in list with new Person
    //Check that the list now contains the second Person object instead of the first Person
    assertEquals("test2", addressBook.get(0).getFirstName());
  }

  @Test
  void remove() {
    addressBook.add(TestingPerson); //Add Person to list
    addressBook.remove(0); //Remove the Person that was just added
    assertEquals(0,addressBook.getRowCount()); //Check that there are now no elements in the list
  }

  @ParameterizedTest
  @ValueSource(ints = {0,1})
  void get(int index) {

    addressBook.add(TestingPerson); //Add Person 1 to list
    addressBook.add(TestingPerson2); //Add Person 2 to list

    //If we are testing 0, we should get the first person in the list
    //If we are testing 1, we should get the second person in the list
    if(index == 0){
      assertEquals(TestingPerson, addressBook.get(index));
    }
    else{
      assertEquals(TestingPerson2, addressBook.get(index));
    }
    addressBook.clear();
    assertEquals(0, addressBook.getRowCount());

  }

  @Test
  void clear() {
//    AddressBook addressBook1 = new AddressBook(); //this was another attempt to cover that branch
//    addressBook1.clear();
//    assertEquals(null, addressBook.getPersons());
    addressBook.add(TestingPerson); //Add Person to list
    addressBook.clear(); //Clear the list
    assertEquals(0,addressBook.getRowCount()); //Check that list contains 0 elements
    addressBook.clear();
    assertEquals(0, addressBook.getRowCount());

//    addressBook.clear(); //there is a second branch here, which is impossible to test,
    // because persons is declared as a new array in the constructor, so it is never null, and persons is private,
    // so cannot be directly set to null
    // assertEquals(null, addressBook.getPersons());
  }

  @Test
  void getRowCount() {
    addressBook.add(TestingPerson); //Add Person 1 to list
    addressBook.add(TestingPerson2); //Add Person 2 to list

    assertEquals(2,addressBook.getRowCount()); //Check that 2 Persons were added to list
  }

  @Test
  void getColumnCountTest() {
    assertEquals(7, addressBook.getColumnCount()); //Check that the Person has 7 attributes to it
  }

  @Test
  void getValueAt() {
    int row = 0, col = 4; //Take an arbitrary value
    addressBook.add(TestingPerson); //Add Person to list

    assertEquals("Test",addressBook.getValueAt(row, col)); //Check we get the right value at that row, col input
  }

  @Test
  void getColumnName() {
    int col = 3; //Take arbitrary column

    assertEquals("City",addressBook.getColumnName(col)); //Check the arbitrary column matches
  }

}