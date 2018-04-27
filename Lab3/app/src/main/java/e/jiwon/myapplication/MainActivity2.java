package e.jiwon.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText editText;
    RadioGroup group;
    RadioButton male;
    RadioButton female;
    CheckBox sms;
    CheckBox email;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText = (EditText)findViewById(R.id.edit);
        group = (RadioGroup)findViewById(R.id.radioGroup);
        male = (RadioButton)findViewById(R.id.male);
        female = (RadioButton)findViewById(R.id.female);
        sms = (CheckBox)findViewById(R.id.chkSMS);
        email = (CheckBox)findViewById(R.id.chkEmail);
        register = (Button)findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewActivity2.class);
                String gender = "";
                String receive = "";
                String name = "";

                int radioId = group.getCheckedRadioButtonId();

                if(male.getId() == radioId) gender = male.getText().toString();
                if(female.getId() == radioId) gender = female.getText().toString();

                if(sms.isChecked()) receive += " " + sms.getText().toString();
                if(email.isChecked()) receive += " " +email.getText().toString();

                name = editText.getText().toString();

                if(name.equals("")) Toast.makeText(getApplicationContext(), "please correct your name.", Toast.LENGTH_LONG);

                intent.putExtra("gender", gender);
                intent.putExtra("receive", receive);
                intent.putExtra("name", editText.getText().toString());

                startActivity(intent);
            }
        });



    }
}
