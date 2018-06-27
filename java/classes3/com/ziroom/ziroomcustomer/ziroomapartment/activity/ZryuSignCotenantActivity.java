package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.freelxl.baselibrary.d.f.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignCertType;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignCotenant;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignCotenantCertItem;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignCotenantList;
import java.util.ArrayList;
import java.util.List;

public class ZryuSignCotenantActivity
  extends BaseActivity
{
  private com.ziroom.ziroomcustomer.e.a.c A = new com.ziroom.ziroomcustomer.e.a.c(this, new f(String.class))
  {
    public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousString);
      ZryuSignCotenantActivity.l(ZryuSignCotenantActivity.this);
      g.textToast(ZryuSignCotenantActivity.this, "删除合租人成功！");
    }
  };
  private final int a = 1;
  private final int b = 2;
  private ImageView c;
  private TextView d;
  private ListViewForScrollView e;
  private Button f;
  private ScrollView g;
  private LinearLayout r;
  private TextView s;
  private LayoutInflater t;
  private a u;
  private String v;
  private List<ZryuSignCotenant> w;
  private List<ZryuSignCertType> x;
  private boolean y = false;
  private com.ziroom.ziroomcustomer.e.a.c z = new com.ziroom.ziroomcustomer.e.a.c(this, new f(ZryuSignCotenantList.class))
  {
    public void onSuccess(int paramAnonymousInt, ZryuSignCotenantList paramAnonymousZryuSignCotenantList)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousZryuSignCotenantList);
      if (paramAnonymousZryuSignCotenantList != null)
      {
        if ((paramAnonymousZryuSignCotenantList.getSharerList() == null) || (paramAnonymousZryuSignCotenantList.getSharerList().size() <= 0)) {
          break label117;
        }
        ZryuSignCotenantActivity.a(ZryuSignCotenantActivity.this, paramAnonymousZryuSignCotenantList.getSharerList());
        ZryuSignCotenantActivity.g(ZryuSignCotenantActivity.this).setVisibility(0);
        ZryuSignCotenantActivity.h(ZryuSignCotenantActivity.this).setVisibility(0);
        ZryuSignCotenantActivity.i(ZryuSignCotenantActivity.this).setVisibility(8);
      }
      for (;;)
      {
        ZryuSignCotenantActivity.k(ZryuSignCotenantActivity.this).notifyDataSetChanged();
        if ((paramAnonymousZryuSignCotenantList.getCertTypeList() != null) && (paramAnonymousZryuSignCotenantList.getCertTypeList().size() > 0)) {
          ZryuSignCotenantActivity.b(ZryuSignCotenantActivity.this, paramAnonymousZryuSignCotenantList.getCertTypeList());
        }
        return;
        label117:
        if (ZryuSignCotenantActivity.a(ZryuSignCotenantActivity.this) != null) {
          ZryuSignCotenantActivity.a(ZryuSignCotenantActivity.this).clear();
        }
        ZryuSignCotenantActivity.g(ZryuSignCotenantActivity.this).setVisibility(8);
        ZryuSignCotenantActivity.h(ZryuSignCotenantActivity.this).setVisibility(8);
        ZryuSignCotenantActivity.i(ZryuSignCotenantActivity.this).setVisibility(0);
        if (ZryuSignCotenantActivity.c(ZryuSignCotenantActivity.this)) {
          ZryuSignCotenantActivity.j(ZryuSignCotenantActivity.this).setVisibility(8);
        } else {
          ZryuSignCotenantActivity.j(ZryuSignCotenantActivity.this).setVisibility(0);
        }
      }
    }
  };
  
  private void a()
  {
    this.c = ((ImageView)findViewById(2131689492));
    this.d = ((TextView)findViewById(2131690041));
    this.e = ((ListViewForScrollView)findViewById(2131690077));
    this.f = ((Button)findViewById(2131690043));
    this.g = ((ScrollView)findViewById(2131690150));
    this.r = ((LinearLayout)findViewById(2131689818));
    this.s = ((TextView)findViewById(2131693028));
    this.y = getIntent().getBooleanExtra("isShow", false);
    if (this.y)
    {
      this.d.setVisibility(8);
      this.f.setVisibility(8);
    }
    this.t = LayoutInflater.from(this);
    this.u = new a(null);
    this.e.setAdapter(this.u);
  }
  
  private void b()
  {
    this.v = getIntent().getStringExtra("contractId");
    e();
  }
  
  private void e()
  {
    if (!TextUtils.isEmpty(this.v)) {
      j.zryuItemDeliverySharerList(this, this.v, this.z);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && ((paramInt1 == 1) || (paramInt1 == 2))) {
      e();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903611);
    a();
    b();
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    if (paramIntent != null) {
      b();
    }
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131689492: 
    case 2131690041: 
    case 2131693028: 
      do
      {
        return;
        finish();
        return;
      } while ((this.x == null) || (this.x.size() <= 0) || (TextUtils.isEmpty(this.v)));
      paramView = new Intent(this, ZryuSignAddCotenantActivity.class);
      paramView.putParcelableArrayListExtra("certTypes", (ArrayList)this.x);
      paramView.putExtra("contractId", this.v);
      paramView.putExtra("isFromList", true);
      startActivityForResult(paramView, 1);
      return;
    }
    finish();
  }
  
  private class a
    extends BaseAdapter
  {
    private a() {}
    
    public int getCount()
    {
      if (ZryuSignCotenantActivity.a(ZryuSignCotenantActivity.this) == null) {
        return 0;
      }
      return ZryuSignCotenantActivity.a(ZryuSignCotenantActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return ZryuSignCotenantActivity.a(ZryuSignCotenantActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      final ZryuSignCotenant localZryuSignCotenant;
      if (paramView == null)
      {
        paramView = ZryuSignCotenantActivity.b(ZryuSignCotenantActivity.this).inflate(2130904636, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131695903));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131690666));
        paramView.setTag(paramViewGroup);
        localZryuSignCotenant = (ZryuSignCotenant)getItem(paramInt);
        paramViewGroup.a.setText(localZryuSignCotenant.getName());
        if (localZryuSignCotenant.getCertInfo() == null) {
          break label192;
        }
        paramViewGroup.b.setText(localZryuSignCotenant.getCertInfo().getName() + " " + localZryuSignCotenant.getCertInfo().getValue());
      }
      for (;;)
      {
        paramViewGroup.c.setText(localZryuSignCotenant.getPhone());
        if (!ZryuSignCotenantActivity.c(ZryuSignCotenantActivity.this)) {
          break label204;
        }
        paramView.setOnClickListener(null);
        paramView.setOnLongClickListener(null);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label192:
        paramViewGroup.b.setText("");
      }
      label204:
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public boolean onLongClick(View paramAnonymousView)
        {
          com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(ZryuSignCotenantActivity.this).setTitle("删除合租人").setContent("您确认删除合租人吗？").setBtnConfirmText("确定").setBtnCancelText("取消").setOnConfirmClickListener(new c.b()
          {
            public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
            {
              if (paramAnonymous2Boolean) {
                j.zryuItemDeliveryDeleteSharer(ZryuSignCotenantActivity.this, ZryuSignCotenantActivity.d(ZryuSignCotenantActivity.this), ZryuSignCotenantActivity.a.1.this.a.getFid(), ZryuSignCotenantActivity.e(ZryuSignCotenantActivity.this));
              }
            }
          }).build().show();
          return false;
        }
      });
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ((ZryuSignCotenantActivity.f(ZryuSignCotenantActivity.this) != null) && (ZryuSignCotenantActivity.f(ZryuSignCotenantActivity.this).size() > 0) && (!TextUtils.isEmpty(ZryuSignCotenantActivity.d(ZryuSignCotenantActivity.this))))
          {
            paramAnonymousView = new Intent(ZryuSignCotenantActivity.this, ZryuSignAddCotenantActivity.class);
            paramAnonymousView.putExtra("cotenant", localZryuSignCotenant);
            paramAnonymousView.putExtra("contractId", ZryuSignCotenantActivity.d(ZryuSignCotenantActivity.this));
            paramAnonymousView.putExtra("isFromList", true);
            paramAnonymousView.putParcelableArrayListExtra("certTypes", (ArrayList)ZryuSignCotenantActivity.f(ZryuSignCotenantActivity.this));
            ZryuSignCotenantActivity.this.startActivityForResult(paramAnonymousView, 2);
          }
        }
      });
      return paramView;
    }
    
    private class a
    {
      TextView a;
      TextView b;
      TextView c;
      
      private a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignCotenantActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */