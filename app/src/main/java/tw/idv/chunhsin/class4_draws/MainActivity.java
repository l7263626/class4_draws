package tw.idv.chunhsin.class4_draws;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CancellationException;

public class MainActivity extends AppCompatActivity {
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //MyView myView = new MyView(this);
        //setContentView(myView);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        findviews();
    }

    void findviews(){
        image=(ImageView)findViewById(R.id.imageView);
        /*
        image.setImageResource(R.drawable.brunch);
        */
        //Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.brunch);
        //image.setImageBitmap(bmp);

        /*
        AssetManager assetManager = getAssets();
        try {
            InputStream is = assetManager.open("brunch.jpg");
            Drawable drawable = Drawable.createFromStream(is,null);
            image.setImageDrawable(drawable);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view){
        //drawSomthing();
        Bitmap bmp = Bitmap.createBitmap(image.getWidth(),image.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);

        int lt=10;
        int rb=310;
        int j=0;
        //for(int j=1;j<=5;j++){
        while(lt<((rb-lt)/2)){
            lt+=10;
            rb-=10;
            RectF rectF = new RectF(lt+(j)*10,lt+(j)*10,rb-(j)*10,rb-(j)*10);
            canvas.drawOval(rectF,paint);
            j++;
        }
        image.setImageBitmap(bmp);

    }

    void drawSomthing(){
        Paint paintBlue=new Paint();
        paintBlue.setAntiAlias(true);
        paintBlue.setColor(Color.BLUE);
        paintBlue.setStrokeWidth(2.0f);
        paintBlue.setStyle(Paint.Style.STROKE);

        Paint paintGreen=new Paint();
        paintGreen.setAntiAlias(true);
        paintGreen.setColor(Color.GREEN);
        paintGreen.setStyle(Paint.Style.FILL);
        paintGreen.setStrokeWidth(2.0f);

        Paint paintRed=new Paint();
        paintRed.setAntiAlias(true);
        paintRed.setColor(Color.RED);
        paintRed.setStyle(Paint.Style.FILL);
        paintRed.setStrokeWidth(2.0f);

        /*
        Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.tower2);
        bmp=bmp.copy(Bitmap.Config.ARGB_8888,true);
        */

        Bitmap bmp = Bitmap.createBitmap(image.getWidth(),image.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bmp);

        canvas.drawColor(0xFF000000);
        //=======drawText============
        canvas.drawLine(20,200,400,200,paintGreen);
        String text="Draw the specified Rect using the specified Paint.";
        canvas.drawText(text,0,text.length(),20,200,paintBlue);

        //========drawTextOnPath
        Path path=new Path();
        path.addCircle(200, 400, 100, Path.Direction.CW);
        canvas.drawCircle(200, 400, 100, paintBlue);
        canvas.drawTextOnPath(text, path, 0, 20, paintRed);

        image.setImageBitmap(bmp);
    }
}
