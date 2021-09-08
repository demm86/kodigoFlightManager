package projectSolid.Service.Weather;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;


public class OpenWeatherClient {

    static private final String APPID_HEADER = "ed361389e17f99360dcc1b0e19b7ca0";
    private String baseOwmUrl = "http://api.openweathermap.org/data/2.5/";
    private String owmAPPID = null;
    private HttpClient httpClient;

    public OpenWeatherClient () {
        this.httpClient = new DefaultHttpClient ();
    }

    public OpenWeatherClient (HttpClient httpClient) {
        if (httpClient == null)
            throw new IllegalArgumentException ("Can't construct a OwmClient with a null HttpClient");
        this.httpClient = httpClient;
    }

    public WeatherForecastResponse forecastWeatherAtCity (String cityName) throws JSONException, IOException {

        String tmpCityName = URLEncoder.encode(cityName, StandardCharsets.UTF_8.name());
        String subUrl = String.format (Locale.ROOT, "weather?q=%s&APPID=ced361389e17f99360dcc1b0e19b7ca0&units=metric", tmpCityName);
        JSONObject response = doQuery (subUrl);

        return new WeatherForecastResponse (response);
    }


    private JSONObject doQuery (String subUrl) throws JSONException, IOException {
        String responseBody = null;
        HttpGet httpget = new HttpGet (this.baseOwmUrl + subUrl);
        if (this.owmAPPID != null) {
            httpget.addHeader (OpenWeatherClient.APPID_HEADER, this.owmAPPID);
        }

        HttpResponse response = this.httpClient.execute (httpget);
        InputStream contentStream = null;
        try {
            StatusLine statusLine = response.getStatusLine ();
            if (statusLine == null) {
                throw new IOException (
                        String.format ("Unable to get a response from OWM server"));
            }
            int statusCode = statusLine.getStatusCode ();
            if (statusCode < 200 && statusCode >= 300) {
                throw new IOException (
                        String.format ("OWM server responded with status code %d: %s", statusCode, statusLine));
            }
            /* Read the response content */
            HttpEntity responseEntity = response.getEntity ();
            contentStream = responseEntity.getContent ();
            Reader isReader = new InputStreamReader(contentStream);
            int contentSize = (int) responseEntity.getContentLength ();
            if (contentSize < 0)
                contentSize = 8*1024;
            StringWriter strWriter = new StringWriter (contentSize);
            char[] buffer = new char[8*1024];
            int n = 0;
            while ((n = isReader.read(buffer)) != -1) {
                strWriter.write(buffer, 0, n);
            }
            responseBody = strWriter.toString ();
            ((InputStream) contentStream).close ();
        } catch (IOException e) {
            throw e;
        } catch (RuntimeException re) {
            httpget.abort ();
            throw re;
        } finally {
            if (contentStream != null)
                contentStream.close ();
        }
        return new JSONObject (responseBody);
    }



}
