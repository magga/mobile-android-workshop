package id.magga.section2solution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SayHello(View view){
        EditText etNama = (EditText) findViewById(R.id.etNama);
        TextView tvNama = (TextView) findViewById(R.id.tvNama);

        tvNama.setText("Hello " + etNama.getText().toString());
    }

    public void Exit(){
        finish();
    }
}
