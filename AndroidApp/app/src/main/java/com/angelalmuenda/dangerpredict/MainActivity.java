package com.angelalmuenda.dangerpredict;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.view.View;

import com.android.volley.VolleyError;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity
        implements
        OnMapReadyCallback,
        OnMapClickListener,
        OnMapLongClickListener,
        OnSeekBarChangeListener,
        ApiEventListener {

    PredictData pData;
    MainActivitySocialMap maSocialMap;
    MainActivityTimeDayWeek maTimeDayWeek;
    MainActivityPlaces maPlaces;
    MainActivityWeather maWeather;
    MainActivityEconomy maEconomy;

    GoogleMap gMap;
    MarkerOptions markerOptions;
    Marker uniMarker;

    ProgressBar spinner;
    Dialog dialogResults;
    ArrayMap<String,String> allData;
    ArrayList<Double> unsorted;
    ArrayList<Double> sorted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pData = new PredictData();
        pData.buttonPredict = (Button) findViewById(R.id.buttonPredict);
        spinner = (ProgressBar) findViewById(R.id.progressPredict);
        spinner.setVisibility(View.GONE);
        dialogResults = new Dialog(this);

        maSocialMap = new MainActivitySocialMap();
        maSocialMap.clickButtonTagum = (Button) findViewById(R.id.buttonTagum);
        maSocialMap.clickButtonPanabo = (Button) findViewById(R.id.buttonPanabo);
        maSocialMap.clickButtonSamal = (Button) findViewById(R.id.buttonSamal);

        maTimeDayWeek = new MainActivityTimeDayWeek();
        maTimeDayWeek.dayGroup = (RadioGroup) findViewById(R.id.dayGroup);
        maTimeDayWeek.timeGroup = (RadioGroup) findViewById(R.id.timeGroup);
        maTimeDayWeek.daylightGroup = (RadioGroup) findViewById(R.id.daylightGroup);
        maTimeDayWeek.daySun = (RadioButton) findViewById(R.id.radioButtonSunday);
        maTimeDayWeek.dayMon = (RadioButton) findViewById(R.id.radioButtonMonday);
        maTimeDayWeek.dayTue = (RadioButton) findViewById(R.id.radioButtonTuesday);
        maTimeDayWeek.dayWed = (RadioButton) findViewById(R.id.radioButtonWednesday);
        maTimeDayWeek.dayThu = (RadioButton) findViewById(R.id.radioButtonThursday);
        maTimeDayWeek.dayFri = (RadioButton) findViewById(R.id.radioButtonFriday);
        maTimeDayWeek.daySat = (RadioButton) findViewById(R.id.radioButtonSaturday);
        maTimeDayWeek.timeAfterMidnight
                = (RadioButton) findViewById(R.id.radioButtonAfterMidnight);
        maTimeDayWeek.timeEarlyMorning
                = (RadioButton) findViewById(R.id.radioButtonEarlyMorning);
        maTimeDayWeek.timeMorning
                = (RadioButton) findViewById(R.id.radioButtonMorning);
        maTimeDayWeek.timeAfternoon
                = (RadioButton) findViewById(R.id.radioButtonAfternoon);
        maTimeDayWeek.timeAfterWorkHours
                = (RadioButton) findViewById(R.id.radioButtonAfterWorkHours);
        maTimeDayWeek.timeEvening
                = (RadioButton) findViewById(R.id.radioButtonEvening);
        maTimeDayWeek.stayDay = (RadioButton) findViewById(R.id.radioButtonDay);
        maTimeDayWeek.stayNight = (RadioButton) findViewById(R.id.radioButtonNight);

        maPlaces = new MainActivityPlaces();
        maPlaces.bank = (CheckBox) findViewById(R.id.checkBoxBank);
        maPlaces.bar = (CheckBox) findViewById(R.id.checkBoxBar);
        maPlaces.beach = (CheckBox) findViewById(R.id.checkBoxBeach);
        maPlaces.bridge = (CheckBox) findViewById(R.id.checkBoxBridge);
        maPlaces.cemetery = (CheckBox) findViewById(R.id.checkBoxCemetery);
        maPlaces.church = (CheckBox) findViewById(R.id.checkBoxChurch);
        maPlaces.clinic = (CheckBox) findViewById(R.id.checkBoxClinic);
        maPlaces.commercialBuilding = (CheckBox) findViewById(R.id.checkBoxCommercialBuilding);
        maPlaces.communityCenter = (CheckBox) findViewById(R.id.checkBoxCommunityCenter);
        maPlaces.convenienceStore = (CheckBox) findViewById(R.id.checkBoxConvenienceStore);
        maPlaces.fireStation = (CheckBox) findViewById(R.id.checkBoxFireStation);
        maPlaces.gasStation = (CheckBox) findViewById(R.id.checkBoxGasStation);
        maPlaces.governmentOffice = (CheckBox) findViewById(R.id.checkBoxGovernmentOffice);
        maPlaces.greenField = (CheckBox) findViewById(R.id.checkBoxGreenFields);
        maPlaces.hospital = (CheckBox) findViewById(R.id.checkBoxHospital);
        maPlaces.hotel = (CheckBox) findViewById(R.id.checkBoxHotel);
        maPlaces.highway = (CheckBox) findViewById(R.id.checkBoxHighway);
        maPlaces.highwayPedestrian = (CheckBox) findViewById(R.id.checkBoxHighwayPedestrian);
        maPlaces.highwayPrimary = (CheckBox) findViewById(R.id.checkBoxHighwayPrimary);
        maPlaces.highwaySecondary = (CheckBox) findViewById(R.id.checkBoxHighwaySecondary);
        maPlaces.highwayTertiary = (CheckBox) findViewById(R.id.checkBoxHighwayTertiary);
        maPlaces.highwayResidential = (CheckBox) findViewById(R.id.checkBoxHighwayResidential);
        maPlaces.industrialBuilding = (CheckBox) findViewById(R.id.checkBoxIndustrialBuilding);
        maPlaces.mall = (CheckBox) findViewById(R.id.checkBoxMall);
        maPlaces.marketplace = (CheckBox) findViewById(R.id.checkBoxMarketplace);
        maPlaces.park = (CheckBox) findViewById(R.id.checkBoxPark);
        maPlaces.parkingArea = (CheckBox) findViewById(R.id.checkBoxParkingArea);
        maPlaces.pawnshop = (CheckBox) findViewById(R.id.checkBoxPawnshop);
        maPlaces.pharmacy = (CheckBox) findViewById(R.id.checkBoxPharmacy);
        maPlaces.policeStation = (CheckBox) findViewById(R.id.checkBoxPoliceStation);
        maPlaces.postOffice = (CheckBox) findViewById(R.id.checkBoxPostOffice);
        maPlaces.privateOffice = (CheckBox) findViewById(R.id.checkBoxPrivateOffice);
        maPlaces.recreationalArea = (CheckBox) findViewById(R.id.checkBoxRecreationalArea);
        maPlaces.road = (CheckBox) findViewById(R.id.checkBoxRoad);
        maPlaces.residentialBuilding = (CheckBox) findViewById(R.id.checkBoxResidentialBuilding);
        maPlaces.restaurant = (CheckBox) findViewById(R.id.checkBoxRestaurant);
        maPlaces.school = (CheckBox) findViewById(R.id.checkBoxSchool);
        maPlaces.sportsField = (CheckBox) findViewById(R.id.checkBoxSportsCenter);
        maPlaces.touristSpot = (CheckBox) findViewById(R.id.checkBoxTouristAttraction);
        maPlaces.transportTerminal = (CheckBox) findViewById(R.id.checkBoxTransportTerminal);

        maWeather = new MainActivityWeather();
        maWeather.weatherGroup = (RadioGroup) findViewById(R.id.weatherGroup);
        maWeather.weatherClear = (RadioButton) findViewById(R.id.radioButtonClear);
        maWeather.weatherCloudy = (RadioButton) findViewById(R.id.radioButtonCloudy);
        maWeather.weatherRainy = (RadioButton) findViewById(R.id.radioButtonRainy);
        maWeather.textTemp = (TextView) findViewById(R.id.textViewTempVal);
        maWeather.textFeels = (TextView) findViewById(R.id.textViewFeelVal);
        maWeather.textWind = (TextView) findViewById(R.id.textViewWindVal);
        maWeather.textCloud = (TextView) findViewById(R.id.textViewCloudVal);
        maWeather.textHumidity = (TextView) findViewById(R.id.textViewHumidityVal);
        maWeather.textPrecip = (TextView) findViewById(R.id.textViewPrecipVal);
        maWeather.textPressure = (TextView) findViewById(R.id.textViewPressureVal);
        maWeather.seekBarTemp = (SeekBar) findViewById(R.id.seekBarTemp);
        maWeather.seekBarFeels = (SeekBar) findViewById(R.id.seekBarFeel);
        maWeather.seekBarWind = (SeekBar) findViewById(R.id.seekBarWind);
        maWeather.seekBarCloud = (SeekBar) findViewById(R.id.seekBarCloud);
        maWeather.seekBarHumidity = (SeekBar) findViewById(R.id.seekBarHumidity);
        maWeather.seekBarPrecip = (SeekBar) findViewById(R.id.seekBarPrecip);
        maWeather.seekBarPressure = (SeekBar) findViewById(R.id.seekBarPressure);
        maWeather.setSeekBarMinMaxValue();
        maWeather.seekBarTemp.setOnSeekBarChangeListener(this);
        maWeather.seekBarFeels.setOnSeekBarChangeListener(this);
        maWeather.seekBarWind.setOnSeekBarChangeListener(this);
        maWeather.seekBarCloud.setOnSeekBarChangeListener(this);
        maWeather.seekBarHumidity.setOnSeekBarChangeListener(this);
        maWeather.seekBarPrecip.setOnSeekBarChangeListener(this);
        maWeather.seekBarPressure.setOnSeekBarChangeListener(this);

        maEconomy = new MainActivityEconomy();
        maEconomy.textPHPUSD = (TextView) findViewById(R.id.textViewPHPUSDVal);
        maEconomy.textPSEI = (TextView) findViewById(R.id.textViewPSEIVal);
        maEconomy.textCPIAll = (TextView) findViewById(R.id.textViewCPIAllItemsVal);
        maEconomy.textCPIAlcohol = (TextView) findViewById(R.id.textViewCPIAlcoholVal);
        maEconomy.textCPITransport = (TextView) findViewById(R.id.textViewCPITransportVal);
        maEconomy.textCPIHousing = (TextView) findViewById(R.id.textViewCPIHousingVal);
        maEconomy.textCPIRestaurant = (TextView) findViewById(R.id.textViewCPIRestaurantVal);
        maEconomy.textRateInflation = (TextView) findViewById(R.id.textViewInflationRateVal);
        maEconomy.textRateSavings = (TextView) findViewById(R.id.textViewSavingsRateVal);
        maEconomy.textRateBank = (TextView) findViewById(R.id.textViewBankRateVal);
        maEconomy.seekBarPHPUSD = (SeekBar) findViewById(R.id.seekBarPHPUSD);
        maEconomy.seekBarPSEI = (SeekBar) findViewById(R.id.seekBarPSEI);
        maEconomy.seekBarCPIAll = (SeekBar) findViewById(R.id.seekBarCPIAllItems);
        maEconomy.seekBarCPIAlcohol = (SeekBar) findViewById(R.id.seekBarCPIAlcohol);
        maEconomy.seekBarCPITransport = (SeekBar) findViewById(R.id.seekBarCPITransport);
        maEconomy.seekBarCPIHousing = (SeekBar) findViewById(R.id.seekBarCPIHousing);
        maEconomy.seekBarCPIRestaurant = (SeekBar) findViewById(R.id.seekBarCPIRestaurant);
        maEconomy.seekBarRateInflation = (SeekBar) findViewById(R.id.seekBarInflationRate);
        maEconomy.seekBarRateSavings = (SeekBar) findViewById(R.id.seekBarSavingsRate);
        maEconomy.seekBarRateBank = (SeekBar) findViewById(R.id.seekBarBankRate);
        maEconomy.setSeekBarMinMaxValue();
        maEconomy.seekBarPHPUSD.setOnSeekBarChangeListener(this);
        maEconomy.seekBarPSEI.setOnSeekBarChangeListener(this);
        maEconomy.seekBarCPIAll.setOnSeekBarChangeListener(this);
        maEconomy.seekBarCPIAlcohol.setOnSeekBarChangeListener(this);
        maEconomy.seekBarCPITransport.setOnSeekBarChangeListener(this);
        maEconomy.seekBarCPIHousing.setOnSeekBarChangeListener(this);
        maEconomy.seekBarCPIRestaurant.setOnSeekBarChangeListener(this);
        maEconomy.seekBarRateInflation.setOnSeekBarChangeListener(this);
        maEconomy.seekBarRateSavings.setOnSeekBarChangeListener(this);
        maEconomy.seekBarRateBank.setOnSeekBarChangeListener(this);

        FragmentManager myFragmentManager = getFragmentManager();
        MapFragment myMapFragment
                = (MapFragment) myFragmentManager.findFragmentById(R.id.map);
        myMapFragment.getMapAsync(this);
    }

    public void clickTagumCity(View view) {
        gMap.animateCamera(CameraUpdateFactory.newCameraPosition(maSocialMap.TAGUM),null);
    }

    public void clickPanaboCity(View view) {
        gMap.animateCamera(CameraUpdateFactory.newCameraPosition(maSocialMap.PANABO),null);
    }

    public void clickSamalCity(View view) {
        gMap.animateCamera(CameraUpdateFactory.newCameraPosition(maSocialMap.SAMAL), null);
    }

    public void predictDanger(View view) {
        spinner.setVisibility(View.VISIBLE);
        pData.buttonPredict.setEnabled(false);
        if(allDataValid()) {
            executePrediction(allData);
        }
    }

    private ArrayList<String> findCrimeLabels(Double level) {
        ArrayList<String> crime = new ArrayList<String>();

        for (int i = 0; i < sorted.size(); i++){
            Double current = unsorted.get(i);
            if (current.compareTo(level) == 0) {
                crime.add(pData.crime_labels[i]);
            }
        }

        return crime;
    }

    private void sortJsonObject (JSONObject json) {
        String temp = new String();
        unsorted = new ArrayList<Double>();
        sorted = new ArrayList<Double>();

        try {
            for (int i = 0; i < json.length(); i++) {
                temp = json.get(pData.crime_labels[i]).toString();
                unsorted.add(Double.parseDouble(temp));
                sorted.add(Double.parseDouble(temp));
            }

            Collections.sort(sorted, Collections.reverseOrder());
        }
        catch (JSONException e) {

        }
    }

    public void getSocialData(ArrayMap<String,String> data) {
        // array map must have "location" key with maSocialMap.selectedLocation value
        DangerPredictApi apiSocial = new DangerPredictApi();
        apiSocial.registerApiEventListener(this);
        apiSocial.getSocialIndicators(data);
    }

    public void executePrediction(ArrayMap<String,String> data) {
        DangerPredictApi apiPredict = new DangerPredictApi();
        apiPredict.registerApiEventListener(this);
        apiPredict.getPredictions(data);
    }

    @Override
    public void onApiSocialIndicatorEvent(JSONObject response) {
        openDialog(response, "social",null);
    }

    @Override
    public void onApiPredictEvent(JSONObject response) {
        openDialog(response, "predict",null);
    }

    @Override
    public void onApiErrorEvent(VolleyError error) {
        openDialog(null, null, error);
    }

    private void openDialog(JSONObject resultsJson, String methodHttp, VolleyError error) {
        String resultStr = new String();
        String titleStr = new String();

        if (error != null) {
            resultStr = error.toString();
            titleStr = "Network Error";

            dialogResults.setContentView(R.layout.activity_prediction_popup);
            TextView textTitle = (TextView) dialogResults.findViewById(R.id.title);
            textTitle.setText(titleStr);
            TextView textResult = (TextView) dialogResults.findViewById(R.id.results);
            textResult.setText(resultStr);
            Button txtClose = (Button) dialogResults.findViewById(R.id.close);
            txtClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogResults.dismiss();
                }
            });
            dialogResults.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialogResults.show();

            spinner.setVisibility(View.GONE);
            pData.buttonPredict.setEnabled(true);
        }
        else if (methodHttp == "predict") {
            sortJsonObject(resultsJson);

            //find highest percentages
            ArrayList<String> highestCrime = findCrimeLabels(sorted.get(0));
            String advise = new String();
            Double d1 = sorted.get(0)*100;
            Double d2 = new Double("50.0");
            if (d1.compareTo(d2) == 1 || d1.compareTo(d2) == 0) {
                advise = String.format("Travel to the place is\n[NOT Advisable]\nsince there is 50%% or more chance of \n%s - %.2f%%\nto happen.\n\n***Complete Assessment***",highestCrime.get(0), d1);
            }
            else if (d1.compareTo(d2) == -1) {
                advise = "Travel to the place is\n[Advisable but with Precautions]\nsince not one crime has\nover 50% chance of happening.\n\n***Complete Assessment***";
            }
            String advise2 = new String();

            ArrayList<String> done = new ArrayList<String>();
            for (int i = 0; i < sorted.size(); i++) {
                Double currentSorted = sorted.get(i);
                for (int j = 0; j < unsorted.size(); j++) {
                    Double currentUnsorted = unsorted.get(j);
                    if (currentSorted.compareTo(currentUnsorted) == 0) {
                        if (!done.contains(pData.crime_labels[j])) {
                            done.add(pData.crime_labels[j]);
                            advise2 = advise2.concat(String.format("\n%.2f%% - %s", currentSorted*100, pData.crime_labels[j]));
                            break;
                        }
                    }
                }
            }

            resultStr = advise.concat(advise2.concat("\n\n++ ALWAYS BE SAFE ++"));
            titleStr = "Calculated Risks";

            Intent intent = new Intent(getBaseContext(), PredictionBarGraph.class);
            intent.putExtra("TITLE_STR", titleStr);
            intent.putExtra("ASSESS_STR", advise);
            for (int i = 0; i < 7; i++) {
                String name1 = new String();
                String name2 = new String();

                name1 = String.format("%s_%s","CRIME",String.valueOf(i));
                name2 = String.format("%s_%s","CRIME_VALUE",String.valueOf(i));

                intent.putExtra(name1, pData.crime_labels[i]);
                intent.putExtra(name2, String.valueOf(unsorted.get(i)*100));
            }
            intent.putExtra("CRIME_DATA", unsorted);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        spinner.setVisibility(View.GONE);
        pData.buttonPredict.setEnabled(true);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        gMap = map;
        gMap.setOnMapClickListener(this);
        gMap.setOnMapLongClickListener(this);
        gMap.animateCamera(CameraUpdateFactory.newCameraPosition(maSocialMap.TAGUM),null);
        maSocialMap.addPolylines(gMap,this);
        markerOptions = new MarkerOptions().position(maSocialMap.startPoint);
        maSocialMap.checkMarkerLocation(maSocialMap.startPoint, markerOptions, this);
        uniMarker = gMap.addMarker(markerOptions);
        uniMarker.showInfoWindow();
    }

    @Override
    public void onMapClick(LatLng point) {
        moveMarker(point);
    }

    @Override
    public void onMapLongClick(LatLng point) {
        moveMarker(point);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch(seekBar.getId()) {
            case R.id.seekBarTemp:
                maWeather.textTemp.setText(String.valueOf(seekBar.getProgress()+15));
                break;
            case R.id.seekBarFeel:
                maWeather.textFeels.setText(String.valueOf(seekBar.getProgress()+15));
                break;
            case R.id.seekBarWind:
                maWeather.textWind.setText(String.valueOf(seekBar.getProgress()));
                break;
            case R.id.seekBarCloud:
                maWeather.textCloud.setText(String.valueOf(seekBar.getProgress()));
                break;
            case R.id.seekBarHumidity:
                maWeather.textHumidity.setText(String.valueOf(seekBar.getProgress()));
                break;
            case R.id.seekBarPrecip:
                maWeather.textPrecip.setText(String.valueOf((float)seekBar.getProgress()/10));
                break;
            case R.id.seekBarPressure:
                maWeather.textPressure.setText(String.valueOf(seekBar.getProgress()+1000));
                break;
            case R.id.seekBarPHPUSD:
                maEconomy.textPHPUSD.setText(String.valueOf(((float)seekBar.getProgress()+40000)/1000));
                break;
            case R.id.seekBarPSEI:
                maEconomy.textPSEI.setText(String.valueOf(((float)seekBar.getProgress()+65000)/10));
                break;
            case R.id.seekBarCPIAllItems:
                maEconomy.textCPIAll.setText(String.valueOf(((float)seekBar.getProgress()+1150)/10));
                break;
            case R.id.seekBarCPIAlcohol:
                maEconomy.textCPIAlcohol.setText(String.valueOf(((float)seekBar.getProgress()+1470)/10));
                break;
            case R.id.seekBarCPITransport:
                maEconomy.textCPITransport.setText(String.valueOf(((float)seekBar.getProgress()+1010)/10));
                break;
            case R.id.seekBarCPIHousing:
                maEconomy.textCPIHousing.setText(String.valueOf(((float)seekBar.getProgress()+1120)/10));
                break;
            case R.id.seekBarCPIRestaurant:
                maEconomy.textCPIRestaurant.setText(String.valueOf(((float)seekBar.getProgress()+1160)/10));
                break;
            case R.id.seekBarInflationRate:
                maEconomy.textRateInflation.setText(String.valueOf(((float)seekBar.getProgress()+20)/10));
                break;
            case R.id.seekBarSavingsRate:
                maEconomy.textRateSavings.setText(String.valueOf(((float)seekBar.getProgress()+650)/1000));
                break;
            case R.id.seekBarBankRate:
                maEconomy.textRateBank.setText(String.valueOf(((float)seekBar.getProgress()+5353)/1000));
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    private void moveMarker (LatLng point) {
        uniMarker.remove();
        markerOptions.position(point);
        maSocialMap.checkMarkerLocation(point, markerOptions, this);
        uniMarker = gMap.addMarker(markerOptions);
        uniMarker.showInfoWindow();
    }

    private boolean allDataValid() {
        String title = new String();
        String message = new String();
        boolean isValid = true;

        if (maSocialMap.selectedLocation == "") {
            title = "Selected Location Invalid";
            message = "Please change the map location to point inside city boundaries.";
            isValid = false;
        }
        else if (maTimeDayWeek.dayGroup.getCheckedRadioButtonId() == -1) {
            title = "No Day of Week selected";
            message = "Please indicate day.";
            isValid = false;
        }
        else if (maTimeDayWeek.timeGroup.getCheckedRadioButtonId() == -1) {
            title = "No Time of Day selected";
            message = "Please indicate time.";
            isValid = false;
        }
        else if (maTimeDayWeek.daylightGroup.getCheckedRadioButtonId() == -1) {
            title = "No Day or Night Stay selected";
            message = "Please indicate stay.";
            isValid = false;
        }
        else if (!maPlaces.selectedPlaces()) {
            title = "No Type of Place selected";
            message = "Please select one or more type of places you see around the vicinity.";
            isValid = false;
        }
        else if (maWeather.weatherGroup.getCheckedRadioButtonId() == -1) {
            title = "No Type of Weather selected";
            message = "Please indicate if weather will be clear, cloudy, or rainy.";
            isValid = false;
        }

        if (!isValid) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage(message).setTitle(title);
            AlertDialog dialog = builder.create();
            dialog.show();
            spinner.setVisibility(View.GONE);
            pData.buttonPredict.setEnabled(true);
            return isValid;
        }

        allData = new ArrayMap<String,String>();
        allData.put("location", maSocialMap.selectedLocation);
        allData.put(pData.ind_vars[0], String.valueOf(uniMarker.getPosition().longitude));
        allData.put(pData.ind_vars[1], String.valueOf(uniMarker.getPosition().latitude));
        allData.put(pData.ind_vars[2],maWeather.textTemp.getText().toString());
        allData.put(pData.ind_vars[3],maWeather.textFeels.getText().toString());
        allData.put(pData.ind_vars[4],maWeather.textWind.getText().toString());
        allData.put(pData.ind_vars[5],maWeather.textCloud.getText().toString());
        allData.put(pData.ind_vars[6],maWeather.textHumidity.getText().toString());
        allData.put(pData.ind_vars[7],maWeather.textPrecip.getText().toString());
        allData.put(pData.ind_vars[8],maWeather.textPressure.getText().toString());
        allData.put(pData.ind_vars[9],String.valueOf(maPlaces.bank.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[10],String.valueOf(maPlaces.bar.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[11],String.valueOf(maPlaces.beach.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[12],String.valueOf(maPlaces.bridge.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[13],String.valueOf(maPlaces.cemetery.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[14],String.valueOf(maPlaces.church.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[15],String.valueOf(maPlaces.clinic.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[16],String.valueOf(maPlaces.commercialBuilding.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[17],String.valueOf(maPlaces.communityCenter.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[18],String.valueOf(maPlaces.convenienceStore.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[19],String.valueOf(maPlaces.fireStation.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[20],String.valueOf(maPlaces.gasStation.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[21],String.valueOf(maPlaces.governmentOffice.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[22],String.valueOf(maPlaces.greenField.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[23],String.valueOf(maPlaces.hospital.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[24],String.valueOf(maPlaces.hotel.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[25],String.valueOf(maPlaces.highway.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[26],String.valueOf(maPlaces.highwayPedestrian.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[27],String.valueOf(maPlaces.highwayPrimary.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[28],String.valueOf(maPlaces.highwaySecondary.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[29],String.valueOf(maPlaces.highwayTertiary.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[30],String.valueOf(maPlaces.highwayResidential.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[31],String.valueOf(maPlaces.industrialBuilding.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[32],String.valueOf(maPlaces.mall.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[33],String.valueOf(maPlaces.marketplace.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[34],String.valueOf(maPlaces.park.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[35],String.valueOf(maPlaces.parkingArea.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[36],String.valueOf(maPlaces.pawnshop.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[37],String.valueOf(maPlaces.pharmacy.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[38],String.valueOf(maPlaces.policeStation.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[39],String.valueOf(maPlaces.postOffice.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[40],String.valueOf(maPlaces.privateOffice.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[41],String.valueOf(maPlaces.recreationalArea.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[42],String.valueOf(maPlaces.road.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[43],String.valueOf(maPlaces.residentialBuilding.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[44],String.valueOf(maPlaces.restaurant.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[45],String.valueOf(maPlaces.school.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[46],String.valueOf(maPlaces.sportsField.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[47],String.valueOf(maPlaces.touristSpot.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[48],String.valueOf(maPlaces.transportTerminal.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[49],maEconomy.textPHPUSD.getText().toString());
        allData.put(pData.ind_vars[50],maEconomy.textPSEI.getText().toString());
        allData.put(pData.ind_vars[110],maEconomy.textCPIAll.getText().toString());
        allData.put(pData.ind_vars[111],maEconomy.textCPIAlcohol.getText().toString());
        allData.put(pData.ind_vars[112],maEconomy.textCPITransport.getText().toString());
        allData.put(pData.ind_vars[113],maEconomy.textCPIHousing.getText().toString());
        allData.put(pData.ind_vars[114],maEconomy.textCPIRestaurant.getText().toString());
        allData.put(pData.ind_vars[115],maEconomy.textRateInflation.getText().toString());
        allData.put(pData.ind_vars[116],maEconomy.textRateSavings.getText().toString());
        allData.put(pData.ind_vars[117],maEconomy.textRateBank.getText().toString());
        allData.put(pData.ind_vars[118],String.valueOf(maTimeDayWeek.timeAfterMidnight.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[119],String.valueOf(maTimeDayWeek.timeAfterWorkHours.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[120],String.valueOf(maTimeDayWeek.timeAfternoon.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[121],String.valueOf(maTimeDayWeek.timeEarlyMorning.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[122],String.valueOf(maTimeDayWeek.timeEvening.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[123],String.valueOf(maTimeDayWeek.timeMorning.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[124],String.valueOf(maTimeDayWeek.dayFri.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[125],String.valueOf(maTimeDayWeek.dayMon.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[126],String.valueOf(maTimeDayWeek.daySat.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[127],String.valueOf(maTimeDayWeek.daySun.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[128],String.valueOf(maTimeDayWeek.dayThu.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[129],String.valueOf(maTimeDayWeek.dayTue.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[130],String.valueOf(maTimeDayWeek.dayWed.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[131],String.valueOf(maWeather.weatherClear.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[132],String.valueOf(maWeather.weatherCloudy.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[133],String.valueOf(maWeather.weatherRainy.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[134],String.valueOf(maTimeDayWeek.stayDay.isChecked() ? 1 : 0));
        allData.put(pData.ind_vars[135],String.valueOf(maTimeDayWeek.stayNight.isChecked() ? 1 : 0));

        return isValid;
    }

}
