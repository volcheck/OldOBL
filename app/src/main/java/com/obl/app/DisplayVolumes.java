package com.obl.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import java.util.Formatter;

import static java.lang.Math.exp;
import static java.lang.Math.log;
import static java.lang.Math.pow;


public class DisplayVolumes extends ActionBarActivity {
    double ock, ocp, bodyweight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_volumes);
        double Surface, NpregBloodV, NPregPlasV, NPregErV, PregBloodV, PregPlasV, PregErV, Bleasure, Pleasure, Percent, BloodLeasure;
        int zeroweight, height, weight, weekgest, age;
        Intent dispvol = getIntent();
        zeroweight = dispvol.getIntExtra("zeroweight", 0);
        height = dispvol.getIntExtra("height",0);
        weight = dispvol.getIntExtra("weight", 0);
        bodyweight = weight;
        weekgest = dispvol.getIntExtra("weekgest", 0);
        age = dispvol.getIntExtra("age", 0);
        NpregBloodV = 0;
        NPregPlasV = 0;
        PregBloodV = 0;
        PregPlasV = 0;
        PregErV = 0;
        //Toast.makeText(this, Double.toString(dblheight),
        //        Toast.LENGTH_LONG).show();
        Surface = (Math.pow((zeroweight / 1000), 0.425)) * (Math.pow((height), 0.725)) * 0.007184;
        Formatter SurfaceToPrint = new Formatter();
        SurfaceToPrint.format("%.3f", Surface);
        TextView testext = (TextView)findViewById(R.id.testext);
        testext.setText(getString(R.string.bsa)  + " " + SurfaceToPrint.toString() + " " + getString(R.string.sqm) + "\n\n");
        SurfaceToPrint.close();
        NpregBloodV = Surface * 2370;
        if (age < 19) {NpregBloodV = 1.1 * Surface * 2370;}
        if (age > 70) {NpregBloodV = 0.9 * Surface * 2370;}
        Formatter BloodVolToPrint = new Formatter();
        BloodVolToPrint.format("%.0f", NpregBloodV);
        testext.setText(testext.getText() + getString(R.string.nonpreg) + "\n" + getString(R.string.wholebloodvol) + " " +  BloodVolToPrint.toString() + " " + getString(R.string.mls) + "\n");
        BloodVolToPrint.close();
        NPregPlasV = Surface * 1470;
        if (age < 19) {NPregPlasV = 1.1 * Surface * 1470;}
        if (age > 70) {NPregPlasV = 0.9 * Surface * 1470;}
        Formatter PlasVolToPrint = new Formatter();
        PlasVolToPrint.format("%.0f", NPregPlasV);
        testext.setText(testext.getText() + getString(R.string.plasmavol) + " " +  PlasVolToPrint.toString() + " " + getString(R.string.mls) + "\n");
        PlasVolToPrint.close();
        NPregErV = (NpregBloodV - NPregPlasV)/0.95;
        Formatter EryVolToPrint = new Formatter();
        EryVolToPrint.format("%.0f", NPregErV);
        testext.setText(testext.getText() + getString(R.string.eryvol) + " " +  EryVolToPrint.toString() + " " + getString(R.string.mls) + "\n\n");
        EryVolToPrint.close();
        if (weekgest > 0) {
            if (weekgest > 10) {
                PregBloodV = NpregBloodV * 1.12;
                PregPlasV = NPregPlasV * 1.09;
                PregErV = NPregErV * 1.03;
            }
            if (weekgest > 20) {
                PregBloodV = NpregBloodV * 1.26;
                PregPlasV = NPregPlasV * 1.2;
                PregErV = NPregErV * 1.1;
            }
            if (weekgest > 10) {
                PregBloodV = NpregBloodV * 1.33;
                PregPlasV = NPregPlasV * 1.27;
                PregErV = NPregErV * 1.14;
            }
            if (weekgest > 10) {
                PregBloodV = NpregBloodV * 1.4;
                PregPlasV = NPregPlasV * 1.3;
                PregErV = NPregErV * 1.15;
            }
            else {
                PregBloodV = NpregBloodV;
                PregPlasV = NPregPlasV;
                PregErV = NPregErV;
            }
        }
        Formatter PregVolToPrint = new Formatter();
        PregVolToPrint.format("%.0f", PregBloodV);
        testext.setText(testext.getText() + getString(R.string.preg) + " " + weekgest + " " + getString(R.string.weeks) +  "\n" + getString(R.string.wholebloodvol) + " " +  PregVolToPrint.toString() + " " + getString(R.string.mls) + "\n");
        PregVolToPrint.close();
        Formatter PPlasVolToPrint = new Formatter();
        PPlasVolToPrint.format("%.0f", PregPlasV);
        testext.setText(testext.getText() + getString(R.string.plasmavol) + " " +  PPlasVolToPrint.toString() + " " + getString(R.string.mls) + "\n");
        PPlasVolToPrint.close();
        Formatter PEryVolToPrint = new Formatter();
        PEryVolToPrint.format("%.0f", PregErV);
        testext.setText(testext.getText() + getString(R.string.eryvol) + " " +  PEryVolToPrint.toString() + " " + getString(R.string.mls) + "\n\n");
        PEryVolToPrint.close();
        ock = PregBloodV;
        ocp = PregPlasV;
        //Toast.makeText(this, Double.toString(ock),
        //       Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.display_volumes, menu);
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

    public void losscount(View view) {
        double blost, percentock, percentocp, percentbodyweight, hbbefore, hbafter;
        EditText editText = (EditText)findViewById(R.id.editText);
        hbafter = Double.parseDouble(editText.getText().toString());
        EditText editText2 = (EditText)findViewById(R.id.editText2);
        hbbefore = Double.parseDouble(editText2.getText().toString());
        blost = ock * ((hbbefore - hbafter) / hbbefore);
        percentock = 100 * ((hbbefore - hbafter) / hbbefore);
        percentocp = 100 * (blost/ocp);
        percentbodyweight = 100 * (blost / bodyweight);
        Intent bloodloss = new Intent(this, bloodloss.class);
        bloodloss.putExtra("blost", blost);
        bloodloss.putExtra("pcock", percentock);
        bloodloss.putExtra("pcocp", percentocp);
        bloodloss.putExtra("pcweight", percentbodyweight);
        startActivity(bloodloss);
//       Toast.makeText(this, Double.toString(hbbbefore),
//            Toast.LENGTH_LONG).show();
    }
}
