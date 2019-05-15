package jy.com.libcustomview.contactlist;

import android.content.Context;
import android.graphics.*;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/*
 * created by taofu on 2019-05-15
 **/
public class SliderView extends View {

    private static final String [] CONTENT =  {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","#"};
   // private static final String [] CONTENT =  {"A","B","C","D","E","F"};

    private Paint mCharPaint;
    private Paint mFillPaint;
    private Paint mStrokePaint;

    private ArrayList<Char> mCharArrayList;

    private RectF mRounderRect = new RectF();
    private int mWidth;
    private int mHeight;

    private int mDefaultTextSize;
    private int mGridHeight,mGridWidth;
    private int mCharWidth,mCharHeight;
    private int mLeftPadding,mRightPadding;

    private int mOffset;





    public SliderView(Context context) {
        super(context);
    }

    public SliderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public SliderView(Context context,  @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);



        if(mWidth != 0){ // 50
           int width = MeasureSpec.makeMeasureSpec(mWidth , MeasureSpec.EXACTLY);
           setMeasuredDimension(width, heightMeasureSpec);// 设置控件自身的宽高
        }else{
           int width = MeasureSpec.makeMeasureSpec(1 , MeasureSpec.EXACTLY);
           setMeasuredDimension(width, heightMeasureSpec);
       }



    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mWidth == 0 || mHeight == 0){
            init();
        }else{

            canvas.drawRoundRect(mRounderRect, mRounderRect.width()/2, mRounderRect.width()/2, mFillPaint);
            canvas.drawRoundRect(mRounderRect, mRounderRect.width()/2, mRounderRect.width()/2, mStrokePaint);

            for(Char c : mCharArrayList){
                canvas.drawText(c.value, c.x, c.y, mCharPaint);
                //canvas.drawLine(0, c.rect.bottom, c.rect.right, c.rect.bottom, mStrokePaint);

                //mStrokePaint.setStrokeWidth(2);

               // canvas.drawLine(0, );
            }


        }




    }


    private void init(){

        mHeight = getHeight();
        mGridHeight = mHeight / CONTENT.length; // 每一个格子的高度

        mDefaultTextSize = mGridHeight /2; // 默认字体的高度为格子的高度的1/2
        mCharPaint = new Paint();
        mCharPaint.setTextSize(mDefaultTextSize);
        mCharPaint.setColor(Color.parseColor("#A6A6A6"));
        mCharPaint.setAntiAlias(true);
        mCharPaint.setTextAlign(Paint.Align.CENTER);
        mOffset = 1;
        mFillPaint = new Paint();
        mFillPaint.setColor(Color.WHITE);
        mFillPaint.setAntiAlias(true);
        mFillPaint.setStyle(Paint.Style.FILL);

        mFillPaint.setStrokeWidth(mOffset*2);



        mStrokePaint = new Paint();
        mStrokePaint.setColor(Color.parseColor("#E1E1E1"));
        mStrokePaint.setAntiAlias(true);
        mStrokePaint.setStyle(Paint.Style.STROKE);
        mStrokePaint.setStrokeWidth(mOffset*2);


        mCharWidth = (int) mCharPaint.measureText("A");// 求字体的宽度

        mLeftPadding = mRightPadding =  (mCharWidth ); // 格子内字体左右两边的padding 为 字体的 1/2

        mGridWidth =  (mLeftPadding + mRightPadding + mCharWidth); // 格子的宽度为 字体的宽度加上左右两边的边距

        mWidth = mGridWidth; // 我们滑动条控件的宽度和格子的宽度一样

        mRounderRect.left =  mOffset;
        mRounderRect.top = mOffset;
        mRounderRect.right = mWidth - mOffset;
        mRounderRect.bottom = mHeight - mOffset;


        requestLayout();// 会让我们控件重新计算大小，

        initContent();


    }



    private void initContent(){
        Char c;
        Rect rect;
        int sum = 0;
        mCharArrayList = new ArrayList<>();
        for(String s : CONTENT){
            rect = new Rect(0,sum,mGridWidth,sum + mGridHeight);
            sum += mGridHeight;
            c = new Char(s, rect);
            mCharArrayList.add(c);
        }


        Log.d("Test", "ddd");
    }

    public class Char{

        private String value; // A,B,C
        private Rect rect;
        private int x;
        private int y;
        private int baseLine;


        public Char(String value, Rect rect) {
            this.value = value;
            this.rect = rect;


            x = rect.width() / 2;

            Paint.FontMetrics fontMetrics = mCharPaint.getFontMetrics();
            int cH = (int) - (fontMetrics.ascent + fontMetrics.descent);

            y = rect.top + (rect.height() / 2 + cH /2);

            baseLine = y;
        }
    }
}
