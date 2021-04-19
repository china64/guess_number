package com.example.guess_int;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView point, history,guessed;
    private EditText maxrange, mixrange, enternum;
    private ImageView egg;
    private Button start1L, start2L;
    public int r,g,times;
    public String his="";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connet();
        getdata();
        startguess();
    }

    private void connet() {
        point = (TextView) findViewById(R.id.point);
        history = (TextView) findViewById(R.id.history);
        guessed=(TextView)findViewById(R.id.guessh);
        maxrange = (EditText) findViewById(R.id.maxrange);
        mixrange = (EditText) findViewById(R.id.mixrange);
        enternum = (EditText) findViewById(R.id.enternum);
        start1L = (Button) findViewById(R.id.start1);
        start2L = (Button) findViewById(R.id.start2);
        egg=(ImageView)findViewById(R.id.egg);
    }
    private void getdata(){
        start1L.setOnClickListener(start1);
    }

    private View.OnClickListener start1 = new View.OnClickListener() {
        public void onClick(View v) {
            String a=maxrange.getText().toString();
            String b=mixrange.getText().toString();
            int max=Integer.parseInt(a);
            int mix=Integer.parseInt(b);
            r=(int)(Math.random()*(max-mix+1))+mix;
            times=0;
            guessed.setText("");
            his="";
            point.setText("");
            start1L.setEnabled(false);
        }
    };
    private void startguess(){
        start2L.setOnClickListener(start2);
    }

    private View.OnClickListener start2 = new View.OnClickListener() {
        public void onClick(View v) {
            String gs=enternum.getText().toString();
            g=Integer.parseInt(gs);

                if(g>r){
                    point.setText(getResources().getString(R.string.big));
                    times++;
                    his=his+gs+" ";
                    guessed.setText(getResources().getString(R.string.guesshis)+his);
                    history.setText("已猜"+times+"次");
                }
                else if(g==r){
                    times++;
                    point.setText("猜到了!共猜"+times+"次");
                    his=his+gs+" ";
                    guessed.setText(getResources().getString(R.string.guesshis)+his);
                    history.setText("");
                    start1L.setEnabled(true);
                    start1L.setText(getResources().getString(R.string.again));
                }
                else if(g<r){
                    point.setText(getResources().getString(R.string.small));
                    times++;
                    his=his+gs+" ";
                    history.setText("已猜"+times+"次");
                    guessed.setText(getResources().getString(R.string.guesshis)+his);
                }
                if("0923".equals(gs)){
                    egg.setVisibility(View.VISIBLE);
                }
                else{
                    egg.setVisibility(View.INVISIBLE);
                }
            }

    };
}