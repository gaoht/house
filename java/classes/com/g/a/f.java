package com.g.a;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class f
  implements Parcelable.Creator
{
  public e a(Parcel paramParcel)
  {
    try
    {
      paramParcel = new e(paramParcel);
      return paramParcel;
    }
    catch (Throwable paramParcel) {}
    return null;
  }
  
  public e[] a(int paramInt)
  {
    try
    {
      e[] arrayOfe = new e[paramInt];
      return arrayOfe;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */