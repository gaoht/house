package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class a
  implements Parcelable
{
  public static final Parcelable.Creator<a> CREATOR = new b();
  public String a;
  public Bundle b = null;
  private int c = 1;
  private Bundle d = null;
  
  public a() {}
  
  private a(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public a(String paramString)
  {
    this.a = paramString;
  }
  
  private static ClassLoader a(Class paramClass)
  {
    if (paramClass == null) {
      return ClassLoader.getSystemClassLoader();
    }
    return paramClass.getClassLoader();
  }
  
  private void a(Parcel paramParcel)
  {
    this.c = paramParcel.readInt();
    this.a = paramParcel.readString();
    this.b = paramParcel.readBundle(a(Bundle.class));
    this.d = paramParcel.readBundle(a(Bundle.class));
  }
  
  public Bundle a()
  {
    return this.d;
  }
  
  public a a(Bundle paramBundle)
  {
    this.d = paramBundle;
    return this;
  }
  
  public int b()
  {
    if (this.d == null) {
      return 0;
    }
    return 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.a);
    paramParcel.writeBundle(this.b);
    paramParcel.writeBundle(this.d);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/core/aidl/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */