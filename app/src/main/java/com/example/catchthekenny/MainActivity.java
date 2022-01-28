package com.example.catchthekenny;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView textView1;
    int number;
    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView[] imageArrays;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView24);
        imageView1=findViewById(R.id.imageView32);
        imageView2=findViewById(R.id.imageView35);
        imageView3=findViewById(R.id.imageView33);
        imageView4=findViewById(R.id.imageView34);
        imageView5=findViewById(R.id.imageView29);
        imageView6=findViewById(R.id.imageView30);
        imageView7=findViewById(R.id.imageView31);
        imageView8=findViewById(R.id.imageView25);
        imageView9=findViewById(R.id.imageView26);
        imageView10=findViewById(R.id.imageView27);
        imageView11=findViewById(R.id.imageView28);
        imageArrays=new ImageView[]{imageView,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11};
        textView=findViewById(R.id.textView);
        textView1=findViewById(R.id.textView2);
        number=0;
        hideImages();
        new CountDownTimer(20000,1000){

            @Override
            public void onTick(long l) {
                textView.setText("Time:" + l/1000);

            }

            @Override
            public void onFinish() {
                handler.removeCallbacks(runnable);
                for (ImageView image:imageArrays){
                    image.setVisibility(View.INVISIBLE);
                }
                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Finish!!");
                alert.setMessage("Play Again");
                alert.setPositiveButton("Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=getIntent();
                        finish();
                        startActivity(intent);


                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Game Over", Toast.LENGTH_SHORT).show();

                    }
                });
                alert.show();





            }
        }.start();
    }

    public void image1(View view){
        number++;
        textView1.setText("Score :" + number);

    }
    public void hideImages(){
        handler=new Handler(Looper.getMainLooper());

        runnable=new Runnable() {
            @Override
            public void run() {
                for (ImageView image:imageArrays){
                image.setVisibility(View.INVISIBLE);
            }
                Random random =new Random();
                int i=random.nextInt(12);
                imageArrays[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500);



            }
        };
        handler.post(runnable);


    }
}