package id.magga.part2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void ButtonClicked(View view){
        EditText etNama = (EditText) findViewById(R.id.etNama);

        Toast.makeText(this, etNama.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
