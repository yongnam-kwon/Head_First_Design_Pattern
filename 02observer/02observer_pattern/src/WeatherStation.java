import observer.CurrentConditionsDisplay;
import observer.ForecastDisplay;
import subject.WeatherData;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(20.5F, 21.2F, 33.3F);
        weatherData.setMeasurements(21.5F, 19.2F, 44.3F);
        weatherData.setMeasurements(18.1F, 55.4F, 20.1F);

        weatherData.removeObserver(forecastDisplay);
        weatherData.setMeasurements(44.1F, 1.4F, 88.1F);

        weatherData.removeObserver(currentConditionsDisplay);
        System.out.println("Observer가 모두 removed되었는데!?!?");
        weatherData.setMeasurements(0, 1.4F, 88.1F);
    }
}
