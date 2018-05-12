package e.jiwon.lab4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout page = null;
    Button button = null;

    Animation translateLeft = null;
    Animation translateRight = null;

    boolean isPageState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page = (LinearLayout)findViewById(R.id.page);
        translateLeft = AnimationUtils.loadAnimation(this,R.anim.translate_left);
        translateRight = AnimationUtils.loadAnimation(this, R.anim.translate_right);

        SlidingAnimationListener listener = new SlidingAnimationListener();
        translateLeft.setAnimationListener(listener);
        translateRight.setAnimationListener(listener);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(isPageState) {
                    page.startAnimation(translateRight);
                }
                else {
                    page.setVisibility(View.VISIBLE);
                    page.startAnimation(translateLeft);
                }
            }
        });
    }
        class SlidingAnimationListener implements Animation.AnimationListener {
            public void onAnimationStart(Animation anim) {

            }

            public void onAnimationEnd(Animation anim) {
                if(isPageState) {
                    page.setVisibility(View.INVISIBLE);
                    button.setText("Open page");
                    isPageState = false;
                }
                else {
                    button.setText("Close page");
                    isPageState = true;
                }
            }

            public void onAnimationRepeat(Animation anim) {

            }
        }
}
