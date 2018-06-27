package com.ziroom.ziroomcustomer.ziroomapartment.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuSignBillsItemActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.b;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignBillRent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZryuSignRentBillsFragment
  extends BaseFragment
{
  private TextView a;
  private ListView b;
  private LinearLayout c;
  private a d;
  private Context e;
  
  public static ZryuSignRentBillsFragment getInstance(String paramString1, String paramString2, List<ZryuSignBillRent> paramList, String paramString3, String paramString4)
  {
    ZryuSignRentBillsFragment localZryuSignRentBillsFragment = new ZryuSignRentBillsFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("bills", (ArrayList)paramList);
    localBundle.putString("tips", paramString3);
    localBundle.putString("contractId", paramString1);
    localBundle.putString("contractCode", paramString4);
    localBundle.putString("systemId", paramString2);
    localZryuSignRentBillsFragment.setArguments(localBundle);
    return localZryuSignRentBillsFragment;
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.e = paramContext;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130904001, paramViewGroup, false);
    paramViewGroup = getArguments().getParcelableArrayList("bills");
    paramBundle = getArguments().getString("tips");
    this.b = ((ListView)paramLayoutInflater.findViewById(2131689817));
    this.a = ((TextView)paramLayoutInflater.findViewById(2131689835));
    this.c = ((LinearLayout)paramLayoutInflater.findViewById(2131689818));
    setData(paramViewGroup, paramBundle);
    return paramLayoutInflater;
  }
  
  public void setData(List<ZryuSignBillRent> paramList, String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString))
    {
      this.a.setVisibility(8);
      if (getActivity() == null) {
        break label176;
      }
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label177;
      }
      this.b.setVisibility(0);
      this.c.setVisibility(8);
      paramString = paramList.iterator();
      label62:
      if (!paramString.hasNext()) {
        break label128;
      }
      ZryuSignBillRent localZryuSignBillRent = (ZryuSignBillRent)paramString.next();
      if ((localZryuSignBillRent.getOperationCode() == null) || (localZryuSignBillRent.getOperationCode().intValue() != 1)) {
        break label215;
      }
      i += 1;
    }
    label128:
    label176:
    label177:
    label215:
    for (;;)
    {
      break label62;
      this.a.setVisibility(0);
      this.a.setText(paramString);
      break;
      if (getActivity() != null) {
        ((b)getActivity()).onZryuSignRentBillsNumChanged(i);
      }
      this.d = new a(getActivity(), paramList);
      this.b.setAdapter(this.d);
      return;
      if (getActivity() != null) {
        ((b)getActivity()).onZryuSignRentBillsNumChanged(0);
      }
      this.c.setVisibility(0);
      this.b.setVisibility(8);
      return;
    }
  }
  
  private class a
    extends BaseAdapter
  {
    private List<ZryuSignBillRent> b;
    private LayoutInflater c;
    private int d;
    private int e;
    private int f;
    
    public a(List<ZryuSignBillRent> paramList)
    {
      List localList;
      this.b = localList;
      this.c = LayoutInflater.from(paramList);
      this.d = Color.parseColor("#FC6C6C");
      this.e = Color.parseColor("#444444");
      this.f = Color.parseColor("#999999");
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
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      final ZryuSignBillRent localZryuSignBillRent;
      if (paramView == null)
      {
        paramView = this.c.inflate(2130904634, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131689541));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131689822));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131695901));
        paramViewGroup.d = ((TextView)paramView.findViewById(2131695902));
        paramViewGroup.e = ((TextView)paramView.findViewById(2131691107));
        paramViewGroup.f = ((Button)paramView.findViewById(2131690043));
        paramView.setTag(paramViewGroup);
        localZryuSignBillRent = (ZryuSignBillRent)getItem(paramInt);
        if (localZryuSignBillRent.getPeriod() != null) {
          paramViewGroup.a.setText("第" + localZryuSignBillRent.getPeriod() + "期 房租账单");
        }
        if (!TextUtils.isEmpty(localZryuSignBillRent.getBillStatusTxt()))
        {
          paramViewGroup.b.setText(localZryuSignBillRent.getBillStatusTxt());
          if ((localZryuSignBillRent.getBillStatus() == null) || (localZryuSignBillRent.getBillStatus().intValue() != 1)) {
            break label397;
          }
          paramViewGroup.b.setTextColor(this.d);
        }
        label216:
        paramViewGroup.c.setText("账单周期：" + localZryuSignBillRent.getBillCycle());
        paramViewGroup.d.setText("付款日期：" + localZryuSignBillRent.getPaymentDate());
        if ((localZryuSignBillRent.getBillStatus() == null) || (localZryuSignBillRent.getBillStatus().intValue() != 0)) {
          break label411;
        }
        paramViewGroup.e.setTextColor(this.f);
        paramViewGroup.e.setText("账单金额：" + localZryuSignBillRent.getReceivedAmount());
      }
      for (;;)
      {
        if (TextUtils.isEmpty(localZryuSignBillRent.getOperation())) {
          break label455;
        }
        paramViewGroup.f.setVisibility(0);
        paramViewGroup.f.setText(localZryuSignBillRent.getOperation());
        paramViewGroup.f.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = localZryuSignBillRent.getOperationCode();
            if (paramAnonymousView != null)
            {
              if (paramAnonymousView.intValue() != 1) {
                break label109;
              }
              if (ZryuSignRentBillsFragment.this.getActivity() != null) {
                b.toBillsInfo(ZryuSignRentBillsFragment.this.getActivity(), ZryuSignRentBillsFragment.this.getArguments().getString("contractId"), ZryuSignRentBillsFragment.this.getArguments().getString("contractCode"), "1007", localZryuSignBillRent.getPeriod() + "");
              }
            }
            label109:
            while ((paramAnonymousView.intValue() != 2) || (ZryuSignRentBillsFragment.this.getActivity() == null)) {
              return;
            }
            paramAnonymousView = new Intent(ZryuSignRentBillsFragment.a(ZryuSignRentBillsFragment.this), ZryuSignBillsItemActivity.class);
            paramAnonymousView.putExtra("contractId", ZryuSignRentBillsFragment.this.getArguments().getString("contractId"));
            if (localZryuSignBillRent.getPeriod() != null) {
              paramAnonymousView.putExtra("period", localZryuSignBillRent.getPeriod());
            }
            ZryuSignRentBillsFragment.this.getActivity().startActivity(paramAnonymousView);
          }
        });
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label397:
        paramViewGroup.b.setTextColor(this.e);
        break label216;
        label411:
        paramViewGroup.e.setTextColor(this.e);
        paramViewGroup.e.setText("待缴费用：" + localZryuSignBillRent.getReceivableAmount());
      }
      label455:
      paramViewGroup.f.setVisibility(8);
      return paramView;
    }
    
    private class a
    {
      TextView a;
      TextView b;
      TextView c;
      TextView d;
      TextView e;
      Button f;
      
      private a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void onZryuSignRentBillsNumChanged(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/fragment/ZryuSignRentBillsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */