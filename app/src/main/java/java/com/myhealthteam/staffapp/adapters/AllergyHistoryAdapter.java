package java.com.myhealthteam.staffapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.com.myhealthteam.staffapp.R;
import java.com.myhealthteam.staffapp.models.AllergyRecord;
import java.util.List;

public class AllergyHistoryAdapter extends RecyclerView.Adapter<AllergyHistoryAdapter.ViewHolder> {

    private List<AllergyRecord> records;

    public AllergyHistoryAdapter(List<AllergyRecord> records) {
        this.records = records;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_allergies, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AllergyRecord record = records.get(position);
        holder.name.setText(record.getName());
        holder.type.setText(record.getType());
        holder.severity.setText(record.getSeverity());
        holder.reaction.setText(record.getReaction());
        holder.notedOn.setText(record.getNotedOn());
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, type, severity, reaction, notedOn;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.allergy_name);
            type = itemView.findViewById(R.id.allergy_type_value);
            severity = itemView.findViewById(R.id.allergy_severity_value);
            reaction = itemView.findViewById(R.id.allergy_reaction_value);
            notedOn = itemView.findViewById(R.id.allergy_noted_on_value);
        }
    }
}