package com.baidu.trace;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

final class x
  extends SQLiteOpenHelper
{
  x(u paramu, Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, null, 1);
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */