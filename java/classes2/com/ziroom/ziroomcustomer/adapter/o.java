package com.ziroom.ziroomcustomer.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuTopHouseListBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.view.stickylistheaders.f;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.widget.ZiroomFlowLayout;
import java.util.List;

public class o
  extends BaseAdapter
  implements f
{
  private final Context a;
  private LayoutInflater b;
  private List<MinsuTopHouseListBean.DataBean.ListBean> c;
  private final int d = 10;
  
  public o(Context paramContext, List<MinsuTopHouseListBean.DataBean.ListBean> paramList)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
    this.c = paramList;
  }
  
  private void a(ZiroomFlowLayout paramZiroomFlowLayout, List<String> paramList)
  {
    if (paramZiroomFlowLayout.getChildCount() > 0) {
      paramZiroomFlowLayout.removeAllViews();
    }
    if (com.ziroom.ziroomcustomer.minsu.f.c.isNullList(paramList)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject = (String)paramList.get(i);
        TextView localTextView = new TextView(this.a);
        localTextView.setText((CharSequence)localObject);
        localTextView.setTextColor(this.a.getResources().getColor(2131624039));
        localTextView.setTextSize(12.0F);
        localTextView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837930));
        localTextView.setPadding(dp2px(10), dp2px(6), dp2px(10), dp2px(6));
        localObject = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, dp2px(16), dp2px(14));
        ((LinearLayout.LayoutParams)localObject).gravity = 17;
        localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramZiroomFlowLayout.addView(localTextView);
        i += 1;
      }
    }
  }
  
  public int dp2px(int paramInt)
  {
    return ab.dp2px(ApplicationEx.c, paramInt);
  }
  
  public int getCount()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.size();
  }
  
  public String getHeaderFromPosition(int paramInt)
  {
    long l = getHeaderIdFromPosition(paramInt);
    return l * 10L + 1L + "-" + (l + 1L) * 10L;
  }
  
  public long getHeaderId(int paramInt)
  {
    return getHeaderIdFromPosition(paramInt);
  }
  
  public long getHeaderIdFromPosition(int paramInt)
  {
    return paramInt / 10;
  }
  
  public View getHeaderView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new a();
      localView = this.b.inflate(2130904016, paramViewGroup, false);
      paramView.a = ((TextView)localView.findViewById(2131689541));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a.setText(getHeaderFromPosition(paramInt));
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      localObject = new b();
      paramView = this.b.inflate(2130904359, paramViewGroup, false);
      ((b)localObject).a = ((TextView)paramView.findViewById(2131690049));
      ((b)localObject).c = ((ZiroomFlowLayout)paramView.findViewById(2131691369));
      ((b)localObject).b = ((SimpleDraweeView)paramView.findViewById(2131695249));
      int i = n.dip2px(this.a, 18.0F);
      paramView.setPadding(i, 0, i, 0);
      paramView.setTag(localObject);
    }
    for (paramViewGroup = (ViewGroup)localObject;; paramViewGroup = (b)paramView.getTag())
    {
      localObject = (MinsuTopHouseListBean.DataBean.ListBean)this.c.get(paramInt);
      if (localObject != null)
      {
        paramViewGroup.a.setText(((MinsuTopHouseListBean.DataBean.ListBean)localObject).houseName);
        paramViewGroup.b.setController(com.freelxl.baselibrary.f.c.frescoController(((MinsuTopHouseListBean.DataBean.ListBean)localObject).picUrl));
        a(paramViewGroup.c, ((MinsuTopHouseListBean.DataBean.ListBean)localObject).indivLabelTipsList);
      }
      return paramView;
    }
  }
  
  class a
  {
    TextView a;
    
    a() {}
  }
  
  class b
  {
    TextView a;
    SimpleDraweeView b;
    ZiroomFlowLayout c;
    
    b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */