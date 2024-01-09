package id.co.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchHelloActivity(View view) {
        Intent tampilHello = new Intent(MainActivity.this, MainHello.class);
        startActivity(tampilHello);
    }

    public void launchToastActivity(View view){
        Intent tampilToast = new Intent(MainActivity.this, MainToast.class);
        startActivity(tampilToast);
    }

    public void launchSianidaActivity(View view){
        Intent tampilSianida = new Intent(MainActivity.this, MainSianida.class);
        startActivity(tampilSianida);
    }

    public void launchTwoActivity(View view){
        Intent tampilTwo = new Intent(MainActivity.this, MainFirstActivity.class);
        startActivity(tampilTwo);
    }

    public void createAlarm(View view) {
        ArrayList<Integer> alarmDays = new ArrayList<>();
        alarmDays.add(2);
        alarmDays.add(3);
        alarmDays.add(4);
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_DAYS, alarmDays)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Wake up!")
                .putExtra(AlarmClock.EXTRA_HOUR, 7)
                .putExtra(AlarmClock.EXTRA_MINUTES, 30)
                .putExtra(AlarmClock.EXTRA_VIBRATE, false)
                .putExtra(AlarmClock.EXTRA_RINGTONE, "VALUE_RINGTONE_SILENT");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showMap(View view) {
        String URL = "http://maps.google.com/";
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(URL));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
    }

    public void movieFragment(View view) {
        Intent movIntent = new Intent(MainActivity.this, FragmentActivity.class);
        startActivity(movIntent);
    }
}
