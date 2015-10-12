package tw.idv.chunhsin.class4_draws;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
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
        float[] pts={100,5,50,90,50,90,150,90,150,90,100,5};
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        paint.setColor(0xffffffff);
        paint.setStrokeWidth(3.0f);
        canvas.drawLines(pts, paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(50, 120, 150, 220, paint);

        RectF rect = new RectF();
        rect.set(50,250,150,350);
        canvas.drawRoundRect(rect,30,30,paint);

        RectF rect2 = new RectF();
        rect2.set(50,380,150,480);
        canvas.drawArc(rect2,-30,120,false,paint);

    }
}
