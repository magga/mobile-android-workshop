package id.magga.floatingpointnumbers;

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

    public void ButtonClicked(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        TextView textView = (TextView) findViewById(R.id.textView);

        // Example of Floating Point Numbers are :
        // 3.14 , 0.007 , -100.10 , etc

        // Java has 2 primitives data type for Floating Point Numbers, that is :
        // Float - 4 bytes
        // Double - 8 bytes

        double r = 10.3;

        // Float number have to have an "f" behind it
        // If you don't add that, it'll give us an error
        // That's because it will be treated as a double number
        float pi = 3.14f;

        // You can cast any data type as you like
        // As long as it actually can be casted
        // But be careful if the data is incorrect, it'll break our app
        float number1 = Float.parseFloat(editText.getText().toString());
        float number2 = Float.parseFloat(editText2.getText().toString());

        // And then you can do an arithmetic operation
        float total = number1 + number2;

        textView.setText(Float.toString(total));
    }
}
