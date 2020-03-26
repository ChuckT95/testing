import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        assertEquals(persons.size(),1); //Check that the size of the new list contains one Person
    }

}

