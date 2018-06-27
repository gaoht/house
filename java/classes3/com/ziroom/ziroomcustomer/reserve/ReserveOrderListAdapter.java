package com.ziroom.ziroomcustomer.reserve;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.activity.HouseBillInfoActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.r;
import com.ziroom.ziroomcustomer.e.e.m;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.signed.o;
import com.ziroom.ziroomcustomer.sublet.activity.SubletReservationDetailActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReserveOrderListAdapter
  extends BaseAdapter
{
  f<e> a = new f(this.c, new r())
  {
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      if (paramAnonymouse != null)
      {
        u.logBigData("OKHttp_ymq", "===" + paramAnonymouse.toString());
        paramAnonymousInt = paramAnonymouse.getInteger("error_code").intValue();
        String str = paramAnonymouse.getString("status");
        paramAnonymouse.getString("data");
        paramAnonymouse = paramAnonymouse.getString("error_message");
        if ((!"success".equals(str)) || (paramAnonymousInt != 0)) {
          break label122;
        }
        if ((ReserveOrderListAdapter.a(ReserveOrderListAdapter.this) instanceof BookingOrderListActivity))
        {
          ((BookingOrderListActivity)ReserveOrderListAdapter.a(ReserveOrderListAdapter.this)).setPageNum(1);
          ((BookingOrderListActivity)ReserveOrderListAdapter.a(ReserveOrderListAdapter.this)).initData();
        }
      }
      return;
      label122:
      af.showToast(ReserveOrderListAdapter.a(ReserveOrderListAdapter.this), paramAnonymouse);
    }
  };
  private List<d> b;
  private Context c;
  private ViewHolder d;
  private String e;
  private a f;
  
  public ReserveOrderListAdapter(List<d> paramList, Context paramContext)
  {
    this.b = paramList;
    this.c = paramContext;
  }
  
  private void a(ViewHolder paramViewHolder, final d paramd)
  {
    final List localList = paramd.getButtons();
    if ((localList != null) && (localList.size() > 0))
    {
      if (localList.size() == 1)
      {
        paramViewHolder.tvButton1.setVisibility(8);
        paramViewHolder.tvButton2.setVisibility(0);
        paramViewHolder.tvButton2.setText(((d.a)localList.get(0)).b);
        paramViewHolder.tvButton2.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            ReserveOrderListAdapter.a(ReserveOrderListAdapter.this, (d.a)localList.get(0), paramd);
          }
        });
      }
      while (localList.size() <= 1) {
        return;
      }
      int i = (b.getScreenWidth(this.c) - b.dip2px(this.c, 54.0F)) / 2;
      paramViewHolder.tvButton1.getLayoutParams().width = i;
      paramViewHolder.tvButton1.setVisibility(0);
      paramViewHolder.tvButton1.setText(((d.a)localList.get(0)).b);
      paramViewHolder.tvButton1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ReserveOrderListAdapter.a(ReserveOrderListAdapter.this, (d.a)localList.get(0), paramd);
        }
      });
      paramViewHolder.tvButton2.getLayoutParams().width = i;
      paramViewHolder.tvButton2.setVisibility(0);
      paramViewHolder.tvButton2.setText(((d.a)localList.get(1)).b);
      paramViewHolder.tvButton2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ReserveOrderListAdapter.a(ReserveOrderListAdapter.this, (d.a)localList.get(1), paramd);
        }
      });
      return;
    }
    paramViewHolder.tvButton1.setVisibility(8);
    paramViewHolder.tvButton2.setVisibility(8);
  }
  
  private void a(final d.a parama, final d paramd)
  {
    String str;
    int i;
    if ((parama != null) && (ae.notNull(parama.a)))
    {
      str = parama.a;
      i = -1;
      switch (str.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (str.equals("detail"))
        {
          i = 0;
          continue;
          if (str.equals("pay"))
          {
            i = 1;
            continue;
            if (str.equals("sign"))
            {
              i = 2;
              continue;
              if (str.equals("dialing"))
              {
                i = 3;
                continue;
                if (str.equals("cancel"))
                {
                  i = 4;
                  continue;
                  if (str.equals("confirm"))
                  {
                    i = 5;
                    continue;
                    if (str.equals("delete_cancel")) {
                      i = 6;
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    parama = new Intent(this.c, SubletReservationDetailActivity.class);
    parama.putExtra("reserveCode", paramd.getOrderCode());
    this.c.startActivity(parama);
    return;
    parama = new Intent(this.c, HouseBillInfoActivity.class);
    parama.putExtra("uniqueCode", paramd.getOrderCode());
    parama.putExtra("period", "");
    if (paramd.getReserveType() == 2) {
      parama.putExtra("payType", "ZZYD");
    }
    for (;;)
    {
      this.c.startActivity(parama);
      return;
      parama.putExtra("payType", "pzyd");
    }
    if (paramd.getReserveType() == 2)
    {
      parama = g.buildGetreserveData(paramd.getOrderCode());
      j.checkReserveCanSign(this.c, parama, new f(this.c, new r())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          u.d("OKHttp_ymq", "===" + paramAnonymouse.toString());
          paramAnonymouse.getInteger("error_code").intValue();
          String str = paramAnonymouse.getString("status");
          paramAnonymouse.getString("data");
          paramAnonymouse = paramAnonymouse.getString("error_message");
          if ("success".equals(str))
          {
            paramAnonymouse = new ArrayList();
            paramAnonymouse.add(paramd.getHousePhone());
            paramAnonymouse = new HouseDetail(paramd.getHouseType(), paramAnonymouse, paramd.getHousePrice() + "", paramd.getHouseAddress(), paramd.getIsShort().intValue(), paramd.getHouseCode(), paramd.getHouseId());
            paramAnonymouse.setCityCode(com.ziroom.ziroomcustomer.minsu.b.c.a);
            new o(ReserveOrderListAdapter.a(ReserveOrderListAdapter.this)).toSign(paramAnonymouse, 1);
            return;
          }
          af.showToast(ReserveOrderListAdapter.a(ReserveOrderListAdapter.this), paramAnonymouse);
        }
      });
      return;
    }
    parama = new ArrayList();
    parama.add(paramd.getHousePhoto());
    parama = new HouseDetail(paramd.getHouseType(), parama, paramd.getHousePrice() + "", paramd.getHouseAddress(), paramd.getIsShort().intValue(), paramd.getHouseCode(), paramd.getHouseId());
    parama.setCityCode(com.ziroom.ziroomcustomer.minsu.b.c.a);
    new o(this.c).toSign(parama, 1);
    return;
    ah.callPhone(this.c, parama.e);
    return;
    com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this.c).setOnConfirmClickListener(new d.b()
    {
      public void onLeftClick(View paramAnonymousView) {}
      
      public void onRightClick(View paramAnonymousView)
      {
        paramAnonymousView = g.buildZkCancel(paramd.getOrderCode(), paramd.getOrderStatus() + "");
        String str = parama.a;
        int i = -1;
        switch (str.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            return;
            if (str.equals("cancel"))
            {
              i = 0;
              continue;
              if (str.equals("confirm"))
              {
                i = 1;
                continue;
                if (str.equals("delete_cancel")) {
                  i = 2;
                }
              }
            }
            break;
          }
        }
        if (2 == paramd.getReserveType())
        {
          j.zkCancelReservation(ReserveOrderListAdapter.a(ReserveOrderListAdapter.this), paramAnonymousView, ReserveOrderListAdapter.this.a);
          return;
        }
        ReserveOrderListAdapter.a(ReserveOrderListAdapter.this, q.s + e.m.j);
        paramAnonymousView = g.buildGetreserveCloseOrder(paramd.getOrderCode());
        j.getReservationOrderText(ReserveOrderListAdapter.a(ReserveOrderListAdapter.this), new ReserveOrderListAdapter.b(ReserveOrderListAdapter.this), paramAnonymousView, true, ReserveOrderListAdapter.b(ReserveOrderListAdapter.this));
        return;
        j.zkConfirmCancel(ReserveOrderListAdapter.a(ReserveOrderListAdapter.this), paramAnonymousView, ReserveOrderListAdapter.this.a);
        return;
        j.zkInvalidCancel(ReserveOrderListAdapter.a(ReserveOrderListAdapter.this), paramAnonymousView, ReserveOrderListAdapter.this.a);
      }
    }).setTitle(parama.c).setContent(parama.d).setButtonText("再想想", "确定").show();
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
    final d locald;
    label118:
    Object localObject2;
    if (paramView == null)
    {
      paramView = View.inflate(this.c, 2130903658, null);
      this.d = new ViewHolder(paramView);
      paramView.setTag(this.d);
      locald = (d)this.b.get(paramInt);
      this.d.tvBookOrderAddress.setText(locald.getHouseAddress());
      this.d.tvBookOrderStatus.setText(locald.getOrderStatusStr());
      if (!"orange".equals(locald.getOrderStatusColor())) {
        break label585;
      }
      this.d.tvBookOrderStatus.setTextColor(this.c.getResources().getColor(2131624609));
      this.d.sdvBookOrderImg.setController(com.freelxl.baselibrary.f.c.frescoController(locald.getHousePhoto()));
      this.d.tvBookOrderContractcode.setText(locald.getOrderCode());
      this.d.tvBookOrderLiveinTime.setText("预计可入住日期 " + locald.getCanSignDate());
      Object localObject1 = this.d.tvBookOrderPrice;
      localObject2 = new StringBuilder().append("¥").append(locald.getHousePrice());
      if (!ae.notNull(locald.getHousePriceUnit())) {
        break label611;
      }
      paramViewGroup = locald.getHousePriceUnit();
      label234:
      localObject2 = ((StringBuilder)localObject2).append(paramViewGroup).append("  ");
      if (!ae.notNull(locald.getPaymentCycleView())) {
        break label617;
      }
      paramViewGroup = locald.getPaymentCycleView();
      label265:
      ((TextView)localObject1).setText(paramViewGroup);
      if (!ae.notNull(locald.getReminder())) {
        break label638;
      }
      this.d.tvBookOrderTips.setVisibility(0);
      localObject2 = locald.getReminder();
      if (!((String)localObject2).contains("{")) {
        break label623;
      }
      paramViewGroup = ((String)localObject2).substring(0, ((String)localObject2).indexOf("{"));
      localObject1 = ((String)localObject2).substring(((String)localObject2).indexOf("{") + 1, ((String)localObject2).indexOf("}"));
      localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf("}") + 1, ((String)localObject2).length());
      localObject2 = paramViewGroup + (String)localObject1 + (String)localObject2;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject2);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.c.getResources().getColor(2131624599)), 0, paramViewGroup.length(), 33);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.c.getResources().getColor(2131623965)), paramViewGroup.length(), paramViewGroup.length() + ((String)localObject1).length(), 33);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.c.getResources().getColor(2131624599)), paramViewGroup.length() + ((String)localObject1).length(), ((String)localObject2).length(), 33);
      this.d.tvBookOrderTips.setText(localSpannableStringBuilder);
    }
    for (;;)
    {
      a(this.d, locald);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(ReserveOrderListAdapter.a(ReserveOrderListAdapter.this), SubletReservationDetailActivity.class);
          paramAnonymousView.putExtra("reserveCode", locald.getOrderCode());
          ReserveOrderListAdapter.a(ReserveOrderListAdapter.this).startActivity(paramAnonymousView);
        }
      });
      return paramView;
      this.d = ((ViewHolder)paramView.getTag());
      break;
      label585:
      this.d.tvBookOrderStatus.setTextColor(this.c.getResources().getColor(2131624599));
      break label118;
      label611:
      paramViewGroup = "";
      break label234;
      label617:
      paramViewGroup = "";
      break label265;
      label623:
      this.d.tvBookOrderTips.setText((CharSequence)localObject2);
      continue;
      label638:
      this.d.tvBookOrderTips.setVisibility(8);
    }
  }
  
  public List<d> getmList()
  {
    return this.b;
  }
  
  public void setmList(List<d> paramList)
  {
    this.b = paramList;
  }
  
  public void setmNotify(a parama)
  {
    this.f = parama;
  }
  
  static class ViewHolder
  {
    @BindView(2131693179)
    LinearLayout llBookOrderItem;
    @BindView(2131693182)
    SimpleDraweeView sdvBookOrderImg;
    @BindView(2131693180)
    TextView tvBookOrderAddress;
    @BindView(2131693183)
    TextView tvBookOrderContractcode;
    @BindView(2131693184)
    TextView tvBookOrderLiveinTime;
    @BindView(2131693185)
    TextView tvBookOrderPrice;
    @BindView(2131693181)
    TextView tvBookOrderStatus;
    @BindView(2131693186)
    TextView tvBookOrderTips;
    @BindView(2131693187)
    TextView tvButton1;
    @BindView(2131693188)
    TextView tvButton2;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
  
  public static abstract interface a
  {
    public abstract void notify(String paramString);
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        if (ReserveOrderListAdapter.b(ReserveOrderListAdapter.this).equals(paramk.getUrl()))
        {
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(null);
        }
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        if (ReserveOrderListAdapter.b(ReserveOrderListAdapter.this).equals(paramk.getUrl())) {
          ReserveOrderListAdapter.c(ReserveOrderListAdapter.this).notify(ReserveOrderListAdapter.b(ReserveOrderListAdapter.this));
        }
        return;
      }
      paramk = paramk.getMessage();
      paramk = Toast.makeText(ReserveOrderListAdapter.a(ReserveOrderListAdapter.this), "" + paramk, 0);
      if (!(paramk instanceof Toast))
      {
        paramk.show();
        return;
      }
      VdsAgent.showToast((Toast)paramk);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/reserve/ReserveOrderListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */