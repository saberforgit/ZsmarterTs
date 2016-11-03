package com.zsmarter.wangxf.WaterMask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import com.zsmarter.wangxf.R;


/**
 * Created by wangxf on 2016/10/28.
 */

public class WaterTsActivity extends Activity {

    private ImageView mSourImage;
    private ImageView mWartermarkImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water);

        initView();
    }

    private void initView() {
        mSourImage = (ImageView) findViewById(R.id.sour_picss);
        mWartermarkImage = (ImageView) findViewById(R.id.wartermark_picsss);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = 5;   //width，hight设为原来的十分一
        Bitmap sourBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.source, options);
        mSourImage.setImageBitmap(sourBitmap);

        Bitmap waterBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ll);

        Bitmap watermarkBitmap = ImageUtil.createWaterMaskCenter(sourBitmap, waterBitmap,50);
        watermarkBitmap = ImageUtil.createWaterMaskLeftBottom(this, watermarkBitmap, waterBitmap, 24, 25,50);
        watermarkBitmap = ImageUtil.createWaterMaskRightBottom(this, watermarkBitmap, waterBitmap, 0, 0,50);
        watermarkBitmap = ImageUtil.createWaterMaskLeftTop(this, watermarkBitmap, waterBitmap, 0, 0,50);
        watermarkBitmap = ImageUtil.createWaterMaskRightTop(this, watermarkBitmap, waterBitmap, 0, 0,50);

        Bitmap textBitmap = ImageUtil.drawTextToLeftTop(this, watermarkBitmap, "左上角", 24, Color.GREEN, 15, 15,50);
        textBitmap = ImageUtil.drawTextToRightBottom(this, textBitmap, "右下角", 24, Color.GREEN, 15, 15,50);
        textBitmap = ImageUtil.drawTextToRightTop(this, textBitmap, "右上角", 24, Color.GREEN, 15, 15,50);
        textBitmap = ImageUtil.drawTextToLeftBottom(this, textBitmap, "左下角", 24, Color.GREEN, 15, 15,50);
        textBitmap = ImageUtil.drawTextToCenter(this, textBitmap, "中间", 24, Color.RED,50);

        mWartermarkImage.setImageBitmap(textBitmap);
    }
}
