import java.util.*;

/**
 * A weather statistics app calculates the minimum, maximum, and average
 * temperature read so far from its subscribed weather station, if any.
 */
public class StatisticsApp extends WeatherObserver {

	/**
	 * Update the reading of this weather observer. Update the current temperature
	 * and the maximum, minimum, and average accordingly.
	 */
	private List<Double> temp = new ArrayList<Double>();
	private WeatherStation wd;

	public void update() {
		temp.add(wd.getTemperature());

		/* Your Task */
	}

	/* See the method description in the parent class */
	public WeatherStation getWeatherStation() {
		/* Your Task */

		return wd;
	}

	/* See the method description in the parent class */
	public void setWeatherStation(WeatherStation ws) {
		this.wd = ws;
		/* Your Task */
	}

	/**
	 * Get the minimum temperature based on the readings so far.
	 * 
	 * @return minimum temperature based on the readings so far
	 */
	public double getMinTemperature() {
		double min = temp.get(0);
		for (Double d : temp) {
			if (d < min) {
				min = d;
			}

		}
		/* Your Task */
		return min;
	}

	/**
	 * Get the maximum temperature based on the readings so far.
	 * 
	 * @return maximum temperature based on the readings so far
	 */
	public double getMaxTemperature() {
		double max = 0.0;
		for (Double d : temp) {
			if (d > max) {
				max = d;
			}

		}
		/* Your Task */
		return max;
	}

	/**
	 * Get the average temperature based on the readings so far.
	 * 
	 * @return average temperature based on the readings so far
	 */
	public double getAverageTemperature() {
		double tot = 0.0;
		double count = 0.0;
		for (Double d : temp) {
			tot += d;
			count++;
		}
		/* Your Task */
		return tot / count;
	}
}
