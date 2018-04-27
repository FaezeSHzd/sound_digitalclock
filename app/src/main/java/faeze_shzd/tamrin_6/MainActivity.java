package faeze_shzd.tamrin_6;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener  {


  private EditText ET1 , ET3 ,ET5;


    private ImageButton IB1;
    private ImageButton IB0;

    private int[] sounds = {R.raw.d_four_o,R.raw.o_fifteen_o,R.raw.b_two,R.raw.z_daghighe,0};
    private int loc = 0;

    int[] sounds1 ={
            0,
            R.raw.a_one,
            R.raw.b_two,
            R.raw.c_three,
            R.raw.d_four,
            R.raw.e_five,
            R.raw.f_six,
            R.raw.g_seven,
            R.raw.h_eight,
            R.raw.i_nine,
            R.raw.j_ten,
            R.raw.k_eleven,
            R.raw.l_twelve,
            R.raw.m_thirteen,
            R.raw.n_fourteen,
            R.raw.o_fifteen,
            R.raw.p_sixteen,
            R.raw.q_seventeen,
            R.raw.r_eighteen,
            R.raw.s_nineteen,
            R.raw.t_twenty,

    };

    int[] sounds10 ={
            0,
            R.raw.j_ten,
            R.raw.t_twenty,
            R.raw.t_twenty_o,
            R.raw.u_thirty,
            R.raw.u_thirty_o,
            R.raw.v_fourty,
            R.raw.v_fourty_o,
            R.raw.w_fifty,
            R.raw.w_fifty_o,

    };

    int[] sounds10O ={
            0,
            R.raw.j_ten_o,
            R.raw.t_twenty_o,
            R.raw.u_thirty_o,
            R.raw.v_fourty_o,
            R.raw.w_fifty_o,

    };

///////--------------------------------------Main------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ET1 = (EditText) findViewById(R.id.Etxt_1);
        ET3 = (EditText) findViewById(R.id.Etxt_3);
        ET5 = (EditText) findViewById(R.id.Etxt_5);
        IB1 =(ImageButton)findViewById(R.id.imgbtn1);

        IB0 =(ImageButton)findViewById(R.id.imgbtn0);


        final Typeface d_n = Typeface.createFromAsset(getAssets(), "fonts/segment7.ttf");



    //    EditText editText1 = (EditText) findViewById(R.id.Etxt_1);
        ET1.setTypeface(d_n);

     //   EditText editText3 = (EditText) findViewById(R.id.Etxt_3);
        ET3.setTypeface(d_n);

    //   EditText editText5 = (EditText) findViewById(R.id.Etxt_5);
        ET5.setTypeface(d_n);

//---------------------------------------------------------activity2---------------
        IB0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);

            }



            Intent intent=getIntent();



          /*  new Intent();

            setResult();
            finish();*/

        });



//---------------------------------clock------------------------

        IB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date=new Date();
                int H=date.getHours();
                int M = date.getMinutes();
                int S = date.getSeconds();
                String hs=String.format("%02d",H);
                String ms=String.format("%02d",M);
                ET1.setText(hs);
                //  ET2.setText(" : ");
                ET3.setText(ms);
                //ET4.setText( " : ");
                ET5.setText(S + " ");

                if(H==0)
                    H=12;
                else if(H>12)
                    H-=12;
                int i=0;
                sounds[i++]= M==0 ? sounds1[H]: sounds10[H];

                if (M <20)
                    sounds[i+1]=sounds1[M];
                else {
                    int M10=M/10;
                    int M1=M%10;
                    sounds[i++]= M1==0 ? sounds10[M10]:sounds10O[M10];
                    if(M1!=0)
                        sounds[i++]=sounds[M1];

                }

                sounds[i++]=0;


                EditText editText1 = (EditText) findViewById(R.id.Etxt_1);
                editText1.setTypeface(d_n);

                EditText editText3 = (EditText) findViewById(R.id.Etxt_3);
                editText3.setTypeface(d_n);

                EditText editText5 = (EditText) findViewById(R.id.Etxt_5);
                editText5.setTypeface(d_n);



                TextView tv_6 = (TextView) findViewById(R.id.TV_6);
                tv_6.setTypeface(d_n);


                TextView tv_8 = (TextView) findViewById(R.id.TV_8);
                tv_8.setTypeface(d_n);


                TextView tv_10 = (TextView) findViewById(R.id.TV_10);
                tv_10.setTypeface(d_n);


                MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.z_saat);
                mp.setOnCompletionListener(MainActivity.this);
            }
        });

    }

    @Override
    public void onCompletion(MediaPlayer mp) {

        if(sounds[loc] !=0) {
            MediaPlayer m = MediaPlayer.create(this, sounds[loc]);
            loc++;
            m.setOnCompletionListener(this);
            mp.start();
        }

    }
}
