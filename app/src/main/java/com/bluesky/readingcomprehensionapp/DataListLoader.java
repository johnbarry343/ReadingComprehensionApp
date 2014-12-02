package com.bluesky.readingcomprehensionapp;

import android.content.Context;
import android.database.sqlite.SQLiteCursor;

import java.util.Map;

public class DataListLoader
{
    private DatabaseHelper db;
    private static SQLiteCursor constantsCursor;
    private static Map<Integer, String> data;

    public static Map<Integer, String> getData(Context ctx)
    {
        constantsCursor = (SQLiteCursor) DatabaseHelper.getInstance(ctx).getReadableDatabase().rawQuery("SELECT " + DatabaseHelper.ID
                + ", "
                + DatabaseHelper.WORD
                + " FROM "
                + DatabaseHelper.TABLE + " ORDER BY " + DatabaseHelper.WORD, null);

        return data;
    }
}
