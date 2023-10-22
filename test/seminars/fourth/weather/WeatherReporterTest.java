package seminars.fourth.weather;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class WeatherReporterTest {

    @Test
    public void testWeather() {
        WeatherService weatherService = mock(WeatherService.class);
        WeatherReporter weatherReporter = new WeatherReporter(weatherService);
        when(weatherService.getCurrentTemperature()).thenReturn(25);
        String report = weatherReporter.generateReport();
        verify(weatherService, times(1)).getCurrentTemperature();
        Assertions.assertThat(report).isEqualTo("Текущая температура: 25 градусов.");
    }

}