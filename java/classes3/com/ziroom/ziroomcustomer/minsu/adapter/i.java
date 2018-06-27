package com.ziroom.ziroomcustomer.minsu.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.freelxl.baselibrary.a.b;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.e;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuCustomersListActivity;
import com.ziroom.ziroomcustomer.minsu.b.a;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuContactsListBean.ListUsualContactBean;
import com.ziroom.ziroomcustomer.minsu.f.k;
import java.util.ArrayList;
import java.util.List;

public class i
  extends c<MinsuContactsListBean.ListUsualContactBean>
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private Activity d;
  private ArrayList<MinsuContactsListBean.ListUsualContactBean> e = new ArrayList();
  private ArrayList<MinsuContactsListBean.ListUsualContactBean> f = new ArrayList();
  private int g = Integer.MAX_VALUE;
  
  public i(Activity paramActivity, List<MinsuContactsListBean.ListUsualContactBean> paramList)
  {
    super(paramActivity, paramList, 2130904297);
    this.d = paramActivity;
  }
  
  private void a()
  {
    g.textToast(this.a, "房间人数有限制...");
  }
  
  protected void a(final View paramView)
  {
    View.OnClickListener local1 = new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = (CheckBox)paramView.findViewById(2131690977);
        if (!paramAnonymousView.isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          return;
        }
      }
    };
    ((CheckBox)paramView.findViewById(2131690977)).setOnCheckedChangeListener(this);
    paramView.findViewById(2131695232).setOnClickListener(this);
    paramView.findViewById(2131690049).setOnClickListener(local1);
    paramView.findViewById(2131693175).setOnClickListener(local1);
    paramView.findViewById(2131695231).setOnClickListener(local1);
  }
  
  public void convert(b paramb, MinsuContactsListBean.ListUsualContactBean paramListUsualContactBean) {}
  
  public void convert(b paramb, MinsuContactsListBean.ListUsualContactBean paramListUsualContactBean, int paramInt)
  {
    paramb.setText(2131690049, "" + paramListUsualContactBean.conName);
    paramb.setText(2131695231, a.getTypeString(this.a, paramListUsualContactBean.cardType) + " : " + paramListUsualContactBean.cardValue);
    paramb.setText(2131693175, this.a.getString(2131296625) + paramListUsualContactBean.conTel);
    paramb.getView(2131690977).setTag(2131689523, paramListUsualContactBean);
    paramb.getView(2131695232).setTag(2131689523, paramListUsualContactBean);
    paramb.getView(2131691563).setTag(2131689526, Integer.valueOf(paramInt));
    if (isBooker(paramListUsualContactBean))
    {
      paramb.setVisibility(2131691563, 8);
      paramb.setVisibility(2131695233, 0);
      paramb = (CheckBox)paramb.getView(2131690977);
      if ((isSelected(paramListUsualContactBean)) && (paramb.isChecked()))
      {
        paramb.setChecked(false);
        paramb.setChecked(true);
      }
    }
    else
    {
      paramb.setVisibility(2131691563, 0);
      paramb.setVisibility(2131695233, 8);
      if (isSelected2(paramListUsualContactBean)) {}
      for (paramInt = getResColor(2131624046);; paramInt = getResColor(2131624042))
      {
        paramb.setTextColor(2131691563, paramInt);
        break;
      }
    }
    paramb.setChecked(isSelected(paramListUsualContactBean));
  }
  
  public int getResColor(int paramInt)
  {
    return ApplicationEx.c.getResources().getColor(paramInt);
  }
  
  public ArrayList<MinsuContactsListBean.ListUsualContactBean> getSelectDatas()
  {
    return this.e;
  }
  
  public boolean getSwipEnableByPosition(int paramInt)
  {
    return !isBooker((MinsuContactsListBean.ListUsualContactBean)this.b.get(paramInt));
  }
  
  public void initView(View paramView)
  {
    super.initView(paramView);
    a(paramView);
  }
  
  public boolean isBooker(MinsuContactsListBean.ListUsualContactBean paramListUsualContactBean)
  {
    return (paramListUsualContactBean != null) && (paramListUsualContactBean.isBooker == 1);
  }
  
  public boolean isSelected(MinsuContactsListBean.ListUsualContactBean paramListUsualContactBean)
  {
    return this.e.contains(paramListUsualContactBean);
  }
  
  public boolean isSelected2(MinsuContactsListBean.ListUsualContactBean paramListUsualContactBean)
  {
    return this.f.contains(paramListUsualContactBean);
  }
  
  @Instrumented
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    VdsAgent.onCheckedChanged(this, paramCompoundButton, paramBoolean);
    MinsuContactsListBean.ListUsualContactBean localListUsualContactBean = (MinsuContactsListBean.ListUsualContactBean)paramCompoundButton.getTag(2131689523);
    if ((this.e.size() >= this.g) && (paramBoolean) && (!this.e.contains(localListUsualContactBean)))
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramCompoundButton.setChecked(paramBoolean);
        a();
        return;
      }
    }
    onSelect(localListUsualContactBean, paramBoolean);
    notifyDataSetChanged();
    ((MinsuCustomersListActivity)this.a).updateSelectStatus();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      paramView = (MinsuContactsListBean.ListUsualContactBean)paramView.getTag(2131689523);
      if (isBooker(paramView))
      {
        e.newBuilder(this.a).setTitle("提示").setContent("如需修改个人基本资料，请到个人中心修改").build().show();
        return;
      }
    } while ((isBooker(paramView)) || (isSelected2(paramView)));
    k.toCustomerDetailsActivity((Activity)this.a, paramView);
  }
  
  public void onSelect(MinsuContactsListBean.ListUsualContactBean paramListUsualContactBean, boolean paramBoolean)
  {
    if (this.e == null) {
      this.e = new ArrayList();
    }
    if (paramBoolean)
    {
      if (!this.e.contains(paramListUsualContactBean))
      {
        this.e.add(paramListUsualContactBean);
        return;
      }
      this.e.remove(paramListUsualContactBean);
      this.e.add(paramListUsualContactBean);
      return;
    }
    this.e.remove(paramListUsualContactBean);
  }
  
  public void setLimit(int paramInt)
  {
    if (paramInt == 0)
    {
      this.g = Integer.MAX_VALUE;
      return;
    }
    this.g = paramInt;
  }
  
  public void setSelectDatas(ArrayList<MinsuContactsListBean.ListUsualContactBean> paramArrayList)
  {
    this.f = paramArrayList;
    this.e.clear();
    if (!com.ziroom.ziroomcustomer.minsu.f.c.isNullList(paramArrayList)) {
      this.e.addAll(paramArrayList);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */