package com.ziroom.ziroomcustomer.newServiceList.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairNewDetailActivity_New;
import com.ziroom.ziroomcustomer.newServiceList.model.aq;
import com.ziroom.ziroomcustomer.newrepair.activity.UrgencyRepairActivity;
import com.ziroom.ziroomcustomer.newrepair.b.l;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class j
  extends BaseAdapter
{
  private Context a;
  private List<aq> b;
  private Contract c;
  private a d;
  
  public j(Context paramContext, List<aq> paramList, Contract paramContract)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramContract;
  }
  
  private void a(b paramb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    switch (paramInt)
    {
    default: 
      paramb.k.setVisibility(8);
      paramb.l.setVisibility(8);
      return;
    case 0: 
      if (paramBoolean1)
      {
        paramb.k.setVisibility(0);
        paramb.k.setText("催单");
      }
      for (;;)
      {
        paramb.l.setVisibility(8);
        paramb.l.setText("取消订单");
        return;
        if ((paramInt == 0) && (!paramBoolean1)) {
          paramb.k.setVisibility(8);
        }
      }
    case 5: 
      paramb.k.setVisibility(0);
      paramb.k.setText("联系师傅");
      paramb.l.setVisibility(8);
      paramb.l.setText("取消订单");
      return;
    case 15: 
      paramb.k.setVisibility(0);
      paramb.k.setText("联系师傅");
      paramb.l.setVisibility(8);
      return;
    case 20: 
      paramb.k.setVisibility(0);
      paramb.k.setText("联系师傅");
      paramb.l.setVisibility(0);
      paramb.l.setText("去确认");
      return;
    case 25: 
      paramb.k.setVisibility(0);
      paramb.k.setText("联系师傅");
      paramb.l.setVisibility(8);
      return;
    case 30: 
      paramb.k.setVisibility(0);
      paramb.k.setText("联系师傅");
      paramb.l.setVisibility(0);
      paramb.l.setText("去验收");
      return;
    }
    paramb.k.setVisibility(0);
    paramb.k.setText("联系师傅");
    if (paramBoolean2)
    {
      paramb.l.setVisibility(0);
      paramb.l.setText("立即支付");
      return;
    }
    paramb.l.setVisibility(0);
    paramb.l.setText("去评价");
  }
  
  private void a(final b paramb, final aq paramaq, final List<l> paramList, final String paramString)
  {
    paramb.k.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if ((paramb.k.getVisibility() == 0) && ("催单".equals(paramb.k.getText()))) {
          if (j.b(j.this) != null) {
            j.b(j.this).promptOrder(paramaq.getLogicCode());
          }
        }
        do
        {
          do
          {
            return;
          } while ((paramb.k.getVisibility() != 0) || (!"联系师傅".equals(paramb.k.getText())));
          paramAnonymousView = paramaq.getServicerPhone();
        } while (TextUtils.isEmpty(paramAnonymousView));
        ah.callPhone(j.a(j.this), paramAnonymousView);
      }
    });
    paramb.l.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if ((paramb.l.getVisibility() == 0) && ("取消订单".equals(paramb.l.getText()))) {
          if (j.b(j.this) != null)
          {
            paramAnonymousView = new ArrayList();
            Iterator localIterator = paramList.iterator();
            while (localIterator.hasNext()) {
              paramAnonymousView.add(((l)localIterator.next()).getWxxmId());
            }
            j.b(j.this).cancelOrder(paramAnonymousView);
          }
        }
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if ((paramb.l.getVisibility() != 0) || (!"去确认".equals(paramb.l.getText()))) {
                  break;
                }
              } while (j.b(j.this) == null);
              j.b(j.this).confirmOrder(paramaq.getLogicCode(), "", paramaq.getLogicCode(), paramaq.getOrderCodeType());
              return;
              if ((paramb.l.getVisibility() != 0) || (!"去验收".equals(paramb.l.getText()))) {
                break;
              }
            } while (j.b(j.this) == null);
            j.b(j.this).passOrder(paramaq.getLogicCode(), paramaq.getLogicCode(), paramaq.getOrderCodeType());
            return;
            if ((paramb.l.getVisibility() != 0) || (!"立即支付".equals(paramb.l.getText()))) {
              break;
            }
          } while (j.b(j.this) == null);
          j.b(j.this).payForIt(paramaq.getLogicCode(), paramaq.getOrderCodeType());
          return;
        } while ((paramb.l.getVisibility() != 0) || (!"去评价".equals(paramb.l.getText())) || (j.b(j.this) == null));
        j.b(j.this).eval(paramaq.getsPic(), paramString, paramaq.getLogicCode());
      }
    });
  }
  
  public int getCount()
  {
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
    final aq localaq;
    Object localObject2;
    label273:
    Object localObject1;
    label359:
    String str;
    l locall;
    label442:
    Object localObject3;
    label540:
    int i;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130904251, null);
      paramViewGroup = new b();
      paramViewGroup.a = ((RelativeLayout)paramView.findViewById(2131690233));
      paramViewGroup.b = ((RelativeLayout)paramView.findViewById(2131695101));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131689541));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131690407));
      paramViewGroup.e = ((SimpleDraweeView)paramView.findViewById(2131694859));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131693265));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131690053));
      paramViewGroup.h = ((TextView)paramView.findViewById(2131695111));
      paramViewGroup.i = ((SimpleDraweeView)paramView.findViewById(2131695112));
      paramViewGroup.j = ((TextView)paramView.findViewById(2131690049));
      paramViewGroup.k = ((TextView)paramView.findViewById(2131695113));
      paramViewGroup.l = ((TextView)paramView.findViewById(2131695114));
      paramViewGroup.m = paramView.findViewById(2131690691);
      paramViewGroup.n = ((TextView)paramView.findViewById(2131695109));
      paramView.setTag(paramViewGroup);
      localaq = (aq)this.b.get(paramInt);
      paramViewGroup.g.setText(localaq.getOrderAddress());
      localObject2 = localaq.getOrderStatusName();
      paramViewGroup.d.setText((CharSequence)localObject2);
      if (!TextUtils.isEmpty(localaq.getPromiseTime())) {
        break label814;
      }
      paramViewGroup.n.setVisibility(8);
      paramViewGroup.d.setTextColor(this.a.getResources().getColor(2131624097));
      if (!TextUtils.isEmpty("")) {
        paramViewGroup.e.setController(c.frescoController(localaq.getsPic()));
      }
      localObject1 = (LinearLayout.LayoutParams)paramViewGroup.m.getLayoutParams();
      if (paramInt != this.b.size() - 1) {
        break label837;
      }
      ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, 0, n.dip2px(this.a, 24.0F));
      localObject1 = localaq.getPlanTime();
      str = localaq.getOrderAscription();
      paramInt = Integer.parseInt(localaq.getOrderStatus());
      if (!"1".equals(str)) {
        break label1081;
      }
      localObject2 = localaq.getWxxmList();
      locall = (l)((List)localObject2).get(0);
      str = localaq.getServicerName();
      paramViewGroup.b.setVisibility(0);
      if (paramInt != 0) {
        break label849;
      }
      paramViewGroup.j.setText("正在派单…");
      if (!TextUtils.isEmpty(str))
      {
        if (!TextUtils.isEmpty(localaq.getsPic())) {
          paramViewGroup.i.setController(c.frescoController(localaq.getsPic()));
        }
        paramViewGroup.j.setText("维修员" + str);
      }
      localObject3 = localaq.getSfyyTime();
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        break label874;
      }
      paramViewGroup.f.setText(m.TimeL2S(m.TimeS2L((String)localObject3, m.c), m.d));
      i = localaq.getOrderType();
      paramViewGroup.h.setVisibility(0);
      if (((List)localObject2).size() <= 1) {
        break label972;
      }
      paramViewGroup.h.setText(locall.getKongjianName() + "...");
      localObject3 = new StringBuilder();
      if (i != 1) {
        break label964;
      }
      localObject1 = "紧急·";
      label617:
      localObject1 = new SpannableString((String)localObject1 + locall.getZhutiName() + locall.getXiangmuName() + "...");
      ((SpannableString)localObject1).setSpan(new StyleSpan(1), 0, "紧急".length(), 33);
      paramViewGroup.c.setText((CharSequence)localObject1);
      localaq.getIsNew();
      paramViewGroup.a.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent();
          paramAnonymousView.setClass(j.a(j.this), UrgencyRepairActivity.class);
          paramAnonymousView.putExtra("orderCode", localaq.getLogicCode());
          paramAnonymousView.putExtra("orderCodeType", localaq.getOrderCodeType());
          j.a(j.this).startActivity(paramAnonymousView);
        }
      });
      if (localaq.getIsPay() != 1) {
        break label1279;
      }
    }
    label814:
    label837:
    label849:
    label874:
    label964:
    label972:
    label1081:
    label1279:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((paramInt == 35) && (bool1))
      {
        paramViewGroup.d.setText("待支付");
        paramViewGroup.d.setTextColor(this.a.getResources().getColor(2131624529));
      }
      boolean bool2 = false;
      if (localaq.getRemindable() == 1) {
        bool2 = true;
      }
      a(paramViewGroup, paramInt, bool2, bool1);
      a(paramViewGroup, localaq, (List)localObject2, str);
      do
      {
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        paramViewGroup.n.setVisibility(0);
        paramViewGroup.n.setText(localaq.getPromiseTime());
        break label273;
        ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
        break label359;
        if ((paramInt != 10) || (!TextUtils.isEmpty(str))) {
          break label442;
        }
        paramViewGroup.b.setVisibility(4);
        break label442;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label540;
        }
        localObject3 = paramViewGroup.f;
        StringBuilder localStringBuilder = new StringBuilder().append(m.getFormatDate(m.strToDate((String)localObject1, m.c), m.l)).append(" ");
        if (TextUtils.isEmpty(localaq.getTimeInterval()) == true) {}
        for (localObject1 = "";; localObject1 = localaq.getTimeInterval())
        {
          ((TextView)localObject3).setText((String)localObject1);
          break;
        }
        localObject1 = "普通·";
        break label617;
        paramViewGroup.h.setText(locall.getKongjianName());
        localObject3 = new StringBuilder();
        if (i == 1) {}
        for (localObject1 = "紧急·";; localObject1 = "普通·")
        {
          localObject1 = new SpannableString((String)localObject1 + locall.getZhutiName() + locall.getXiangmuName());
          ((SpannableString)localObject1).setSpan(new StyleSpan(1), 0, "紧急".length(), 33);
          paramViewGroup.c.setText((CharSequence)localObject1);
          break;
        }
      } while (!"2".equals(str));
      paramViewGroup.b.setVisibility(4);
      paramViewGroup.d.setText((CharSequence)localObject2);
      localObject2 = new SpannableString(localaq.getCategoryName() + "·" + localaq.getProductName());
      ((SpannableString)localObject2).setSpan(new StyleSpan(1), 0, localaq.getCategoryName().length(), 33);
      paramViewGroup.c.setText((CharSequence)localObject2);
      paramViewGroup.h.setVisibility(4);
      if ((localObject1 != null) && (((String)localObject1).length() >= 10))
      {
        localObject2 = ((String)localObject1).substring(0, 10);
        localObject1 = ((String)localObject1).substring(11, 16);
        paramViewGroup.f.setText((String)localObject2 + "  " + (String)localObject1);
      }
      paramViewGroup.a.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(j.a(j.this), RepairNewDetailActivity_New.class);
          paramAnonymousView.putExtra("serviceType", "付费维修");
          paramAnonymousView.putExtra("maintainOrderCode", localaq.getLogicCode());
          j.a(j.this).startActivity(paramAnonymousView);
        }
      });
      return paramView;
    }
  }
  
  public void setData(List<aq> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public void setOnClickBtnListener(a parama)
  {
    this.d = parama;
  }
  
  public static abstract interface a
  {
    public abstract void cancelOrder(List<String> paramList);
    
    public abstract void confirmOrder(String paramString1, String paramString2, String paramString3, String paramString4);
    
    public abstract void eval(String paramString1, String paramString2, String paramString3);
    
    public abstract void passOrder(String paramString1, String paramString2, String paramString3);
    
    public abstract void payForIt(String paramString1, String paramString2);
    
    public abstract void promptOrder(String paramString);
  }
  
  public static class b
  {
    public RelativeLayout a;
    public RelativeLayout b;
    public TextView c;
    public TextView d;
    public SimpleDraweeView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public SimpleDraweeView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public View m;
    public TextView n;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */