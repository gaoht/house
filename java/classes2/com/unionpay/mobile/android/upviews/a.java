package com.unionpay.mobile.android.upviews;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upwidget.q.a;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.widgets.UPWidget;
import com.unionpay.mobile.android.widgets.aa;
import com.unionpay.mobile.android.widgets.aa.a;
import com.unionpay.mobile.android.widgets.ad;
import com.unionpay.mobile.android.widgets.ae;
import com.unionpay.mobile.android.widgets.af;
import com.unionpay.mobile.android.widgets.ah;
import com.unionpay.mobile.android.widgets.ah.a;
import com.unionpay.mobile.android.widgets.aj;
import com.unionpay.mobile.android.widgets.aj.a;
import com.unionpay.mobile.android.widgets.ao;
import com.unionpay.mobile.android.widgets.ap;
import com.unionpay.mobile.android.widgets.ap.a;
import com.unionpay.mobile.android.widgets.at;
import com.unionpay.mobile.android.widgets.au;
import com.unionpay.mobile.android.widgets.av;
import com.unionpay.mobile.android.widgets.bd;
import com.unionpay.mobile.android.widgets.e;
import com.unionpay.mobile.android.widgets.g;
import com.unionpay.mobile.android.widgets.m;
import com.unionpay.mobile.android.widgets.p;
import com.unionpay.mobile.android.widgets.u;
import com.unionpay.mobile.android.widgets.y;
import com.unionpay.mobile.android.widgets.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends LinearLayout
  implements q.a, aa.a, ah.a, aj.a, ap.a
{
  private Context a = null;
  private m b = null;
  private ArrayList<z> c = null;
  private long d = 0L;
  private b e = null;
  private boolean f = false;
  private boolean g = true;
  private JSONObject h = null;
  private String i = "";
  
  public a(Context paramContext, JSONArray paramJSONArray, long paramLong, b paramb, String paramString1, boolean paramBoolean, String paramString2)
  {
    this(paramContext, paramJSONArray, paramLong, paramb, paramString1, paramBoolean, paramString2, (byte)0);
  }
  
  private a(Context paramContext, JSONArray paramJSONArray, long paramLong, b paramb, String paramString1, boolean paramBoolean, String paramString2, byte paramByte)
  {
    this(paramContext, paramJSONArray, paramLong, paramb, paramString1, paramBoolean, paramString2, '\000');
  }
  
  private a(Context paramContext, JSONArray paramJSONArray, long paramLong, b paramb, String paramString1, boolean paramBoolean, String paramString2, char paramChar)
  {
    this(paramContext, paramJSONArray, paramLong, paramb, paramString1, paramBoolean, false, null, null, paramString2);
  }
  
  public a(Context paramContext, JSONArray paramJSONArray1, long paramLong, b paramb, String paramString1, boolean paramBoolean1, boolean paramBoolean2, z paramz, JSONArray paramJSONArray2, String paramString2)
  {
    super(paramContext);
    this.a = paramContext;
    this.d = paramLong;
    this.e = paramb;
    this.f = paramBoolean2;
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    int j = com.unionpay.mobile.android.global.a.f;
    paramContext.bottomMargin = j;
    paramContext.topMargin = j;
    setLayoutParams(paramContext);
    setPadding(0, 0, 0, 0);
    setOrientation(1);
    setBackgroundColor(0);
    a(paramJSONArray1, paramString1, paramBoolean1, paramz, paramJSONArray2, paramString2);
  }
  
  public a(Context paramContext, JSONArray paramJSONArray, b paramb, String paramString)
  {
    this(paramContext, paramJSONArray, -1L, paramb, null, true, paramString);
  }
  
  private a a(boolean paramBoolean)
  {
    a locala = new a("");
    if (this.c != null)
    {
      localObject1 = this.c.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (z)((Iterator)localObject1).next();
        if ((localObject2 instanceof af))
        {
          if (!((z)localObject2).c()) {
            locala.a(-1, String.format(c.bD.aC, new Object[] { c.bD.aE }));
          } else if (!((z)localObject2).b()) {
            locala.a(-1, String.format(c.bD.aD, new Object[] { c.bD.aE }));
          }
        }
        else
        {
          if (((z)localObject2).c()) {
            break label179;
          }
          locala.a(-1, String.format(c.bD.aC, new Object[] { ((z)localObject2).u() }));
        }
      }
    }
    for (;;)
    {
      if (locala.a()) {
        break label217;
      }
      return locala;
      label179:
      if (((z)localObject2).b()) {
        break;
      }
      locala.a(-1, String.format(c.bD.aD, new Object[] { ((z)localObject2).u() }));
    }
    label217:
    Object localObject1 = new StringBuffer();
    if (this.c != null)
    {
      int j = 0;
      while (j < this.c.size())
      {
        localObject2 = (z)this.c.get(j);
        if ((!(localObject2 instanceof ad)) && ((!(localObject2 instanceof UPWidget)) || (paramBoolean)) && (!TextUtils.isEmpty(((z)this.c.get(j)).h())) && (((z)this.c.get(j)).f()))
        {
          ((StringBuffer)localObject1).append(",");
          ((StringBuffer)localObject1).append(((z)this.c.get(j)).h());
        }
        j += 1;
      }
    }
    Object localObject2 = ((StringBuffer)localObject1).toString();
    localObject1 = localObject2;
    if (((String)localObject2).length() > 1) {
      localObject1 = ((String)localObject2).substring(1);
    }
    locala.a(0, (String)localObject1);
    return locala;
  }
  
  private static z a(List<z> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      z localz = (z)paramList.next();
      if (localz.q().equalsIgnoreCase(paramString)) {
        return localz;
      }
    }
    return null;
  }
  
  public final a a()
  {
    a locala = new a("");
    z localz = a(this.c, "pin");
    if (localz != null)
    {
      if (localz.c()) {
        break label66;
      }
      locala.a(-1, String.format(c.bD.aC, new Object[] { localz.u() }));
    }
    while (!locala.a())
    {
      return locala;
      label66:
      if (!localz.b()) {
        locala.a(-1, String.format(c.bD.aD, new Object[] { localz.u() }));
      }
    }
    locala.b = localz.a();
    return locala;
  }
  
  public final String a(String paramString)
  {
    z localz = a(this.c, paramString);
    String str = "";
    if (localz != null) {
      str = localz.h();
    }
    j.a("uppay", " name:" + paramString + ", value:" + str);
    return str;
  }
  
  public final void a(int paramInt)
  {
    z localz = a(this.c, "sms");
    if (localz != null) {
      ((ap)localz).a(paramInt);
    }
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    z localz = c("promotion");
    if ((localz != null) && ((localz instanceof aj))) {
      ((aj)localz).b(paramOnClickListener);
    }
  }
  
  public final void a(m paramm, JSONObject paramJSONObject)
  {
    this.b = paramm;
    this.h = paramJSONObject;
  }
  
  public final void a(u paramu, String paramString)
  {
    boolean bool;
    if (this.e != null)
    {
      if ((paramString != null) && (paramString.length() > 0)) {
        break label31;
      }
      bool = true;
    }
    for (;;)
    {
      this.e.a(bool);
      return;
      label31:
      if (this.c != null)
      {
        paramString = this.c.iterator();
        for (;;)
        {
          if (paramString.hasNext())
          {
            z localz = (z)paramString.next();
            if (((localz instanceof aa)) && (!((aa)localz).a(paramu)) && (!((aa)localz).c()))
            {
              bool = true;
              break;
            }
          }
        }
      }
      bool = false;
    }
  }
  
  public final void a(z paramz)
  {
    boolean bool = paramz instanceof ap;
    if ((this.e == null) || (!bool)) {
      return;
    }
    d();
    a locala = new a("");
    Object localObject2 = a(this.c, "mobile");
    z localz3 = a(this.c, "pan");
    z localz2 = a(this.c, "card");
    z localz1 = a(this.c, "area_code");
    Object localObject1 = "";
    paramz = (z)localObject1;
    if (localz3 != null)
    {
      if (localz3.c()) {
        break label150;
      }
      locala.a(-1, String.format(c.bD.aC, new Object[] { c.bD.aE }));
      paramz = (z)localObject1;
    }
    while (!locala.a())
    {
      this.e.a(locala);
      return;
      label150:
      if (!localz3.b())
      {
        locala.a(-1, String.format(c.bD.aD, new Object[] { c.bD.aE }));
        paramz = (z)localObject1;
      }
      else
      {
        paramz = "" + localz3.h();
      }
    }
    localObject1 = paramz;
    if (localObject2 != null)
    {
      if (((z)localObject2).c()) {
        break label282;
      }
      locala.a(-1, String.format(c.bD.aC, new Object[] { ((z)localObject2).u() }));
      localObject1 = paramz;
    }
    while (!locala.a())
    {
      this.e.a(locala);
      return;
      label282:
      if (!((z)localObject2).b())
      {
        locala.a(-1, String.format(c.bD.aD, new Object[] { ((z)localObject2).u() }));
        localObject1 = paramz;
      }
      else
      {
        localObject1 = new StringBuilder().append(paramz);
        if (paramz.length() == 0) {}
        for (paramz = "";; paramz = ",")
        {
          paramz = paramz;
          localObject1 = paramz + ((z)localObject2).h();
          break;
        }
      }
    }
    paramz = (z)localObject1;
    if (localz2 != null)
    {
      paramz = (z)localObject1;
      if (localz2.h().length() > 0)
      {
        localObject2 = new StringBuilder().append((String)localObject1);
        if (((String)localObject1).length() != 0) {
          break label554;
        }
        paramz = "";
        paramz = paramz;
        paramz = paramz + localz2.h();
      }
    }
    localObject1 = paramz;
    if (localz1 != null)
    {
      localObject1 = paramz;
      if (localz1.h().length() > 0)
      {
        localObject1 = new StringBuilder().append(paramz);
        if (paramz.length() != 0) {
          break label560;
        }
      }
    }
    label554:
    label560:
    for (paramz = "";; paramz = ",")
    {
      paramz = paramz;
      localObject1 = paramz + localz1.h();
      locala.a(0, (String)localObject1);
      this.e.a(locala);
      return;
      paramz = ",";
      break;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (this.e != null)
    {
      d();
      this.e.c(paramString1, paramString2);
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if ("promotion".equalsIgnoreCase(paramString))
    {
      localObject = "instalment";
      paramString = c(paramString);
      localObject = c((String)localObject);
      if (paramString != null) {
        break label38;
      }
    }
    label38:
    label110:
    do
    {
      do
      {
        return;
        localObject = "promotion";
        break;
        if (!(paramString instanceof aj)) {
          break label110;
        }
        ((aj)paramString).a(paramBoolean);
      } while ((localObject == null) || (!((p)localObject).g()));
      paramString = Toast.makeText(this.a, this.i, 1);
      if (!(paramString instanceof Toast)) {
        paramString.show();
      }
      for (;;)
      {
        ((p)localObject).b(false);
        return;
        VdsAgent.showToast((Toast)paramString);
      }
    } while (!(paramString instanceof p));
    if (paramBoolean) {
      this.e.t();
    }
    ((p)paramString).b(paramBoolean);
  }
  
  public final void a(JSONArray paramJSONArray)
  {
    z localz = c("promotion");
    if ((localz != null) && ((localz instanceof aj))) {
      ((aj)localz).a(paramJSONArray);
    }
  }
  
  public final void a(JSONArray paramJSONArray, String paramString)
  {
    z localz = c("promotion");
    if ((localz != null) && ((localz instanceof aj))) {
      ((aj)localz).a(paramJSONArray, paramString);
    }
  }
  
  public final void a(JSONArray paramJSONArray1, String paramString1, boolean paramBoolean, z paramz, JSONArray paramJSONArray2, String paramString2)
  {
    if ((paramJSONArray1 == null) || (paramJSONArray1.length() <= 0)) {}
    int j;
    int k;
    Object localObject5;
    Object localObject1;
    do
    {
      return;
      if (this.c != null) {
        break;
      }
      this.c = new ArrayList(1);
      removeAllViews();
      setBackgroundColor(-1);
      new LinearLayout.LayoutParams(-1, -2);
      j = com.unionpay.mobile.android.global.a.f;
      k = com.unionpay.mobile.android.global.a.I - com.unionpay.mobile.android.global.a.f * 4;
      j = 0;
      localObject5 = null;
      localObject1 = "";
    } while (j >= paramJSONArray1.length());
    for (;;)
    {
      try
      {
        localObject6 = paramJSONArray1.getJSONObject(j);
        localObject3 = i.a((JSONObject)localObject6, "type");
        try
        {
          localContext = this.a;
          localObject1 = null;
          localObject7 = i.a((JSONObject)localObject6, "type");
          if ("pan".equalsIgnoreCase((String)localObject7)) {
            localObject1 = new af(localContext, k, (JSONObject)localObject6, paramString2);
          }
        }
        catch (JSONException localJSONException1)
        {
          localObject2 = null;
        }
      }
      catch (JSONException localJSONException2)
      {
        Object localObject6;
        Object localObject3;
        Context localContext;
        Object localObject7;
        Object localObject4 = localObject2;
        Object localObject2 = null;
        continue;
      }
      try
      {
        localObject6 = new LinearLayout.LayoutParams(-1, -2);
        localObject5 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject6;
        if (localObject5 != null)
        {
          if (!(localObject5 instanceof UPWidget)) {
            continue;
          }
          ((UPWidget)localObject5).a(this.d);
          ((UPWidget)localObject5).b(paramString1);
          ((UPWidget)localObject5).b(paramBoolean);
          if (((localObject5 instanceof aa)) && (!(localObject5 instanceof bd))) {
            ((aa)localObject5).a(this);
          }
          if (!"instalment".equals(localObject1))
          {
            localObject6 = new LinearLayout(this.a);
            ((LinearLayout)localObject6).setBackgroundColor(-3419943);
            localObject7 = new LinearLayout.LayoutParams(-1, 1);
            if (j == 0) {
              continue;
            }
            ((LinearLayout.LayoutParams)localObject7).leftMargin = com.unionpay.mobile.android.utils.f.a(this.a, 10.0F);
            if ((!this.f) || (j != 0) || (paramz == null)) {
              continue;
            }
            addView(paramz, (ViewGroup.LayoutParams)localObject3);
            if (((z)localObject5).getVisibility() == 0) {
              addView((View)localObject6, (ViewGroup.LayoutParams)localObject7);
            }
            addView((View)localObject5, (ViewGroup.LayoutParams)localObject3);
            if ((j == paramJSONArray1.length() - 1) || ((localObject5 instanceof aj)))
            {
              localObject6 = new LinearLayout(this.a);
              ((LinearLayout)localObject6).setBackgroundColor(-3419943);
              addView((View)localObject6, new LinearLayout.LayoutParams(-1, 1));
            }
          }
          this.c.add(localObject5);
        }
        j += 1;
        localObject5 = localObject3;
      }
      catch (JSONException localJSONException3)
      {
        continue;
      }
      this.c.clear();
      break;
      if ("mobile".equalsIgnoreCase((String)localObject7))
      {
        localObject1 = new ah(localContext, k, (JSONObject)localObject6, paramString2);
        continue;
        j.c("uppay", "json parser exception!!! - UPRuleView");
        localObject6 = localObject5;
        localObject5 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject6;
      }
      else if ("sms".equalsIgnoreCase((String)localObject7))
      {
        localObject2 = new ap(localContext, k, (JSONObject)localObject6, paramString2, (byte)0);
      }
      else if ("cvn2".equalsIgnoreCase((String)localObject7))
      {
        localObject2 = new e(localContext, k, (JSONObject)localObject6, paramString2);
      }
      else if ("expire".equalsIgnoreCase((String)localObject7))
      {
        localObject2 = new av(localContext, k, (JSONObject)localObject6, paramString2);
      }
      else if ("pwd".equalsIgnoreCase((String)localObject7))
      {
        localObject2 = new UPWidget(localContext, this.d, k, (JSONObject)localObject6, paramString2);
      }
      else if ("text".equalsIgnoreCase((String)localObject7))
      {
        localObject2 = new at(localContext, k, (JSONObject)localObject6, paramString2);
      }
      else if ("string".equalsIgnoreCase((String)localObject7))
      {
        localObject2 = new ad(localContext, (JSONObject)localObject6, paramString2);
      }
      else if ("cert_id".equalsIgnoreCase((String)localObject7))
      {
        localObject2 = new com.unionpay.mobile.android.widgets.f(localContext, k, (JSONObject)localObject6, paramString2);
      }
      else if ("cert_type".equalsIgnoreCase((String)localObject7))
      {
        localObject2 = new g(localContext, (JSONObject)localObject6, paramString2);
      }
      else if ("name".equalsIgnoreCase((String)localObject7))
      {
        localObject2 = new ae(localContext, k, (JSONObject)localObject6, paramString2);
      }
      else if ("hidden".equalsIgnoreCase((String)localObject7))
      {
        localObject2 = new y(localContext, (JSONObject)localObject6, paramString2);
      }
      else if ("user_name".equalsIgnoreCase((String)localObject7))
      {
        localObject2 = new au(localContext, k, (JSONObject)localObject6, paramString2);
      }
      else if ("password".equalsIgnoreCase((String)localObject7))
      {
        localObject2 = new ao(localContext, k, (JSONObject)localObject6, paramString2);
      }
      else if ("point".equalsIgnoreCase((String)localObject7))
      {
        localObject2 = new bd(localContext, k, (JSONObject)localObject6, paramString2);
      }
      else if ("instalment".equalsIgnoreCase((String)localObject7))
      {
        localObject2 = new p(this.a, (JSONObject)localObject6, paramString2);
        ((p)localObject2).a(this);
      }
      else if ("promotion".equalsIgnoreCase((String)localObject7))
      {
        localObject2 = new aj(this.a, (JSONObject)localObject6, paramString2, this);
        ((aj)localObject2).a(this);
      }
      else if ("area_code".equalsIgnoreCase((String)localObject7))
      {
        localObject2 = new com.unionpay.mobile.android.widgets.a(this.a, (JSONObject)localObject6, paramJSONArray2, paramString2);
        continue;
        if ((localObject5 instanceof ap))
        {
          ((ap)localObject5).a(this);
        }
        else if ((localObject5 instanceof ah))
        {
          ((ah)localObject5).a(this);
          continue;
          if (this.f)
          {
            ((LinearLayout.LayoutParams)localObject7).leftMargin = com.unionpay.mobile.android.utils.f.a(this.a, 10.0F);
            setPadding(0, 0, 0, 0);
            continue;
            if (((z)localObject5).getVisibility() == 0)
            {
              addView((View)localObject6, (ViewGroup.LayoutParams)localObject7);
              addView((View)localObject5, (ViewGroup.LayoutParams)localObject3);
              if (((localObject5 instanceof af)) && (paramz != null)) {
                addView(paramz, (ViewGroup.LayoutParams)localObject3);
              }
            }
          }
        }
      }
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    String str = i.a(paramJSONObject, "instalment_empty_info");
    if (!TextUtils.isEmpty(str))
    {
      ((p)c("instalment")).a(false);
      ((p)c("instalment")).b(false);
      paramJSONObject = Toast.makeText(this.a, str, 1);
      if (!(paramJSONObject instanceof Toast))
      {
        paramJSONObject.show();
        return;
      }
      VdsAgent.showToast((Toast)paramJSONObject);
      return;
    }
    ((p)c("instalment")).a(true);
    ((p)c("instalment")).b(true);
    ((p)a(this.c, "instalment_policy")).a(i.d(paramJSONObject, "new_instalments"));
  }
  
  public final a b()
  {
    return a(true);
  }
  
  public final String b(String paramString)
  {
    z localz = a(this.c, paramString);
    paramString = "";
    if (localz != null) {
      paramString = localz.a();
    }
    return paramString;
  }
  
  public final void b(View.OnClickListener paramOnClickListener)
  {
    z localz = c("promotion");
    if ((localz != null) && ((localz instanceof aj))) {
      ((aj)localz).c(paramOnClickListener);
    }
  }
  
  public final z c(String paramString)
  {
    if ((this.c == null) || (this.c.size() <= 0) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      z localz = (z)localIterator.next();
      if (localz.r().equalsIgnoreCase(paramString)) {
        return localz;
      }
    }
    return null;
  }
  
  public final HashMap<String, String> c()
  {
    if (!a(false).a()) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    if (this.c != null)
    {
      int j = 0;
      while (j < this.c.size())
      {
        z localz = (z)this.c.get(j);
        if ((!(localz instanceof ad)) && (!(localz instanceof UPWidget)) && (!TextUtils.isEmpty(localz.a()))) {
          localHashMap.put(localz.q(), localz.a());
        }
        j += 1;
      }
    }
    return localHashMap;
  }
  
  public final void c(View.OnClickListener paramOnClickListener)
  {
    z localz = c("promotion");
    if ((localz != null) && ((localz instanceof aj))) {
      ((aj)localz).a(paramOnClickListener);
    }
  }
  
  public final void d(String paramString)
  {
    this.i = paramString;
  }
  
  public final boolean d()
  {
    if (this.c != null)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        z localz = (z)localIterator.next();
        if (((localz instanceof UPWidget)) && (((UPWidget)localz).j())) {
          ((UPWidget)localz).k();
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
      return bool;
    }
  }
  
  public final void e(String paramString)
  {
    if (this.e != null) {
      this.e.c(paramString);
    }
  }
  
  public final boolean e()
  {
    if (this.c != null)
    {
      Iterator localIterator = this.c.iterator();
      z localz;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localz = (z)localIterator.next();
      } while ((!(localz instanceof aa)) || (((aa)localz).c()));
    }
    for (int j = 1; j == 0; j = 0) {
      return true;
    }
    return false;
  }
  
  public final void f()
  {
    if ((this.c == null) || (this.c.size() <= 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        z localz = (z)localIterator.next();
        if (((localz instanceof UPWidget)) || ((localz instanceof e)) || ((localz instanceof av))) {
          ((aa)localz).g();
        }
      }
    }
  }
  
  public final void g()
  {
    z localz = c("instalment");
    Toast localToast;
    if ((localz != null) && (((p)localz).g()))
    {
      localToast = Toast.makeText(this.a, this.i, 1);
      if ((localToast instanceof Toast)) {
        break label55;
      }
      localToast.show();
    }
    for (;;)
    {
      ((p)localz).b(false);
      return;
      label55:
      VdsAgent.showToast((Toast)localToast);
    }
  }
  
  public final class a
  {
    public int a = 0;
    public String b;
    
    a(String paramString)
    {
      this.b = paramString;
    }
    
    public final void a(int paramInt, String paramString)
    {
      this.b = paramString;
      this.a = paramInt;
    }
    
    public final boolean a()
    {
      return this.a == 0;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(a.a parama);
    
    public abstract void a(boolean paramBoolean);
    
    public abstract void c(String paramString);
    
    public abstract void c(String paramString1, String paramString2);
    
    public abstract void t();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/upviews/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */