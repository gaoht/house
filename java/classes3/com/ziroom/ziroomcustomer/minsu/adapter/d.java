package com.ziroom.ziroomcustomer.minsu.adapter;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.util.n;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class d
  extends BaseAdapter
  implements Serializable
{
  private int a = -1;
  private List<Map> b;
  private a c;
  
  public d(List<Map> paramList, a parama)
  {
    this.b = paramList;
    this.c = parama;
  }
  
  public void clearData()
  {
    this.b.clear();
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public Map getItem(int paramInt)
  {
    if (this.b.size() > 0) {
      return (Map)this.b.get(paramInt);
    }
    return new HashMap();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getSelectedPosition()
  {
    return this.a;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramView == null)
    {
      paramViewGroup = new b();
      paramView = LayoutInflater.from(ApplicationEx.c).inflate(2130903678, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131693236));
      paramViewGroup.b = ((RelativeLayout)paramView.findViewById(2131693238));
      paramView.setTag(paramViewGroup);
      str = (String)((Map)this.b.get(paramInt)).get("name");
      if (this.c != a.b) {
        break label180;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(-2, n.dip2px(ApplicationEx.c, 45.0F));
      localLayoutParams.addRule(13);
      localLayoutParams.leftMargin = 0;
      paramViewGroup.a.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      paramViewGroup.a.setText(str);
      if (this.a != paramInt) {
        break label231;
      }
      paramViewGroup.a.setTextColor(ApplicationEx.c.getResources().getColor(2131624475));
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label180:
      localLayoutParams = new RelativeLayout.LayoutParams(-2, n.dip2px(ApplicationEx.c, 45.0F));
      localLayoutParams.addRule(15);
      localLayoutParams.leftMargin = n.dip2px(ApplicationEx.c, 45.0F);
      paramViewGroup.a.setLayoutParams(localLayoutParams);
    }
    label231:
    paramViewGroup.a.setTextColor(ApplicationEx.c.getResources().getColor(2131624039));
    return paramView;
  }
  
  public void setData(List<Map> paramList)
  {
    clearData();
    paramList.addAll(paramList);
  }
  
  public void setSelectedPosition(int paramInt)
  {
    this.a = paramInt;
    notifyDataSetChanged();
  }
  
  public static enum a
  {
    private a() {}
  }
  
  static class b
  {
    TextView a;
    RelativeLayout b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */