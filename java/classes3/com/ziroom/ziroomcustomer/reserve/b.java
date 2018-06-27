package com.ziroom.ziroomcustomer.reserve;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.fastjson.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.activity.HouseBillInfoActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.r;
import com.ziroom.ziroomcustomer.e.e.m;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.findhouse.view.RentHouseDetailActivity;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.signed.o;
import com.ziroom.ziroomcustomer.sublet.activity.SubletReservationDetailActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class b
  extends BaseAdapter
{
  private List<d> a;
  private Context b;
  private c c;
  private String d;
  private a e;
  private String f;
  
  public b(List<d> paramList, Context paramContext, String paramString)
  {
    this.f = paramString;
    this.a = paramList;
    this.b = paramContext;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(final int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    int i;
    if (paramView == null)
    {
      this.c = new c();
      paramView = View.inflate(this.b, 2130905099, null);
      c.a(this.c, (TextView)paramView.findViewById(2131697425));
      c.b(this.c, (TextView)paramView.findViewById(2131692417));
      c.c(this.c, (TextView)paramView.findViewById(2131696617));
      c.d(this.c, (TextView)paramView.findViewById(2131697427));
      c.a(this.c, (Button)paramView.findViewById(2131697426));
      c.a(this.c, (ImageView)paramView.findViewById(2131697428));
      c.b(this.c, (Button)paramView.findViewById(2131697430));
      c.a(this.c, (SimpleDraweeView)paramView.findViewById(2131692416));
      paramView.setTag(this.c);
      i = ((d)this.a.get(paramInt)).getOrderStatus();
      if (!ae.isNull(((d)this.a.get(paramInt)).getOrderStatusStr())) {
        break label600;
      }
      c.a(this.c).setVisibility(8);
      label223:
      c.b(this.c).setController(c.frescoController(((d)this.a.get(paramInt)).getHousePhoto()));
      if (i != 3) {
        break label640;
      }
      c.c(this.c).setVisibility(8);
      c.d(this.c).setVisibility(8);
      label282:
      if (((d)this.a.get(paramInt)).getCanClose() == 1)
      {
        c.d(this.c).setVisibility(8);
        c.c(this.c).setVisibility(8);
        setImageType(paramInt, this.c);
      }
      if (i != 2) {
        break label734;
      }
      c.e(this.c).setVisibility(0);
      c.e(this.c).setText("支付");
      ((d)this.a.get(paramInt)).setIsPay("支付");
    }
    for (;;)
    {
      c.f(this.c).setText(((d)this.a.get(paramInt)).getCanSignDate());
      c.g(this.c).setText(((d)this.a.get(paramInt)).getOrderCode());
      c.h(this.c).setText(((d)this.a.get(paramInt)).getHouseAddress());
      c.d(this.c).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ((d)b.a(b.this).get(paramInt)).setIsClor(1);
          b.this.notifyDataSetChanged();
        }
      });
      c.b(this.c).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(b.b(b.this), RentHouseDetailActivity.class);
          paramAnonymousView.putExtra("house_id", ((d)b.a(b.this).get(paramInt)).getHouseId());
          paramAnonymousView.putExtra("id", ((d)b.a(b.this).get(paramInt)).getHouseCode());
          b.b(b.this).startActivity(paramAnonymousView);
        }
      });
      c.e(this.c).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ("签约".equals(((d)b.a(b.this).get(paramInt)).getIsPay())) {
            if (((d)b.a(b.this).get(paramInt)).getReserveType() == 2)
            {
              paramAnonymousView = g.buildGetreserveData(((d)b.a(b.this).get(paramInt)).getOrderCode());
              j.checkReserveCanSign(b.b(b.this), paramAnonymousView, new f(b.b(b.this), new r())
              {
                public void onSuccess(int paramAnonymous2Int, e paramAnonymous2e)
                {
                  super.onSuccess(paramAnonymous2Int, paramAnonymous2e);
                  u.d("OKHttp_ymq", "===" + paramAnonymous2e.toString());
                  paramAnonymous2e.getInteger("error_code").intValue();
                  String str = paramAnonymous2e.getString("status");
                  paramAnonymous2e.getString("data");
                  paramAnonymous2e = paramAnonymous2e.getString("error_message");
                  if ("success".equals(str))
                  {
                    paramAnonymous2e = new ArrayList();
                    paramAnonymous2e.add(((d)b.a(b.this).get(b.3.this.a)).getHousePhone());
                    paramAnonymous2e = new HouseDetail(((d)b.a(b.this).get(b.3.this.a)).getHouseType(), paramAnonymous2e, ((d)b.a(b.this).get(b.3.this.a)).getHousePrice() + "", ((d)b.a(b.this).get(b.3.this.a)).getHouseAddress(), ((d)b.a(b.this).get(b.3.this.a)).getIsShort().intValue(), ((d)b.a(b.this).get(b.3.this.a)).getHouseCode(), ((d)b.a(b.this).get(b.3.this.a)).getHouseId());
                    paramAnonymous2e.setCityCode(b.c(b.this));
                    new o(b.b(b.this)).toSign(paramAnonymous2e, 1);
                    return;
                  }
                  af.showToast(b.b(b.this), paramAnonymous2e);
                }
              });
            }
          }
          while (!"支付".equals(((d)b.a(b.this).get(paramInt)).getIsPay()))
          {
            return;
            paramAnonymousView = new ArrayList();
            paramAnonymousView.add(((d)b.a(b.this).get(paramInt)).getHousePhone());
            paramAnonymousView = new HouseDetail(((d)b.a(b.this).get(paramInt)).getHouseType(), paramAnonymousView, ((d)b.a(b.this).get(paramInt)).getHousePrice() + "", ((d)b.a(b.this).get(paramInt)).getHouseAddress(), ((d)b.a(b.this).get(paramInt)).getIsShort().intValue(), ((d)b.a(b.this).get(paramInt)).getHouseCode(), ((d)b.a(b.this).get(paramInt)).getHouseId());
            paramAnonymousView.setCityCode(b.c(b.this));
            new o(b.b(b.this)).toSign(paramAnonymousView, 1);
            return;
          }
          paramAnonymousView = new Intent(b.b(b.this), HouseBillInfoActivity.class);
          paramAnonymousView.putExtra("uniqueCode", ((d)b.a(b.this).get(paramInt)).getOrderCode());
          paramAnonymousView.putExtra("period", "");
          if (((d)b.a(b.this).get(paramInt)).getReserveType() == 2) {
            paramAnonymousView.putExtra("payType", "ZZYD");
          }
          for (;;)
          {
            b.b(b.this).startActivity(paramAnonymousView);
            return;
            paramAnonymousView.putExtra("payType", "pzyd");
          }
        }
      });
      paramViewGroup = new f(this.b, new r())
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
            if (("success".equals(str)) && (paramAnonymousInt == 0)) {
              af.showToast(b.b(b.this), "关闭预约成功");
            }
          }
          else
          {
            return;
          }
          af.showToast(b.b(b.this), paramAnonymouse);
        }
      };
      c.c(this.c).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(final View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (((d)b.a(b.this).get(paramInt)).getReserveType() == 2)
          {
            com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(b.b(b.this)).setOnConfirmClickListener(new d.b()
            {
              public void onLeftClick(View paramAnonymous2View) {}
              
              public void onRightClick(View paramAnonymous2View)
              {
                paramAnonymous2View = g.buildZkCancel(((d)b.a(b.this).get(b.5.this.a)).getOrderCode(), ((d)b.a(b.this).get(b.5.this.a)).getOrderStatus() + "");
                j.zkCancelReservation(b.b(b.this), paramAnonymous2View, b.5.this.b);
              }
            }).setTitle(((d)b.a(b.this).get(paramInt)).getPromptTitle()).setContent(((d)b.a(b.this).get(paramInt)).getPromptText()).setButtonText("取消", "确定").show();
            return;
          }
          paramAnonymousView = new AlertDialog.Builder(b.b(b.this)).create();
          View localView = View.inflate(b.b(b.this), 2130903650, null);
          TextView localTextView1 = (TextView)localView.findViewById(2131693119);
          TextView localTextView2 = (TextView)localView.findViewById(2131693120);
          TextView localTextView3 = (TextView)localView.findViewById(2131691289);
          TextView localTextView4 = (TextView)localView.findViewById(2131693121);
          localTextView1.setText("关闭预约单？");
          if (((d)b.a(b.this).get(paramInt)).getDefaultAmount() == 0)
          {
            localTextView2.setText("点击【确认】后意味着你要关闭预约单，关闭之后，房源将不再为您锁定，已支付预订金将退回你的自如空间。");
            localTextView3.setText("确认");
            localTextView3.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                b.a(b.this, q.s + e.m.j);
                paramAnonymous2View = g.buildGetreserveCloseOrder(((d)b.a(b.this).get(b.5.this.a)).getOrderCode());
                j.getReservationOrderText(b.b(b.this), new b.b(b.this), paramAnonymous2View, true, b.d(b.this));
                paramAnonymousView.dismiss();
              }
            });
            localTextView4.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                paramAnonymousView.dismiss();
              }
            });
            paramAnonymousView.setView(localView, 0, 0, 0, 0);
            if ((paramAnonymousView instanceof AlertDialog)) {
              break label348;
            }
            paramAnonymousView.show();
          }
          for (;;)
          {
            paramAnonymousView.setOnDismissListener(new DialogInterface.OnDismissListener()
            {
              public void onDismiss(DialogInterface paramAnonymous2DialogInterface)
              {
                paramAnonymousView.dismiss();
              }
            });
            return;
            localTextView2.setText("点击【确认】后意味着你要关闭预约单，关闭之后，房源将不再为您锁定，同时会按照预订金的20%扣除违约金（" + ((d)b.a(b.this).get(paramInt)).getDefaultAmount() + "元），剩余款项将退回你的自如空间。");
            break;
            label348:
            VdsAgent.showDialog((AlertDialog)paramAnonymousView);
          }
        }
      });
      c.c(this.c).setTag(Integer.valueOf(paramInt));
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(b.b(b.this), SubletReservationDetailActivity.class);
          paramAnonymousView.putExtra("reserveCode", ((d)b.a(b.this).get(paramInt)).getOrderCode());
          b.b(b.this).startActivity(paramAnonymousView);
        }
      });
      return paramView;
      this.c = ((c)paramView.getTag());
      break;
      label600:
      c.a(this.c).setText(((d)this.a.get(paramInt)).getOrderStatusStr());
      c.a(this.c).setVisibility(0);
      break label223;
      label640:
      if (i == 5)
      {
        c.c(this.c).setVisibility(8);
        c.d(this.c).setVisibility(8);
        break label282;
      }
      if (i == 6)
      {
        c.c(this.c).setVisibility(8);
        c.d(this.c).setVisibility(8);
        break label282;
      }
      c.c(this.c).setVisibility(8);
      c.d(this.c).setVisibility(8);
      break label282;
      label734:
      if (((d)this.a.get(paramInt)).getCanSign() == 1)
      {
        c.e(this.c).setVisibility(0);
        c.e(this.c).setText("签约");
        ((d)this.a.get(paramInt)).setIsPay("签约");
      }
      else
      {
        ((d)this.a.get(paramInt)).setIsPay("");
        c.e(this.c).setText("");
        c.e(this.c).setVisibility(8);
      }
    }
  }
  
  public List<d> getmList()
  {
    return this.a;
  }
  
  public void setImageType(int paramInt, c paramc)
  {
    if (((d)this.a.get(paramInt)).getIsClor() == 0)
    {
      c.d(paramc).setVisibility(8);
      c.c(paramc).setVisibility(8);
      return;
    }
    c.d(paramc).setVisibility(8);
    c.c(paramc).setVisibility(0);
    c.c(paramc).setText("关闭预约");
  }
  
  public void setmList(List<d> paramList)
  {
    this.a = paramList;
  }
  
  public void setmNotify(a parama)
  {
    this.e = parama;
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
        if (b.d(b.this).equals(paramk.getUrl()))
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
        if (b.d(b.this).equals(paramk.getUrl())) {
          b.e(b.this).notify(b.d(b.this));
        }
        return;
      }
      paramk = paramk.getMessage();
      paramk = Toast.makeText(b.b(b.this), "" + paramk, 0);
      if (!(paramk instanceof Toast))
      {
        paramk.show();
        return;
      }
      VdsAgent.showToast((Toast)paramk);
    }
  }
  
  class c
  {
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private Button f;
    private Button g;
    private ImageView h;
    private SimpleDraweeView i;
    
    c() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/reserve/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */