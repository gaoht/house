package com.facebook.imagepipeline.producers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import b.j;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.CacheKeyUtil;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.MediaVariations.Variant;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class MediaVariationsIndexDatabase
  implements MediaVariationsIndex
{
  private static final String[] PROJECTION = { "cache_key", "width", "height" };
  private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS media_variations_index";
  private static final String TAG = MediaVariationsIndexDatabase.class.getSimpleName();
  private final LazyIndexDbOpenHelper mDbHelper;
  private final Executor mReadExecutor;
  private final Executor mWriteExecutor;
  
  public MediaVariationsIndexDatabase(Context paramContext, Executor paramExecutor1, Executor paramExecutor2)
  {
    this.mDbHelper = new LazyIndexDbOpenHelper(paramContext, null);
    this.mReadExecutor = paramExecutor1;
    this.mWriteExecutor = paramExecutor2;
  }
  
  /* Error */
  private List<MediaVariations.Variant> getCachedVariantsSync(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 61	com/facebook/imagepipeline/producers/MediaVariationsIndexDatabase:mDbHelper	Lcom/facebook/imagepipeline/producers/MediaVariationsIndexDatabase$LazyIndexDbOpenHelper;
    //   9: invokevirtual 80	com/facebook/imagepipeline/producers/MediaVariationsIndexDatabase$LazyIndexDbOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore 7
    //   14: aload 7
    //   16: ldc 82
    //   18: getstatic 51	com/facebook/imagepipeline/producers/MediaVariationsIndexDatabase:PROJECTION	[Ljava/lang/String;
    //   21: ldc 84
    //   23: iconst_1
    //   24: anewarray 43	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: aload_1
    //   30: aastore
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokevirtual 90	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore 6
    //   39: aload 6
    //   41: astore 5
    //   43: aload 5
    //   45: invokeinterface 96 1 0
    //   50: istore_2
    //   51: iload_2
    //   52: ifne +26 -> 78
    //   55: aload 5
    //   57: ifnull +10 -> 67
    //   60: aload 5
    //   62: invokeinterface 99 1 0
    //   67: aload 7
    //   69: invokevirtual 100	android/database/sqlite/SQLiteDatabase:close	()V
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: areturn
    //   78: aload 5
    //   80: ldc 45
    //   82: invokeinterface 104 2 0
    //   87: istore_2
    //   88: aload 5
    //   90: ldc 47
    //   92: invokeinterface 104 2 0
    //   97: istore_3
    //   98: aload 5
    //   100: ldc 49
    //   102: invokeinterface 104 2 0
    //   107: istore 4
    //   109: new 106	java/util/ArrayList
    //   112: dup
    //   113: aload 5
    //   115: invokeinterface 96 1 0
    //   120: invokespecial 109	java/util/ArrayList:<init>	(I)V
    //   123: astore 6
    //   125: aload 5
    //   127: invokeinterface 113 1 0
    //   132: ifeq +97 -> 229
    //   135: aload 6
    //   137: new 115	com/facebook/imagepipeline/request/MediaVariations$Variant
    //   140: dup
    //   141: aload 5
    //   143: iload_2
    //   144: invokeinterface 119 2 0
    //   149: invokestatic 125	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   152: aload 5
    //   154: iload_3
    //   155: invokeinterface 129 2 0
    //   160: aload 5
    //   162: iload 4
    //   164: invokeinterface 129 2 0
    //   169: invokespecial 132	com/facebook/imagepipeline/request/MediaVariations$Variant:<init>	(Landroid/net/Uri;II)V
    //   172: invokeinterface 138 2 0
    //   177: pop
    //   178: goto -53 -> 125
    //   181: astore 6
    //   183: getstatic 41	com/facebook/imagepipeline/producers/MediaVariationsIndexDatabase:TAG	Ljava/lang/String;
    //   186: aload 6
    //   188: ldc -116
    //   190: iconst_1
    //   191: anewarray 4	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload_1
    //   197: aastore
    //   198: invokestatic 146	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: aload 6
    //   203: athrow
    //   204: astore_1
    //   205: aload 5
    //   207: ifnull +10 -> 217
    //   210: aload 5
    //   212: invokeinterface 99 1 0
    //   217: aload 7
    //   219: invokevirtual 100	android/database/sqlite/SQLiteDatabase:close	()V
    //   222: aload_1
    //   223: athrow
    //   224: astore_1
    //   225: aload_0
    //   226: monitorexit
    //   227: aload_1
    //   228: athrow
    //   229: aload 5
    //   231: ifnull +10 -> 241
    //   234: aload 5
    //   236: invokeinterface 99 1 0
    //   241: aload 7
    //   243: invokevirtual 100	android/database/sqlite/SQLiteDatabase:close	()V
    //   246: aload 6
    //   248: astore_1
    //   249: goto -175 -> 74
    //   252: astore_1
    //   253: aconst_null
    //   254: astore 5
    //   256: goto -51 -> 205
    //   259: astore_1
    //   260: goto -55 -> 205
    //   263: astore 6
    //   265: goto -82 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	MediaVariationsIndexDatabase
    //   0	268	1	paramString	String
    //   50	94	2	i	int
    //   97	58	3	j	int
    //   107	56	4	k	int
    //   1	254	5	localObject1	Object
    //   37	99	6	localObject2	Object
    //   181	66	6	localSQLException1	android.database.SQLException
    //   263	1	6	localSQLException2	android.database.SQLException
    //   12	230	7	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   43	51	181	android/database/SQLException
    //   78	125	181	android/database/SQLException
    //   125	178	181	android/database/SQLException
    //   183	204	204	finally
    //   5	14	224	finally
    //   60	67	224	finally
    //   67	72	224	finally
    //   210	217	224	finally
    //   217	224	224	finally
    //   234	241	224	finally
    //   241	246	224	finally
    //   14	39	252	finally
    //   43	51	259	finally
    //   78	125	259	finally
    //   125	178	259	finally
    //   14	39	263	android/database/SQLException
  }
  
  public j<List<MediaVariations.Variant>> getCachedVariants(final String paramString)
  {
    try
    {
      j localj = j.call(new Callable()
      {
        public List<MediaVariations.Variant> call()
          throws Exception
        {
          return MediaVariationsIndexDatabase.this.getCachedVariantsSync(paramString);
        }
      }, this.mReadExecutor);
      return localj;
    }
    catch (Exception localException)
    {
      FLog.w(TAG, localException, "Failed to schedule query task for %s", new Object[] { paramString });
      return j.forError(localException);
    }
  }
  
  public void saveCachedVariant(final String paramString, final CacheKey paramCacheKey, final EncodedImage paramEncodedImage)
  {
    this.mWriteExecutor.execute(new Runnable()
    {
      public void run()
      {
        SQLiteDatabase localSQLiteDatabase = MediaVariationsIndexDatabase.this.mDbHelper.getWritableDatabase();
        try
        {
          localSQLiteDatabase.beginTransaction();
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("media_id", paramString);
          localContentValues.put("width", Integer.valueOf(paramEncodedImage.getWidth()));
          localContentValues.put("height", Integer.valueOf(paramEncodedImage.getHeight()));
          localContentValues.put("cache_key", paramCacheKey.getUriString());
          localContentValues.put("resource_id", CacheKeyUtil.getFirstResourceId(paramCacheKey));
          localSQLiteDatabase.insertOrThrow("media_variations_index", null, localContentValues);
          localSQLiteDatabase.setTransactionSuccessful();
          return;
        }
        catch (Exception localException)
        {
          FLog.e(MediaVariationsIndexDatabase.TAG, localException, "Error writing for %s", new Object[] { paramString });
          return;
        }
        finally
        {
          localSQLiteDatabase.endTransaction();
        }
      }
    });
  }
  
  private static class IndexDbOpenHelper
    extends SQLiteOpenHelper
  {
    public static final String DATABASE_NAME = "FrescoMediaVariationsIndex.db";
    public static final int DATABASE_VERSION = 1;
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE media_variations_index (_id INTEGER PRIMARY KEY,media_id TEXT,width INTEGER,height INTEGER,cache_key TEXT,resource_id TEXT )";
    private static final String SQL_CREATE_INDEX = "CREATE INDEX index_media_id ON media_variations_index (media_id)";
    private static final String TEXT_TYPE = " TEXT";
    
    public IndexDbOpenHelper(Context paramContext)
    {
      super("FrescoMediaVariationsIndex.db", null, 1);
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.beginTransaction();
      try
      {
        paramSQLiteDatabase.execSQL("CREATE TABLE media_variations_index (_id INTEGER PRIMARY KEY,media_id TEXT,width INTEGER,height INTEGER,cache_key TEXT,resource_id TEXT )");
        paramSQLiteDatabase.execSQL("CREATE INDEX index_media_id ON media_variations_index (media_id)");
        paramSQLiteDatabase.setTransactionSuccessful();
        return;
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
    }
    
    public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      onUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      paramSQLiteDatabase.beginTransaction();
      try
      {
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS media_variations_index");
        paramSQLiteDatabase.setTransactionSuccessful();
        return;
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
    }
  }
  
  private static final class IndexEntry
    implements BaseColumns
  {
    public static final String COLUMN_NAME_CACHE_KEY = "cache_key";
    public static final String COLUMN_NAME_HEIGHT = "height";
    public static final String COLUMN_NAME_MEDIA_ID = "media_id";
    public static final String COLUMN_NAME_RESOURCE_ID = "resource_id";
    public static final String COLUMN_NAME_WIDTH = "width";
    public static final String TABLE_NAME = "media_variations_index";
  }
  
  private static class LazyIndexDbOpenHelper
  {
    private final Context mContext;
    @Nullable
    private MediaVariationsIndexDatabase.IndexDbOpenHelper mIndexDbOpenHelper;
    
    private LazyIndexDbOpenHelper(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public SQLiteDatabase getWritableDatabase()
    {
      try
      {
        if (this.mIndexDbOpenHelper == null) {
          this.mIndexDbOpenHelper = new MediaVariationsIndexDatabase.IndexDbOpenHelper(this.mContext);
        }
        SQLiteDatabase localSQLiteDatabase = this.mIndexDbOpenHelper.getWritableDatabase();
        return localSQLiteDatabase;
      }
      finally {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/MediaVariationsIndexDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */