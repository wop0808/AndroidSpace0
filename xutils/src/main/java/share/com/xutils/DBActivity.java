package share.com.xutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.xutils.DbManager;
import org.xutils.common.util.KeyValue;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.db.table.TableEntity;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import share.com.dbLogic.ChildInfo;

public class DBActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = "crazyK";
    private Button btn_createDB,btn_dropDB,btn_dropTable,btn_select,btn_update,btn_delete;
    private DbManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        /**
         * 1、创建数据库
         * 2、删除数据库
         * 3、创建表
         * 4、删除表
         * 5、添
         * 6、改
         * 7、查
         * 8、删
         * */
        initView();
        initListener();

    }

    public void initView(){
        btn_createDB = (Button) findViewById(R.id.create_db);
        btn_dropDB = (Button) findViewById(R.id.drop_db);
        btn_dropTable = (Button) findViewById(R.id.drop_table);
        btn_select = (Button) findViewById(R.id.select);
        btn_update = (Button) findViewById(R.id.update);
        btn_delete = (Button) findViewById(R.id.delete);
    }
    public void initListener(){
        btn_createDB.setOnClickListener(this);
        btn_dropDB.setOnClickListener(this);
        btn_dropTable.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_select.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            //创建数据库
            case R.id.create_db:
                DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                        .setDbName("hkc.db")
                        .setTableCreateListener(new DbManager.TableCreateListener() {
                            @Override
                            public void onTableCreated(DbManager db, TableEntity<?> table) {
                                Log.i(TAG, table.getName());
                            }
                        })
                        /**
                         * 在打开监听中，可以拿到database，获得数据库多线程操作
                         * */
                        .setDbOpenListener(new DbManager.DbOpenListener() {
                            @Override
                            public void onDbOpened(DbManager db) {
                                db.getDatabase().enableWriteAheadLogging();
                            }
                        });

                /**
                 * 1、创建数据库
                 * 3、创建表
                 * 5、插入数据
                 * 如果发现数据库及表已经存在，则会直接进行插入数据
                 * */

                dbManager = x.getDb(daoConfig);
                ArrayList<ChildInfo> childInfoArrayList = new ArrayList<>();
                childInfoArrayList.add( new ChildInfo("hkc",25));
                childInfoArrayList.add( new ChildInfo("hkc1",26));
                childInfoArrayList.add( new ChildInfo("hkc2",27));
                childInfoArrayList.add( new ChildInfo("hkc3",28));
                childInfoArrayList.add( new ChildInfo("hkc4",29));
                childInfoArrayList.add( new ChildInfo("hkc5",30));
                childInfoArrayList.add( new ChildInfo("hkc6",20));
                childInfoArrayList.add( new ChildInfo("hkc7",21));

                try {
                    dbManager.save(childInfoArrayList);
                } catch (DbException e) {
                    e.printStackTrace();
                }
                break;

            //删除数据库
            /**
             * 2、删除数据库
             * */
            case R.id.drop_db:
                try {
                    dbManager.dropDb();
                } catch (DbException e) {
                    e.printStackTrace();
                }
                break;

            /**
             * 4、删除表
             * */
            case R.id.drop_table:
                WhereBuilder whereBuilder = WhereBuilder.b();
                whereBuilder.expr("id ='1'");
                try {
                    dbManager.delete(ChildInfo.class,whereBuilder);
                } catch (DbException e) {
                    e.printStackTrace();
                }
                break;

            /**
             * 查
             * */
            case R.id.select:
                WhereBuilder whereBuilder1 = WhereBuilder.b();
                whereBuilder1.and("age",">",21);
                whereBuilder1.and("age","<",28);
                try {
                    /**
                     * 以下两种方法等价
                     * */
                    List<ChildInfo> infoList = dbManager.selector(ChildInfo.class).where(whereBuilder1).findAll();
                    List<ChildInfo> infoList1 = dbManager.selector(ChildInfo.class).where("age", ">", 21).and("age", "<", 28).findAll();
                } catch (DbException e) {
                    e.printStackTrace();
                }
                break;

            /**
             * 改
             * */
            case R.id.update:
                try {
                    //方法1
                    ChildInfo first = dbManager.findFirst(ChildInfo.class);
                    first.setName("张三");
                    first.setAge(100);
                    dbManager.update(first,"age","name");

                    //方法2：
                    WhereBuilder whereBuilder2 = WhereBuilder.b();
                    whereBuilder2.and("id","=",first.getId());
                    KeyValue keyValue = new KeyValue("name", "李四");
                    KeyValue keyValue1 = new KeyValue("age", 1000);
                    dbManager.update(ChildInfo.class, whereBuilder2, keyValue, keyValue1);

                    //方法三
                    first.setName("张三11111");
                    first.setAge(1000);
                    dbManager.saveOrUpdate(first);

                } catch (DbException e) {
                    e.printStackTrace();
                }
                break;

            /**
             * 删
             * */
            case R.id.delete:
                try {
                    //删除表中所有数据
                    dbManager.delete(ChildInfo.class);
                    //删除条件数据
                    WhereBuilder whereBuilder3 = WhereBuilder.b();
                    whereBuilder3.and("name","=","张三");
                    dbManager.delete(ChildInfo.class,whereBuilder3);
                } catch (DbException e) {
                    e.printStackTrace();
                }
                break;

        }
    }
}
