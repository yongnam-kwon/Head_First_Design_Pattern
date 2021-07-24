public class WeatherData {
    CurrentConditionsDisplay currentConditionsDisplay;
    StatisticsDisplay statisticsDisplay;
    ForecastDisplay forecastDisplay;

    public float getTemperature() {
        return (float) 34.2;
    }
    public float getHumidity() {
        return 80.5F;
    }
    public float getPressure() {
        return (float) 1.1;
    }

    public void measurementsChanged() { // 기상 관측값이 갱신되면 해당 메소드가 호출되는 구조
        float temp = getTemperature();
        float humidity = getHumidity();
        float pressure = getPressure();

        /**
         * 다른 Display를 추가하고자 한다면, 이 measurementsChanged 메소드를 고쳐야 하는 상황이기에
         * 바뀔 수 있는 부분, 바로 이 부분을 캡슐화해야 함!!
         */
        currentConditionsDisplay.update(temp, humidity, pressure);
        statisticsDisplay.update(temp, humidity, pressure);
        forecastDisplay.update(temp, humidity, pressure);
    }

    // 기타 메소드들...
}
