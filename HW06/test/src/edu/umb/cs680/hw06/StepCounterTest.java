package edu.umb.cs680.hw06;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class StepCounterTest {

    private StepCounter stepCounter;
    private TrackApp trackApp;

    @Before
    public void setUp(){
        trackApp = new TrackApp();
        stepCounter = new StepCounter();
    }

    @Test
    public void testStepCounterChanged(){
        stepCounter.addObserver(trackApp);
        stepCounter.updateStepCount(300);
        assertEquals(300,trackApp.getReceivedStepCount());
    }

    @Test
    public void testMultipleObservers() {
        TrackApp anotherApp = new TrackApp();

        stepCounter.addObserver(trackApp);
        stepCounter.addObserver(anotherApp);
        stepCounter.updateStepCount(300);

        assertEquals(300, trackApp.getReceivedStepCount());
        assertEquals(300, anotherApp.getReceivedStepCount());
    }

    @Test
    public void testRemoveObserver() {
        stepCounter.addObserver(trackApp);
        stepCounter.removeObserver(trackApp);
        stepCounter.updateStepCount(400);

        assertNull(trackApp.getReceivedLocation());
    }
}
