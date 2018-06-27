package com.ziroom.ziroomcustomer.findhouse.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.findhouse.model.MapPlanNode;
import com.ziroom.ziroomcustomer.findhouse.model.MapPlanNode.MapRoute;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.List;

public class d
  extends BaseAdapter
{
  private List<MapPlanNode.MapRoute> a;
  private Context b;
  
  public d(Context paramContext, List<MapPlanNode.MapRoute> paramList)
  {
    this.b = paramContext;
    this.a = paramList;
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = new TextView(this.b);
    paramViewGroup = new AbsListView.LayoutParams(-1, ah.dip2px(this.b, 54.0F));
    paramView.setTextSize(2, 14.0F);
    paramView.setTextColor(this.b.getResources().getColor(2131624416));
    paramView.setLayoutParams(paramViewGroup);
    paramViewGroup = (MapPlanNode.MapRoute)this.a.get(paramInt);
    SpannableString localSpannableString = new SpannableString(paramViewGroup.getStartNode().getName() + " - " + paramViewGroup.getEndNode().getName());
    localSpannableString.setSpan(new ForegroundColorSpan(this.b.getResources().getColor(2131624417)), 0, paramViewGroup.getStartNode().getName().length(), 18);
    paramView.setGravity(16);
    paramView.setTag(paramViewGroup);
    paramView.setText(localSpannableString);
    return paramView;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */