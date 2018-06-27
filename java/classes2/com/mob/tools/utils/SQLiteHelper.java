package com.mob.tools.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class SQLiteHelper
{
  public static void close(SingleTableDB paramSingleTableDB)
  {
    paramSingleTableDB.close();
  }
  
  public static int delete(SingleTableDB paramSingleTableDB, String paramString, String[] paramArrayOfString)
    throws Throwable
  {
    paramSingleTableDB.open();
    return paramSingleTableDB.db.delete(paramSingleTableDB.getName(), paramString, paramArrayOfString);
  }
  
  public static void execSQL(SingleTableDB paramSingleTableDB, String paramString)
    throws Throwable
  {
    paramSingleTableDB.open();
    paramSingleTableDB.db.beginTransaction();
    try
    {
      paramSingleTableDB.db.execSQL(paramString);
      paramSingleTableDB.db.setTransactionSuccessful();
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
    finally
    {
      paramSingleTableDB.db.endTransaction();
    }
  }
  
  public static SingleTableDB getDatabase(Context paramContext, String paramString)
  {
    return getDatabase(paramContext.getDatabasePath(paramString).getPath(), paramString);
  }
  
  public static SingleTableDB getDatabase(String paramString1, String paramString2)
  {
    return new SingleTableDB(paramString1, paramString2, null);
  }
  
  /* Error */
  public static int getSize(SingleTableDB paramSingleTableDB)
    throws Throwable
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokestatic 26	com/mob/tools/utils/SQLiteHelper$SingleTableDB:access$100	(Lcom/mob/tools/utils/SQLiteHelper$SingleTableDB;)V
    //   6: aload_0
    //   7: invokestatic 30	com/mob/tools/utils/SQLiteHelper$SingleTableDB:access$300	(Lcom/mob/tools/utils/SQLiteHelper$SingleTableDB;)Landroid/database/sqlite/SQLiteDatabase;
    //   10: aload_0
    //   11: invokestatic 34	com/mob/tools/utils/SQLiteHelper$SingleTableDB:access$200	(Lcom/mob/tools/utils/SQLiteHelper$SingleTableDB;)Ljava/lang/String;
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokevirtual 80	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_0
    //   24: aload_0
    //   25: ifnonnull +17 -> 42
    //   28: iconst_0
    //   29: istore_1
    //   30: aload_0
    //   31: ifnull +9 -> 40
    //   34: aload_0
    //   35: invokeinterface 84 1 0
    //   40: iload_1
    //   41: ireturn
    //   42: aload_0
    //   43: astore_2
    //   44: aload_0
    //   45: invokeinterface 88 1 0
    //   50: istore_1
    //   51: goto -21 -> 30
    //   54: astore_3
    //   55: aconst_null
    //   56: astore_0
    //   57: aload_0
    //   58: astore_2
    //   59: aload_3
    //   60: athrow
    //   61: astore_0
    //   62: aload_2
    //   63: ifnull +9 -> 72
    //   66: aload_2
    //   67: invokeinterface 84 1 0
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: goto -13 -> 62
    //   78: astore_3
    //   79: goto -22 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramSingleTableDB	SingleTableDB
    //   29	22	1	i	int
    //   1	66	2	localSingleTableDB	SingleTableDB
    //   54	6	3	localThrowable1	Throwable
    //   78	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   6	24	54	java/lang/Throwable
    //   44	51	61	finally
    //   59	61	61	finally
    //   6	24	74	finally
    //   44	51	78	java/lang/Throwable
  }
  
  public static long insert(SingleTableDB paramSingleTableDB, ContentValues paramContentValues)
    throws Throwable
  {
    paramSingleTableDB.open();
    return paramSingleTableDB.db.replace(paramSingleTableDB.getName(), null, paramContentValues);
  }
  
  public static Cursor query(SingleTableDB paramSingleTableDB, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
    throws Throwable
  {
    paramSingleTableDB.open();
    return paramSingleTableDB.db.query(paramSingleTableDB.getName(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
  }
  
  public static Cursor rawQuery(SingleTableDB paramSingleTableDB, String paramString, String[] paramArrayOfString)
    throws Throwable
  {
    paramSingleTableDB.open();
    return paramSingleTableDB.db.rawQuery(paramString, paramArrayOfString);
  }
  
  public static int update(SingleTableDB paramSingleTableDB, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
    throws Throwable
  {
    paramSingleTableDB.open();
    return paramSingleTableDB.db.update(paramSingleTableDB.getName(), paramContentValues, paramString, paramArrayOfString);
  }
  
  public static class SingleTableDB
  {
    private SQLiteDatabase db;
    private HashMap<String, Boolean> fieldLimits;
    private LinkedHashMap<String, String> fieldTypes;
    private String name;
    private String path;
    private String primary;
    private boolean primaryAutoincrement;
    
    private SingleTableDB(String paramString1, String paramString2)
    {
      this.path = paramString1;
      this.name = paramString2;
      this.fieldTypes = new LinkedHashMap();
      this.fieldLimits = new HashMap();
    }
    
    private void close()
    {
      if (this.db != null)
      {
        this.db.close();
        this.db = null;
      }
    }
    
    private String getName()
    {
      return this.name;
    }
    
    private void open()
    {
      Object localObject1 = new File(this.path);
      Object localObject2;
      if ((this.db != null) && (!((File)localObject1).exists()))
      {
        this.db.close();
        localObject2 = ((File)localObject1).getParentFile();
        if (localObject2 != null) {
          ((File)localObject2).mkdirs();
        }
        this.db = null;
      }
      int i;
      if (this.db == null)
      {
        this.db = SQLiteDatabase.openOrCreateDatabase((File)localObject1, null);
        localObject1 = this.db.query("sqlite_master", null, "type=? and name=?", new String[] { "table", this.name }, null, null, null);
        if (localObject1 == null) {
          break label396;
        }
        if (((Cursor)localObject1).getCount() <= 0) {
          break label391;
        }
        i = 0;
        ((Cursor)localObject1).close();
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("create table  ").append(this.name).append("(");
          Iterator localIterator = this.fieldTypes.entrySet().iterator();
          if (localIterator.hasNext())
          {
            Object localObject3 = (Map.Entry)localIterator.next();
            localObject1 = (String)((Map.Entry)localObject3).getKey();
            localObject3 = (String)((Map.Entry)localObject3).getValue();
            boolean bool2 = ((Boolean)this.fieldLimits.get(localObject1)).booleanValue();
            boolean bool3 = ((String)localObject1).equals(this.primary);
            boolean bool1;
            if (bool3)
            {
              bool1 = this.primaryAutoincrement;
              label262:
              ((StringBuilder)localObject2).append((String)localObject1).append(" ").append((String)localObject3);
              if (!bool2) {
                break label337;
              }
              localObject1 = " not null";
              label288:
              ((StringBuilder)localObject2).append((String)localObject1);
              if (!bool3) {
                break label344;
              }
              localObject1 = " primary key";
              label305:
              ((StringBuilder)localObject2).append((String)localObject1);
              if (!bool1) {
                break label351;
              }
            }
            label337:
            label344:
            label351:
            for (localObject1 = " autoincrement,";; localObject1 = ",")
            {
              ((StringBuilder)localObject2).append((String)localObject1);
              break;
              bool1 = false;
              break label262;
              localObject1 = "";
              break label288;
              localObject1 = "";
              break label305;
            }
          }
          ((StringBuilder)localObject2).replace(((StringBuilder)localObject2).length() - 1, ((StringBuilder)localObject2).length(), ");");
          this.db.execSQL(((StringBuilder)localObject2).toString());
        }
        return;
        label391:
        i = 1;
        break;
        label396:
        i = 1;
      }
    }
    
    public void addField(String paramString1, String paramString2, boolean paramBoolean)
    {
      if (this.db == null)
      {
        this.fieldTypes.put(paramString1, paramString2);
        this.fieldLimits.put(paramString1, Boolean.valueOf(paramBoolean));
      }
    }
    
    public void setPrimary(String paramString, boolean paramBoolean)
    {
      this.primary = paramString;
      this.primaryAutoincrement = paramBoolean;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/utils/SQLiteHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */