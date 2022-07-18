package com.angelalmuenda.dangerpredict;

import android.content.Context;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivityEconomy {

    public TextView textPHPUSD;
    public TextView textPSEI;
    public TextView textCPIAll;
    public TextView textCPIAlcohol;
    public TextView textCPITransport;
    public TextView textCPIHousing;
    public TextView textCPIRestaurant;
    public TextView textRateInflation;
    public TextView textRateSavings;
    public TextView textRateBank;

    public SeekBar seekBarPHPUSD;
    public SeekBar seekBarPSEI;
    public SeekBar seekBarCPIAll;
    public SeekBar seekBarCPIAlcohol;
    public SeekBar seekBarCPITransport;
    public SeekBar seekBarCPIHousing;
    public SeekBar seekBarCPIRestaurant;
    public SeekBar seekBarRateInflation;
    public SeekBar seekBarRateSavings;
    public SeekBar seekBarRateBank;

    public void setSeekBarMinMaxValue() {
        seekBarPHPUSD.setProgress(11500);
        textPHPUSD.setText(String.valueOf(((float)seekBarPHPUSD.getProgress()+40000)/1000));

        seekBarPSEI.setProgress(18000);
        textPSEI.setText(String.valueOf(((float)seekBarPSEI.getProgress()+65000)/10));

        seekBarCPIAll.setProgress(40);
        textCPIAll.setText(String.valueOf(((float)seekBarCPIAll.getProgress()+1150)/10));

        seekBarCPIAlcohol.setProgress(110);
        textCPIAlcohol.setText(String.valueOf(((float)seekBarCPIAlcohol.getProgress()+1470)/10));

        seekBarCPITransport.setProgress(40);
        textCPITransport.setText(String.valueOf(((float)seekBarCPITransport.getProgress()+1010)/10));

        seekBarCPIHousing.setProgress(50);
        textCPIHousing.setText(String.valueOf(((float)seekBarCPIHousing.getProgress()+1120)/10));

        seekBarCPIRestaurant.setProgress(70);
        textCPIRestaurant.setText(String.valueOf(((float)seekBarCPIRestaurant.getProgress()+1160)/10));

        seekBarRateInflation.setProgress(30);
        textRateInflation.setText(String.valueOf(((float)seekBarRateInflation.getProgress()+20)/10));

        seekBarRateSavings.setProgress(115);
        textRateSavings.setText(String.valueOf(((float)seekBarRateSavings.getProgress()+650)/1000));

        seekBarRateBank.setProgress(300);
        textRateBank.setText(String.valueOf(((float)seekBarRateBank.getProgress()+5353)/1000));
    }

}
