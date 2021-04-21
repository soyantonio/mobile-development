package mx.tec.consumingservices;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String fullResponse = intent.getStringExtra("fullResponse");
        String city = intent.getStringExtra("city");
        String temperature = intent.getStringExtra("temperature");
        String feels_like = intent.getStringExtra("feels_like");
        String weather =  intent.getStringExtra("weather");
        String icon =  intent.getStringExtra("icon");

        TextView fullTextView = findViewById(R.id.results);
        fullTextView.setTextSize(36);
        //fullTextView.setText(fullResponse);

        TextView cityTextView = findViewById(R.id.City);
        cityTextView.setTextSize(20);
        cityTextView.setText("City: " + city);

        TextView tempTextView = findViewById(R.id.Temperature);
        tempTextView.setTextSize(24);
        tempTextView.setText("Temperature: " + temperature);

        TextView feelsTextView = findViewById(R.id.Feels_Like);
        feelsTextView.setTextSize(24);
        feelsTextView.setText("Feels Like: " + feels_like);

        TextView commTextView = findViewById(R.id.Comment);
        commTextView.setTextSize(20);
        commTextView.setText("Comment: " + weather);

        Context myContext = getApplicationContext();
        ImageView myImageView = findViewById(R.id.imageView);
        Glide.with(myContext).load("http://openweathermap.org/img/w/" + icon + ".png").into(myImageView);

    }

}