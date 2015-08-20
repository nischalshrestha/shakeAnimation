package com.bitsorific.shakeanimation.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bitsorific.shakeanimation.R;
import com.bitsorific.shakeanimation.shaker.Shaker;


public class MainActivity extends AppCompatActivity {

    private static final Integer GREY = Color.parseColor("#D2D2D2");
    private EditText textInput;
    private Button shakeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shakeButton = (Button) findViewById(R.id.shakeButton);
        textInput = (EditText) findViewById(R.id.editText);

        //Shake and pulse red
        shakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shaker shake = new Shaker(textInput, -15, 15, GREY, Color.RED);
                shake.shake();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent com.bitsorific.shakeanimation.activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
