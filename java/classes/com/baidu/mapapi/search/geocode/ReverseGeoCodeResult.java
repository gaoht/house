package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.List;

public class ReverseGeoCodeResult
  extends SearchResult
{
  public static final Parcelable.Creator<ReverseGeoCodeResult> CREATOR = new c();
  private String a;
  private String b;
  private AddressComponent c;
  private LatLng d;
  private List<PoiInfo> e;
  
  ReverseGeoCodeResult() {}
  
  protected ReverseGeoCodeResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = ((AddressComponent)paramParcel.readParcelable(AddressComponent.class.getClassLoader()));
    this.d = ((LatLng)paramParcel.readValue(LatLng.class.getClassLoader()));
    this.e = paramParcel.createTypedArrayList(PoiInfo.CREATOR);
  }
  
  ReverseGeoCodeResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }
  
  void a(LatLng paramLatLng)
  {
    this.d = paramLatLng;
  }
  
  void a(AddressComponent paramAddressComponent)
  {
    this.c = paramAddressComponent;
  }
  
  void a(String paramString)
  {
    this.a = paramString;
  }
  
  void a(List<PoiInfo> paramList)
  {
    this.e = paramList;
  }
  
  void b(String paramString)
  {
    this.b = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress()
  {
    return this.b;
  }
  
  public AddressComponent getAddressDetail()
  {
    return this.c;
  }
  
  public String getBusinessCircle()
  {
    return this.a;
  }
  
  public LatLng getLocation()
  {
    return this.d;
  }
  
  public List<PoiInfo> getPoiList()
  {
    return this.e;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.c, 0);
    paramParcel.writeValue(this.d);
    paramParcel.writeTypedList(this.e);
  }
  
  public static class AddressComponent
    implements Parcelable
  {
    public static final Parcelable.Creator<AddressComponent> CREATOR = new d();
    public String city;
    public String district;
    public String province;
    public String street;
    public String streetNumber;
    
    public AddressComponent() {}
    
    protected AddressComponent(Parcel paramParcel)
    {
      this.streetNumber = paramParcel.readString();
      this.street = paramParcel.readString();
      this.district = paramParcel.readString();
      this.city = paramParcel.readString();
      this.province = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.streetNumber);
      paramParcel.writeString(this.street);
      paramParcel.writeString(this.district);
      paramParcel.writeString(this.city);
      paramParcel.writeString(this.province);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/geocode/ReverseGeoCodeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */