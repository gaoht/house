package com.ziroom.ziroomcustomer.activity;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.model.GiftList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class c
  extends BaseAdapter
{
  CompoundButton.OnCheckedChangeListener a = new CompoundButton.OnCheckedChangeListener()
  {
    @Instrumented
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
      int j = ((Integer)paramAnonymousCompoundButton.getTag()).intValue();
      int i = 0;
      if (i < c.a(c.this).size())
      {
        if (i == j) {
          c.a(c.this).set(i, Integer.valueOf(1));
        }
        for (;;)
        {
          i += 1;
          break;
          c.a(c.this).set(i, Integer.valueOf(0));
        }
      }
      c.this.notifyDataSetChanged();
    }
  };
  private List<String> b;
  private HashMap<String, String> c;
  private Context d;
  private b e;
  private List<Integer> f = new ArrayList();
  private List<GiftList> g;
  private a h;
  private String i;
  private String j;
  
  public c(List<String> paramList, Context paramContext, List<Integer> paramList1)
  {
    this.f = paramList1;
    this.b = paramList;
    this.d = paramContext;
  }
  
  public c(List<String> paramList, Context paramContext, List<Integer> paramList1, HashMap<String, String> paramHashMap)
  {
    this.f = paramList1;
    this.b = paramList;
    this.c = paramHashMap;
    this.d = paramContext;
  }
  
  public c(List<String> paramList, Context paramContext, List<Integer> paramList1, List<GiftList> paramList2)
  {
    this.f = paramList1;
    this.b = paramList;
    this.d = paramContext;
    this.g = paramList2;
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
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.d, 2130905096, null);
      this.e = new b();
      this.e.e = ((CheckBox)paramView.findViewById(2131695528));
      this.e.a = ((TextView)paramView.findViewById(2131697418));
      this.e.b = ((TextView)paramView.findViewById(2131697419));
      this.e.d = ((SimpleDraweeView)paramView.findViewById(2131697417));
      this.e.c = ((TextView)paramView.findViewById(2131697420));
      paramView.setTag(this.e);
      if (((Integer)this.f.get(paramInt)).intValue() != 1) {
        break label322;
      }
      this.e.e.setChecked(true);
      label146:
      if (!"yl_make_order".equals(this.b.get(paramInt))) {
        break label336;
      }
      paramView.setVisibility(0);
      this.e.a.setText("银联信用卡支付");
      this.e.d.setController(com.freelxl.baselibrary.f.c.frescoFromResourceController(2130839921));
      label196:
      this.e.b.setVisibility(8);
      if (this.g == null) {
        break label698;
      }
      paramViewGroup = this.g.iterator();
    }
    for (;;)
    {
      if (!paramViewGroup.hasNext()) {
        break label698;
      }
      GiftList localGiftList = (GiftList)paramViewGroup.next();
      if (localGiftList.getPayWay().equals(this.b.get(paramInt)))
      {
        if (localGiftList.getIsHaveGift().equals("1"))
        {
          this.e.b.setVisibility(0);
          this.e.b.setText(localGiftList.getGiftNote());
          continue;
          this.e = ((b)paramView.getTag());
          break;
          label322:
          this.e.e.setChecked(false);
          break label146;
          label336:
          if ("wxpay_make_order_v2".equals(this.b.get(paramInt)))
          {
            paramView.setVisibility(0);
            this.e.a.setText("微信支付");
            this.e.d.setController(com.freelxl.baselibrary.f.c.frescoFromResourceController(2130839918));
            break label196;
          }
          if ("jd_m_pay".equals(this.b.get(paramInt)))
          {
            paramView.setVisibility(0);
            this.e.a.setText("京东支付");
            this.e.d.setController(com.freelxl.baselibrary.f.c.frescoFromResourceController(2130838902));
            break label196;
          }
          if ("yl_cashCard_make_order".equals(this.b.get(paramInt)))
          {
            this.e.a.setText("银联储蓄卡支付");
            this.e.d.setController(com.freelxl.baselibrary.f.c.frescoFromResourceController(2130839921));
            break label196;
          }
          if ("hf_make_order".equals(this.b.get(paramInt)))
          {
            paramView.setVisibility(0);
            this.e.a.setText("银行卡快捷支付");
            if ((this.i == null) || (this.i.equals("")))
            {
              this.e.d.setController(com.freelxl.baselibrary.f.c.frescoFromResourceController(2130838796));
              break label196;
            }
            this.e.d.setController(com.freelxl.baselibrary.f.c.frescoController(this.i));
            break label196;
          }
          if ("yl_dk".equals(this.b.get(paramInt)))
          {
            paramView.setVisibility(0);
            this.e.a.setText("银联代扣支付");
            if ((this.j == null) || (this.j.equals("")))
            {
              this.e.d.setController(com.freelxl.baselibrary.f.c.frescoFromResourceController(2130839921));
              break label196;
            }
            this.e.d.setController(com.freelxl.baselibrary.f.c.frescoController(this.j));
            break label196;
          }
          paramView.setVisibility(8);
          break label196;
        }
        this.e.b.setVisibility(8);
      }
    }
    label698:
    if ((this.c != null) && (this.c.size() > paramInt)) {
      this.e.c.setText((CharSequence)this.c.get(this.b.get(paramInt)));
    }
    this.e.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        int i = 0;
        if (i < c.this.getCount())
        {
          if (paramInt == i)
          {
            c.a(c.this).set(i, Integer.valueOf(1));
            label44:
            if (((Integer)c.a(c.this).get(paramInt)).intValue() != 0) {
              break label111;
            }
            c.b(c.this).e.setChecked(false);
          }
          for (;;)
          {
            i += 1;
            break;
            c.a(c.this).set(i, Integer.valueOf(0));
            break label44;
            label111:
            c.d(c.this).setPayType((String)c.c(c.this).get(paramInt));
            c.b(c.this).e.setChecked(true);
          }
        }
        c.this.notifyDataSetChanged();
      }
    });
    return paramView;
  }
  
  public List<Integer> getmCheck()
  {
    return this.f;
  }
  
  public List<String> getmList()
  {
    return this.b;
  }
  
  public HashMap<String, String> getmListMsg()
  {
    return this.c;
  }
  
  public a getmPayType()
  {
    return this.h;
  }
  
  public void setmCheck(List<Integer> paramList)
  {
    this.f = paramList;
  }
  
  public void setmImgHuifuIcon(String paramString)
  {
    this.i = paramString;
  }
  
  public void setmImgYldkIcon(String paramString)
  {
    this.j = paramString;
  }
  
  public void setmList(List<String> paramList)
  {
    this.b = paramList;
  }
  
  public void setmListMsg(HashMap<String, String> paramHashMap)
  {
    this.c = paramHashMap;
    notifyDataSetChanged();
  }
  
  public void setmPayType(a parama)
  {
    this.h = parama;
  }
  
  static abstract interface a
  {
    public abstract void setPayType(String paramString);
  }
  
  class b
  {
    TextView a;
    TextView b;
    TextView c;
    SimpleDraweeView d;
    CheckBox e;
    
    b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */