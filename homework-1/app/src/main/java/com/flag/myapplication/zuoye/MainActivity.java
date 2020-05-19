package com.flag.myapplication.zuoye;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioButton yes= findViewById(R.id.yes);
        RadioButton no= findViewById(R.id.no);
        yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("cs","RadioButton=="+isChecked);
            }
        });
        no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("cs","RadioButton=="+isChecked);
            }
        });
        Button button= findViewById(R.id.button);
        final EditText editText= findViewById(R.id.edtext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("cs","EditText=="+editText.getText()+"");
            }
        });
        final ImageView imageView=findViewById(R.id.image);
        findViewById(R.id.yc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);
                Log.d("cs","显示图案");

            }
        });
        findViewById(R.id.xs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.GONE);
                Log.d("cs","隐藏图案");

            }
        });


    }
}
