package mx.tec.consumingservices;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {

    public String city;
    public String temperature;
    public String feels_like;
    public String icon;
    public String weather;

    public class CallAPI extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String urlString = params[0]; // URL to call
            String resultToDisplay = "";
            InputStream in = null;
            String result = null;

            // HTTP Request
            try {
                URL url = new URL(urlString);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                in = new BufferedInputStream(urlConnection.getInputStream());

            } catch (Exception e ) {
                System.out.println(e.getMessage());
                return e.getMessage();
            }

            // Parse XML
            XmlPullParserFactory pullParserFactory;

            try {
                pullParserFactory = XmlPullParserFactory.newInstance();
                XmlPullParser parser = pullParserFactory.newPullParser();
                parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                parser.setInput(in, null);
                result = parseAllXML(parser);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            if (result != null ) {
                resultToDisplay = urlString +" : "+ result + "\n";
            }
            else {
                resultToDisplay = "Exception Occured";
            }

            return resultToDisplay;
        }


        public String parseAllXML( XmlPullParser parser) throws XmlPullParserException, IOException {
            int eventType = parser.getEventType();
            String result = new String();
            String tag = new String();

            Log.i("Parse", "Parsing");

           while (eventType != XmlPullParser.END_DOCUMENT) {
                if(eventType == XmlPullParser.START_DOCUMENT) {
                    result += "\n";
                } else if(eventType == XmlPullParser.START_TAG) {

                    tag = parser.getName().trim();
                    Log.i("parsing tag", tag + "");

                    result += "\nTag: "+ tag;

                    if(tag.equals("city")) {
                        city =  parser.getAttributeValue(null, "name");
                        Log.i("I", "Parsing the city: " + city);

                    }
                    if(tag.equals("temperature")) {
                        temperature = parser.getAttributeValue(null, "value");
                        Log.i("I", "Parsing temperature: " + temperature);
                    }
                    if(tag.equals("feels_like")) {
                        feels_like = parser.getAttributeValue(null, "value");
                        Log.i("I", "Parsing feels_like: " + feels_like);
                    }

                    if(tag.equals("weather")) {
                        weather = parser.getAttributeValue(null, "value");
                        Log.i("I", "Parsing weather: " + weather);
                        icon = parser.getAttributeValue(null, "icon");
                        Log.i("I", "Parsing icon: " + icon);
                    }

                    if (parser.getAttributeValue(null, "value") != null)
                        result += " = " + parser.getAttributeValue(null, "value");
                    if (parser.getAttributeValue(null, "name") != null)
                        result += " = " + parser.getAttributeValue(null, "name");
                    if (parser.getAttributeValue(null, "icon") != null)
                        result += " = " + parser.getAttributeValue(null, "icon");

                }
                eventType = parser.next();
            }
            result += "\nEnd response \n";

            return result;
        }

        public void onPostExecute(String result) {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("fullResponse", result);
            intent.putExtra("city", city);
            intent.putExtra("temperature", temperature);
            intent.putExtra("feels_like", feels_like);
            intent.putExtra("weather", weather);
            intent.putExtra("icon", icon);

            startActivity(intent);
        }
    }

    public void sendRequest() {
        String apiURL = "";
        String baseURL = "http://api.openweathermap.org/data/2.5/weather?";
        String responseMode ="&mode=xml";
        String units = "&units=metric";
        String apiKey="&APPID=";
        apiURL = baseURL + responseMode + units + apiKey;

        EditText city = findViewById(R.id.city);
        String cityTxt = city.getText().toString();

        if( city != null && !cityTxt.isEmpty()) {
            String urlString = apiURL + "&q=" + cityTxt;
            new CallAPI().execute(urlString);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button requestButton = findViewById(R.id.callservice);
        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });
    }




}
