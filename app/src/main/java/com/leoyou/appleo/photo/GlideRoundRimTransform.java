package com.leoyou.appleo.photo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.leoyou.appleo.R;

/**
 * Created by Administrator on 2017/3/20.
 * 把下载的图片转化成圆角图片
 */
public class GlideRoundRimTransform extends BitmapTransformation {

    private Paint mBorderPaint;
    private float mBorderWidth;

    public GlideRoundRimTransform(Context context) {
        this(context,10,context.getColor(R.color.colorPrimaryDark));
    }

    public GlideRoundRimTransform(Context context, int borderWidth, int borderColor) {
        super(context);
        mBorderWidth = Resources.getSystem().getDisplayMetrics().density * borderWidth;

        mBorderPaint = new Paint();
        mBorderPaint.setDither(true);
        mBorderPaint.setAntiAlias(true);
        mBorderPaint.setColor(borderColor);
        mBorderPaint.setStyle(Paint.Style.STROKE);
        mBorderPaint.setStrokeWidth(mBorderWidth);
    }


    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return roundCrop1(pool ,roundCrop(pool, toTransform));
    }

    private  Bitmap roundCrop(BitmapPool pool, Bitmap source) {
        if (source == null) return null;

        int size = (int) (Math.min(source.getWidth(), source.getHeight()) - (mBorderWidth / 2));
        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;
        Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);
        Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        RectF rectF=new RectF(mBorderWidth/2,mBorderWidth/2,size-mBorderWidth/2,size-mBorderWidth/2);
        canvas.drawRoundRect(rectF,10, 10, paint);
        if (mBorderPaint != null) {
            canvas.drawRoundRect(rectF,10, 10 , mBorderPaint);
        }
        return result;
    }

    @Override
    public String getId() {
        return getClass().getName() ;
    }


    private static Bitmap roundCrop1(BitmapPool pool, Bitmap source) {
        if (source == null) return null;

        Bitmap result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
        canvas.drawRoundRect(rectF, 10, 10, paint);
        return result;
    }
}
