package com.ziroom.ziroomcustomer.newrepair.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.RepairWork;
import com.ziroom.ziroomcustomer.model.RepairWorkItem;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.activity.ZiroomOrderListActivity;
import com.ziroom.ziroomcustomer.newrepair.dialog.b;
import com.ziroom.ziroomcustomer.newrepair.dialog.c;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RepairNewActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private RepairWork A;
  private String B;
  private List<RepairWork> C = new ArrayList();
  private ImageView D;
  private a E;
  private int F;
  private Dialog G;
  private Context H;
  private BroadcastReceiver I = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("repair_delete"))
      {
        int i = paramAnonymousIntent.getExtras().getInt("index");
        RepairNewActivity.a(RepairNewActivity.this).remove(i);
        RepairNewActivity.e(RepairNewActivity.this).remove(i);
        RepairNewActivity.f(RepairNewActivity.this).notifyDataSetChanged();
        if (RepairNewActivity.a(RepairNewActivity.this).size() == 0) {
          RepairNewActivity.g(RepairNewActivity.this).setBackgroundColor(-4473925);
        }
      }
    }
  };
  private Handler J = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      RepairNewActivity.this.dismissProgress();
      if (locall.getSuccess().booleanValue())
      {
        g.textToast(RepairNewActivity.b(RepairNewActivity.this), "您已成功预约维修!");
        RepairNewActivity.a(RepairNewActivity.this, new Intent(RepairNewActivity.this, RepairSubmitSuccessActivity.class));
        RepairNewActivity.d(RepairNewActivity.this).putExtra("RepairList", "repairItemList");
        paramAnonymousMessage = new Bundle();
        paramAnonymousMessage.putInt("query_index_contract", RepairNewActivity.k(RepairNewActivity.this));
        RepairNewActivity.d(RepairNewActivity.this).putExtras(paramAnonymousMessage);
        RepairNewActivity.this.startActivity(RepairNewActivity.d(RepairNewActivity.this));
        RepairNewActivity.this.finish();
        return;
      }
      g.textToast(RepairNewActivity.b(RepairNewActivity.this), locall.getMessage());
    }
  };
  private TextView a;
  private RelativeLayout b;
  private RelativeLayout c;
  private ListView d;
  private Intent e;
  private List<Contract> f = new ArrayList();
  private TextView g;
  private Button r;
  private ImageView s;
  private EditText t;
  private UserInfo u;
  private Contract v;
  private List<com.ziroom.ziroomcustomer.newrepair.b.o> w = new ArrayList();
  private b x;
  private View y;
  private RepairWorkItem z = new RepairWorkItem();
  
  private void a()
  {
    if ((ApplicationEx.c.getContracts() != null) && (ApplicationEx.c.getContracts().size() != 0))
    {
      this.f = ApplicationEx.c.getContracts();
      this.v = ((Contract)this.f.get(0));
      if (this.f.size() != 1) {
        break label251;
      }
      this.D.setVisibility(8);
    }
    for (;;)
    {
      this.u = ((ApplicationEx)getApplication()).getUser();
      if ((this.f != null) && (this.f.size() != 0)) {
        this.g.setText(((Contract)this.f.get(0)).getAddress());
      }
      if (this.u != null) {
        this.t.setText(this.u.getLogin_name_mobile());
      }
      this.y = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130905090, null, false);
      this.y.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (RepairNewActivity.a(RepairNewActivity.this).size() >= 5)
          {
            g.textToast(RepairNewActivity.b(RepairNewActivity.this), "维修项添加请勿超过五项");
            return;
          }
          RepairNewActivity.a(RepairNewActivity.this, new Intent(RepairNewActivity.this, RepairNewItemActivity.class));
          RepairNewActivity.d(RepairNewActivity.this).putExtra("ContractCode", RepairNewActivity.c(RepairNewActivity.this).getContract_code());
          RepairNewActivity.this.startActivityForResult(RepairNewActivity.d(RepairNewActivity.this), 1);
        }
      });
      this.d.addFooterView(this.y, null, true);
      this.x = new b();
      this.d.setAdapter(this.x);
      this.d.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          RepairNewActivity.a(RepairNewActivity.this, paramAnonymousInt);
          return true;
        }
      });
      this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          RepairNewActivity.a(RepairNewActivity.this, new Intent(RepairNewActivity.this, RepairNewItemActivity.class));
          paramAnonymousAdapterView = new Bundle();
          paramAnonymousAdapterView.putInt("index", paramAnonymousInt);
          RepairNewActivity.d(RepairNewActivity.this).putExtras(paramAnonymousAdapterView);
          RepairNewActivity.d(RepairNewActivity.this).putExtra("isRepairItem", "repairItem");
          RepairNewActivity.d(RepairNewActivity.this).putExtra("repairWork", (Serializable)RepairNewActivity.e(RepairNewActivity.this).get(paramAnonymousInt));
          RepairNewActivity.d(RepairNewActivity.this).putExtra("ContractCode", RepairNewActivity.c(RepairNewActivity.this).getContract_code());
          RepairNewActivity.this.startActivityForResult(RepairNewActivity.d(RepairNewActivity.this), 2);
          RepairNewActivity.f(RepairNewActivity.this).notifyDataSetChanged();
        }
      });
      return;
      label251:
      this.D.setVisibility(0);
    }
  }
  
  private void b()
  {
    this.a = ((TextView)findViewById(2131690048));
    this.b = ((RelativeLayout)findViewById(2131697389));
    this.g = ((TextView)findViewById(2131689924));
    this.c = ((RelativeLayout)findViewById(2131697391));
    this.d = ((ListView)findViewById(2131690998));
    this.r = ((Button)findViewById(2131690996));
    this.s = ((ImageView)findViewById(2131689492));
    this.t = ((EditText)findViewById(2131697393));
    this.D = ((ImageView)findViewById(2131693108));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("repair_delete");
    registerReceiver(this.I, localIntentFilter);
    this.A = new RepairWork();
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    b localb = new b(this, paramInt);
    localb.setCanceledOnTouchOutside(true);
    localb.show();
  }
  
  private void e()
  {
    if (this.w.size() == 0) {}
    String str;
    do
    {
      return;
      str = VdsAgent.trackEditTextSilent(this.t).toString();
      if ((ae.isNull(str)) || (!ah.isMobile(str)))
      {
        g.textToast(this.H, "请填写正确的电话号码");
        return;
      }
    } while ((this.u == null) || (this.v == null));
    com.ziroom.ziroomcustomer.e.o.submitRepair(this, this.J, this.u.getLogin_name_mobile(), m.GetNowDate(), this.u.getUser_name(), str, this.v.getContract_code(), "", 1, 12, this.C);
    showProgress("");
  }
  
  private void f()
  {
    this.G = new Dialog(this, 2131427692);
    Object localObject1 = getLayoutInflater().inflate(2130903838, null);
    Object localObject2 = (ListView)((View)localObject1).findViewById(2131693805);
    Object localObject3 = (TextView)((View)localObject1).findViewById(2131691288);
    this.E = new a();
    ((ListView)localObject2).setAdapter(this.E);
    ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        RepairNewActivity.h(RepairNewActivity.this).dismiss();
      }
    });
    this.G.setCanceledOnTouchOutside(true);
    localObject2 = this.G.getWindow();
    ((Window)localObject2).getDecorView().setPadding(0, 0, 0, 0);
    localObject3 = ((Window)localObject2).getAttributes();
    ((WindowManager.LayoutParams)localObject3).width = -1;
    ((WindowManager.LayoutParams)localObject3).height = -2;
    ((Window)localObject2).setAttributes((WindowManager.LayoutParams)localObject3);
    ((Window)localObject2).setGravity(80);
    this.G.setContentView((View)localObject1);
    localObject1 = this.G;
    if (!(localObject1 instanceof Dialog))
    {
      ((Dialog)localObject1).show();
      return;
    }
    VdsAgent.showDialog((Dialog)localObject1);
  }
  
  private void g()
  {
    com.ziroom.ziroomcustomer.newrepair.b.o localo = new com.ziroom.ziroomcustomer.newrepair.b.o();
    localo.setRepair_place(this.z.getKongJian());
    localo.setRepair_reason(this.z.getWxgz());
    localo.setRepair_time(this.B);
    this.w.add(localo);
    this.r.setBackgroundColor(-1739008);
  }
  
  private void h()
  {
    final Dialog localDialog = new Dialog(this, 2131427591);
    View localView = getLayoutInflater().inflate(2130903648, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131691289);
    TextView localTextView2 = (TextView)localView.findViewById(2131691288);
    ((TextView)localView.findViewById(2131693113)).setText("您确定不报修就退出么？");
    localTextView1.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localDialog.dismiss();
        RepairNewActivity.this.finish();
      }
    });
    localTextView2.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localDialog.dismiss();
      }
    });
    localDialog.setContentView(localView);
    if (!(localDialog instanceof Dialog))
    {
      localDialog.show();
      return;
    }
    VdsAgent.showDialog((Dialog)localDialog);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      this.z = ((RepairWorkItem)paramIntent.getSerializableExtra("repairWorkItem"));
      this.B = paramIntent.getStringExtra("order_time");
      this.A = ((RepairWork)paramIntent.getSerializableExtra("repairWork"));
      this.C.add(this.A);
      g();
      this.x.notifyDataSetChanged();
    }
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      this.z = ((RepairWorkItem)paramIntent.getSerializableExtra("repairWorkItem"));
      this.B = paramIntent.getStringExtra("order_time");
      this.A = ((RepairWork)paramIntent.getSerializableExtra("repairWork"));
      paramInt1 = paramIntent.getExtras().getInt("index_item");
      this.C.remove(paramInt1);
      this.C.add(paramInt1, this.A);
      paramIntent = new com.ziroom.ziroomcustomer.newrepair.b.o();
      paramIntent.setRepair_place(this.z.getKongJian());
      paramIntent.setRepair_reason(this.z.getWxgz());
      paramIntent.setRepair_time(this.B);
      this.w.remove(paramInt1);
      this.w.add(paramInt1, paramIntent);
      this.x.notifyDataSetChanged();
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131690048: 
    case 2131697389: 
      do
      {
        return;
        this.e = new Intent(this, ZiroomOrderListActivity.class);
        paramView = new Bundle();
        paramView.putInt("query_index_contract", this.F);
        this.e.putExtras(paramView);
        this.e.putExtra("ServiceList", "repair");
        startActivity(this.e);
        return;
      } while (this.f.size() <= 1);
      f();
      return;
    case 2131690996: 
      e();
      return;
    }
    h();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905092);
    this.H = this;
    b();
    a();
  }
  
  public void onDestroy()
  {
    if (this.I != null) {
      unregisterReceiver(this.I);
    }
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      h();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void showItemIsEmpty()
  {
    c localc = new c(this);
    localc.setCanceledOnTouchOutside(true);
    localc.show();
  }
  
  public class a
    extends BaseAdapter
  {
    public a() {}
    
    public int getCount()
    {
      return RepairNewActivity.i(RepairNewActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = View.inflate(RepairNewActivity.this, 2130904470, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131693248));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.a.setText(((Contract)RepairNewActivity.i(RepairNewActivity.this).get(paramInt)).getAddress());
        paramViewGroup.a.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            RepairNewActivity.b(RepairNewActivity.this, paramInt);
            RepairNewActivity.a.this.notifyDataSetChanged();
            RepairNewActivity.j(RepairNewActivity.this).setText(((Contract)RepairNewActivity.i(RepairNewActivity.this).get(paramInt)).getAddress());
            RepairNewActivity.a(RepairNewActivity.this, (Contract)RepairNewActivity.i(RepairNewActivity.this).get(paramInt));
            if ((RepairNewActivity.a(RepairNewActivity.this) != null) && (RepairNewActivity.a(RepairNewActivity.this).size() != 0) && (paramInt != 0))
            {
              RepairNewActivity.a(RepairNewActivity.this).clear();
              RepairNewActivity.e(RepairNewActivity.this).clear();
              if (RepairNewActivity.a(RepairNewActivity.this).size() == 0) {
                RepairNewActivity.g(RepairNewActivity.this).setBackgroundColor(-4473925);
              }
              RepairNewActivity.f(RepairNewActivity.this).notifyDataSetChanged();
            }
            RepairNewActivity.h(RepairNewActivity.this).dismiss();
          }
        });
        if (RepairNewActivity.k(RepairNewActivity.this) != paramInt) {
          break;
        }
        paramViewGroup.a.setTextColor(-695296);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.a.setTextColor(-15658735);
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
      return RepairNewActivity.a(RepairNewActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return Integer.valueOf(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = View.inflate(RepairNewActivity.this, 2130903641, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131693105));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131693107));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131689852));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.a.setText(((com.ziroom.ziroomcustomer.newrepair.b.o)RepairNewActivity.a(RepairNewActivity.this).get(paramInt)).getRepair_place());
        paramViewGroup.b.setText(((com.ziroom.ziroomcustomer.newrepair.b.o)RepairNewActivity.a(RepairNewActivity.this).get(paramInt)).getRepair_reason());
        paramViewGroup.c.setText(((com.ziroom.ziroomcustomer.newrepair.b.o)RepairNewActivity.a(RepairNewActivity.this).get(paramInt)).getRepair_time());
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    public class a
    {
      public TextView a;
      public TextView b;
      public TextView c;
      
      public a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/RepairNewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */