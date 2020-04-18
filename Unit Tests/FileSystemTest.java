import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class FileSystemTest {
  Person testPerson;
  AddressBook testBook;

  @BeforeEach
  void setUp() {
    //Create instance of Person and Address Book
    testPerson = new Person("fname","lname","address","city","state",
        "zip","phone");
    testBook = new AddressBook();

  }

  //Test to read a file
  @Test
  void readFileTest() throws IOException, SQLException {
      //Add Person to the address book
      testBook.add(testPerson);
      //Create new File object
      File file = new File("readFile.txt");
      //Save the address book to the file, then read it
      new FileSystem().saveFile(testBook, file);
      new FileSystem().readFile(testBook, file);
      //Read file should have added Person read the file and added all Persons to address book,
      //So check to see that the person was added
      //assertTrue(file.exists());
      assertEquals("fname",testBook.get(0).getFirstName());
      //If file wasn't found, should produce FileNotFoundException
      assertThrows(FileNotFoundException.class , () -> {new FileSystem().readFile(testBook, new File("failFile.txt"));});

  }

  @Test
  void saveFileTest() {
    //Create new File object
    File f = new File("saveFile.txt");
    //Add Person to the address book
    testBook.add(testPerson);
    try{
      //Save the contents of the address book to the file we are pointing to
      new FileSystem().saveFile(testBook, f);
    } catch (Exception e){
      e.printStackTrace();
    }
    //If this worked, a file named saveFile.txt wouldve been created
    assertTrue(f.exists());
  }
}