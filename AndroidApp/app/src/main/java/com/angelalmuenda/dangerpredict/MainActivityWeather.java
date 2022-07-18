package com.angelalmuenda.dangerpredict;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.content.Context;

public class MainActivityWeather {

    public RadioGroup weatherGroup;
    public RadioButton weatherClear;
    public RadioButton weatherCloudy;
    public RadioButton weatherRainy;

    public TextView textTemp;
    public TextView textFeels;
    public TextView textWind;
    public TextView textCloud;
    public TextView textHumidity;
    public TextView textPrecip;
    public TextView textPressure;

    public SeekBar seekBarTemp;
    public SeekBar seekBarFeels;
    public SeekBar seekBarWind;
    public SeekBar seekBarCloud;
    public SeekBar seekBarHumidity;
    public SeekBar seekBarPrecip;
    public SeekBar seekBarPressure;

    public void setSeekBarMinMaxValue() {
        seekBarTemp.setProgress(15);
        textTemp.setText(String.valueOf(seekBarTemp.getProgress()+15));

        seekBarFeels.setProgress(15);
        textFeels.setText(String.valueOf(seekBarFeels.getProgress()+15));

        seekBarWind.setProgress(10);
        textWind.setText(String.valueOf(seekBarWind.getProgress()));

        seekBarCloud.setProgress(37);
        textCloud.setText(String.valueOf(seekBarCloud.getProgress()));

        seekBarHumidity.setProgress(73);
        textHumidity.setText(String.valueOf(seekBarHumidity.getProgress()));

        seekBarPrecip.setProgress(12);
        textPrecip.setText(String.valueOf((float)seekBarPrecip.getProgress()/10));

        seekBarPressure.setProgress(9);
        textPressure.setText(String.valueOf(seekBarPressure.getProgress()+1000));
    }
}
