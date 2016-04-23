package com.gr.weather;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.text.DecimalFormat;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.line_chat)
    private LineChart chart;
    @ViewInject(R.id.swipe_refresh)
    private SwipeRefreshLayout swipeRefresh;
    @ViewInject(R.id.cityname)
    private TextView cityname;
    @ViewInject(R.id.info)
    private TextView info;
    @ViewInject(R.id.temperature)
    private TextView temperature;
    @ViewInject(R.id.time)
    private TextView time;

    @ViewInject(R.id.day1_above)
    private ImageView day1_above;
    @ViewInject(R.id.day1_below)
    private ImageView day1_below;
    @ViewInject(R.id.day1_temperature)
    private TextView day1_temperature;

    @ViewInject(R.id.day2_above)
    private ImageView day2_above;
    @ViewInject(R.id.day2_below)
    private ImageView day2_below;
    @ViewInject(R.id.day2_temperature)
    private TextView day2_temperature;

    @ViewInject(R.id.day3_week)
    private TextView day3_week;
    @ViewInject(R.id.day3_above)
    private ImageView day3_above;
    @ViewInject(R.id.day3_below)
    private ImageView day3_below;
    @ViewInject(R.id.day3_temperature)
    private TextView day3_temperature;

    @ViewInject(R.id.day4_week)
    private TextView day4_week;
    @ViewInject(R.id.day4_above)
    private ImageView day4_above;
    @ViewInject(R.id.day4_below)
    private ImageView day4_below;
    @ViewInject(R.id.day4_temperature)
    private TextView day4_temperature;

    @ViewInject(R.id.day5_week)
    private TextView day5_week;
    @ViewInject(R.id.day5_above)
    private ImageView day5_above;
    @ViewInject(R.id.day5_below)
    private ImageView day5_below;
    @ViewInject(R.id.day5_temperature)
    private TextView day5_temperature;

    @ViewInject(R.id.day6_week)
    private TextView day6_week;
    @ViewInject(R.id.day6_above)
    private ImageView day6_above;
    @ViewInject(R.id.day6_below)
    private ImageView day6_below;
    @ViewInject(R.id.day6_temperature)
    private TextView day6_temperature;

    @ViewInject(R.id.des)
    private LinearLayout des;
    @ViewInject(R.id.cur_pm)
    private TextView cur_pm;
    @ViewInject(R.id.quality)
    private TextView quality;
    @ViewInject(R.id.pm25_text)
    private TextView pm25_text;
    @ViewInject(R.id.pm25_progress)
    private ProgressBar pm25_progress;
    @ViewInject(R.id.pm10_text)
    private TextView pm10_text;
    @ViewInject(R.id.pm10_progress)
    private ProgressBar pm10_progress;

    @ViewInject(R.id.direct)
    private TextView direct;
    @ViewInject(R.id.power)
    private TextView power;
    @ViewInject(R.id.humidity)
    private TextView humidity;

    private Intent intent;
    private SharedPreferences preferences;
    private WeatherReceiver receiver;
    private IntentFilter filter;
    private ColorStateList tint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        x.view().inject(this);
        intent = new Intent(this, UpdateService.class);
        preferences = getSharedPreferences("weather", MODE_PRIVATE);
        if (System.currentTimeMillis() - preferences.getLong("current_time", 0) > 3600000) {
            startService(intent);
        }
        receiver = new WeatherReceiver();
        filter = new IntentFilter("com.gr.weather.WeatherUpdate");
        swipeRefresh.setOnRefreshListener(() -> startService(intent));
        chart.setTouchEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.getXAxis().setEnabled(false);
        chart.getAxisLeft().setEnabled(false);
        chart.getAxisRight().setEnabled(false);
        chart.setDescription(null);
        LineData lineData = new LineData();
        LineDataSet set = new LineDataSet(null, null);
        set.setColor(0x88ffffff);
        set.setCircleColor(0xefffffff);
        set.setCircleColorHole(0xff207eb4);
        set.setLineWidth(2);
        set.setValueTextColor(0xefffffff);
        set.setValueTextSize(12);
        set.setValueFormatter(((value, entry, dataSetIndex, viewPortHandler) -> {
            DecimalFormat format = new DecimalFormat("00");
            return format.format(value) + "°";
        }));
        lineData.addDataSet(set);
        chart.setData(lineData);
        chart.animateX(1000);
        tint = getResources().getColorStateList(R.color.tint);
        des.setOnClickListener((v) -> Snackbar.make(v, preferences.getString("des", "N/A"), Snackbar.LENGTH_LONG).show());
        updateWeather();
    }

    private class WeatherReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            swipeRefresh.setRefreshing(false);
            updateWeather();
        }
    }

    private void updateWeather() {
        LineData lineData = chart.getData();
        ILineDataSet dataSet = lineData.getDataSetByIndex(0);
        lineData.addXValue(lineData.getXValCount() + "");
        lineData.addEntry(new Entry(Float.parseFloat(preferences.getString("maximum_temperature_day_1", "0")), dataSet.getEntryCount()), 0);
        chart.notifyDataSetChanged();
        chart.setVisibleXRangeMaximum(5);
        chart.moveViewToX(lineData.getXValCount() - 5);
        lineData.addXValue(lineData.getXValCount() + "");
        lineData.addEntry(new Entry(Float.parseFloat(preferences.getString("maximum_temperature_day_2", "0")), dataSet.getEntryCount()), 0);
        chart.notifyDataSetChanged();
        chart.setVisibleXRangeMaximum(5);
        chart.moveViewToX(lineData.getXValCount() - 5);
        lineData.addXValue(lineData.getXValCount() + "");
        lineData.addEntry(new Entry(Float.parseFloat(preferences.getString("maximum_temperature_day_3", "0")), dataSet.getEntryCount()), 0);
        chart.notifyDataSetChanged();
        chart.setVisibleXRangeMaximum(5);
        chart.moveViewToX(lineData.getXValCount() - 5);
        lineData.addXValue(lineData.getXValCount() + "");
        lineData.addEntry(new Entry(Float.parseFloat(preferences.getString("maximum_temperature_day_4", "0")), dataSet.getEntryCount()), 0);
        chart.notifyDataSetChanged();
        chart.setVisibleXRangeMaximum(5);
        chart.moveViewToX(lineData.getXValCount() - 5);
        lineData.addXValue(lineData.getXValCount() + "");
        lineData.addEntry(new Entry(Float.parseFloat(preferences.getString("maximum_temperature_day_5", "0")), dataSet.getEntryCount()), 0);
        chart.notifyDataSetChanged();
        chart.setVisibleXRangeMaximum(5);
        chart.moveViewToX(lineData.getXValCount() - 5);
        lineData.addXValue(lineData.getXValCount() + "");
        lineData.addEntry(new Entry(Float.parseFloat(preferences.getString("maximum_temperature_day_6", "0")), dataSet.getEntryCount()), 0);
        chart.notifyDataSetChanged();
        chart.setVisibleXRangeMaximum(5);
        chart.moveViewToX(lineData.getXValCount() - 5);

        cityname.setText(preferences.getString("city_name", "N/A"));
        info.setText(preferences.getString("info", "N/A"));
        temperature.setText(preferences.getString("temperature", "N/A"));
        time.setText(preferences.getString("time", "N/A"));

        day1_above.setImageTintList(tint);
        day2_above.setImageTintList(tint);
        day3_above.setImageTintList(tint);
        day4_above.setImageTintList(tint);
        day5_above.setImageTintList(tint);
        day6_above.setImageTintList(tint);

        day1_below.setImageTintList(null);
        day2_below.setImageTintList(null);
        day3_below.setImageTintList(null);
        day4_below.setImageTintList(null);
        day5_below.setImageTintList(null);
        day6_below.setImageTintList(null);

        day1_above.setVisibility(View.VISIBLE);
        day2_above.setVisibility(View.VISIBLE);
        day3_above.setVisibility(View.VISIBLE);
        day4_above.setVisibility(View.VISIBLE);
        day5_above.setVisibility(View.VISIBLE);
        day6_above.setVisibility(View.VISIBLE);

        day1_below.setVisibility(View.VISIBLE);
        day2_below.setVisibility(View.VISIBLE);
        day3_below.setVisibility(View.VISIBLE);
        day4_below.setVisibility(View.VISIBLE);
        day5_below.setVisibility(View.VISIBLE);
        day6_below.setVisibility(View.VISIBLE);

        switch (preferences.getString("info_day_1", "N/A")) {
            case "晴":
                day1_above.setImageResource(R.drawable.ic_weather_sun);
                day1_above.setImageTintList(null);
                day1_below.setVisibility(View.GONE);
                break;
            case "多云":
                day1_above.setImageResource(R.drawable.ic_weather_above_cloudy);
                day1_above.setImageTintList(null);
                day1_below.setImageResource(R.drawable.ic_weather_below_cloudy);
                day1_below.setImageTintList(tint);
                break;
            case "阴":
                day1_above.setImageResource(R.drawable.ic_weather_overcast);
                day1_below.setVisibility(View.GONE);
                break;
            case "阵雨":
                day1_above.setImageResource(R.drawable.ic_weather_above);
                day1_below.setImageResource(R.drawable.ic_weather_below_lightrain);
                break;
            case "小雨":
                day1_above.setImageResource(R.drawable.ic_weather_above);
                day1_below.setImageResource(R.drawable.ic_weather_below_lightrain);
                break;
            case "中雨":
                day1_above.setImageResource(R.drawable.ic_weather_above);
                day1_below.setImageResource(R.drawable.ic_weather_below_moderaterain);
                break;
            case "中雨-大雨":
                day1_above.setImageResource(R.drawable.ic_weather_above);
                day1_below.setImageResource(R.drawable.ic_weather_below_moderaterain);
                break;
            case "大雨":
                day1_above.setImageResource(R.drawable.ic_weather_above);
                day1_below.setImageResource(R.drawable.ic_weather_below_heavyrain);
                break;
            case "暴雨":
                day1_above.setImageResource(R.drawable.ic_weather_above);
                day1_below.setImageResource(R.drawable.ic_weather_below_heavyrain);
                break;
            case "雨夹雪":
                day1_above.setImageResource(R.drawable.ic_weather_above);
                day1_below.setImageResource(R.drawable.ic_weather_below_sleet);
            case "小雪":
                day1_above.setImageResource(R.drawable.ic_weather_above);
                day1_below.setImageResource(R.drawable.ic_weather_below_lightsnow);
                break;
            case "暴雪":
                day1_above.setImageResource(R.drawable.ic_weather_above);
                day1_below.setImageResource(R.drawable.ic_weather_below_snowstorm);
                break;
            default:
                day1_above.setImageResource(R.drawable.ic_weather_na_w);
                day1_below.setVisibility(View.GONE);
        }

        switch (preferences.getString("info_day_2", "N/A")) {
            case "晴":
                day2_above.setImageResource(R.drawable.ic_weather_sun);
                day2_above.setImageTintList(null);
                day2_below.setVisibility(View.GONE);
                break;
            case "多云":
                day2_above.setImageResource(R.drawable.ic_weather_above_cloudy);
                day2_above.setImageTintList(null);
                day2_below.setImageResource(R.drawable.ic_weather_below_cloudy);
                day2_below.setImageTintList(tint);
                break;
            case "阴":
                day2_above.setImageResource(R.drawable.ic_weather_overcast);
                day2_below.setVisibility(View.GONE);
                break;
            case "阵雨":
                day2_above.setImageResource(R.drawable.ic_weather_above);
                day2_below.setImageResource(R.drawable.ic_weather_below_lightrain);
                break;
            case "小雨":
                day2_above.setImageResource(R.drawable.ic_weather_above);
                day2_below.setImageResource(R.drawable.ic_weather_below_lightrain);
                break;
            case "中雨":
                day2_above.setImageResource(R.drawable.ic_weather_above);
                day2_below.setImageResource(R.drawable.ic_weather_below_moderaterain);
                break;
            case "中雨-大雨":
                day2_above.setImageResource(R.drawable.ic_weather_above);
                day2_below.setImageResource(R.drawable.ic_weather_below_moderaterain);
                break;
            case "大雨":
                day2_above.setImageResource(R.drawable.ic_weather_above);
                day2_below.setImageResource(R.drawable.ic_weather_below_heavyrain);
                break;
            case "暴雨":
                day2_above.setImageResource(R.drawable.ic_weather_above);
                day2_below.setImageResource(R.drawable.ic_weather_below_heavyrain);
                break;
            case "雨夹雪":
                day2_above.setImageResource(R.drawable.ic_weather_above);
                day2_below.setImageResource(R.drawable.ic_weather_below_sleet);
            case "小雪":
                day2_above.setImageResource(R.drawable.ic_weather_above);
                day2_below.setImageResource(R.drawable.ic_weather_below_lightsnow);
                break;
            case "暴雪":
                day2_above.setImageResource(R.drawable.ic_weather_above);
                day2_below.setImageResource(R.drawable.ic_weather_below_snowstorm);
                break;
            default:
                day2_above.setImageResource(R.drawable.ic_weather_na_w);
                day2_below.setVisibility(View.GONE);
        }

        switch (preferences.getString("info_day_3", "N/A")) {
            case "晴":
                day3_above.setImageResource(R.drawable.ic_weather_sun);
                day3_above.setImageTintList(null);
                day3_below.setVisibility(View.GONE);
                break;
            case "多云":
                day3_above.setImageResource(R.drawable.ic_weather_above_cloudy);
                day3_above.setImageTintList(null);
                day3_below.setImageResource(R.drawable.ic_weather_below_cloudy);
                day3_below.setImageTintList(tint);
                break;
            case "阴":
                day3_above.setImageResource(R.drawable.ic_weather_overcast);
                day3_below.setVisibility(View.GONE);
                break;
            case "阵雨":
                day3_above.setImageResource(R.drawable.ic_weather_above);
                day3_below.setImageResource(R.drawable.ic_weather_below_lightrain);
                break;
            case "小雨":
                day3_above.setImageResource(R.drawable.ic_weather_above);
                day3_below.setImageResource(R.drawable.ic_weather_below_lightrain);
                break;
            case "中雨":
                day3_above.setImageResource(R.drawable.ic_weather_above);
                day3_below.setImageResource(R.drawable.ic_weather_below_moderaterain);
                break;
            case "中雨-大雨":
                day3_above.setImageResource(R.drawable.ic_weather_above);
                day3_below.setImageResource(R.drawable.ic_weather_below_moderaterain);
                break;
            case "大雨":
                day3_above.setImageResource(R.drawable.ic_weather_above);
                day3_below.setImageResource(R.drawable.ic_weather_below_heavyrain);
                break;
            case "暴雨":
                day3_above.setImageResource(R.drawable.ic_weather_above);
                day3_below.setImageResource(R.drawable.ic_weather_below_heavyrain);
                break;
            case "雨夹雪":
                day3_above.setImageResource(R.drawable.ic_weather_above);
                day3_below.setImageResource(R.drawable.ic_weather_below_sleet);
            case "小雪":
                day3_above.setImageResource(R.drawable.ic_weather_above);
                day3_below.setImageResource(R.drawable.ic_weather_below_lightsnow);
                break;
            case "暴雪":
                day3_above.setImageResource(R.drawable.ic_weather_above);
                day3_below.setImageResource(R.drawable.ic_weather_below_snowstorm);
                break;
            default:
                day3_above.setImageResource(R.drawable.ic_weather_na_w);
                day3_below.setVisibility(View.GONE);
        }

        switch (preferences.getString("info_day_4", "N/A")) {
            case "晴":
                day4_above.setImageResource(R.drawable.ic_weather_sun);
                day4_above.setImageTintList(null);
                day4_below.setVisibility(View.GONE);
                break;
            case "多云":
                day4_above.setImageResource(R.drawable.ic_weather_above_cloudy);
                day4_above.setImageTintList(null);
                day4_below.setImageResource(R.drawable.ic_weather_below_cloudy);
                day4_below.setImageTintList(tint);
                break;
            case "阴":
                day4_above.setImageResource(R.drawable.ic_weather_overcast);
                day4_below.setVisibility(View.GONE);
                break;
            case "阵雨":
                day4_above.setImageResource(R.drawable.ic_weather_above);
                day4_below.setImageResource(R.drawable.ic_weather_below_lightrain);
                break;
            case "小雨":
                day4_above.setImageResource(R.drawable.ic_weather_above);
                day4_below.setImageResource(R.drawable.ic_weather_below_lightrain);
                break;
            case "中雨":
                day4_above.setImageResource(R.drawable.ic_weather_above);
                day4_below.setImageResource(R.drawable.ic_weather_below_moderaterain);
                break;
            case "中雨-大雨":
                day4_above.setImageResource(R.drawable.ic_weather_above);
                day4_below.setImageResource(R.drawable.ic_weather_below_moderaterain);
                break;
            case "大雨":
                day4_above.setImageResource(R.drawable.ic_weather_above);
                day4_below.setImageResource(R.drawable.ic_weather_below_heavyrain);
                break;
            case "暴雨":
                day4_above.setImageResource(R.drawable.ic_weather_above);
                day4_below.setImageResource(R.drawable.ic_weather_below_heavyrain);
                break;
            case "雨夹雪":
                day4_above.setImageResource(R.drawable.ic_weather_above);
                day4_below.setImageResource(R.drawable.ic_weather_below_sleet);
            case "小雪":
                day4_above.setImageResource(R.drawable.ic_weather_above);
                day4_below.setImageResource(R.drawable.ic_weather_below_lightsnow);
                break;
            case "暴雪":
                day4_above.setImageResource(R.drawable.ic_weather_above);
                day4_below.setImageResource(R.drawable.ic_weather_below_snowstorm);
                break;
            default:
                day4_above.setImageResource(R.drawable.ic_weather_na_w);
                day4_below.setVisibility(View.GONE);
        }

        switch (preferences.getString("info_day_5", "N/A")) {
            case "晴":
                day5_above.setImageResource(R.drawable.ic_weather_sun);
                day5_above.setImageTintList(null);
                day5_below.setVisibility(View.GONE);
                break;
            case "多云":
                day5_above.setImageResource(R.drawable.ic_weather_above_cloudy);
                day5_above.setImageTintList(null);
                day5_below.setImageResource(R.drawable.ic_weather_below_cloudy);
                day5_below.setImageTintList(tint);
                break;
            case "阴":
                day5_above.setImageResource(R.drawable.ic_weather_overcast);
                day5_below.setVisibility(View.GONE);
                break;
            case "阵雨":
                day5_above.setImageResource(R.drawable.ic_weather_above);
                day5_below.setImageResource(R.drawable.ic_weather_below_lightrain);
                break;
            case "小雨":
                day5_above.setImageResource(R.drawable.ic_weather_above);
                day5_below.setImageResource(R.drawable.ic_weather_below_lightrain);
                break;
            case "中雨":
                day5_above.setImageResource(R.drawable.ic_weather_above);
                day5_below.setImageResource(R.drawable.ic_weather_below_moderaterain);
                break;
            case "中雨-大雨":
                day5_above.setImageResource(R.drawable.ic_weather_above);
                day5_below.setImageResource(R.drawable.ic_weather_below_moderaterain);
                break;
            case "大雨":
                day5_above.setImageResource(R.drawable.ic_weather_above);
                day5_below.setImageResource(R.drawable.ic_weather_below_heavyrain);
                break;
            case "暴雨":
                day5_above.setImageResource(R.drawable.ic_weather_above);
                day5_below.setImageResource(R.drawable.ic_weather_below_heavyrain);
                break;
            case "雨夹雪":
                day5_above.setImageResource(R.drawable.ic_weather_above);
                day5_below.setImageResource(R.drawable.ic_weather_below_sleet);
            case "小雪":
                day5_above.setImageResource(R.drawable.ic_weather_above);
                day5_below.setImageResource(R.drawable.ic_weather_below_lightsnow);
                break;
            case "暴雪":
                day5_above.setImageResource(R.drawable.ic_weather_above);
                day5_below.setImageResource(R.drawable.ic_weather_below_snowstorm);
                break;
            default:
                day5_above.setImageResource(R.drawable.ic_weather_na_w);
                day5_below.setVisibility(View.GONE);
        }

        switch (preferences.getString("info_day_6", "N/A")) {
            case "晴":
                day6_above.setImageResource(R.drawable.ic_weather_sun);
                day6_above.setImageTintList(null);
                day6_below.setVisibility(View.GONE);
                break;
            case "多云":
                day6_above.setImageResource(R.drawable.ic_weather_above_cloudy);
                day6_above.setImageTintList(null);
                day6_below.setImageResource(R.drawable.ic_weather_below_cloudy);
                day6_below.setImageTintList(tint);
                break;
            case "阴":
                day6_above.setImageResource(R.drawable.ic_weather_overcast);
                day6_below.setVisibility(View.GONE);
                break;
            case "阵雨":
                day6_above.setImageResource(R.drawable.ic_weather_above);
                day6_below.setImageResource(R.drawable.ic_weather_below_lightrain);
                break;
            case "小雨":
                day6_above.setImageResource(R.drawable.ic_weather_above);
                day6_below.setImageResource(R.drawable.ic_weather_below_lightrain);
                break;
            case "中雨":
                day6_above.setImageResource(R.drawable.ic_weather_above);
                day6_below.setImageResource(R.drawable.ic_weather_below_moderaterain);
                break;
            case "中雨-大雨":
                day6_above.setImageResource(R.drawable.ic_weather_above);
                day6_below.setImageResource(R.drawable.ic_weather_below_moderaterain);
                break;
            case "大雨":
                day6_above.setImageResource(R.drawable.ic_weather_above);
                day6_below.setImageResource(R.drawable.ic_weather_below_heavyrain);
                break;
            case "暴雨":
                day6_above.setImageResource(R.drawable.ic_weather_above);
                day6_below.setImageResource(R.drawable.ic_weather_below_heavyrain);
                break;
            case "雨夹雪":
                day6_above.setImageResource(R.drawable.ic_weather_above);
                day6_below.setImageResource(R.drawable.ic_weather_below_sleet);
            case "小雪":
                day6_above.setImageResource(R.drawable.ic_weather_above);
                day6_below.setImageResource(R.drawable.ic_weather_below_lightsnow);
                break;
            case "暴雪":
                day6_above.setImageResource(R.drawable.ic_weather_above);
                day6_below.setImageResource(R.drawable.ic_weather_below_snowstorm);
                break;
            default:
                day6_above.setImageResource(R.drawable.ic_weather_na_w);
                day6_below.setVisibility(View.GONE);
        }

        day3_week.setText("周" + preferences.getString("week_day_3", "N/A"));
        day4_week.setText("周" + preferences.getString("week_day_4", "N/A"));
        day5_week.setText("周" + preferences.getString("week_day_5", "N/A"));
        day6_week.setText("周" + preferences.getString("week_day_6", "N/A"));

        day1_temperature.setText(preferences.getString("maximum_temperature_day_1", "0") + "°/"
                + preferences.getString("minimum_temperature_day_1", "0") + "°");
        day2_temperature.setText(preferences.getString("maximum_temperature_day_2", "0") + "°/"
                + preferences.getString("minimum_temperature_day_2", "0") + "°");
        day3_temperature.setText(preferences.getString("maximum_temperature_day_3", "0") + "°/"
                + preferences.getString("minimum_temperature_day_3", "0") + "°");
        day4_temperature.setText(preferences.getString("maximum_temperature_day_4", "0") + "°/"
                + preferences.getString("minimum_temperature_day_4", "0") + "°");
        day5_temperature.setText(preferences.getString("maximum_temperature_day_4", "0") + "°/"
                + preferences.getString("minimum_temperature_day_5", "0") + "°");
        day6_temperature.setText(preferences.getString("maximum_temperature_day_6", "0") + "°/"
                + preferences.getString("minimum_temperature_day_6", "0") + "°");

        cur_pm.setText(preferences.getString("curPm", "N/A"));
        quality.setText(preferences.getString("quality", "N/A"));
        pm25_text.setText(preferences.getString("pm25", "0"));
        pm25_progress.setProgress(Integer.parseInt(preferences.getString("pm25", "0")));
        pm10_text.setText(preferences.getString("pm10", "0"));
        pm10_progress.setProgress(Integer.parseInt(preferences.getString("pm10", "0")));

        direct.setText(preferences.getString("direct","N/A"));
        power.setText(preferences.getString("power","N/A"));
        humidity.setText(preferences.getString("humidity","N/A")+"%");
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
}
