package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.d.f.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.ziroomapartment.adapter.i;
import com.ziroom.ziroomcustomer.ziroomapartment.b;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignKvItem;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignKvLItem;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignPaymentInfo;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignProject;
import java.util.List;

public class ZryuSignPaymentInfoActivity
  extends BaseActivity
{
  private String A;
  private com.ziroom.ziroomcustomer.e.a.c B = new com.ziroom.ziroomcustomer.e.a.c(this, new f(ZryuSignPaymentInfo.class))
  {
    public void onSuccess(int paramAnonymousInt, ZryuSignPaymentInfo paramAnonymousZryuSignPaymentInfo)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousZryuSignPaymentInfo);
      if (paramAnonymousZryuSignPaymentInfo != null)
      {
        Object localObject = paramAnonymousZryuSignPaymentInfo.getProjectInfo();
        if (localObject != null)
        {
          ZryuSignPaymentInfoActivity.a(ZryuSignPaymentInfoActivity.this).setText(((ZryuSignProject)localObject).getProName());
          ZryuSignPaymentInfoActivity.b(ZryuSignPaymentInfoActivity.this).setText(((ZryuSignProject)localObject).getProAddress());
          ZryuSignPaymentInfoActivity.c(ZryuSignPaymentInfoActivity.this).setText(((ZryuSignProject)localObject).getRoomSalesPrice() + "");
          ZryuSignPaymentInfoActivity.d(ZryuSignPaymentInfoActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(((ZryuSignProject)localObject).getProHeadFigureUrl()));
        }
        localObject = paramAnonymousZryuSignPaymentInfo.getBillInfo();
        if (localObject != null)
        {
          ZryuSignPaymentInfoActivity.e(ZryuSignPaymentInfoActivity.this).setText(((ZryuSignKvItem)localObject).getName());
          ZryuSignPaymentInfoActivity.f(ZryuSignPaymentInfoActivity.this).setText(((ZryuSignKvItem)localObject).getDescription());
          ZryuSignPaymentInfoActivity.g(ZryuSignPaymentInfoActivity.this).setText(((ZryuSignKvItem)localObject).getValue());
        }
        localObject = paramAnonymousZryuSignPaymentInfo.getPayInfo();
        if (localObject != null)
        {
          String str = ((ZryuSignKvLItem)localObject).getName();
          ZryuSignPaymentInfoActivity.h(ZryuSignPaymentInfoActivity.this).setText(str);
          localObject = ((ZryuSignKvLItem)localObject).getList();
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            ZryuSignPaymentInfoActivity.i(ZryuSignPaymentInfoActivity.this).setAdapter(new i(ZryuSignPaymentInfoActivity.this, (List)localObject));
          }
        }
        localObject = paramAnonymousZryuSignPaymentInfo.getTotalPayInfo();
        if (localObject != null)
        {
          ZryuSignPaymentInfoActivity.j(ZryuSignPaymentInfoActivity.this).setText(((ZryuSignKvItem)localObject).getName());
          ZryuSignPaymentInfoActivity.k(ZryuSignPaymentInfoActivity.this).setText(((ZryuSignKvItem)localObject).getValue());
        }
        paramAnonymousZryuSignPaymentInfo = paramAnonymousZryuSignPaymentInfo.getActivityInfo();
        if ((paramAnonymousZryuSignPaymentInfo == null) || (paramAnonymousZryuSignPaymentInfo.getName() == null) || (paramAnonymousZryuSignPaymentInfo.getList() == null)) {
          break label355;
        }
        ZryuSignPaymentInfoActivity.l(ZryuSignPaymentInfoActivity.this).setVisibility(0);
        ZryuSignPaymentInfoActivity.m(ZryuSignPaymentInfoActivity.this).setVisibility(0);
        ZryuSignPaymentInfoActivity.l(ZryuSignPaymentInfoActivity.this).setText(paramAnonymousZryuSignPaymentInfo.getName());
        paramAnonymousZryuSignPaymentInfo = paramAnonymousZryuSignPaymentInfo.getList();
        if ((paramAnonymousZryuSignPaymentInfo != null) && (paramAnonymousZryuSignPaymentInfo.size() > 0)) {
          ZryuSignPaymentInfoActivity.m(ZryuSignPaymentInfoActivity.this).setAdapter(new ZryuSignPaymentInfoActivity.a(ZryuSignPaymentInfoActivity.this, ZryuSignPaymentInfoActivity.this, paramAnonymousZryuSignPaymentInfo));
        }
      }
      return;
      label355:
      ZryuSignPaymentInfoActivity.l(ZryuSignPaymentInfoActivity.this).setVisibility(8);
      ZryuSignPaymentInfoActivity.m(ZryuSignPaymentInfoActivity.this).setVisibility(8);
    }
  };
  private ImageView a;
  private SimpleDraweeView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView r;
  private TextView s;
  private TextView t;
  private ListViewForScrollView u;
  private TextView v;
  private ListViewForScrollView w;
  private LinearLayout x;
  private TextView y;
  private TextView z;
  
  private void a()
  {
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((SimpleDraweeView)findViewById(2131691098));
    this.c = ((TextView)findViewById(2131696404));
    this.d = ((TextView)findViewById(2131696579));
    this.e = ((TextView)findViewById(2131696402));
    this.f = ((TextView)findViewById(2131693034));
    this.g = ((TextView)findViewById(2131693035));
    this.r = ((TextView)findViewById(2131690073));
    this.s = ((TextView)findViewById(2131692617));
    this.u = ((ListViewForScrollView)findViewById(2131690077));
    this.v = ((TextView)findViewById(2131693037));
    this.w = ((ListViewForScrollView)findViewById(2131693038));
    this.x = ((LinearLayout)findViewById(2131692949));
    this.y = ((TextView)findViewById(2131693039));
    this.z = ((TextView)findViewById(2131690309));
    this.t = ((TextView)findViewById(2131693036));
  }
  
  private void b()
  {
    this.A = getIntent().getStringExtra("contractId");
    if (!TextUtils.isEmpty(this.A)) {
      j.contractPaymentDetail(this, this.A, this.B);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903616);
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
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131690043: 
      paramView = new Intent(this, ZryuSignContractTermsActivity.class);
      paramView.putExtra("contractId", this.A);
      startActivity(paramView);
      return;
    }
    b.toBillsList(this, this.A, 1, 0);
  }
  
  public class a
    extends BaseAdapter
  {
    private Context b;
    private List<ZryuSignKvItem> c;
    private LayoutInflater d;
    
    public a(List<ZryuSignKvItem> paramList)
    {
      this.b = paramList;
      List localList;
      this.c = localList;
      this.d = LayoutInflater.from(paramList);
    }
    
    public int getCount()
    {
      if (this.c == null) {
        return 0;
      }
      return this.c.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.c.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = this.d.inflate(2130904629, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131689857));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131691546));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        ZryuSignKvItem localZryuSignKvItem = (ZryuSignKvItem)getItem(paramInt);
        paramViewGroup.a.setText(paramInt + 1 + "." + localZryuSignKvItem.getName());
        paramViewGroup.b.setText(localZryuSignKvItem.getValue());
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    private class a
    {
      public TextView a;
      public TextView b;
      
      private a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignPaymentInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */