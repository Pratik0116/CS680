package edu.umb.cs680.hw16;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SchoolObserverTest {

    private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(consoleOutput));
    }

    @Test
    public void testStudentObserverWithLambda() {
        HighAuthority highAuthority = new HighAuthority();
        Observer<String> studentObserver = (sender, msg) ->
                System.out.println("Student received announcement: " + msg);
        highAuthority.addObserver(studentObserver);
        highAuthority.makeAnnouncement("School will be closed tomorrow due to Storm Warning.");
        String output = consoleOutput.toString();
        assertTrue(output.contains("Student received announcement: School will be closed tomorrow due to Storm Warning."));
    }

    @Test
    public void testTeacherObserver() {
        HighAuthority highAuthority = new HighAuthority();
        Observer<String> teacherObserver = (sender, msg) ->
                System.out.println("Teacher received announcement: " + msg);
        highAuthority.addObserver(teacherObserver);
        highAuthority.makeAnnouncement("Faculty meeting at 3 PM today.");
        String output = consoleOutput.toString();
        assertTrue(output.contains("Teacher received announcement: Faculty meeting at 3 PM today."));
    }

    @Test
    public void testWorkerObserver() {
        HighAuthority highAuthority = new HighAuthority();
        Observer<String> workerObserver = (sender, msg) ->
                System.out.println("Worker received announcement: " + msg);
        highAuthority.addObserver(workerObserver);
        highAuthority.makeAnnouncement("New cleaning schedule is posted.");
        String output = consoleOutput.toString();
        assertTrue(output.contains("Worker received announcement: New cleaning schedule is posted."));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }
}
