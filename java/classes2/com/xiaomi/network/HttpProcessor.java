package com.xiaomi.network;

import android.content.Context;
import com.xiaomi.channel.commonutils.network.c;
import java.util.List;

public abstract class HttpProcessor
{
  private int a;
  
  public HttpProcessor(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public boolean a(Context paramContext, String paramString, List<c> paramList)
  {
    return true;
  }
  
  public abstract String b(Context paramContext, String paramString, List<c> paramList);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/network/HttpProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */