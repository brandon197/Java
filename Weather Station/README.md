A weather station measures temperature and pressure and has a list of subscribed weather observers. When
there is an update on the measures, the weather station publishes the update to all currently-subscribed
observers.

A weather observer should be subscribed to some weather station and be kept up to date whenever an update
on the measures of temperature and pressure occurs. Specifically, there are two kinds of weather observers:


– A weather forecast app determines if the pressure readings from its subscribed weather station, if any,
indicate it is likely to rain due to a reduction on the pressure level.


– A weather statistics app calculates the minimum, maximum, and average temperature read so far from
its subscribed weather station, if any.
