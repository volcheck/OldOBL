package com.obl.app;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import static android.widget.Toast.*;


public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void volcount(View view)
    {   int zeroweight, weight, height, weekgest, age;
        EditText editText = (EditText)findViewById(R.id.editText);
        zeroweight = Integer.parseInt(editText.getText().toString());
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        height = Integer.parseInt(editText3.getText().toString());
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        weight = Integer.parseInt(editText2.getText().toString());
        EditText editText4 = (EditText) findViewById(R.id.editText4);
        weekgest = Integer.parseInt(editText4.getText().toString());
        EditText editText5 = (EditText) findViewById(R.id.editText5);
        age = Integer.parseInt(editText5.getText().toString());
        /*Toast.makeText(this, editText.getText().toString(),
                Toast.LENGTH_LONG).show();*/
        Intent dispvol = new Intent(this, DisplayVolumes.class);
        dispvol.putExtra("zeroweight", zeroweight);
        dispvol.putExtra("height", height);
        dispvol.putExtra("weight", weight);
        dispvol.putExtra("weekgest", weekgest);
        dispvol.putExtra("age", age);
        startActivity(dispvol);

    }

/*    public void exitapp(MenuItem item) {
        finish();
    }*/
}

