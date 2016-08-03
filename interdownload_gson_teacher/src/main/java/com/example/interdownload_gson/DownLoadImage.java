package com.example.interdownload_gson;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/8/2.
 */
public class DownLoadImage extends AsyncTask<String , Void ,Bitmap> {
    private ImageView imageView;

    public DownLoadImage(ImageView imageView){
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        String murl = params[0];
        Bitmap bitmapFromURL = DownLoadTool.getBitmapFromURL(murl);
        return bitmapFromURL;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);

    }
}
