package com.ziroom.ziroomcustomer.newclean.cardpay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CardStylesBean;
import com.ziroom.ziroomcustomer.util.ac;
import java.util.List;

public class CleanGralleyCardAdapter
  extends BaseAdapter
{
  private Context a;
  private List<CardStylesBean> b;
  private float c;
  private float d;
  
  public CleanGralleyCardAdapter(Context paramContext, List<CardStylesBean> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = (ac.getScreenWidth(paramContext) - ab.dp2px(this.a, 40.0F));
    this.d = (this.c * 210.0F * 1.0F / 335.0F);
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
      paramView = LayoutInflater.from(this.a).inflate(2130904163, null);
      paramViewGroup = new ViewHolder(paramView);
      c.frescoHierarchyController(paramViewGroup.sdvCard, 2130838349);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      CardStylesBean localCardStylesBean = (CardStylesBean)this.b.get(paramInt);
      paramViewGroup.sdvCard.setController(c.frescoController(localCardStylesBean.getCardStyleUrl()));
      paramViewGroup.tvContent.setText(localCardStylesBean.getCardStyleNote());
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
    }
  }
  
  static class ViewHolder
  {
    @BindView(2131691257)
    TextView btnSend;
    @BindView(2131692486)
    LinearLayout llSend;
    @BindView(2131694925)
    SimpleDraweeView sdvCard;
    @BindView(2131692685)
    SimpleDraweeView sdvHeadPic;
    @BindView(2131690084)
    TextView tvContent;
    @BindView(2131694927)
    TextView tvGet;
    @BindView(2131689846)
    TextView tvMoney;
    @BindView(2131690147)
    View view;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/adapter/CleanGralleyCardAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */