package com.gr.weather;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class UpdateService extends Service {
    private LocationClient client;
    private Timer timer;
    private RequestParams params;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Intent intent;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        preferences = getSharedPreferences("weather", MODE_PRIVATE);
        editor = preferences.edit();
        params = new RequestParams("http://op.juhe.cn/onebox/weather/query");
        params.addBodyParameter("key", "c02c680c29e8ccc1a5b60d6a6947afcd");
        initLocation();
        intent=new Intent("com.gr.weather.WeatherUpdate");
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                client.start();
            }
        }, 3600000, 3600000);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        client.start();
        return super.onStartCommand(intent, flags, startId);
    }

    private void initLocation() {
        client = new LocationClient(getApplicationContext());
        client.registerLocationListener(new LocationListener());
        LocationClientOption option = new LocationClientOption();
        option.setIgnoreKillProcess(false);
        option.setIsNeedAddress(true);
        client.setLocOption(option);
    }

    private class LocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            params.addBodyParameter("cityname", location.getCity());
            x.http().get(params, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    Weather weather = JSON.parseObject(result, Weather.class);
                    Weather.ResultBean.DataBean.RealtimeBean realtime = weather.getResult().getData().getRealtime();
                    editor.putLong("current_time", System.currentTimeMillis());

                    editor.putString("direct", realtime.getWind().getDirect());
                    editor.putString("power", realtime.getWind().getPower());
                    editor.putString("time", realtime.getTime().substring(0,5));
                    editor.putString("humidity", realtime.getWeather().getHumidity());
                    editor.putString("info", realtime.getWeather().getInfo());
                    editor.putString("temperature", realtime.getWeather().getTemperature());
                    editor.putString("city_name", realtime.getCity_name());

                    Weather.ResultBean.DataBean.LifeBean life = weather.getResult().getData().getLife();
                    editor.putString("yundong_0", life.getInfo().getYundong().get(0));
                    editor.putString("yundong_1", life.getInfo().getYundong().get(1));
                    editor.putString("ziwaixian_0", life.getInfo().getZiwaixian().get(0));
                    editor.putString("ziwaixian_1", life.getInfo().getZiwaixian().get(1));
                    editor.putString("xiche_0", life.getInfo().getXiche().get(0));
                    editor.putString("xiche_1", life.getInfo().getXiche().get(1));
                    editor.putString("chuanyi_0", life.getInfo().getChuanyi().get(0));
                    editor.putString("chuanyi_1", life.getInfo().getChuanyi().get(1));

                    List<Weather.ResultBean.DataBean.WeatherBean> week = weather.getResult().getData().getWeather();
                    editor.putString("maximum_temperature_day_1", week.get(0).getInfo().getDay().get(2));
                    editor.putString("minimum_temperature_day_1", week.get(0).getInfo().getNight().get(2));
                    editor.putString("info_day_1", week.get(0).getInfo().getDay().get(1));

                    editor.putString("maximum_temperature_day_2", week.get(1).getInfo().getDay().get(2));
                    editor.putString("minimum_temperature_day_2", week.get(1).getInfo().getNight().get(2));
                    editor.putString("info_day_2", week.get(1).getInfo().getDay().get(1));

                    editor.putString("maximum_temperature_day_3", week.get(2).getInfo().getDay().get(2));
                    editor.putString("minimum_temperature_day_3", week.get(2).getInfo().getNight().get(2));
                    editor.putString("week_day_3", week.get(2).getWeek());
                    editor.putString("info_day_3", week.get(2).getInfo().getDay().get(1));

                    editor.putString("maximum_temperature_day_4", week.get(3).getInfo().getDay().get(2));
                    editor.putString("minimum_temperature_day_4", week.get(3).getInfo().getNight().get(2));
                    editor.putString("info_day_4", week.get(3).getInfo().getDay().get(1));
                    editor.putString("week_day_4", week.get(3).getWeek());

                    editor.putString("maximum_temperature_day_5", week.get(4).getInfo().getDay().get(2));
                    editor.putString("minimum_temperature_day_5", week.get(4).getInfo().getNight().get(2));
                    editor.putString("info_day_5", week.get(4).getInfo().getDay().get(1));
                    editor.putString("week_day_5", week.get(4).getWeek());

                    editor.putString("maximum_temperature_day_6", week.get(5).getInfo().getDay().get(2));
                    editor.putString("minimum_temperature_day_6", week.get(5).getInfo().getNight().get(2));
                    editor.putString("info_day_6", week.get(5).getInfo().getDay().get(1));
                    editor.putString("week_day_6", week.get(5).getWeek());

                    Weather.ResultBean.DataBean.Pm25Bean.Pm25 pm25 = weather.getResult().getData().getPm25().getPm25();
                    editor.putString("pm25",pm25.getPm25());
                    editor.putString("pm10",pm25.getPm10());
                    editor.putString("curPm",pm25.getCurPm());
                    editor.putString("quality",pm25.getQuality());
                    editor.putString("des",pm25.getDes());

                    editor.commit();
                    sendBroadcast(intent);
                }

                @Override
                public void onError(Throwable ex, boolean isOnCallback) {
                    Toast.makeText(x.app(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(CancelledException cex) {

                }

                @Override
                public void onFinished() {

                }
            });
            client.stop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
