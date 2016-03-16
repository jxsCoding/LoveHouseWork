package com.joy.demo.lovehousework.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by joy on 16/3/16.
 */
public class HouseWorkService {
    private DBHelper mDBHelper;
    private SQLiteDatabase mDatabase;

    /**
     * 表hw_selected添加单个条目
     * @param hwsid
     * @param name
     */
    public void addSelected(Integer hwsid,String name){
        if (!mDatabase.isOpen()){
           mDatabase= mDBHelper.getWritableDatabase();
        }
        mDatabase.execSQL("INSERT INTO hw_selected(hwsid,name) values(?,?)",
                new Object[]{hwsid,name});
        mDatabase.close();
    }

    /**
     * 表hw_selected更新指定id条目
     * @param id
     * @param name
     */
    public void updateSelected(Integer id,String name){
        mDatabase=mDBHelper.getWritableDatabase();
        mDatabase.execSQL("UPDATE hw_selected set name=? WHERE id=?",new Object[]{name,id});
        mDatabase.close();
    }

    /**
     * 表hw_selected查询指定id条目
     * @param id
     * @return
     */
    public String findSelected(Integer id){
        mDatabase=mDBHelper.getReadableDatabase();
        String result=null;
        Cursor cursor=mDatabase.rawQuery("SELECT name FROW hw_selected WHERE id=?",
                new String[]{id+""});
        //迭代记录集
        if (cursor.moveToNext()){
            result=cursor.getString(cursor.getColumnIndex("name"));
        }
        return result;
    }

    /**
     * 表hw_selected删除指定id条目
     * @param id
     */
    public void deleteSelected(Integer id){
        mDatabase=mDBHelper.getWritableDatabase();
        mDatabase.execSQL("DELETE FROM hw_selected WHERE id=?",new Object[]{id});
        mDatabase.close();
    }

    /**
     * 表hw_selected删除批量指定id条目
     * @param ids
     */
    public void deleteSelected(ArrayList<Integer> ids){
        mDatabase=mDBHelper.getWritableDatabase();
        for (int i=0;i<ids.size();i++){
            mDatabase.execSQL("DELETE FROM hw_selected WHERE id=?",new Object[]{ids.get(i)});
        }
        mDatabase.close();
    }


    /**
     * 表hw_selected分页查找
     * @param firstIndex
     * @param offset
     * @return
     */
    public ArrayList<String> getScrollNameSelected(int firstIndex,int offset){
        ArrayList<String> result=new ArrayList<String>();
        mDatabase=mDBHelper.getReadableDatabase();
        Cursor cursor=mDatabase.rawQuery("SELECT NAME FROM hw_selected limit ? offset ?",
                new String[]{offset+"",firstIndex+""});
        while (cursor.moveToNext()){
            result.add(cursor.getString(cursor.getColumnIndex("name")));
        }
        cursor.close();
        return result;
    }

    /**
     * 表hw_selected分页查找
     * @param firstIndex
     * @param offset
     * @return
     */
    public ArrayList<Integer> getScrollIdSelected(int firstIndex,int offset){
        ArrayList<Integer> result=new ArrayList<Integer>();
        mDatabase=mDBHelper.getReadableDatabase();
        Cursor cursor=mDatabase.rawQuery("SELECT id FROM hw_selected limit ? offset ?",
                new String[]{offset+"",firstIndex+""});
        while (cursor.moveToNext()){
            result.add(cursor.getInt(cursor.getColumnIndex("id")));
        }
        cursor.close();
        return result;
    }

    /**
     * 表hw_selected获取所有数据id
     * @return
     */
    public ArrayList<Integer> getAllIdSelected(){
        ArrayList<Integer> result=new ArrayList<Integer>();
        mDatabase=mDBHelper.getReadableDatabase();
        Cursor cursor=mDatabase.rawQuery("SELECT id FROM hw_selected",null);
        while (cursor.moveToNext()){
            result.add(cursor.getInt(cursor.getColumnIndex("id")));
        }
        cursor.close();
        return result;
    }


    /**
     * 表hw_selected获取所有数据id
     * @return
     */
    public ArrayList<Integer> getAllHwsidSelected(){
        ArrayList<Integer> result=new ArrayList<Integer>();
        mDatabase=mDBHelper.getReadableDatabase();
        Cursor cursor=mDatabase.rawQuery("SELECT hwsid FROM hw_selected",null);
        while (cursor.moveToNext()){
            result.add(cursor.getInt(cursor.getColumnIndex("id")));
        }
        cursor.close();
        return result;
    }

    /**
     * 表hw_selected获取所有数据
     * @return
     */
    public ArrayList<String> getAllNameSelected(){
        ArrayList<String> result=new ArrayList<String>();
        mDatabase=mDBHelper.getReadableDatabase();
        Cursor cursor=mDatabase.rawQuery("SELECT name FROM hw_selected", null);
        while (cursor.moveToNext()){
            result.add(cursor.getString(cursor.getColumnIndex("name")));
        }
        cursor.close();
        return result;
    }

    /**
     * 表hw_selected获取总记录数
     * @return
     */
    public long getCountSelected(){
        mDatabase=mDBHelper.getReadableDatabase();
        Cursor cursor=mDatabase.rawQuery("SELECT COUNT(*) FROM hw_selected",null);
        cursor.moveToFirst();
        long count=cursor.getLong(0);
        cursor.close();
        return count;
    }

    /**
     * 表hw_works添加单个条目
     * @param name
     */
    public void addWork(String name){
        if (!mDatabase.isOpen()){
            mDatabase= mDBHelper.getWritableDatabase();
        }
        mDatabase.execSQL("INSERT INTO hw_works(name) values(?,?)",
                new Object[]{name});
        mDatabase.close();
    }

    /**
     * 表hw_work删除指定id条目
     * @param id
     */
    public void deleteWork(Integer id){
        mDatabase=mDBHelper.getWritableDatabase();
        mDatabase.execSQL("DELETE FROM hw_works WHERE id=?", new Object[]{id});
        mDatabase.close();
    }

    /**
     * 表hw_works获取所有数据
     * @return
     */
    public ArrayList<String> getAllNameWorks(){
        ArrayList<String> result=new ArrayList<String>();
        mDatabase=mDBHelper.getReadableDatabase();
        Cursor cursor=mDatabase.rawQuery("SELECT name FROM hw_works",null);
        while (cursor.moveToNext()){
            result.add(cursor.getString(cursor.getColumnIndex("name")));
        }
        cursor.close();
        return result;
    }

    /**
     * 表hw_works获取所有数据id
     * @return
     */
    public ArrayList<Integer> getAllIdWorks(){
        ArrayList<Integer> result=new ArrayList<Integer>();
        mDatabase=mDBHelper.getReadableDatabase();
        Cursor cursor=mDatabase.rawQuery("SELECT id FROM hw_works", null);
        while (cursor.moveToNext()){
            result.add(cursor.getInt(cursor.getColumnIndex("id")));
        }
        cursor.close();
        return result;
    }

    /**
     * 表hw_works获取总记录数
     * @return
     */
    public long getCountWorks(){
        mDatabase=mDBHelper.getReadableDatabase();
        Cursor cursor=mDatabase.rawQuery("SELECT COUNT(*) FROM hw_works",null);
        cursor.moveToFirst();
        long count=cursor.getLong(0);
        cursor.close();
        return count;
    }

    /**
     * 添加选项到hw_selected
     * @param ids
     */
    public void addToGrids(ArrayList<Integer> ids){
        mDatabase=mDBHelper.getReadableDatabase();
        String name;
        for (int i=0;i<ids.size();i++){
            Cursor cursor=mDatabase.rawQuery("SELECT name FROM hw_works WHERE id=?"
                    ,new String[]{ids.get(i)+""});
            if (cursor.moveToNext()){
                name=cursor.getString(cursor.getColumnIndex("name"));
                mDatabase.execSQL("INSERT INTO hw_selected(hwsid,name) value(?,?)",
                        new Object[]{ids.get(i),name});
            }
        }

    }

    /**
     * 删除数据
     */
    public void deleteReal(ArrayList<Integer> ids){
        mDatabase=mDBHelper.getReadableDatabase();
        for (int i=0;i<ids.size();i++){
            mDatabase.execSQL("DELETE FROM hw_works WHERE id=?",new Object[]{ids.get(i)});
            mDatabase.execSQL("DELETE FROM hw_selected WHERE hwsid=?",new Object[]{ids.get(i)});

        }
        mDatabase.close();
    }

}
