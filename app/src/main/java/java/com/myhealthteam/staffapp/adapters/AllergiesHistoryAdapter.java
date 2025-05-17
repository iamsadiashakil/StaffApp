package java.com.myhealthteam.staffapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.com.myhealthteam.staffapp.R;
import java.com.myhealthteam.staffapp.models.Allergy;
import java.util.List;

public class AllergiesHistoryAdapter extends RecyclerView.Adapter<AllergiesHistoryAdapter.AllergyViewHolder> {

    private final Context context;
    private final List<Allergy> allergies;

    public AllergiesHistoryAdapter(Context context, List<Allergy> allergies) {
        this.context = context;
        this.allergies = allergies;
    }

    @NonNull
    @Override
    public AllergyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_allergy_row, parent, false);
        return new AllergyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllergyViewHolder holder, int position) {
        Allergy allergy = allergies.get(position);

        holder.name.setText(allergy.getName());
        holder.type.setText(allergy.getType());
        holder.severity.setText(allergy.getSeverity());
        holder.reaction.setText(allergy.getReaction());
        holder.notedOn.setText(allergy.getNotedOn());
    }

    @Override
    public int getItemCount() {
        return allergies.size();
    }

    public static class AllergyViewHolder extends RecyclerView.ViewHolder {
        TextView name, type, severity, reaction, notedOn;

        public AllergyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_allergy_name);
            type = itemView.findViewById(R.id.text_allergy_type);
            severity = itemView.findViewById(R.id.text_allergy_severity);
            reaction = itemView.findViewById(R.id.text_allergy_reaction);
            notedOn = itemView.findViewById(R.id.text_allergy_noted_on);
        }
    }
}