package com.unionpay.client3.tsm;

import android.os.Bundle;

public abstract interface ITsmTransCallback
{
  public abstract void onFailed(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public abstract void onSuccess(int paramInt1, int paramInt2, Bundle paramBundle);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/client3/tsm/ITsmTransCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */