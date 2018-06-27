package com.unionpay.mobile.android.pboctransaction;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppIdentification
  implements Parcelable, Comparable<AppIdentification>
{
  public static final Parcelable.Creator<AppIdentification> CREATOR = new a();
  private String a;
  private String b;
  
  private AppIdentification()
  {
    this.a = "";
    this.b = "";
  }
  
  public AppIdentification(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final String b()
  {
    try
    {
      String str = this.a.substring(14, 16);
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public final boolean c()
  {
    if (this.a != null) {
      return this.a.startsWith("A000000333");
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof AppIdentification))) {}
    do
    {
      return false;
      paramObject = (AppIdentification)paramObject;
    } while ((!this.a.equalsIgnoreCase(((AppIdentification)paramObject).a)) || (!this.b.equalsIgnoreCase(((AppIdentification)paramObject).b)));
    return true;
  }
  
  public int hashCode()
  {
    return (this.a.hashCode() + 31) * 31 + this.b.hashCode();
  }
  
  public String toString()
  {
    return "{appId:" + this.a + ", appVersion:" + this.b + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/AppIdentification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */