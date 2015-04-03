package com.obl.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Formatter;


public class bloodloss extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodloss);
        double bloodlost, pcentock, pcentocp, pcentweight;
        Intent bloodloss = getIntent();
        bloodlost = bloodloss.getDoubleExtra("blost", 0);
        //Toast.makeText(this, Double.toString(bloodlost),
        //        Toast.LENGTH_LONG).show();
        pcentock = bloodloss.getDoubleExtra("pcock", 0);
        pcentocp = bloodloss.getDoubleExtra("pcocp", 0);
        pcentweight = bloodloss.getDoubleExtra("pcweight", 0);
        TextView output = (TextView)findViewById(R.id.output);
        Formatter blostToPrint = new Formatter();
        blostToPrint.format("%.0f", bloodlost);
        output.setText(getString(R.string.blosscounted) + " " + blostToPrint.toString() + " " + getString(R.string.mls) + "\n\n");
        blostToPrint.close();
        Formatter pcockToPrint = new Formatter();
        pcockToPrint.format("%.3f", pcentock);
        output.setText(output.getText() + getString(R.string.thatis) + " " + pcockToPrint.toString() + getString(R.string.ofbloodvolume));
        pcockToPrint.close();
        Formatter pcocpToPrint = new Formatter();
        pcocpToPrint.format("%.3f", pcentocp);
        output.setText(output.getText() + " " + pcocpToPrint.toString() + getString(R.string.ofplasmavolume));
        pcocpToPrint.close();
        Formatter pcwghtToPrint = new Formatter();
        pcwghtToPrint.format("%.3f", pcentweight);
        output.setText(output.getText() + " " + pcwghtToPrint.toString() + getString(R.string.ofbobyweight));
        pcwghtToPrint.close();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bloodloss, menu);
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

}
