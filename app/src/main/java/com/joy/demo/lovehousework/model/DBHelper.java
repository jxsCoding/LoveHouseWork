package com.joy.demo.lovehousework.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by joy on 16/3/16.
 */
public class DBHelper extends SQLiteOpenHelper{
    //database name
    private static final String NAME="housework.db";
    //database version
    private static final int VERSION=1;
    private String[] houseworks={"扫地","洗碗","做饭","买菜","洗衣服",
            "倒垃圾","包干","歇着","唱歌","跳舞"};
    public DBHelper(Context context){
        super(context,NAME,null,VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, NAME, factory, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //新建hw_selected表，存储的为gridview中的选择项
        sqLiteDatabase.execSQL("CREATE TABLE hw_selected(" +
                "id integer primary key autoincrement," +
                "hwsid integer," +
                "name varchar(16))");
        //新建hw_works表，存储的为listview中选择项--所有家务条目
        sqLiteDatabase.execSQL("CREATE TABLE hw_works(" +
                "id integer primary key autoincrement," +
                "name varchar(16))");
        //初始化数据
        for (int i=0;i<houseworks.length;i++){
            //初始化表hw_works
            sqLiteDatabase.execSQL("INSERT INTO hw_works(name) value(?)",
                    new Object[]{houseworks[i]});
            //初始化表hw_selected
            if (i<6){
                sqLiteDatabase.execSQL("INSERT INTO hw_selected(hwsid,name) value(?,?)",
                        new Object[]{i+1,houseworks[i]});
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS hw_selected");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS hw_works");
        onCreate(sqLiteDatabase);
    }
}
