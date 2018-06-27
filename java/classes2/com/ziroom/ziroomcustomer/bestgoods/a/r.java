package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.bestgoods.model.ag.a;
import java.util.List;

public class r
  extends BaseAdapter
{
  private Context a;
  private List<ag.a> b;
  
  public r(Context paramContext, List<ag.a> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    label115:
    String str1;
    String str2;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = LayoutInflater.from(this.a).inflate(2130904576, null);
      paramViewGroup.a = ((ImageView)paramView.findViewById(2131694874));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695039));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131694876));
      paramViewGroup.d = paramView.findViewById(2131690678);
      paramView.setTag(paramViewGroup);
      if (this.b.size() > 0)
      {
        if (this.b.size() != 1) {
          break label225;
        }
        paramViewGroup.d.setVisibility(8);
      }
      str1 = ((ag.a)this.b.get(paramInt)).getRemark();
      str2 = ((ag.a)this.b.get(paramInt)).getCreateTime();
      this.b.size();
      if (paramInt != 0) {
        break label263;
      }
      paramViewGroup.a.setBackgroundResource(2130840250);
      paramViewGroup.b.setTextColor(Color.parseColor("#FFA000"));
    }
    for (;;)
    {
      paramViewGroup.b.setText(str1);
      if (!TextUtils.isEmpty(str2)) {
        break label287;
      }
      paramViewGroup.c.setVisibility(8);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label225:
      if (paramInt == this.b.size() - 1)
      {
        paramViewGroup.d.setVisibility(8);
        break label115;
      }
      paramViewGroup.d.setVisibility(0);
      break label115;
      label263:
      paramViewGroup.a.setBackgroundResource(2130840254);
      paramViewGroup.b.setTextColor(Color.parseColor("#666666"));
    }
    label287:
    paramViewGroup.c.setVisibility(0);
    paramViewGroup.c.setText(str2);
    return paramView;
  }
  
  public class a
  {
    public ImageView a;
    public TextView b;
    public TextView c;
    public View d;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */