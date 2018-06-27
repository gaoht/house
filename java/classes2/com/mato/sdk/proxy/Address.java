package com.mato.sdk.proxy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;

public class Address
  implements Parcelable
{
  private static Parcelable.Creator<Address> c;
  private String a;
  private int b;
  
  static
  {
    new Parcelable.Creator()
    {
      private static Address a(Parcel paramAnonymousParcel)
      {
        return new Address(paramAnonymousParcel);
      }
      
      private static Address[] a(int paramAnonymousInt)
      {
        return new Address[paramAnonymousInt];
      }
    };
  }
  
  public Address(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
  }
  
  public Address(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Address)) {
        return false;
      }
      paramObject = (Address)paramObject;
    } while ((this.b == ((Address)paramObject).b) && (this.a.equals(((Address)paramObject).a)));
    return false;
  }
  
  public String getHost()
  {
    return this.a;
  }
  
  public Proxy getHttpProxy()
  {
    return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(getHost(), getPort()));
  }
  
  public int getPort()
  {
    return this.b;
  }
  
  public SocketAddress getSocketAddress()
  {
    return new InetSocketAddress(getHost(), getPort());
  }
  
  public void setHost(String paramString)
  {
    this.a = paramString;
  }
  
  public void setPort(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/proxy/Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */