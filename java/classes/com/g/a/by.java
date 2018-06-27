package com.g.a;

import android.os.Build;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

public class by
  extends br
{
  public by()
  {
    a("os", "android");
    a("osVersionName", n.a());
    a("osVersionCode", String.valueOf(n.g()));
    a("timezone", TimeZone.getDefault().getID());
    a("locale", Locale.getDefault().toString());
    a("timezoneV", String.valueOf(TimeZone.getDefault().getRawOffset() / 3600000.0F));
    a("language", n.i());
    a("romVersion", Build.FINGERPRINT);
    if (z.a(14)) {
      a("basebandVersion", Build.getRadioVersion());
    }
  }
  
  public String b()
  {
    return ((JSONObject)a_()).optString("timezoneV");
  }
  
  public String c()
  {
    return ((JSONObject)a_()).optString("locale");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */