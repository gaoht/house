package com.ziroom.ziroomcustomer.newServiceList.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.Promotions;
import java.util.List;

public class b
  extends BaseAdapter
{
  private Context a;
  private List<Promotions> b;
  
  public b(Context paramContext, List<Promotions> paramList)
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
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130903684, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689852));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131690003));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131689541));
      paramViewGroup.e = ((ImageView)paramView.findViewById(2131691574));
      paramViewGroup.f = ((RelativeLayout)paramView.findViewById(2131693262));
      paramViewGroup.g = ((RelativeLayout)paramView.findViewById(2131693263));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.e.setBackgroundResource(2130838608);
      Promotions localPromotions = (Promotions)this.b.get(paramInt);
      paramViewGroup.a.setText(localPromotions.getPromotionTypeName());
      paramViewGroup.b.setText("有效期" + localPromotions.getEndMonth() + "个月");
      if (!TextUtils.isEmpty(localPromotions.getSendPrice())) {
        paramViewGroup.c.setText(Long.parseLong(localPromotions.getSendPrice()) / 100L + "");
      }
      paramViewGroup.d.setText(localPromotions.getSendCount() + "张");
      paramViewGroup.f.getBackground().setAlpha(70);
      paramViewGroup.g.getBackground().setAlpha(150);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public void setData(List<Promotions> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public static class a
  {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public ImageView e;
    public RelativeLayout f;
    public RelativeLayout g;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */