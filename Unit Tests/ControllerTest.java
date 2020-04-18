import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class    ControllerTest {
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
    void ControllerConstructorTest() {
        //Create a instance of Controller, which will invoke Constructor when passing
        //in an Address Book
        AddressBookController controllerTest = new AddressBookController(addressBook);
        //The model of the controller should be the address book that was passed in
        assertEquals(controllerTest.getModel(), addressBook);
    }


    @Test
    public void addTest() {
        //Add Person to the controller
        testController.add(testingPerson);
        //Check to see if the Person object is in the address book
        assertEquals(testingPerson, addressBook.get(0));
    }

    @Test
    public void setTest() {
        //Add Person to the controller
        testController.add(testingPerson);
        //Replace the already added Person with a new Person
        testController.set(0, testingPerson2);
        //Check to see that the old person was replaced with new one
        assertEquals(testingPerson2, addressBook.get(0));
    }

    @Test
    public void removeTest(){
        //Add Person to the controller
        testController.add(testingPerson);
        //Remove Person from the controller
        testController.remove(0);
        //Check to see that there are no Persons in the address book
        assertEquals(0, addressBook.getRowCount());
    }

    @Test
    public void getTest(){
        //Add Person to the controller
        testController.add(testingPerson);
        //Check to see if we can get the person we added, which would be at the beginning
        assertEquals(testingPerson, testController.get(0));
    }

    @Test
    public void clearTest(){
        //Add Person 1 and 2 to the controller
        testController.add(testingPerson);
        testController.add(testingPerson2);
        //Clear the controller
        testController.clear();
        //Check to see the address book contains 0 elements
        assertEquals(0,addressBook.getRowCount());
    }

    //Test to see if we can open an address book from a file
    @Test
    void openTest() throws FileNotFoundException, SQLException {
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
        assertEquals("test",addressBook.getValueAt(0,0));
        //If we cant find File, we should expect to get a FileNotFoundException
        assertThrows(FileNotFoundException.class, () -> { testController.open(new File("Fail.txt"));});
    }



    @Test
    public void getModelTest(){
        //Add Person to the controller
        testController.add(testingPerson);
        //Check that the model of the Controller returns the original address book.
        assertEquals(addressBook, testController.getModel());
    }
}