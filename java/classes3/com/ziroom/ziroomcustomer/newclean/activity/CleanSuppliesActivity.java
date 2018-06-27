package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.newclean.d.ac;
import com.ziroom.ziroomcustomer.newclean.d.x;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CleanSuppliesActivity
  extends BaseActivity
  implements XListView.a
{
  private String a;
  private List<ac> b = new ArrayList();
  private XListView c;
  private Context d;
  private a e;
  private int f = 1;
  private TextView g;
  private Button r;
  private List<x> s = new ArrayList();
  private ac t;
  private double u = 0.0D;
  private ImageView v;
  private Handler w = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      if (locall.getSuccess().booleanValue())
      {
        if (locall.getObject() != null)
        {
          paramAnonymousMessage = (List)locall.getObject();
          CleanSuppliesActivity.a(CleanSuppliesActivity.this).addAll(paramAnonymousMessage);
          CleanSuppliesActivity.g(CleanSuppliesActivity.this).notifyDataSetChanged();
          CleanSuppliesActivity.h(CleanSuppliesActivity.this).setPullLoadEnable(true);
          CleanSuppliesActivity.i(CleanSuppliesActivity.this);
        }
        if ((locall.getObject() == null) && (CleanSuppliesActivity.a(CleanSuppliesActivity.this).size() > 0))
        {
          CleanSuppliesActivity.i(CleanSuppliesActivity.this);
          CleanSuppliesActivity.h(CleanSuppliesActivity.this).setPullLoadEnable(false);
        }
      }
      for (;;)
      {
        CleanSuppliesActivity.this.dismissProgress();
        return;
        g.textToast(CleanSuppliesActivity.d(CleanSuppliesActivity.this), locall.getMessage());
      }
    }
  };
  
  private void a()
  {
    List localList = (List)getIntent().getSerializableExtra("list");
    if (localList != null)
    {
      this.u = getIntent().getExtras().getDouble("TotalPrice");
      this.g.setText(this.u + "元");
      this.e.notifyDataSetChanged();
      this.b.addAll(localList);
      return;
    }
    this.a = getIntent().getStringExtra("serviceInfoId");
    o.getNewCleanGoods(this.d, this.w, this.a, 1, 8);
  }
  
  private void b()
  {
    this.c = ((XListView)findViewById(2131690085));
    this.g = ((TextView)findViewById(2131689841));
    this.r = ((Button)findViewById(2131689843));
    this.v = ((ImageView)findViewById(2131689492));
    this.e = new a();
    this.c.setAdapter(this.e);
    this.r.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = CleanSuppliesActivity.a(CleanSuppliesActivity.this).iterator();
        int i = 0;
        Object localObject;
        if (paramAnonymousView.hasNext())
        {
          localObject = (ac)paramAnonymousView.next();
          if (((ac)localObject).getNum() <= 0) {
            break label214;
          }
          x localx = new x();
          localx.setGoodsId(((ac)localObject).getGoodsId());
          localx.setGoodsName(((ac)localObject).getName());
          localx.setNum(((ac)localObject).getNum());
          CleanSuppliesActivity.b(CleanSuppliesActivity.this).add(localx);
          i = ((ac)localObject).getNum() + i;
        }
        label214:
        for (;;)
        {
          break;
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("supplylist", (Serializable)CleanSuppliesActivity.a(CleanSuppliesActivity.this));
          paramAnonymousView.putExtra("unnum", i + "");
          localObject = new Bundle();
          ((Bundle)localObject).putDouble("TotalPrice", CleanSuppliesActivity.c(CleanSuppliesActivity.this));
          paramAnonymousView.putExtras((Bundle)localObject);
          CleanSuppliesActivity.this.setResult(-1, paramAnonymousView);
          CleanSuppliesActivity.this.finish();
          w.onEvent(CleanSuppliesActivity.d(CleanSuppliesActivity.this), "dailygoods_submit");
          return;
        }
      }
    });
    this.v.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CleanSuppliesActivity.this.finish();
        w.onEvent(CleanSuppliesActivity.d(CleanSuppliesActivity.this), "dailygoods_return");
      }
    });
    this.c.setPullLoadEnable(false);
    this.c.setPullRefreshEnable(true);
    this.c.setXListViewListener(this);
  }
  
  private void e()
  {
    this.c.stopRefresh();
    this.c.stopLoadMore();
    this.c.setRefreshTime("刚刚");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903120);
    this.d = this;
    b();
    a();
  }
  
  public void onLoadMore()
  {
    Context localContext = this.d;
    Handler localHandler = this.w;
    String str = this.a;
    int i = this.f + 1;
    this.f = i;
    o.getNewCleanGoods(localContext, localHandler, str, i, 8);
  }
  
  public void onRefresh()
  {
    this.c.setPullLoadEnable(false);
    this.f = 1;
    this.b.clear();
    this.e.notifyDataSetChanged();
    o.getNewCleanGoods(this.d, this.w, this.a, 1, 8);
  }
  
  public class a
    extends BaseAdapter
  {
    public a() {}
    
    public int getCount()
    {
      return CleanSuppliesActivity.a(CleanSuppliesActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(final int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = View.inflate(CleanSuppliesActivity.d(CleanSuppliesActivity.this), 2130904401, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131695455));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131695456));
        paramViewGroup.c = ((SimpleDraweeView)paramView.findViewById(2131695454));
        paramViewGroup.d = ((ImageView)paramView.findViewById(2131691436));
        paramViewGroup.e = ((ImageView)paramView.findViewById(2131691434));
        paramViewGroup.f = ((TextView)paramView.findViewById(2131695189));
        paramView.setTag(paramViewGroup);
        CleanSuppliesActivity.a(CleanSuppliesActivity.this, (ac)CleanSuppliesActivity.a(CleanSuppliesActivity.this).get(paramInt));
        paramViewGroup.a.setText(CleanSuppliesActivity.e(CleanSuppliesActivity.this).getName());
        paramViewGroup.b.setText((int)CleanSuppliesActivity.e(CleanSuppliesActivity.this).getPrice() + "元");
        paramViewGroup.c.setController(c.frescoController(CleanSuppliesActivity.e(CleanSuppliesActivity.this).getSmallimgurl()));
        if (CleanSuppliesActivity.e(CleanSuppliesActivity.this).getNum() <= 0) {
          break label318;
        }
        paramViewGroup.e.setVisibility(0);
        paramViewGroup.f.setVisibility(0);
      }
      for (;;)
      {
        paramViewGroup.f.setText(CleanSuppliesActivity.e(CleanSuppliesActivity.this).getNum() + "");
        paramViewGroup.d.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            CleanSuppliesActivity.a(CleanSuppliesActivity.this, (ac)CleanSuppliesActivity.a(CleanSuppliesActivity.this).get(paramInt));
            paramViewGroup.e.setVisibility(0);
            paramViewGroup.f.setVisibility(0);
            int i = CleanSuppliesActivity.e(CleanSuppliesActivity.this).getNum();
            paramViewGroup.f.setText(i + 1 + "");
            CleanSuppliesActivity.e(CleanSuppliesActivity.this).setNum(i + 1);
            CleanSuppliesActivity.a(CleanSuppliesActivity.this, CleanSuppliesActivity.c(CleanSuppliesActivity.this) + CleanSuppliesActivity.e(CleanSuppliesActivity.this).getPrice());
            CleanSuppliesActivity.f(CleanSuppliesActivity.this).setText((int)CleanSuppliesActivity.c(CleanSuppliesActivity.this) + "元");
            w.onEvent(CleanSuppliesActivity.d(CleanSuppliesActivity.this), "dailygoods_add");
          }
        });
        paramViewGroup.e.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            CleanSuppliesActivity.a(CleanSuppliesActivity.this, (ac)CleanSuppliesActivity.a(CleanSuppliesActivity.this).get(paramInt));
            int i = CleanSuppliesActivity.e(CleanSuppliesActivity.this).getNum();
            if (i >= 1)
            {
              paramViewGroup.e.setVisibility(0);
              paramViewGroup.f.setVisibility(0);
              paramViewGroup.f.setText(i - 1 + "");
              CleanSuppliesActivity.e(CleanSuppliesActivity.this).setNum(i - 1);
              CleanSuppliesActivity.a(CleanSuppliesActivity.this, CleanSuppliesActivity.c(CleanSuppliesActivity.this) - CleanSuppliesActivity.e(CleanSuppliesActivity.this).getPrice());
              CleanSuppliesActivity.f(CleanSuppliesActivity.this).setText((int)CleanSuppliesActivity.c(CleanSuppliesActivity.this) + "元");
            }
            for (;;)
            {
              w.onEvent(CleanSuppliesActivity.d(CleanSuppliesActivity.this), "dailygoods_del");
              return;
              paramViewGroup.e.setVisibility(4);
              paramViewGroup.f.setVisibility(4);
            }
          }
        });
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label318:
        paramViewGroup.e.setVisibility(4);
        paramViewGroup.f.setVisibility(4);
      }
    }
    
    public class a
    {
      public TextView a;
      public TextView b;
      public SimpleDraweeView c;
      public ImageView d;
      public ImageView e;
      public TextView f;
      
      public a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/CleanSuppliesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */