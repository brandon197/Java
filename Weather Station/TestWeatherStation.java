import static org.junit.Assert.*;

import org.junit.Test;

public class TestWeatherStation {

	@Test
	public void testWeatherStation1() {
		/* Create a new weather station with initial
		 * temperature 23 degree C and pressure 1017 mb  
		 */
		WeatherStation ws = new WeatherStation(23.2, 1017.5);
		assertEquals(23.2, ws.getTemperature(), 0.01);
		assertEquals(1017.5, ws.getPressure(), 0.01);
		
		/*
		 * Temperature drops and pressure increases.
		 */
		ws.set_measurements(17.8, 1025.6);
		assertEquals(17.8, ws.getTemperature(), 0.01);
		assertEquals(1025.6, ws.getPressure(), 0.01);
	}
	
	@Test
	public void testWeatherStation2() { 
		WeatherStation ws = new WeatherStation(23.2, 1017.5);
		WeatherObserver obs1 = new StatisticsApp();
		WeatherObserver obs2 = new ForecastApp();
		
		/* Both observers not yet subscribed to the weather station */
		assertNull(obs1.getWeatherStation());
		assertNull(obs2.getWeatherStation());
		WeatherObserver[] observers = ws.getObservers();
		assertEquals(0, observers.length);
		
		/* Subscribe both observers to the weather station */
		ws.subscribe(obs1);
		ws.subscribe(obs2);
		assertTrue(ws == obs1.getWeatherStation());
		assertTrue(ws == obs2.getWeatherStation());
		observers = ws.getObservers();
		assertEquals(2, observers.length);
		assertTrue(observers[0] == obs1);
		assertTrue(observers[1] == obs2);
		
		/* Unsubscribe an observer */
		ws.unsubscribe(obs1);
		assertNull(obs1.getWeatherStation());
		assertTrue(ws == obs2.getWeatherStation());
		observers = ws.getObservers();
		assertEquals(1, observers.length);
		assertTrue(observers[0] == obs2); 
		
		/* Unsubscribe an observer */
		ws.unsubscribe(obs2);
		assertNull(obs1.getWeatherStation());
		assertNull(obs2.getWeatherStation());
		observers = ws.getObservers();
		assertEquals(0, observers.length);
	}
	
	@Test
	public void testWeatherStation3() { 
		WeatherStation ws = new WeatherStation(23.2, 1017.5);
		StatisticsApp obs1 = new StatisticsApp();
		
		/* Subscribe an observer to the weather station */
		ws.subscribe(obs1);
		
		/* publish the latest readings to subscribed observers */
		ws.publish();
		
		/* Getting observer calculations based on one reading */
		assertEquals(23.2, obs1.getMinTemperature(), 0.01);
		assertEquals(23.2, obs1.getMaxTemperature(), 0.01);
		assertEquals(23.2, obs1.getAverageTemperature(), 0.01);
		
		/*
		 * Temperature drops and pressure increases.
		 */
		ws.set_measurements(17.8, 1025.6);
		
		/* publish the latest readings to both observers */
		ws.publish();
		
		/* Getting observer calculations based on two readings */
		assertEquals(17.8, obs1.getMinTemperature(), 0.01);
		assertEquals(23.2, obs1.getMaxTemperature(), 0.01);
		assertEquals(20.5, obs1.getAverageTemperature(), 0.01);
	}
	
	@Test
	public void testWeatherStation4() { 
		WeatherStation ws = new WeatherStation(23.2, 1017.5);
		ForecastApp obs2 = new ForecastApp();
		
		/* Subscribe an observer to the weather station */
		ws.subscribe(obs2);
		
		/* publish the latest readings to subscribed observers */
		ws.publish();
		
		/* Getting observer calculations based on one reading */
		assertEquals(1017.5, obs2.getCurrentPressure(), 0.01);
		assertEquals(1017.5, obs2.getLastPressure(), 0.01);
		assertFalse(obs2.isLikelyToRain());
		
		/*
		 * Temperature drops and pressure drops.
		 */
		ws.set_measurements(17.8, 1014.8);
		
		/* publish the latest readings to both observers */
		ws.publish();
		
		/* Getting observer calculations based on two readings */
		assertEquals(1014.8, obs2.getCurrentPressure(), 0.01);
		assertEquals(1017.5, obs2.getLastPressure(), 0.01);
		assertTrue(obs2.isLikelyToRain());
		
		/*
		 * Temperature increases and pressure increases.
		 */
		ws.set_measurements(17.8, 1015.3);
		
		/* publish the latest readings to both observers */
		ws.publish();
		
		assertEquals(1015.3, obs2.getCurrentPressure(), 0.01);
		assertEquals(1014.8, obs2.getLastPressure(), 0.01);
		assertFalse(obs2.isLikelyToRain());
	}
}
