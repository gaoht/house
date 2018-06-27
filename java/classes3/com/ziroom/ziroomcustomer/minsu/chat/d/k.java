package com.ziroom.ziroomcustomer.minsu.chat.d;

import com.ziroom.ziroomcustomer.minsu.chat.a.a;
import com.ziroom.ziroomcustomer.minsu.chat.j;
import java.util.HashMap;
import java.util.Map;

public class k
{
  private static k b;
  private Map<String, a> a = new HashMap();
  
  private void a()
  {
    if (this.a == null) {
      this.a = new HashMap();
    }
  }
  
  public static k getInstance()
  {
    if (b == null) {
      b = new k();
    }
    b.a();
    return b;
  }
  
  public void clear()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public a getUser(String paramString)
  {
    a();
    paramString = j.removeEMPrefix(paramString);
    return (a)this.a.get(paramString);
  }
  
  public void putUser(String paramString, a parama)
  {
    a();
    paramString = j.removeEMPrefix(paramString);
    this.a.put(paramString, parama);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */