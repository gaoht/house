package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.adapter.MyWillPayAdapter.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.ziroomapartment.b;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignPendingPay;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignPendingPayItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyWillPayZryuBillFragment
  extends BaseFragment
  implements MyWillPayAdapter.b
{
  private View a;
  private ListView b;
  private a c;
  private ViewStub d;
  private Context e;
  private List<ZryuSignPendingPayItem> f = new ArrayList();
  
  private void c()
  {
    this.c = new a(this.e);
    this.b.setAdapter(this.c);
  }
  
  private void d()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if ((localUserInfo != null) && (!TextUtils.isEmpty(localUserInfo.getUid())))
    {
      j.zryuPendingPay(this.e, new com.ziroom.commonlibrary.a.a(this.e, new f(ZryuSignPendingPay.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          MyWillPayZryuBillFragment.this.showError(paramAnonymousThrowable.getMessage());
        }
        
        public void onSuccess(int paramAnonymousInt, ZryuSignPendingPay paramAnonymousZryuSignPendingPay)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousZryuSignPendingPay);
          if (paramAnonymousZryuSignPendingPay != null)
          {
            MyWillPayZryuBillFragment.a(MyWillPayZryuBillFragment.this).clear();
            Object localObject = paramAnonymousZryuSignPendingPay.getLifeBillList();
            if ((localObject != null) && (((List)localObject).size() > 0))
            {
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                ZryuSignPendingPayItem localZryuSignPendingPayItem = (ZryuSignPendingPayItem)((Iterator)localObject).next();
                localZryuSignPendingPayItem.setType(ZryuSignPendingPayItem.TYPE_LIVING);
                MyWillPayZryuBillFragment.a(MyWillPayZryuBillFragment.this).add(localZryuSignPendingPayItem);
              }
            }
            paramAnonymousZryuSignPendingPay = paramAnonymousZryuSignPendingPay.getRoomRentList();
            if ((paramAnonymousZryuSignPendingPay != null) && (paramAnonymousZryuSignPendingPay.size() > 0))
            {
              paramAnonymousZryuSignPendingPay = paramAnonymousZryuSignPendingPay.iterator();
              while (paramAnonymousZryuSignPendingPay.hasNext())
              {
                localObject = (ZryuSignPendingPayItem)paramAnonymousZryuSignPendingPay.next();
                ((ZryuSignPendingPayItem)localObject).setType(ZryuSignPendingPayItem.TYPE_RENT);
                MyWillPayZryuBillFragment.a(MyWillPayZryuBillFragment.this).add(localObject);
              }
            }
            MyWillPayZryuBillFragment.b(MyWillPayZryuBillFragment.this).setDatas(MyWillPayZryuBillFragment.a(MyWillPayZryuBillFragment.this));
            if ((MyWillPayZryuBillFragment.a(MyWillPayZryuBillFragment.this) == null) || (MyWillPayZryuBillFragment.a(MyWillPayZryuBillFragment.this).size() == 0)) {
              MyWillPayZryuBillFragment.this.showError("暂无订单");
            }
            return;
          }
          MyWillPayZryuBillFragment.this.showError("暂无订单");
        }
      });
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this.e);
  }
  
  public static MyWillPayZryuBillFragment getInstance()
  {
    return new MyWillPayZryuBillFragment();
  }
  
  public void loadData()
  {
    d();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = paramLayoutInflater.inflate(2130903888, paramViewGroup, false);
    this.b = ((ListView)this.a.findViewById(2131689817));
    this.d = ((ViewStub)this.a.findViewById(2131690620));
    this.e = getActivity();
    c();
    return this.a;
  }
  
  public void onResume()
  {
    super.onResume();
    loadData();
  }
  
  public void showError(String paramString)
  {
    this.d.setVisibility(0);
    ((TextView)this.a.findViewById(2131690822)).setText(paramString);
    ((LinearLayout)this.a.findViewById(2131694408)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
      }
    });
  }
  
  public class a
    extends BaseAdapter
  {
    private Context b;
    private List<ZryuSignPendingPayItem> c;
    
    public a(Context paramContext)
    {
      this.b = paramContext;
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
    
    public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(this.b).inflate(2130904620, paramViewGroup, false);
        paramView = new a();
        paramView.a = ((TextView)localView.findViewById(2131689541));
        paramView.b = ((TextView)localView.findViewById(2131689822));
        paramView.c = ((TextView)localView.findViewById(2131690049));
        paramView.d = ((TextView)localView.findViewById(2131695885));
        paramView.e = ((TextView)localView.findViewById(2131695886));
        paramView.f = ((TextView)localView.findViewById(2131691105));
        paramView.g = ((TextView)localView.findViewById(2131691840));
        paramView.h = ((SimpleDraweeView)localView.findViewById(2131691098));
        localView.setTag(paramView);
      }
      paramView = (a)localView.getTag();
      paramViewGroup = (ZryuSignPendingPayItem)this.c.get(paramInt);
      paramView.h.setController(c.frescoController(paramViewGroup.getProHeadFigureUrl()));
      if (paramViewGroup.getType() == ZryuSignPendingPayItem.TYPE_RENT)
      {
        paramView.a.setText("第" + paramViewGroup.getPeriod() + "期 房租账单");
        paramView.d.setText("账单周期：" + paramViewGroup.getBillCycle());
        paramView.e.setText("付款日期：" + paramViewGroup.getPaymentDate());
        paramView.f.setText("待缴费用：" + paramViewGroup.getReceivableAmount());
      }
      for (;;)
      {
        paramView.b.setText(paramViewGroup.getBillStatusTxt());
        paramView.c.setText(paramViewGroup.getProjectName());
        paramView.g.setText(paramViewGroup.getOperation());
        paramView.g.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (paramViewGroup.getType() == ZryuSignPendingPayItem.TYPE_RENT) {
              if ((paramViewGroup.getOperationCode() != null) && (paramViewGroup.getOperationCode().intValue() == 1)) {
                b.toBillsInfo(MyWillPayZryuBillFragment.a.a(MyWillPayZryuBillFragment.a.this), paramViewGroup.getContractId(), paramViewGroup.getContractCode(), "1007", paramViewGroup.getPeriod() + "");
              }
            }
            while ((paramViewGroup.getType() != ZryuSignPendingPayItem.TYPE_LIVING) || (paramViewGroup.getOperationCode() == null) || (paramViewGroup.getOperationCode().intValue() != 1)) {
              return;
            }
            b.toBillsList(MyWillPayZryuBillFragment.a.a(MyWillPayZryuBillFragment.a.this), paramViewGroup.getContractId(), 2, 1);
          }
        });
        return localView;
        if (paramViewGroup.getType() == ZryuSignPendingPayItem.TYPE_LIVING)
        {
          paramView.a.setText("生活费用账单");
          paramView.d.setText("账单项目：" + paramViewGroup.getCostNameList());
          paramView.e.setText("生成日期：" + paramViewGroup.getCreateDate());
          paramView.f.setText("待缴费用：" + paramViewGroup.getAmount());
        }
        else
        {
          paramView.a.setText("");
          paramView.d.setText("");
          paramView.e.setText("");
          paramView.f.setText("");
        }
      }
    }
    
    public void setDatas(List<ZryuSignPendingPayItem> paramList)
    {
      this.c = paramList;
      notifyDataSetChanged();
    }
    
    public class a
    {
      TextView a;
      TextView b;
      TextView c;
      TextView d;
      TextView e;
      TextView f;
      TextView g;
      SimpleDraweeView h;
      
      public a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyWillPayZryuBillFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */