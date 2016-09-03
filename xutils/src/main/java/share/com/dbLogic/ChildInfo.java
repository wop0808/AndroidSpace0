package share.com.dbLogic;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2016/9/3.
 */

/**
 * onCreated:表创建时执行的sql语句
 * 默认为空
 * */

@Table(name = "child_info ",onCreated = "")
public class ChildInfo {
    /**
     * name：字段名
     * isID：是否为主键，默认false
     * autoGen：是否自增长，默认ture
     * */
    @Column(name = "id",isId = true,autoGen = true)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    /**
     * 通过映射机制生成的对象，必须保留无参构造，不然要出问题
     * */
    public ChildInfo() {
    }

    public ChildInfo( String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
