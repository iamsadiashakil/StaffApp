package java.com.myhealthteam.staffapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.com.myhealthteam.staffapp.R;
import java.com.myhealthteam.staffapp.models.Vital;
import java.util.List;

public class VitalsHistoryAdapter extends RecyclerView.Adapter<VitalsHistoryAdapter.VitalViewHolder> {

    private final Context context;
    private final List<Vital> vitals;

    public VitalsHistoryAdapter(Context context, List<Vital> vitals) {
        this.context = context;
        this.vitals = vitals;
    }

    @NonNull
    @Override
    public VitalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_vital_row, parent, false);
        return new VitalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VitalViewHolder holder, int position) {
        Vital vital = vitals.get(position);

        holder.reading.setText(vital.getReading());
        holder.measuredAt.setText(vital.getMeasuredAt());
        holder.status.setText(vital.getStatus());

        // Change the status text color dynamically
        if (vital.getStatus().equalsIgnoreCase("Normal")) {
            holder.status.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.green));
        } else if (vital.getStatus().equalsIgnoreCase("High") ||
                vital.getStatus().equalsIgnoreCase("Fever")) {
            holder.status.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.red));
        }
    }

    @Override
    public int getItemCount() {
        return vitals.size();
    }

    public static class VitalViewHolder extends RecyclerView.ViewHolder {
        TextView reading, measuredAt, status;

        public VitalViewHolder(@NonNull View itemView) {
            super(itemView);
            reading = itemView.findViewById(R.id.text_reading);
            measuredAt = itemView.findViewById(R.id.text_measured_at);
            status = itemView.findViewById(R.id.text_status);
        }
    }
}