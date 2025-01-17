package de.riedelei.weather.weatherdata;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @CrossOrigin
    @GetMapping(value="weather", produces="application/json")
    public Weather getWeatherForLatLon(@RequestParam String lon, @RequestParam String lat) throws JsonProcessingException {
        return weatherService.getWeatherDataFromOpenWeatherMap(lon, lat);
    }

    @CrossOrigin
    @GetMapping("weather_city")
    public List<Weather> getWeatherForCity(@RequestParam String city) throws JsonProcessingException {

        return weatherService.getWeatherComplete(city);
    }

    @CrossOrigin
    @GetMapping("weatherfavoritecity")
    public Weather getWeatherForFavoriteCity() throws JsonProcessingException {
        return weatherService.getWeatherForFavoriteCity();
    }
}
