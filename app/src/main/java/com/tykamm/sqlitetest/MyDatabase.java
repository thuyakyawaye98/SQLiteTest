package com.tykamm.sqlitetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "Student.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public long saveStudentData(String name,String password)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues myValues=new ContentValues();
        myValues.put("Name",name);
        myValues.put("Password",password);
        return db.insert("Student",null,myValues);
    }

    public String loadStudentData(){
        SQLiteDatabase db=getReadableDatabase();
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();
        qb.setTables("Student");
        StringBuilder sb=new StringBuilder();
        Cursor cursor=qb.query(db,null,null,null,null,null,null);
        while (cursor.moveToNext()){
            sb.append(cursor.getInt(0)+"\t");
            sb.append(cursor.getString(1)+"\t");
            sb.append(cursor.getString(2)+"\n");
        }
        return sb.toString();
    }
    public int updateStudent(String name,String password){
        SQLiteDatabase db=getWritableDatabase();
        String where="Id=?";
        String whereArgs[]=new String[]{String.valueOf(1)};
        ContentValues myValues=new ContentValues();
        myValues.put("Name",name);
        myValues.put("Password",password);
        return db.update("Student",myValues,where,whereArgs);
    }

    public  int deleteStudent(){
        SQLiteDatabase db=getWritableDatabase();
        String where="Id=?";
        String whereArgs[]=new String[]{String.valueOf(1)};
        return  db.delete("Student",where,whereArgs);
    }
}