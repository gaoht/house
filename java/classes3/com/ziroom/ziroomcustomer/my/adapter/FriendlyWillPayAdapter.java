package com.ziroom.ziroomcustomer.my.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.activity.HouseBillInfoActivity;
import com.ziroom.ziroomcustomer.e.a.h;
import com.ziroom.ziroomcustomer.e.c.s;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.living.LeaseAllBillActivity;
import com.ziroom.ziroomcustomer.living.d;
import com.ziroom.ziroomcustomer.model.NotPayEntity;
import com.ziroom.ziroomcustomer.my.MyWillPayListActivity;
import com.ziroom.ziroomcustomer.repay.RepayInfoActivity;
import com.ziroom.ziroomcustomer.signed.EasilyPayLoanInfoActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FriendlyWillPayAdapter
  extends BaseAdapter
{
  private Context a;
  private List<NotPayEntity> b;
  private ViewHolder c;
  
  public FriendlyWillPayAdapter(Context paramContext, List<NotPayEntity> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getCount()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.a).inflate(2130904012, null);
      this.c = new ViewHolder(paramViewGroup);
      paramViewGroup.setTag(this.c);
      paramView = (NotPayEntity)this.b.get(paramInt);
      this.c.sdvIcon.setController(c.frescoController(paramView.getHousePic()));
      this.c.tvWillPayTitle.setText(paramView.getTitleNotes());
      this.c.tvWillPayInfoTop.setText(paramView.getAddress());
      i = paramView.getOverDueDay();
      if (!"rent".equals(paramView.getType())) {
        break label367;
      }
      if (1 != paramView.getOrderType()) {
        break label284;
      }
      this.c.tvWillPayPrice.setText("¥" + ah.Number(paramView.getMoney()));
      if (i >= 0) {
        break label249;
      }
      this.c.tvWillPayInfoCenter.setText("已逾期" + i * -1 + "天");
      label200:
      this.c.btnPay.setText("去支付");
    }
    for (;;)
    {
      this.c.btnPay.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          Log.e("notpay", "mList = " + ((NotPayEntity)FriendlyWillPayAdapter.a(FriendlyWillPayAdapter.this).get(paramInt)).toString());
          if ("rent".equals(((NotPayEntity)FriendlyWillPayAdapter.a(FriendlyWillPayAdapter.this).get(paramInt)).getType()))
          {
            FriendlyWillPayAdapter.this.toJudgeJump(1, paramInt);
            return;
          }
          if ("live".equals(((NotPayEntity)FriendlyWillPayAdapter.a(FriendlyWillPayAdapter.this).get(paramInt)).getType()))
          {
            FriendlyWillPayAdapter.this.toJudgeJump(2, paramInt);
            return;
          }
          if ("easy_pay_first".equals(((NotPayEntity)FriendlyWillPayAdapter.a(FriendlyWillPayAdapter.this).get(paramInt)).getType()))
          {
            FriendlyWillPayAdapter.this.toJudgeJump(4, paramInt);
            return;
          }
          if ("loan".equals(((NotPayEntity)FriendlyWillPayAdapter.a(FriendlyWillPayAdapter.this).get(paramInt)).getType()))
          {
            FriendlyWillPayAdapter.this.toIntent(5, paramInt);
            return;
          }
          FriendlyWillPayAdapter.this.toJudgeJump(3, paramInt);
        }
      });
      return paramViewGroup;
      this.c = ((ViewHolder)paramView.getTag());
      paramViewGroup = paramView;
      break;
      label249:
      this.c.tvWillPayInfoCenter.setText("应缴日期 " + paramView.getPayDateStr());
      break label200;
      label284:
      if (2 != paramView.getOrderType()) {
        break label200;
      }
      this.c.tvWillPayPrice.setText("¥" + ah.Number(paramView.getMoney()));
      this.c.tvWillPayInfoCenter.setText("已逾期" + i * -1 + "天");
      break label200;
      label367:
      if ("live".equals(paramView.getType()))
      {
        if (ae.notNull(paramView.getAllShouldPayAmount())) {
          this.c.tvWillPayPrice.setText("¥" + ah.Number(Float.parseFloat(ah.changeF2Y(paramView.getAllShouldPayAmount()))));
        }
        Object localObject = "";
        List localList = paramView.getExpensesCategoryList();
        paramView = (View)localObject;
        if (localList != null)
        {
          paramView = (View)localObject;
          if (localList.size() > 0)
          {
            paramView = "";
            i = 0;
            while (i < localList.size())
            {
              localObject = paramView;
              if (i <= 2) {
                localObject = paramView + ((d)localList.get(i)).getExpensesCategoryName() + "、";
              }
              i += 1;
              paramView = (View)localObject;
            }
            localObject = paramView.substring(0, paramView.length() - 1);
            paramView = (View)localObject;
            if (localList.size() > 3) {
              paramView = (String)localObject + "等";
            }
          }
        }
        this.c.tvWillPayInfoCenter.setText(paramView);
        this.c.btnPay.setText("去支付");
      }
      else
      {
        if ("easy_pay_first".equals(((NotPayEntity)this.b.get(paramInt)).getType()))
        {
          this.c.tvWillPayInfoCenter.setVisibility(8);
          if (0.0F == paramView.getMoney()) {
            this.c.btnPay.setText("确认贷款");
          }
          for (;;)
          {
            this.c.tvWillPayPrice.setText("¥" + ah.Number(paramView.getMoney()));
            break;
            this.c.btnPay.setText("去支付");
          }
        }
        if ("loan".equals(((NotPayEntity)this.b.get(paramInt)).getType()))
        {
          if (1 == paramView.getOrderType())
          {
            this.c.tvWillPayPrice.setText("¥" + ah.Number(paramView.getMoney()));
            if (i < 0) {
              this.c.tvWillPayInfoCenter.setText("已逾期" + i * -1 + "天");
            }
          }
          for (;;)
          {
            this.c.btnPay.setText("去支付");
            break;
            this.c.tvWillPayInfoCenter.setText("应缴日期 " + paramView.getPayDateStr());
            continue;
            if (2 == paramView.getOrderType())
            {
              this.c.tvWillPayPrice.setText("¥" + ah.Number(paramView.getMoney()));
              this.c.tvWillPayInfoCenter.setText("已逾期" + i * -1 + "天");
            }
          }
        }
        this.c.btnPay.setText("去支付");
        this.c.tvWillPayPrice.setText("¥" + ah.Number(paramView.getMoney()));
        this.c.tvWillPayInfoCenter.setText("已逾期" + i * -1 + "天");
      }
    }
  }
  
  public List<NotPayEntity> getmList()
  {
    return this.b;
  }
  
  public void setmList(List<NotPayEntity> paramList)
  {
    this.b = paramList;
  }
  
  public void toIntent(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3)
    {
      localIntent = new Intent(this.a, HouseBillInfoActivity.class);
      localIntent.putExtra("uniqueCode", ((NotPayEntity)this.b.get(paramInt2)).getContractCode());
      localIntent.putExtra("period", ((NotPayEntity)this.b.get(paramInt2)).getPeriod() + "");
      localIntent.putExtra("payType", "wyj");
      ((MyWillPayListActivity)this.a).startActivityForResult(localIntent, 66);
    }
    do
    {
      do
      {
        return;
        if (paramInt1 == 2)
        {
          localIntent = new Intent(this.a, LeaseAllBillActivity.class);
          localIntent.putExtra("mContractCode", ((NotPayEntity)this.b.get(paramInt2)).getRentContractCode());
          localIntent.putExtra("notPayLiving", "NotPayLiving");
          this.a.startActivity(localIntent);
          return;
        }
        if (paramInt1 != 1) {
          break;
        }
        if (1 == ((NotPayEntity)this.b.get(paramInt2)).getOrderType())
        {
          localIntent = new Intent(this.a, HouseBillInfoActivity.class);
          localIntent.putExtra("uniqueCode", ((NotPayEntity)this.b.get(paramInt2)).getContractCode());
          localIntent.putExtra("period", ((NotPayEntity)this.b.get(paramInt2)).getPeriod() + "");
          localIntent.putExtra("payType", "fz");
          ((MyWillPayListActivity)this.a).startActivityForResult(localIntent, 66);
          return;
        }
      } while (2 != ((NotPayEntity)this.b.get(paramInt2)).getOrderType());
      localIntent = new Intent(this.a, HouseBillInfoActivity.class);
      localIntent.putExtra("uniqueCode", ((NotPayEntity)this.b.get(paramInt2)).getContractCode());
      localIntent.putExtra("period", ((NotPayEntity)this.b.get(paramInt2)).getPeriod() + "");
      localIntent.putExtra("payType", "wyj");
      ((MyWillPayListActivity)this.a).startActivityForResult(localIntent, 66);
      return;
      if (paramInt1 == 4)
      {
        localIntent = new Intent(this.a, EasilyPayLoanInfoActivity.class);
        localIntent.putExtra("mContractCode", ((NotPayEntity)this.b.get(paramInt2)).getContractCode());
        localIntent.putExtra("isBack", true);
        ((MyWillPayListActivity)this.a).startActivityForResult(localIntent, 66);
        return;
      }
    } while (paramInt1 != 5);
    Intent localIntent = new Intent(this.a, RepayInfoActivity.class);
    localIntent.putExtra("contractCode", ((NotPayEntity)this.b.get(paramInt2)).getContractCode());
    this.a.startActivity(localIntent);
  }
  
  public void toJudgeJump(final int paramInt1, final int paramInt2)
  {
    if (("rent".equals(((NotPayEntity)this.b.get(paramInt2)).getType())) && (2 == ((NotPayEntity)this.b.get(paramInt2)).getOrderType())) {}
    String str2;
    int i;
    for (String str1 = "penalty";; str1 = ((NotPayEntity)this.b.get(paramInt2)).getType())
    {
      str2 = ((NotPayEntity)this.b.get(paramInt2)).getContractCode();
      i = ((NotPayEntity)this.b.get(paramInt2)).getPeriod();
      Object localObject3 = ((NotPayEntity)this.b.get(paramInt2)).getBillNumList();
      localObject2 = "";
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      localObject1 = localObject2;
      if (((List)localObject3).size() <= 0) {
        break;
      }
      localObject2 = ((List)localObject3).iterator();
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + (String)localObject3 + ",") {
        localObject3 = (String)((Iterator)localObject2).next();
      }
    }
    Object localObject2 = localObject1;
    if (((String)localObject1).length() > 0) {
      localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
    }
    Object localObject1 = g.buildCheckCanPay(str1, str2, i, (String)localObject2);
    j.getBillCheckCanPay(this.a, (Map)localObject1, new h(this.a, new s())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        paramAnonymousString = com.alibaba.fastjson.a.parseObject(paramAnonymousString);
        if (paramAnonymousString.getInteger("error_code").intValue() == 0)
        {
          FriendlyWillPayAdapter.this.toIntent(paramInt1, paramInt2);
          return;
        }
        af.showToast(FriendlyWillPayAdapter.b(FriendlyWillPayAdapter.this), paramAnonymousString.getString("error_message"));
      }
    });
  }
  
  static class ViewHolder
  {
    @BindView(2131690461)
    TextView btnPay;
    @BindView(2131694449)
    SimpleDraweeView sdvIcon;
    @BindView(2131694451)
    TextView tvWillPayInfoCenter;
    @BindView(2131694450)
    TextView tvWillPayInfoTop;
    @BindView(2131694452)
    TextView tvWillPayPrice;
    @BindView(2131694448)
    TextView tvWillPayStatus;
    @BindView(2131694447)
    TextView tvWillPayTitle;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/FriendlyWillPayAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */