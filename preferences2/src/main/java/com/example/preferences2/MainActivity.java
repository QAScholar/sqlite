package com.example.preferences2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText enter;
    Button writebtn;
    Button readbtn;
    TextView read;
    public final String TextFile="TextFile";
    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enter=findViewById(R.id.enter);
        read=findViewById(R.id.see);
        readbtn=findViewById(R.id.read);
        writebtn=findViewById(R.id.write);

        writebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings=getSharedPreferences(TextFile,MODE_PRIVATE);
                SharedPreferences.Editor editor=settings.edit();
                editor.putString(TextFile,enter.getText().toString());
                editor.commit();
//                Toast.makeText(this,"aaa",Toast.LENGTH_SHORT).show();
            }
        });
        readbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings=getSharedPreferences(TextFile,0);
                String savedText=settings.getString(TextFile,"");
                read.setText(savedText);
            }
        });
    }
}
