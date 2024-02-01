package edu.umb.cs680.hw06;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocationSensorTest {
    private LocationSensor locationSensor;
    private TrackApp trackApp;

    @BeforeEach
    public void setUp() {
        locationSensor = new LocationSensor();
        trackApp = new TrackApp();
    }

    @Test
    public void testLocationUpdate() {
        locationSensor.addObserver(trackApp);
        locationSensor.updateLocation(42.36, -71.06);

        Location receivedLocation = trackApp.getReceivedLocation();
        assertEquals(42.36, receivedLocation.getLatitude());
        assertEquals(-71.06, receivedLocation.getLongitude());
    }

    @Test
    public void testMultipleObservers() {
        TrackApp anotherApp = new TrackApp();

        locationSensor.addObserver(trackApp);
        locationSensor.addObserver(anotherApp);
        locationSensor.updateLocation(12.23, 17.06);

        Location receivedLocation = trackApp.getReceivedLocation();
        Location receivedLocationAnother = anotherApp.getReceivedLocation();

        assertEquals(12.23, receivedLocation.getLatitude());
        assertEquals(17.06, receivedLocation.getLongitude());

        assertEquals(12.23, receivedLocationAnother.getLatitude());
        assertEquals(17.06, receivedLocationAnother.getLongitude());
    }

    @Test
    public void testRemoveObserver() {
        locationSensor.addObserver(trackApp);
        locationSensor.removeObserver(trackApp);
        locationSensor.updateLocation(12.23, 17.06);

        assertNull(trackApp.getReceivedLocation());
    }

}