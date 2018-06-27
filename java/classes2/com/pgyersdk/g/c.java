package com.pgyersdk.g;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.graphics.Color;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.pgyersdk.i.g;
import com.pgyersdk.i.i;
import com.pgyersdk.i.k;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends a
{
  protected boolean e = false;
  protected String f = "";
  private Activity g = null;
  private AlertDialog h = null;
  private String i;
  
  public c(Activity paramActivity, String paramString1, String paramString2, com.pgyersdk.h.b paramb, boolean paramBoolean)
  {
    super(paramActivity, paramString1, paramString2, paramb);
    this.g = paramActivity;
    this.e = paramBoolean;
  }
  
  @TargetApi(11)
  private void a(String paramString)
  {
    Object localObject4 = com.pgyersdk.b.b.a(this.c, 514);
    Object localObject3 = localObject4;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localObject1 = localObject4;
      localObject3 = localObject4;
      if ("0".equals(localJSONObject.getString("code")))
      {
        localObject3 = localObject4;
        localJSONObject = localJSONObject.getJSONObject("data");
        localObject3 = localObject4;
        if (localJSONObject.has("lastBuild"))
        {
          localObject3 = localObject4;
          d = localJSONObject.getString("lastBuild");
          localObject3 = localObject4;
          if (k.a(i.a(this.g, "buildNo")))
          {
            localObject3 = localObject4;
            i.a(this.g, "buildNo", d);
            return;
          }
        }
        localObject3 = localObject4;
        if (!localJSONObject.has("releaseNote")) {
          break label423;
        }
        localObject3 = localObject4;
        localObject4 = localJSONObject.getString("releaseNote");
        localObject3 = localObject4;
        this.f = localJSONObject.getString("downloadURL");
        localObject3 = localObject4;
        g.a("PgyerSDK", "There is a new version");
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (localJSONObject.has("appUrl"))
        {
          localObject3 = localObject4;
          this.i = localJSONObject.getString("appUrl");
          localObject1 = localObject4;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject1;
        label423:
        localJSONException.printStackTrace();
        Object localObject2 = localObject3;
        continue;
        VdsAgent.showDialog((AlertDialog)localObject2);
      }
    }
    if ((this.g != null) && (!this.g.isFinishing()))
    {
      localObject3 = new AlertDialog.Builder(this.g);
      ((AlertDialog.Builder)localObject3).setTitle(com.pgyersdk.b.b.a(this.c, 513));
      localObject4 = new TextView(this.g);
      ((TextView)localObject4).setText(com.pgyersdk.b.b.a(513));
      ((TextView)localObject4).setTextSize(22.0F);
      ((TextView)localObject4).setTextColor(Color.parseColor("#56bc94"));
      ((TextView)localObject4).setPadding(30, 20, 0, 20);
      ((TextView)localObject4).setBackgroundColor(Color.parseColor("#56bc94"));
      ((AlertDialog.Builder)localObject3).setMessage((CharSequence)localObject1);
      ((AlertDialog.Builder)localObject3).setNegativeButton(com.pgyersdk.b.b.a(this.c, 515), new d(this));
      ((AlertDialog.Builder)localObject3).setPositiveButton(com.pgyersdk.b.b.a(this.c, 516), new e(this));
      this.h = ((AlertDialog.Builder)localObject3).create();
      if ((this.g != null) && ((this.g == null) || (!this.g.isFinishing())))
      {
        localObject1 = this.h;
        if (!(localObject1 instanceof AlertDialog))
        {
          ((AlertDialog)localObject1).show();
          if (this.c == null) {
            return;
          }
          this.c.onUpdateAvailable(paramString);
          return;
          localObject3 = localObject4;
          if (this.c != null)
          {
            localObject3 = localObject4;
            this.c.onNoUpdateAvailable();
          }
          localObject3 = localObject4;
          g.a("PgyerSDK", "It's the latest version");
        }
      }
    }
  }
  
  public void a()
  {
    super.a();
    this.g = null;
    if (this.h != null)
    {
      this.h.dismiss();
      this.h = null;
    }
  }
  
  protected void a(HashMap paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("response");
    if ((!k.a(paramHashMap)) && (this.e)) {
      a(paramHashMap);
    }
  }
  
  protected void b()
  {
    super.b();
    this.g = null;
    this.h = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/g/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */