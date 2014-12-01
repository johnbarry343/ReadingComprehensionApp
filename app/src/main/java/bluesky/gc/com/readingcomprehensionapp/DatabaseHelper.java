package bluesky.gc.com.readingcomprehensionapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.DateFormat;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static DatabaseHelper mInstance = null;

    public static final String WORD = "numberCorrect";
    public static final String IMAGE = "numberIncorrect";
    public static final String SOUND = "db";
    public static final String TABLE = "data";
    public static final String ID = "_id";
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
    public void onCreate(SQLiteDatabase db)
    {
        android.util.Log.i("onCreate", "Creating Database");

        db.execSQL("CREATE TABLE " + TABLE
                + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + WORD
                + " TEXT, " + IMAGE + " INTEGER, " + SOUND
                + " INTEGER);");
    }

    public void recordScore(int numberCorrect, int numberIncorrect)
    {
        ContentValues cv = new ContentValues();

        cv.put(DATE, DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM).format(new Date()));
        cv.put(NUMBER_CORRECT, numberCorrect);
        cv.put(NUMBER_INCORRECT, numberIncorrect);
        getWritableDatabase().insert(TABLE, DATE, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        android.util.Log.w("Constants", "Upgrading database, which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS constants");
        onCreate(getWritableDatabase());
    }
}
