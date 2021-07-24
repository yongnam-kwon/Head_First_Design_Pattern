package observer;

import subject.WeatherData;

public class ForecastDisplay implements Observer, DisplayElement {
    private float lastTemp;
    private float temp;
    private float lastHumidity;
    private float humidity;
    private float lastPressure;
    private float pressure;
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.lastTemp = this.temp;
        this.temp = temp;
        this.lastHumidity = this.humidity;
        this.humidity = humidity;
        this.lastPressure = this.pressure;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("[Forecast]: ");
        if(this.temp > this.lastTemp) {
            System.out.println("기온 올라감..");
        } else if(this.temp == this.lastTemp) {
            System.out.println("기온 똑같음");
        } else {
            System.out.println("시원해짐~");
        }
        // ...
    }
}
