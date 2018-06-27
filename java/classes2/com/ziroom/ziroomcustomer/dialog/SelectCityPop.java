package com.ziroom.ziroomcustomer.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.location.BDLocation;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.e;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.util.t;
import com.ziroom.ziroomcustomer.util.t.a;
import com.ziroom.ziroomcustomer.util.u;
import java.util.Iterator;
import java.util.List;

public class SelectCityPop
  extends PopupWindow
{
  public BaseAdapter a = new BaseAdapter()
  {
    public int getCount()
    {
      if (SelectCityPop.k(SelectCityPop.this) == null) {
        return 0;
      }
      return SelectCityPop.k(SelectCityPop.this).size();
    }
    
    public Object getItem(int paramAnonymousInt)
    {
      return SelectCityPop.k(SelectCityPop.this).get(paramAnonymousInt);
    }
    
    public long getItemId(int paramAnonymousInt)
    {
      return paramAnonymousInt;
    }
    
    public View getView(final int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
    {
      View localView = paramAnonymousView;
      if (paramAnonymousView == null) {
        localView = SelectCityPop.n(SelectCityPop.this).inflate(2130904148, paramAnonymousViewGroup, false);
      }
      paramAnonymousView = (TextView)localView.findViewById(2131690049);
      paramAnonymousViewGroup = (ImageView)localView.findViewById(2131694577);
      com.ziroom.ziroomcustomer.base.a.b localb = (com.ziroom.ziroomcustomer.base.a.b)getItem(paramAnonymousInt);
      paramAnonymousView.setText(localb.getName());
      if (com.ziroom.ziroomcustomer.base.b.d.equals(localb.getCode())) {
        paramAnonymousViewGroup.setVisibility(0);
      }
      for (;;)
      {
        localView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
            if (paramAnonymousInt < SelectCityPop.k(SelectCityPop.this).size())
            {
              paramAnonymous2View = (com.ziroom.ziroomcustomer.base.a.b)SelectCityPop.k(SelectCityPop.this).get(paramAnonymousInt);
              Iterator localIterator = com.ziroom.ziroomcustomer.base.b.getCityList().iterator();
              while (localIterator.hasNext())
              {
                com.ziroom.ziroomcustomer.base.a.b localb = (com.ziroom.ziroomcustomer.base.a.b)localIterator.next();
                if ((localb.getCode() != null) && (localb.getCode().equals(paramAnonymous2View.getCode()))) {
                  com.ziroom.ziroomcustomer.base.b.changeCity(paramAnonymous2View.getCode());
                }
              }
            }
            for (int i = 1;; i = 0)
            {
              if (i == 0)
              {
                e.newBuilder(SelectCityPop.o(SelectCityPop.this)).setTitle("提示").setButtonText("我知道了").setContent("对不起，暂未开通该城市").setOnClickListener(new View.OnClickListener()
                {
                  @Instrumented
                  public void onClick(View paramAnonymous3View)
                  {
                    VdsAgent.onClick(this, paramAnonymous3View);
                    com.ziroom.ziroomcustomer.base.b.changeCity("110000");
                    SelectCityPop.this.dismiss();
                  }
                }).build().show();
                return;
              }
              SelectCityPop.this.dismiss();
              return;
            }
          }
        });
        return localView;
        paramAnonymousViewGroup.setVisibility(8);
      }
    }
  };
  private Context b;
  private LinearLayout c;
  private ImageView d;
  private ProgressBar e;
  private ImageView f;
  private TextView g;
  private Button h;
  private LinearLayout i;
  private ProgressBar j;
  private ImageView k;
  private TextView l;
  private Button m;
  private ListView n;
  private View o;
  private LayoutInflater p;
  private boolean q;
  private boolean r;
  private boolean s;
  private List<com.ziroom.ziroomcustomer.base.a.b> t = com.ziroom.ziroomcustomer.base.b.getCityList();
  private t.a u = new t.a()
  {
    public void onReceiveLocation(boolean paramAnonymousBoolean, BDLocation paramAnonymousBDLocation)
    {
      u.d("SelectCityPop", "====onReceiveLocation:" + paramAnonymousBoolean + "====");
      if ((SelectCityPop.this.isShowing()) && (SelectCityPop.j(SelectCityPop.this) != null) && (SelectCityPop.a(SelectCityPop.this) != null))
      {
        u.d("SelectCityPop", "====isShowing:" + SelectCityPop.this.isShowing());
        if ((!paramAnonymousBoolean) || (paramAnonymousBDLocation == null) || (TextUtils.isEmpty(paramAnonymousBDLocation.getCity()))) {
          break label323;
        }
        SelectCityPop.c(SelectCityPop.this).setVisibility(8);
        SelectCityPop.d(SelectCityPop.this).setVisibility(8);
        paramAnonymousBDLocation = paramAnonymousBDLocation.getCity();
        if (!paramAnonymousBDLocation.endsWith("市")) {
          break label419;
        }
        paramAnonymousBDLocation = paramAnonymousBDLocation.substring(0, paramAnonymousBDLocation.length() - 1);
      }
      label323:
      label419:
      for (;;)
      {
        Iterator localIterator = SelectCityPop.k(SelectCityPop.this).iterator();
        final com.ziroom.ziroomcustomer.base.a.b localb;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localb = (com.ziroom.ziroomcustomer.base.a.b)localIterator.next();
        } while (!localb.getName().equals(paramAnonymousBDLocation));
        for (;;)
        {
          if (localb != null)
          {
            SelectCityPop.a(SelectCityPop.this).setText(paramAnonymousBDLocation);
            SelectCityPop.a(SelectCityPop.this).setTextColor(Color.parseColor("#444444"));
            SelectCityPop.a(SelectCityPop.this).setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                com.ziroom.ziroomcustomer.base.b.changeCity(localb.getCode());
                SelectCityPop.this.dismiss();
              }
            });
          }
          for (;;)
          {
            SelectCityPop.a(SelectCityPop.this).setTextSize(18.0F);
            return;
            SelectCityPop.a(SelectCityPop.this).setOnClickListener(null);
            SelectCityPop.a(SelectCityPop.this).setText(paramAnonymousBDLocation + "（暂未开通服务）");
            SelectCityPop.a(SelectCityPop.this).setTextColor(Color.parseColor("#999999"));
          }
          if (SelectCityPop.l(SelectCityPop.this)) {
            SelectCityPop.m(SelectCityPop.this);
          }
          SelectCityPop.c(SelectCityPop.this).setVisibility(8);
          SelectCityPop.d(SelectCityPop.this).setVisibility(0);
          SelectCityPop.a(SelectCityPop.this).setText("当前城市获取失败");
          SelectCityPop.a(SelectCityPop.this).setTextSize(14.0F);
          SelectCityPop.a(SelectCityPop.this).setTextColor(Color.parseColor("#FF6262"));
          SelectCityPop.b(SelectCityPop.this).setVisibility(0);
          return;
          localb = null;
        }
      }
    }
  };
  private BroadcastReceiver v = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent.getAction().equals("init_citylist")) && ((!SelectCityPop.p(SelectCityPop.this)) || (SelectCityPop.q(SelectCityPop.this))))
      {
        if (paramAnonymousIntent.getIntExtra("result", 0) == 1)
        {
          SelectCityPop.a(SelectCityPop.this, com.ziroom.ziroomcustomer.base.b.getCityList());
          SelectCityPop.this.a.notifyDataSetChanged();
          SelectCityPop.r(SelectCityPop.this).setVisibility(0);
          SelectCityPop.s(SelectCityPop.this).setVisibility(8);
        }
      }
      else {
        return;
      }
      SelectCityPop.r(SelectCityPop.this).setVisibility(8);
      SelectCityPop.s(SelectCityPop.this).setVisibility(0);
      SelectCityPop.h(SelectCityPop.this).setVisibility(8);
      SelectCityPop.i(SelectCityPop.this).setVisibility(0);
      SelectCityPop.f(SelectCityPop.this).setText("获取城市列表失败，请稍后重试");
      SelectCityPop.f(SelectCityPop.this).setTextSize(14.0F);
      SelectCityPop.f(SelectCityPop.this).setTextColor(Color.parseColor("#FF6262"));
      SelectCityPop.g(SelectCityPop.this).setVisibility(0);
    }
  };
  
  public SelectCityPop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SelectCityPop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SelectCityPop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSoftInputMode(16);
    setWidth(-1);
    setHeight(-1);
    setAnimationStyle(2131427507);
    this.p = ((Activity)paramContext).getLayoutInflater();
    this.o = this.p.inflate(2130904028, null);
    this.b = paramContext;
    a();
  }
  
  private void a()
  {
    this.c = ((LinearLayout)this.o.findViewById(2131694497));
    this.d = ((ImageView)this.o.findViewById(2131689492));
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SelectCityPop.this.dismiss();
      }
    });
    this.e = ((ProgressBar)this.o.findViewById(2131694498));
    this.f = ((ImageView)this.o.findViewById(2131694499));
    this.g = ((TextView)this.o.findViewById(2131692497));
    this.h = ((Button)this.o.findViewById(2131694500));
    this.h.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SelectCityPop.a(SelectCityPop.this, true);
        SelectCityPop.a(SelectCityPop.this).setText("正在获取当前定位城市");
        SelectCityPop.a(SelectCityPop.this).setTextSize(14.0F);
        SelectCityPop.a(SelectCityPop.this).setTextColor(Color.parseColor("#666666"));
        SelectCityPop.b(SelectCityPop.this).setVisibility(8);
        SelectCityPop.c(SelectCityPop.this).setVisibility(0);
        SelectCityPop.d(SelectCityPop.this).setVisibility(8);
        t.addListener(SelectCityPop.e(SelectCityPop.this));
        t.startLocate();
      }
    });
    this.j = ((ProgressBar)this.o.findViewById(2131694502));
    this.k = ((ImageView)this.o.findViewById(2131694503));
    this.l = ((TextView)this.o.findViewById(2131694504));
    this.m = ((Button)this.o.findViewById(2131694505));
    this.m.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SelectCityPop.b(SelectCityPop.this, true);
        SelectCityPop.f(SelectCityPop.this).setText("正在获取城市列表");
        SelectCityPop.f(SelectCityPop.this).setTextSize(14.0F);
        SelectCityPop.f(SelectCityPop.this).setTextColor(Color.parseColor("#666666"));
        SelectCityPop.g(SelectCityPop.this).setVisibility(8);
        SelectCityPop.h(SelectCityPop.this).setVisibility(0);
        SelectCityPop.i(SelectCityPop.this).setVisibility(8);
        com.ziroom.ziroomcustomer.base.b.initCityListFromServer();
      }
    });
    this.i = ((LinearLayout)this.o.findViewById(2131694501));
    this.n = ((ListView)this.o.findViewById(2131694506));
    this.n.setAdapter(this.a);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("init_citylist");
    this.b.registerReceiver(this.v, localIntentFilter);
    setContentView(this.o);
  }
  
  private void b()
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
        SelectCityPop.a(SelectCityPop.this, false);
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
  
  public void show(View paramView)
  {
    this.g.setText("正在获取当前定位城市");
    this.g.setTextSize(14.0F);
    this.g.setTextColor(Color.parseColor("#666666"));
    this.h.setVisibility(8);
    this.e.setVisibility(0);
    this.f.setVisibility(8);
    t.addListener(this.u);
    t.startLocate();
    if ((com.ziroom.ziroomcustomer.base.b.b) || (com.ziroom.ziroomcustomer.base.b.a))
    {
      this.r = true;
      this.i.setVisibility(8);
      this.n.setVisibility(0);
      this.t = com.ziroom.ziroomcustomer.base.b.getCityList();
      this.a.notifyDataSetChanged();
    }
    while (!(this instanceof PopupWindow))
    {
      super.showAtLocation(paramView, 0, 0, 0);
      return;
      this.r = false;
      this.i.setVisibility(0);
      this.n.setVisibility(8);
      this.l.setText("正在获取城市列表");
      this.l.setTextSize(14.0F);
      this.l.setTextColor(Color.parseColor("#666666"));
      this.m.setVisibility(8);
      this.j.setVisibility(0);
      this.k.setVisibility(8);
      com.ziroom.ziroomcustomer.base.b.initCityListFromServer();
    }
    VdsAgent.showAtLocation((PopupWindow)this, paramView, 0, 0, 0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/dialog/SelectCityPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */