package sg.edu.rp.c346.id22024848.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName, etGPA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.editTextName);
        etGPA=findViewById(R.id.editTextGPA);


    }

    @Override
    protected void onPause() {
        super.onPause();

        String strName=etName.getText().toString();
        Float StrGPA=Float.parseFloat(etGPA.getText().toString());
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("username", strName);
        prefEdit.putFloat("gpa", StrGPA );
        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs=getPreferences(MODE_PRIVATE);
        String msg=prefs.getString("username", "error");
        Float msg2=prefs.getFloat("gpa", 0);
        etName.setText(msg);
        etGPA.setText(msg2.toString());


    }
}