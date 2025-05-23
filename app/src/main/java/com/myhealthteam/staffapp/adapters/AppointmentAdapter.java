package com.myhealthteam.staffapp.adapters;

import android.content.Context;
import android.content.Intent;
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
import com.myhealthteam.staffapp.activities.AppointmentDetailsActivity;
import com.myhealthteam.staffapp.models.Appointment;
import com.myhealthteam.staffapp.models.Patient;
import com.myhealthteam.staffapp.utils.MockData;
import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder> {

    private Context context;
    private List<Appointment> appointmentList;

    public AppointmentAdapter(Context context, List<Appointment> appointmentList) {
        this.context = context;
        this.appointmentList = appointmentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_appointment_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Appointment appointment = appointmentList.get(position);
        Patient patient = MockData.getPatientById(appointment.getPatientId());
        holder.patientImage.setColorFilter(ContextCompat.getColor(context, R.color.primary), PorterDuff.Mode.SRC_IN);
        holder.patientName.setText(patient.getName());
        holder.time.setText(appointment.getTime());
        holder.status.setText(appointment.getStatus());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, AppointmentDetailsActivity.class);
            intent.putExtra("patient_id", appointment.getPatientId());
            intent.putExtra("appointment_id", appointment.getId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return appointmentList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView patientName, time, status, notes;
        ImageView patientImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            patientImage = itemView.findViewById(R.id.patient_image);
            patientName = itemView.findViewById(R.id.patient_name);
            time = itemView.findViewById(R.id.appointment_time);
            status = itemView.findViewById(R.id.appointment_status);
            notes = itemView.findViewById(R.id.appointment_notes);
        }
    }
}