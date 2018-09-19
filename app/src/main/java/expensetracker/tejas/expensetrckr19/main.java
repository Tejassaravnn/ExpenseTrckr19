package expensetracker.tejas.expensetrckr19;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class main extends AppCompatActivity {

    private GridLayout mlayout;
    // static int count=0;
    private static final String FILE_NAME="sure.txt";
    Button btn;
    dviews in;
    EditText edt;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mlayout=(GridLayout)findViewById(R.id.mylayout);
        btn=(Button)findViewById(R.id.btn);
        edt=(EditText)findViewById(R.id.edt);
        //String str=edt.getText().toString();

        load();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in = new dviews(context);
                String str = edt.getText().toString();

                mlayout.addView(in.dtv(getApplicationContext(), str),1);
                try{
                    str=str+"\n";
                    FileOutputStream fos=openFileOutput(FILE_NAME,Context.MODE_APPEND);
                    OutputStreamWriter myOutWriter = new OutputStreamWriter(fos);
                    fos.write(str.getBytes());
                    // myOutWriter.append(str);
                    //myOutWriter.append("\n");
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
       /* in.edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlayout.addView(in.price(getApplicationContext()),1);
            }
        });*/
        load();
    }
    private void load()
    {
        FileInputStream fis=null;
        int count=0;
        try {
            in=new dviews(context);
            fis=openFileInput(FILE_NAME);
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            // mlayout=(GridLayout)findViewById(R.id.mylayout);
            // StringBuilder sb=new StringBuilder();
            String text;
            String str;

            while((text=br.readLine())!=null)
            {
                str=text;
                mlayout.addView(in.dtv(getApplicationContext(),str),1);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }}
        
   /* public Button ab(Context context)
    {
        final ViewGroup.LayoutParams lparams= new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        Button bt=new Button (context);
        bt.setText(" ADD ");
        bt.setTextColor(Color.rgb(0,0,0));
        bt.setMinEms(2);
        //bt.setInputType(InputType.TYPE_CLASS_NUMBER);
        return bt;
    }*/
}