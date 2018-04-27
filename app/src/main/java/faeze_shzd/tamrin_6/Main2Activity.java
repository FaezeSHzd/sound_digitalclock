package faeze_shzd.tamrin_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
   /* public void MyClock (View view){

        Intent intent=new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent);
    }*/
    private RadioGroup RG1;
    private RadioButton RB1,RB2;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);




        RG1=(RadioGroup)findViewById(R.id.RG_1);
        RB1=(RadioButton)findViewById(R.id.RB_1);
        RB2=(RadioButton)findViewById(R.id.RB_2);

        btn1 =(Button)findViewById(R.id.btn_1);


       RG1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selected = RG1.getCheckedRadioButtonId();
                RB1 = (RadioButton) findViewById(selected);


            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);


                startActivityForResult(intent);


            }

            private void startActivityForResult(Intent intent) {
                intent.getExtras();

                int[] sounds = {R.raw.d_four_o,R.raw.o_fifteen_o,R.raw.b_two,R.raw.z_daghighe,0};
                int loc = 0;

            }
        });


    }
}
