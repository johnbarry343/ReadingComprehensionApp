package com.bluesky.readingcomprehensionapp;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static DatabaseHelper mInstance = null;
    private final Context mContext;

    private static final String WORD = "word";
    private static final String TABLE = "ReadingComprehensionData";
    private static final String LEVEL = "level";
    private static final String ID = "_id";
    private static final String DATABASE_NAME = "ReadingComprehensionData";
    private static final String DATABASE_PATH = "";
    private static final String DATABASE_VERSION = "1";

    private static final ArrayList<String> data = null;

    private static SQLiteCursor constantsCursor;
    private static String TAG = "DataBaseHelper"; // Tag just for the LogCat window
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
        this.mContext = ctx;
    }

    public void createDataBase() throws IOException
    {
        //If database not exists copy it from the assets

        boolean mDataBaseExist = checkDataBase();
        if(!mDataBaseExist)
        {
            this.getReadableDatabase();
            this.close();
            try
            {
                //Copy the database from assests
                copyDataBase();
                Log.e(TAG, "createDatabase database created");
            }
            catch (IOException mIOException)
            {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    //Check that the database exists here: /data/data/your package/databases/Da Name
    private boolean checkDataBase()
    {
        File dbFile = new File(DATABASE_PATH + DATABASE_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }

    //Copy the database from assets
    private void copyDataBase() throws IOException
    {
        InputStream mInput = mContext.getAssets().open(DATABASE_NAME);
        String outFileName = DATABASE_PATH + DATABASE_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer))>0)
        {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    //Open the database, so we can query it
    public boolean openDataBase() throws SQLException
    {
        String mPath = DATABASE_PATH + DATABASE_NAME;
        //Log.v("mPath", mPath);
        db = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return db != null;
    }


    @Override
    public synchronized void close()
    {
        if(db != null)
            db.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2)
    {

    }

    public static String[] getData(Context ctx, int level)
    {
        constantsCursor = (SQLiteCursor) DatabaseHelper.getInstance(ctx).getReadableDatabase().rawQuery("SELECT " + WORD + " FROM " + TABLE + " WHERE " + LEVEL + " = " + Integer.toString(level), null);
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
