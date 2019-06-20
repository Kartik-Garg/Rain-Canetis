package com.example.kartik.rainsounds;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        TextView textViewTitle = (TextView) findViewById(R.id.rainOnTent);
        textViewTitle.setText(R.string.title);

        MobileAds.initialize(this, "ca-app-pub-7381031943051414~8309553566");
        //Banner Ads
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void RainOnTent(View view){
        Intent i = new Intent(this,Rain.class);
        startActivity(i);
    }

    public void HeavyRain(View v){
        Intent i = new Intent(this,HeavyRain.class);
        startActivity(i);
    }

    public void Thunderstorm(View v){
        Intent i = new Intent(this,ThunderStrom.class);
        startActivity(i);
    }

    public void WateryStreet(View v){
        Intent i = new Intent(this,WateryStreet.class);
        startActivity(i);
    }

    public void Ground(View v){
        Intent i = new Intent(this,Ground.class);
        startActivity(i);
    }

    public void autumn(View v){
        Intent i = new Intent(this,Autumn.class);
        startActivity(i);
    }

    public void umbrella(View v){
        Intent i = new Intent(this,umbrella.class);
        startActivity(i);
    }
}
