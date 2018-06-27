package com.ziroom.ziroomcustomer.newchat.chatcenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.model.UserInfo;
import java.util.List;

public class a
  extends BaseAdapter
{
  private Context a;
  private List<String> b;
  private UserInfo c;
  
  public a(Context paramContext, List<String> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = ApplicationEx.c.getUser();
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
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.a, 2130904146, null);
      paramView = new a();
      paramView.a = ((TextView)localView.findViewById(2131690181));
      paramView.b = ((RelativeLayout)localView.findViewById(2131694888));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a.setText(((String)this.b.get(paramInt)).trim());
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  public class a
  {
    public TextView a;
    public RelativeLayout b;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */