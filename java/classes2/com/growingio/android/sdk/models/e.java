package com.growingio.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  implements Parcelable
{
  public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator()
  {
    public e a(Parcel paramAnonymousParcel)
    {
      return new e(paramAnonymousParcel);
    }
    
    public e[] a(int paramAnonymousInt)
    {
      return new e[paramAnonymousInt];
    }
  };
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public e() {}
  
  protected e(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
  }
  
  public static e a(JSONObject paramJSONObject)
  {
    e locale = new e();
    try
    {
      locale.a = paramJSONObject.getString("x");
      locale.b = paramJSONObject.getString("y");
      locale.c = paramJSONObject.getString("w");
      locale.d = paramJSONObject.getString("h");
      locale.e = paramJSONObject.getString("target");
      locale.f = paramJSONObject.getString("viewport");
      return locale;
    }
    catch (JSONException paramJSONObject) {}
    return locale;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("x", this.a);
      localJSONObject.put("y", this.b);
      localJSONObject.put("w", this.c);
      localJSONObject.put("h", this.d);
      localJSONObject.put("target", this.e);
      localJSONObject.put("viewport", this.f);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/models/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */