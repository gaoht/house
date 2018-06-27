package com.ziroom.ziroomcustomer.reserve;

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
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.model.GiftList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class a
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
      if (i < a.a(a.this).size())
      {
        if (i == j) {
          a.a(a.this).set(i, Integer.valueOf(1));
        }
        for (;;)
        {
          i += 1;
          break;
          a.a(a.this).set(i, Integer.valueOf(0));
        }
      }
      a.this.notifyDataSetChanged();
    }
  };
  private List<Integer> b;
  private HashMap<Integer, String> c;
  private Context d;
  private b e;
  private List<Integer> f = new ArrayList();
  private a g;
  private String h;
  private List<GiftList> i;
  
  public a(List<Integer> paramList1, Context paramContext, List<Integer> paramList2)
  {
    this.f = paramList2;
    this.b = paramList1;
    this.d = paramContext;
  }
  
  public a(List<Integer> paramList1, Context paramContext, List<Integer> paramList2, HashMap<Integer, String> paramHashMap)
  {
    this.f = paramList2;
    this.b = paramList1;
    this.d = paramContext;
    this.c = paramHashMap;
  }
  
  public a(List<Integer> paramList1, Context paramContext, List<Integer> paramList2, List<GiftList> paramList)
  {
    this.f = paramList2;
    this.b = paramList1;
    this.d = paramContext;
    this.i = paramList;
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
      this.e.c = ((TextView)paramView.findViewById(2131697420));
      this.e.d = ((SimpleDraweeView)paramView.findViewById(2131697417));
      paramView.setTag(this.e);
      if (((Integer)this.f.get(paramInt)).intValue() != 1) {
        break label330;
      }
      this.e.e.setChecked(true);
      label146:
      if (1 != ((Integer)this.b.get(paramInt)).intValue()) {
        break label344;
      }
      paramView.setVisibility(0);
      this.e.a.setText("银联信用卡支付");
      this.e.d.setController(c.frescoFromResourceController(2130839921));
      label198:
      this.e.b.setVisibility(8);
      if (this.i == null) {
        break label645;
      }
      paramViewGroup = this.i.iterator();
    }
    for (;;)
    {
      if (!paramViewGroup.hasNext()) {
        break label645;
      }
      GiftList localGiftList = (GiftList)paramViewGroup.next();
      if (localGiftList.getPayWay().equals(((Integer)this.b.get(paramInt)).toString()))
      {
        if (localGiftList.getIsHaveGift().equals("1"))
        {
          this.e.b.setVisibility(0);
          this.e.b.setText(localGiftList.getGiftNote());
          continue;
          this.e = ((b)paramView.getTag());
          break;
          label330:
          this.e.e.setChecked(false);
          break label146;
          label344:
          if (2 == ((Integer)this.b.get(paramInt)).intValue())
          {
            paramView.setVisibility(0);
            this.e.a.setText("微信支付");
            this.e.d.setController(c.frescoFromResourceController(2130839918));
            break label198;
          }
          if (3 == ((Integer)this.b.get(paramInt)).intValue())
          {
            paramView.setVisibility(0);
            this.e.a.setText("京东支付");
            this.e.d.setController(c.frescoFromResourceController(2130838902));
            break label198;
          }
          if (6 == ((Integer)this.b.get(paramInt)).intValue())
          {
            this.e.a.setText("银联储蓄卡支付");
            this.e.d.setController(c.frescoFromResourceController(2130839921));
            break label198;
          }
          if ((7 == ((Integer)this.b.get(paramInt)).intValue()) || (8 == ((Integer)this.b.get(paramInt)).intValue()))
          {
            paramView.setVisibility(0);
            this.e.a.setText("银行卡快捷支付");
            if ((this.h == null) || (this.h.equals("")))
            {
              this.e.d.setController(c.frescoFromResourceController(2130838796));
              break label198;
            }
            this.e.d.setController(c.frescoController(this.h));
            break label198;
          }
          paramView.setVisibility(8);
          break label198;
        }
        this.e.b.setVisibility(8);
      }
    }
    label645:
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
        if (i < a.this.getCount())
        {
          if (paramInt == i)
          {
            a.a(a.this).set(i, Integer.valueOf(1));
            label44:
            if (((Integer)a.a(a.this).get(paramInt)).intValue() != 0) {
              break label111;
            }
            a.b(a.this).e.setChecked(false);
          }
          for (;;)
          {
            i += 1;
            break;
            a.a(a.this).set(i, Integer.valueOf(0));
            break label44;
            label111:
            a.b(a.this).e.setChecked(true);
            a.d(a.this).setPayType(((Integer)a.c(a.this).get(paramInt)).intValue());
          }
        }
        a.this.notifyDataSetChanged();
      }
    });
    return paramView;
  }
  
  public List<Integer> getmCheck()
  {
    return this.f;
  }
  
  public List<Integer> getmList()
  {
    return this.b;
  }
  
  public a getmPayType()
  {
    return this.g;
  }
  
  public void setmCheck(List<Integer> paramList)
  {
    this.f = paramList;
  }
  
  public void setmImgHuifuIcon(String paramString)
  {
    this.h = paramString;
  }
  
  public void setmList(List<Integer> paramList)
  {
    this.b = paramList;
  }
  
  public void setmListMsg(HashMap<Integer, String> paramHashMap)
  {
    this.c = paramHashMap;
    notifyDataSetChanged();
  }
  
  public void setmPayType(a parama)
  {
    this.g = parama;
  }
  
  public static abstract interface a
  {
    public abstract void setPayType(int paramInt);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/reserve/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */