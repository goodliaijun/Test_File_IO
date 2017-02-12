package cn.aijuntj.test_file_io;

import android.graphics.Color;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import cn.aijuntj.test_file_io.utility.File_IO;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private EditText editText;
    private TextView textView_hello;

    private Button button_could_read_and_write_SD;
    private TextView textView_could_read_and_write_SD;
    private String Dir_Name = "AJ_files";
    private String File_Name = "data.txt";
    private File rootPath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conponient_of_Activity_init();
        create_new_Dir();
        File dataFile = new File(rootPath,File_Name);

        try {
            FileOutputStream fileOutPut = new FileOutputStream(dataFile, true);
            String data = "This is the date by aijun.";
            fileOutPut.write(data.getBytes());
            fileOutPut.flush();
            fileOutPut.getFD().sync();
            fileOutPut.close();
            Toast.makeText(this, "Create " + rootPath + " "+ File_Name + " OK", Toast.LENGTH_LONG).show();

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }

    private void create_new_Dir() {
        rootPath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), Dir_Name);
        if(!rootPath.exists()){
            rootPath.mkdirs();
        }
    }

    private void conponient_of_Activity_init() {
        button = (Button)findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView2);
        button_could_read_and_write_SD = (Button)findViewById(R.id.button2);
        textView_could_read_and_write_SD = (TextView)findViewById(R.id.textView3);
        editText = (EditText)findViewById(R.id.editText);
        textView_hello = (TextView)findViewById(R.id.hello_textView);
    }
}
