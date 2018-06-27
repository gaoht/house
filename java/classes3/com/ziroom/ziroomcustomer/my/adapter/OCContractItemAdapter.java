package com.ziroom.ziroomcustomer.my.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.e;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.my.model.OwnerConfirmContractBean.ContractInfoBean;
import com.ziroom.ziroomcustomer.my.model.OwnerConfirmContractBean.DataBean;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.widget.MyGridView;
import java.util.Iterator;
import java.util.List;

public class OCContractItemAdapter
  extends BaseAdapter
{
  private List<OwnerConfirmContractBean.ContractInfoBean> a;
  private Context b;
  
  public OCContractItemAdapter(Context paramContext, List<OwnerConfirmContractBean.ContractInfoBean> paramList)
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
    Object localObject1;
    label142:
    label182:
    View localView;
    Object localObject2;
    TextView localTextView2;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(2130904408, paramViewGroup, false);
      paramViewGroup = new ViewHolder(paramView);
      paramView.setTag(paramViewGroup);
      localObject1 = (OwnerConfirmContractBean.ContractInfoBean)this.a.get(paramInt);
      if (localObject1 == null) {
        return paramView;
      }
      if ((ae.isNull(((OwnerConfirmContractBean.ContractInfoBean)localObject1).itemName)) || (ae.isNull(((OwnerConfirmContractBean.ContractInfoBean)localObject1).houseAddress))) {
        break label364;
      }
      paramViewGroup.tvChildInfoTitle.setVisibility(0);
      paramViewGroup.tvChildInfoSubtitle.setVisibility(0);
      paramViewGroup.tvChildInfoTitle.setText(((OwnerConfirmContractBean.ContractInfoBean)localObject1).itemName);
      paramViewGroup.tvChildInfoSubtitle.setText(((OwnerConfirmContractBean.ContractInfoBean)localObject1).houseAddress);
      ((LinearLayout.LayoutParams)paramViewGroup.lineTop.getLayoutParams()).leftMargin = 0;
      if (paramInt != 0) {
        break label493;
      }
      paramViewGroup.lineTop.setVisibility(8);
      paramViewGroup.llChildItemDetail.removeAllViews();
      if ((((OwnerConfirmContractBean.ContractInfoBean)localObject1).data == null) || (((OwnerConfirmContractBean.ContractInfoBean)localObject1).data.size() <= 0)) {
        break label524;
      }
      localObject1 = ((OwnerConfirmContractBean.ContractInfoBean)localObject1).data.iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label524;
      }
      final OwnerConfirmContractBean.DataBean localDataBean = (OwnerConfirmContractBean.DataBean)((Iterator)localObject1).next();
      localView = LayoutInflater.from(this.b).inflate(2130904411, null, false);
      localObject2 = (TextView)localView.findViewById(2131695033);
      TextView localTextView1 = (TextView)localView.findViewById(2131695034);
      localTextView2 = (TextView)localView.findViewById(2131695474);
      ((TextView)localObject2).setText(localDataBean.title);
      localTextView1.setText(localDataBean.value);
      if (!ae.notNull(localDataBean.explainText)) {
        break label504;
      }
      localTextView2.setText(localDataBean.explainText);
      label297:
      localObject2 = (ImageView)localView.findViewById(2131695475);
      if (!ae.notNull(localDataBean.explainText)) {
        break label514;
      }
      ((ImageView)localObject2).setVisibility(0);
      ((ImageView)localObject2).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          e.newBuilder(OCContractItemAdapter.a(OCContractItemAdapter.this)).setContent(localDataBean.explainText).setButtonText("知道了").build().show();
        }
      });
    }
    for (;;)
    {
      paramViewGroup.llChildItemDetail.addView(localView);
      break label182;
      paramViewGroup = (ViewHolder)paramView.getTag();
      break;
      label364:
      if (!ae.isNull(((OwnerConfirmContractBean.ContractInfoBean)localObject1).itemName))
      {
        paramViewGroup.tvChildInfoTitle.setVisibility(0);
        paramViewGroup.tvChildInfoSubtitle.setVisibility(8);
        paramViewGroup.tvChildInfoTitle.setText(((OwnerConfirmContractBean.ContractInfoBean)localObject1).itemName);
      }
      for (;;)
      {
        ((LinearLayout.LayoutParams)paramViewGroup.lineTop.getLayoutParams()).leftMargin = n.dip2px(this.b, 18.0F);
        break;
        if (!ae.isNull(((OwnerConfirmContractBean.ContractInfoBean)localObject1).houseAddress))
        {
          paramViewGroup.tvChildInfoTitle.setVisibility(8);
          paramViewGroup.tvChildInfoSubtitle.setVisibility(0);
          paramViewGroup.tvChildInfoSubtitle.setText(((OwnerConfirmContractBean.ContractInfoBean)localObject1).houseAddress);
        }
        else
        {
          paramViewGroup.tvChildInfoTitle.setVisibility(8);
          paramViewGroup.tvChildInfoSubtitle.setVisibility(8);
        }
      }
      label493:
      paramViewGroup.lineTop.setVisibility(0);
      break label142;
      label504:
      localTextView2.setText("");
      break label297;
      label514:
      ((ImageView)localObject2).setVisibility(8);
    }
    label524:
    paramViewGroup.glChildPicBottom.setVisibility(8);
    return paramView;
  }
  
  public void setData(List<OwnerConfirmContractBean.ContractInfoBean> paramList)
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/OCContractItemAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */