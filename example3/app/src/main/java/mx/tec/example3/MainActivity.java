package mx.tec.example3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        toast = new Toast(context);
        toast.makeText(context, "This is a Toast Message", Toast.LENGTH_LONG).show();

        AlertDialog.Builder dialogConf = new AlertDialog.Builder(this);
        dialogConf.setTitle("Title");
        dialogConf.setMessage("Thi is the Text of the neutral dialog");
        dialogConf.setIcon(R.mipmap.ic_launcher);

        dialogConf.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toast.makeText(context, "You clicked dismiss", Toast.LENGTH_LONG).show();
            }
        });

        dialogConf.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toast.makeText(context, "You clicked accept", Toast.LENGTH_LONG).show();
            }
        });

        dialogConf.setNegativeButton("Deny", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toast.makeText(context, "You clicked deny", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog dialog = dialogConf.create();
        dialog.show();

        Notification.Builder notificationConf = new Notification.Builder(this);
        notificationConf.setContentTitle("Notification Title");
        notificationConf.setContentText("Notification message");
        notificationConf.setSmallIcon(R.mipmap.ic_launcher);

        Intent notificationIntent = new Intent(this, ChildActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
        notificationConf.setContentIntent(contentIntent);

        NotificationManager notification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notification.notify(12345,  notificationConf.build());
    }
}