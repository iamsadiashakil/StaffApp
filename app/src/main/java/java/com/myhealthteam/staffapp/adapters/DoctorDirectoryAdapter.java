package java.com.myhealthteam.staffapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.com.myhealthteam.staffapp.R;
import java.com.myhealthteam.staffapp.models.Doctor;
import java.util.List;

public class DoctorDirectoryAdapter extends RecyclerView.Adapter<DoctorDirectoryAdapter.DoctorViewHolder> {

    private List<Doctor> doctorDirectory;
    private final OnDoctorClickListener listener;

    public interface OnDoctorClickListener {
        void onDoctorClick(Doctor doctor);
    }

    public DoctorDirectoryAdapter(List<Doctor> doctorDirectory, OnDoctorClickListener listener) {
        this.doctorDirectory = doctorDirectory;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_doctor_directory, parent, false);
        return new DoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {
        Doctor doctor = doctorDirectory.get(position);
        holder.newDoctorName.setText(doctor.getDoctorName());
        holder.itemView.setOnClickListener(v -> listener.onDoctorClick(doctor));
    }

    @Override
    public int getItemCount() {
        return doctorDirectory.size();
    }

    public void updateList(List<Doctor> newDoctors) {
        doctorDirectory = newDoctors;
        notifyDataSetChanged();
    }

    static class DoctorViewHolder extends RecyclerView.ViewHolder {
        TextView newDoctorName;

        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);
            newDoctorName = itemView.findViewById(R.id.new_doctor_name);
        }
    }
}
