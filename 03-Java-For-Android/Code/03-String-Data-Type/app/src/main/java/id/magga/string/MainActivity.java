package id.magga.string;

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

        // String is a text value that contains any alphabet
        // It have to be wrapped in the double quote " "
        // That means a number that wrapped in a double quote is not a number
        // It is indeed a string
        int angka = 34;
        String kata = "34";

        // You can concatenate 2 or more strings
        // You can do that using + sign
        String firstName = "David";
        String lastName = "Beckham";

        String fullName = "David" + " " + "Beckham"; // It should display "David Beckham"

        // Any number can be casted to String using .toString() method
        String fullAge = fullName + " is " + Integer.toString(angka) + " years old";

        textView.setText(fullAge);

        // You can get any property of string by accessing it's method
        fullAge.length();  // Get the total number of alphanumeric of the string
        fullAge.toLowerCase(); // Make the string all lowercase
        //etc
    }
}
