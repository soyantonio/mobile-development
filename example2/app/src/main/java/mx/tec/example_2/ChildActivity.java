package mx.tec.example_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {

    String anyString;
    TextView textView;
    Intent intentReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        textView = findViewById(R.id.textView2);
        intentReceiver = getIntent();
        anyString = intentReceiver.getStringExtra("myExtra");
        textView.setText(anyString);
    }
}