package java.com.myhealthteam.staffapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.com.myhealthteam.staffapp.R;
import java.com.myhealthteam.staffapp.models.Message;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_USER = 1;
    private static final int VIEW_TYPE_CARETAKER = 2;

    private Context context;
    private List<Message> messageList;

    public ChatAdapter(Context context, List<Message> messageList) {
        this.context = context;
        this.messageList = messageList;
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messageList.get(position);
        return message.isUserMessage() ? VIEW_TYPE_USER : VIEW_TYPE_CARETAKER;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_USER) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_chat_user, parent, false);
            return new UserMessageViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_chat_caretaker, parent, false);
            return new CaretakerMessageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message message = messageList.get(position);
        if (holder instanceof UserMessageViewHolder) {
            ((UserMessageViewHolder) holder).txtMessage.setText(message.getText());
            ((UserMessageViewHolder) holder).txtTimestamp.setText(message.getTimestamp());
        } else if (holder instanceof CaretakerMessageViewHolder) {
            ((CaretakerMessageViewHolder) holder).txtMessage.setText(message.getText());
            ((CaretakerMessageViewHolder) holder).txtTimestamp.setText(message.getTimestamp());
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    static class UserMessageViewHolder extends RecyclerView.ViewHolder {
        TextView txtMessage;
        TextView txtTimestamp;

        public UserMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMessage = itemView.findViewById(R.id.message_text);
            txtTimestamp = itemView.findViewById(R.id.timestamp);
        }
    }

    static class CaretakerMessageViewHolder extends RecyclerView.ViewHolder {
        TextView txtMessage;
        TextView txtTimestamp;

        public CaretakerMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMessage = itemView.findViewById(R.id.message_text);
            txtTimestamp = itemView.findViewById(R.id.timestamp);
        }
    }
}