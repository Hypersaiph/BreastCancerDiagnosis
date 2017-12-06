package com.android.breastcancerdiagnosis;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mehdi.sakout.fancybuttons.FancyButton;

public class PatientFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Patient> patientArray = new ArrayList<>();

    public PatientFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_patient, container, false);
    }
    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Patient a = new Patient(1, "#17A89B", "5/12/2017",98.55,true);
        Patient b = new Patient(2, "#45E56T", "1/12/2017",99.34,false);
        patientArray.add(a);
        patientArray.add(b);
        //AQUI INICIALIZAR LOS OBJETOS
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        mAdapter = new patientArrayAdapter(patientArray, getActivity());
        recyclerView.setAdapter(mAdapter);
    }
    public class patientArrayAdapter extends RecyclerView.Adapter<patientArrayAdapter.ViewHolder> {
        private ArrayList<Patient> patientArray = new ArrayList<>();
        private final Picasso picasso;
        private Context context;
        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            TextView textID;
            TextView textDate;
            TextView textPercentage;
            CheckBox checkDiagnostic;
            FancyButton btnSee;
            ViewHolder(View view) {
                super(view);
                btnSee = (FancyButton) view.findViewById(R.id.btnSee);
                textID = (TextView) view.findViewById(R.id.textID);
                textDate = (TextView) view.findViewById(R.id.textDate);
                textPercentage = (TextView) view.findViewById(R.id.textPercentage);
                checkDiagnostic = (CheckBox) view.findViewById(R.id.checkDiagnostic);
            }
        }
        // Provide a suitable constructor (depends on the kind of dataset)
        public patientArrayAdapter(ArrayList<Patient> patientArray, Context context) {
            this.patientArray = patientArray;
            this.picasso = Picasso.with(context);
            this.context = context;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public patientArrayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_patient, parent, false);
            // set the view's size, margins, paddings and layout parameters
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }
        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.textID.setText(patientArray.get(position).getHospitalID());
            holder.textDate.setText(patientArray.get(position).getLastDate());
            holder.textPercentage.setText(patientArray.get(position).getPrecision().toString());
            if(patientArray.get(position).isMalignant()){
                holder.checkDiagnostic.setChecked(true);
                holder.checkDiagnostic.setText("Maligno");
            }else{
                holder.checkDiagnostic.setChecked(false);
                holder.checkDiagnostic.setText("Benigno");
            }
            holder.btnSee.setIconResource(R.mipmap.ic_remove_red_eye_black_48dp);
            holder.btnSee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DiagnosesActivity.class);
                    startActivity(intent);
                    Toast.makeText(context, ""+patientArray.get(position).getHospitalID(), Toast.LENGTH_SHORT).show();
                }
            });

        }
        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return patientArray.size();
        }
    }
}
