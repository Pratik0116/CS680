package edu.umb.cs680.hw05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SchoolObserverTest {

    private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(consoleOutput));
    }

    @Test
    public void testStudentObserver() {
        HighAuthority highAuthority = new HighAuthority();
        Student student = new Student("Pratik");
        highAuthority.addObserver(student);

        highAuthority.makeAnnouncement("School will be closed tomorrow due to Storm Warning.");

        String output = consoleOutput.toString();
        assertTrue(output.contains("Student Pratik received announcement: School will be closed tomorrow due to Storm Warning."));
    }

    @Test
    public void testTeacherObserver() {
        HighAuthority highAuthority = new HighAuthority();
        Teacher teacher = new Teacher("Junichi");
        highAuthority.addObserver(teacher);

        highAuthority.makeAnnouncement("Faculty meeting at 3 PM today.");

        String output = consoleOutput.toString();
        assertTrue(output.contains("Teacher Junichi received announcement: Faculty meeting at 3 PM today."));
    }

    @Test
    public void testWorkerObserver() {
        HighAuthority highAuthority = new HighAuthority();
        Worker worker = new Worker("Adam");
        highAuthority.addObserver(worker);

        highAuthority.makeAnnouncement("New cleaning schedule is posted.");

        String output = consoleOutput.toString();
        assertTrue(output.contains("Worker Adam received announcement: New cleaning schedule is posted."));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }
}
