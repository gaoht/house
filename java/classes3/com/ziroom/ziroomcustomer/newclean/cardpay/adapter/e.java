package com.ziroom.ziroomcustomer.newclean.cardpay.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanCard;
import java.util.List;

public class e
  extends BaseAdapter
{
  private Context a;
  private List<CleanCard> b;
  
  public e(Context paramContext, List<CleanCard> paramList)
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
    CleanCard localCleanCard;
    Object localObject;
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904398, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690311));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131694895));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131690353));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131690316));
      paramViewGroup.f = paramView.findViewById(2131694897);
      paramViewGroup.g = ((CardView)paramView.findViewById(2131695441));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131694894));
      paramViewGroup.h = ((SimpleDraweeView)paramView.findViewById(2131695443));
      paramViewGroup.i = paramView.findViewById(2131694926);
      paramViewGroup.j = paramView.findViewById(2131695442);
      paramView.setTag(paramViewGroup);
      localCleanCard = (CleanCard)this.b.get(paramInt);
      localObject = paramViewGroup.h;
      if (!TextUtils.isEmpty(localCleanCard.getCardStyleUrl())) {
        break label465;
      }
      paramInt = 8;
      label185:
      ((SimpleDraweeView)localObject).setVisibility(paramInt);
      localObject = paramViewGroup.i;
      if (!TextUtils.isEmpty(localCleanCard.getCardStyleUrl())) {
        break label470;
      }
      paramInt = 8;
      label211:
      ((View)localObject).setVisibility(paramInt);
      paramViewGroup.h.setController(c.frescoController(localCleanCard.getCardStyleUrl()));
      localObject = paramViewGroup.b;
      if (!TextUtils.isEmpty(localCleanCard.getCardStyleUrl())) {
        break label475;
      }
      paramInt = 0;
      label251:
      ((TextView)localObject).setVisibility(paramInt);
      localObject = paramViewGroup.f;
      if (!TextUtils.isEmpty(localCleanCard.getCardStyleUrl())) {
        break label481;
      }
    }
    label465:
    label470:
    label475:
    label481:
    for (paramInt = this.a.getResources().getColor(2131624247);; paramInt = this.a.getResources().getColor(2131624583))
    {
      ((View)localObject).setBackgroundColor(paramInt);
      paramViewGroup.a.setText(localCleanCard.getCardName());
      if (!TextUtils.isEmpty(localCleanCard.getRemainAmount())) {
        paramViewGroup.c.setText(Long.parseLong(localCleanCard.getRemainAmount()) / 100L + "");
      }
      if (!TextUtils.isEmpty(localCleanCard.getTotalAmount())) {
        paramViewGroup.d.setText("总额" + Long.parseLong(localCleanCard.getTotalAmount()) / 100L + "元");
      }
      if (localCleanCard.getCardState() != 2) {
        break label497;
      }
      if (TextUtils.isEmpty(localCleanCard.getCardStyleUrl()))
      {
        paramViewGroup.f.setBackgroundColor(-806849);
        paramViewGroup.j.setBackgroundResource(2130838207);
      }
      paramViewGroup.e.setVisibility(0);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      paramInt = 0;
      break label185;
      paramInt = 0;
      break label211;
      paramInt = 8;
      break label251;
    }
    label497:
    paramViewGroup.e.setVisibility(8);
    if (TextUtils.isEmpty(localCleanCard.getCardStyleUrl()))
    {
      paramViewGroup.f.setBackgroundColor(-1118482);
      paramViewGroup.j.setBackgroundResource(2130838194);
    }
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
    public CardView g;
    public SimpleDraweeView h;
    public View i;
    public View j;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/adapter/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */