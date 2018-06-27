package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.model.MHCommodityCategory;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHTool;
import com.ziroom.ziroomcustomer.util.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MHChangeToolActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private int A = 1;
  private a B;
  private List<MHCommodityCategory> C;
  private List<MHTool> D;
  private List<MHTool> E;
  private List<MHTool> F;
  private LinearLayout G;
  private Handler H = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Object localObject = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 8195: 
      case 8213: 
        label359:
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while (!((l)localObject).getSuccess().booleanValue());
              MHChangeToolActivity.a(MHChangeToolActivity.this, (List)((l)localObject).getObject());
            } while ((MHChangeToolActivity.r(MHChangeToolActivity.this) == null) || (MHChangeToolActivity.r(MHChangeToolActivity.this).size() <= 0));
            MHChangeToolActivity.a(MHChangeToolActivity.this, ((MHCommodityCategory)MHChangeToolActivity.r(MHChangeToolActivity.this).get(0)).getId());
            return;
          } while (!((l)localObject).getSuccess().booleanValue());
          MHChangeToolActivity.this.dismissProgress();
          MHChangeToolActivity.b(MHChangeToolActivity.this, (List)((l)localObject).getObject());
          if (MHChangeToolActivity.s(MHChangeToolActivity.this))
          {
            MHChangeToolActivity.b(MHChangeToolActivity.this).clear();
            MHChangeToolActivity.b(MHChangeToolActivity.this, false);
          }
          if ((MHChangeToolActivity.t(MHChangeToolActivity.this) == null) || (MHChangeToolActivity.t(MHChangeToolActivity.this).size() <= 0))
          {
            g.textToast(MHChangeToolActivity.this, "没有最新数据了");
            MHChangeToolActivity.u(MHChangeToolActivity.this);
            return;
          }
          if ((MHChangeToolActivity.b(MHChangeToolActivity.this) == null) || (MHChangeToolActivity.b(MHChangeToolActivity.this).size() <= 0)) {
            break;
          }
          paramAnonymousMessage = new ArrayList();
          localObject = MHChangeToolActivity.t(MHChangeToolActivity.this).iterator();
          for (;;)
          {
            if (!((Iterator)localObject).hasNext()) {
              break label359;
            }
            MHTool localMHTool = (MHTool)((Iterator)localObject).next();
            String str = localMHTool.getGoodsId();
            Iterator localIterator = MHChangeToolActivity.b(MHChangeToolActivity.this).iterator();
            if (localIterator.hasNext())
            {
              if (!((MHTool)localIterator.next()).getGoodsId().equals(str)) {
                break;
              }
              paramAnonymousMessage.add(localMHTool);
            }
          }
        } while (MHChangeToolActivity.t(MHChangeToolActivity.this).size() == paramAnonymousMessage.size());
        MHChangeToolActivity.t(MHChangeToolActivity.this).removeAll(paramAnonymousMessage);
        MHChangeToolActivity.b(MHChangeToolActivity.this).addAll(MHChangeToolActivity.t(MHChangeToolActivity.this));
        MHChangeToolActivity.u(MHChangeToolActivity.this);
        MHChangeToolActivity.a(MHChangeToolActivity.this, false);
        return;
      }
      if (((l)localObject).getSuccess().booleanValue())
      {
        paramAnonymousMessage = (Map)((l)localObject).getObject();
        if (paramAnonymousMessage != null)
        {
          paramAnonymousMessage = (String)paramAnonymousMessage.get("id");
          localObject = new Intent();
          ((Intent)localObject).putExtra("workId", paramAnonymousMessage);
          MHChangeToolActivity.this.setResult(514, (Intent)localObject);
          MHChangeToolActivity.this.finish();
        }
      }
      for (;;)
      {
        MHChangeToolActivity.this.dismissProgress();
        MHChangeToolActivity.n(MHChangeToolActivity.this);
        return;
        g.textToast(MHChangeToolActivity.this, ((l)localObject).getMessage());
      }
    }
  };
  private View a;
  private ListView b;
  private FrameLayout c;
  private TextView d;
  private TextView e;
  private View f;
  private boolean g = false;
  private boolean r = false;
  private boolean s = false;
  private String t = "0";
  private String u;
  private String v;
  private float w = 0.0F;
  private int x = 0;
  private View y;
  private SimpleDraweeView z;
  
  private void a()
  {
    this.a = findViewById(2131689492);
    this.a.setOnClickListener(this);
    this.b = ((ListView)findViewById(2131691787));
    this.c = ((FrameLayout)findViewById(2131691788));
    this.e = ((TextView)findViewById(2131691790));
    this.d = ((TextView)findViewById(2131691789));
    this.f = findViewById(2131691791);
    this.f.setOnClickListener(this);
    this.y = findViewById(2131691792);
    this.y.setOnClickListener(this);
    this.z = ((SimpleDraweeView)findViewById(2131691793));
    this.G = ((LinearLayout)findViewById(2131689838));
    this.D = new ArrayList();
    this.E = new ArrayList();
    this.F = new ArrayList();
    if (getIntent() != null)
    {
      this.u = ((String)getIntent().getSerializableExtra("mBillId"));
      if ((this.u != null) && (!this.u.equals("")))
      {
        this.s = true;
        g();
      }
    }
    this.v = getIntent().getStringExtra("serviceInfoId");
    this.C = new ArrayList();
    this.b.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        }
        int i;
        do
        {
          return;
          paramAnonymousInt = MHChangeToolActivity.a(MHChangeToolActivity.this).getLastVisiblePosition();
          i = MHChangeToolActivity.b(MHChangeToolActivity.this).size();
        } while ((MHChangeToolActivity.c(MHChangeToolActivity.this)) || (paramAnonymousInt != i - 1));
        MHChangeToolActivity.d(MHChangeToolActivity.this);
        MHChangeToolActivity.this.showProgress("加载数据中...");
        MHChangeToolActivity.a(MHChangeToolActivity.this, true);
        o.getMHToolList(MHChangeToolActivity.this, MHChangeToolActivity.e(MHChangeToolActivity.this), b.d, MHChangeToolActivity.f(MHChangeToolActivity.this), MHChangeToolActivity.g(MHChangeToolActivity.this));
      }
    });
  }
  
  private void b()
  {
    showProgress("加载数据中...");
    this.g = true;
    o.getMHToolList(this, this.H, b.d, this.v, this.A);
  }
  
  private void e()
  {
    if (this.B == null)
    {
      this.B = new a(this);
      View localView = new View(this);
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
      localLayoutParams.height = ((int)(getResources().getDisplayMetrics().density * 1.0F + 0.5F));
      localView.setLayoutParams(localLayoutParams);
      localView.setBackgroundColor(Color.rgb(230, 230, 230));
      this.b.addFooterView(localView);
      this.b.setAdapter(this.B);
    }
    for (;;)
    {
      this.b.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
      });
      this.b.setEmptyView(this.c);
      if (this.B.getCount() <= 0) {
        break;
      }
      this.G.setVisibility(0);
      return;
      this.B.notifyDataSetChanged();
    }
    this.G.setVisibility(8);
  }
  
  private void f()
  {
    this.f.setClickable(true);
    this.f.setEnabled(true);
    this.f.setBackgroundResource(2130837810);
  }
  
  private void g()
  {
    this.f.setClickable(false);
    this.f.setEnabled(false);
    this.f.setBackgroundResource(2130837884);
  }
  
  public void onBackPressed()
  {
    if (this.y.isShown())
    {
      this.y.setVisibility(4);
      return;
    }
    super.onBackPressed();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      if (this.y.isShown())
      {
        this.y.setVisibility(4);
        return;
      }
      finish();
      w.onEvent(this, "movegoods_return");
      return;
    case 2131691791: 
      paramView = getIntent();
      paramView.putExtra("totalPrice", this.w);
      paramView.putExtra("totalNum", this.x);
      paramView.putExtra("shoppingCart", (Serializable)this.F);
      paramView.putExtra("serviceInfoId", this.v);
      setResult(-1, paramView);
      finish();
      w.onEvent(this, "movegoods_submit");
      return;
    }
    this.y.setVisibility(4);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903353);
    a();
    b();
    paramBundle = (List)getIntent().getExtras().getSerializable("shoppingCart");
    if (paramBundle != null)
    {
      this.F = paramBundle;
      this.D = paramBundle;
      e();
      paramBundle = this.F.iterator();
      while (paramBundle.hasNext())
      {
        MHTool localMHTool = (MHTool)paramBundle.next();
        this.w += localMHTool.getNum() * localMHTool.getPrice();
        int i = this.x;
        this.x = (localMHTool.getNum() + i);
        this.e.setVisibility(0);
        this.e.setText(this.w + " 元");
        this.d.setVisibility(0);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    if (this.y.isShown())
    {
      this.y.setVisibility(4);
      return true;
    }
    finish();
    return true;
  }
  
  private class a
    extends BaseAdapter
  {
    private Context b;
    
    public a(Context paramContext)
    {
      this.b = paramContext;
    }
    
    public int getCount()
    {
      return MHChangeToolActivity.b(MHChangeToolActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return MHChangeToolActivity.b(MHChangeToolActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      final Object localObject = (MHTool)MHChangeToolActivity.b(MHChangeToolActivity.this).get(paramInt);
      if (paramView == null)
      {
        paramViewGroup = new MHChangeToolActivity.b();
        paramView = LayoutInflater.from(this.b).inflate(2130904369, null);
        paramViewGroup.g = paramView.findViewById(2131695365);
        paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694813));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131695359));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131695360));
        paramViewGroup.e = ((ImageButton)paramView.findViewById(2131695362));
        paramViewGroup.f = ((ImageButton)paramView.findViewById(2131695364));
        paramViewGroup.d = ((TextView)paramView.findViewById(2131695363));
        paramView.setTag(paramViewGroup);
        paramViewGroup.a.setScaleType(ImageView.ScaleType.FIT_XY);
        paramInt = ((MHTool)localObject).getNum();
        if (paramInt <= 0) {
          break label330;
        }
        paramViewGroup.e.setVisibility(0);
      }
      for (;;)
      {
        paramViewGroup.d.setText(paramInt + "");
        paramViewGroup.b.setText(((MHTool)localObject).getDesc());
        paramViewGroup.c.setText(((MHTool)localObject).getPrice() + "");
        paramViewGroup.f.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramViewGroup.e.setVisibility(0);
            paramViewGroup.e.setClickable(true);
            int i = localObject.getNum();
            float f = localObject.getPrice();
            MHChangeToolActivity.a(MHChangeToolActivity.this, MHChangeToolActivity.h(MHChangeToolActivity.this) + 1);
            MHChangeToolActivity.a(MHChangeToolActivity.this, f + MHChangeToolActivity.i(MHChangeToolActivity.this));
            paramViewGroup.d.setText(i + 1 + "");
            MHChangeToolActivity.j(MHChangeToolActivity.this).setVisibility(0);
            MHChangeToolActivity.k(MHChangeToolActivity.this).setVisibility(0);
            MHChangeToolActivity.k(MHChangeToolActivity.this).setText(MHChangeToolActivity.i(MHChangeToolActivity.this) + "元");
            localObject.setNum(i + 1);
            if (!MHChangeToolActivity.l(MHChangeToolActivity.this).contains(localObject)) {
              MHChangeToolActivity.l(MHChangeToolActivity.this).add(localObject);
            }
            if (MHChangeToolActivity.m(MHChangeToolActivity.this)) {
              MHChangeToolActivity.n(MHChangeToolActivity.this);
            }
            w.onEvent(MHChangeToolActivity.this, "movegoods_add");
          }
        });
        paramViewGroup.e.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            int i = localObject.getNum();
            float f = localObject.getPrice();
            MHChangeToolActivity.a(MHChangeToolActivity.this, MHChangeToolActivity.h(MHChangeToolActivity.this) - 1);
            MHChangeToolActivity.a(MHChangeToolActivity.this, MHChangeToolActivity.i(MHChangeToolActivity.this) - f);
            if (i <= 1)
            {
              paramViewGroup.e.setVisibility(4);
              paramViewGroup.e.setClickable(false);
              MHChangeToolActivity.l(MHChangeToolActivity.this).remove(localObject);
            }
            MHChangeToolActivity.k(MHChangeToolActivity.this).setText(MHChangeToolActivity.i(MHChangeToolActivity.this) + "元");
            paramViewGroup.d.setText(i - 1 + "");
            localObject.setNum(i - 1);
            if (i > 1)
            {
              MHChangeToolActivity.k(MHChangeToolActivity.this).setVisibility(0);
              MHChangeToolActivity.j(MHChangeToolActivity.this).setVisibility(0);
            }
            if (MHChangeToolActivity.h(MHChangeToolActivity.this) <= 0)
            {
              MHChangeToolActivity.k(MHChangeToolActivity.this).setVisibility(0);
              MHChangeToolActivity.j(MHChangeToolActivity.this).setVisibility(0);
              if (MHChangeToolActivity.m(MHChangeToolActivity.this)) {
                MHChangeToolActivity.o(MHChangeToolActivity.this);
              }
            }
            w.onEvent(MHChangeToolActivity.this, "movegoods_del");
          }
        });
        final String str = ((MHTool)localObject).getLargeimgurl();
        paramViewGroup.a.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            MHChangeToolActivity.p(MHChangeToolActivity.this).setVisibility(0);
            ((GenericDraweeHierarchy)MHChangeToolActivity.q(MHChangeToolActivity.this).getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            MHChangeToolActivity.q(MHChangeToolActivity.this).setController(c.frescoController(str));
          }
        });
        localObject = ((MHTool)localObject).getSmallimgurl();
        if (localObject != null) {
          paramViewGroup.a.setController(c.frescoController((String)localObject));
        }
        return paramView;
        paramViewGroup = (MHChangeToolActivity.b)paramView.getTag();
        break;
        label330:
        paramViewGroup.e.setVisibility(4);
        paramViewGroup.e.setClickable(false);
      }
    }
  }
  
  static class b
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    TextView d;
    ImageButton e;
    ImageButton f;
    View g;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MHChangeToolActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */