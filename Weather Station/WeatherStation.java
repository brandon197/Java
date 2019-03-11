import java.util.*;

/**
 * A weather station measures temperature and pressure and has a list of
 * subscribed weather observers. When there is an update on the measures, the
 * weather station publishes the update to all currently-subscribed observers.
 */
public class WeatherStation {

	/*
	 * Your Task: Declare an attribute for the ***list*** of subscribed weather
	 * observers.
	 */
	List<WeatherObserver> subs;
	double temp;
	double pres;

	/**
	 * Initialize a new weather station.
	 * 
	 * @param t
	 *            initial temperature measure
	 * @param p
	 *            initial pressure measure
	 */
	public WeatherStation(double t, double p) {
		subs = new ArrayList<WeatherObserver>();
		temp = t;
		pres = p;

	}

	/**
	 * Subscribe the input weather observer o as one of the observers of the current
	 * weather station. Add the input o to the list of subscribed observers.
	 * 
	 * @param o
	 *            a weather observer
	 */
	public void subscribe(WeatherObserver o) {
		subs.add(o);
		o.setWeatherStation(this);
		/* Your Task */
	}

	/**
	 * Unsubscribe the input weather observer o from the list of observers of the
	 * current weather station. Remove the input o from the list of subscribed
	 * observers. Assume that the input o is an already-subscribed observer.
	 * 
	 * @param o
	 *            a weather observer
	 */
	public void unsubscribe(WeatherObserver o) {
		o.setWeatherStation(null);
		subs.remove(o);

		/* Your Task */
	}

	/**
	 * Publish the latest readings of weather data to all subscribed observers. That
	 * is, perform an update on each subscribed observer.
	 */
	public void publish() {
		for (WeatherObserver s : subs) {
			s.update();
		}
	}

	/**
	 * Get the list of subscribed weather observers.
	 * 
	 * @return an array of subscribed weather observers.
	 */
	public WeatherObserver[] getObservers() {
		/* Your Task */
		WeatherObserver[] t = new WeatherObserver[subs.size()];
		subs.toArray(t);
		return t;
	}

	/**
	 * Get the latest temperature measure.
	 * 
	 * @return latest temperature measure
	 */
	public double getTemperature() {
		/* Your Task */
		return temp;
	}

	/**
	 * Get the latest pressure measure.
	 * 
	 * @return latest pressure measure
	 */
	public double getPressure() {
		/* Your Task */
		return pres;
	}

	/**
	 * Update the weather data
	 * 
	 * @param t
	 *            new temperature measure
	 * @param p
	 *            new pressure measure
	 */
	public void set_measurements(double t, double p) {
		temp = t;
		pres = p;
		// publish();
	}
}