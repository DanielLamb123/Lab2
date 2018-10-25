package my.edu.taruc.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
static final String MESSAGE_TAG="my.edu.tarc.lab2.MESSAGE";
    private static final int REQUEST_REPLY_CODE =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Main",  "OnPause");
    }

    protected void OnPause(){
        super.onPause();
        Log.d("Main",  "OnPause");
    }

    protected void OnResume(){
        super.onResume();
        Log.d("Main",  "OnPause");
    }

    public void sendMessage(View view){
        String stringMsg;
        EditText editTextMsg;
        editTextMsg=findViewById(R.id.editTextMessage);
        if(TextUtils.isEmpty(editTextMsg.getText())){
            editTextMsg.setError(getString(R.string.error_message));
            return;
        }

        Intent intent=new Intent( getApplicationContext(),SecondActivity.class);
        stringMsg=editTextMsg.getText().toString();
        intent.putExtra( "MESSAGE_TAG",stringMsg);
        startActivity(intent);

        startActivityForResult(intent,REQUEST_REPLY_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //TODO: Complete result handling process
        if(requestCode==REQUEST_REPLY_CODE){
            if(resultCode==RESULT_OK){
                String stringMsg;
                TextView textViewReply=findViewById(R.id.textViewMessage);
                stringReply=data.getStringExtra(SecondActivity.REPLY_TAG);
                textViewReply.setText(stringReply);
            }
        }

    }
}
