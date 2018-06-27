package com.ziroom.ziroomcustomer.newchat.chatcenter.a;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newchat.chatcenter.i;
import java.util.List;

public class d
  extends BaseAdapter
{
  private Context a;
  private List<i> b;
  private UserInfo c;
  
  public d(Context paramContext, List<i> paramList)
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
    i locali;
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904147, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690181));
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131694889));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131693178));
      paramView.setTag(paramViewGroup);
      locali = (i)this.b.get(paramInt);
      if (TextUtils.isEmpty(locali.getHighlightName())) {
        break label172;
      }
      String str = locali.getHighlightName().replace("@preTag@", "<font color='#FFa000'>").replace("@postTag@", "</font>");
      paramViewGroup.a.setText(Html.fromHtml(str));
      label127:
      if (!locali.isImageKnowledge()) {
        break label187;
      }
      paramViewGroup.b.setVisibility(0);
    }
    for (;;)
    {
      if (!locali.isVideoKnowledge()) {
        break label199;
      }
      paramViewGroup.c.setVisibility(0);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label172:
      paramViewGroup.a.setText(locali.getName());
      break label127;
      label187:
      paramViewGroup.b.setVisibility(8);
    }
    label199:
    paramViewGroup.c.setVisibility(8);
    return paramView;
  }
  
  public class a
  {
    public TextView a;
    public ImageView b;
    public ImageView c;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */