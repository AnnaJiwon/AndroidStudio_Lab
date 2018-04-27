package e.jiwon.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    public Button btn_frag1;
    public Button btn_frag2;

    public Fragment1 firFragment;
    public Fragment2 secFragment;
    public TextView fragment_text1;
    public TextView fragment_text2;
    public ImageView fragment_image1;
    public ImageView fragment_image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();

        setListener();
    }

    public void init() {
        btn_frag1 = (Button)findViewById(R.id.btn_frag1);
        btn_frag2 = (Button)findViewById(R.id.btn_frag2);
        fragment_image1 = (ImageView)findViewById(R.id.fragment_image1);
        fragment_image2 = (ImageView)findViewById(R.id.fragment_image2);
        fragment_text1 = (TextView)findViewById(R.id.fragment_text1);
        fragment_text2 = (TextView)findViewById(R.id.fragment_text2);

        firFragment = new Fragment1();
        secFragment = new Fragment2();
    }

    private void setListener() {
        btn_frag1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_for_fragment, firFragment).commit();
                fragment_image1.setVisibility(View.VISIBLE);
                fragment_text1.setVisibility(View.VISIBLE);
                fragment_image2.setVisibility(View.INVISIBLE);
                fragment_text2.setVisibility(View.INVISIBLE);
            }
        });

        btn_frag2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_for_fragment, secFragment).commit();
                fragment_image1.setVisibility(View.INVISIBLE);
                fragment_text1.setVisibility(View.INVISIBLE);
                fragment_image2.setVisibility(View.VISIBLE);
                fragment_text2.setVisibility(View.VISIBLE);
            }
        });
    }
}
