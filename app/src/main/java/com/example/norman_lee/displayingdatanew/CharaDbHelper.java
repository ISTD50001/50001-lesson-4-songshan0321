package com.example.norman_lee.displayingdatanew;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.example.norman_lee.displayingdatanew.CharaContract;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by norman_lee on 6/10/17.
 */

public class CharaDbHelper extends SQLiteOpenHelper {


    private final Context context;
    private static String PACKAGE_NAME;
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase sqLiteDatabase;
    private SQLiteDatabase readableDb;
    private SQLiteDatabase writeableDb;
    private static CharaDbHelper charaDbHelper;

    //TODO 7.4 Create the Constructor and make it a singleton
    CharaDbHelper(Context context){
        super(context, CharaContract.CharaEntry.TABLE_NAME, null, DATABASE_VERSION );
        this.context = context;
    }

    //TODO 7.5 Complete onCreate. You may make use of fillTable below
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    //TODO 7.6 Complete onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //TODO 7.5 --- written for you
    private void fillTable(SQLiteDatabase sqLiteDatabase){

        ArrayList<CharaData> arrayList = new ArrayList<>();
        PACKAGE_NAME = context.getPackageName();

        //open the Json file pictures stored in the res/raw folder
        InputStream inputStream = context.getResources().openRawResource(R.raw.pictures);
        String string = Utils.convertStreamToString(inputStream);

        //parse the Json file and store data in the ArrayList using the CharaData class
        try{
            JSONArray jsonArray = new JSONArray(string);
            for(int i = 0; i <= jsonArray.length(); i++){
                String name = jsonArray.getJSONObject(i).getString("name");
                String description = jsonArray.getJSONObject(i).getString("description");
                String file = jsonArray.getJSONObject(i).getString("file");

                arrayList.add(new CharaDbHelper.CharaData(name, description, file));
            }
        }catch(JSONException e){
            e.printStackTrace();
        }

        //Each entry in the arrayList is stored as a ContentValues object
        //Then this ContentValues object is inserted to the sqLiteDatabase to create a new row
        for(int i = 0; i< arrayList.size(); i++){
            Log.i("Norman","" + arrayList.get(i).getDescription());
            ContentValues cv = new ContentValues();

            cv.put(CharaContract.CharaEntry.COL_NAME, arrayList.get(i).getName());
            cv.put(CharaContract.CharaEntry.COL_DESCRIPTION, arrayList.get(i).getDescription());

            String fname = arrayList.get(i).getFile();
            int resId = context.getResources().getIdentifier(fname, "drawable", PACKAGE_NAME);
            Drawable drawable = context.getResources().getDrawable(resId);
            Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] bitMapData = stream.toByteArray();

            cv.put(CharaContract.CharaEntry.COL_FILE,bitMapData);

            sqLiteDatabase.insert(CharaContract.CharaEntry.TABLE_NAME,null,cv);
        }

        Cursor cursor = sqLiteDatabase.rawQuery(CharaContract.CharaSql.SQL_QUERY_ALL_ROWS, null);
        Log.i("Norman","Table Filled. Rows = " + cursor.getCount());


    }

    //TODO 7.8 query one row at random
    public CharaData queryOneRowRandom(){

        return new CharaData("","","");

    }

    //TODO 7.9 queryOneRow gets the entire database and returns the row in position as a CharaData object
    public CharaData queryOneRow(int position){

        return new CharaData("","","");

    }

    //TODO 7.8 Get the data from cursor
    private CharaData getDataFromCursor(int position, Cursor cursor){

        String name=null;
        String description =null;
        Bitmap bitmap =null;

        return new CharaData(name, description, bitmap);
    }

    //TODO 7.10 Insert one row when data is passed to it
    public void insertOneRow(CharaData charaData){

    }


    //TODO 7.11 Delete one row given the name field
    public int deleteOneRow(String name){
        return 0;
    }

    //TODO 7.7 return the number of rows in the database
    public long queryNumRows(){
        return 0;
    }

    public Context getContext(){
        return context;
    }


    //TODO 7.3 Create a model class to represent our data
    static class CharaData{

        private String name;
        private String description;
        private String file;
        private Bitmap bitmap;

        public CharaData(String name, String description, String file) {
            this.name = name;
            this.description = description;
            this.file = file;
        }

        public CharaData( String name, String description, Bitmap bitmap){
            this.name = name;
            this.description = description;
            this.bitmap = bitmap;
        }

        public Bitmap getBitmap() {
            return bitmap;
        }

        public String getDescription() {
            return description;
        }

        public String getFile() {
            return file;
        }

        public String getName() {
            return name;
        }
    }

}
