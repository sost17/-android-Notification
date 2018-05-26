package com.col.commo.tongzhi;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    public static final int NOTIFICATION_ID = 0x123;
    private Button Notification;
    private NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Notification = (Button) findViewById(R.id.T_button);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,View.class);
                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                Notification notification = new Notification.Builder(getApplicationContext())
                        .setAutoCancel(true)
                        .setTicker("有新消息")
                        .setSmallIcon(R.drawable.file)
                        .setContentTitle("一条新通知")
                        .setContentText("要期末了")
                        .setDefaults(Notification.SOUND_EFFECTS_ENABLED)
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pIntent)
                        .build();
                manager.notify(NOTIFICATION_ID, notification);
            }
        });

    }
}
