package com.android.breastcancerdiagnosis;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_patients:
                    switchToPatients();
                    return true;
                case R.id.navigation_dashboard:
                    switchToDashboard();
                    return true;
                case R.id.navigation_settings:
                    switchToSettings();
                    return true;
                case R.id.navigation_profile:
                    switchToProfile();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frameLayout, new PatientFragment()).commit();
    }

    public void switchToPatients(){
        fragmentManager.beginTransaction().replace(R.id.frameLayout, new PatientFragment()).commit();
    }

    public void switchToDashboard(){
        fragmentManager.beginTransaction().replace(R.id.frameLayout, new DashboardFragment()).commit();
    }

    public void switchToSettings(){
        fragmentManager.beginTransaction().replace(R.id.frameLayout, new SettingsFragment()).commit();
    }

    public void switchToProfile(){
        fragmentManager.beginTransaction().replace(R.id.frameLayout, new ProfileFragment()).commit();
    }
}
