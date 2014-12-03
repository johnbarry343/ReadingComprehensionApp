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

    private static final String WORD = "word";
    private static final String TABLE = "ReadingComprehensionData";
    private static final String LEVEL = "level";
    private static final String ID = "_id";
    private static final String DATABASE_NAME = "ReadingComprehensionData";
    private static final String DATABASE_VERSION = "1";

    private static final ArrayList<String> data = new ArrayList<String>();

    private static SQLiteCursor constantsCursor;
    private SQLiteDatabase db;

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

    public String[] getData(int level)
    {
        constantsCursor = (SQLiteCursor) getReadableDatabase().rawQuery("SELECT " + WORD + " FROM " + TABLE + " WHERE " + LEVEL + " = " + Integer.toString(level), null);
        constantsCursor.moveToFirst();

        while (!constantsCursor.isAfterLast())
        {
            data.add(constantsCursor.getString(0));
            constantsCursor.moveToNext();
        }

        Collections.shuffle(data);

        return data.subList(0, 4).toArray(new String[4]);
    }
}
