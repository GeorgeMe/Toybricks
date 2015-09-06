package com.yunyan.toybricks.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by George on 2015/9/6.
 * 数据库帮助类，用来保存各个线程下载进度信息
 */
public class DbHelper  extends SQLiteOpenHelper {

    private static final String DB_NAME = "toybricks_thread_download.db";
    private static final int VERSION = 1;

    // 建表SQL语句
    private static final String SQL_CREATE = "create table thread_info(_id integer primary key autoincrement, "
            + "thread_id integer, url text, start integer, end integer, finished integer)";
    private static final String SQL_CREATE_STATE= "create table state_info(_id integer primary key autoincrement, "
            + "state_id integer, qr_check integer, download integer, choose integer)";

    // 删表SQL语句
    private static final String SQL_DELETE = "drap table if exists thread_info";
    private static final String SQL_DEKETE_STATE="drap table if exists state_info";
    //=================单例==================
    private static DbHelper sInstance;
    /**
     * 单例
     * @param context
     * @return
     */
    public static DbHelper getInstance(Context context){
        if(sInstance == null){
            sInstance = new DbHelper(context);
        }
        return sInstance;
    }
    // 私有构造函数
    private DbHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }
    //=================单例==================

    //=========重写SQLiteOpenHelper的函数==============
    // 创建数据库时回调
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
        db.execSQL(SQL_CREATE_STATE);
    }

    // 更新数据库时回调
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 直接删除了，重新创建表
        db.execSQL(SQL_DELETE);
        db.execSQL(SQL_DEKETE_STATE);
        db.execSQL(SQL_CREATE);
        db.execSQL(SQL_DEKETE_STATE);
    }
    //=========重写SQLiteOpenHelper的函数==============

}
