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
public class FileSystemIntegration {
  private AddressBook addressBook;
  private AddressBookController testController;
  private Person testingPerson;
  private Person testingPerson2;

  @BeforeEach
  void setUp() {
    //Create instances of Address Book, 2 People, and a Controller
    addressBook = new AddressBook();
    testingPerson = new Person("test", "test", "123 Test", "Test", "Test", "Test", "Test");
    testingPerson2 = new Person("test2", "test2", "123 Test2", "Test2", "Test2", "Test2", "Test2");
    testController= new AddressBookController(addressBook);

  }
  @Test
  public void openTest() throws SQLException, FileNotFoundException{
    //Create a File object that should already exist
    File file = new File("testOpen.txt");
    //Add Person 1 and 2 to address book
    addressBook.add(testingPerson);
    addressBook.add(testingPerson2);
    //Save the controller data to the file
    testController.save(file);
    //Clear the address book so nothing exists in it
    addressBook.clear();
    //Now open the file we just saved from the controller. It should load the address book with
    //The Persons we just added
    testController.open(file);
    //Check to see that Person 1 is there in the first row
    assertEquals("test",testController.getModel().getValueAt(0,0));
    //If we cant find File, we should expect to get a FileNotFoundException
    assertThrows(FileNotFoundException.class, () -> { testController.open(new File("Fail.txt"));});
  }

}
