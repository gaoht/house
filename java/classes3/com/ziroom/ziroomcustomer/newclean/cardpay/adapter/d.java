package com.ziroom.ziroomcustomer.newclean.cardpay.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanCard;
import java.util.List;

public class d
  extends BaseAdapter
{
  private Context a;
  private List<CleanCard> b;
  
  public d(Context paramContext, List<CleanCard> paramList)
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
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904150, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690311));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131694895));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131690353));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131690316));
      paramViewGroup.f = paramView.findViewById(2131694897);
      paramViewGroup.g = ((LinearLayout)paramView.findViewById(2131694893));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131694894));
      paramView.setTag(paramViewGroup);
    }
    CleanCard localCleanCard;
    for (;;)
    {
      localCleanCard = (CleanCard)this.b.get(paramInt);
      paramViewGroup.a.setText(localCleanCard.getCardName());
      if (!TextUtils.isEmpty(localCleanCard.getRemainAmount())) {
        paramViewGroup.c.setText(Long.parseLong(localCleanCard.getRemainAmount()) / 100L + "");
      }
      if (!TextUtils.isEmpty(localCleanCard.getTotalAmount())) {
        paramViewGroup.d.setText("总额" + Long.parseLong(localCleanCard.getTotalAmount()) / 100L + "元");
      }
      if (localCleanCard.getCardState() != 2) {
        break;
      }
      paramViewGroup.f.setBackgroundColor(-806849);
      paramViewGroup.g.setBackgroundResource(2130838207);
      paramViewGroup.e.setVisibility(0);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.e.setVisibility(8);
    paramViewGroup.f.setBackgroundColor(-1118482);
    paramViewGroup.g.setBackgroundResource(2130838194);
    switch (localCleanCard.getCardState())
    {
    default: 
      return paramView;
    case 1: 
      paramViewGroup.b.setText("未激活");
      return paramView;
    case 2: 
      paramViewGroup.b.setText("可用");
      return paramView;
    case 3: 
      paramViewGroup.b.setText("已禁用");
      return paramView;
    case 4: 
      paramViewGroup.b.setText("已过期");
      return paramView;
    }
    paramViewGroup.b.setText("已废弃");
    return paramView;
  }
  
  public void setList(List<CleanCard> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public class a
  {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public View f;
    public LinearLayout g;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/adapter/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */