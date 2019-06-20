package com.example.kartik.rainsounds;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class Ground extends AppCompatActivity{
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    MediaPlayer ring;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ground);
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
        textViewTitle.setText(R.string.ground);
        ring = MediaPlayer.create(this,R.raw.ground);
        ring.start();
        ring.setLooping(true);
    }
    public void pauseSong(View view){
        if(ring.isPlaying()){
            ring.pause();
        }
        else {
            ring.start();
            ring.setLooping(true);
        }
    }

    public void onBackPressed(){
        ring.pause();
        super.onBackPressed();
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }
}
