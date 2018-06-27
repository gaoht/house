package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import org.json.JSONException;
import org.json.JSONObject;

public class PoiDetailResult
  extends SearchResult
  implements Parcelable
{
  public static final Parcelable.Creator<PoiDetailResult> CREATOR = new a();
  int a;
  String b;
  String c;
  LatLng d;
  String e;
  String f;
  String g;
  String h;
  String i;
  String j;
  double k;
  double l;
  double m;
  double n;
  double o;
  double p;
  double q;
  double r;
  int s;
  int t;
  int u;
  int v;
  int w;
  String x;
  
  PoiDetailResult() {}
  
  protected PoiDetailResult(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = ((LatLng)paramParcel.readValue(LatLng.class.getClassLoader()));
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readDouble();
    this.l = paramParcel.readDouble();
    this.m = paramParcel.readDouble();
    this.n = paramParcel.readDouble();
    this.o = paramParcel.readDouble();
    this.p = paramParcel.readDouble();
    this.q = paramParcel.readDouble();
    this.r = paramParcel.readDouble();
    this.s = paramParcel.readInt();
    this.t = paramParcel.readInt();
    this.u = paramParcel.readInt();
    this.v = paramParcel.readInt();
    this.w = paramParcel.readInt();
    this.x = paramParcel.readString();
  }
  
  public PoiDetailResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }
  
  boolean a(String paramString)
  {
    boolean bool2 = false;
    try
    {
      paramString = new JSONObject(paramString);
      this.a = paramString.optInt("status");
      boolean bool1 = bool2;
      if (this.a == 0)
      {
        this.b = paramString.optString("message");
        paramString = paramString.optJSONObject("result");
        bool1 = bool2;
        if (paramString != null)
        {
          this.c = paramString.optString("name");
          JSONObject localJSONObject = paramString.optJSONObject("location");
          this.d = new LatLng(localJSONObject.optDouble("lat"), localJSONObject.optDouble("lng"));
          this.e = paramString.optString("address");
          this.f = paramString.optString("telephone");
          this.g = paramString.optString("uid");
          paramString = paramString.optJSONObject("detail_info");
          if (paramString != null)
          {
            this.h = paramString.optString("tag");
            this.i = paramString.optString("detail_url");
            this.j = paramString.optString("type");
            this.k = paramString.optDouble("price", 0.0D);
            this.l = paramString.optDouble("overall_rating", 0.0D);
            this.m = paramString.optDouble("taste_rating", 0.0D);
            this.n = paramString.optDouble("service_rating", 0.0D);
            this.o = paramString.optDouble("environment_rating", 0.0D);
            this.p = paramString.optDouble("facility_rating", 0.0D);
            this.q = paramString.optDouble("hygiene_rating", 0.0D);
            this.r = paramString.optDouble("technology_rating", 0.0D);
            this.s = paramString.optInt("image_num");
            this.t = paramString.optInt("groupon_num");
            this.u = paramString.optInt("comment_num");
            this.v = paramString.optInt("favorite_num");
            this.w = paramString.optInt("checkin_num");
            this.x = paramString.optString("shop_hours");
          }
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress()
  {
    return this.e;
  }
  
  public int getCheckinNum()
  {
    return this.w;
  }
  
  public int getCommentNum()
  {
    return this.u;
  }
  
  public String getDetailUrl()
  {
    return this.i;
  }
  
  public double getEnvironmentRating()
  {
    return this.o;
  }
  
  public double getFacilityRating()
  {
    return this.p;
  }
  
  public int getFavoriteNum()
  {
    return this.v;
  }
  
  public int getGrouponNum()
  {
    return this.t;
  }
  
  public double getHygieneRating()
  {
    return this.q;
  }
  
  public int getImageNum()
  {
    return this.s;
  }
  
  public LatLng getLocation()
  {
    return this.d;
  }
  
  public String getName()
  {
    return this.c;
  }
  
  public double getOverallRating()
  {
    return this.l;
  }
  
  public double getPrice()
  {
    return this.k;
  }
  
  public double getServiceRating()
  {
    return this.n;
  }
  
  public String getShopHours()
  {
    return this.x;
  }
  
  public String getTag()
  {
    return this.h;
  }
  
  public double getTasteRating()
  {
    return this.m;
  }
  
  public double getTechnologyRating()
  {
    return this.r;
  }
  
  public String getTelephone()
  {
    return this.f;
  }
  
  public String getType()
  {
    return this.j;
  }
  
  public String getUid()
  {
    return this.g;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeValue(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeDouble(this.k);
    paramParcel.writeDouble(this.l);
    paramParcel.writeDouble(this.m);
    paramParcel.writeDouble(this.n);
    paramParcel.writeDouble(this.o);
    paramParcel.writeDouble(this.p);
    paramParcel.writeDouble(this.q);
    paramParcel.writeDouble(this.r);
    paramParcel.writeInt(this.s);
    paramParcel.writeInt(this.t);
    paramParcel.writeInt(this.u);
    paramParcel.writeInt(this.v);
    paramParcel.writeInt(this.w);
    paramParcel.writeString(this.x);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/poi/PoiDetailResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */