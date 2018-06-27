package com.ziroom.ziroomcustomer.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.model.RentCardDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class k
  extends BaseAdapter
{
  private Context a;
  private List<RentCardDetail> b = new ArrayList();
  
  public k(Context paramContext, List<RentCardDetail> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public void addMoreRentCard(List<RentCardDetail> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RentCardDetail localRentCardDetail = (RentCardDetail)paramList.next();
      this.b.add(localRentCardDetail);
    }
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
    String str;
    ImageView localImageView;
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904456, null);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((ImageView)paramView.findViewById(2131695568));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689763));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695571));
      a.a(paramViewGroup, (ImageView)paramView.findViewById(2131695569));
      paramView.setTag(paramViewGroup);
      str = ((RentCardDetail)this.b.get(paramInt)).getCardValue() + "";
      a.a(paramViewGroup).setVisibility(0);
      localImageView = paramViewGroup.a;
      if (!str.equals("50")) {
        break label217;
      }
    }
    label217:
    for (int i = 2130838338;; i = 2130838337)
    {
      localImageView.setBackgroundResource(i);
      paramViewGroup.b.setText(str + "元租金卡");
      paramViewGroup.c.setText(((RentCardDetail)this.b.get(paramInt)).getExpireDate());
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
    }
  }
  
  public void removeAllList()
  {
    this.b.clear();
  }
  
  private class a
  {
    public ImageView a;
    public TextView b;
    public TextView c;
    private ImageView e;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */