import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PersonBookIntegration {
    private List<Person> persons = new ArrayList<>();

    public Person person(){
        Person mockPerson = mock(Person.class);
        when(mockPerson.getAddress()).thenReturn("Mock Address");
        when(mockPerson.getCity()).thenReturn("Mock City");
        when(mockPerson.getFirstName()).thenReturn("Mocky");
        when(mockPerson.getLastName()).thenReturn("Mockerton");
        when(mockPerson.getState()).thenReturn("Wyoming");
        when(mockPerson.getZip()).thenReturn("00000");
        when(mockPerson.getPhone()).thenReturn("0000000000");

        return mockPerson;
    }


    @Test
        //Test the add method
    void add() {
        persons.add(person()); //Add Person to list
        assertEquals(persons.get(0).getFirstName(), "Mocky"); //Check that the size of the new list contains one Person
    }
//    @Test
//    void getPersons() {
//        persons.add(person()); //Add person to list
//        Person[] pArr = new Person[] {person()}; //Create array containing all Persons
//        assertArrayEquals(pArr,persons.toArray()); //Check if both arrays are equivalent
//    }

    @Test
    void set() {
        persons.add(person()); //Add Person to list
        persons.set(0,person()); //Replace the 1st element in list with new Person
        //Check that the list now contains the second Person object instead of the first Person
        assertEquals("Mocky",persons.get(0).getFirstName());
    }

    @Test
    void remove() {
        persons.add(person()); //Add Person to list
        persons.remove(0); //Remove the Person that was just added
        assertEquals(0,persons.size()); //Check that there are now no elements in the list
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    void get(int index) {
        persons.add(person()); //Add Person 1 to list

        //since this is a mock test for person, we cannot test the choice of number
            assertEquals("Mocky",persons.get(index).getFirstName());
    }

    @Test
    void clear() {
        persons.add(person()); //Add Person to list
        persons.clear(); //Clear the list
        assertEquals(0,persons.size()); //Check that list contains 0 elements
    }

    @Test
    void getRowCount() {
        persons.add(person()); //Add Person 1 to list

        assertEquals(1,persons.size()); //Check that 2 Persons were added to list
    }

    @Test
    void getColumnCount() {
        assertEquals(7,Person.fields.length); //Check that the Person has 7 attributes to it
    }

//todo switch values

//    @Test
//    void getValueAt() {
//        int row = 0, col = 4; //Take an arbitrary value
//        persons.add(person()); //Add Person to list
//
//        assertEquals("Test",persons.get(row).getField(col)); //Check we get the right value at that row, col input
//    }

    @Test
    void getColumnName() {
        int col = 3; //Take arbitrary column

        assertEquals("City",Person.fields[col]); //Check the arbitrary column matches
    }
}

