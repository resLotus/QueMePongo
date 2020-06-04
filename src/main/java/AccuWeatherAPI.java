import java.util.*;

public final class AccuWeatherAPI {

    public final List<Map<String, Object>> getWeather(String ciudad) {
        Map<String, Object> demoMap = new HashMap<String, Object>();
        demoMap.put("DateTime", "2019-05-03T01:00:00-03:00");
        demoMap.put("EpochDateTime", 1556856000);
        demoMap.put("WeatherIcon", 33);
        demoMap.put("IconPhrase", "Clear");
        demoMap.put("IsDaylight", false);
        demoMap.put("PrecipitationProbability", 0);
        demoMap.put("MobileLink", "http://m.accuweather.com/en/ar/villa-vil/7984/");
        demoMap.put("Link", "http://www.accuweather.com/en/ar/villa-vil/7984");
        demoMap.put("Temperature", new HashMap(){{
            put("Value", 57);
            put("Unit", "F");
            put("UnitType", 18);
        }});

        return Arrays.asList(demoMap);
    }
}