package com.example.scoremate;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GameSettings extends AppCompatActivity {
    private LocationManager locationManager;
    private static final int PERM_L = 1;

    private Location getLastKnownLocation() {
        locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
        List<String> providers = locationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return null;
            }
            Location l = locationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                // Found best last known location: %s", l);
                bestLocation = l;
            }
        }
        return bestLocation;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_settings);
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        Context context = getApplicationContext();
        ArrayList<MLBCoords> stadiums = new ArrayList<>();
        stadiums.add(new MLBCoords("Angels", 33.800308, -117.882732));
        stadiums.add(new MLBCoords("Diamondbacks", 33.445526, -112.066664));
        stadiums.add(new MLBCoords("Braves", 33.800308, -84.467705));
        stadiums.add(new MLBCoords("Orioles", 39.283486, -76.621423));
        stadiums.add(new MLBCoords("Cardinals", 38.622619, -90.192821));
        stadiums.add(new MLBCoords("Mets", 40.757114, -73.845189));
        stadiums.add(new MLBCoords("Phillies", 39.905768, -75.166491));
        stadiums.add(new MLBCoords("Tigers", 42.338998, -83.048509));
        stadiums.add(new MLBCoords("Rockies", 39.755883, -104.994177));
        stadiums.add(new MLBCoords("Rangers", 32.751148, -97.082631));
        stadiums.add(new MLBCoords("Reds", 39.097931, -84.508151));
        stadiums.add(new MLBCoords("Royals", 39.051816, -94.480315));
        stadiums.add(new MLBCoords("Marlins", 25.778599, -80.219642));
        stadiums.add(new MLBCoords("Brewers", 43.0282, -87.9713));
        stadiums.add(new MLBCoords("Astros", 29.757222, -95.355354));
        stadiums.add(new MLBCoords("Nationals", 38.873010, -77.007433));
        stadiums.add(new MLBCoords("Athletics", 37.751608, -122.200677));
        stadiums.add(new MLBCoords("Padres", 32.707156, -117.157095));
        stadiums.add(new MLBCoords("Pirates", 40.446855, -80.005666));
        stadiums.add(new MLBCoords("Guardians", 41.495149, -81.685267));
        stadiums.add(new MLBCoords("Blue Jays", 43.641467, -79.389244));
        stadiums.add(new MLBCoords("Twins", 44.981722, -93.277495));
        stadiums.add(new MLBCoords("Mariners", 47.591290, -122.332044));
        stadiums.add(new MLBCoords("Yankees", 40.829643, -73.926175));
        stadiums.add(new MLBCoords("White Sox", 41.829902, -87.633759));
        stadiums.add(new MLBCoords("Giants", 37.778595, -122.389270));
        stadiums.add(new MLBCoords("Dodgers", 34.073851, -118.240869));
        stadiums.add(new MLBCoords("Rays",27.768284, -82.653961));
        stadiums.add(new MLBCoords("Red Sox", 42.346676, -71.097218));
        stadiums.add(new MLBCoords("Cubs", 41.948438, -87.655333));



        EditText teamname = (EditText) findViewById(R.id.teamname);
        SwitchMaterial away = (SwitchMaterial) findViewById(R.id.awayswitch);
        EditText inning = (EditText) findViewById(R.id.inning);
        Button back = (Button) findViewById(R.id.settingsback);
        Button setlineup = (Button) findViewById(R.id.lineupbutton);
        Button autofill = (Button) findViewById(R.id.autofill);


        boolean awaybool = false;

        autofill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double latitude = 0;
                double longitude = 0;
                // Get the user's current location
                if (ActivityCompat.checkSelfPermission(GameSettings.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // Request permission to access the user's location
                    ActivityCompat.requestPermissions(GameSettings.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, PERM_L);
                } else {
                    // Get the user's location
                    Location location = getLastKnownLocation();
                    System.out.println(location);
                        // Extract the latitude and longitude from the user's location
                        latitude = location.getLatitude();
                        longitude = location.getLongitude();


                }

                // Calculate the distance between the user's location and each MLB stadium
                List<Pair<MLBCoords, Double>> distances = new ArrayList<>();
                for (MLBCoords stadium : stadiums) {
                    double distance = distance(latitude, longitude, stadium.latitude, stadium.longitude);
                    distances.add(new Pair<>(stadium, distance));
                }

// Sort the stadiums by distance
                Collections.sort(distances, new Comparator<Pair<MLBCoords, Double>>() {
                    @Override
                    public int compare(Pair<MLBCoords, Double> o1, Pair<MLBCoords, Double> o2) {
                        return o1.second.compareTo(o2.second);
                    }
                });

                // Display the closest MLB stadium to the user's current location
                String closestStadiumName = distances.get(0).first.name;
                teamname.setText(closestStadiumName);

            }

        });

        away.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(away.isChecked()){


                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(GameSettings.this, TitleScreen.class);

                startActivity(back);
            }
        });

        setlineup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lineup = new Intent(GameSettings.this, BatterSelect.class);
                if (away.isChecked()){
                    lineup.putExtra("away", true);
                }
                else{
                    lineup.putExtra("away", false);
                }
                lineup.putExtra("team", teamname.getText().toString());
                lineup.putExtra("innings", Integer.parseInt(inning.getText().toString()));
                startActivity(lineup);
            }
        });

    }


    // Calculate the distance between two sets of coordinates using the Haversine formula
    public double distance(double latitude1, double longitude1, double latitude2, double longitude2) {
        double earthRadius = 6371; // km
        double dLat = Math.toRadians(latitude2 - latitude1);
        double dLon = Math.toRadians(longitude2 - longitude1);
        double a = (Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;
        return distance;
    }

}
