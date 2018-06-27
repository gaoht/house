package com.ziroom.ziroomcustomer.ziroomstation.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.util.Log;
import com.ziroom.ziroomcustomer.ziroomstation.model.ImageBucket;
import com.ziroom.ziroomcustomer.ziroomstation.model.ImageItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class g
{
  private static g b;
  boolean a = false;
  private Context c;
  private HashMap<String, ImageBucket> d = new HashMap();
  private HashMap<String, String> e = new HashMap();
  
  private g() {}
  
  private g(Context paramContext)
  {
    this.c = paramContext;
  }
  
  private void a()
  {
    do
    {
      for (;;)
      {
        try
        {
          l1 = System.currentTimeMillis();
          b();
          localCursor = this.c.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "bucket_id", "_data", "bucket_display_name" }, null, null, null);
        }
        finally
        {
          long l1;
          int i;
          int j;
          int k;
          int m;
          String str1;
          String str2;
          Object localObject3;
          String str3;
          ImageBucket localImageBucket;
          long l2;
          Cursor localCursor = null;
          localCursor.close();
        }
        try
        {
          if (!localCursor.moveToFirst()) {
            continue;
          }
          i = localCursor.getColumnIndexOrThrow("_id");
          j = localCursor.getColumnIndexOrThrow("_data");
          k = localCursor.getColumnIndexOrThrow("bucket_display_name");
          m = localCursor.getColumnIndexOrThrow("bucket_id");
          str1 = localCursor.getString(i);
          str2 = localCursor.getString(j);
          localObject3 = localCursor.getString(k);
          str3 = localCursor.getString(m);
          localImageBucket = (ImageBucket)this.d.get(str3);
          if (localImageBucket != null) {
            break label352;
          }
          localImageBucket = new ImageBucket();
          this.d.put(str3, localImageBucket);
          localImageBucket.imageList = new ArrayList();
          localImageBucket.bucketName = ((String)localObject3);
        }
        finally
        {
          continue;
        }
      }
      localImageBucket.count += 1;
      localObject3 = new ImageItem();
      ((ImageItem)localObject3).imageId = str1;
      ((ImageItem)localObject3).sourcePath = str2;
      ((ImageItem)localObject3).thumbnailPath = ((String)this.e.get(str1));
      localImageBucket.imageList.add(localObject3);
    } while (localCursor.moveToNext());
    this.a = true;
    l2 = System.currentTimeMillis();
    Log.d(g.class.getName(), "use time: " + (l2 - l1) + " ms");
    localCursor.close();
  }
  
  private void a(Cursor paramCursor)
  {
    if (paramCursor.moveToFirst())
    {
      int i = paramCursor.getColumnIndex("image_id");
      int j = paramCursor.getColumnIndex("_data");
      do
      {
        int k = paramCursor.getInt(i);
        String str = paramCursor.getString(j);
        this.e.put("" + k, str);
      } while (paramCursor.moveToNext());
    }
  }
  
  private void b()
  {
    try
    {
      Cursor localCursor = this.c.getContentResolver().query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, new String[] { "image_id", "_data" }, null, null, null);
      localCursor.close();
    }
    finally
    {
      try
      {
        a(localCursor);
        localCursor.close();
        return;
      }
      finally {}
      localObject1 = finally;
      localCursor = null;
    }
    throw ((Throwable)localObject1);
  }
  
  public static g getInstance(Context paramContext)
  {
    if (b == null) {}
    try
    {
      b = new g(paramContext);
      return b;
    }
    finally {}
  }
  
  public List<ImageBucket> getImagesBucketList(boolean paramBoolean)
  {
    if ((paramBoolean) || ((!paramBoolean) && (!this.a))) {
      a();
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.d.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    return localArrayList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/utils/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */