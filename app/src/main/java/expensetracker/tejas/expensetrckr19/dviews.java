package expensetracker.tejas.expensetrckr19;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class dviews {
    Context ctx;
    // private GridLayout g;
    Button edt;


    public dviews(Context ctx) {
        this.ctx = ctx;
    }
    public Button dtv(Context context, String str)
    {
        final ViewGroup.LayoutParams lparams= new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        final Button textView=new Button(context);
        textView.setLayoutParams(lparams);
        //textView.setTextSize(10);
        textView.setText(str);
        textView.setTextColor(Color.rgb(0,0,0));
        //textView.setMaxEms(8);
        return textView;
    }
    public Button sectext(Context context)
    {
        final ViewGroup.LayoutParams lparams= new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        edt=new Button(context);
        edt.setText("    ADD    ");
        int id=5;
        edt.setId(id);
        edt.setMinEms(2);
        edt.setTextColor(Color.rgb(0,0,0));
        edt.setInputType(InputType.TYPE_CLASS_NUMBER);
        return edt;
    }
    public EditText price(Context context)
    {
        final ViewGroup.LayoutParams lparams= new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final EditText textView=new EditText(context);
        textView.setTextColor(Color.rgb(0,0,0));
        textView.setLayoutParams(lparams);
        //textView.setText(str);
        return textView;
    }
    public void onClick(Button b)
    {
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ViewGroup.LayoutParams lparams= new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                final EditText textView=new EditText(ctx);
                textView.setTextColor(Color.rgb(0,0,0));
                textView.setLayoutParams(lparams);
            }
        });
    }
}

