package com.mob.tools.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class SharePrefrenceHelper
{
  private Context context;
  private MobSharePreference prefrence;
  
  public SharePrefrenceHelper(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
  }
  
  public void clear()
  {
    this.prefrence.clear();
  }
  
  public Object get(String paramString)
  {
    try
    {
      paramString = getString(paramString);
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      paramString = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(paramString, 2)));
      Object localObject = paramString.readObject();
      paramString.close();
      return localObject;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
    }
    return null;
  }
  
  public HashMap<String, Object> getAll()
  {
    return this.prefrence.getAll();
  }
  
  public boolean getBoolean(String paramString)
  {
    return this.prefrence.getBoolean(paramString, false);
  }
  
  public float getFloat(String paramString)
  {
    return this.prefrence.getFloat(paramString, 0.0F);
  }
  
  public int getInt(String paramString)
  {
    return this.prefrence.getInt(paramString, 0);
  }
  
  public long getLong(String paramString)
  {
    return this.prefrence.getLong(paramString, 0L);
  }
  
  public String getString(String paramString)
  {
    return this.prefrence.getString(paramString, "");
  }
  
  public void open(String paramString)
  {
    open(paramString, 0);
  }
  
  public void open(String paramString, int paramInt)
  {
    paramString = paramString + "_" + paramInt;
    this.prefrence = new MobSharePreference(this.context, paramString);
  }
  
  public void put(String paramString, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      putString(paramString, Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 2));
      return;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
    }
  }
  
  public void putAll(HashMap<String, Object> paramHashMap)
  {
    this.prefrence.putAll(paramHashMap);
  }
  
  public void putBoolean(String paramString, Boolean paramBoolean)
  {
    this.prefrence.putBoolean(paramString, paramBoolean.booleanValue());
  }
  
  public void putFloat(String paramString, Float paramFloat)
  {
    this.prefrence.putFloat(paramString, paramFloat.floatValue());
  }
  
  public void putInt(String paramString, Integer paramInteger)
  {
    this.prefrence.putInt(paramString, paramInteger.intValue());
  }
  
  public void putLong(String paramString, Long paramLong)
  {
    this.prefrence.putLong(paramString, paramLong.longValue());
  }
  
  public void putString(String paramString1, String paramString2)
  {
    this.prefrence.putString(paramString1, paramString2);
  }
  
  public void remove(String paramString)
  {
    this.prefrence.remove(paramString);
  }
  
  private static final class MobSharePreference
  {
    private static Handler handler = MobHandlerThread.newHandler("s", new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        try
        {
          Object localObject = paramAnonymousMessage.getData();
          paramAnonymousMessage = ((Bundle)localObject).getString("json");
          localObject = new OutputStreamWriter(new FileOutputStream(((Bundle)localObject).getString("file")), "utf-8");
          ((OutputStreamWriter)localObject).append(paramAnonymousMessage);
          ((OutputStreamWriter)localObject).flush();
          ((OutputStreamWriter)localObject).close();
          return false;
        }
        catch (Throwable paramAnonymousMessage)
        {
          for (;;)
          {
            MobLog.getInstance().w(paramAnonymousMessage);
          }
        }
      }
    });
    private Hashon hashon;
    private File spFile;
    private HashMap<String, Object> spMap;
    
    public MobSharePreference(Context paramContext, String paramString)
    {
      this.spFile = new File(new File(paramContext.getFilesDir(), "Mob"), paramString);
      if (!this.spFile.getParentFile().exists()) {
        this.spFile.getParentFile().mkdirs();
      }
      this.spMap = new HashMap();
      this.hashon = new Hashon();
      open();
    }
    
    private Object get(String paramString)
    {
      synchronized (this.spMap)
      {
        paramString = this.spMap.get(paramString);
        return paramString;
      }
    }
    
    private void open()
    {
      synchronized (this.spMap)
      {
        boolean bool = this.spFile.exists();
        if (bool) {}
        try
        {
          BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.spFile), "utf-8"));
          StringBuilder localStringBuilder = new StringBuilder();
          for (String str = localBufferedReader.readLine(); str != null; str = localBufferedReader.readLine())
          {
            if (localStringBuilder.length() > 0) {
              localStringBuilder.append("\n");
            }
            localStringBuilder.append(str);
          }
          localBufferedReader.close();
          this.spMap = this.hashon.fromJson(localStringBuilder.toString());
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            MobLog.getInstance().w(localThrowable);
          }
        }
        return;
      }
    }
    
    private void put(String paramString, Object paramObject)
    {
      synchronized (this.spMap)
      {
        this.spMap.put(paramString, paramObject);
        if (handler != null)
        {
          paramString = new Message();
          paramObject = new Bundle();
          ((Bundle)paramObject).putString("json", this.hashon.fromHashMap(this.spMap));
          ((Bundle)paramObject).putString("file", this.spFile.getAbsolutePath());
          paramString.setData((Bundle)paramObject);
          paramString.what = 1;
          handler.sendMessage(paramString);
        }
        return;
      }
    }
    
    public void clear()
    {
      synchronized (this.spMap)
      {
        this.spMap.clear();
        if (handler != null) {
          handler.sendEmptyMessage(1);
        }
        return;
      }
    }
    
    public HashMap<String, Object> getAll()
    {
      synchronized (this.spMap)
      {
        HashMap localHashMap2 = new HashMap();
        localHashMap2.putAll(this.spMap);
        return localHashMap2;
      }
    }
    
    public boolean getBoolean(String paramString, boolean paramBoolean)
    {
      paramString = get(paramString);
      if (paramString != null) {
        return ((Number)paramString).byteValue() == 1;
      }
      return paramBoolean;
    }
    
    public byte getByte(String paramString, byte paramByte)
    {
      paramString = get(paramString);
      if (paramString != null) {
        paramByte = ((Number)paramString).byteValue();
      }
      return paramByte;
    }
    
    public char getChar(String paramString, char paramChar)
    {
      paramString = get(paramString);
      if (paramString != null) {
        paramChar = ((String)paramString).charAt(0);
      }
      return paramChar;
    }
    
    public double getDouble(String paramString, double paramDouble)
    {
      paramString = get(paramString);
      if (paramString != null) {
        paramDouble = ((Number)paramString).doubleValue();
      }
      return paramDouble;
    }
    
    public float getFloat(String paramString, float paramFloat)
    {
      paramString = get(paramString);
      if (paramString != null) {
        paramFloat = ((Number)paramString).floatValue();
      }
      return paramFloat;
    }
    
    public int getInt(String paramString, int paramInt)
    {
      paramString = get(paramString);
      if (paramString != null) {
        paramInt = ((Number)paramString).intValue();
      }
      return paramInt;
    }
    
    public long getLong(String paramString, long paramLong)
    {
      paramString = get(paramString);
      if (paramString != null) {
        paramLong = ((Number)paramString).longValue();
      }
      return paramLong;
    }
    
    public short getShort(String paramString, short paramShort)
    {
      paramString = get(paramString);
      if (paramString != null) {
        paramShort = ((Number)paramString).shortValue();
      }
      return paramShort;
    }
    
    public String getString(String paramString1, String paramString2)
    {
      paramString1 = get(paramString1);
      if (paramString1 != null) {
        return (String)paramString1;
      }
      return paramString2;
    }
    
    public void putAll(HashMap<String, Object> paramHashMap)
    {
      synchronized (this.spMap)
      {
        this.spMap.putAll(paramHashMap);
        if (handler != null) {
          handler.sendEmptyMessage(1);
        }
        return;
      }
    }
    
    public void putBoolean(String paramString, boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        putByte(paramString, (byte)i);
        return;
      }
    }
    
    public void putByte(String paramString, byte paramByte)
    {
      put(paramString, Byte.valueOf(paramByte));
    }
    
    public void putChar(String paramString, char paramChar)
    {
      putString(paramString, String.valueOf(paramChar));
    }
    
    public void putDouble(String paramString, double paramDouble)
    {
      put(paramString, Double.valueOf(paramDouble));
    }
    
    public void putFloat(String paramString, float paramFloat)
    {
      put(paramString, Float.valueOf(paramFloat));
    }
    
    public void putInt(String paramString, int paramInt)
    {
      put(paramString, Integer.valueOf(paramInt));
    }
    
    public void putLong(String paramString, long paramLong)
    {
      put(paramString, Long.valueOf(paramLong));
    }
    
    public void putShort(String paramString, short paramShort)
    {
      put(paramString, Short.valueOf(paramShort));
    }
    
    public void putString(String paramString1, String paramString2)
    {
      put(paramString1, paramString2);
    }
    
    public void remove(String paramString)
    {
      put(paramString, null);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/utils/SharePrefrenceHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */