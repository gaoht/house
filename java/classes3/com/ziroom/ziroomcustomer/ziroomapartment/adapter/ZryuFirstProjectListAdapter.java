package com.ziroom.ziroomcustomer.ziroomapartment.adapter;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.ziroomapartment.a;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuFirstProjectListModel.DataBean;
import java.util.List;

public class ZryuFirstProjectListAdapter
  extends BaseAdapter
{
  Context a;
  List<ZryuFirstProjectListModel.DataBean> b;
  int c;
  private String d = "ZryuFirstProjectListAdapter";
  
  public ZryuFirstProjectListAdapter(Context paramContext, List<ZryuFirstProjectListModel.DataBean> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = (((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth() / 2 * 1);
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
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a).inflate(2130904623, paramViewGroup, false);
      paramView = new ViewHolder(localView);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.projectPrice.setText(((ZryuFirstProjectListModel.DataBean)this.b.get(paramInt)).projMinPrice + "");
      paramViewGroup.projectName.setText(((ZryuFirstProjectListModel.DataBean)this.b.get(paramInt)).projName);
      paramViewGroup.projectAddress.setText(((ZryuFirstProjectListModel.DataBean)this.b.get(paramInt)).projAddr);
      paramViewGroup.flProjectPic.getLayoutParams().height = this.c;
      d.i(this.d, "图片链接：" + ((ZryuFirstProjectListModel.DataBean)this.b.get(paramInt)).projImgUrl);
      paramViewGroup.ivProjectPic.setController(c.frescoController(((ZryuFirstProjectListModel.DataBean)this.b.get(paramInt)).projImgUrl));
      localView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          a.ToProjectInfo(ZryuFirstProjectListAdapter.this.a, ((ZryuFirstProjectListModel.DataBean)ZryuFirstProjectListAdapter.this.b.get(paramInt)).projId);
        }
      });
      return localView;
      paramViewGroup = (ViewHolder)paramView.getTag();
      localView = paramView;
    }
  }
  
  public void setData(List<ZryuFirstProjectListModel.DataBean> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  static class ViewHolder
  {
    @BindView(2131695894)
    FrameLayout flProjectPic;
    @BindView(2131695895)
    SimpleDraweeView ivProjectPic;
    @BindView(2131695009)
    TextView projectAddress;
    @BindView(2131695008)
    TextView projectName;
    @BindView(2131695896)
    TextView projectPrice;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/adapter/ZryuFirstProjectListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */