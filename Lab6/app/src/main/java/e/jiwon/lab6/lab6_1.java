package e.jiwon.lab6;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class lab6_1 extends AppCompatActivity {
    private EditText editText;
    private Button writeFile;
    private Button clear;
    private Button readFile;
    private Button finishApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6_1);

        editText = findViewById(R.id.txtData);
        writeFile = findViewById(R.id.writeSDFile);
        clear = findViewById(R.id.clearScreen);
        readFile = findViewById(R.id.readSDFile);
        finishApp = findViewById(R.id.finishApp);

        final String[] text = {""};
        writeFile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    FileWriter writer;
                    String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/App";
                    File dir = new File(dirPath);

                    if(!dir.exists()) {
                        dir.mkdirs();
                    }

                    File file = new File(dir + "/mysdFile.txt");
                    if(!file.exists())
                        file.mkdirs();
                    PrintWriter write = new PrintWriter(file);
                    write.print("");
                    write.close();

                    writer = new FileWriter(file, true);
                    writer.write(editText.getText().toString());
                    writer.flush();
                    writer.close();
                    Toast.makeText(getApplicationContext(), "Done writing SD 'mysdFile.txt'", Toast.LENGTH_SHORT).show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
        readFile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                File sdCard = Environment.getExternalStorageDirectory();
                File directory = new File(sdCard.getAbsolutePath() + "/App");
                directory.mkdirs();

                try {
                    File file = new File(directory, "myFile.txt");
                    FileInputStream fIn = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fIn);
                    int i = 0;
                    String text = "";
                    while((i = isr.read()) != -1) {
                        text += (char)i;
                    }
                    editText.setText(text);
                    Toast.makeText(getApplicationContext(), "Done reading SD 'mysdFile.txt'", Toast.LENGTH_SHORT).show();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        finishApp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
