package java.com.myhealthteam.staffapp.activities;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.com.myhealthteam.staffapp.R;
import java.com.myhealthteam.staffapp.adapters.ChatAdapter;
import java.com.myhealthteam.staffapp.models.Message;
import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends Activity {

    private RecyclerView recyclerView;
    private ChatAdapter messageAdapter;
    private List<Message> messageList;

    private EditText inputMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // Initialize views
        recyclerView = findViewById(R.id.recycler_chat);
        TextView patientCaretakerTextView = findViewById(R.id.patient_caretaker_title);
        inputMessageEditText = findViewById(R.id.input_message);
        ImageButton sendButton = findViewById(R.id.send_button);

        // Get doctor details from intent
        String patientCaretaker = getIntent().getStringExtra("patient_caretaker");

        // Set up back button
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN);
        backButton.setOnClickListener(v -> finish());


        // Set doctor name in toolbar
        patientCaretakerTextView.setText(patientCaretaker);

        // Initialize RecyclerView
        messageList = new ArrayList<>();
        messageAdapter = new ChatAdapter(this, messageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(messageAdapter);

        // Load existing messages (mocked or fetched via API)
        loadMessages();

        // Handle send button click
        sendButton.setOnClickListener(v -> sendMessage());
    }

    private void loadMessages() {
        // Mock data: Replace with API call to fetch messages
        messageList.add(new Message("Hi, I have a question about my prescription.", false, "10:32 AM"));
        messageList.add(new Message("Sure, I’m here to help. Please go ahead with your question" +
                " about the prescription.", true, "10:30 AM"));
        messageAdapter.notifyDataSetChanged();
    }

    private void sendMessage() {
        String messageText = inputMessageEditText.getText().toString().trim();
        if (!messageText.isEmpty()) {
            // Add message to the list
            messageList.add(new Message(messageText, true, "Now")); // true indicates it's the user's message
            messageAdapter.notifyItemInserted(messageList.size() - 1);
            recyclerView.scrollToPosition(messageList.size() - 1);
            inputMessageEditText.setText("");

            // Simulate caretaker's reply
            simulateCaretakerReply();
        }
    }

    private void simulateCaretakerReply() {
        recyclerView.postDelayed(() -> {
            messageList.add(new Message("Thank you, Doctor. I appreciate your guidance and will " +
                    "follow your advice. Please let me know if there’s anything else I should be " +
                    "aware of.", false, "Now")); // false indicates caretaker's message
            messageAdapter.notifyItemInserted(messageList.size() - 1);
            recyclerView.scrollToPosition(messageList.size() - 1);
        }, 1000);
    }

}
