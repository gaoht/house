package com.ziroom.ziroomcustomer.minsu.chat.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;

public class c
  extends ArrayAdapter<String>
{
  private Context a;
  
  public c(Context paramContext, int paramInt, List<String> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.a = paramContext;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = View.inflate(getContext(), 2130903672, null);
    }
    paramView = (SimpleDraweeView)paramViewGroup.findViewById(2131693233);
    String str = (String)getItem(paramInt);
    paramInt = getContext().getResources().getIdentifier(str, "drawable", getContext().getPackageName());
    if (paramView != null) {
      paramView.setController(com.freelxl.baselibrary.f.c.frescoFromResourceController(paramInt));
    }
    return paramViewGroup;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */