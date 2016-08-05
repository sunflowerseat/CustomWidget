package com.fancy.customwidget.bezier;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by gavin on 15-4-1.
 */
public class BezierView extends View {

    //    private Path mPath = new Path();
    private Paint mPaint;

    public BezierView(Context context) {
        this(context, null);
    }

    public BezierView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BezierView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(0xFF009688);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path mPath = new Path();
        /**
         * 二阶贝塞尔 起点是path的当前位置
         * 终点是quadTo方法中传入第二个点
         * quadTo方法中传入的第一个点是二阶贝塞尔的控制点
         */
//        mPath.quadTo(100,200,200,0);

        /**
         * 三阶贝塞尔 起点是path的当前位置
         * 终点是cubicTo方法中传入的第三个点
         * quadTo方法中传入的第一个点是三阶贝塞尔的第一个控制点
         * quadTo方法中传入的第一个点是三阶贝塞尔的第一二控制点
         */
//        mPath.moveTo(0,0);
//        mPath.cubicTo(200, 0, 200, 400, 400, 400);

        /*mRectF = new RectF(10, 10, 600, 600);
        mPath.arcTo(mRectF, 0, 90);*/

        mPath.reset();
        mPaint.setColor(Color.BLACK);

        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        PointF center1 = new PointF(100, 100);
        float r1 = 80;
        PointF start1 = new PointF(center1.x - r1, center1.y - r1);
        PointF end1 = new PointF(center1.x + r1, center1.y + r1);

        PointF center2 = new PointF(300, 100);
        float r2 = 40;
        PointF start2 = new PointF(center2.x - r2, center2.y - r2);
        PointF end2 = new PointF(center2.x + r2, center2.y + r2);

        canvas.drawCircle(center1.x, center1.y, r1, mPaint);
        canvas.drawCircle(center2.x, center2.y, r2, mPaint);

        /*PointF point1 = new PointF(start1.x + r1, start1.y);
        PointF point2 = new PointF(start1.x + r1 + r1 / 2, start1.y + r1 / 2);
        PointF point3 = new PointF(end1.x, start1.y + r1);
        PointF point4 = new PointF(start2.x + r2, start2.y);
        PointF point5 = new PointF(start1.x + r1, end1.y);
        PointF point6 = new PointF(start1.x + r1 + r1 / 2, start1.y + r1 + r1 / 2);
        PointF point7 = new PointF(end1.x, start1.y + r1);
        PointF point8 = new PointF(start2.x + r2, end2.y);*/

        PointF point1 = new PointF(start1.x + r1, start1.y);
        PointF point2 = new PointF(end1.x, (float) (start1.y + r1*0.8));
        PointF point3 = new PointF(start2.x, (float) (start2.y + r2*0.8));
        PointF point4 = new PointF(start2.x + r2, start2.y);

        PointF point5 = new PointF(start1.x + r1, end1.y);
        PointF point6 = new PointF(end1.x, (float) (end1.y - r1*0.8));
        PointF point7 = new PointF(start2.x, (float) (end2.y - r2/2*0.8));
        PointF point8 = new PointF(start2.x + r2, end2.y);

        mPath.moveTo(point1.x, point1.y);
        mPath.cubicTo(point2.x, point2.y, point3.x, point3.y, point4.x, point4.y);
        mPath.lineTo(point8.x,point8.y);
        mPath.cubicTo(point7.x, point7.y, point6.x, point6.y, point5.x, point5.y);
        mPath.lineTo(point1.x,point1.y);
        mPath.close();
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

}
