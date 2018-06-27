package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.d.f.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignChoosePayMethod;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignPayMethod;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignProject;
import java.util.List;

public class ZryuSignPaymentMethodActivity
  extends BaseActivity
{
  private ImageView a;
  private ListViewForScrollView b;
  private Button c;
  private SimpleDraweeView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private String r;
  private a s;
  private LayoutInflater t;
  private com.ziroom.ziroomcustomer.e.a.c u = new com.ziroom.ziroomcustomer.e.a.c(this, new f(ZryuSignChoosePayMethod.class))
  {
    public void onSuccess(int paramAnonymousInt, ZryuSignChoosePayMethod paramAnonymousZryuSignChoosePayMethod)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousZryuSignChoosePayMethod);
      if (paramAnonymousZryuSignChoosePayMethod != null)
      {
        ZryuSignProject localZryuSignProject = paramAnonymousZryuSignChoosePayMethod.getProjectInfo();
        if (localZryuSignProject != null)
        {
          ZryuSignPaymentMethodActivity.a(ZryuSignPaymentMethodActivity.this).setText(localZryuSignProject.getProName());
          ZryuSignPaymentMethodActivity.b(ZryuSignPaymentMethodActivity.this).setText(localZryuSignProject.getProAddress());
          ZryuSignPaymentMethodActivity.c(ZryuSignPaymentMethodActivity.this).setText(localZryuSignProject.getRoomSalesPrice() + "");
          ZryuSignPaymentMethodActivity.d(ZryuSignPaymentMethodActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(localZryuSignProject.getProHeadFigureUrl()));
        }
        paramAnonymousZryuSignChoosePayMethod = paramAnonymousZryuSignChoosePayMethod.getPayList();
        if ((paramAnonymousZryuSignChoosePayMethod != null) && (paramAnonymousZryuSignChoosePayMethod.size() > 0))
        {
          ZryuSignPaymentMethodActivity.a(ZryuSignPaymentMethodActivity.this, new ZryuSignPaymentMethodActivity.a(ZryuSignPaymentMethodActivity.this, paramAnonymousZryuSignChoosePayMethod));
          ZryuSignPaymentMethodActivity.f(ZryuSignPaymentMethodActivity.this).setAdapter(ZryuSignPaymentMethodActivity.e(ZryuSignPaymentMethodActivity.this));
        }
      }
    }
  };
  private com.ziroom.ziroomcustomer.e.a.c v = new com.ziroom.ziroomcustomer.e.a.c(this, new f(String.class))
  {
    public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousString);
      paramAnonymousString = new Intent(ZryuSignPaymentMethodActivity.this, ZryuSignPaymentInfoActivity.class);
      paramAnonymousString.putExtra("contractId", ZryuSignPaymentMethodActivity.g(ZryuSignPaymentMethodActivity.this));
      ZryuSignPaymentMethodActivity.this.startActivity(paramAnonymousString);
    }
  };
  
  private void a()
  {
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((ListViewForScrollView)findViewById(2131690077));
    this.c = ((Button)findViewById(2131690043));
    this.d = ((SimpleDraweeView)findViewById(2131691098));
    this.e = ((TextView)findViewById(2131696404));
    this.f = ((TextView)findViewById(2131696579));
    this.g = ((TextView)findViewById(2131696402));
    this.t = LayoutInflater.from(this);
  }
  
  private void b()
  {
    this.r = getIntent().getStringExtra("contractId");
    if (!TextUtils.isEmpty(this.r)) {
      j.zryuContractChoosePayStyle(this, this.r, this.u);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903617);
    a();
    b();
    ApplicationEx.c.addToZryuSign(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ApplicationEx.c.removeFromZryuSign(this);
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        finish();
        return;
      } while (this.s == null);
      paramView = this.s.getSelectedCode();
      if (paramView == null) {
        break;
      }
    } while (TextUtils.isEmpty(this.r));
    j.zryuContractSavePayStyle(this, this.r, paramView.intValue(), this.v);
    return;
    g.textToast(this, "请选择一种付款方式！");
  }
  
  private class a
    extends BaseAdapter
  {
    private List<ZryuSignPayMethod> b;
    private CheckBox c;
    private ZryuSignPayMethod d;
    
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
    
    public Integer getSelectedCode()
    {
      if (this.d != null) {
        return this.d.getCode();
      }
      return null;
    }
    
    public View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
    {
      paramView = (ZryuSignPayMethod)getItem(paramInt);
      paramViewGroup = ZryuSignPaymentMethodActivity.h(ZryuSignPaymentMethodActivity.this).inflate(2130904641, paramViewGroup, false);
      final CheckBox localCheckBox = (CheckBox)paramViewGroup.findViewById(2131690977);
      Object localObject = (LinearLayout)paramViewGroup.findViewById(2131689775);
      localObject = (TextView)paramViewGroup.findViewById(2131690049);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131690073);
      if ((paramView.getSelect() != null) && (paramView.getSelect().booleanValue()))
      {
        localCheckBox.setChecked(true);
        this.d = paramView;
        if (this.c != null) {
          this.c.setChecked(false);
        }
        this.c = localCheckBox;
      }
      for (;;)
      {
        localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          @Instrumented
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
            if (paramAnonymousBoolean)
            {
              if ((ZryuSignPaymentMethodActivity.a.a(ZryuSignPaymentMethodActivity.a.this) != null) && (ZryuSignPaymentMethodActivity.a.a(ZryuSignPaymentMethodActivity.a.this) != paramAnonymousCompoundButton)) {
                ZryuSignPaymentMethodActivity.a.a(ZryuSignPaymentMethodActivity.a.this).setChecked(false);
              }
              ZryuSignPaymentMethodActivity.a.a(ZryuSignPaymentMethodActivity.a.this, paramView);
              ZryuSignPaymentMethodActivity.a.a(ZryuSignPaymentMethodActivity.a.this, (CheckBox)paramAnonymousCompoundButton);
            }
            while ((ZryuSignPaymentMethodActivity.a.a(ZryuSignPaymentMethodActivity.a.this) == null) || (ZryuSignPaymentMethodActivity.a.a(ZryuSignPaymentMethodActivity.a.this) != paramAnonymousCompoundButton)) {
              return;
            }
            ZryuSignPaymentMethodActivity.a.a(ZryuSignPaymentMethodActivity.a.this, null);
            ZryuSignPaymentMethodActivity.a.a(ZryuSignPaymentMethodActivity.a.this, null);
          }
        });
        paramViewGroup.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = localCheckBox;
            if (!localCheckBox.isChecked()) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousView.setChecked(bool);
              return;
            }
          }
        });
        ((TextView)localObject).setText(paramView.getName());
        if (!TextUtils.isEmpty(paramView.getDesc())) {
          break;
        }
        localTextView.setVisibility(8);
        return paramViewGroup;
        localCheckBox.setChecked(false);
      }
      localTextView.setVisibility(0);
      localTextView.setText(paramView.getDesc());
      return paramViewGroup;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignPaymentMethodActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */