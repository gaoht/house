package com.growingio.android.sdk.models;

import java.io.Serializable;
import java.util.HashMap;

public class EventSID
  implements Serializable
{
  private HashMap<String, Integer> data = new HashMap();
  
  public int getSid(String paramString)
  {
    paramString = (Integer)this.data.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  public EventSID setSid(String paramString, int paramInt)
  {
    this.data.put(paramString, Integer.valueOf(paramInt));
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/models/EventSID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */