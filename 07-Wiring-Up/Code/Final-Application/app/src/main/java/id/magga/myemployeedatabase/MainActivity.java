package id.magga.myemployeedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity {

    EditText etID;
    EditText etNama;
    EditText etTanggalLahir;
    RadioGroup rgJenisKelamin;
    CheckBox cbMenikah;
    EditText etFoto;
    EditText etTelepon;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializeView();

        InitializeParse();
    }

    private void InitializeParse() {
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("9c344d161a974bb20f0cbb5e869a455e2bacb9ef")
                .server("http://ec2-52-14-11-143.us-east-2.compute.amazonaws.com:80/parse")
                .enableLocalDataStore()
                .build()
        );
    }

    private void InitializeView() {
        etID = (EditText) findViewById(R.id.etID);
        etNama = (EditText) findViewById(R.id.etNama);
        etTanggalLahir = (EditText) findViewById(R.id.etTanggalLahir);
        rgJenisKelamin = (RadioGroup) findViewById(R.id.rgJenisKelamin);
        cbMenikah = (CheckBox) findViewById(R.id.cbMenikah);
        etFoto = (EditText) findViewById(R.id.etFoto);
        etTelepon = (EditText) findViewById(R.id.etTelepon);
        btnAdd = (Button) findViewById(R.id.btnAdd);
    }

    public void Add(View view){
        ParseObject employee = new ParseObject("Employee");

        employee.put("id", etID.getText().toString());
        employee.put("nama", etNama.getText().toString());
        employee.put("tanggalLahir", etTanggalLahir.getText().toString());

        int radio = rgJenisKelamin.getCheckedRadioButtonId();
        if (radio == R.id.rbLakiLaki){
            employee.put("jenisKelamin", "Laki - Laki");
        } else {
            employee.put("jenisKelamin", "Perempuan");
        }

        employee.put("menikah", cbMenikah.isChecked());
        employee.put("foto", etFoto.getText().toString());
        employee.put("telepon", etTelepon.getText().toString());

        employee.pinInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null){
                    Toast.makeText(MainActivity.this, "BERHASIL", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "ERROR : " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.see_all){
            Intent intent = new Intent(getApplicationContext(), AllEmployeeActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}







