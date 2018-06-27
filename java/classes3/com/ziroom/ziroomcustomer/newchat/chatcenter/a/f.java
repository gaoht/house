package com.ziroom.ziroomcustomer.newchat.chatcenter.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newServiceList.utils.i;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.c.a;
import java.util.List;

public class f
  extends BaseAdapter
{
  private Context a;
  private List<c.a> b;
  
  public f(Context paramContext, List<c.a> paramList)
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
      paramView = View.inflate(this.a, 2130904563, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690360));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689852));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131690084));
      paramViewGroup.d = paramView.findViewById(2131690678);
      paramView.setTag(paramViewGroup);
      if (paramInt != 0) {
        break label207;
      }
      paramViewGroup.c.setTextColor(-12303292);
      label91:
      if (paramInt != this.b.size() - 1) {
        break label219;
      }
      paramViewGroup.d.setVisibility(4);
    }
    for (;;)
    {
      c.a locala = (c.a)this.b.get(paramInt);
      if (!TextUtils.isEmpty(locala.getFollowDate()))
      {
        paramViewGroup.a.setText(locala.getFollowDate().substring(10, locala.getFollowDate().length()));
        paramViewGroup.b.setText(i.getFormatTime(locala.getFollowDate(), "yyyy-MM-dd"));
      }
      paramViewGroup.c.setText(locala.getMatter());
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label207:
      paramViewGroup.c.setTextColor(-6710887);
      break label91;
      label219:
      paramViewGroup.d.setVisibility(0);
    }
  }
  
  public class a
  {
    public TextView a;
    public TextView b;
    public TextView c;
    public View d;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */