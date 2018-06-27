package org.apache.thrift.meta_data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.a;

public class b
  implements Serializable
{
  private static Map<Class<? extends a>, Map<?, b>> d = new HashMap();
  public final String a;
  public final byte b;
  public final c c;
  
  public b(String paramString, byte paramByte, c paramc)
  {
    this.a = paramString;
    this.b = paramByte;
    this.c = paramc;
  }
  
  public static void a(Class<? extends a> paramClass, Map<?, b> paramMap)
  {
    d.put(paramClass, paramMap);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/apache/thrift/meta_data/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */