import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class WeatherClient {
    // Replace with your real OpenWeatherMap API key
    private static final String API_KEY = "0f889b3be7cee6b618c04bf467b3a6e6"; //your_api_key_here

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter city name: ");
        String city = scanner.nextLine().trim();
        scanner.close();

        String urlString = String.format(
            "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s",
            city, API_KEY
        );

        try {
            // Create and send HTTP GET request
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Check response code
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.out.println("❌ Error: HTTP " + responseCode);
                return;
            }

            // Read JSON response
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                json.append(line);
            }
            in.close();

            // Parse JSON
            JSONObject obj = new JSONObject(json.toString());
            JSONObject main = obj.getJSONObject("main");
            JSONObject wind = obj.getJSONObject("wind");

            System.out.println("\n🌤 Weather Report for " + city + ":");
            System.out.println("Temperature: " + main.getDouble("temp") + " °K");
            System.out.println("Humidity: " + main.getInt("humidity") + " %");
            System.out.println("Wind Speed: " + wind.getDouble("speed") + " m/s");

        } catch (Exception e) {
            System.out.println("⚠️ Error fetching weather data: " + e.getMessage());
        }
    }
}
