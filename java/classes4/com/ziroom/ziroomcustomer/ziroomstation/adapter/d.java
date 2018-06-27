package com.ziroom.ziroomcustomer.ziroomstation.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.ziroomstation.model.ImageItem;
import com.ziroom.ziroomcustomer.ziroomstation.utils.f;
import java.util.ArrayList;
import java.util.List;

public class d
  extends BaseAdapter
{
  private List<ImageItem> a = new ArrayList();
  private Context b;
  private int c;
  private int d;
  
  public d(Context paramContext, List<ImageItem> paramList)
  {
    this.b = paramContext;
    this.a = paramList;
    this.d = ((((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth() - n.dip2px(paramContext, 36.0F)) / 4);
    this.c = (this.d / 3 * 2);
  }
  
  private boolean a(int paramInt)
  {
    boolean bool = false;
    if (this.a == null) {}
    for (int i = 0;; i = this.a.size())
    {
      if (paramInt == i) {
        bool = true;
      }
      return bool;
    }
  }
  
  public int getCount()
  {
    int i = 8;
    if (this.a == null) {
      i = 1;
    }
    while (this.a.size() == 8) {
      return i;
    }
    return this.a.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.a != null) && (this.a.size() == 8)) {
      return this.a.get(paramInt);
    }
    if ((this.a == null) || (paramInt - 1 < 0) || (paramInt > this.a.size())) {
      return null;
    }
    return this.a.get(paramInt - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @SuppressLint({"ViewHolder"})
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = View.inflate(this.b, 2130904447, null);
    paramViewGroup = (ImageView)paramView.findViewById(2131695556);
    Object localObject = (RelativeLayout)paramView.findViewById(2131695557);
    paramViewGroup.getLayoutParams().height = this.c;
    ((RelativeLayout)localObject).getLayoutParams().height = this.c;
    if (a(paramInt))
    {
      paramViewGroup.setVisibility(8);
      ((RelativeLayout)localObject).setVisibility(0);
      return paramView;
    }
    paramViewGroup.setVisibility(0);
    ((RelativeLayout)localObject).setVisibility(8);
    localObject = (ImageItem)this.a.get(paramInt);
    f.getInstance(this.b).displayBmp(paramViewGroup, ((ImageItem)localObject).thumbnailPath, ((ImageItem)localObject).sourcePath);
    return paramView;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/adapter/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */