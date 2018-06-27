package com.ziroom.ziroomcustomer.newrepair.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.newrepair.b.p;
import com.ziroom.ziroomcustomer.newrepair.b.t;
import java.util.List;

public class RepairReasonActivity
  extends BaseActivity
{
  private ImageView a;
  private ListView b;
  private ListView c;
  private a d;
  private b e;
  private List<t> f;
  private List<p> g;
  private String r;
  private String s;
  private String t;
  private int u = 0;
  private int v = -1;
  private Context w;
  private Handler x = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 4199: 
        RepairReasonActivity.this.dismissProgress();
        if (locall.getSuccess().booleanValue())
        {
          RepairReasonActivity.a(RepairReasonActivity.this, (List)locall.getObject());
          RepairReasonActivity.a(RepairReasonActivity.this, ((p)RepairReasonActivity.a(RepairReasonActivity.this).get(0)).getCode());
          RepairReasonActivity.b(RepairReasonActivity.this, ((p)RepairReasonActivity.a(RepairReasonActivity.this).get(0)).getCue());
          RepairReasonActivity.c(RepairReasonActivity.this, ((p)RepairReasonActivity.a(RepairReasonActivity.this).get(0)).getName());
          if (!"".equals(RepairReasonActivity.b(RepairReasonActivity.this))) {
            RepairReasonActivity.this.showToast(RepairReasonActivity.b(RepairReasonActivity.this));
          }
          RepairReasonActivity.a(RepairReasonActivity.this, new RepairReasonActivity.a(RepairReasonActivity.this));
          RepairReasonActivity.d(RepairReasonActivity.this).setAdapter(RepairReasonActivity.c(RepairReasonActivity.this));
          o.getRepairReason(RepairReasonActivity.this, RepairReasonActivity.e(RepairReasonActivity.this), ((p)RepairReasonActivity.a(RepairReasonActivity.this).get(RepairReasonActivity.f(RepairReasonActivity.this))).getCode());
          return;
        }
        g.textToast(RepairReasonActivity.g(RepairReasonActivity.this), locall.getMessage());
        return;
      }
      RepairReasonActivity.this.dismissProgress();
      if (locall.getSuccess().booleanValue())
      {
        RepairReasonActivity.b(RepairReasonActivity.this, (List)locall.getObject());
        RepairReasonActivity.a(RepairReasonActivity.this, new RepairReasonActivity.b(RepairReasonActivity.this));
        RepairReasonActivity.i(RepairReasonActivity.this).setAdapter(RepairReasonActivity.h(RepairReasonActivity.this));
        return;
      }
      g.textToast(RepairReasonActivity.g(RepairReasonActivity.this), locall.getMessage());
    }
  };
  
  private void a()
  {
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((ListView)findViewById(2131695562));
    this.c = ((ListView)findViewById(2131695563));
    this.a.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        RepairReasonActivity.this.finish();
      }
    });
    Object localObject;
    if (getIntent().getExtras() != null)
    {
      localObject = getIntent().getExtras();
      this.u = ((Bundle)localObject).getInt("query_object_index");
      this.v = ((Bundle)localObject).getInt("query_reason_index");
    }
    if ((getIntent().getStringExtra("place_code") != null) && (getIntent().getStringExtra("type_code") != null))
    {
      localObject = getIntent().getStringExtra("place_code");
      String str = getIntent().getStringExtra("type_code");
      o.getRepairArticle(this, this.x, (String)localObject, str);
      showProgress("");
    }
  }
  
  public ListView getLv_item()
  {
    return this.c;
  }
  
  public ListView getLv_subject()
  {
    return this.b;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904450);
    this.w = this;
    a();
  }
  
  class a
    extends BaseAdapter
  {
    a() {}
    
    public int getCount()
    {
      return RepairReasonActivity.a(RepairReasonActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return Integer.valueOf(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = View.inflate(RepairReasonActivity.this, 2130905082, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131697371));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        p localp = (p)RepairReasonActivity.a(RepairReasonActivity.this).get(paramInt);
        paramViewGroup.a.setText(localp.getName());
        paramViewGroup.a.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            RepairReasonActivity.b(RepairReasonActivity.this, paramInt);
            RepairReasonActivity.a(RepairReasonActivity.this, -1);
            RepairReasonActivity.a.this.notifyDataSetChanged();
            RepairReasonActivity.a(RepairReasonActivity.this, ((p)RepairReasonActivity.a(RepairReasonActivity.this).get(paramInt)).getCode());
            RepairReasonActivity.b(RepairReasonActivity.this, ((p)RepairReasonActivity.a(RepairReasonActivity.this).get(paramInt)).getCue());
            RepairReasonActivity.c(RepairReasonActivity.this, ((p)RepairReasonActivity.a(RepairReasonActivity.this).get(paramInt)).getName());
            o.getRepairReason(RepairReasonActivity.this, RepairReasonActivity.e(RepairReasonActivity.this), RepairReasonActivity.l(RepairReasonActivity.this));
          }
        });
        if (RepairReasonActivity.f(RepairReasonActivity.this) != paramInt) {
          break;
        }
        paramViewGroup.a.setTextColor(-695296);
        paramViewGroup.a.setBackgroundColor(-328966);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.a.setTextColor(-9079435);
      paramViewGroup.a.setBackgroundColor(-1);
      return paramView;
    }
    
    public class a
    {
      public TextView a;
      
      public a() {}
    }
  }
  
  public class b
    extends BaseAdapter
  {
    public b() {}
    
    public int getCount()
    {
      return RepairReasonActivity.j(RepairReasonActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return Integer.valueOf(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = View.inflate(RepairReasonActivity.this, 2130905081, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131693107));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        t localt = (t)RepairReasonActivity.j(RepairReasonActivity.this).get(paramInt);
        paramViewGroup.a.setText(localt.getName());
        paramViewGroup.a.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent();
            RepairReasonActivity.a(RepairReasonActivity.this, paramInt);
            paramAnonymousView.putExtra("repair_reason", ((t)RepairReasonActivity.j(RepairReasonActivity.this).get(paramInt)).getName());
            paramAnonymousView.putExtra("repair_reason_code", ((t)RepairReasonActivity.j(RepairReasonActivity.this).get(paramInt)).getCode());
            paramAnonymousView.putExtra("repair_object_name", RepairReasonActivity.k(RepairReasonActivity.this));
            paramAnonymousView.putExtra("repair_object_code", RepairReasonActivity.l(RepairReasonActivity.this));
            paramAnonymousView.putExtra("repair_object_cue", RepairReasonActivity.b(RepairReasonActivity.this));
            Bundle localBundle = new Bundle();
            localBundle.putInt("query_object_index", RepairReasonActivity.f(RepairReasonActivity.this));
            localBundle.putInt("query_reason_index", RepairReasonActivity.m(RepairReasonActivity.this));
            paramAnonymousView.putExtras(localBundle);
            RepairReasonActivity.this.setResult(-1, paramAnonymousView);
            RepairReasonActivity.this.finish();
          }
        });
        if (RepairReasonActivity.m(RepairReasonActivity.this) != paramInt) {
          break;
        }
        paramViewGroup.a.setTextColor(-695296);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.a.setTextColor(-6447715);
      return paramView;
    }
    
    public class a
    {
      public TextView a;
      
      public a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/RepairReasonActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */