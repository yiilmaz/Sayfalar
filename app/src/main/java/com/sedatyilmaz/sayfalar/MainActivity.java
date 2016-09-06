package com.sedatyilmaz.sayfalar;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView3 = (TextView) findViewById(R.id.textView3);
    }

    public void button1_OnClick(View view){
        SharedPreferences sharedPref = getSharedPreferences("kullanici", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("kad", editText1.getText().toString());
        editor.putString("sifre", editText2.getText().toString());
        editor.apply();

        Toast.makeText(this, "Kaydedildi.", Toast.LENGTH_LONG).show();
    }

    public void button2_OnClick(View view){
        SharedPreferences sharedPref = getSharedPreferences("kullanici", Context.MODE_PRIVATE);
        String kad = sharedPref.getString("kad",""); // ikinci değer, ilk değer yoksa varsayılan değeri ifade eder.
        String sifre = sharedPref.getString("sifre","");
        textView3.setText(kad + " " + sifre);
    }
}
