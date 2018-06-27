package com.ziroom.ziroomcustomer.newServiceList.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanCard;
import java.util.List;

public class f
  extends BaseAdapter
{
  private Context a;
  private List<CleanCard> b;
  
  public f(Context paramContext, List<CleanCard> paramList)
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
      paramView = View.inflate(this.a, 2130904471, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690311));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131694895));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131690353));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131690316));
      paramViewGroup.g = paramView.findViewById(2131694897);
      paramViewGroup.h = ((LinearLayout)paramView.findViewById(2131694893));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131694894));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131692131));
      paramView.setTag(paramViewGroup);
    }
    CleanCard localCleanCard;
    for (;;)
    {
      localCleanCard = (CleanCard)this.b.get(paramInt);
      paramViewGroup.a.setText(localCleanCard.getCardName());
      paramViewGroup.e.setText("此卡可消费自如全类付费维修服务");
      if (!TextUtils.isEmpty(localCleanCard.getEndTime())) {
        paramViewGroup.b.setText("有效期至" + localCleanCard.getEndTime().replaceAll("-", "/"));
      }
      if (!TextUtils.isEmpty(localCleanCard.getRemainAmount())) {
        paramViewGroup.c.setText(Long.parseLong(localCleanCard.getRemainAmount()) / 100L + "");
      }
      if (!TextUtils.isEmpty(localCleanCard.getTotalAmount())) {
        paramViewGroup.d.setText("总额" + Long.parseLong(localCleanCard.getTotalAmount()) / 100L + "元");
      }
      if (localCleanCard.getCardState() != 2) {
        break;
      }
      paramViewGroup.g.setBackgroundColor(-806849);
      paramViewGroup.h.setBackgroundResource(2130838193);
      paramViewGroup.f.setVisibility(0);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.f.setVisibility(8);
    paramViewGroup.g.setBackgroundColor(-1118482);
    paramViewGroup.h.setBackgroundResource(2130838194);
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
    public TextView f;
    public View g;
    public LinearLayout h;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */