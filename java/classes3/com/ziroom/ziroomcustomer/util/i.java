package com.ziroom.ziroomcustomer.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class i
{
  private final Properties a = new Properties();
  
  private i()
    throws IOException
  {
    this.a.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
  }
  
  public static i newInstance()
    throws IOException
  {
    return new i();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.a.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return this.a.containsValue(paramObject);
  }
  
  public Set<Map.Entry<Object, Object>> entrySet()
  {
    return this.a.entrySet();
  }
  
  public String getProperty(String paramString)
  {
    return this.a.getProperty(paramString);
  }
  
  public String getProperty(String paramString1, String paramString2)
  {
    return this.a.getProperty(paramString1, paramString2);
  }
  
  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }
  
  public Set<Object> keySet()
  {
    return this.a.keySet();
  }
  
  public Enumeration<Object> keys()
  {
    return this.a.keys();
  }
  
  public int size()
  {
    return this.a.size();
  }
  
  public Collection<Object> values()
  {
    return this.a.values();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */