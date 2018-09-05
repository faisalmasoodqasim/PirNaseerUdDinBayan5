package com.pirnaseerbayan.faisalmasoodqasim.smksystems;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {


    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;


    int[] images = {R.drawable.pirnaseer1,
            R.drawable.pirnaseer2,
            R.drawable.pirnaseer3,
            R.drawable.pirnaseer4,

            R.drawable.pirnaseer5,
            R.drawable.pirnaseer6,
            R.drawable.pirnaseer7,
            R.drawable.pirnaseer8,
            R.drawable.pirnaseer9,
            R.drawable.pirnaseer10,
            R.drawable.pirnaseer11,
            R.drawable.pirnaseer12,
            R.drawable.pirnaseer13,
            R.drawable.pirnaseer14,
            R.drawable.pirnaseer15,
            R.drawable.pirnaseer16,
            R.drawable.pirnaseer17,
            R.drawable.pirnaseer18,
            R.drawable.pirnaseer19,
            R.drawable.pirnaseer20,

            R.drawable.pirnaseer21,
            R.drawable.pirnaseer22,
            R.drawable.pirnaseer23,
            R.drawable.pirnaseer24,
            R.drawable.pirnaseer25,
            R.drawable.pirnaseer26,
            R.drawable.pirnaseer27,
            R.drawable.pirnaseer28,
            R.drawable.pirnaseer29,
            R.drawable.pirnaseer30,

            R.drawable.pirnaseer31,
            R.drawable.pirnaseer32,
            R.drawable.pirnaseer33,
            R.drawable.pirnaseer34,
            R.drawable.pirnaseer35,
            R.drawable.pirnaseer36,
            R.drawable.pirnaseer37,
            R.drawable.pirnaseer38,
            R.drawable.pirnaseer39,
            R.drawable.pirnaseer40,
            R.drawable.pirnaseer41

    };

    String[] name = {

            "Nabi ke Batin Ka Masla | Har Zahir Ka Batin Hie Golra Sharif bayan",
            "40 Din Ki umar mein Hazrat Esaa ka Ilam Aur Bachpan mien kalam",
            "Roza Rasool ki taraf mun kar ke ziarat karna kesa?",
            "Ghous Azam ke bayan ka waqia",
            "Namoos E Risaalat Ka masla aur Haq o Batil ka farq",
            "Ilam Kitabat ka muhtaj nahi",
            "Mehar Ali Shah Ne Zakat di ya nahi",
            "Hazrat Esaa ne apne Wiladat pe Salam ku kahai",
            "Sher Khuar Bache ne Hazrat Yousaf ki gawahi di",
            "Allah sab ko deta hei",
            "Peer Mehar Ali Shah ke Pardada ke",
            "Aurton ki khaslat Quran ki roshni mein",
            "Kufar kia hei | Namoos E Risalat Pir Naseer bayan",
            "Nabi aur Ali ki wirasat kis ko mili",
            "Allah Azmaish ku dalta hei ",
            "Hazrat Imam Hassan ne Khilafat ku chori",
            "Aulia Allah Ki pehchan Kia hei | Dunya ki muhabat",
            "Nabi Hamre Jesa hei | Islam Ghareebon mien hei ",
            "Sahabi E Rasool aur Sher ka qissa",
            "Bacha kis admi ke pass nahi jata",
            "Deo Bandiyon aur Shia ke bare mein",

            "Khanqahon min ilm ki kami",
            "Mitti se kia awaz aa rahi heii",
            "Wahi aur Ilham ke liye alfaz ki zaroorat hei ya nahi",
            "Ilam ka shehar aur iska Darwaza | Quran mien ghor o fikar",
            "Allah ke khaliq hone ki daleel | Hazrat Ali",
            "Aulia Allah kon hein | Dunya ki muhabat",
            "Doctor ke pass jana shirk hei? Golra Sharif bayan",
            "Mere dil ke tukre",
            "Hazrat Ghos e Azam ka Daman tham lo",

            "Faqar E Muhammadi Ya Roti Kapra Makan?",

            "Purai Qabar Mein Allah Ka Maqbool",
            "Kia Uras Manana Zaroori hei Pir Naseer Lecture",
            "Sab Allah Ke Dastar khuan Se Kha Rahe Hein",
            "Aik Admi Ne Peer Sab Se Kia Kaha | Dunya Dar Mureed",
            "La Ilaha Ilalah Pir Naseer Ud din Poetry",
            "Do grohon min sulah kara do",
            "Jali Pir | Ulma Ahle Sunnat | Madrison ki taleem ",
            "Taweez Men Asar q Nahi",
            "Dunya ki muhabat ka Nuqsan",
            "Allah ke bandey jo ahista chaltey hein"


    };

    ListView videoLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        MobileAds.initialize(this, "ca-app-pub-8606320654355180~6158911951");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

// Prepare the Interstitial Ad
        interstitial = new InterstitialAd(MainActivity.this);
// Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));

        interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                // displayInterstitial();
            }
        });





        videoLV = (ListView)findViewById(R.id.LV);

        CustomAdopter customAdopter = new CustomAdopter();
        videoLV.setAdapter(customAdopter);

        videoLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l) {

                if(i==0){

                    Intent myIntent = new Intent(view.getContext(), page1.class);
                    startActivityForResult(myIntent, 0);

                }
                if(i==1){

                    Intent myIntent = new Intent(view.getContext(), page2.class);
                    startActivityForResult(myIntent, 1);

                }
                if(i==2){

                    Intent myIntent = new Intent(view.getContext(), page3.class);
                    startActivityForResult(myIntent, 2);

                }
                if(i==3){

                    Intent myIntent = new Intent(view.getContext(), page4.class);
                    startActivityForResult(myIntent, 3);

                }
                if(i==4){

                    Intent myIntent = new Intent(view.getContext(), page5.class);
                    startActivityForResult(myIntent, 4);

                }
                if(i==5){

                    Intent myIntent = new Intent(view.getContext(), page6.class);
                    startActivityForResult(myIntent, 5);

                }
                if(i==6){

                    Intent myIntent = new Intent(view.getContext(), page7.class);
                    startActivityForResult(myIntent, 6);

                }
                if(i==7){

                    Intent myIntent = new Intent(view.getContext(), page8.class);
                    startActivityForResult(myIntent, 7);

                }
                if(i==8){

                    Intent myIntent = new Intent(view.getContext(), page9.class);
                    startActivityForResult(myIntent, 8);

                }
                if(i==9){

                    Intent myIntent = new Intent(view.getContext(), page10.class);
                    startActivityForResult(myIntent, 9);

                }
                if(i==10){

                    Intent myIntent = new Intent(view.getContext(), page11.class);
                    startActivityForResult(myIntent, 2);

                }

                if(i==11){

                    Intent myIntent = new Intent(view.getContext(), page12.class);
                    startActivityForResult(myIntent, 11);

                }
                if(i==12){

                    Intent myIntent = new Intent(view.getContext(), page13.class);
                    startActivityForResult(myIntent, 12);

                }
                if(i==13){

                    Intent myIntent = new Intent(view.getContext(), page14.class);
                    startActivityForResult(myIntent, 13);

                }
                if(i==14){

                    Intent myIntent = new Intent(view.getContext(), page15.class);
                    startActivityForResult(myIntent, 14);

                }
                if(i==15){

                    Intent myIntent = new Intent(view.getContext(), page16.class);
                    startActivityForResult(myIntent, 15);

                }
                if(i==16){

                    Intent myIntent = new Intent(view.getContext(), page17.class);
                    startActivityForResult(myIntent, 16);

                }
                if(i==17){

                    Intent myIntent = new Intent(view.getContext(), page18.class);
                    startActivityForResult(myIntent, 17);

                }
                if(i==18){

                    Intent myIntent = new Intent(view.getContext(), page19.class);
                    startActivityForResult(myIntent, 18);

                }
                if(i==19){

                    Intent myIntent = new Intent(view.getContext(), page20.class);
                    startActivityForResult(myIntent, 19);

                }
                if(i==20){

                    Intent myIntent = new Intent(view.getContext(), page21.class);
                    startActivityForResult(myIntent, 20);

                }
                if(i==21){

                    Intent myIntent = new Intent(view.getContext(), page22.class);
                    startActivityForResult(myIntent, 21);

                }
                if(i==22){

                    Intent myIntent = new Intent(view.getContext(), page23.class);
                    startActivityForResult(myIntent, 22);

                }
                if(i==23){

                    Intent myIntent = new Intent(view.getContext(), page24.class);
                    startActivityForResult(myIntent, 23);

                }
                if(i==24){

                    Intent myIntent = new Intent(view.getContext(), page25.class);
                    startActivityForResult(myIntent, 24);

                }
                if(i==25){

                    Intent myIntent = new Intent(view.getContext(), page26.class);
                    startActivityForResult(myIntent, 25);

                }
                if(i==26){

                    Intent myIntent = new Intent(view.getContext(), page27.class);
                    startActivityForResult(myIntent, 26);

                }
                if(i==27){

                    Intent myIntent = new Intent(view.getContext(), page28.class);
                    startActivityForResult(myIntent, 27);

                }
                if(i==28){

                    Intent myIntent = new Intent(view.getContext(), page29.class);
                    startActivityForResult(myIntent, 28);

                }
                if(i==29){

                    Intent myIntent = new Intent(view.getContext(), page30.class);
                    startActivityForResult(myIntent, 29);

                }

                if(i==30){

                    Intent myIntent = new Intent(view.getContext(), page31.class);
                    startActivityForResult(myIntent, 30);

                }
                if(i==31){

                    Intent myIntent = new Intent(view.getContext(), page32.class);
                    startActivityForResult(myIntent, 31);

                }
                if(i==32){

                    Intent myIntent = new Intent(view.getContext(), page33.class);
                    startActivityForResult(myIntent, 32);

                }
                if(i==33){

                    Intent myIntent = new Intent(view.getContext(), page34.class);
                    startActivityForResult(myIntent, 33);

                }
                if(i==34){

                    Intent myIntent = new Intent(view.getContext(), page35.class);
                    startActivityForResult(myIntent, 34);

                }
                if(i==35){

                    Intent myIntent = new Intent(view.getContext(), page36.class);
                    startActivityForResult(myIntent, 35);

                }

                if(i==36){

                    Intent myIntent = new Intent(view.getContext(), page37.class);
                    startActivityForResult(myIntent, 36);

                }
                if(i==37){

                    Intent myIntent = new Intent(view.getContext(), page38.class);
                    startActivityForResult(myIntent, 37);

                }
                if(i==38){

                    Intent myIntent = new Intent(view.getContext(), page39.class);
                    startActivityForResult(myIntent, 38);

                }
                if(i==39){

                    Intent myIntent = new Intent(view.getContext(), page40.class);
                    startActivityForResult(myIntent, 39);

                }
                if(i==40){

                    Intent myIntent = new Intent(view.getContext(), page41.class);
                    startActivityForResult(myIntent, 40);

                }




            }
        });








    }


    class CustomAdopter extends BaseAdapter {


        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i,View convertView,ViewGroup viewGroup) {


            View view = getLayoutInflater().inflate(R.layout.customlayout, null);

            ImageView imageView = view.findViewById(R.id.imageView);

            TextView mTextView = (TextView) view.findViewById(R.id.TV);

            imageView.setImageResource(images[i]);
            mTextView.setText(name[i]);
            return view;
        }
    }



    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }



}
