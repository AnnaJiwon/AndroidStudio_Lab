package e.jiwon.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity2 extends AppCompatActivity {
    TextView gender;
    TextView name;
    TextView receive;
    Button previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new2);

        gender = (TextView)findViewById(R.id.gender);
        name = (TextView)findViewById(R.id.name);
        receive = (TextView)findViewById(R.id.receive);
        previous = (Button)findViewById(R.id.previous);

        Intent intent = getIntent();

        gender.setText(intent.getStringExtra("gender"));
        name.setText(intent.getStringExtra("name"));
        receive.setText(intent.getStringExtra("receive"));

        previous.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });



    }
}
