package expensetracker.tejas.expensetrckr19;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class pop extends AppCompatActivity {

    Button btn;
    EditText edt;
    private static final String FILE_NAME="amt.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        btn=(Button)findViewById(R.id.btn);
        edt=(EditText)findViewById(R.id.edt);
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width=dm.widthPixels;
        int height=dm.heightPixels;
        getWindow().setLayout((int)(width*0.8),(int)(height*0.6));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=edt.getText().toString();
                try{
                    FileOutputStream fos=openFileOutput(FILE_NAME, Context.MODE_APPEND);
                    fos.write(str.getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent i=new Intent(pop.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
