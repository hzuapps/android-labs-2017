package edu.hzuapps.androidlabs.homeworks.net1414080903226;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Net1414080903226DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 13;
    public static final String DATABASE_NAME = "database.db";
    public static final String TABLE_BLOCK = "block";
    public static final String TABLE_SAVE = "save";
    public static final String TABLE_SEED = "seed";
    public static final String TABLE_STEVE = "steve";

    public static final String SAVE_PREFIX = "world_";

    private static final String SQL_CREATE_BLOCK =
            "CREATE TABLE " + TABLE_BLOCK + " (" +
                    "chunkX INTEGER," +
                    "chunkY INTEGER," +
                    "chunkZ INTEGER," +
                    "blockX INTEGER," +
                    "blockY INTEGER," +
                    "blockZ INTEGER," +
                    "blockType INTEGER," +
                    "PRIMARY KEY(blockX, blockY, blockZ));";

    private static final String SQL_CREATE_SEED =
            "CREATE TABLE " + TABLE_SEED + " (" +
                    "seed INTEGER PRIMARY KEY);";

    private static final String SQL_CREATE_SAVE =
            "CREATE TABLE " + TABLE_SAVE + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "seed INTEGER," +
                    "date TEXT," +
                    "x INTEGER," +
                    "y INTEGER," +
                    "z INTEGER);";

    private static final String SQL_CREATE_STEVE =
            "CREATE TABLE " + TABLE_STEVE + " (" +
                    "x INTEGER," +
                    "y INTEGER," +
                    "z INTEGER," +
                    "PRIMARY KEY(x, y, z));";

    public static final String SQL_DROP_TABLE =
            "DROP TABLE IF EXISTS ";

    private static Net1414080903226DBHelper instance = null;

    private static Context context = null;

    public static void setContext(Context c){
        context = c;
    }

    public synchronized static Net1414080903226DBHelper getInstance(){
        if (instance == null) {
            instance = new Net1414080903226DBHelper(context);
        }
        return instance;
    }

    private Net1414080903226DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_BLOCK);
        db.execSQL(SQL_CREATE_SEED);
        db.execSQL(SQL_CREATE_SAVE);
        db.execSQL(SQL_CREATE_STEVE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DROP_TABLE + TABLE_BLOCK);
        db.execSQL(SQL_DROP_TABLE + TABLE_SEED);
        db.execSQL(SQL_DROP_TABLE + TABLE_SAVE);
        db.execSQL(SQL_DROP_TABLE + TABLE_STEVE);
        onCreate(db);
    }