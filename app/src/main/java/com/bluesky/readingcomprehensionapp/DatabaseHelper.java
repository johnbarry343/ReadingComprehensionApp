package com.bluesky.readingcomprehensionapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static DatabaseHelper mInstance = null;

    public static final String WORD = "word";
    public static final String TABLE = "ReadingComprehensionData";
    public static final String ID = "_id";
    public static final String DATABASE_NAME = "ReadingComprehensionData";
    public static final String DATABASE_VERSION = "1";

    public static DatabaseHelper getInstance(Context ctx)
    {
        if (mInstance == null)
        {
            mInstance = new DatabaseHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }

    private DatabaseHelper(Context ctx)
    {
        super(ctx, DATABASE_NAME, null, Integer.parseInt(DATABASE_VERSION));
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2)
    {

    }
}
