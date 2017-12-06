package com.android.breastcancerdiagnosis;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class SettingsFragment extends Fragment {
    private ImageView google_icon, facebook_icon;
    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }
    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        google_icon = (ImageView) view.findViewById(R.id.google_icon);
        facebook_icon = (ImageView) view.findViewById(R.id.facebook_icon);
        Picasso.with(getActivity()).load(R.drawable.google).into(google_icon);
        Picasso.with(getActivity()).load(R.drawable.facebook).into(facebook_icon);
    }

}
