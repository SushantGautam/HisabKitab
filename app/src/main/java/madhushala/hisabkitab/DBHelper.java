package madhushala.hisabkitab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
                        "create table contacts " + "(id integer primary key, name text,amount text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //This function will add a new row of data in the database
    public boolean insertRow(String name, String amount) {

        SQLiteDatabase db = this.getWritableDatabase(); //Lets make a SQLiteDatabase object to use within this fuction
        ContentValues contentValues = new ContentValues(); //ContentValues class can store label-value pair
        contentValues.put("name", name);
        contentValues.put("amount", amount);
        db.insert("contacts", null, contentValues); //This inserts the line
        return true; //This is a boolean. will return 1 if success
    }

    //Get all data from database using this function
    // Cursor class  interface provides random read-write access to the result set returned by a database query.
    //We can retrieve anything from database using an object of the Cursor class.
    // We will call a method of this class called rawQuery and
    // it will return a resultset with the cursor pointing to the table.
    // We can move the cursor forward and retrieve the data.
    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();  //getReadableDatabase is a method of SQLiteOpenHelper
        // Thats why we used it to derive a class
        Cursor data = db.rawQuery("select * from contacts where id=" + id + "", null); //The same rawquery as in oncreate method
        return data; //finally it will return the data with given id as parameter
    }



}
