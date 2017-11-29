## Disclaimer: This is an open source project. This project does NOT affiliated to Data.gov.sg

# Why I created this open source project?
1. As a project for me to learn writing Android library and other learning purposes.
2. To help others to save time in implement Data.gov.sg API responses in Android project.

# Requirements
1. Android plugin for gradle 3 or above (example: com.android.tools.build:gradle:3.0.0-rc2)
2. Gradle version 4.1 or above

# How to use
1. In your app level build.gradle add
```groovy
compile 'com.winsontan520.datagovsg:datagovsg:0.1.12'
```

2. In your main application onCreate
```groovy
DataGovSg.initialize(YOUR_API_KEY);
```
3. Example to get traffic images
```groovy
DataGovSg.requestTrafficImages(new Callback<DataWrapper>() {

            @Override
            public void onResponse(Call<DataWrapper> call, Response<DataWrapper> response) {
                // handle your response here, for help checkout the sample in this repo
                updateUI(response);
            }

            @Override
            public void onFailure(Call<DataWrapper> call, Throwable t) {
                // implement your own error handling here
                Log.e(TAG, "onFailure" + t);
            }
        });
```

# To-Do
- Sample app
- 4-day-weather-forecast
- GETair-temperature
- GETpm25
- GETpsi
- GETrainfall
- GETrelative-humidity
- GETuv-index
- GETwind-direction
- GETwind-speed

# Credits
Thanks Data.gov.sg providing data for public to access.

# License

    Copyright 2017 Winson Tan

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
