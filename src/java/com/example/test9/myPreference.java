package com.example.test9;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v14.preference.PreferenceFragment;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.PreferenceManager;

public class myPreference extends PreferenceFragment {
    SharedPreferences prefs;
    ListPreference network;

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.setting);
        network = (ListPreference) findPreference("network");
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (!prefs.getString("network", "").equals(""))
            network.setSummary(prefs.getString("network", "2G"));
        prefs.registerOnSharedPreferenceChangeListener(prefListener);
    }

    SharedPreferences.OnSharedPreferenceChangeListener prefListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if(key.equals("network"))
                network.setSummary(prefs.getString("network","2G"));
        }
    };
}
