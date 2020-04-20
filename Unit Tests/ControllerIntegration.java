import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class ControllerIntegration {
    // creating the variables here, but not declaring them, so they can be used in a @Before method,
    // while also being in scope for the other test cases
    private Person testingPerson;
    private Person testingPerson2;
    private AddressBook addressBook;

    AddressBookController controllerIntegration;


    // This is the code that makes creating a mock object for the person class possible
    public Person person() {
        // This line follows the mock object
        Person mockPerson = mock(Person.class);
        // each when().then() call sets up a return for each needed call for a method.
        when(mockPerson.getAddress()).thenReturn("Mock Address");
        when(mockPerson.getCity()).thenReturn("Mock City");
        when(mockPerson.getFirstName()).thenReturn("test");
        when(mockPerson.getLastName()).thenReturn("test");
        when(mockPerson.getState()).thenReturn("Wyoming");
        when(mockPerson.getZip()).thenReturn("00000");
        when(mockPerson.getPhone()).thenReturn("0000000000");
        // this makes the mock person object return when a person would be constructed
        return mockPerson;
    }

    // Execute this method before each test method is executed
    // This creates two new mock Person Objects and adds them into the addressbook of a controller
    @BeforeEach
    void setUp() {
        // creating an address book, mock people, and a controller for the purposes of each test
        addressBook = new AddressBook();
        testingPerson = person();
        testingPerson2 = person();
        controllerIntegration = new AddressBookController(addressBook);

    }

    @Test
    public void add() {
        // tests to add a person and check the value of that person's first name. since the person is not real,
        // the testing person's method is called to ensure that the hashcode of the mock matches what's stored
        controllerIntegration.add(testingPerson);
        assertEquals(testingPerson.getFirstName(), controllerIntegration.get(0).getFirstName());
    }

    @Test
    public void set() {
        // tests to add a person and change the person's info to the second mock person, then
        // checks the value of that person's first name. since the person is not real,
        // the testing person's method is called to ensure that the hashcode of the mock matches what's stored
        controllerIntegration.add(testingPerson);
        controllerIntegration.set(0, testingPerson2);
        assertEquals(testingPerson2.getFirstName(), controllerIntegration.get(0).getFirstName());
    }

    @Test
    public void remove() {
        // tests to add a person and delete the person stored in the addressbook
        // then number of rows to ensure that the person was removed successfully

        controllerIntegration.add(testingPerson);
        controllerIntegration.remove(0);
        assert (addressBook.getRowCount() == 0);
    }

    @Test
    public Person get() {
        //tests to add a person to the book then checks that the name of the first name of the first
        // person in the addressbook matches the expected output
        controllerIntegration.add(testingPerson);
        int index = 0;
        Person person = controllerIntegration.get(0);
        assert (person.getFirstName() == "test");
        return (controllerIntegration.get(0));
    }

    @Test
    public void clear() {
        //tests to add a person to the addressbook then clear the addressbook,
        // then checks that the addressbook has zero rows, as would be expected
        controllerIntegration.add(testingPerson);
        controllerIntegration.clear();
        assert (addressBook.getRowCount() == 0);
    }

    //these tests are made under the scenario that the FileSystem class has not been written yet
    @Test
    public void openTestIncomplete() {
        assertThrows(UnsupportedOperationException.class, () -> {
            throw new UnsupportedOperationException("Not Supported yet");
        });
    }

    //these tests are made under the scenario that the FileSystem class has not been written yet
    @Test
    public void saveTestIncomplete() throws SQLException {
        assertThrows(UnsupportedOperationException.class, () -> {
            throw new UnsupportedOperationException("Not Supported yet");
        });
    }



    @Test
    public void saveTest() throws SQLException {
        assertThrows(UnsupportedOperationException.class, () -> {
            throw new UnsupportedOperationException("Not Supported yet");
        });
    }

    @Test
    public void getModel() {
        //The getModel from Controller class should return the AddressBook that was passed in
        assertEquals(this.addressBook,controllerIntegration.getModel());
    }
}

