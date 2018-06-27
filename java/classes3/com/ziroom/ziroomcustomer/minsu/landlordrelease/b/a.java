package com.ziroom.ziroomcustomer.minsu.landlordrelease.b;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.AloneRoomBedTypeListDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomBedTypeMsgListBean;
import com.ziroom.ziroomcustomer.util.af;
import java.util.List;

public class a
  extends BaseAdapter
{
  private Context a;
  private List<AloneRoomBedTypeListDataBean> b;
  private List<AloneRoomBedTypeMsgListBean> c;
  private int d;
  private b e;
  
  public a(Context paramContext, List<AloneRoomBedTypeListDataBean> paramList, List<AloneRoomBedTypeMsgListBean> paramList1, int paramInt, b paramb)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramList1;
    this.d = paramInt;
    this.e = paramb;
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
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j;
    int i;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = LayoutInflater.from(this.a).inflate(2130904338, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131690071));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695329));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131689995));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131690041));
      paramView.setTag(paramViewGroup);
      String str1 = ((AloneRoomBedTypeListDataBean)this.b.get(paramInt)).getText();
      ((AloneRoomBedTypeListDataBean)this.b.get(paramInt)).getValue();
      String str2 = ((AloneRoomBedTypeListDataBean)this.b.get(paramInt)).getExplain();
      ((AloneRoomBedTypeListDataBean)this.b.get(paramInt)).isSelect();
      ((AloneRoomBedTypeMsgListBean)this.c.get(paramInt)).getBedType();
      j = ((AloneRoomBedTypeMsgListBean)this.c.get(paramInt)).getNum();
      i = ((AloneRoomBedTypeMsgListBean)this.c.get(paramInt)).getMaxNum();
      paramViewGroup.a.setText(str1);
      paramViewGroup.d.setText(j + "");
      if (!TextUtils.isEmpty(str2)) {
        break label420;
      }
      paramViewGroup.b.setVisibility(8);
      label273:
      if ((j <= 0) || (j >= i)) {
        break label454;
      }
      paramViewGroup.d.setTextColor(Color.parseColor("#444444"));
      paramViewGroup.c.setClickable(true);
      paramViewGroup.e.setClickable(true);
      paramViewGroup.c.setBackgroundResource(2130838655);
      paramViewGroup.e.setBackgroundResource(2130838652);
    }
    for (;;)
    {
      paramViewGroup.c.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = ((AloneRoomBedTypeMsgListBean)a.a(a.this).get(paramInt)).getNum();
          ((AloneRoomBedTypeMsgListBean)a.a(a.this).get(paramInt)).setNum(i - 1);
          a.b(a.this).setRoomBedChosen(a.a(a.this));
          a.this.notifyDataSetChanged();
        }
      });
      paramViewGroup.e.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = ((AloneRoomBedTypeMsgListBean)a.a(a.this).get(paramInt)).getNum();
          ((AloneRoomBedTypeMsgListBean)a.a(a.this).get(paramInt)).setNum(i + 1);
          a.b(a.this).setRoomBedChosen(a.a(a.this));
          a.this.notifyDataSetChanged();
        }
      });
      paramInt = 0;
      i = 0;
      while (paramInt < this.c.size())
      {
        i += ((AloneRoomBedTypeMsgListBean)this.c.get(paramInt)).getNum();
        paramInt += 1;
      }
      paramViewGroup = (a)paramView.getTag();
      break;
      label420:
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setText(((AloneRoomBedTypeListDataBean)this.b.get(paramInt)).getExplain());
      break label273;
      label454:
      if (j == 0)
      {
        paramViewGroup.d.setTextColor(Color.parseColor("#999999"));
        paramViewGroup.c.setClickable(false);
        paramViewGroup.e.setClickable(true);
        paramViewGroup.c.setBackgroundResource(2130838654);
        paramViewGroup.e.setBackgroundResource(2130838652);
      }
      else if (j == i)
      {
        af.showToast(this.a, "床总数不能超过" + this.d);
        paramViewGroup.d.setTextColor(Color.parseColor("#444444"));
        paramViewGroup.c.setClickable(true);
        paramViewGroup.e.setClickable(false);
        paramViewGroup.c.setBackgroundResource(2130838655);
        paramViewGroup.e.setBackgroundResource(2130838653);
      }
    }
    if (i >= this.d)
    {
      if (j <= 0) {
        paramViewGroup.c.setClickable(false);
      }
      for (;;)
      {
        paramViewGroup.e.setClickable(false);
        paramViewGroup.e.setBackgroundResource(2130838653);
        return paramView;
        paramViewGroup.c.setClickable(true);
      }
    }
    if (j <= 0) {
      paramViewGroup.c.setClickable(false);
    }
    for (;;)
    {
      paramViewGroup.e.setClickable(true);
      paramViewGroup.e.setBackgroundResource(2130838652);
      return paramView;
      paramViewGroup.c.setClickable(true);
    }
  }
  
  public void setmRoomBedChosenListener(b paramb)
  {
    this.e = paramb;
  }
  
  public class a
  {
    TextView a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void setRoomBedChosen(List<AloneRoomBedTypeMsgListBean> paramList);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */