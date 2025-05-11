package java.com.myhealthteam.staffapp.activities;

import android.app.Activity;
import android.os.Bundle;
import java.com.myhealthteam.staffapp.R;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Links the activity to the XML layout file
    }
}
