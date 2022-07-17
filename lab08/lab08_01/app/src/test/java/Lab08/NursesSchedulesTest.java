package Lab08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class NursesSchedulesTest {
    String basePath;

    @BeforeEach
    public void init(){
        basePath = "C:\\Users\\Alex\\IdeaProjects\\lab08\\";

    }

    @Test
    public void generateN1Schedule() throws IOException {
        String line = Files.readAllLines(Paths.get(basePath + "n1_schedule.txt")).get(0);
        assertEquals("Nurse Name: Margaret Atwood", line);
    }

    @Test
    public void generateN2Schedule() throws IOException {
        String line = Files.readAllLines(Paths.get(basePath + "n2_schedule.txt")).get(0);
        assertEquals("Nurse Name: Alexander Solzhenitsyn", line);
    }

    @Test
    public void generateN3Schedule() throws IOException {
        String line = Files.readAllLines(Paths.get(basePath + "n3_schedule.txt")).get(0);
        assertEquals("Nurse Name: Charles Dickens", line);
    }

    @Test
    public void generateN4Schedule() throws IOException {
        String line = Files.readAllLines(Paths.get(basePath + "n4_schedule.txt")).get(0);
        assertEquals("Nurse Name: Williams Wordsworth", line);
    }

    @Test
    public void generateN5Schedule() throws IOException {
        String line = Files.readAllLines(Paths.get(basePath + "n5_schedule.txt")).get(0);
        assertEquals("Nurse Name: Homer", line);
    }

    @Test
    public void generateN6Schedule() throws IOException {
        String line = Files.readAllLines(Paths.get(basePath + "n6_schedule.txt")).get(0);
        assertEquals("Nurse Name: Socrates", line);
    }
}