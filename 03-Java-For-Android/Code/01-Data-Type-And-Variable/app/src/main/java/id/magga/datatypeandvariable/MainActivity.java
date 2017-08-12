package id.magga.datatypeandvariable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

// In Programming, Variables are used to store values
// Values may be a numbers, text, or other types of data
// Variables are like a containers which hold a value
// They could be used to store air temperature, age, your name, etc
// To use a variable, it must be declared
// To declare a variable, you only need to specify the data type of the variable

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SayHello(View view){
        EditText etNama = (EditText) findViewById(R.id.etNama);
        TextView tvNama = (TextView) findViewById(R.id.tvNama);

        // The name is one of the most important part of variable
        // You have to give it a meaningful name there
        String nama = etNama.getText().toString();

        // Variable's name are case sensitive
        // Variable's name have to begin with a letter, an underscore, or a dollar sign
        // No spaces or special characters allowed
        // You can't use a java keyword (reserved word) such as "void"
        String helloNama = "Hello " + nama;

        // you can't enter a fractional number into an "int" variable
        int umur = 24;

        String helloNamaUmur = helloNama + ", umur kamu " + Integer.toString(umur) + " tahun";

        tvNama.setText(helloNamaUmur);
    }

    public void Exit(){
        finish();
    }
}
