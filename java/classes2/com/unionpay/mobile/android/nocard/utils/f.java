package com.unionpay.mobile.android.nocard.utils;

import android.text.TextUtils;
import com.unionpay.mobile.android.model.a;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.utils.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public static int a(b paramb, JSONObject paramJSONObject)
  {
    paramb.bs = i.a(paramJSONObject, "promotion_change_info");
    paramb.z = i.d(paramJSONObject, "rules");
    paramb.ad = i.d(paramJSONObject, "available_area_codes");
    paramb.D = i.d(paramJSONObject, "entrust_rules");
    paramb.E = i.a(paramJSONObject, "pre_cmd");
    paramb.A = i.a(paramJSONObject, "title");
    paramb.C = i.c(paramJSONObject, "rules_button");
    paramb.al = i.c(paramJSONObject, "service_checkbox");
    paramb.am = i.c(paramJSONObject, "bind_card_checkbox");
    String str = i.a(paramJSONObject, "timeout_msg");
    if ((str != null) && (!TextUtils.isEmpty(str))) {
      paramb.ak = str;
    }
    paramb.p = new HashMap();
    Object localObject = i.c(paramJSONObject, "f55");
    str = i.a((JSONObject)localObject, "order_amount");
    HashMap localHashMap = paramb.p;
    if ((str != null) && (str.length() > 0))
    {
      localHashMap.put("trans_amt", str);
      str = i.a((JSONObject)localObject, "order_currency");
      localHashMap = paramb.p;
      if ((str == null) || (str.length() <= 0)) {
        break label358;
      }
      label188:
      localHashMap.put("trans currcy code", str);
      str = i.a((JSONObject)localObject, "trans_type");
      localHashMap = paramb.p;
      if ((str == null) || (str.length() <= 0)) {
        break label364;
      }
      label221:
      localHashMap.put("trans_type", str);
      str = i.a((JSONObject)localObject, "mer_name");
      localObject = paramb.p;
      if ((str == null) || (str.length() <= 0)) {
        break label370;
      }
    }
    for (;;)
    {
      ((HashMap)localObject).put("mer_name", str);
      paramb.aq = i.a(paramJSONObject, "pan");
      paramb.be = i.a(paramJSONObject, "encrypt_key");
      paramb.bf = i.a(paramJSONObject, "auth_id");
      paramJSONObject = i.a(paramJSONObject, "fail_continue");
      if ((paramJSONObject != null) && (paramJSONObject.equalsIgnoreCase("0"))) {
        paramb.F = true;
      }
      if (((paramb.z != null) && (paramb.z.length() > 0)) || ((paramb.D != null) && (paramb.D.length() > 0))) {
        break label376;
      }
      return 2;
      str = "000000000000";
      break;
      label358:
      str = "0156";
      break label188;
      label364:
      str = "00";
      break label221;
      label370:
      str = "";
    }
    label376:
    return 0;
  }
  
  public static int a(b paramb, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (!paramBoolean) {
      paramb.G = paramJSONObject;
    }
    return a(paramb, paramJSONObject);
  }
  
  public static e a(JSONObject paramJSONObject)
  {
    com.unionpay.mobile.android.model.f localf = new com.unionpay.mobile.android.model.f();
    localf.a("promotion", i.c(paramJSONObject, "promotion"));
    localf.a("instalment", i.c(paramJSONObject, "instalment"));
    localf.a("promotion_instalment_msgbox", i.c(paramJSONObject, "promotion_instalment_msgbox"));
    return localf;
  }
  
  public static boolean a(JSONArray paramJSONArray)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (paramJSONArray != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramJSONArray.length()) {}
      try
      {
        Object localObject = paramJSONArray.getJSONObject(i);
        String str = i.a((JSONObject)localObject, "type");
        localObject = i.a((JSONObject)localObject, "readonly");
        if ("pan".equalsIgnoreCase(str))
        {
          boolean bool3 = "true".equalsIgnoreCase((String)localObject);
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
          return bool1;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        i += 1;
      }
    }
  }
  
  public static int b(b paramb, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (int i = 2;; i = 0)
    {
      if (paramb.ab == null) {
        paramb.ab = new ArrayList();
      }
      paramb.ab.clear();
      List localList = i.e(paramJSONObject, "user_cards");
      if ((localList != null) && (localList.size() > 0))
      {
        int j = 0;
        while ((localList != null) && (j < localList.size()))
        {
          a locala = new a(i.a((JSONArray)localList.get(j), 0), i.a((JSONArray)localList.get(j), 1), i.a((JSONArray)localList.get(j), 2), (byte)0);
          paramb.ab.add(locala);
          j += 1;
        }
      }
      paramb.ad = i.d(paramJSONObject, "available_area_codes");
      paramb.bs = i.a(paramJSONObject, "promotion_change_info");
      paramb.ac = i.d(paramJSONObject, "user_info");
      paramb.z = i.d(paramJSONObject, "rules");
      paramb.Z = i.c(paramJSONObject, "service_url");
      paramb.aa = i.c(paramJSONObject, "bind_url");
      paramb.ae = i.a(paramJSONObject, "empty_info");
      paramb.aY = i.a(paramJSONObject, "add_card_tip");
      paramb.aq = i.a(paramJSONObject, "pan");
      return i;
    }
  }
  
  public static boolean c(b paramb, JSONObject paramJSONObject)
  {
    boolean bool = false;
    paramb.aF = null;
    paramb.aF = i.c(paramJSONObject, "cardExpireMsgBox");
    if (paramb.aF == null) {
      paramb.aF = i.c(paramJSONObject, "openByCounterMsgBox");
    }
    if (paramb.aF == null) {
      paramb.aF = i.c(paramJSONObject, "restrictPayMsgBox");
    }
    if (paramb.aF != null)
    {
      paramb.aG = i.a(paramb.aF, "title");
      paramb.aH = i.a(paramb.aF, "text");
      paramJSONObject = i.c(paramb.aF, "func");
      JSONObject localJSONObject = i.c(paramb.aF, "cancel");
      paramb.aK = i.a(paramJSONObject, "label");
      paramb.aL = i.a(paramJSONObject, "action");
      paramb.aI = i.a(localJSONObject, "label");
      paramb.aJ = i.a(localJSONObject, "action");
      bool = true;
    }
    return bool;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/utils/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */