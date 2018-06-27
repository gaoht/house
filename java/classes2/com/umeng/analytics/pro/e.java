package com.umeng.analytics.pro;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.io.File;

public class e
  extends ContextWrapper
{
  private String a;
  
  public e(Context paramContext, String paramString)
  {
    super(paramContext);
    this.a = paramString;
  }
  
  public File getDatabasePath(String paramString)
  {
    paramString = new File(this.a + paramString);
    if ((!paramString.getParentFile().exists()) && (!paramString.getParentFile().isDirectory())) {
      paramString.getParentFile().mkdirs();
    }
    return paramString;
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(paramString).getAbsolutePath(), paramCursorFactory);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */