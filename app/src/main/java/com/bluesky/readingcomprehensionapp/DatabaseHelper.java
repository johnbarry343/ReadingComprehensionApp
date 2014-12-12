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
    private static final String DATABASE_VERSION = "1";

    private static String DATABASE_NAME = "ReadingComprehensionData";
    private SQLiteDatabase db;
    private static SQLiteCursor constantsCursor;

    private ArrayList<String> data = new ArrayList<String>();


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
    public void onCreate(SQLiteDatabase db)
    {
        android.util.Log.i("onCreate", "Creating Database");

        db.execSQL("CREATE TABLE " + TABLE + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + WORD + " TEXT, " + LEVEL + " INTEGER);");
        db.execSQL("INSERT INTO " + TABLE + " SELECT NULL AS _id, 'ball' AS word, 1 AS level\n" +
                "UNION SELECT NULL, 'ball', 1\n" +
                "UNION SELECT NULL, 'bear', 1\n" +
                "UNION SELECT NULL, 'bee', 1\n" +
                "UNION SELECT NULL, 'book', 1\n" +
                "UNION SELECT NULL, 'bus', 1\n" +
                "UNION SELECT NULL, 'car', 1\n" +
                "UNION SELECT NULL, 'cat', 1\n" +
                "UNION SELECT NULL, 'circle', 1\n" +
                "UNION SELECT NULL, 'cow', 1\n" +
                "UNION SELECT NULL, 'dog', 1\n" +
                "UNION SELECT NULL, 'door', 1\n" +
                "UNION SELECT NULL, 'duck', 1\n" +
                "UNION SELECT NULL, 'egg', 1\n" +
                "UNION SELECT NULL, 'fish', 1\n" +
                "UNION SELECT NULL, 'flower', 1\n" +
                "UNION SELECT NULL, 'frog', 1\n" +
                "UNION SELECT NULL, 'goat', 1\n" +
                "UNION SELECT NULL, 'hat', 1\n" +
                "UNION SELECT NULL, 'house', 1\n" +
                "UNION SELECT NULL, 'leaf', 1\n" +
                "UNION SELECT NULL, 'lion', 1\n" +
                "UNION SELECT NULL, 'moon', 1\n" +
                "UNION SELECT NULL, 'pie', 1\n" +
                "UNION SELECT NULL, 'ship', 1\n" +
                "UNION SELECT NULL, 'sky', 1\n" +
                "UNION SELECT NULL, 'star', 1\n" +
                "UNION SELECT NULL, 'sun', 1\n" +
                "UNION SELECT NULL, 'square', 1\n" +
                "UNION SELECT NULL, 'tree', 1\n" +
                "UNION SELECT NULL, 'triangle', 1");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        android.util.Log.w("ReadingComprehensionData", "Upgrading database, which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS ReadingComprehensionData");
        onCreate(getWritableDatabase());
    }

    /**
     * Returns an array of four String objects randomly chosen from the database based on the level passed
     *
     * @param level the level of difficulty that the user is currently at
     * @return a random String array of four objects of the level specified
     */
    public String[] getData(int level)
    {
        data.clear();
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
