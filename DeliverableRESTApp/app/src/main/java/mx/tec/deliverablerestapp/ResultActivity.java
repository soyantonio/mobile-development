package mx.tec.deliverablerestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ResultActivity extends AppCompatActivity {

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

        TextView cityTextView = findViewById(R.id.city);
        cityTextView.setTextSize(20);
        cityTextView.setText("City: " + city);

        TextView tempTextView = findViewById(R.id.temperature);
        tempTextView.setTextSize(24);
        tempTextView.setText("Temperature: " + temperature);

        TextView feelsTextView = findViewById(R.id.feels_Like);
        feelsTextView.setTextSize(24);
        feelsTextView.setText("Feels Like: " + feels_like);

        TextView commTextView = findViewById(R.id.comment);
        commTextView.setTextSize(20);
        commTextView.setText("Comment: " + weather);

        Context myContext = getApplicationContext();
        ImageView myImageView = findViewById(R.id.imageView);
        Glide.with(myContext).load("http://openweathermap.org/img/w/" + icon + ".png").into(myImageView);

    }
}