package share.com.xutils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private Button btn_http,btn_image,btn_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_http = (Button) findViewById(R.id.http);
        btn_image = (Button) findViewById(R.id.image);
        btn_db = (Button) findViewById(R.id.db);
        btn_http.setOnClickListener(this);
        btn_image.setOnClickListener(this);
        btn_db.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.http:
                Intent intent_http = new Intent(this,HttpActivity.class);
                startActivity(intent_http);
                break;
            case R.id.image:
                Intent intent_image = new Intent(this,ImageActivity.class);
                startActivity(intent_image);
                break;
            case R.id.db:
                Intent intent_db = new Intent(this,DBActivity.class);
                startActivity(intent_db);
                break;
        }
    }
}
