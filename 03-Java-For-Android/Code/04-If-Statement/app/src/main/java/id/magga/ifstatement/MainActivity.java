package id.magga.ifstatement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ButtonClicked(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        TextView textView = (TextView) findViewById(R.id.textView);

        int angka1 = Integer.parseInt(editText.getText().toString());
        int angka2 = Integer.parseInt(editText2.getText().toString());

        if (angka1 > angka2){
            textView.setText("Angka 1 lebih besar dari Angka 2");
        } else if (angka2 < angka1){
            textView.setText("Angka 2 lebih besar dari Angka 1");
        } else {
            textView.setText("Kedua angka sama besar");
        }

        // Another Relational Operators :
        // <= : Less than equal
        // >= : Greater than equal
        // == : Equal to
        // != : Not equal to
    }

}
