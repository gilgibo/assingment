package com.example.gibo.assing3;

import android.content.ClipData;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.gibo.assing3.R.drawable.chicken;

public class MainActivity extends AppCompatActivity {

    boolean rot, tit , mag;
    String pic = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.ass1, menu);

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if(rot){
            menu.findItem(R.id.rotation).setChecked(true);
        }
        else{
            menu.findItem(R.id.rotation).setChecked(false);
        }
        if(tit){
            menu.findItem(R.id.title).setChecked(true);
        }
        else{
            menu.findItem(R.id.title).setChecked(false);
        }
        if(mag){
            menu.findItem(R.id.magnification).setChecked(true);
        }
        else{
            menu.findItem(R.id.magnification).setChecked(false);
        }
        if(pic.equals("chicken")){
            menu.findItem(R.id.menu5).setChecked(true);
        }
        if(pic.equals("spagetti")){
            menu.findItem(R.id.menu6).setChecked(true);
        }
        return  true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        LinearLayout llo1 = (LinearLayout)findViewById(R.id.llo1);
        ImageView iv1 = (ImageView)findViewById(R.id.imageView);
        TextView tv1 = (TextView)findViewById(R.id.textView);

        switch (item.getItemId()){
            case R.id.red :
                llo1.setBackgroundColor(Color.RED);
                return true;
            case R.id.blue :
                llo1.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.yellow :
                llo1.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.rotation :
                if(rot){
                    if(pic.equals("chicken")){
                        iv1.setBackgroundResource(0);
                        iv1.setImageBitmap(rotateImage(
                                BitmapFactory.decodeResource(getResources(),R.drawable.chicken),0));
                    } else if(pic.equals("spagetti")){
                        iv1.setBackgroundResource(0);
                        iv1.setImageBitmap(rotateImage(
                                BitmapFactory.decodeResource(getResources(),R.drawable.spagetti),0));
                    }
                    rot = false;
                } else{
                    if(pic.equals("chicken")){
                        iv1.setBackgroundResource(0);
                        iv1.setImageBitmap(rotateImage(
                                BitmapFactory.decodeResource(getResources(),R.drawable.chicken),30));
                    } else if(pic.equals("spagetti")){
                        iv1.setBackgroundResource(0);
                        iv1.setImageBitmap(rotateImage(
                                BitmapFactory.decodeResource(getResources(),R.drawable.spagetti),30));
                    }
                    rot = true;
                }
                return true;
            case R.id.title :
                if(tit){
                    tit = false;
                    tv1.setVisibility(View.INVISIBLE);
                } else{
                    tit = true;
                    tv1.setVisibility(View.VISIBLE);
                }
                return true;
            case  R.id.magnification :
                if(mag){
                    sizecontrol(1,1);
                    iv1.setScaleX(1);
                    iv1.setScaleY(1);
                    mag = false;
                } else {
                    sizecontrol(2,2);
                    iv1.setScaleX(2);
                    iv1.setScaleY(2);
                    mag = true;
                }
                return  true;
            case R.id.menu5 :
                pic = "chicken";
                iv1.setBackgroundResource(0);
                iv1.setBackgroundResource(R.drawable.chicken);
                tv1.setText("치킨");
                return true;
            case R.id.menu6 :
                pic = "spagetti";
                iv1.setBackgroundResource(0);
                iv1.setBackgroundResource(R.drawable.spagetti);
                tv1.setText("스파게티");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public Bitmap rotateImage(Bitmap src, float degree) {

        Matrix matrix = new Matrix();

        matrix.postRotate(degree);


        return Bitmap.createBitmap(src, 0, 0, src.getWidth(),
                src.getHeight(), matrix, true);
    }

    public  Matrix sizecontrol(float x, float y){
        ImageView iv1 = (ImageView)findViewById(R.id.imageView);

        float size_x = iv1.getScaleX() * x;
        float size_y = iv1.getScaleY() * y;

        Matrix matrix = new Matrix();

        matrix.setScale(size_x,size_y);

        return matrix;
    }

}
