package com.ziroom.ziroomcustomer.my.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.my.OwnerPhotoPreviewActivity;
import com.ziroom.ziroomcustomer.my.model.OwnerConfirmDeliveryBean.DataBean;
import com.ziroom.ziroomcustomer.my.model.OwnerConfirmDeliveryBean.DeliveryInfoBean;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.widget.MyGridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OCDeliveryItemAdapter
  extends BaseAdapter
{
  private List<OwnerConfirmDeliveryBean.DeliveryInfoBean> a;
  private Context b;
  
  public OCDeliveryItemAdapter(Context paramContext, List<OwnerConfirmDeliveryBean.DeliveryInfoBean> paramList)
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
    final Object localObject1;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(2130904408, paramViewGroup, false);
      paramViewGroup = new ViewHolder(paramView);
      paramView.setTag(paramViewGroup);
      localObject1 = (OwnerConfirmDeliveryBean.DeliveryInfoBean)this.a.get(paramInt);
      if (localObject1 == null) {
        break label540;
      }
      if ((ae.isNull(((OwnerConfirmDeliveryBean.DeliveryInfoBean)localObject1).deliveryName)) || (ae.isNull(((OwnerConfirmDeliveryBean.DeliveryInfoBean)localObject1).subName))) {
        break label287;
      }
      paramViewGroup.tvChildInfoTitle.setVisibility(0);
      paramViewGroup.tvChildInfoSubtitle.setVisibility(0);
      paramViewGroup.tvChildInfoTitle.setText(((OwnerConfirmDeliveryBean.DeliveryInfoBean)localObject1).deliveryName);
      paramViewGroup.tvChildInfoSubtitle.setText(((OwnerConfirmDeliveryBean.DeliveryInfoBean)localObject1).subName);
      ((LinearLayout.LayoutParams)paramViewGroup.lineTop.getLayoutParams()).leftMargin = 0;
      if (paramInt != 0) {
        break label416;
      }
      paramViewGroup.lineTop.setVisibility(8);
    }
    Object localObject2;
    for (;;)
    {
      paramViewGroup.llChildItemDetail.removeAllViews();
      if ((((OwnerConfirmDeliveryBean.DeliveryInfoBean)localObject1).data == null) || (((OwnerConfirmDeliveryBean.DeliveryInfoBean)localObject1).data.size() <= 0)) {
        break label427;
      }
      localObject2 = ((OwnerConfirmDeliveryBean.DeliveryInfoBean)localObject1).data.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        OwnerConfirmDeliveryBean.DataBean localDataBean = (OwnerConfirmDeliveryBean.DataBean)((Iterator)localObject2).next();
        View localView = LayoutInflater.from(this.b).inflate(2130904411, null, false);
        TextView localTextView1 = (TextView)localView.findViewById(2131695033);
        TextView localTextView2 = (TextView)localView.findViewById(2131695034);
        localTextView1.setText(localDataBean.title);
        localTextView2.setText(localDataBean.value);
        paramViewGroup.llChildItemDetail.addView(localView);
      }
      paramViewGroup = (ViewHolder)paramView.getTag();
      break;
      label287:
      if (!ae.isNull(((OwnerConfirmDeliveryBean.DeliveryInfoBean)localObject1).deliveryName))
      {
        paramViewGroup.tvChildInfoTitle.setVisibility(0);
        paramViewGroup.tvChildInfoSubtitle.setVisibility(8);
        paramViewGroup.tvChildInfoTitle.setText(((OwnerConfirmDeliveryBean.DeliveryInfoBean)localObject1).deliveryName);
      }
      for (;;)
      {
        ((LinearLayout.LayoutParams)paramViewGroup.lineTop.getLayoutParams()).leftMargin = n.dip2px(this.b, 18.0F);
        break;
        if (!ae.isNull(((OwnerConfirmDeliveryBean.DeliveryInfoBean)localObject1).subName))
        {
          paramViewGroup.tvChildInfoTitle.setVisibility(8);
          paramViewGroup.tvChildInfoSubtitle.setVisibility(0);
          paramViewGroup.tvChildInfoSubtitle.setText(((OwnerConfirmDeliveryBean.DeliveryInfoBean)localObject1).deliveryName);
        }
        else
        {
          paramViewGroup.tvChildInfoTitle.setVisibility(8);
          paramViewGroup.tvChildInfoSubtitle.setVisibility(8);
        }
      }
      label416:
      paramViewGroup.lineTop.setVisibility(0);
    }
    label427:
    if ((((OwnerConfirmDeliveryBean.DeliveryInfoBean)localObject1).imgUrls != null) && (((OwnerConfirmDeliveryBean.DeliveryInfoBean)localObject1).imgUrls.length > 0))
    {
      localObject2 = ((OwnerConfirmDeliveryBean.DeliveryInfoBean)localObject1).imgUrls;
      paramViewGroup.glChildPicBottom.setVisibility(0);
      localObject1 = new ArrayList();
      paramInt = 0;
      while (paramInt < localObject2.length)
      {
        ((ArrayList)localObject1).add(localObject2[paramInt]);
        paramInt += 1;
      }
      localObject2 = new OCInfoItemImageAdapter(this.b, (List)localObject1);
      paramViewGroup.glChildPicBottom.setAdapter((ListAdapter)localObject2);
      paramViewGroup.glChildPicBottom.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramAnonymousAdapterView = new Intent(OCDeliveryItemAdapter.a(OCDeliveryItemAdapter.this), OwnerPhotoPreviewActivity.class);
          paramAnonymousAdapterView.putStringArrayListExtra("urlList", localObject1);
          paramAnonymousAdapterView.putExtra("position", paramAnonymousInt);
          OCDeliveryItemAdapter.a(OCDeliveryItemAdapter.this).startActivity(paramAnonymousAdapterView);
        }
      });
      ((OCInfoItemImageAdapter)localObject2).notifyDataSetChanged();
      label540:
      return paramView;
    }
    paramViewGroup.glChildPicBottom.setVisibility(8);
    return paramView;
  }
  
  public void setData(List<OwnerConfirmDeliveryBean.DeliveryInfoBean> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  static class ViewHolder
  {
    @BindView(2131695466)
    MyGridView glChildPicBottom;
    @BindView(2131695462)
    View lineTop;
    @BindView(2131695465)
    LinearLayout llChildItemDetail;
    @BindView(2131695464)
    TextView tvChildInfoSubtitle;
    @BindView(2131695463)
    TextView tvChildInfoTitle;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/OCDeliveryItemAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */