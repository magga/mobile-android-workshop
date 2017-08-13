package id.magga.myemployeedatabase;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailEmployeeActivity extends AppCompatActivity {

    TextView tvKeterangan;
    ImageView imageView;

    String telepon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_employee);

        InitializeView();

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Employee");
        query.fromLocalDatastore();
        query.whereEqualTo("id", id);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e == null){
                    ParseObject employee = objects.get(0);

                    tvKeterangan.setText("");

                    tvKeterangan.append("ID : " + "\n");
                    tvKeterangan.append(employee.getString("id") + "\n\n");

                    tvKeterangan.append("Nama : " + "\n");
                    tvKeterangan.append(employee.getString("nama") + "\n\n");

                    tvKeterangan.append("Tanggal Lahir : " + "\n");
                    tvKeterangan.append(employee.getString("tanggalLahir") + "\n\n");

                    tvKeterangan.append("Jenis Kelamin : " + "\n");
                    tvKeterangan.append(employee.getString("jenisKelamin") + "\n\n");

                    tvKeterangan.append("Sudah Menikah : " + "\n");
                    tvKeterangan.append(employee.getBoolean("menikah") + "\n\n");

                    tvKeterangan.append("Telepon : " + "\n");
                    telepon = employee.getString("telepon");
                    tvKeterangan.append(telepon + "\n\n");

                    Picasso.with(getApplicationContext()).load(employee.getString("foto")).into(imageView);


                } else {
                    Toast.makeText(DetailEmployeeActivity.this, "ERROR : " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void InitializeView() {
        tvKeterangan = (TextView) findViewById(R.id.tvKeterangan);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void Telepon(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + telepon));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}
