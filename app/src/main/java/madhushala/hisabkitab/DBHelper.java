package madhushala.hisabkitab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by eSushant on 5/22/2017.
 */

public class DBHelper extends SQLiteOpenHelper
{
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }



    @Override
<<<<<<< Temporary merge branch 1
    //We need to maken a database when this class is created to do so execute the following SQL command::
=======
    //We need to make a database when this class is created to do so execute the following SQL command::
>>>>>>> Temporary merge branch 2
    // create table contacts( id integer primary key, name text,phone text,email text, street text,place text)
    // This is a raw sql command. We can call it using execSQL method
    public void onCreate(SQLiteDatabase db) {
        db.execSQL
    (
       "create table contacts " +"(id integer primary key, name text,phone text,email text, street text,place text)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
