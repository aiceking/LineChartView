package com.example.vmmet.keyindeslinechart;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Vmmet on 2016/10/12.
 */
public class RealtimeLineChart extends View {
    private Paint nowLinePaint;
    private Paint lastLinePaint;
    private Paint borderPaint;
    private Paint textPaint;
    private Paint xandyPaint;
    private keyIndexLinebean keyIndexLinebean;
    public RealtimeLineChart(Context context) {
        this(context, null);
    }
public void setDateSource(keyIndexLinebean keyIndexLinebean){
    this.keyIndexLinebean=keyIndexLinebean;
    invalidate();
}
    public RealtimeLineChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RealtimeLineChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        nowLinePaint=new Paint();
        nowLinePaint.setAntiAlias(true);
        nowLinePaint.setColor(Color.RED);
        nowLinePaint.setStrokeWidth(3);
        nowLinePaint.setStrokeCap(Paint.Cap.ROUND);
        nowLinePaint.setStyle(Paint.Style.STROKE);
        lastLinePaint=new Paint();
        lastLinePaint.setAntiAlias(true);
        lastLinePaint.setColor(Color.BLUE);
        lastLinePaint.setStrokeWidth(3);
        lastLinePaint.setStrokeCap(Paint.Cap.ROUND);
        lastLinePaint.setStyle(Paint.Style.STROKE);
        borderPaint=new Paint();
        borderPaint.setAntiAlias(true);
        borderPaint.setStrokeWidth(2);
        borderPaint.setColor(Color.parseColor("#50000000"));
        textPaint=new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setColor(Color.BLACK);
        xandyPaint=new Paint();
        xandyPaint.setAntiAlias(true);
        xandyPaint.setTextAlign(Paint.Align.CENTER);
        xandyPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int multiple=7;
        float width=getWidth()/multiple;
        float height=getHeight()/8;
        /**矩形边框*/
        canvas.drawLine(width, height,getWidth()-width, height, borderPaint);
        canvas.drawLine(width,height,width,getHeight()-height,borderPaint);
        canvas.drawLine(width, getHeight() - height, getWidth() - width, getHeight() - height, borderPaint);
        canvas.drawLine(getWidth() - width, height, getWidth() - width, getHeight() - height, borderPaint);
        /**边框上边的指示字*/
        if (keyIndexLinebean!=null){
        textPaint.setTextSize(height / 2.1f);
        canvas.drawLine(width, height / 2, width + width / 2, height / 2, lastLinePaint);
        canvas.drawText(keyIndexLinebean.getLastname(), width + width / 2 + 5, height / 3 * 2 - 3, textPaint);
        canvas.drawLine(getWidth() / 2, height / 2, getWidth() / 2 + width / 2, height / 2, nowLinePaint);
        canvas.drawText(keyIndexLinebean.getNowname(), getWidth() / 2 + width / 2 + 5, height / 3 * 2 - 3, textPaint);
        /**画X轴的刻度*/
        xandyPaint.setTextSize(height / 2.1f);
            if (keyIndexLinebean.getX_numbers()!=null){
        float average_x=(getWidth() - width-width)/(keyIndexLinebean.getX_numbers().size()-1);
        for (int i=0;i<keyIndexLinebean.getX_numbers().size();i++){
            canvas.drawText(keyIndexLinebean.getX_numbers().get(i),width+i*average_x,height*8,xandyPaint);
        }
            }
        /**画Y轴的刻度*/
        xandyPaint.setTextSize(height / 2.1f);
            if (keyIndexLinebean.getY_numbers()!=null){
        float average_y=(getHeight() - height-height)/(keyIndexLinebean.getY_numbers().size()-1);
        for (int i=0;i<keyIndexLinebean.getY_numbers().size();i++){
            canvas.drawText(keyIndexLinebean.getY_numbers().get(i),width/2,getHeight() - height-average_y*i+9,xandyPaint);
        }
            }
        /**画折线*/
        float average_x_line=(getWidth() - width-width)/(keyIndexLinebean.getX_datas()-1);
        Path p1=new Path();
        Path p2=new Path();
            if (keyIndexLinebean.getLast_numbers()!=null&&keyIndexLinebean.getNow_numbers()!=null) {
                for (int i = 0; i < keyIndexLinebean.getNow_numbers().size(); i++) {
                    if (i > 0) {
                        p1.lineTo(width + average_x_line * (i), (getHeight() - height) - (keyIndexLinebean.getNow_numbers().get(i) - keyIndexLinebean.getMin()) * (getHeight() - height - height) / (keyIndexLinebean.getMax() - keyIndexLinebean.getMin()));
                    } else {
                        p1.moveTo(width + average_x_line * (i), (getHeight() - height) - (keyIndexLinebean.getNow_numbers().get(i) - keyIndexLinebean.getMin()) * (getHeight() - height - height) / (keyIndexLinebean.getMax()-keyIndexLinebean.getMin()));
                    }
                }
                for (int i = 0; i < keyIndexLinebean.getLast_numbers().size(); i++) {
                    if (i > 0) {
                        p2.lineTo(width + average_x_line * (i), (getHeight() - height) - (keyIndexLinebean.getLast_numbers().get(i) - keyIndexLinebean.getMin()) * (getHeight() - height - height) / (keyIndexLinebean.getMax() - keyIndexLinebean.getMin()));
                    } else {
                        p2.moveTo(width + average_x_line * (i), (getHeight() - height) - (keyIndexLinebean.getLast_numbers().get(i) - keyIndexLinebean.getMin()) * (getHeight() - height - height) / (keyIndexLinebean.getMax()-keyIndexLinebean.getMin()));
                    }
                }
            }
        canvas.drawPath(p1,nowLinePaint);
        canvas.drawPath(p2,lastLinePaint);

    }
    }
}
