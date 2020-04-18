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
    //Create instance of an address book
    addressBook = new AddressBook();
    //Create Test people to use later
    TestingPerson = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
    TestingPerson2 = new Person("test2","test","123 Test", "Test", "Test", "Test", "Test");

  }


  //Method to test if an the correct array of Person'sis returned
  @Test
  void getPersonsTest() {
    //Add the two People to the address book
    addressBook.add(TestingPerson);
    addressBook.add(TestingPerson2);
    //Create an array with the same two people
    Person[] pArr = new Person[] {TestingPerson,TestingPerson2};
    //Check to see if both the address book and array are equal
    assertArrayEquals(pArr, addressBook.getPersons());
  }

  @Test
  //Test the add method
  void add() {
    //Add person to address book
    addressBook.add(TestingPerson);
    //Check that the TestingPerson was added to the first entry of the address book
    assertEquals(TestingPerson,addressBook.get(0));
  }

  @Test
  void set() {
    //Add Person to address book
    addressBook.add(TestingPerson);
    //Replace the 1st element in list with new Person
    addressBook.set(0,TestingPerson2);
    //Check that the list now contains the second Person object instead of the first Person
    assertEquals(TestingPerson2, addressBook.get(0));
  }

  @Test
  void remove() {
    //Add Person to address book
    addressBook.add(TestingPerson);
    //Remove the Person that was just added
    addressBook.remove(0);
    //Check that there are now no elements in the list
    assertEquals(0,addressBook.getRowCount());
  }

  @ParameterizedTest
  @ValueSource(ints = {0,1})
  void get(int index) {
    //Add Person 1 to address book
    addressBook.add(TestingPerson);
    addressBook.add(TestingPerson2);

    //If we are testing 0, we should get the first person in the list
    //If we are testing 1, we should get the second person in the list
    if(index == 0){
      assertEquals(TestingPerson, addressBook.get(index));
    }
    else{
      assertEquals(TestingPerson2, addressBook.get(index));
    }

  }

  @Test
  void clear() {
    //Add Person to address book
    addressBook.add(TestingPerson);
    //Clear the list
    addressBook.clear();
    //Check that list contains 0 elements
    assertEquals(0,addressBook.getRowCount());

  }

  @Test
  void getRowCount() {
    //Add Person 1 and 2 to address book
    addressBook.add(TestingPerson);
    addressBook.add(TestingPerson2);

    //Check that 2 Persons were added to list
    assertEquals(2,addressBook.getRowCount());
  }

  @Test
  void getColumnCountTest() {
    //Check that the Person has 7 attributes to it
    assertEquals(7, addressBook.getColumnCount());
  }

  @Test
  void getValueAt() {
    //Take an arbitrary value, in this case, (0,4) represents the city attribute of the Person
    int row = 0, col = 4;
    //Add Person to address book
    addressBook.add(TestingPerson);
    //Check we get the right value at that row, col input
    assertEquals("Test",addressBook.getValueAt(row, col));
  }

  @Test
  void getColumnName() {
    int col = 3; //Take arbitrary column, in this case, 3 is the City index
    //Check the arbitrary column matches
    assertEquals("City",addressBook.getColumnName(col));
  }

}