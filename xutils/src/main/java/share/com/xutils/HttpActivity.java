package share.com.xutils;

import android.app.ProgressDialog;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.xutils.common.Callback;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;

public class HttpActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = "crazyK";
    private Button btn_GET,btn_POST,btn_OTHER,btn_UPLOAD,btn_DOWNLOAD,btn_CACHE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

        initView();
        initListener();
    }

    public void initView(){
        btn_GET = (Button) findViewById(R.id.get);
        btn_POST = (Button) findViewById(R.id.post);
        btn_OTHER= (Button) findViewById(R.id.other);
        btn_UPLOAD = (Button) findViewById(R.id.upload);
        btn_DOWNLOAD = (Button) findViewById(R.id.download);
        btn_CACHE = (Button) findViewById(R.id.cache);
    }

    public void initListener(){
        btn_GET.setOnClickListener(this);
        btn_POST.setOnClickListener(this);
        btn_OTHER.setOnClickListener(this);
        btn_UPLOAD.setOnClickListener(this);
        btn_DOWNLOAD.setOnClickListener(this);
        btn_CACHE.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String url = "https://www.baidu.com";


        switch (v.getId()){
            case R.id.get:
                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setMessage("请稍后....");

                RequestParams requestParams = new RequestParams(url);
                final Callback.Cancelable cancelable = x.http().get(requestParams, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.i(TAG, "onSuccess: "+result);
                    }

                    /**
                     * hrowable ex:异常信息
                     * boolean isOnCallback：错误的来源，如果为ture：异常来源于onSuccess()，若为false，则不是
                     * */
                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    /**
                     * 调用cancelable.cancel()后，此方法会被调用
                     * */
                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    /**
                     *
                     * 请求结束后调用
                     * */
                    @Override
                    public void onFinished() {
                        progressDialog.cancel();
                    }
                });
                break;

            case R.id.post:
                RequestParams requestParams1 = new RequestParams(url);
                requestParams1.addBodyParameter("username","hkc");
                requestParams1.addParameter("pwd","123456");
                requestParams1.addHeader("head","test");

                x.http().post(requestParams1, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.i(TAG, "onSuccess: "+result);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.i(TAG, "onError: "+isOnCallback);
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {
                        
                    }

                    @Override
                    public void onFinished() {
                        Log.i(TAG, "onFinished: ");
                    }
                });
                break;

            case R.id.other:
                RequestParams requestParams2 = new RequestParams(url);
                requestParams2.addBodyParameter("username","hkc");
                requestParams2.addParameter("pwd","123456");
                x.http().request(HttpMethod.POST, requestParams2, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.i(TAG, "onSuccess: "+result);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.i(TAG, "onError: "+isOnCallback);
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {
                        Log.i(TAG, "onCancelled: ");
                    }

                    @Override
                    public void onFinished() {
                        Log.i(TAG, "onFinished: ");
                    }
                });
                break;

            case R.id.upload:
                String path = "手机文件路径";
                RequestParams requestParams3 = new RequestParams(url);
                requestParams3.setMultipart(true);//使用Multipart方式上传
                requestParams3.addBodyParameter("file",new File(path));
                x.http().post(requestParams3, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {

                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
                break;

            /**
             * 在下载图片时CommonCallback无法满足需求，用ProgressCallback
             *
             * */
            case R.id.download:
                RequestParams requestParams4 = new RequestParams(url);

                requestParams4.setSaveFilePath(Environment.getExternalStorageDirectory()+"/hkc/");//设置下载文件路径
                requestParams4.setAutoRename(true);//将文件名自动设置为下载时文件的名字

                x.http().post(requestParams4, new Callback.ProgressCallback<File>() {

                    @Override
                    public void onSuccess(File result) {

                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }

                    /**
                     * 在请求之前调用
                     * */
                    @Override
                    public void onWaiting() {

                    }

                    /**
                     * 网络请求开始时调用
                     * */
                    @Override
                    public void onStarted() {

                    }

                    /**
                     * 文件下载时回调
                     * total:文件总大小
                     * current：当前进度
                     * isDownloading：是否正在下载
                     * */
                    @Override
                    public void onLoading(long total, long current, boolean isDownloading) {

                    }

                });
                break;

            /**
             * 缓存
             * 在使用缓存时CommonCallback无法满足需求，用CacheCallback
             *
             * */
            case R.id.db:
                RequestParams requestParams5 = new RequestParams(url);

                requestParams5.setCacheMaxAge(1000*60);//设置缓存时间

                x.http().get(requestParams5, new Callback.CacheCallback<String>() {
                    @Override
                    public void onSuccess(String result) {

                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }

                    /**
                     * result:缓存内容
                     * return ture:相信本地缓存
                     * return false:不相信本地缓存
                     * 在最大缓存时间中——setCacheMaxAge，如果再次调用x.http().get()，将调用此方法,并返回缓存内容
                     *      若此时return false，则不相信本地缓存，将会再次x.http().get()
                     *      若此时return ture，则相信本地缓存，不会再次x.http().get()
                     * **/
                    @Override
                    public boolean onCache(String result) {
                        return false;
                    }
                });
                break;
        }
    }
}
