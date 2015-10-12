package tw.idv.chunhsin.class4_draws;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by student on 2015/10/12.
 */
public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);

        Paint paintBlue=new Paint();
        paintBlue.setAntiAlias(true);
        paintBlue.setColor(Color.BLUE);
        paintBlue.setStrokeWidth(2.0f);
        paintBlue.setStyle(Paint.Style.STROKE);
        //畫空心三角形
        float[] pts={100,5,50,55,50,55,150,55,150,55,100,5};
        canvas.drawLines(pts,paintBlue);

        //畫空心矩形
        canvas.drawRect(50,65,150,165,paintBlue);

        //畫空心扇形
        RectF rectF=new RectF(50,175,150,275);
        canvas.drawArc(rectF,0,90,true,paintBlue);
        canvas.drawArc(rectF,180,90,false,paintBlue);

        //畫空心圓形
        RectF rectF1=new RectF(50,285,150,385);
        canvas.drawOval(rectF1,paintBlue);


        //畫實心三角形
        Paint paintGreen=new Paint();
        paintGreen.setAntiAlias(true);
        paintGreen.setColor(Color.GREEN);
        paintGreen.setStyle(Paint.Style.FILL);
        paintGreen.setStrokeWidth(2.0f);

        float[] pts1={225,5,175,55,175,55,275,55,275,55,225,5};
        canvas.drawLines(pts1, paintGreen);

        //畫實心矩形
        canvas.drawRect(175,65,275,165,paintGreen);

        //畫實心扇形
        RectF rectF2=new RectF(175,175,275,275);
        canvas.drawArc(rectF2, 0, 90, true, paintGreen);
        canvas.drawArc(rectF2, 180, 90, false, paintGreen);

        //畫實心圓形
        RectF rectF3=new RectF(175,285,275,385);
        canvas.drawOval(rectF3, paintGreen);


        //畫實心三角形漸層色
        Paint paintRed=new Paint();
        paintRed.setAntiAlias(true);
        paintRed.setColor(Color.RED);
        paintRed.setStyle(Paint.Style.FILL);
        paintRed.setStrokeWidth(2.0f);
//        paintRed.setShader(new LinearGradient(345,0,345,60,Color.BLUE,Color.RED, Shader.TileMode.REPEAT));
        int[] colors={Color.RED,Color.YELLOW,Color.GREEN,Color.BLUE};
        float[] positions={0.2f,0.4f,0.6f,1f};
        paintRed.setShader(new LinearGradient(345,0,345,60,colors,positions, Shader.TileMode.REPEAT));


        float[] pts2={345,5,295,55,295,55,395,55,395,55,345,5};
        canvas.drawLines(pts2, paintRed);

        //畫實心矩形漸層色
        canvas.drawRect(295,65,395,165,paintRed);

        //畫實心扇形漸層色
        RectF rectF4=new RectF(295,175,395,275);
        canvas.drawArc(rectF4, 0, 90, true, paintRed);
        canvas.drawArc(rectF4, 180, 90, false, paintRed);

        //畫實心圓形漸層色
        RectF rectF5=new RectF(295,285,395,385);
        canvas.drawOval(rectF5, paintRed);


    }
}
