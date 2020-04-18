import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class FileSystemTest {
  Person testPerson;
  AddressBook testBook;

  @BeforeEach
  void setUp() {
    testPerson = new Person("fname","lname","address","city","state",
        "zip","phone");
    testBook = new AddressBook();

  }

  @Test
  void readFileTest() throws IOException, SQLException {
      testBook.add(testPerson);
      File file = new File("readFile.txt");
      new FileSystem().saveFile(testBook, file);
      new FileSystem().readFile(testBook, file);
      assertTrue(file.exists());
      assertThrows(FileNotFoundException.class , () -> {new FileSystem().readFile(testBook, new File("failFile"));});

  }

  @Test
  void saveFileTest() {
    File f = new File("saveFile.txt");
    testBook.add(testPerson);
    try{
      new FileSystem().saveFile(testBook, f);
    } catch (Exception e){
      e.printStackTrace();
    }
    assertTrue(f.exists());
  }
}