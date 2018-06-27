package com.baidu.mapapi.search.busline;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.Date;
import java.util.List;

public class BusLineResult
  extends SearchResult
  implements Parcelable
{
  public static final Parcelable.Creator<BusLineResult> CREATOR = new a();
  private String a = null;
  private String b = null;
  private boolean c;
  private Date d;
  private Date e;
  private String f;
  private List<BusStation> g = null;
  private List<BusStep> h = null;
  private float i;
  private float j;
  private String k = null;
  
  BusLineResult() {}
  
  BusLineResult(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader())).booleanValue();
    this.d = ((Date)paramParcel.readValue(Date.class.getClassLoader()));
    this.e = ((Date)paramParcel.readValue(Date.class.getClassLoader()));
    this.f = paramParcel.readString();
    this.g = paramParcel.readArrayList(BusStation.class.getClassLoader());
    this.h = paramParcel.readArrayList(RouteStep.class.getClassLoader());
  }
  
  BusLineResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }
  
  void a(String paramString)
  {
    this.b = paramString;
  }
  
  void a(Date paramDate)
  {
    this.d = paramDate;
  }
  
  void a(List<BusStation> paramList)
  {
    this.g = paramList;
  }
  
  void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  void b(String paramString)
  {
    this.f = paramString;
  }
  
  void b(Date paramDate)
  {
    this.e = paramDate;
  }
  
  void b(List<BusStep> paramList)
  {
    this.h = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getBasePrice()
  {
    return this.i;
  }
  
  public String getBusCompany()
  {
    return this.a;
  }
  
  public String getBusLineName()
  {
    return this.b;
  }
  
  public Date getEndTime()
  {
    return this.e;
  }
  
  public String getLineDirection()
  {
    return this.k;
  }
  
  public float getMaxPrice()
  {
    return this.j;
  }
  
  public Date getStartTime()
  {
    return this.d;
  }
  
  public List<BusStation> getStations()
  {
    return this.g;
  }
  
  public List<BusStep> getSteps()
  {
    return this.h;
  }
  
  public String getUid()
  {
    return this.f;
  }
  
  public boolean isMonthTicket()
  {
    return this.c;
  }
  
  public void setBasePrice(float paramFloat)
  {
    this.i = paramFloat;
  }
  
  public void setLineDirection(String paramString)
  {
    this.k = paramString;
  }
  
  public void setMaxPrice(float paramFloat)
  {
    this.j = paramFloat;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeValue(Boolean.valueOf(this.c));
    paramParcel.writeValue(this.d);
    paramParcel.writeValue(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeList(this.g);
    paramParcel.writeList(this.h);
  }
  
  public static class BusStation
    extends RouteNode
  {}
  
  public static class BusStep
    extends RouteStep
  {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/busline/BusLineResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */