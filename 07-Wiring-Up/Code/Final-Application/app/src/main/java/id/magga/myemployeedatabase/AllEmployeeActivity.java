package id.magga.myemployeedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class AllEmployeeActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_employee);

        listView = (ListView) findViewById(R.id.listView);

        final List<String> listID = new ArrayList<>();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Employee");

        query.fromLocalDatastore();
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e == null){
                    for(ParseObject obj : objects){
                        listID.add(obj.getString("id"));
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, listID);
                    listView.setAdapter(adapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getApplicationContext(), DetailEmployeeActivity.class);
                            intent.putExtra("id", listID.get(position));
                            startActivity(intent);
                        }
                    });
                } else {
                    Toast.makeText(AllEmployeeActivity.this, "ERROR : " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
