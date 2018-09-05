package com.pirnaseerbayan.faisalmasoodqasim.smksystems;


import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

public class page32 extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener{


    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;


    public static final String DEVELOPER_KEY = "AIzaSyCdBNyQ-y4gYoU1OeLZUQ83kbWiFP74Zy0";
    private static final String VIDEO_ID = "93v_H5geheQ";
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    YouTubePlayerFragment myYouTubePlayerFragment;
    DownloadManager downloadManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page32);


        MobileAds.initialize(this, "ca-app-pub-8606320654355180~6158911951");


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

// Prepare the Interstitial Ad
        interstitial = new InterstitialAd(page32.this);
// Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));

        interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });




        Button btn2 = (Button) findViewById(R.id.btnBack);
        Button btn3 = (Button)findViewById(R.id.btnShare);
        //     Button btnDownloadVideo = (Button)findViewById(R.id.btnDownloadVideo);
        //    Button btnDownloadAudio = (Button)findViewById(R.id.btnDownloadAudio);


        btn2.getBackground().setAlpha(200);
        btn3.getBackground().setAlpha(200);
        //    btnDownloadVideo.getBackground().setAlpha(200);
        //    btnDownloadAudio.getBackground().setAlpha(200);

/*

        btnDownloadVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri  = Uri.parse("http://download1929.mediafire.com/5556i6qs8szg/55hpil4f8w8fb1i/40+Din+Ki+umar+mein+Hazrat+Esaa+ka+Ilam+Aur+Bachpan+mien+kalam++Peer+Naseer+Ud+D.mp4");
                DownloadManager.Request request = new DownloadManager.Request(uri);

                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long reference = downloadManager.enqueue(request);


            }
        });


        btnDownloadAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri  = Uri.parse("http://download1568.mediafire.com/cpfcf4cbklvg/e6moe7484eown64/40+-+Din.mp3");
                DownloadManager.Request request = new DownloadManager.Request(uri);

                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long reference = downloadManager.enqueue(request);


            }
        });


*/

        // Button page2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "https://www.youtube.com/watch?v=93v_H5geheQ";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(myIntent, "Share using"));
            }
        });


        myYouTubePlayerFragment = (YouTubePlayerFragment)getFragmentManager()
                .findFragmentById(R.id.youtubeplayerfragment);
        myYouTubePlayerFragment.initialize(DEVELOPER_KEY, this);
    }
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    "There was an error initializing the YouTubePlayer (%1$s)",
                    errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player,
                                        boolean wasRestored) {
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
// Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(DEVELOPER_KEY, this);
        }
    }
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView)findViewById(R.id.youtubeplayerfragment);
    }



    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }


}
