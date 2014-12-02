package com.bluesky.readingcomprehensionapp;

import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static DatabaseHelper mInstance = null;

    public static final String WORD = "word";
    public static final String TABLE = "ReadingComprehensionData";
    public static final String LEVEL = "level";
    public static final String ID = "_id";
    public static final String DATABASE_NAME = "ReadingComprehensionData";
    public static final String DATABASE_VERSION = "1";

    private static final ArrayList<String> data = null;
    private static SQLiteCursor constantsCursor;

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

    public static String[] getData(Context ctx)
    {
        constantsCursor = (SQLiteCursor) DatabaseHelper.getInstance(ctx).getReadableDatabase().rawQuery("SELECT " + WORD + " FROM " + TABLE + " WHERE " + LEVEL + " = 1", null);
        constantsCursor.moveToFirst();

        while (!constantsCursor.isAfterLast())
        {
            data.add(constantsCursor.getString(1));
            constantsCursor.moveToNext();
        }

        Collections.shuffle(data);

        return data.subList(0, 3).toArray(new String[4]);
    }
}
