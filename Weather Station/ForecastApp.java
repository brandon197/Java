import java.util.*;

/**
 * A weather forecast app determines if the pressure readings from its
 * subscribed weather station, if any, indicate it is likely to rain due to a
 * reduction on the pressure level.
 */
public class ForecastApp extends WeatherObserver {

	/**
	 * Update the reading of this weather observer. Update the current and last
	 * readings of pressure.
	 */
	List<Double> pressure = new ArrayList<Double>();
	WeatherStation wss;

	public void update() {
		pressure.add(wss.getPressure());
	}

	/* See the method description in the parent class */
	public WeatherStation getWeatherStation() {
		return wss;
	}

	/* See the method description in the parent class */
	public void setWeatherStation(WeatherStation ws) {
		this.wss = ws;
		/* Your Task */

	}

	/**
	 * Get the pressure level read from the last update.
	 * 
	 * @return pressure level read from the last update
	 */
	public double getCurrentPressure() {
		return wss.getPressure();
	}

	/**
	 * Get the pressure level read from the second last update.
	 * 
	 * @return pressure level read from the second last update
	 */
	public double getLastPressure() {
		/* Your Task */
		if (pressure.size() == 1) {
			return this.getCurrentPressure();
		}
		return this.pressure.get(pressure.size() - 2);
	}

	/**
	 * Based on the last and second last readings of the pressure level, it is
	 * determined as likely to rain if there is a reduction on the pressure level;
	 * otherwise it is unlikely to rain.
	 * 
	 * @return whether or not it is likely to rain.
	 */
	public boolean isLikelyToRain() {
		/* Your Task */
		if (this.getCurrentPressure() < this.getLastPressure()) {
			return true;
		}
		return false;
	}
}