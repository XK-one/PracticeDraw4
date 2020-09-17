package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice10MatrixSkewView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    Matrix mMatrix = new Matrix();

    public Practice10MatrixSkewView(Context context) {
        super(context);
    }

    public Practice10MatrixSkewView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10MatrixSkewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int bitmapWidth;

    private int bitmapHeight;

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        bitmapWidth = bitmap.getWidth();
        bitmapHeight = bitmap.getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        mMatrix.reset();
        //mMatrix.postSkew(0.5f,0f, point1.x + bitmapWidth / 2, point1.y + bitmapHeight / 2);
        mMatrix.postSkew(0,0.5f, point1.x + bitmapWidth / 2, point1.y + bitmapHeight / 2);
        canvas.concat(mMatrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();


        //看app\src\main\java\com\hencoder\hencoderpracticedraw4\skew.png 图片，
        // 红色的x和y表示倾斜的角度，下面是x，上面是y 。参数正数为顺时针，参数负数为逆时针
        //ps: 例如，将一个正方形放到x/y坐标轴中，原点和坐标(0,0)重合
        //正方形的左边线条和y轴所成的角度，就是参数sx在x方向上的错切系数；
        //正方形的上边线条和x轴所成的角度，就是参数sy在y方向上的错切系数；
        //整数为顺时针，负数为逆时针

        canvas.save();
        mMatrix.reset();
        //mMatrix.postSkew(-0.5f,0f, point2.x + bitmapWidth / 2, point2.y + bitmapHeight / 2);
        mMatrix.postSkew(-0.5f,0, point2.x + bitmapWidth / 2, point2.y + bitmapHeight / 2);
        canvas.concat(mMatrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();

        /*canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);*/



    }
}
