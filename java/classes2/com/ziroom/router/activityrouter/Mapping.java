package com.ziroom.router.activityrouter;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;

public class Mapping
{
  private Class<? extends Activity> activity;
  private final ExtraTypes extraTypes;
  private final String format;
  private Path formatPath;
  private final MethodInvoker method;
  
  public Mapping(String paramString, Class<? extends Activity> paramClass, MethodInvoker paramMethodInvoker, ExtraTypes paramExtraTypes)
  {
    if (paramString == null) {
      throw new NullPointerException("format can not be null");
    }
    this.format = paramString;
    this.activity = paramClass;
    this.method = paramMethodInvoker;
    this.extraTypes = paramExtraTypes;
    if ((paramString.toLowerCase().startsWith("http://")) || (paramString.toLowerCase().startsWith("https://")))
    {
      this.formatPath = Path.create(Uri.parse(paramString));
      return;
    }
    this.formatPath = Path.create(Uri.parse("helper://".concat(paramString)));
  }
  
  private void put(Bundle paramBundle, String paramString1, String paramString2)
  {
    int j = this.extraTypes.getType(paramString1);
    paramString1 = this.extraTypes.transfer(paramString1);
    int i = j;
    if (j == -1) {
      i = this.extraTypes.getType(paramString1);
    }
    switch (i)
    {
    default: 
      paramBundle.putString(paramString1, paramString2);
      return;
    case 1: 
      paramBundle.putInt(paramString1, Integer.parseInt(paramString2));
      return;
    case 2: 
      paramBundle.putLong(paramString1, Long.parseLong(paramString2));
      return;
    case 3: 
      paramBundle.putBoolean(paramString1, Boolean.parseBoolean(paramString2));
      return;
    case 4: 
      paramBundle.putShort(paramString1, Short.parseShort(paramString2));
      return;
    case 5: 
      paramBundle.putFloat(paramString1, Float.parseFloat(paramString2));
      return;
    case 6: 
      paramBundle.putDouble(paramString1, Double.parseDouble(paramString2));
      return;
    case 7: 
      paramBundle.putByte(paramString1, Byte.parseByte(paramString2));
      return;
    }
    paramBundle.putChar(paramString1, paramString2.charAt(0));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Mapping))
    {
      paramObject = (Mapping)paramObject;
      return this.format.equals(((Mapping)paramObject).format);
    }
    return false;
  }
  
  public Class<? extends Activity> getActivity()
  {
    return this.activity;
  }
  
  public String getFormat()
  {
    return this.format;
  }
  
  public MethodInvoker getMethod()
  {
    return this.method;
  }
  
  public int hashCode()
  {
    return this.format.hashCode();
  }
  
  public boolean match(Path paramPath)
  {
    boolean bool1;
    if (this.formatPath.isHttp()) {
      bool1 = Path.match(this.formatPath, paramPath);
    }
    do
    {
      boolean bool2;
      do
      {
        return bool1;
        bool2 = Path.match(this.formatPath.next(), paramPath.next());
        bool1 = bool2;
      } while (bool2);
      bool1 = bool2;
    } while (paramPath.next() == null);
    return Path.match(this.formatPath.next(), paramPath.next().next());
  }
  
  public Bundle parseExtras(Uri paramUri)
  {
    Bundle localBundle = new Bundle();
    Object localObject2 = this.formatPath.next();
    for (Object localObject1 = Path.create(paramUri).next(); localObject2 != null; localObject1 = ((Path)localObject1).next())
    {
      if (((Path)localObject2).isArgument()) {
        put(localBundle, ((Path)localObject2).argument(), ((Path)localObject1).value());
      }
      localObject2 = ((Path)localObject2).next();
    }
    localObject1 = UriCompact.getQueryParameterNames(paramUri).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      put(localBundle, (String)localObject2, paramUri.getQueryParameter((String)localObject2));
    }
    return localBundle;
  }
  
  public String toString()
  {
    return String.format("%s => %s", new Object[] { this.format, this.activity });
  }
  
  public void updateActivity(Class<? extends Activity> paramClass)
  {
    this.activity = paramClass;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/router/activityrouter/Mapping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */