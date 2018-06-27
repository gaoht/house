package com.g.a;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;

final class az
  extends PhoneStateListener
{
  long a = 0L;
  long b = 0L;
  int c;
  int d = 0;
  
  private void a()
  {
    try
    {
      this.a = System.currentTimeMillis();
      if ((this.c != this.d) && (this.c > 1) && (this.a - this.b > 180000L))
      {
        be localbe = new be();
        localbe.b = "env";
        localbe.c = "cellUpdate";
        localbe.a = a.b;
        ad.a().post(localbe);
        this.b = this.a;
        this.d = this.c;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
  }
  
  public void onCellLocationChanged(CellLocation paramCellLocation)
  {
    try
    {
      if (paramCellLocation.getClass().equals(GsmCellLocation.class))
      {
        this.c = ((GsmCellLocation)paramCellLocation).getLac();
        a();
        return;
      }
      if (paramCellLocation.getClass().equals(CdmaCellLocation.class))
      {
        this.c = ((CdmaCellLocation)paramCellLocation).getNetworkId();
        a();
        return;
      }
    }
    catch (Throwable paramCellLocation)
    {
      av.postSDKError(paramCellLocation);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */