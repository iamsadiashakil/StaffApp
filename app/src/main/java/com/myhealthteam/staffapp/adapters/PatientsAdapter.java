package com.myhealthteam.staffapp.adapters;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.myhealthteam.staffapp.R;
import com.myhealthteam.staffapp.models.Patient;
import java.util.List;

public class PatientsAdapter extends RecyclerView.Adapter<PatientsAdapter.PatientViewHolder> {

    private final Context context;
    private List<Patient> patientList;
    protected final OnPatientClickListener listener;

    public interface OnPatientClickListener {
        void onPatientClick(Patient patient);
    }

    public PatientsAdapter(Context context, List<Patient> patientList, OnPatientClickListener listener) {
        this.context = context;
        this.patientList = patientList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_patient, parent, false);
        return new PatientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder holder, int position) {
        Patient patient = patientList.get(position);

        // Bind data to views
        holder.patientImage.setColorFilter(ContextCompat.getColor(context, R.color.primary), PorterDuff.Mode.SRC_IN);
        holder.patientName.setText(patient.getName());
        holder.patientAge.setText(patient.getAge() + " years");
        holder.patientSex.setText(patient.getSex());
        holder.patientBloodGroup.setText(patient.getBloodGroup());

        // Set status indicator color based on 'isActive' status
        if (patient.isActive()) {
            holder.statusIndicator.setBackgroundResource(R.drawable.circle_green); // Active
        } else {
            holder.statusIndicator.setBackgroundResource(R.drawable.circle_red); // Inactive
        }

        holder.itemView.setOnClickListener(v -> listener.onPatientClick(patient));
    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }

    public void updateList(List<Patient> newPatients) {
        patientList = newPatients;
        notifyDataSetChanged();
    }

    public static class PatientViewHolder extends RecyclerView.ViewHolder {
        ImageView patientImage;
        TextView patientName;
        TextView patientAge;
        TextView patientSex;
        TextView patientBloodGroup;
        View statusIndicator;

        public PatientViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize views
            patientImage = itemView.findViewById(R.id.patient_image);
            patientName = itemView.findViewById(R.id.patient_name);
            patientAge = itemView.findViewById(R.id.patient_age);
            patientSex = itemView.findViewById(R.id.patient_sex);
            patientBloodGroup = itemView.findViewById(R.id.patient_blood_group);
            statusIndicator = itemView.findViewById(R.id.status_indicator);
        }
    }
}
