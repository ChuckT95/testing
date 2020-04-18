import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;




public class ControllerIntegration{
    AddressBook addressBook = new AddressBook();
    private Person testingPerson;
    private Person testingPerson2;

    @BeforeEach
    void setUp(){
        //Create instances of a new Person
        testingPerson = new Person("test","test","123 Test", "Test", "Test", "Test", "Test");
        testingPerson2 = new Person("test2","test","123 Test", "Test", "Test", "Test", "Test");

    }

    @Test
    public void add() {
        //Add person to address book
        addressBook.add(testingPerson);
        assert(addressBook.get(0).getFirstName().equals("test"));
    }
    @Test
    public void set() {
        int index = 0;
        addressBook.add(testingPerson);
        addressBook.set(index, testingPerson2);
        assert(addressBook.get(0).getFirstName().equals("test2"));
    }
    @Test
    public void remove(){
        int index = 0;
        addressBook.add(testingPerson);
        addressBook.remove(index);
        assert(addressBook.getRowCount() == 0);
    }
    @Test
    public Person get() {
        addressBook.add(testingPerson);
        int index = 0;
        Person person = addressBook.get(0);
        assert(person.getFirstName().equals("test"));
        return(addressBook.get(0));
    }

    @Test
    public void clear() {
        addressBook.add(testingPerson);
        addressBook.clear();
        assert(addressBook.getRowCount() == 0);
    }

    @Test
    public void open(){
        assertThrows(UnsupportedOperationException.class, () -> {throw new UnsupportedOperationException("Not Supported yet");});
    }

    @Test
    public void save() throws SQLException {
        assertThrows(UnsupportedOperationException.class, () -> {throw new UnsupportedOperationException("Not Supported yet");});
    }

    @Test
    public void getModel() {
        assertThrows(UnsupportedOperationException.class, () -> {throw new UnsupportedOperationException("Not Supported yet");});
    }
}

