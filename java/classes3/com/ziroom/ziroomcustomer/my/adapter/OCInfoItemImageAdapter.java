package com.ziroom.ziroomcustomer.my.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import java.util.ArrayList;
import java.util.List;

public class OCInfoItemImageAdapter
  extends BaseAdapter
{
  private List<String> a = new ArrayList();
  private Context b;
  
  public OCInfoItemImageAdapter(Context paramContext, List<String> paramList)
  {
    this.b = paramContext;
    this.a = paramList;
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      ViewHolder localViewHolder = (ViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localViewHolder;
    }
    for (;;)
    {
      paramView.ivPdRevisionZspace.setController(c.frescoController((String)this.a.get(paramInt)));
      paramView.tvSeeMoreZSpace.setVisibility(8);
      return paramViewGroup;
      paramViewGroup = View.inflate(this.b, 2130904407, null);
      paramView = new ViewHolder(paramViewGroup);
      paramViewGroup.setTag(paramView);
    }
  }
  
  static class ViewHolder
  {
    @BindView(2131695460)
    SimpleDraweeView ivPdRevisionZspace;
    @BindView(2131695461)
    TextView tvSeeMoreZSpace;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/OCInfoItemImageAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */