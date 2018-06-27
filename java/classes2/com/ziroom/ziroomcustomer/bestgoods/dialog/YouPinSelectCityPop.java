package com.ziroom.ziroomcustomer.bestgoods.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.location.BDLocation;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.a.b;
import com.ziroom.ziroomcustomer.bestgoods.model.ah;
import com.ziroom.ziroomcustomer.bestgoods.model.ah.a;
import com.ziroom.ziroomcustomer.e.c.a.e;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.util.t;
import com.ziroom.ziroomcustomer.util.t.a;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class YouPinSelectCityPop
  extends PopupWindow
{
  private boolean A;
  private LinearLayout B;
  private LinearLayout C;
  private LinearLayout D;
  private t.a E = new t.a()
  {
    public void onReceiveLocation(boolean paramAnonymousBoolean, BDLocation paramAnonymousBDLocation)
    {
      u.d("SelectCityPop", "====onReceiveLocation:" + paramAnonymousBoolean + "====");
      if ((YouPinSelectCityPop.this.isShowing()) && (YouPinSelectCityPop.p(YouPinSelectCityPop.this) != null) && (YouPinSelectCityPop.d(YouPinSelectCityPop.this) != null))
      {
        u.d("SelectCityPop", "====isShowing:" + YouPinSelectCityPop.this.isShowing());
        if ((!paramAnonymousBoolean) || (paramAnonymousBDLocation == null) || (TextUtils.isEmpty(paramAnonymousBDLocation.getCity()))) {
          break label214;
        }
        YouPinSelectCityPop.f(YouPinSelectCityPop.this).setVisibility(8);
        YouPinSelectCityPop.g(YouPinSelectCityPop.this).setVisibility(8);
        String str = paramAnonymousBDLocation.getCity();
        paramAnonymousBDLocation = "";
        if (str.endsWith("市")) {
          paramAnonymousBDLocation = str.substring(0, str.length() - 1);
        }
        YouPinSelectCityPop.d(YouPinSelectCityPop.this).setText(paramAnonymousBDLocation);
        YouPinSelectCityPop.d(YouPinSelectCityPop.this).setTextColor(Color.parseColor("#444444"));
        YouPinSelectCityPop.d(YouPinSelectCityPop.this).setTextSize(18.0F);
        paramAnonymousBDLocation = com.ziroom.ziroomcustomer.bestgoods.a.getCityByName(paramAnonymousBDLocation);
        if (paramAnonymousBDLocation != null) {}
      }
      else
      {
        return;
      }
      paramAnonymousBDLocation.getCode();
      return;
      label214:
      if (YouPinSelectCityPop.q(YouPinSelectCityPop.this)) {
        YouPinSelectCityPop.r(YouPinSelectCityPop.this);
      }
      YouPinSelectCityPop.f(YouPinSelectCityPop.this).setVisibility(8);
      YouPinSelectCityPop.g(YouPinSelectCityPop.this).setVisibility(0);
      YouPinSelectCityPop.d(YouPinSelectCityPop.this).setText("当前城市获取失败");
      YouPinSelectCityPop.d(YouPinSelectCityPop.this).setTextSize(14.0F);
      YouPinSelectCityPop.d(YouPinSelectCityPop.this).setTextColor(Color.parseColor("#FF6262"));
      YouPinSelectCityPop.e(YouPinSelectCityPop.this).setVisibility(0);
    }
  };
  Map<Integer, List<ah.a>> a = new HashMap();
  private Context b;
  private LinearLayout c;
  private ImageView d;
  private ProgressBar e;
  private ImageView f;
  private TextView g;
  private TextView h;
  private Button i;
  private ListView j;
  private ListView k;
  private ListView l;
  private View m;
  private LayoutInflater n;
  private boolean o;
  private a p;
  private a q;
  private a r;
  private ah s;
  private ah t;
  private ah u;
  private String v = "";
  private String w = "";
  private boolean x = false;
  private boolean y = false;
  private boolean z = false;
  
  public YouPinSelectCityPop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public YouPinSelectCityPop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public YouPinSelectCityPop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSoftInputMode(16);
    setWidth(-1);
    setHeight(-1);
    setAnimationStyle(2131427507);
    this.n = ((Activity)paramContext).getLayoutInflater();
    this.m = this.n.inflate(2130905242, null);
    this.b = paramContext;
    b();
    c();
    a();
  }
  
  private void a()
  {
    a(Integer.valueOf(1), "000000");
  }
  
  private void a(final Integer paramInteger, String paramString)
  {
    n.getQueryCityInfo(this.b, paramString, new com.ziroom.ziroomcustomer.e.a.a(this.b, new m(ah.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, ah paramAnonymousah)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousah);
        if (paramAnonymousah != null)
        {
          List localList;
          if (paramInteger.intValue() == 1)
          {
            YouPinSelectCityPop.a(YouPinSelectCityPop.this, paramAnonymousah);
            if (YouPinSelectCityPop.a(YouPinSelectCityPop.this) != null)
            {
              localList = YouPinSelectCityPop.a(YouPinSelectCityPop.this).getList();
              YouPinSelectCityPop.this.a.put(Integer.valueOf(1), localList);
            }
          }
          if (paramInteger.intValue() == 2)
          {
            YouPinSelectCityPop.b(YouPinSelectCityPop.this, paramAnonymousah);
            localList = YouPinSelectCityPop.b(YouPinSelectCityPop.this).getList();
            YouPinSelectCityPop.this.a.put(Integer.valueOf(2), localList);
          }
          if (paramInteger.intValue() == 3)
          {
            YouPinSelectCityPop.c(YouPinSelectCityPop.this, paramAnonymousah);
            paramAnonymousah = YouPinSelectCityPop.c(YouPinSelectCityPop.this).getList();
            YouPinSelectCityPop.this.a.put(Integer.valueOf(3), paramAnonymousah);
          }
          YouPinSelectCityPop.a(YouPinSelectCityPop.this, YouPinSelectCityPop.this.a);
        }
      }
    });
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("cityName", paramString1);
    localIntent.putExtra("cityCode", paramString2);
    localIntent.putExtra("isColsePop", paramBoolean);
    localIntent.setAction("youpin_city_select");
    ApplicationEx.c.sendBroadcast(localIntent);
    LocalBroadcastManager.getInstance(ApplicationEx.c).sendBroadcast(localIntent);
  }
  
  private void a(Map<Integer, List<ah.a>> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      List localList;
      if (((Integer)localObject).intValue() == 1)
      {
        localList = (List)paramMap.get(localObject);
        if (this.p == null)
        {
          this.p = new a(localList);
          this.j.setAdapter(this.p);
        }
      }
      else
      {
        label83:
        if (((Integer)localObject).intValue() == 2)
        {
          localList = (List)paramMap.get(localObject);
          if (this.q != null) {
            break label200;
          }
          this.q = new a(localList);
          this.k.setAdapter(this.q);
        }
      }
      for (;;)
      {
        if (((Integer)localObject).intValue() != 3) {
          break label210;
        }
        localObject = (List)paramMap.get(localObject);
        if (this.r != null) {
          break label212;
        }
        this.r = new a((List)localObject);
        this.l.setAdapter(this.r);
        break;
        this.p.setmList(localList);
        break label83;
        label200:
        this.q.setmList(localList);
      }
      label210:
      continue;
      label212:
      this.r.setmList((List)localObject);
    }
  }
  
  private boolean a(List<ah.a> paramList)
  {
    return (paramList != null) && (!paramList.isEmpty());
  }
  
  private void b()
  {
    this.c = ((LinearLayout)this.m.findViewById(2131694497));
    this.d = ((ImageView)this.m.findViewById(2131689492));
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        YouPinSelectCityPop.this.checkCityIsSelect();
      }
    });
    this.e = ((ProgressBar)this.m.findViewById(2131694498));
    this.f = ((ImageView)this.m.findViewById(2131694499));
    this.h = ((TextView)this.m.findViewById(2131697828));
    this.g = ((TextView)this.m.findViewById(2131692497));
    this.i = ((Button)this.m.findViewById(2131694500));
    this.i.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        YouPinSelectCityPop.a(YouPinSelectCityPop.this, true);
        YouPinSelectCityPop.d(YouPinSelectCityPop.this).setText("正在获取当前定位城市");
        YouPinSelectCityPop.d(YouPinSelectCityPop.this).setTextSize(14.0F);
        YouPinSelectCityPop.d(YouPinSelectCityPop.this).setTextColor(Color.parseColor("#666666"));
        YouPinSelectCityPop.e(YouPinSelectCityPop.this).setVisibility(8);
        YouPinSelectCityPop.f(YouPinSelectCityPop.this).setVisibility(0);
        YouPinSelectCityPop.g(YouPinSelectCityPop.this).setVisibility(8);
        t.addListener(YouPinSelectCityPop.h(YouPinSelectCityPop.this));
        t.startLocate();
      }
    });
    this.B = ((LinearLayout)this.m.findViewById(2131697829));
    this.j = ((ListView)this.m.findViewById(2131697830));
    this.C = ((LinearLayout)this.m.findViewById(2131697831));
    this.k = ((ListView)this.m.findViewById(2131697832));
    this.D = ((LinearLayout)this.m.findViewById(2131697833));
    this.l = ((ListView)this.m.findViewById(2131697834));
    setContentView(this.m);
  }
  
  private void c()
  {
    this.j.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        YouPinSelectCityPop.i(YouPinSelectCityPop.this).setVisibility(0);
        YouPinSelectCityPop.j(YouPinSelectCityPop.this).setVisibility(8);
        YouPinSelectCityPop.b(YouPinSelectCityPop.this, true);
        YouPinSelectCityPop.c(YouPinSelectCityPop.this, false);
        YouPinSelectCityPop.d(YouPinSelectCityPop.this, false);
        if (YouPinSelectCityPop.a(YouPinSelectCityPop.this, YouPinSelectCityPop.k(YouPinSelectCityPop.this).getmList()))
        {
          int i = 0;
          if (i < YouPinSelectCityPop.k(YouPinSelectCityPop.this).getmList().size())
          {
            if (i == paramAnonymousInt) {
              ((ah.a)YouPinSelectCityPop.k(YouPinSelectCityPop.this).getmList().get(i)).setSelected(true);
            }
            for (;;)
            {
              i += 1;
              break;
              ((ah.a)YouPinSelectCityPop.k(YouPinSelectCityPop.this).getmList().get(i)).setSelected(false);
            }
          }
          YouPinSelectCityPop.this.a.put(Integer.valueOf(1), YouPinSelectCityPop.k(YouPinSelectCityPop.this).getmList());
        }
        paramAnonymousAdapterView = ((ah.a)YouPinSelectCityPop.k(YouPinSelectCityPop.this).getmList().get(paramAnonymousInt)).getCode();
        YouPinSelectCityPop.a(YouPinSelectCityPop.this, Integer.valueOf(2), paramAnonymousAdapterView);
      }
    });
    this.k.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        YouPinSelectCityPop.j(YouPinSelectCityPop.this).setVisibility(0);
        YouPinSelectCityPop.c(YouPinSelectCityPop.this, true);
        YouPinSelectCityPop.d(YouPinSelectCityPop.this, false);
        if (YouPinSelectCityPop.a(YouPinSelectCityPop.this, YouPinSelectCityPop.l(YouPinSelectCityPop.this).getmList()))
        {
          int i = 0;
          if (i < YouPinSelectCityPop.l(YouPinSelectCityPop.this).getmList().size())
          {
            if (i == paramAnonymousInt) {
              ((ah.a)YouPinSelectCityPop.l(YouPinSelectCityPop.this).getmList().get(i)).setSelected(true);
            }
            for (;;)
            {
              i += 1;
              break;
              ((ah.a)YouPinSelectCityPop.l(YouPinSelectCityPop.this).getmList().get(i)).setSelected(false);
            }
          }
          YouPinSelectCityPop.this.a.put(Integer.valueOf(2), YouPinSelectCityPop.l(YouPinSelectCityPop.this).getmList());
        }
        YouPinSelectCityPop.a(YouPinSelectCityPop.this, ((ah.a)YouPinSelectCityPop.l(YouPinSelectCityPop.this).getmList().get(paramAnonymousInt)).getShowName());
        YouPinSelectCityPop.b(YouPinSelectCityPop.this, ((ah.a)YouPinSelectCityPop.l(YouPinSelectCityPop.this).getmList().get(paramAnonymousInt)).getCode());
        YouPinSelectCityPop.a(YouPinSelectCityPop.this, Integer.valueOf(3), YouPinSelectCityPop.m(YouPinSelectCityPop.this));
      }
    });
    this.l.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        YouPinSelectCityPop.d(YouPinSelectCityPop.this, true);
        if (YouPinSelectCityPop.a(YouPinSelectCityPop.this, YouPinSelectCityPop.n(YouPinSelectCityPop.this).getmList()))
        {
          int i = 0;
          if (i < YouPinSelectCityPop.n(YouPinSelectCityPop.this).getmList().size())
          {
            if (i == paramAnonymousInt) {
              ((ah.a)YouPinSelectCityPop.n(YouPinSelectCityPop.this).getmList().get(i)).setSelected(true);
            }
            for (;;)
            {
              i += 1;
              break;
              ((ah.a)YouPinSelectCityPop.n(YouPinSelectCityPop.this).getmList().get(i)).setSelected(false);
            }
          }
          YouPinSelectCityPop.this.a.put(Integer.valueOf(3), YouPinSelectCityPop.n(YouPinSelectCityPop.this).getmList());
        }
        YouPinSelectCityPop.a(YouPinSelectCityPop.this, YouPinSelectCityPop.o(YouPinSelectCityPop.this), YouPinSelectCityPop.m(YouPinSelectCityPop.this), true);
        YouPinSelectCityPop.this.dismiss();
      }
    });
  }
  
  private void d()
  {
    final AlertDialog localAlertDialog = new AlertDialog.Builder(this.b).create();
    View localView = LayoutInflater.from(this.b).inflate(2130904658, null);
    Object localObject1 = (TextView)localView.findViewById(2131690084);
    Object localObject2 = (TextView)localView.findViewById(2131693670);
    ((TextView)localObject1).setText("请检查网络或定位是否开启");
    ((TextView)localObject2).setText("知道了");
    ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        YouPinSelectCityPop.a(YouPinSelectCityPop.this, false);
        YouPinSelectCityPop.a(YouPinSelectCityPop.this, "", "", true);
        localAlertDialog.dismiss();
      }
    });
    if (!(localAlertDialog instanceof AlertDialog)) {
      localAlertDialog.show();
    }
    for (;;)
    {
      localObject1 = localAlertDialog.getWindow();
      localObject2 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject2).width = ((int)(this.b.getResources().getDisplayMetrics().density * 245.0F + 0.5F));
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      localAlertDialog.getWindow().setContentView(localView);
      return;
      VdsAgent.showDialog((AlertDialog)localAlertDialog);
    }
  }
  
  public void checkCityIsSelect()
  {
    if (this.z)
    {
      a(this.v, this.w, true);
      dismiss();
    }
    do
    {
      return;
      if ((!this.x) && (!this.y) && (!this.z))
      {
        String str1 = aa.getString(this.b, "currentYouPinCityName", "");
        String str2 = aa.getString(this.b, "currentYouPinCityCode", "");
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
          a(str1, str2, true);
        }
        for (;;)
        {
          dismiss();
          return;
          a("北京", "110000", true);
        }
      }
    } while ((this.x != true) && (this.y != true));
    g.textToast(this.b, "城市选择未完成，不可关闭");
  }
  
  public void show(View paramView)
  {
    this.A = aa.getBoolean(this.b, "isSwitchYouPinCity", false);
    this.g.setTextSize(14.0F);
    this.g.setTextColor(Color.parseColor("#666666"));
    this.i.setVisibility(8);
    this.f.setVisibility(8);
    String str;
    if (this.A) {
      if (this.z)
      {
        str = aa.getString(this.b, "currentYouPinCityName", "");
        aa.getString(this.b, "currentYouPinCityCode", "");
        this.h.setText("当前定位城市");
        this.g.setText(str);
      }
    }
    while (!(this instanceof PopupWindow))
    {
      super.showAtLocation(paramView, 0, 0, 0);
      return;
      this.h.setText("当前定位城市");
      this.g.setText("正在获取当前定位城市");
      this.e.setVisibility(0);
      t.addListener(this.E);
      t.startLocate();
      continue;
      if (this.z)
      {
        str = aa.getString(this.b, "currentYouPinCityName", "");
        aa.getString(this.b, "currentYouPinCityCode", "");
        this.h.setText("当前定位城市");
        this.g.setText(str);
      }
      else
      {
        this.e.setVisibility(8);
        this.h.setText("默认城市");
        this.g.setText("北京");
      }
    }
    VdsAgent.showAtLocation((PopupWindow)this, paramView, 0, 0, 0);
  }
  
  private class a
    extends BaseAdapter
  {
    private List<ah.a> b;
    
    public a()
    {
      List localList;
      this.b = localList;
    }
    
    public int getCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(YouPinSelectCityPop.s(YouPinSelectCityPop.this)).inflate(2130904592, paramViewGroup, false);
        paramView = new a();
        paramView.a = ((TextView)localView.findViewById(2131695287));
        localView.setTag(paramView);
      }
      paramView = (a)localView.getTag();
      paramView.a.setText(((ah.a)this.b.get(paramInt)).getShowName());
      if (((ah.a)this.b.get(paramInt)).isSelected())
      {
        paramView.a.setTextColor(Color.parseColor("#ffa000"));
        return localView;
      }
      paramView.a.setTextColor(Color.parseColor("#444444"));
      return localView;
    }
    
    public List<ah.a> getmList()
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      return this.b;
    }
    
    public void setmList(List<ah.a> paramList)
    {
      this.b = paramList;
      notifyDataSetChanged();
    }
    
    class a
    {
      TextView a;
      
      a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/dialog/YouPinSelectCityPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */