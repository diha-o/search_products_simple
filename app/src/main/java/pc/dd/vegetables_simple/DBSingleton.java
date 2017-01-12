package pc.dd.vegetables_simple;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import javax.annotation.Resource;

/**
 * Created by User on 12.01.2017.
 */

public final class DBSingleton{

    private static DBSingleton mInstance = null;

    static DBHelper helper;
    static SQLiteDatabase database;

    private DBSingleton(Context context){
        helper = new DBHelper(context);
    }

    public static DBSingleton getInstance(Context context){
        if(mInstance == null)
        {
            mInstance = new DBSingleton(context);
        }
        return mInstance;
    }

    private void open (){
        database = helper.getWritableDatabase();
    }

    public void close(){
        database.close();
    }
    public void addDatatoDatabase(String photo_url,String name,String description,Context c){
        open();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("description",description);
        cv.put("photo_url",photo_url);
        //add to bd
        long id = database.insert("di", null, cv);
        if (id!= -1){
            Toast.makeText(c,"Added to your list",Toast.LENGTH_SHORT).show();
        }else Toast.makeText(c,"Error! Can't add.",Toast.LENGTH_LONG).show();
        // close bd
        close();
    }
    public Cursor readFromDatabase(){
        open();
        Cursor c = database.query("di", null, null, null, null, null, null);
        return c;
    }
}
