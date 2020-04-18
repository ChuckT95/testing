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

public class ControllerTest {
    private AddressBook addressBook;
    private AddressBookController testController;
    private Person testingPerson;
    private Person testingPerson2;

    @BeforeEach
    void setUp() {
        addressBook = new AddressBook();
        testingPerson = new Person("test", "test", "123 Test", "Test", "Test", "Test", "Test");
        testingPerson2 = new Person("test2", "test2", "123 Test2", "Test2", "Test2", "Test2", "Test2");
        testController= new AddressBookController(addressBook);

    }

    @Test
    void ControllerConstructorTest() {
        AddressBookController controllerTest = new AddressBookController(addressBook);
        assertEquals(controllerTest.getModel(), addressBook);
    }


    @Test
    public void addTest() {
        testController.add(testingPerson);
        assertEquals("test", addressBook.get(0).getFirstName());
    }

    @Test
    public void setTest() {
        testController.add(testingPerson);
        testController.set(0, testingPerson2);
        assertEquals("test2", addressBook.get(0).getFirstName());
    }

    @Test
    public void removeTest(){
        testController.add(testingPerson);
        testController.remove(0);
        assertEquals(0, addressBook.getRowCount());
    }

    @Test
    public void getTest(){
        testController.add(testingPerson);
        assertEquals(testingPerson, testController.get(0));
    }

    @Test
    public void clearTest(){
        testController.add(testingPerson);
        testController.clear();
        assertEquals(0,addressBook.getRowCount());
    }

    @Test
    void openTest() throws FileNotFoundException, SQLException {
        File file = new File("testOpen.txt");
        addressBook.add(testingPerson);
        addressBook.add(testingPerson2);
        testController.save(file);
        testController.open(file);
        assertEquals("test",addressBook.getValueAt(0,0));

        assertThrows(FileNotFoundException.class, () -> { testController.open(new File("Fail.txt"));});
    }



    @Test
    public void getModelTest(){
        testController.add(testingPerson);
        assertEquals(addressBook, testController.getModel());
    }
}