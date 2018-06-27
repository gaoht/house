package com.ziroom.ziroomcustomer.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.widget.BadgeView;
import java.util.List;
import java.util.Map;

public class e
  extends BaseAdapter
{
  private Context a;
  private List<String> b;
  private BadgeView c;
  
  public e(Context paramContext, List<String> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
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
    paramView = LayoutInflater.from(this.a).inflate(2130904831, null);
    paramViewGroup = (TextView)paramView.findViewById(2131696607);
    paramViewGroup.setText((CharSequence)this.b.get(paramInt));
    if ("申请合同转签".equals(this.b.get(paramInt)))
    {
      ImageView localImageView = (ImageView)paramView.findViewById(2131696608);
      this.c = new BadgeView(this.a, paramViewGroup, n.dip2px(this.a, 3.0F), 1);
      this.c.setBadgeMargin(0, 0);
      this.c.setBadgeBackgroundColor(Color.parseColor("#FF2914"));
      ApplicationEx.setBadgeView(this.c, "MZCLI_badge");
      if (!ApplicationEx.f) {
        break label180;
      }
      if (ApplicationEx.j.get("MAC_badge") != null)
      {
        if (!((BadgeView)ApplicationEx.j.get("MAC_badge")).isShown()) {
          break label172;
        }
        ApplicationEx.setPackState(1, "MZCLI_badge");
      }
    }
    return paramView;
    label172:
    ApplicationEx.setPackState(0, "MZCLI_badge");
    return paramView;
    label180:
    ApplicationEx.setPackState(0, "MZCLI_badge");
    return paramView;
  }
  
  public List<String> getmList()
  {
    return this.b;
  }
  
  public void setmList(List<String> paramList)
  {
    this.b = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */