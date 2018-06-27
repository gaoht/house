package com.baidu.mapapi.search.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;

public class ShareUrlResult
  extends SearchResult
  implements Parcelable
{
  public static final Parcelable.Creator<ShareUrlResult> CREATOR = new a();
  private String a;
  private int b;
  
  ShareUrlResult() {}
  
  protected ShareUrlResult(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
  }
  
  ShareUrlResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }
  
  void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  void a(String paramString)
  {
    this.a = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getUrl()
  {
    return this.a;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/share/ShareUrlResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */