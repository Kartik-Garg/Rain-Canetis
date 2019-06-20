package com.example.kartik.rainsounds;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class Rain extends AppCompatActivity {
    MediaPlayer rain;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rain_tent);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        // To set custom layout for the text in status bar

        MobileAds.initialize(this, "ca-app-pub-7381031943051414~8309553566");

        //Banner Ads
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Inter Ads
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7381031943051414/2969187853");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        TextView textViewTitle = (TextView) findViewById(R.id.rainOnTent);
        textViewTitle.setText(R.string.tent);
        //To set the text for status bar.

        rain = MediaPlayer.create(this,R.raw.raintent);
        rain.start();
        rain.setLooping(true);
    }

    public void pauseSong(View view){
        if(rain.isPlaying()){
            rain.pause();
        }
        else {
            rain.start();
            rain.setLooping(true);
        }
    }
    public void onBackPressed(){
        rain.pause();
        super.onBackPressed();

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }

}
