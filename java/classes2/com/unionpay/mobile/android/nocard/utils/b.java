package com.unionpay.mobile.android.nocard.utils;

import com.unionpay.mobile.android.utils.i;
import org.json.JSONObject;

public final class b
{
  public static void a(JSONObject paramJSONObject, com.unionpay.mobile.android.model.b paramb)
  {
    paramb.as = i.a(paramJSONObject, "red_packet_url");
  }
  
  public static void b(JSONObject paramJSONObject, com.unionpay.mobile.android.model.b paramb)
  {
    paramb.aR = i.a(paramJSONObject, "pay_msg");
    paramb.bi = i.a(paramJSONObject, "reserved");
    paramb.aS = i.a(paramJSONObject, "promotion_msg");
    paramb.aT = i.a(paramJSONObject, "instalment_msg");
    paramb.aW = i.a(paramJSONObject, "temporary_pay_flag");
    if ("0".equalsIgnoreCase(paramb.aW)) {
      paramb.aX = i.a(paramJSONObject, "temporary_pay_info");
    }
    if ("0".equalsIgnoreCase(i.a(paramJSONObject, "luck_draw_flag"))) {
      paramb.aV = true;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/utils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */