package com.bwie.myview_demo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.bwie.myview_demo.R;

/**
 * 作者：王庆
 * 时间：2017/11/29
 */

public class MyView extends View {


    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    //测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("TAG", "onMeasure");
    }


    //绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(24);
//        paint.setStrokeWidth(5);

        canvas.drawText("画圆：", 30, 60, paint);
        paint.setAntiAlias(true);
        canvas.drawCircle(150, 50, 40, paint);


        canvas.drawText("画线：", 30, 150, paint);
        paint.setColor(Color.GREEN);
        canvas.drawLine(100, 140, 200, 140, paint);//直线：Y轴相等
        canvas.drawLine(250, 140, 500, 300, paint);//斜线，Y轴不等

        //画笑脸
        paint.setColor(Color.RED);
        canvas.drawText("画笑脸：", 30, 200, paint);
        paint.setStyle(Paint.Style.STROKE);//设置空心
        RectF ovall = new RectF(150, 160, 200, 180);
        canvas.drawArc(ovall, 180, 180, false, paint);//画小弧
        ovall.set(230, 160, 280, 180);
        canvas.drawArc(ovall, 180, 180, false, paint);//画小弧
        ovall.set(170, 160, 260, 210);
        canvas.drawArc(ovall, 0, 180, false, paint);//画小弧

        canvas.drawText("画矩形：", 30, 260, paint);
        paint.setStyle(Paint.Style.FILL);//填充
        canvas.drawRect(170, 240, 300, 270, paint);//长方形
        canvas.drawRect(340, 240, 400, 300, paint);//正方形

        RectF rect = new RectF(420, 240, 500, 290);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(rect, 10, 10, paint);

        canvas.drawText("画扇形和椭圆形：", 30, 350, paint);
        paint.setStyle(Paint.Style.FILL);
        RectF ovall12 = new RectF(230, 320, 370, 460);
        //第一个参数定义大小，第二个参数起始度，0度在x轴右侧，90度在y轴的下面，180度在x轴的左侧，360在y轴上面；
        //第三个参数弧旋转的角度，第四个参数，是true表示与原点相连，false不相连，第五个参数画笔
        canvas.drawArc(ovall12, 200, 130, true, paint);

        //椭圆
        ovall12.set(460, 300, 500, 400);
        canvas.drawOval(ovall12, paint);

        //三角形
        canvas.drawText("三角形：", 30, 400, paint);
        Path path = new Path();
        path.moveTo(150, 400);//定点
        path.lineTo(150, 500);
        path.lineTo(250, 500);
        path.close();
        canvas.drawPath(path, paint);

        //多边形
        Path path1 = new Path();
        path1.moveTo(300, 400);
        path1.lineTo(360, 400);
        path1.lineTo(420, 460);
        path1.lineTo(420, 520);
        path1.lineTo(360, 580);
        path1.lineTo(300, 580);
        path1.lineTo(240, 520);
        path1.lineTo(240, 460);
        canvas.drawPath(path1, paint);

        //设置贝塞尔曲线
        canvas.drawText("设置贝塞尔曲线：", 30, 600, paint);
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        Path path2 = new Path();
        path2.moveTo(400, 600);
        path2.quadTo(240, 650, 400, 700);
        path2.quadTo(560, 720, 350, 800);
        canvas.drawPath(path2, paint);

        //画点
        paint.setTextSize(24);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("画点：", 30, 700, paint);
        canvas.drawPoint(120, 700, paint);
        canvas.drawPoints(new float[]{130, 700, 140, 700, 150, 700}, paint);

        //贴图
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap, 200, 800, paint);


        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(300, 600, 200, paint);

//        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GRAY);
        RectF oval = new RectF(150, 480, 260, 530);
        canvas.drawArc(oval, 180, 170, false, paint);

        oval.set(340, 480, 450, 530);
        canvas.drawArc(oval, 180, 170, false, paint);

        oval.set(170, 650, 430, 740);
        canvas.drawArc(oval, 0, 180, false, paint);

        paint.setColor(Color.DKGRAY);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(200, 540, 40, paint);
        canvas.drawCircle(400, 540, 40, paint);
        paint.setColor(Color.WHITE);

        oval.set(200,520,220,550);
        canvas.drawOval(oval,paint);
        oval.set(380,520,400,550);
        canvas.drawOval(oval ,paint);

//        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap,270,600,paint);
    }

    //位置
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e("TAG", "onLayout");
    }

    //监听
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

}
