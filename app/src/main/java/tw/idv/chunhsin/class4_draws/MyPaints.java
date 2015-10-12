package tw.idv.chunhsin.class4_draws;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by student on 2015/10/12.
 */
public class MyPaints {
    Paint pBlue;
    Paint pRed;
    MyPaints(){
        intiPaint();
    }

    void intiPaint(){
        pBlue=new Paint();
        pBlue.setAntiAlias(true);
        pBlue.setColor(Color.BLUE);
        pBlue.setStrokeWidth(2.0f);
        pBlue.setStyle(Paint.Style.STROKE);

        pRed=new Paint();
        pRed.setAntiAlias(true);
        pRed.setColor(Color.BLUE);
        pRed.setStrokeWidth(2.0f);
        pRed.setStyle(Paint.Style.FILL);
    }
}
