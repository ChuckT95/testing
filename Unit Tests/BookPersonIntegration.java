import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class BookPersonIntegration {
  private Person TestingPerson;
  private Person TestingPerson2;
  private AddressBook addressBook;


  //Create a new Person before each testing method is executed
  @BeforeEach
  void setUp(){
    //Create new Person
    TestingPerson = new Person("fname1","lname1","123 Test1", "Test1", "Test", "Test", "Test");
    TestingPerson2 = new Person("fname2","lname2","123 Test2", "Test2", "Test", "Test", "Test");
    addressBook = new AddressBook();
    addressBook.add(TestingPerson);
    addressBook.add(TestingPerson2);
  }

  @Test
  public void getColumnCountTest(){
    assertEquals(7,addressBook.getColumnCount());
  }
  @Test
  public void getValueAtTest(){
    assertEquals("fname1",addressBook.getValueAt(0,1));
  }
  @Test
  public void getColumnNameTest(){
    assertEquals("First Name",addressBook.getColumnName(1));
  }
  @Test
  void getFirstName() {
    //Get First name of Person
    String firstName = addressBook.get(0).getFirstName();
    //Check first name matches
    Assertions.assertEquals("fname1",firstName);
  }

  @Test
  void getLastName() {
    //Get last name of Person
    String lastName = addressBook.get(0).getLastName();
    //Check last name matches
    Assertions.assertEquals("lname1",lastName);
  }

  @Test
  void getAddress() {
    //Get address  of Person
    String address = addressBook.get(0).getAddress();
    //Check address matches
    Assertions.assertEquals("123 Test1",address);
  }

  @Test
  void getCity() {
    //Get city of Person
    String city = addressBook.get(0).getCity();
    //Check city matches
    Assertions.assertEquals("Test1",city);
  }

  @Test
  void getState() {
    //Get state of Person
    String state = addressBook.get(0).getState();
    //Check state matches
    Assertions.assertEquals("Test",state);
  }

  @Test
  void getZip() {
    //Get zip of Person
    String zip = addressBook.get(0).getZip();
    //Check zip matches
    Assertions.assertEquals("Test",zip);
  }

  @Test
  void getPhone() {
    //Get phone of Person
    String phone = addressBook.get(0).getPhone();
    //Check phone matches
    Assertions.assertEquals("Test",phone);

  }


  @Test
  public void toStringTest(){
    //Should return string in form of "LastName, FirstName"
    assertEquals("lname1, fname1", addressBook.get(0).toString());
  }

  @Test
  void containsStringTest() {
    //Create a new Person
    Person stringPerson = new Person("this","is", "a", "test", "person", "for", "testing");
    addressBook.add(stringPerson);
    //Check to see that each string is contained in the Person
    assertTrue(addressBook.get(2).containsString("this"));
    assertTrue(addressBook.get(2).containsString("is"));
    assertTrue(addressBook.get(2).containsString("a"));
    assertTrue(addressBook.get(2).containsString("test"));
    assertTrue(addressBook.get(2).containsString("person"));
    assertTrue(addressBook.get(2).containsString("for"));
    assertTrue(addressBook.get(2).containsString("testing"));
    assertFalse(addressBook.get(2).containsString("fail"));
  }


  @ParameterizedTest
  @ValueSource(ints = { -1,0,1,2,3,4,5,6,7 })
  void getFieldTest(int field) {
    //go through all test inputs, should go through each case
    switch (field) {
      case 0:
        Assertions.assertEquals("lname1",addressBook.get(0).getField(field)); //Check first name
        break;
      case 1:
        Assertions.assertEquals("fname1",addressBook.get(0).getField(field)); //Check last name
        break;
      case 2:
        Assertions.assertEquals("123 Test1",addressBook.get(0).getField(field)); //Check address
        break;
      case 3:
        Assertions.assertEquals("Test1",addressBook.get(0).getField(field)); //Check city
        break;
      case 4:
        Assertions.assertEquals("Test",addressBook.get(0).getField(field)); //Check state
        break;
      case 5:
        Assertions.assertEquals("Test",addressBook.get(0).getField(field)); //Check zip
        break;
      case 6:
        Assertions.assertEquals("Test",addressBook.get(0).getField(field)); //Check phone
        break;
      default:
        //Out of bounds, check we throw an IllegalArgumentException
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
          addressBook.get(0).getField(field);
        });
    }
  }
  @Test
  public void clearTest(){
    //Empty the address book
    addressBook.clear();
    //Empty on an empty list will go inside branch
    //Note: Not possible to get persons == null, unreachable branch
    addressBook.clear();
    assertEquals(0,addressBook.getRowCount());
  }
  @Test
  public void personConstructorTest(){
    Assertions.assertThrows(IllegalArgumentException.class, () -> {Person TestingPerson2 = new Person(null, "test","123 Test", "Test", "Test", "Test", "Test");});
    Assertions.assertThrows(IllegalArgumentException.class, () -> {Person TestingPerson2 = new Person( "test", null,"123 Test", "Test", "Test", "Test", "Test");});
    Assertions.assertThrows(IllegalArgumentException.class, () -> {Person TestingPerson2 = new Person( "", "","123 Test", "Test", "Test", "Test", "Test");});
    Assertions.assertThrows(IllegalArgumentException.class, () -> {Person TestingPerson2 = new Person( "test", "","123 Test", "Test", "Test", "Test", "Test");});

  }

}
