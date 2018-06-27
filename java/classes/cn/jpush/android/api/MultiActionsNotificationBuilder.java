package cn.jpush.android.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.c.f;
import cn.jpush.android.d;
import cn.jpush.android.service.PushReceiver;
import cn.jpush.android.ui.PopWinActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MultiActionsNotificationBuilder
  extends DefaultPushNotificationBuilder
{
  private static final String NOTI_ACT_EXTRA_STR;
  private static final String NOTI_ACT_RES_ID;
  private static final String NOTI_ACT_TEXT;
  private static final String TAG;
  private static final String[] z;
  private JSONArray actionJSONArray = new JSONArray();
  protected Context mContext;
  
  static
  {
    String[] arrayOfString = new String[10];
    int j = 0;
    Object localObject1 = "f\\\023W'aP\006J(g]8_\"|Z\bP\036zV\024a(l";
    int i = 9;
    Object localObject2 = arrayOfString;
    Object localObject4 = localObject2;
    localObject1 = ((String)localObject1).toCharArray();
    int k = localObject1.length;
    int i1 = 0;
    int m = 0;
    int i4 = i;
    Object localObject3 = localObject1;
    int i3 = j;
    localObject2 = localObject4;
    int n = k;
    int i2;
    if (k <= 1)
    {
      i2 = i;
      label65:
      n = m;
      label68:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 65;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label68;
        NOTI_ACT_RES_ID = (String)localObject1;
        localObject1 = "f\\\023W'aP\006J(g]8_\"|Z\bP\036|V\037J";
        i = 10;
        j = i3;
        break;
        NOTI_ACT_TEXT = (String)localObject1;
        localObject1 = "EF\013J(IP\023W.f@)Q5aU\016] |Z\bP\003}Z\013Z$z";
        i = 11;
        j = i3;
        break;
        TAG = (String)localObject1;
        localObject1 = "f\\\023W'aP\006J(g]8_\"|Z\bP\036mK\023L W@\023L(fT";
        i = 12;
        j = i3;
        break;
        NOTI_ACT_EXTRA_STR = (String)localObject1;
        localObject1 = "K\\\tM5zF\004JaiP\023W.f\023\001_(dV\003\037";
        i = -1;
        j = i3;
        break;
      }
      i1 = n;
      n = k;
      localObject2 = localObject4;
      i3 = j;
      localObject3 = localObject1;
      i4 = i2;
      i2 = i4;
      localObject1 = localObject3;
      j = i3;
      localObject4 = localObject2;
      k = n;
      m = i1;
      if (n > i1) {
        break label65;
      }
      localObject1 = new String((char[])localObject3).intern();
      switch (i4)
      {
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      default: 
        localObject2[i3] = localObject1;
        j = 1;
        localObject1 = "IW\003\036/gG\016X(kR\023W.f\023\006]5a\\\t\004azV\024\036l(";
        i = 0;
        localObject2 = arrayOfString;
        break;
      case 0: 
        localObject2[i3] = localObject1;
        j = 2;
        localObject1 = "$\023\002F5zRG\023a";
        i = 1;
        localObject2 = arrayOfString;
        break;
      case 1: 
        localObject2[i3] = localObject1;
        j = 3;
        localObject1 = "XR\025M$(r\004J(g]GX3g^GN3mU\002L$fP\002\0361zV\001[3m]\004[anR\016R$l\022";
        i = 2;
        localObject2 = arrayOfString;
        break;
      case 2: 
        localObject2[i3] = localObject1;
        j = 4;
        localObject1 = "LV\021W\"m\023\020W5`\0234z\nWe\"l\022A|)\036}(\002Q\022a{[\bIagA\016Y(fR\013\036/gG\016X(kR\023W.f\023\024J8dVI";
        i = 3;
        localObject2 = arrayOfString;
        break;
      case 3: 
        localObject2[i3] = localObject1;
        j = 5;
        localObject1 = "k]IT1}@\017\020 fW\025Q(l\035)q\025Au.\002Ig.q\017Wr$j\bG}8{\031\\a&";
        i = 4;
        localObject2 = arrayOfString;
        break;
      case 4: 
        localObject2[i3] = localObject1;
        j = 6;
        localObject1 = "k]IT1}@\017\020 fW\025Q(l\035\016P5m]\023\020\017Gg.x\bKr3w\016Fl$r\bKx8\002\\z(p\036Xa(f\030";
        i = 5;
        localObject2 = arrayOfString;
        break;
      case 5: 
        localObject2[i3] = localObject1;
        j = 7;
        localObject1 = "$\023\024J3a]\000\036l(";
        i = 6;
        localObject2 = arrayOfString;
        break;
      case 6: 
        localObject2[i3] = localObject1;
        j = 8;
        localObject1 = "a@)Q5aU\016] |Z\bP";
        i = 7;
        localObject2 = arrayOfString;
        break;
      case 7: 
        localObject2[i3] = localObject1;
        j = 9;
        localObject1 = "XR\025M$(Q\022W-lV\025\036'z\\\n\0361zV\001[3m]\004[anR\016R$l\022";
        i = 8;
        localObject2 = arrayOfString;
        break;
      case 8: 
        localObject2[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 8;
        continue;
        i = 51;
        continue;
        i = 103;
        continue;
        i = 62;
      }
    }
  }
  
  public MultiActionsNotificationBuilder(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  static PushNotificationBuilder parseFromPreference(String paramString)
  {
    MultiActionsNotificationBuilder localMultiActionsNotificationBuilder = new MultiActionsNotificationBuilder(d.e);
    try
    {
      localMultiActionsNotificationBuilder.actionJSONArray = new JSONArray(paramString);
      return localMultiActionsNotificationBuilder;
    }
    catch (JSONException paramString)
    {
      f.h(TAG, z[9]);
      paramString.printStackTrace();
    }
    return localMultiActionsNotificationBuilder;
  }
  
  public void addJPushAction(int paramInt, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(NOTI_ACT_RES_ID, paramInt);
      localJSONObject.put(NOTI_ACT_TEXT, paramString1);
      localJSONObject.put(NOTI_ACT_EXTRA_STR, paramString2);
      this.actionJSONArray.put(localJSONObject);
      f.e(TAG, this.actionJSONArray.toString());
      return;
    }
    catch (JSONException paramString1)
    {
      f.h(TAG, z[0]);
      paramString1.printStackTrace();
    }
  }
  
  @TargetApi(11)
  Notification getNotification(Notification.Builder paramBuilder)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 16) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.actionJSONArray.length()) {
        try
        {
          JSONObject localJSONObject = this.actionJSONArray.getJSONObject(i);
          Object localObject = new Intent(z[6]);
          ((Intent)localObject).putExtra(z[5], localJSONObject.getString(NOTI_ACT_EXTRA_STR));
          if (JCoreInterface.getRuningFlag())
          {
            ((Intent)localObject).setClass(this.mContext, PopWinActivity.class);
            ((Intent)localObject).putExtra(z[8], true);
          }
          for (localObject = PendingIntent.getActivity(this.mContext, i, (Intent)localObject, 134217728);; localObject = PendingIntent.getBroadcast(this.mContext, i, (Intent)localObject, 134217728))
          {
            f.e(TAG, z[1] + localJSONObject.getInt(NOTI_ACT_RES_ID) + z[7] + localJSONObject.getString(NOTI_ACT_TEXT) + z[2] + localJSONObject.getString(NOTI_ACT_EXTRA_STR));
            paramBuilder.addAction(localJSONObject.getInt(NOTI_ACT_RES_ID), localJSONObject.getString(NOTI_ACT_TEXT), (PendingIntent)localObject).setAutoCancel(true);
            break;
            ((Intent)localObject).setClass(this.mContext, PushReceiver.class);
          }
          return paramBuilder.build();
        }
        catch (JSONException localJSONException)
        {
          f.h(TAG, z[3]);
          localJSONException.printStackTrace();
        }
      }
      f.e(TAG, z[4]);
      return paramBuilder.getNotification();
      i += 1;
    }
  }
  
  public String toString()
  {
    return this.actionJSONArray.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/api/MultiActionsNotificationBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */