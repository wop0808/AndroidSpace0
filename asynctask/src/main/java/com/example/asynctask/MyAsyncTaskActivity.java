package com.example.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;


import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyAsyncTaskActivity extends AppCompatActivity {
    private ImageView imageView;
    private ProgressBar progressBar;
    private String url = "http://android-artworks.25pp.com/fs01/2015/01/05/4/110_416b936f41cb2b73dce64cbaf6bf1e16.png";
    private MyAsyncTask myAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_async_task);

        imageView = (ImageView) findViewById(R.id.id_myasynctask_img);
        progressBar = (ProgressBar) findViewById(R.id.id_myasynctask_prgb);
        myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute(url);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(myAsyncTask != null && myAsyncTask.getStatus() == AsyncTask.Status.RUNNING){
            myAsyncTask.cancel(true);
        }
    }

    class MyAsyncTask extends AsyncTask<String, Integer, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {

                String url0 = params[0];
                Bitmap bitmap = null;
                URLConnection urlConnection;
                InputStream is;
            try {
                urlConnection = new URL(url).openConnection();
                is = urlConnection.getInputStream();
//                Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//                Set<String> strings = headerFields.keySet();
//                for (String s:strings){
//                    System.out.print(headerFields.get(s));
//                }

                BufferedInputStream bis = new BufferedInputStream(is);
                bitmap = BitmapFactory.decodeStream(bis);
                is.close();
                bis.close();

                for(int i = 0 ; i< 100 ; i++){
                    if(this.isCancelled()){
                        break;
                    }
                    Thread.sleep(100);
                    publishProgress(i);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            progressBar.setVisibility(View.GONE);
            imageView.setImageBitmap(bitmap);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if(this.isCancelled()){
                return;
            }
            progressBar.setProgress(values[0]);
        }
    }
}
