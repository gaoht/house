package com.ziroom.ziroomcustomer.newchat.chatcenter;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.model.Contract;
import java.util.ArrayList;
import java.util.List;

public class NetPhoneActivity
  extends BaseActivity
{
  private NetPhoneActivity a;
  private ListView b;
  private ImageView c;
  private n d;
  private List<f> e = new ArrayList();
  private Contract f;
  private TextView g;
  private List<Contract> r;
  private Dialog s;
  private a t;
  private int u;
  private Handler v = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      NetPhoneActivity.this.dismissProgress();
      if (locall.getSuccess().booleanValue())
      {
        NetPhoneActivity.a(NetPhoneActivity.this, (List)locall.getObject());
        NetPhoneActivity.a(NetPhoneActivity.this, new n(NetPhoneActivity.d(NetPhoneActivity.this), NetPhoneActivity.h(NetPhoneActivity.this), NetPhoneActivity.f(NetPhoneActivity.this).getAddress()));
        NetPhoneActivity.j(NetPhoneActivity.this).setAdapter(NetPhoneActivity.i(NetPhoneActivity.this));
        return;
      }
      NetPhoneActivity.this.showToast(locall.getMessage());
    }
  };
  
  private void a()
  {
    this.r = ApplicationEx.c.getContracts();
    if ((this.r != null) && (this.r.size() > 0))
    {
      this.f = ((Contract)this.r.get(0));
      o.getNetPhone(this.a, this.v, this.f.getHouse_code());
      showProgress("");
      if (this.r.size() > 1)
      {
        this.g.setVisibility(0);
        this.g.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            NetPhoneActivity.a(NetPhoneActivity.this);
          }
        });
      }
    }
    else
    {
      return;
    }
    this.g.setVisibility(8);
  }
  
  private void b()
  {
    this.b = ((ListView)findViewById(2131690167));
    this.c = ((ImageView)findViewById(2131689492));
    this.g = ((TextView)findViewById(2131690166));
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        NetPhoneActivity.this.finish();
      }
    });
  }
  
  private void e()
  {
    this.s = new Dialog(this, 2131427692);
    Object localObject1 = getLayoutInflater().inflate(2130903863, null);
    Object localObject2 = (ListView)((View)localObject1).findViewById(2131693805);
    Object localObject3 = (TextView)((View)localObject1).findViewById(2131691288);
    this.t = new a();
    ((ListView)localObject2).setAdapter(this.t);
    ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        NetPhoneActivity.b(NetPhoneActivity.this).dismiss();
      }
    });
    this.s.setCanceledOnTouchOutside(true);
    localObject2 = this.s.getWindow();
    ((Window)localObject2).getDecorView().setPadding(0, 0, 0, 0);
    localObject3 = ((Window)localObject2).getAttributes();
    ((WindowManager.LayoutParams)localObject3).width = -1;
    ((WindowManager.LayoutParams)localObject3).height = -2;
    ((Window)localObject2).setAttributes((WindowManager.LayoutParams)localObject3);
    ((Window)localObject2).setGravity(80);
    this.s.setContentView((View)localObject1);
    localObject1 = this.s;
    if (!(localObject1 instanceof Dialog))
    {
      ((Dialog)localObject1).show();
      return;
    }
    VdsAgent.showDialog((Dialog)localObject1);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903130);
    this.a = this;
    b();
    a();
  }
  
  public class a
    extends BaseAdapter
  {
    public a() {}
    
    public int getCount()
    {
      return NetPhoneActivity.c(NetPhoneActivity.this).size();
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
        paramView = View.inflate(NetPhoneActivity.d(NetPhoneActivity.this), 2130904570, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131693248));
        paramViewGroup.b = ((ImageView)paramView.findViewById(2131695668));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.a.setText(((Contract)NetPhoneActivity.c(NetPhoneActivity.this).get(paramInt)).getAddress());
        paramViewGroup.a.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            NetPhoneActivity.a(NetPhoneActivity.this, paramInt);
            NetPhoneActivity.a.this.notifyDataSetChanged();
            NetPhoneActivity.a(NetPhoneActivity.this, (Contract)NetPhoneActivity.c(NetPhoneActivity.this).get(paramInt));
            paramViewGroup.b.setVisibility(0);
            o.getNetPhone(NetPhoneActivity.d(NetPhoneActivity.this), NetPhoneActivity.e(NetPhoneActivity.this), NetPhoneActivity.f(NetPhoneActivity.this).getHouse_code());
            NetPhoneActivity.this.showProgress("");
            NetPhoneActivity.b(NetPhoneActivity.this).dismiss();
          }
        });
        if (NetPhoneActivity.g(NetPhoneActivity.this) != paramInt) {
          break;
        }
        paramViewGroup.a.setTextColor(-695296);
        paramViewGroup.b.setVisibility(0);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.a.setTextColor(-15658735);
      paramViewGroup.b.setVisibility(4);
      return paramView;
    }
    
    public class a
    {
      public TextView a;
      public ImageView b;
      
      public a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/NetPhoneActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */