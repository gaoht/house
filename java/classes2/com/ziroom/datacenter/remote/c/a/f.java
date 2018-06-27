package com.ziroom.datacenter.remote.c.a;

import com.alibaba.fastjson.e;

public abstract class f
{
  protected e a;
  
  public void decode(String paramString)
  {
    this.a = e.parseObject(paramString);
  }
  
  public abstract int getCode();
  
  public abstract String getData();
  
  public abstract String getMessage();
  
  public abstract boolean isSuccess();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */