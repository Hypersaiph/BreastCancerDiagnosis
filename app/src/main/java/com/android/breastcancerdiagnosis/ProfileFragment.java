package com.android.breastcancerdiagnosis;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mikhaellopez.circularimageview.CircularImageView;

import com.squareup.picasso.Picasso;

import mehdi.sakout.fancybuttons.FancyButton;

public class ProfileFragment extends Fragment {

    private CircularImageView profileImage;
    private FancyButton updateName,updateEmail,updateEstablishment,updateLinkedin,btnLogOut;
    private ImageView linkedinIcon,verifiedUser;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        verifiedUser = (ImageView) view.findViewById(R.id.verifiedUser);
        linkedinIcon = (ImageView) view.findViewById(R.id.linkedinIcon);
        profileImage = (CircularImageView) view.findViewById(R.id.profileImage);
        updateName = (FancyButton) view.findViewById(R.id.btnUpdateName);
        updateEmail = (FancyButton) view.findViewById(R.id.btnUpdateEmail);
        updateEstablishment = (FancyButton) view.findViewById(R.id.btnUpdateEstablishment);
        updateLinkedin = (FancyButton) view.findViewById(R.id.btnUpdateLinkedin);
        btnLogOut = (FancyButton) view.findViewById(R.id.btnLogOut);

        btnLogOut.setIconResource(R.mipmap.ic_close_black_24dp);
        updateName.setIconResource(R.mipmap.ic_mode_edit_black_24dp);
        updateEmail.setIconResource(R.mipmap.ic_mode_edit_black_24dp);
        updateEstablishment.setIconResource(R.mipmap.ic_mode_edit_black_24dp);
        updateLinkedin.setIconResource(R.mipmap.ic_mode_edit_black_24dp);
        Picasso.with(getActivity()).load(R.drawable.gvs).into(profileImage);
        Picasso.with(getActivity()).load(R.drawable.linkedin).into(linkedinIcon);
        Picasso.with(getActivity()).load(R.drawable.verified50pc).into(verifiedUser);
    }

}
