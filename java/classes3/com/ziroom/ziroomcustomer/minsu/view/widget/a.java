package com.ziroom.ziroomcustomer.minsu.view.widget;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.text.TextUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"SimpleDateFormat"})
public class a
{
  private static a d;
  private static final String[] g = { "_id", "_data", "orientation" };
  private static final String[] h = { "_id", "_data" };
  final List<a> a = new ArrayList();
  final List<a> b = new ArrayList();
  final Map<String, List<a>> c = new HashMap();
  private int e;
  private String f;
  private Context i;
  private boolean j;
  private boolean k = false;
  
  private a(Context paramContext)
  {
    this.i = paramContext;
  }
  
  private String a(int paramInt, String paramString)
  {
    paramString = this.i.getContentResolver().query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, h, "image_id = ?", new String[] { paramInt + "" }, null);
    if (paramString.getCount() > 0)
    {
      paramString.moveToFirst();
      paramInt = paramString.getInt(0);
      String str = MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI.buildUpon().appendPath(Integer.toString(paramInt)).build().toString();
      paramString.close();
      return str;
    }
    paramString.close();
    return null;
  }
  
  public static a getInstance()
  {
    return d;
  }
  
  public static void init(Context paramContext)
  {
    d = new a(paramContext);
    new Thread(new Runnable()
    {
      public void run()
      {
        a.a().initImage();
      }
    }).start();
  }
  
  public void clear()
  {
    this.a.clear();
    this.e = 0;
    File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "ziroomminsu" + "/");
    if (localFile.exists()) {
      deleteFile(localFile);
    }
  }
  
  public void deleteFile(File paramFile)
  {
    if (paramFile.exists())
    {
      if (!paramFile.isFile()) {
        break label20;
      }
      paramFile.delete();
    }
    for (;;)
    {
      return;
      label20:
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.listFiles();
        int m = 0;
        while (m < paramFile.length)
        {
          deleteFile(paramFile[m]);
          m += 1;
        }
      }
    }
  }
  
  public String getCameraImgPath()
  {
    return this.f;
  }
  
  public List<a> getCheckedItems()
  {
    return this.a;
  }
  
  public int getCurrentSize()
  {
    return this.e;
  }
  
  public List<a> getFolder(String paramString)
  {
    return (List)this.c.get(paramString);
  }
  
  public Map<String, List<a>> getFolderMap()
  {
    return this.c;
  }
  
  public String getImageAbsolutePath(String paramString)
  {
    paramString = paramString.replace("file:///", "");
    if (new File(paramString).exists()) {
      return paramString;
    }
    paramString = Uri.parse(paramString);
    paramString = this.i.getContentResolver().query(paramString, g, null, null, "datetaken DESC");
    if (paramString == null) {
      return "";
    }
    if (paramString.moveToNext())
    {
      paramString.getInt(0);
      return paramString.getString(1);
    }
    return "";
  }
  
  public void initImage()
  {
    for (;;)
    {
      Cursor localCursor;
      Object localObject3;
      String str2;
      try
      {
        boolean bool = this.k;
        if (bool) {
          return;
        }
        this.k = true;
        if (isInited()) {
          continue;
        }
        localCursor = this.i.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, g, null, null, "datetaken DESC");
        if (localCursor == null) {
          continue;
        }
        if (!localCursor.moveToNext()) {
          break label313;
        }
        int m = localCursor.getInt(0);
        Object localObject1 = localCursor.getString(1);
        localObject3 = new File((String)localObject1);
        if (!((File)localObject3).exists()) {
          continue;
        }
        str2 = a(m, (String)localObject1);
        String str1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon().appendPath(Integer.toString(m)).build().toString();
        if (TextUtils.isEmpty(str1)) {
          continue;
        }
        localObject1 = str2;
        if (TextUtils.isEmpty(str2)) {
          localObject1 = str1;
        }
        str2 = ((File)localObject3).getParentFile().getName();
        localObject3 = new a();
        ((a)localObject3).setOriginalUri(str1);
        ((a)localObject3).setThumbnailUri((String)localObject1);
        int n = localCursor.getInt(2);
        m = n;
        if (n != 0) {
          m = n + 180;
        }
        ((a)localObject3).setOrientation(360 - m);
        this.b.add(localObject3);
        if (this.c.containsKey(str2))
        {
          ((List)this.c.get(str2)).add(localObject3);
          continue;
        }
        localArrayList = new ArrayList();
      }
      finally {}
      ArrayList localArrayList;
      localArrayList.add(localObject3);
      this.c.put(str2, localArrayList);
      continue;
      label313:
      this.c.put("所有图片", this.b);
      localCursor.close();
      this.k = false;
    }
  }
  
  public boolean isInited()
  {
    return this.b.size() > 0;
  }
  
  public boolean isResultOk()
  {
    return this.j;
  }
  
  public String setCameraImgPath()
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "ziroomminsu" + "/";
    Object localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    localObject = (String)localObject + ".jpg";
    this.f = (str + (String)localObject);
    return this.f;
  }
  
  public void setCurrentSize(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setResultOk(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public static class a
  {
    private String a;
    private String b;
    private int c;
    private String d;
    private a e;
    private String f;
    private String g;
    private int h;
    private int i;
    
    public String getFid()
    {
      return this.f;
    }
    
    public String getHousePicType()
    {
      return this.g;
    }
    
    public int getIsDefault()
    {
      return this.i;
    }
    
    public int getIsUpload()
    {
      return this.h;
    }
    
    public int getOrientation()
    {
      return this.c;
    }
    
    public String getOriginalUri()
    {
      return this.a;
    }
    
    public a getPicType()
    {
      return this.e;
    }
    
    public String getPicUrl()
    {
      return this.d;
    }
    
    public String getThumbnailUri()
    {
      return this.b;
    }
    
    public void setFid(String paramString)
    {
      this.f = paramString;
    }
    
    public void setHousePicType(String paramString)
    {
      this.g = paramString;
    }
    
    public void setIsDefault(int paramInt)
    {
      this.i = paramInt;
    }
    
    public void setIsUpload(int paramInt)
    {
      this.h = paramInt;
    }
    
    public void setOrientation(int paramInt)
    {
      this.c = paramInt;
    }
    
    public void setOriginalUri(String paramString)
    {
      this.a = paramString;
    }
    
    public void setPicType(a parama)
    {
      this.e = parama;
    }
    
    public void setPicUrl(String paramString)
    {
      this.d = paramString;
    }
    
    public void setThumbnailUri(String paramString)
    {
      this.b = paramString;
    }
    
    public static enum a
    {
      private a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */