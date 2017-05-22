package madhushala.hisabkitab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

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


    //This function will add a new row of data in the database

    public boolean insertRow(String name, String amount) {

        SQLiteDatabase db = this.getWritableDatabase(); //Lets make a SQLiteDatabase object to use within this fuction
        ContentValues contentValues = new ContentValues(); //ContentValues class can store label-value pair
        return true; //This is a boolean. will return 1 if success
    }


    public boolean updateRow(Integer id, String name, String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("amount", amount);
        db.update("contacts", contentValues, "id = ? ", new String[]{Integer.toString(id)});
        return true;
    }



    public Integer deleteRow (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("contacts",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }


    //Function to return all data as a arraylist datatype
    public ArrayList<String> getAllRows() {
        ArrayList<String> dataarray = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor alldata =  db.rawQuery( "select * from contacts", null );
        alldata.moveToFirst();

        while(alldata.isAfterLast() == false){
            dataarray.add(alldata.getString(alldata.getColumnIndex("name")));
            alldata.moveToNext();
        } //this loops adds all rows to our array variable
        return dataarray;
    }
}


