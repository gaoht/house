package com.ziroom.ziroomcustomer.my.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.my.model.RegionBean;
import com.ziroom.ziroomcustomer.my.model.RegionBean.CityBean;
import com.ziroom.ziroomcustomer.my.model.RegionBean.DistrictBean;
import com.ziroom.ziroomcustomer.widget.TimePickerView;
import com.ziroom.ziroomcustomer.widget.TimePickerView.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InvoiceCitySelectDialog
  extends DialogFragment
  implements View.OnClickListener
{
  ArrayList<RegionBean> a;
  private Context b;
  private View c;
  private TextView d;
  private TextView e;
  private TimePickerView f;
  private TimePickerView g;
  private TimePickerView h;
  private String i;
  private String j;
  private String k;
  private int l;
  private int m;
  private int n;
  private a o;
  
  private void a()
  {
    this.f.setData(b());
    this.g.setData(c());
    this.h.setData(d());
    this.f.setOnSelectListener(new TimePickerView.b()
    {
      public void onSelect(String paramAnonymousString, int paramAnonymousInt)
      {
        InvoiceCitySelectDialog.a(InvoiceCitySelectDialog.this, paramAnonymousInt);
        InvoiceCitySelectDialog.a(InvoiceCitySelectDialog.this, paramAnonymousString);
        InvoiceCitySelectDialog.b(InvoiceCitySelectDialog.this).setData(InvoiceCitySelectDialog.a(InvoiceCitySelectDialog.this));
        InvoiceCitySelectDialog.d(InvoiceCitySelectDialog.this).setData(InvoiceCitySelectDialog.c(InvoiceCitySelectDialog.this));
      }
    });
    this.g.setOnSelectListener(new TimePickerView.b()
    {
      public void onSelect(String paramAnonymousString, int paramAnonymousInt)
      {
        InvoiceCitySelectDialog.b(InvoiceCitySelectDialog.this, paramAnonymousString);
        InvoiceCitySelectDialog.b(InvoiceCitySelectDialog.this, paramAnonymousInt);
        InvoiceCitySelectDialog.d(InvoiceCitySelectDialog.this).setData(InvoiceCitySelectDialog.c(InvoiceCitySelectDialog.this));
      }
    });
    this.h.setOnSelectListener(new TimePickerView.b()
    {
      public void onSelect(String paramAnonymousString, int paramAnonymousInt)
      {
        InvoiceCitySelectDialog.c(InvoiceCitySelectDialog.this, paramAnonymousString);
        InvoiceCitySelectDialog.c(InvoiceCitySelectDialog.this, paramAnonymousInt);
      }
    });
  }
  
  private void a(List<String> paramList)
  {
    if (paramList == null) {}
    while (paramList.size() >= 5) {
      return;
    }
    paramList.add("");
    paramList.add("");
    paramList.add("");
    paramList.add("");
  }
  
  private ArrayList<String> b()
  {
    if ((this.a == null) || (this.a.size() < 1)) {
      return new ArrayList();
    }
    this.l = 0;
    this.i = ((RegionBean)this.a.get(this.l)).getProvince();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((RegionBean)localIterator.next()).getProvince());
    }
    a(localArrayList);
    return localArrayList;
  }
  
  private ArrayList<String> c()
  {
    if ((this.a == null) || (this.a.size() < 1) || (this.a.get(this.l) == null)) {
      return new ArrayList();
    }
    Object localObject = ((RegionBean)this.a.get(this.l)).getCityList();
    if ((localObject == null) || (((List)localObject).size() < 1)) {
      return new ArrayList();
    }
    this.m = 0;
    this.j = ((RegionBean.CityBean)((RegionBean)this.a.get(this.l)).getCityList().get(this.m)).getCityName();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((RegionBean.CityBean)((Iterator)localObject).next()).getCityName());
    }
    a(localArrayList);
    return localArrayList;
  }
  
  private ArrayList<String> d()
  {
    if ((this.a == null) || (this.a.size() < 1) || (this.a.get(this.l) == null) || (((RegionBean)this.a.get(this.l)).getCityList() == null) || (((RegionBean)this.a.get(this.l)).getCityList().size() < 1) || (((RegionBean)this.a.get(this.l)).getCityList().get(this.m) == null) || (((RegionBean.CityBean)((RegionBean)this.a.get(this.l)).getCityList().get(this.m)).getDistrictList() == null) || (((RegionBean.CityBean)((RegionBean)this.a.get(this.l)).getCityList().get(this.m)).getDistrictList().size() < 1)) {
      return new ArrayList();
    }
    Object localObject = ((RegionBean.CityBean)((RegionBean)this.a.get(this.l)).getCityList().get(this.m)).getDistrictList();
    this.n = 0;
    this.k = ((RegionBean.DistrictBean)((List)localObject).get(this.n)).getDistrictName();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((RegionBean.DistrictBean)((Iterator)localObject).next()).getDistrictName());
    }
    a(localArrayList);
    return localArrayList;
  }
  
  private void e()
  {
    this.d = ((TextView)this.c.findViewById(2131690169));
    this.e = ((TextView)this.c.findViewById(2131693809));
    this.f = ((TimePickerView)this.c.findViewById(2131696251));
    this.g = ((TimePickerView)this.c.findViewById(2131696252));
    this.h = ((TimePickerView)this.c.findViewById(2131696253));
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void f()
  {
    getDialog().requestWindowFeature(1);
    getDialog().getWindow().setGravity(17);
    getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
    getDialog().getWindow().getDecorView().setPadding(0, 0, 0, 0);
    getDialog().getWindow().setLayout(-1, -1);
    getDialog().setCanceledOnTouchOutside(true);
    getDialog().setCancelable(true);
  }
  
  public static InvoiceCitySelectDialog getInstance(ArrayList<RegionBean> paramArrayList)
  {
    InvoiceCitySelectDialog localInvoiceCitySelectDialog = new InvoiceCitySelectDialog();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("region", paramArrayList);
    localInvoiceCitySelectDialog.setArguments(localBundle);
    return localInvoiceCitySelectDialog;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690169: 
      dismiss();
      return;
    }
    paramView = this.i + this.j + this.k;
    if (this.o != null) {
      this.o.onCitySelect(paramView);
    }
    dismiss();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = getActivity();
    this.c = paramLayoutInflater.inflate(2130904733, paramViewGroup);
    this.a = ((ArrayList)getArguments().getSerializable("region"));
    f();
    e();
    a();
    return this.c;
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString, a parama)
  {
    if (!(this instanceof DialogFragment)) {
      super.show(paramFragmentManager, paramString);
    }
    for (;;)
    {
      this.o = parama;
      return;
      VdsAgent.showDialogFragment((DialogFragment)this, paramFragmentManager, paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onCitySelect(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/widget/InvoiceCitySelectDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */