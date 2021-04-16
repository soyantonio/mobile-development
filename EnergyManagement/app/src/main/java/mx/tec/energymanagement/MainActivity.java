package mx.tec.energymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView powerStatus;

    private BroadcastReceiver plugInfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            if(plugged == BatteryManager.BATTERY_PLUGGED_AC)
                powerStatus.setText("Plugged to Ac");
            else if (plugged == BatteryManager.BATTERY_PLUGGED_USB)
                powerStatus.setText("Plugged to USB");
            else if (plugged == BatteryManager.BATTERY_PLUGGED_WIRELESS)
                powerStatus.setText("Plugged to Wireless charger");
            else
                powerStatus.setText("Not plugged");
        }
    };

    private TextView batteryText;

    private BroadcastReceiver batteryInfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            batteryText.setText("Battery level: " + String.valueOf(level) + "%");
        }
    };

    private TextView connectionStatus;
    private BroadcastReceiver networkStatus = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            if (activeNetwork != null) {
                if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                    connectionStatus.setText("Wifi enable");
                else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                    connectionStatus.setText("Mobile data enable");
            } else {
                connectionStatus.setText("No internet is available");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batteryText = findViewById(R.id.batteryLevelTxt);
        powerStatus = findViewById(R.id.powerStatusTxt);
        connectionStatus = findViewById(R.id.connectionStatusTxt);

        this.registerReceiver(this.batteryInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        this.registerReceiver(this.plugInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        this.registerReceiver(this.networkStatus, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

}