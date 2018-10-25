package my.edu.taruc.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private static final String REPLY_TAG = "package my.edu.taruc.lab2";
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String stringMsg;
        TextView textviewMsg = findViewById(R.id.textViewMessage);
        Intent intent = getIntent();
        if (intent.hasExtra(MainActivity.MESSAGE_TAG)) {
            stringMsg = intent.getStringExtra(MainActivity.MESSAGE_TAG);
            textviewMsg.setText(stringMsg);
        }
    }

    public void sendReply(View view) {
        EditText editTextReply;
        editTextReply = findViewById(R.id.editTextReply);
        if (TextUtils.isEmpty(editTextReply.getText())) {
            editTextReply.setError(getString(R.string.error_reply));
            return;
        }

        String stringReply = editTextReply.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(REPLY_TAG, stringReply);
        setResult(RESULT_OK), intent);

    }
}