package csc315.com.todolist;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

import android.content.Context;
import android.content.ContentValues;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME="toDoListDB.db";
    public static final String TABLE_TODOLIST = "todolist";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TASK = "task";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TODOLIST_TABLE = "CREATE TABLE " + TABLE_TODOLIST + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_TASK + " TEXT," + ")";
        db.execSQL(CREATE_TODOLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODOLIST);
        onCreate(db);
    }

    public void addTask(Task task) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TASK, task.getTask());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_TODOLIST, null, values);
        db.close();
    }

}

