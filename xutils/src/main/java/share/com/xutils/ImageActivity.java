package share.com.xutils;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import org.xutils.common.Callback;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.io.File;

public class ImageActivity extends AppCompatActivity {
    private ImageView iv1,iv2,iv3,iv4,iv5,iv6;
    private String[] imageStr = new String[]{
            "http://img0.imgtn.bdimg.com/it/u=2719701944,3742084682&fm=21&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2719701944,3742084682&fm=21&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2719701944,3742084682&fm=21&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2719701944,3742084682&fm=21&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2719701944,3742084682&fm=21&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2719701944,3742084682&fm=21&gp=0.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        initView();

        x.image().bind(iv1,imageStr[0]);

        ImageOptions imageOptions = new ImageOptions.Builder().build();
        x.image().bind(iv2,imageStr[1],imageOptions);

        x.image().bind(iv3, imageStr[2], new Callback.CommonCallback<Drawable>() {
            @Override
            public void onSuccess(Drawable result) {

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

        x.image().bind(iv4, imageStr[3], imageOptions, new Callback.CommonCallback<Drawable>() {
            @Override
            public void onSuccess(Drawable result) {

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

        x.image().loadDrawable(imageStr[0], imageOptions, new Callback.CommonCallback<Drawable>() {

            @Override
            public void onSuccess(Drawable result) {
                iv5.setImageDrawable(result);
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

        /**
         * 当我们之前调用过bind或loadDrawable方法后，图片将保存在本地中，
         * 我们用loadFile方法来直接找到本地图片
         * */
        x.image().loadFile(imageStr[0], imageOptions, new Callback.CacheCallback<File>() {
            @Override
            public boolean onCache(File result) {
                //图片另存为 等操作
                return false;
            }

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
        });
    }

    public void initView(){
        iv1 = (ImageView) findViewById(R.id.image1);
        iv2 = (ImageView) findViewById(R.id.image2);
        iv3 = (ImageView) findViewById(R.id.image3);
        iv4 = (ImageView) findViewById(R.id.image4);
        iv5 = (ImageView) findViewById(R.id.image5);
        iv6 = (ImageView) findViewById(R.id.image6);
    }
}
