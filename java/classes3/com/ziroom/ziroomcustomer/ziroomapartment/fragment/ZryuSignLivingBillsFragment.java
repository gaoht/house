package com.ziroom.ziroomcustomer.ziroomapartment.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.c.d;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuSignBillsListHistoryActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignBillLiving;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignKvItem;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ZryuSignLivingBillsFragment
  extends BaseFragment
{
  private ListView a;
  private TextView b;
  private a c;
  private TextView d;
  private CheckBox e;
  private TextView f;
  private Button g;
  private ScrollView h;
  private LinearLayout i;
  private LinearLayout j;
  private TextView k;
  private DecimalFormat l = new DecimalFormat("0.00");
  
  private void a(int paramInt, String paramString)
  {
    if ((getActivity() != null) && (!TextUtils.isEmpty(paramString))) {
      j.zryuSdDelFeeBill(getActivity(), Integer.valueOf(paramInt), paramString, new com.ziroom.commonlibrary.a.a(getActivity(), new d())
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          ((ZryuSignLivingBillsFragment.b)ZryuSignLivingBillsFragment.this.getActivity()).refreshData();
        }
      });
    }
  }
  
  public static ZryuSignLivingBillsFragment getInstance(String paramString1, String paramString2, List<ZryuSignBillLiving> paramList, String paramString3, int paramInt)
  {
    ZryuSignLivingBillsFragment localZryuSignLivingBillsFragment = new ZryuSignLivingBillsFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("bills", (ArrayList)paramList);
    localBundle.putString("tips", paramString3);
    localBundle.putInt("flag", paramInt);
    localBundle.putString("contractId", paramString1);
    localBundle.putString("systemId", paramString2);
    localZryuSignLivingBillsFragment.setArguments(localBundle);
    return localZryuSignLivingBillsFragment;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130904000, paramViewGroup, false);
    this.d = ((TextView)paramLayoutInflater.findViewById(2131689835));
    this.e = ((CheckBox)paramLayoutInflater.findViewById(2131690977));
    this.f = ((TextView)paramLayoutInflater.findViewById(2131690309));
    this.g = ((Button)paramLayoutInflater.findViewById(2131690043));
    this.h = ((ScrollView)paramLayoutInflater.findViewById(2131690150));
    this.i = ((LinearLayout)paramLayoutInflater.findViewById(2131694406));
    this.j = ((LinearLayout)paramLayoutInflater.findViewById(2131689818));
    this.k = ((TextView)paramLayoutInflater.findViewById(2131694407));
    if (getArguments().getInt("flag") == 0) {
      this.k.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup = getArguments().getParcelableArrayList("bills");
      paramBundle = getArguments().getString("tips");
      this.a = ((ListView)paramLayoutInflater.findViewById(2131689817));
      this.b = ((TextView)paramLayoutInflater.findViewById(2131692260));
      this.b.getPaint().setFlags(8);
      this.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (ZryuSignLivingBillsFragment.this.getActivity() != null)
          {
            paramAnonymousView = new Intent(ZryuSignLivingBillsFragment.this.getActivity(), ZryuSignBillsListHistoryActivity.class);
            paramAnonymousView.putExtra("contractId", ZryuSignLivingBillsFragment.this.getArguments().getString("contractId"));
            ZryuSignLivingBillsFragment.this.getActivity().startActivity(paramAnonymousView);
          }
        }
      });
      setData(paramViewGroup, paramBundle);
      this.e.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (ZryuSignLivingBillsFragment.a(ZryuSignLivingBillsFragment.this).isChecked())
          {
            ZryuSignLivingBillsFragment.b(ZryuSignLivingBillsFragment.this).selectAll();
            return;
          }
          ZryuSignLivingBillsFragment.b(ZryuSignLivingBillsFragment.this).selectNone();
        }
      });
      this.g.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ((ZryuSignLivingBillsFragment.this.getActivity() != null) && (ZryuSignLivingBillsFragment.b(ZryuSignLivingBillsFragment.this) != null))
          {
            paramAnonymousView = ZryuSignLivingBillsFragment.b(ZryuSignLivingBillsFragment.this).selectedNumStr();
            if (TextUtils.isEmpty(paramAnonymousView)) {
              g.textToast(ZryuSignLivingBillsFragment.this.getActivity(), "请选择待支付的生活费用账单！");
            }
          }
          else
          {
            return;
          }
          int i = ZryuSignLivingBillsFragment.b(ZryuSignLivingBillsFragment.this).selectedSum();
          if (ZryuSignLivingBillsFragment.this.getActivity() != null) {
            ((ZryuSignLivingBillsFragment.b)ZryuSignLivingBillsFragment.this.getActivity()).onZryuSignLivingBillsPay(i);
          }
          com.ziroom.ziroomcustomer.payment.a.startPayActivty(ZryuSignLivingBillsFragment.this.getActivity(), i, "1001", paramAnonymousView, ZryuSignLivingBillsFragment.this.getArguments().getString("systemId"));
        }
      });
      return paramLayoutInflater;
      this.k.setVisibility(0);
      this.k.getPaint().setFlags(8);
      this.k.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (ZryuSignLivingBillsFragment.this.getActivity() != null)
          {
            paramAnonymousView = new Intent(ZryuSignLivingBillsFragment.this.getActivity(), ZryuSignBillsListHistoryActivity.class);
            paramAnonymousView.putExtra("contractId", ZryuSignLivingBillsFragment.this.getArguments().getString("contractId"));
            ZryuSignLivingBillsFragment.this.getActivity().startActivity(paramAnonymousView);
          }
        }
      });
    }
  }
  
  public void setData(List<ZryuSignBillLiving> paramList, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.d.setVisibility(8);
    }
    for (;;)
    {
      if (getActivity() != null)
      {
        if ((paramList == null) || (paramList.size() <= 0)) {
          break;
        }
        this.h.setVisibility(0);
        this.i.setVisibility(0);
        this.j.setVisibility(8);
        ((b)getActivity()).onZryuSignLivingBillsNumChanged(paramList.size());
        this.c = new a(getActivity(), paramList, new c()
        {
          public void onSelectChange(Set paramAnonymousSet, int paramAnonymousInt)
          {
            if ((paramAnonymousSet != null) && (paramAnonymousSet.size() == paramAnonymousInt)) {
              ZryuSignLivingBillsFragment.a(ZryuSignLivingBillsFragment.this).setChecked(true);
            }
            for (;;)
            {
              long l = ZryuSignLivingBillsFragment.b(ZryuSignLivingBillsFragment.this).selectedSum();
              if (l <= 0L) {
                break;
              }
              ZryuSignLivingBillsFragment.d(ZryuSignLivingBillsFragment.this).setText("合计：¥" + ZryuSignLivingBillsFragment.c(ZryuSignLivingBillsFragment.this).format((float)l / 100.0F));
              return;
              ZryuSignLivingBillsFragment.a(ZryuSignLivingBillsFragment.this).setChecked(false);
            }
            ZryuSignLivingBillsFragment.d(ZryuSignLivingBillsFragment.this).setText("");
          }
        });
        this.a.setAdapter(this.c);
      }
      return;
      this.d.setVisibility(0);
      this.d.setText(paramString);
    }
    ((b)getActivity()).onZryuSignLivingBillsNumChanged(0);
    this.h.setVisibility(8);
    this.i.setVisibility(8);
    this.j.setVisibility(0);
  }
  
  private class a
    extends BaseAdapter
  {
    private List<ZryuSignBillLiving> b;
    private Context c;
    private LayoutInflater d;
    private Set<String> e;
    private ZryuSignLivingBillsFragment.c f;
    private int g;
    private int h;
    
    public a(List<ZryuSignBillLiving> paramList, ZryuSignLivingBillsFragment.c paramc)
    {
      this.b = paramc;
      this.d = LayoutInflater.from(paramList);
      this.c = paramList;
      this.e = new HashSet();
      ZryuSignLivingBillsFragment.c localc;
      this.f = localc;
      if ((paramc != null) && (paramc.size() > 0))
      {
        paramList = paramc.iterator();
        while (paramList.hasNext())
        {
          paramc = (ZryuSignBillLiving)paramList.next();
          if (!TextUtils.isEmpty(paramc.getBillNum())) {
            this.e.add(paramc.getBillNum());
          }
        }
      }
      this.g = ((int)(ZryuSignLivingBillsFragment.this.getResources().getDisplayMetrics().density * 12.0F));
      this.h = Color.parseColor("#999999");
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
    
    public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      final ZryuSignBillLiving localZryuSignBillLiving;
      if (paramView == null)
      {
        paramView = this.d.inflate(2130904632, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((CheckBox)paramView.findViewById(2131692109));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131689541));
        paramViewGroup.c = ((LinearLayout)paramView.findViewById(2131689775));
        paramViewGroup.d = ((TextView)paramView.findViewById(2131691107));
        paramViewGroup.e = ((Button)paramView.findViewById(2131690043));
        paramView.setTag(paramViewGroup);
        localZryuSignBillLiving = (ZryuSignBillLiving)getItem(paramInt);
        paramViewGroup.b.setText(localZryuSignBillLiving.getName());
        paramViewGroup.a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          @Instrumented
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
            if (!TextUtils.isEmpty(localZryuSignBillLiving.getBillNum()))
            {
              if (!paramAnonymousBoolean) {
                break label85;
              }
              ZryuSignLivingBillsFragment.a.a(ZryuSignLivingBillsFragment.a.this).add(localZryuSignBillLiving.getBillNum());
            }
            for (;;)
            {
              if (ZryuSignLivingBillsFragment.a.b(ZryuSignLivingBillsFragment.a.this) != null) {
                ZryuSignLivingBillsFragment.a.b(ZryuSignLivingBillsFragment.a.this).onSelectChange(ZryuSignLivingBillsFragment.a.a(ZryuSignLivingBillsFragment.a.this), ZryuSignLivingBillsFragment.a.c(ZryuSignLivingBillsFragment.a.this).size());
              }
              return;
              label85:
              ZryuSignLivingBillsFragment.a.a(ZryuSignLivingBillsFragment.a.this).remove(localZryuSignBillLiving.getBillNum());
            }
          }
        });
        if ((TextUtils.isEmpty(localZryuSignBillLiving.getBillNum())) || (!this.e.contains(localZryuSignBillLiving.getBillNum()))) {
          break label381;
        }
        paramViewGroup.a.setChecked(true);
      }
      for (;;)
      {
        paramView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = paramViewGroup.a;
            if (!paramViewGroup.a.isChecked()) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousView.setChecked(bool);
              return;
            }
          }
        });
        paramViewGroup.c.removeAllViews();
        if ((localZryuSignBillLiving.getList() == null) || (localZryuSignBillLiving.getList().size() <= 0)) {
          break label392;
        }
        paramViewGroup.c.setVisibility(0);
        Iterator localIterator = localZryuSignBillLiving.getList().iterator();
        while (localIterator.hasNext())
        {
          ZryuSignKvItem localZryuSignKvItem = (ZryuSignKvItem)localIterator.next();
          TextView localTextView = new TextView(this.c);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
          localLayoutParams.setMargins(0, 0, 0, this.g);
          localTextView.setLayoutParams(localLayoutParams);
          localTextView.setLines(1);
          localTextView.setTextSize(2, 12.0F);
          localTextView.setTextColor(this.h);
          localTextView.setText(localZryuSignKvItem.getName() + ":" + localZryuSignKvItem.getValue());
          paramViewGroup.c.addView(localTextView);
        }
        paramViewGroup = (a)paramView.getTag();
        break;
        label381:
        paramViewGroup.a.setChecked(false);
      }
      label392:
      paramViewGroup.c.setVisibility(8);
      paramViewGroup.d.setText(localZryuSignBillLiving.getValue());
      if ((!TextUtils.isEmpty(localZryuSignBillLiving.getDelDesc())) && (localZryuSignBillLiving.getDelCode() != null))
      {
        paramViewGroup.e.setVisibility(0);
        paramViewGroup.e.setText(localZryuSignBillLiving.getDelDesc());
        paramViewGroup.e.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (localZryuSignBillLiving.getDelCode().intValue() == 1) {
              c.newBuilder(ZryuSignLivingBillsFragment.a.d(ZryuSignLivingBillsFragment.a.this)).setContent("您确认要废除账单吗？").setTitle("提示").setBtnCancelText("我再想想").setBtnConfirmText("确定").setOnConfirmClickListener(new c.b()
              {
                public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
                {
                  if (paramAnonymous2Boolean) {
                    ZryuSignLivingBillsFragment.a(ZryuSignLivingBillsFragment.this, ZryuSignLivingBillsFragment.a.3.this.a.getAmount().intValue(), ZryuSignLivingBillsFragment.a.3.this.a.getBillNum());
                  }
                }
              }).build().show();
            }
          }
        });
        return paramView;
      }
      paramViewGroup.e.setVisibility(8);
      return paramView;
    }
    
    public boolean isAllSelected()
    {
      return (this.b != null) && (this.e.size() == this.b.size());
    }
    
    public void selectAll()
    {
      if ((this.b == null) || (this.b.size() == 0) || (this.e.size() == this.b.size())) {
        return;
      }
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        ZryuSignBillLiving localZryuSignBillLiving = (ZryuSignBillLiving)localIterator.next();
        if (!TextUtils.isEmpty(localZryuSignBillLiving.getBillNum())) {
          this.e.add(localZryuSignBillLiving.getBillNum());
        }
      }
      notifyDataSetChanged();
    }
    
    public void selectNone()
    {
      this.e.clear();
      notifyDataSetChanged();
    }
    
    public String selectedNumStr()
    {
      if ((this.e != null) && (this.e.size() > 0))
      {
        Iterator localIterator = this.e.iterator();
        String str2;
        for (String str1 = ""; localIterator.hasNext(); str1 = str1 + "," + str2) {
          str2 = (String)localIterator.next();
        }
        if (!TextUtils.isEmpty(str1)) {
          return str1.substring(1);
        }
      }
      return "";
    }
    
    public int selectedSum()
    {
      int j = 0;
      int i = j;
      if (this.b != null)
      {
        i = j;
        if (this.b.size() > 0)
        {
          Iterator localIterator = this.b.iterator();
          i = 0;
          if (localIterator.hasNext())
          {
            ZryuSignBillLiving localZryuSignBillLiving = (ZryuSignBillLiving)localIterator.next();
            if (!this.e.contains(localZryuSignBillLiving.getBillNum())) {
              break label90;
            }
            i = localZryuSignBillLiving.getAmount().intValue() + i;
          }
        }
      }
      label90:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    private class a
    {
      CheckBox a;
      TextView b;
      LinearLayout c;
      TextView d;
      Button e;
      
      private a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void onZryuSignLivingBillsNumChanged(int paramInt);
    
    public abstract void onZryuSignLivingBillsPay(int paramInt);
    
    public abstract void refreshData();
  }
  
  static abstract interface c
  {
    public abstract void onSelectChange(Set paramSet, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/fragment/ZryuSignLivingBillsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */