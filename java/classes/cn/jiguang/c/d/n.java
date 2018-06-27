package cn.jiguang.c.d;

import android.content.Context;
import org.json.JSONArray;

final class n
  implements Runnable
{
  Context a;
  JSONArray b;
  String c;
  
  public n(Context paramContext, JSONArray paramJSONArray, String paramString)
  {
    this.a = paramContext;
    this.b = paramJSONArray;
    this.c = paramString;
  }
  
  public final void run()
  {
    l.b(this.a, this.b, this.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/d/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */