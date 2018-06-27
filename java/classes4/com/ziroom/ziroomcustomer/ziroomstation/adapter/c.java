package com.ziroom.ziroomcustomer.ziroomstation.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.ziroomstation.model.ImageItem;
import com.ziroom.ziroomcustomer.ziroomstation.utils.f;
import java.util.List;

public class c
  extends BaseAdapter
{
  private Context a;
  private List<ImageItem> b;
  
  public c(Context paramContext, List<ImageItem> paramList)
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
      paramView = View.inflate(this.a, 2130904245, null);
      paramViewGroup = new a();
      a.a(paramViewGroup, (ImageView)paramView.findViewById(2131689700));
      a.b(paramViewGroup, (ImageView)paramView.findViewById(2131695095));
      a.a(paramViewGroup, (TextView)paramView.findViewById(2131695094));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      ImageItem localImageItem = (ImageItem)this.b.get(paramInt);
      f.getInstance(this.a).displayBmp(a.a(paramViewGroup), localImageItem.thumbnailPath, localImageItem.sourcePath);
      if (!localImageItem.isSelected) {
        break;
      }
      a.b(paramViewGroup).setImageDrawable(this.a.getResources().getDrawable(2130839800));
      a.b(paramViewGroup).setVisibility(0);
      a.c(paramViewGroup).setBackgroundResource(2130838866);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    a.b(paramViewGroup).setImageDrawable(null);
    a.b(paramViewGroup).setVisibility(8);
    a.c(paramViewGroup).setBackgroundResource(2131624451);
    return paramView;
  }
  
  static class a
  {
    private ImageView a;
    private ImageView b;
    private TextView c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/adapter/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */