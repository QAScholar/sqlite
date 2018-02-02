package com.example.preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText write;
    Button writebtn;
    Button go;

//    SharedPreferences sp;
//
//    final String Text="text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        write=findViewById(R.id.write);
        writebtn=findViewById(R.id.btnwrite);
       go.findViewById(R.id.transition);

        writebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sp=getPreferences(MODE_PRIVATE);
//                SharedPreferences.Editor ed=sp.edit();
//                ed.putString(Text,write.getText().toString());
//                ed.commit();
            }
        });
//        gobtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent go=new Intent(MainActivity.this,second.class);
//                startActivity(go);
//            }
//        });
    }
}
