package com.ehsanrc.labbaik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ehsanrc.labbaik.R;
import com.ehsanrc.labbaik.lists.PrayerTimeList;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PrayerTime extends AppCompatActivity {

    private PrayerTimeList prayerTime;
    private List<PrayerTimeList> list;
    private int deviceHeight, deviceWidth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer_time);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("নামাজের সময়সূচি");


        list = new ArrayList<>();

        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        deviceWidth = displayMetrics.widthPixels;
        deviceHeight = displayMetrics.heightPixels;

        String arabicDate[] = getResources().getStringArray(R.array.arabicDate);
        String arabicDate2[] = getResources().getStringArray(R.array.arabicDateAug);
        String day[] = getResources().getStringArray(R.array.day);
        String day2[] = getResources().getStringArray(R.array.day_aug);
        String fajr[] = getResources().getStringArray(R.array.fajr);
        String fajr2[] = getResources().getStringArray(R.array.fajr_aug);
        String sunrise[] = getResources().getStringArray(R.array.sunrise);
        String sunrise2[] = getResources().getStringArray(R.array.sunrise_aug);
        String duhr[] = getResources().getStringArray(R.array.duhr);
        String duhr2[] = getResources().getStringArray(R.array.duhr_aug);
        String asr[] = getResources().getStringArray(R.array.asr);
        String asr2[] = getResources().getStringArray(R.array.asr_aug);
        String magrib[] = getResources().getStringArray(R.array.magrib);
        String magrib2[] = getResources().getStringArray(R.array.magrib_aug);
        String isha[] = getResources().getStringArray(R.array.isha);
        String isha2[] = getResources().getStringArray(R.array.isha_aug);

        Calendar calendar = Calendar.getInstance();
        int date = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);

        if(month==9)
        {
            for(int i = 0;i<arabicDate.length;i++)
            {
                prayerTime = new PrayerTimeList(i+1,arabicDate[i],day[i],fajr[i],sunrise[i],duhr[i],asr[i],magrib[i],isha[i]);
                list.add(prayerTime);
            }
        }
        else
        {
            for(int i = 0;i<arabicDate.length;i++)
            {
                prayerTime = new PrayerTimeList(i+1,arabicDate2[i],day2[i],fajr2[i],sunrise2[i],duhr2[i],asr2[i],magrib2[i],isha2[i]);
                list.add(prayerTime);
            }
        }

        setParams();

        String text_fajr = list.get(date-1).getFajr();
        String text_sunrise = list.get(date-1).getSunrise();
        String text_duhr = list.get(date-1).getDuhr();
        String text_asr = list.get(date-1).getAsr();
        String text_magrib = list.get(date-1).getMagribr();
        String text_isha = list.get(date-1).getIsha();
        String text_arabic_date = list.get(date-1).getArabicDate();

        TextView tv_arabic_date = (TextView) findViewById(R.id.arabic_date);
        tv_arabic_date.setText(text_arabic_date);

        TextView tv_fajr = (TextView) findViewById(R.id.fajr);
        tv_fajr.setText(text_fajr);
        //tv_fajr.setLayoutParams(new RelativeLayout.LayoutParams(deviceWidth/6, ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView tv_sunrise = (TextView) findViewById(R.id.sunrise);
        tv_sunrise.setText(text_sunrise);

        TextView tv_duhr = (TextView) findViewById(R.id.duhr);
        tv_duhr.setText(text_duhr);

        TextView tv_asr = (TextView) findViewById(R.id.asr);
        tv_asr.setText(text_asr);

        TextView tv_magrib = (TextView) findViewById(R.id.magrib);
        tv_magrib.setText(text_magrib);

        TextView tv_isha = (TextView) findViewById(R.id.isha);
        tv_isha.setText(text_isha);

    }

    private void setParams() {

        LinearLayout ll1 = (LinearLayout) findViewById(R.id.ll_fajr);
        LinearLayout ll2 = (LinearLayout) findViewById(R.id.ll_sunrise);
        LinearLayout ll3 = (LinearLayout) findViewById(R.id.ll_duhr);
        LinearLayout ll4 = (LinearLayout) findViewById(R.id.ll_asr);
        LinearLayout ll5 = (LinearLayout) findViewById(R.id.ll_magrib);
        LinearLayout ll6 = (LinearLayout) findViewById(R.id.ll_isha);

        Log.i("width",String.valueOf(deviceWidth));

        setParamsLinearLayout(ll1,150,150);
        setParamsLinearLayout(ll2,150,150);
        setParamsLinearLayout(ll3,150,150);
        setParamsLinearLayout(ll4,150,150);
        setParamsLinearLayout(ll5,150,150);
        setParamsLinearLayout(ll6,150,150);

    }

    void setParamsLinearLayout(LinearLayout linearLayout,int mHeight, int mWidth){

        RelativeLayout.LayoutParams mParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();

        if(mHeight!=0)
            mParams.height = (int) mHeight;
        if(mWidth!=0)
            mParams.width = (int) mWidth;

        linearLayout.setLayoutParams(mParams);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onBackPressed();
        return true;
    }
}
