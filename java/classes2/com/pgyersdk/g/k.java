package com.pgyersdk.g;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.pgyersdk.activity.FeedbackActivity;
import com.pgyersdk.b.b;
import com.pgyersdk.i.e;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class k
  extends f
{
  private Context a;
  private Handler b;
  private String c;
  private String d;
  private List e;
  private File f;
  private String g;
  private ProgressDialog h;
  private boolean i;
  private int j;
  private String k;
  private String l;
  
  public k(Context paramContext, String paramString1, String paramString2, String paramString3, List paramList, File paramFile, String paramString4, Handler paramHandler, String paramString5)
  {
    this.a = paramContext;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramList;
    this.f = paramFile;
    this.g = paramString4;
    this.b = paramHandler;
    this.i = true;
    this.j = -1;
    this.k = paramString1;
    this.l = paramString5;
    if (paramContext != null) {
      com.pgyersdk.b.a.a(paramContext);
    }
  }
  
  private HashMap a()
  {
    localHashMap1 = new HashMap();
    localObject7 = null;
    localObject6 = null;
    localObject2 = localObject6;
    localObject1 = localObject7;
    try
    {
      localHashMap2 = new HashMap();
      localObject2 = localObject6;
      localObject1 = localObject7;
      localHashMap2.put("agKey", com.pgyersdk.b.a.l);
      localObject2 = localObject6;
      localObject1 = localObject7;
      localHashMap2.put("from", com.pgyersdk.b.a.f);
      localObject2 = localObject6;
      localObject1 = localObject7;
      localHashMap2.put("content", this.d);
      localObject2 = localObject6;
      localObject1 = localObject7;
      localHashMap2.put("versionCode", com.pgyersdk.b.a.b);
      localObject2 = localObject6;
      localObject1 = localObject7;
      localHashMap2.put("version", com.pgyersdk.b.a.d);
      localObject2 = localObject6;
      localObject1 = localObject7;
      localHashMap2.put("deviceId", com.pgyersdk.b.a.i);
      localObject2 = localObject6;
      localObject1 = localObject7;
      localHashMap2.put("deviceName", com.pgyersdk.b.a.g);
      localObject2 = localObject6;
      localObject1 = localObject7;
      localHashMap2.put("deviceModel", com.pgyersdk.b.a.f);
      localObject2 = localObject6;
      localObject1 = localObject7;
      localHashMap2.put("osVersion", com.pgyersdk.b.a.e);
      localObject2 = localObject6;
      localObject1 = localObject7;
      localHashMap2.put("resolution", com.pgyersdk.b.a.j);
      localObject2 = localObject6;
      localObject1 = localObject7;
      localHashMap2.put("osType", "2");
      localObject2 = localObject6;
      localObject1 = localObject7;
      if (!com.pgyersdk.b.a.a()) {
        break label793;
      }
      localObject4 = "1";
    }
    catch (Exception localException)
    {
      HashMap localHashMap2;
      for (;;)
      {
        Object localObject4;
        Object localObject8;
        localObject1 = localObject2;
        localException.printStackTrace();
        return localHashMap1;
        localObject5 = "2";
      }
      localObject2 = localObject6;
      localObject1 = localObject7;
      Object localObject5 = new e(this.c).a("POST").a(localHashMap2, this.a, this.f, (List)localObject5).a();
      localObject2 = localObject5;
      localObject1 = localObject5;
      ((HttpURLConnection)localObject5).connect();
      localObject2 = localObject5;
      localObject1 = localObject5;
      localHashMap1.put("status", String.valueOf(((HttpURLConnection)localObject5).getResponseCode()));
      localObject2 = localObject5;
      localObject1 = localObject5;
      localHashMap1.put("response", a((HttpURLConnection)localObject5));
      return localHashMap1;
    }
    finally
    {
      if (localObject1 == null) {
        break label904;
      }
      ((HttpURLConnection)localObject1).disconnect();
    }
    localObject2 = localObject6;
    localObject1 = localObject7;
    localHashMap2.put("jailBroken", localObject4);
    localObject2 = localObject6;
    localObject1 = localObject7;
    localObject4 = com.pgyersdk.e.a.a();
    localObject2 = localObject6;
    localObject1 = localObject7;
    localHashMap2.put("freeSpace", localObject4[1] + " / " + localObject4[0]);
    localObject2 = localObject6;
    localObject1 = localObject7;
    if (com.pgyersdk.e.a.c())
    {
      localObject2 = localObject6;
      localObject1 = localObject7;
      localObject4 = com.pgyersdk.e.a.b();
      localObject2 = localObject6;
      localObject1 = localObject7;
      localHashMap2.put("freeSdc", localObject4[1] + " / " + localObject4[0]);
    }
    localObject2 = localObject6;
    localObject1 = localObject7;
    localObject8 = com.pgyersdk.e.a.b(this.a);
    localObject4 = "";
    localObject2 = localObject6;
    localObject1 = localObject7;
    if (localObject8.length == 2)
    {
      localObject2 = localObject6;
      localObject1 = localObject7;
      localObject4 = localObject8[1] + " / " + localObject8[0];
    }
    localObject2 = localObject6;
    localObject1 = localObject7;
    localHashMap2.put("freeRam", localObject4);
    localObject2 = localObject6;
    localObject1 = localObject7;
    localHashMap2.put("battery", com.pgyersdk.e.a.g(this.a));
    localObject2 = localObject6;
    localObject1 = localObject7;
    localHashMap2.put("protrait", this.a.getResources().getConfiguration().orientation + "");
    localObject4 = "";
    localObject2 = localObject6;
    localObject1 = localObject7;
    localObject8 = com.pgyersdk.e.a.a(this.a);
    localObject2 = localObject6;
    localObject1 = localObject7;
    if (((Map)localObject8).containsKey("network_type"))
    {
      localObject2 = localObject6;
      localObject1 = localObject7;
      localObject4 = (String)((Map)localObject8).get("network_type");
    }
    localObject2 = localObject6;
    localObject1 = localObject7;
    localHashMap2.put("network", localObject4);
    localObject2 = localObject6;
    localObject1 = localObject7;
    localHashMap2.put("sdkVersion", com.pgyersdk.b.a.k);
    localObject2 = localObject6;
    localObject1 = localObject7;
    localHashMap2.put("_api_key", "305092bc73c180b55c26012a94809131");
    localObject2 = localObject6;
    localObject1 = localObject7;
    localHashMap2.put("mail", this.k);
    localObject2 = localObject6;
    localObject1 = localObject7;
    localHashMap2.put("moreParams", this.l);
    localObject2 = localObject6;
    localObject1 = localObject7;
    localObject4 = new ArrayList();
    localObject2 = localObject6;
    localObject1 = localObject7;
    localObject8 = this.e.iterator();
    for (;;)
    {
      localObject2 = localObject6;
      localObject1 = localObject7;
      if (!((Iterator)localObject8).hasNext()) {
        break;
      }
      localObject2 = localObject6;
      localObject1 = localObject7;
      ((List)localObject4).add(Uri.fromFile(new File((String)((Iterator)localObject8).next())));
    }
  }
  
  protected HashMap a(Void... paramVarArgs)
  {
    return a();
  }
  
  protected void a(HashMap paramHashMap)
  {
    if (this.h != null) {}
    for (;;)
    {
      try
      {
        this.h.dismiss();
        this.h = null;
        if ((this.a instanceof FeedbackActivity))
        {
          ((FeedbackActivity)this.a).destroy();
          ((Activity)this.a).finish();
        }
      }
      catch (Exception localException)
      {
        try
        {
          paramHashMap = (String)paramHashMap.get("response");
          Message localMessage = new Message();
          if (!com.pgyersdk.i.k.a(paramHashMap))
          {
            if (new JSONObject(paramHashMap).getInt("code") == 0)
            {
              localMessage.what = 20001;
              this.b.sendMessage(localMessage);
              return;
              localException = localException;
              localException.printStackTrace();
            }
            else
            {
              localException.what = 20002;
            }
          }
          else {
            localException.what = 20002;
          }
        }
        catch (Exception paramHashMap)
        {
          paramHashMap = new Message();
          paramHashMap.what = 20002;
          this.b.sendMessage(paramHashMap);
          return;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  protected void onPreExecute()
  {
    String str = b.a(1061);
    if (((this.h == null) || (!this.h.isShowing())) && (this.i)) {
      this.h = ProgressDialog.show(this.a, "", str, true, false);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/g/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */