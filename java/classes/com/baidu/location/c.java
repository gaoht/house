package com.baidu.location;

import com.baidu.location.a.b;

class c
  extends Thread
{
  c(LocationClient paramLocationClient) {}
  
  public void run()
  {
    if (LocationClient.access$900(this.a) == null) {
      LocationClient.access$902(this.a, new b(LocationClient.access$1000(this.a), LocationClient.access$700(this.a), this.a));
    }
    LocationClient.access$900(this.a).c();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */