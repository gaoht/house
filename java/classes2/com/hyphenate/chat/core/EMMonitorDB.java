package com.hyphenate.chat.core;

import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.hyphenate.util.EMLog;
import com.hyphenate.util.EasyUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EMMonitorDB
{
  private static final String a = "EMMonitorDB";
  private static final int b = 1;
  private static final String c = "monitor.db";
  private static final String e = "apps";
  private static final String f = "appname";
  private static final String g = "create table apps (appname text primary key);";
  private EMMonitorDBHelper d = null;
  
  public EMMonitorDB()
  {
    try
    {
      String str = Environment.getExternalStorageDirectory() + "/emlibs/libs";
      this.d = new EMMonitorDBHelper(EMClient.getInstance().getContext(), "monitor.db", 1, str);
      return;
    }
    catch (Exception localException)
    {
      EMLog.d("EMMonitorDB", localException.getMessage());
    }
  }
  
  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (this.d != null)
      {
        Cursor localCursor = this.d.getReadableDatabase().rawQuery("select * from apps", null);
        if (localCursor != null) {
          while (localCursor.moveToNext()) {
            localArrayList.add(localCursor.getString(localCursor.getColumnIndex("appname")));
          }
        }
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      EMLog.e("EMMonitorDB", localException.toString());
    }
    localException.close();
    return localArrayList;
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.d != null)
      {
        SQLiteDatabase localSQLiteDatabase = this.d.getWritableDatabase();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("appname", paramString);
        localSQLiteDatabase.replace("apps", null, localContentValues);
      }
      return;
    }
    catch (Exception paramString)
    {
      EMLog.e("EMMonitorDB", paramString.toString());
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      if (this.d != null) {
        this.d.getWritableDatabase().delete("apps", "appname = ?", new String[] { paramString });
      }
      return;
    }
    catch (Exception paramString)
    {
      EMLog.e("EMMonitorDB", paramString.toString());
    }
  }
  
  private static class EMMonitorDBHelper
    extends SQLiteOpenHelper
  {
    public EMMonitorDBHelper(Context paramContext, String paramString1, int paramInt, String paramString2)
      throws HyphenateException
    {
      super(paramString1, null, paramInt);
    }
    
    private static EMMonitorDB.a getCustomContext(Context paramContext, String paramString)
      throws HyphenateException
    {
      if (!EasyUtils.isSDCardExist()) {
        throw new HyphenateException("sd card not exist");
      }
      return new EMMonitorDB.a(paramContext, paramString);
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("create table apps (appname text primary key);");
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  }
  
  private static class a
    extends ContextWrapper
  {
    private String dirPath;
    
    public a(Context paramContext, String paramString)
    {
      super();
      this.dirPath = paramString;
    }
    
    public File getDatabasePath(String paramString)
    {
      paramString = new File(this.dirPath + File.separator + paramString);
      if (!paramString.getParentFile().exists()) {
        paramString.getParentFile().mkdirs();
      }
      return paramString;
    }
    
    public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
    {
      return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(paramString), paramCursorFactory);
    }
    
    public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
    {
      return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(paramString).getAbsolutePath(), paramCursorFactory, paramDatabaseErrorHandler);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/core/EMMonitorDB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */