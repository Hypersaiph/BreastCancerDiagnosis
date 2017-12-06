package com.android.breastcancerdiagnosis;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mehdi.sakout.fancybuttons.FancyButton;

public class DiagnosesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private LayoutInflater layoutInflater;
    ArrayList<Diagnosis> diagnosisArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnoses);
        layoutInflater = LayoutInflater.from(this);
        Diagnosis a = new Diagnosis(1,"11/12/2017","1",true);
        Diagnosis b = new Diagnosis(2,"10/12/2017","2",false);
        diagnosisArray.add(a);
        diagnosisArray.add(b);
        //AQUI INICIALIZAR LOS OBJETOS
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        mAdapter = new diagnosisArrayAdapter(diagnosisArray, this);
        recyclerView.setAdapter(mAdapter);
    }
    public void see(){
        AlertDialog.Builder builder = new AlertDialog.Builder(DiagnosesActivity.this);
        builder.setTitle(R.string.diagnosis_detail);
        View view = layoutInflater.inflate(R.layout.item_diagnosis_detail, null);
        builder.setView(view);


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
                dialog.cancel();
            }
        });
        builder.show();
    }
    public class diagnosisArrayAdapter extends RecyclerView.Adapter<diagnosisArrayAdapter.ViewHolder> {
        private ArrayList<Diagnosis> diagnosisArray = new ArrayList<>();
        private final Picasso picasso;
        private Context context;
        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            TextView textID;
            TextView textDate;
            TextView textDiagnosis;
            FancyButton btnSee;
            ViewHolder(View view) {
                super(view);
                btnSee = (FancyButton) view.findViewById(R.id.btnSee);
                textID = (TextView) view.findViewById(R.id.textID);
                textDate = (TextView) view.findViewById(R.id.textDate);
                textDiagnosis = (TextView) view.findViewById(R.id.textDiagnosis);
            }
        }
        // Provide a suitable constructor (depends on the kind of dataset)
        public diagnosisArrayAdapter(ArrayList<Diagnosis> diagnosisArray, Context context) {
            this.diagnosisArray = diagnosisArray;
            this.picasso = Picasso.with(context);
            this.context = context;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public diagnosisArrayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_diagnoses, parent, false);
            // set the view's size, margins, paddings and layout parameters
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }
        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.textID.setText(diagnosisArray.get(position).getId()+"");
            holder.textDate.setText(diagnosisArray.get(position).getDate());
            if(diagnosisArray.get(position).isMalignant()){
                holder.textDiagnosis.setText("Maligno");
            }else{
                holder.textDiagnosis.setText("Benigno");
            }
            holder.btnSee.setIconResource(R.mipmap.ic_assessment_black_36dp);
            holder.btnSee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    see();
                }
            });

        }
        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return diagnosisArray.size();
        }
    }
}
