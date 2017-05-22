package madhushala.hisabkitab;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by eSushant on 5/22/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    //We need to make a database when this class is created to do so execute the following SQL command::
    // create table contacts( id integer primary key, name text,phone text,email text, street text,place text)
    // This is a raw sql command. We can call it using execSQL method
    public void onCreate(SQLiteDatabase db) {
        db.execSQL
                (
                        "create table contacts " + "(id integer primary key, name text,phone text,email text, street text,place text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int numberOfDatas() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numofRows = (int) DatabaseUtils.queryNumEntries(db, "hisabkitab.db");
        //DatabaseUtils is a module to play with databse. we should include it in header as well to use
        // Here we use queryNumEntries method of DatabaseUtils to get number of datas in our database file
        return numofRows;
    }
}
