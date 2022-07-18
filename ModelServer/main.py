# Copyright 2015 Google Inc. All Rights Reserved.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# [START gae_flex_quickstart]
import logging

from flask import Flask, request
from sklearn.externals import joblib
import pandas as pd
import json


app = Flask(__name__)


crime_labels = {
    7: 'Vehicular Traffic Accident',
    2: 'Murder/Homicide',
    3: 'Physical Injuries',
    1: 'Drug Related Incident (RA 9165)',
    6: 'Theft',
    0: 'Carnapping (R.A. 6539)',
    4: 'Rape (Art. 266-A RC & R.A.8353)',
    5: 'Robbery'
 }

independent_columns = [
    'Temp (deg celsius)',
    'Feels Like (deg celsius)',
    'Wind (km/h)',
    'Cloud',
    'Humidity',
    'Precip (mm)',
    'Pressure (mb)',
    'Bank',
    'Bar',
    'Beach',
    'Bridge',
    'Cemetery',
    'Church',
    'Clinic',
    'Commercial Building',
    'Community Center',
    'Convenience Store',
    'Fire Station',
    'Gas Station',
    'Government Office',
    'Greenfield',
    'Highway',
    'Highway Pedestrian',
    'Highway Primary',
    'Highway Residential',
    'Highway Secondary',
    'Highway Tertiary',
    'Hospital',
    'Hotel',
    'Industrial Building',
    'Mall',
    'Marketplace',
    'Park',
    'Parking Area',
    'Pawnshop',
    'Pharmacy',
    'Police Station',
    'Post Office',
    'Private Office',
    'Recreational Area',
    'Residential Building',
    'Restaurant',
    'Road',
    'School',
    'Sports Center',
    'Tourist Attraction',
    'Transport Terminal',
    'php-usd-rate',
    'PSE-index-Close',
    'Education,Baccalauate graduate',
    'Education,College undergraduate',
    'Education,Elementary',
    'Education,High school',
    'Education,No grade completed',
    'Education,Out of school youth',
    'Education,Post baccalaureate',
    'Education,Postsecondary',
    'Household,number of households',
    'Housing,dwelling tenure status,Own house rent lot',
    'Housing,dwelling tenure status,Own house rent,free lot with consent of owner',
    'Housing,dwelling tenure status,Own house rent,free lot without consent of owner',
    'Housing,dwelling tenure status,Own or owner,like possession of house and lot',
    'Housing,dwelling tenure status,Rent house/ room including lot',
    'Housing,dwelling tenure status,Rent,free house and lot with consent of owner',
    'Housing,dwelling tenure status,Rent,free house and lot without consent of owner',
    'Labor,Employed',
    'Labor,In the Labor Force',
    'Labor,Not in the Labor Force',
    'Labor,Underemployed',
    'Labor,Unemployed',
    'Poverty,poverty incidence by employed',
    'Poverty,poverty incidence by household',
    'Poverty,poverty incidence by population',
    'Poverty,poverty incidence by unemployed',
    'Consumer Price Index  - all items',
    'Consumer Price Index -Alcoholic beverages and tobacco',
    'Consumer Price Index -transport',
    'Consumer Price Index -Housing, water, electricity, gas, and other fuels',
    'Consumer Price Index -Restaurant and miscellaneous goods and services',
    'inflation rate',
    'savings deposit interest rate',
    'bank lending rates',
    'time_epoch_After Midnight',
    'time_epoch_After Work-Hours',
    'time_epoch_Afternoon',
    'time_epoch_Early Morning',
    'time_epoch_Evening',
    'time_epoch_Morning',
    'day_Friday',
    'day_Monday',
    'day_Saturday',
    'day_Sunday',
    'day_Thursday',
    'day_Tuesday',
    'day_Wednesday',
    'Weather_Clear',
    'Weather_Cloudy',
    'Weather_Rainy',
    'day_night_daylight',
    'day_night_nighttime',
    'placetype_rural',
    'placetype_urban',
    'Children Population',
    'Teenage Population',
    'Adult Population',
    'Retiree Population',
    'Female Children Population',
    'Female Teenage Population',
    'Female Adult Population',
    'Female Retiree Population',
    'Male Children Population',
    'Male Teenage Population',
    'Male Adult Population',
    'Male Retiree Population',
]

social_independent = [
    'Education,Baccalauate graduate',
    'Education,College undergraduate',
    'Education,Elementary',
    'Education,High school',
    'Education,No grade completed',
    'Education,Out of school youth',
    'Education,Post baccalaureate',
    'Education,Postsecondary',
    'Household,number of households',
    'Housing,dwelling tenure status,Own house rent lot',
    'Housing,dwelling tenure status,Own house rent,free lot with consent of owner',
    'Housing,dwelling tenure status,Own house rent,free lot without consent of owner',
    'Housing,dwelling tenure status,Own or owner,like possession of house and lot',
    'Housing,dwelling tenure status,Rent house/ room including lot',
    'Housing,dwelling tenure status,Rent,free house and lot with consent of owner',
    'Housing,dwelling tenure status,Rent,free house and lot without consent of owner',
    'Labor,Employed',
    'Labor,In the Labor Force',
    'Labor,Not in the Labor Force',
    'Labor,Underemployed',
    'Labor,Unemployed',
    'Poverty,poverty incidence by employed',
    'Poverty,poverty incidence by household',
    'Poverty,poverty incidence by population',
    'Poverty,poverty incidence by unemployed',
    'Children Population',
    'Teenage Population',
    'Adult Population',
    'Retiree Population',
    'Female Children Population',
    'Female Teenage Population',
    'Female Adult Population',
    'Female Retiree Population',
    'Male Children Population',
    'Male Teenage Population',
    'Male Adult Population',
    'Male Retiree Population',
]

@app.route('/')
def hello():
    """Return a friendly HTTP greeting."""
    return 'Hello World!'

@app.route('/api/social_indicators', methods=['POST'])
def social_indicators():
    user_data = request.get_json()
    location = user_data['location']
    social_ind = {}

    social_csv = pd.read_csv('data/social_indicators.csv', encoding='utf-8')
    for index, row in social_csv.iterrows():
        if social_csv.loc[index,'location'] == location:
            social_ind = row.to_json()

    return social_ind

@app.route('/api/predict', methods=['POST'])
def predict():
    user_data = request.get_json()
    query_df = pd.DataFrame([user_data])
    # clean data from android app
    query_df.rename(columns={'Wind (km\/h)': 'Wind (km/h)'},inplace=True)
    #get location data
    social_csv = pd.read_csv('data/social_indicators.csv', encoding='utf-8')
    soci = social_csv[social_csv['location'] == query_df.loc[0,'location']]
    soci = soci.reset_index()
    city = soci['city'][0]

    a = 0
    while a < len(social_independent):
        query_df[social_independent[a]] = soci.loc[0,social_independent[a]]
        a+=1
    if soci.loc[0,'placetype'] == 'rural':
        query_df['placetype_rural'] = 1
        query_df['placetype_urban'] = 0
    elif soci.loc[0,'placetype'] == 'urban':
        query_df['placetype_rural'] = 0
        query_df['placetype_urban'] = 1
    query_df.drop(['location'],axis=1,inplace=True)

    if city == 'Tagum City':
        predictmodel = joblib.load('data/randomforest_dangerpredict_model_tagum.pkl')
    if city == 'Panabo City':
        predictmodel = joblib.load('data/randomforest_dangerpredict_model_panabo.pkl')
    if city == 'Samal City':
        predictmodel = joblib.load('data/randomforest_dangerpredict_model_samal.pkl')

    prediction = predictmodel.predict_proba(query_df[independent_columns])
    crime_predictions = {}
    x=0
    while x < len(prediction[0]):
        crime_predictions[crime_labels[x]] = prediction[0][x]
        x+=1
    return json.dumps(crime_predictions)

@app.errorhandler(500)
def server_error(e):
    logging.exception('An error occurred during a request.')
    return """
    An internal error occurred: <pre>{}</pre>
    See logs for full stacktrace.
    """.format(e), 500


if __name__ == '__main__':
    # This is used when running locally. Gunicorn is used to run the
    # application on Google App Engine. See entrypoint in app.yaml.
    app.run(host='localhost', port=5000, debug=True)
# [END gae_flex_quickstart]
