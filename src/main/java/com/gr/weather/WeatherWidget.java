package com.gr.weather;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class WeatherWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        context.startService(new Intent(context, UpdateService.class));
        RemoteViews views=new RemoteViews(context.getPackageName(),R.layout.weather_widget);
        views.setOnClickPendingIntent(R.id.weather_plate,PendingIntent.getActivity(context,0,new Intent(
                context,MainActivity.class),0));
        appWidgetManager.updateAppWidget(appWidgetIds,views);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        context.stopService(new Intent(context, UpdateService.class));
    }
}

