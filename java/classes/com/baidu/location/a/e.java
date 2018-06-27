package com.baidu.location.a;

import android.os.Environment;
import java.io.File;

class e
  extends Thread
{
  e(c paramc) {}
  
  public void run()
  {
    File localFile = new File(Environment.getExternalStorageDirectory() + "/baidu/tempdata", "intime.dat");
    c.a(this.a, localFile, "http://itsdata.map.baidu.com/long-conn-gps/sdk.php");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */