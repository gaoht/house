package com.ziroom.ziroomcustomer.newchat.chatcenter;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.model.UserInfo;
import java.util.List;

public class c
  extends BaseAdapter
{
  private Context a;
  private List<h.a> b;
  private UserInfo c;
  
  public c(Context paramContext, List<h.a> paramList)
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
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904146, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690181));
      paramViewGroup.b = ((RelativeLayout)paramView.findViewById(2131694888));
      paramView.setTag(paramViewGroup);
    }
    Object localObject;
    for (;;)
    {
      localObject = (h.a)this.b.get(paramInt);
      if (TextUtils.isEmpty(((h.a)localObject).getQuestion())) {
        break;
      }
      localObject = ((h.a)localObject).getQuestion().replace("@preTag@", "<font color='#FFa000'>").replace("@postTag@", "</font>");
      paramViewGroup.a.setText(Html.fromHtml((String)localObject));
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.a.setText(((h.a)localObject).getQuestion());
    return paramView;
  }
  
  public class a
  {
    public TextView a;
    public RelativeLayout b;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */