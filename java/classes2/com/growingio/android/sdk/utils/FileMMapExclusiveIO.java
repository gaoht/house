package com.growingio.android.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.FileLock;
import org.json.JSONObject;

public class FileMMapExclusiveIO
{
  private static FileMMapExclusiveIO a = null;
  private String b;
  private FileChannel c;
  private MappedByteBuffer d;
  
  FileMMapExclusiveIO(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), ".gio.dir");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    this.b = (paramContext.getAbsolutePath() + File.separator + ".sid");
    try
    {
      this.c = new RandomAccessFile(this.b, "rw").getChannel();
      try
      {
        this.d = this.c.map(FileChannel.MapMode.READ_WRITE, 0L, 255L);
        if (!d())
        {
          LogUtil.i("GIO.FileMMapExclusiveIO", "check magic fail");
          c();
          return;
        }
        LogUtil.i("GIO.FileMMapExclusiveIO", "check magic success");
        return;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      return;
    }
    catch (FileNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private int a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0);
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24;
  }
  
  private Object a(String paramString, byte[] paramArrayOfByte, DATA_TYPE paramDATA_TYPE)
  {
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte));
      if (!paramArrayOfByte.has(paramString)) {
        return null;
      }
      if (paramDATA_TYPE == DATA_TYPE.a) {
        return Integer.valueOf(paramArrayOfByte.optInt(paramString));
      }
      if (paramDATA_TYPE == DATA_TYPE.b) {
        return Boolean.valueOf(paramArrayOfByte.optBoolean(paramString));
      }
      if (paramDATA_TYPE == DATA_TYPE.c) {
        return paramArrayOfByte.opt(paramString);
      }
      if (paramDATA_TYPE == DATA_TYPE.d) {
        return paramArrayOfByte.optString(paramString);
      }
      if ((paramDATA_TYPE == DATA_TYPE.f) || (paramDATA_TYPE == DATA_TYPE.e))
      {
        paramString = paramArrayOfByte.opt(paramString);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void a(String paramString, Object paramObject, DATA_TYPE paramDATA_TYPE, byte[] paramArrayOfByte)
  {
    LogUtil.i("GIO.FileMMapExclusiveIO", "setValue type:" + paramDATA_TYPE.toString() + " key: " + paramString + " value: " + paramObject + " arr: " + new String(paramArrayOfByte));
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte));
      if (paramDATA_TYPE == DATA_TYPE.a) {
        paramArrayOfByte.put(paramString, ((Integer)paramObject).intValue());
      }
      if (paramDATA_TYPE == DATA_TYPE.b) {
        paramArrayOfByte.put(paramString, ((Boolean)paramObject).booleanValue());
      }
      if (paramDATA_TYPE == DATA_TYPE.c) {
        paramArrayOfByte.put(paramString, paramObject);
      }
      if (paramDATA_TYPE == DATA_TYPE.d) {
        paramArrayOfByte.put(paramString, ((String)paramObject).toString());
      }
      if ((paramDATA_TYPE == DATA_TYPE.f) || (paramDATA_TYPE == DATA_TYPE.e)) {
        paramArrayOfByte.putOpt(paramString, paramObject);
      }
      if (this.d.position() != 8) {
        this.d.position(8);
      }
      paramString = paramArrayOfByte.toString().getBytes();
      this.d.put(paramString);
      this.d.rewind();
      b(paramString.length);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private byte[] a(int paramInt)
  {
    if (this.d.position() != 8) {
      this.d.position(8);
    }
    byte[] arrayOfByte = new byte[paramInt];
    this.d.get(arrayOfByte);
    this.d.rewind();
    return arrayOfByte;
  }
  
  private int b()
  {
    try
    {
      byte[] arrayOfByte = new byte[4];
      if (this.d.position() != 4) {
        this.d.position(4);
      }
      this.d.get(arrayOfByte);
      this.d.rewind();
      int i = a(arrayOfByte);
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0;
  }
  
  private void b(int paramInt)
  {
    if (this.d.position() != 4) {
      this.d.position(4);
    }
    byte[] arrayOfByte = c(paramInt);
    this.d.put(arrayOfByte);
    this.d.rewind();
  }
  
  private void c()
  {
    try
    {
      if (this.d.position() != 0) {
        this.d.position(0);
      }
      byte[] arrayOfByte = c(1297);
      LogUtil.i("GIO.FileMMapExclusiveIO", "resetMagic arr: " + a(arrayOfByte));
      this.d.put(arrayOfByte);
      this.d.rewind();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private byte[] c(int paramInt)
  {
    int i = (byte)(paramInt >> 24 & 0xFF);
    int j = (byte)(paramInt >> 16 & 0xFF);
    int k = (byte)(paramInt >> 8 & 0xFF);
    return new byte[] { (byte)(paramInt & 0xFF), k, j, i };
  }
  
  private boolean d()
  {
    boolean bool = false;
    try
    {
      byte[] arrayOfByte = new byte[4];
      if (this.d.position() != 0) {
        this.d.position(0);
      }
      this.d.get(arrayOfByte);
      this.d.rewind();
      LogUtil.i("GIO.FileMMapExclusiveIO", "checkMagic arr: " + a(arrayOfByte));
      int i = a(arrayOfByte);
      if (i == 1297) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public Object a(String paramString, DATA_TYPE paramDATA_TYPE)
  {
    Object localObject1 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    localObject3 = localObject5;
    try
    {
      FileLock localFileLock = this.c.lock(0L, 255L, false);
      if (localFileLock != null)
      {
        localObject1 = localObject4;
        localObject3 = localObject5;
        if (d())
        {
          localObject3 = localObject5;
          int i = b();
          localObject1 = localObject4;
          if (i > 0)
          {
            localObject3 = localObject5;
            localObject1 = a(paramString, a(i), paramDATA_TYPE);
          }
        }
        localObject3 = localObject1;
        localFileLock.release();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        Object localObject2 = localObject3;
      }
    }
    LogUtil.i("GIO.FileMMapExclusiveIO", "read type:" + paramDATA_TYPE.toString() + " key: " + paramString + " value: " + localObject1);
    return localObject1;
  }
  
  public void a()
  {
    if (this.d != null) {}
    try
    {
      Class localClass = Class.forName("java.nio.MemoryBlock");
      Object localObject = MappedByteBuffer.class.getDeclaredField("block");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this.d);
      localClass.getDeclaredMethod("free", new Class[0]).invoke(localObject, new Object[0]);
      this.d = null;
      System.gc();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, Object paramObject, DATA_TYPE paramDATA_TYPE)
  {
    LogUtil.i("GIO.FileMMapExclusiveIO", "save type: " + paramDATA_TYPE.toString() + " key: " + paramString + " value: " + paramObject);
    if ((paramObject != null) && ((paramObject instanceof String)) && (!TextUtils.isEmpty((String)paramObject))) {
      try
      {
        FileLock localFileLock = this.c.lock(0L, 255L, false);
        if (localFileLock != null)
        {
          int i;
          if (d())
          {
            i = b();
            if (i <= 0) {
              break label127;
            }
          }
          label127:
          for (byte[] arrayOfByte = a(i);; arrayOfByte = "{}".getBytes())
          {
            a(paramString, paramObject, paramDATA_TYPE, arrayOfByte);
            localFileLock.release();
            return;
          }
        }
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static enum DATA_TYPE
  {
    private DATA_TYPE() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/utils/FileMMapExclusiveIO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */