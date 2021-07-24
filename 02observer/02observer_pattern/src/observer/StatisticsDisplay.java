package observer;

import subject.WeatherData;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float temp;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        ;
    }

    @Override
    public void display() {
        ;
    }
}
