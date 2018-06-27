package com.unionpay.mobile.android.pboctransaction.sdapdu;

import com.unionpay.mobile.android.utils.j;
import java.util.ArrayList;

public class NativeSDWriter
{
  public NativeSDWriter()
  {
    b.a();
  }
  
  private native boolean closeSD();
  
  private native boolean openSD(ArrayList<String> paramArrayList);
  
  private native String writeApdu(String paramString);
  
  public final String a(String paramString)
  {
    j.c("uppay", "[====>]" + paramString);
    paramString = writeApdu(paramString);
    j.c("uppay", "[<====]" + paramString);
    return paramString;
  }
  
  public final boolean a()
  {
    j.c("uppay", "close()");
    return closeSD();
  }
  
  public final boolean a(ArrayList<String> paramArrayList)
  {
    boolean bool = openSD(paramArrayList);
    j.c("uppay", "open(), ret=" + bool);
    return bool;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/sdapdu/NativeSDWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */