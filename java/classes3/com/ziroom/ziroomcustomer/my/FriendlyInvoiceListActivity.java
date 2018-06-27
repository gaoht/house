package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.model.FInvoiceListModel;
import com.ziroom.ziroomcustomer.my.model.FInvoiceListModel.InfoListBean;
import com.ziroom.ziroomcustomer.my.model.FInvoiceTypeBean;
import com.ziroom.ziroomcustomer.my.widget.FInvoiceTypeListPop;
import com.ziroom.ziroomcustomer.my.widget.FInvoiceTypeListPop.b;
import com.ziroom.ziroomcustomer.my.widget.b;
import com.ziroom.ziroomcustomer.my.widget.b.a;
import com.ziroom.ziroomcustomer.newchat.chatcenter.activity.ChatWebViewActivity;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.ProjectListConditionalView.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FriendlyInvoiceListActivity
  extends OwnerBaseActivity
{
  Unbinder a;
  FInvoiceTypeListPop b;
  @BindView(2131690078)
  ImageView btnBack;
  private String d = FriendlyInvoiceListActivity.class.getSimpleName();
  private Context e;
  private List<FInvoiceListModel> f = new ArrayList();
  private List<FInvoiceTypeBean> g = new ArrayList();
  @BindView(2131690623)
  ImageView ivAdvice;
  @BindView(2131690608)
  LinearLayout llContentContainer;
  @BindView(2131689834)
  LinearLayout llTips;
  @BindView(2131690622)
  ListView lvOwnerInvoices;
  private a r;
  private String s;
  @BindView(2131690620)
  ViewStub stubError;
  private String t;
  @BindView(2131690621)
  TextView tvBtnTitleRight;
  @BindView(2131689541)
  TextView tvTitle;
  private int u;
  private int v = 2;
  private String w = "";
  private String x = "";
  private final int y = 0;
  private final int z = 1;
  
  private void a(LinearLayout paramLinearLayout, List<FInvoiceListModel.InfoListBean> paramList)
  {
    paramLinearLayout.removeAllViews();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FInvoiceListModel.InfoListBean localInfoListBean = (FInvoiceListModel.InfoListBean)paramList.next();
        LinearLayout localLinearLayout = new LinearLayout(this);
        localLinearLayout.setOrientation(0);
        TextView localTextView1 = new TextView(this);
        localTextView1.setTextSize(2, 14.0F);
        localTextView1.setTextColor(getResources().getColor(2131624042));
        LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams1.bottomMargin = ah.dip2px(this, 16.0F);
        localTextView1.setText(localInfoListBean.title + ": ");
        TextView localTextView2 = new TextView(this);
        localTextView2.setTextSize(2, 14.0F);
        localTextView2.setTextColor(getResources().getColor(2131624042));
        localTextView2.setSingleLine();
        localTextView2.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams2.bottomMargin = ah.dip2px(this, 16.0F);
        localTextView2.setText(localInfoListBean.getValue());
        localLinearLayout.addView(localTextView1, localLayoutParams1);
        localLinearLayout.addView(localTextView2, localLayoutParams2);
        paramLinearLayout.addView(localLinearLayout);
      }
    }
  }
  
  private void b()
  {
    this.t = getIntent().getStringExtra("contractCode");
    this.u = 0;
  }
  
  private void b(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", this.t);
    localHashMap.put("uid", com.ziroom.commonlibrary.login.a.getUid(this));
    localHashMap.put("type", Integer.valueOf(paramInt));
    j.getFInvoiceApplyNature(this, localHashMap, new com.ziroom.ziroomcustomer.e.a.d(this, new f(com.alibaba.fastjson.e.class))
    {
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if (paramAnonymouse == null) {
          return;
        }
        paramAnonymousInt = paramAnonymouse.getInteger("type").intValue();
        paramAnonymouse = new Intent(FriendlyInvoiceListActivity.this, FriendlyInvoiceOpenActivity.class);
        paramAnonymouse.putExtra("contractCode", FriendlyInvoiceListActivity.b(FriendlyInvoiceListActivity.this));
        paramAnonymouse.putExtra("type", paramAnonymousInt);
        FriendlyInvoiceListActivity.this.startActivity(paramAnonymouse);
      }
    });
  }
  
  private void e()
  {
    this.r.notifyDataSetChanged();
  }
  
  private void f()
  {
    b localb = new b(this.e);
    localb.setOnTypeSelectListener(new b.a()
    {
      public void onTypeSelect(int paramAnonymousInt)
      {
        FriendlyInvoiceListActivity.a(FriendlyInvoiceListActivity.this, paramAnonymousInt);
      }
    });
    localb.show();
  }
  
  private void g()
  {
    if (this.b == null)
    {
      this.b = new FInvoiceTypeListPop(this.e);
      h();
    }
    if (this.b.isShowing())
    {
      this.b.dismiss();
      return;
    }
    this.tvTitle.setSelected(true);
    this.b.show(this.tvTitle, this.g, this.u);
  }
  
  private void h()
  {
    this.b.setPopDismisListener(new ProjectListConditionalView.b()
    {
      public void onDismiss()
      {
        FriendlyInvoiceListActivity.this.tvTitle.setSelected(false);
      }
    });
    this.b.setOnSelectListener(new FInvoiceTypeListPop.b()
    {
      public void select(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        FriendlyInvoiceListActivity.this.tvTitle.setText(((FInvoiceTypeBean)FriendlyInvoiceListActivity.c(FriendlyInvoiceListActivity.this).get(paramAnonymousInt)).typeName);
        FriendlyInvoiceListActivity.b(FriendlyInvoiceListActivity.this, paramAnonymousInt);
        FriendlyInvoiceListActivity.c(FriendlyInvoiceListActivity.this, ((FInvoiceTypeBean)FriendlyInvoiceListActivity.c(FriendlyInvoiceListActivity.this).get(paramAnonymousInt)).typeCode);
        FriendlyInvoiceListActivity.this.initData();
      }
    });
  }
  
  void a()
  {
    showError(this.llContentContainer, this.stubError, "网络故障，");
  }
  
  public void initData()
  {
    if (ApplicationEx.c.getUser() != null) {
      this.s = ApplicationEx.c.getUser().getUid();
    }
    for (;;)
    {
      j.getFInvoiceList(this, g.buildFInvoiceList(this.t, this.w, this.v, this.x), new com.ziroom.ziroomcustomer.e.a.d(this, new com.ziroom.ziroomcustomer.e.c.e(FInvoiceListModel.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          FriendlyInvoiceListActivity.this.llTips.setVisibility(8);
          FriendlyInvoiceListActivity.this.c.sendEmptyMessage(0);
        }
        
        public void onSuccess(int paramAnonymousInt, List<FInvoiceListModel> paramAnonymousList)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousList);
          if ((paramAnonymousList == null) || (paramAnonymousList.size() < 1))
          {
            FriendlyInvoiceListActivity.this.llTips.setVisibility(0);
            return;
          }
          FriendlyInvoiceListActivity.this.llTips.setVisibility(8);
          FriendlyInvoiceListActivity.a(FriendlyInvoiceListActivity.this, paramAnonymousList);
          if (FriendlyInvoiceListActivity.this.stubError.getVisibility() == 0) {
            FriendlyInvoiceListActivity.this.closeError(FriendlyInvoiceListActivity.this.llContentContainer, FriendlyInvoiceListActivity.this.stubError);
          }
          FriendlyInvoiceListActivity.a(FriendlyInvoiceListActivity.this);
        }
      });
      return;
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
    }
  }
  
  public void initView()
  {
    this.r = new a();
    this.lvOwnerInvoices.setAdapter(this.r);
    int i = 0;
    if (i < 3)
    {
      FInvoiceTypeBean localFInvoiceTypeBean = new FInvoiceTypeBean();
      switch (i)
      {
      }
      for (;;)
      {
        this.g.add(localFInvoiceTypeBean);
        i += 1;
        break;
        localFInvoiceTypeBean.typeName = "全部";
        localFInvoiceTypeBean.typeCode = 2;
        continue;
        localFInvoiceTypeBean.typeName = "服务费发票";
        localFInvoiceTypeBean.typeCode = 1;
        continue;
        localFInvoiceTypeBean.typeName = "房租发票";
        localFInvoiceTypeBean.typeCode = 0;
      }
    }
  }
  
  public void onBackPressed()
  {
    setResult(999);
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.e = this;
    setContentView(2130903180);
    this.a = ButterKnife.bind(this);
    b();
    initView();
    initData();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    b();
    initData();
  }
  
  protected void onResume()
  {
    super.onResume();
    initData();
  }
  
  @OnClick({2131690078, 2131689541, 2131690621, 2131690623})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690078: 
      finish();
      return;
    case 2131689541: 
      g();
      return;
    case 2131690621: 
      f();
      return;
    }
    startActivity(new Intent(this, ChatWebViewActivity.class));
  }
  
  static class ViewHolder
  {
    @BindView(2131695031)
    TextView btnCancelInvoice;
    @BindView(2131695032)
    TextView btnToPay;
    @BindView(2131695025)
    TextView friendlyContractCode;
    @BindView(2131695024)
    TextView friendlyInvoiceName;
    @BindView(2131695026)
    TextView friendlyInvoiceStatus;
    @BindView(2131695028)
    LinearLayout llContainerBelow;
    @BindView(2131695027)
    LinearLayout llContainerInfo;
    @BindView(2131695029)
    LinearLayout llPriceContainer;
    @BindView(2131695030)
    TextView tvNeedPayValue;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
  
  class a
    extends BaseAdapter
  {
    FriendlyInvoiceListActivity.ViewHolder a;
    
    a() {}
    
    public int getCount()
    {
      if (FriendlyInvoiceListActivity.d(FriendlyInvoiceListActivity.this) == null) {
        return 0;
      }
      return FriendlyInvoiceListActivity.d(FriendlyInvoiceListActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return FriendlyInvoiceListActivity.d(FriendlyInvoiceListActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = View.inflate(FriendlyInvoiceListActivity.e(FriendlyInvoiceListActivity.this), 2130904205, null);
        this.a = new FriendlyInvoiceListActivity.ViewHolder(paramView);
        paramView.setTag(this.a);
        paramViewGroup = (FInvoiceListModel)FriendlyInvoiceListActivity.d(FriendlyInvoiceListActivity.this).get(paramInt);
        this.a.friendlyInvoiceName.setText(paramViewGroup.busTypeName);
        this.a.friendlyContractCode.setText(paramViewGroup.contractCode);
        this.a.friendlyInvoiceStatus.setText(paramViewGroup.statusName);
        FriendlyInvoiceListActivity.a(FriendlyInvoiceListActivity.this, this.a.llContainerInfo, paramViewGroup.infoList);
        if ((paramViewGroup.payAmount > 0) || (paramViewGroup.cancelApply) || (paramViewGroup.payButton)) {
          break label177;
        }
        this.a.llContainerBelow.setVisibility(8);
      }
      for (;;)
      {
        paramView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(FriendlyInvoiceListActivity.e(FriendlyInvoiceListActivity.this), FriendlyInvoiceDetailActivity.class);
            paramAnonymousView.putExtra("invoiceNum", paramViewGroup.getApplyNo());
            paramAnonymousView.putExtra("busType", paramViewGroup.getBusType());
            FriendlyInvoiceListActivity.this.startActivity(paramAnonymousView);
          }
        });
        return paramView;
        this.a = ((FriendlyInvoiceListActivity.ViewHolder)paramView.getTag());
        break;
        label177:
        this.a.llContainerBelow.setVisibility(0);
        if (paramViewGroup.payAmount > 0)
        {
          this.a.llPriceContainer.setVisibility(0);
          this.a.tvNeedPayValue.setText(paramViewGroup.payAmount / 100.0D + "");
          label243:
          if (!paramViewGroup.cancelApply) {
            break label335;
          }
          this.a.btnCancelInvoice.setVisibility(0);
          this.a.btnCancelInvoice.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(FriendlyInvoiceListActivity.e(FriendlyInvoiceListActivity.this)).setOnConfirmClickListener(new d.b()
              {
                public void onLeftClick(View paramAnonymous2View) {}
                
                public void onRightClick(View paramAnonymous2View)
                {
                  paramAnonymous2View = new HashMap();
                  paramAnonymous2View.put("invoiceNum", FriendlyInvoiceListActivity.a.1.this.a.applyNo);
                  paramAnonymous2View.put("busType", Integer.valueOf(FriendlyInvoiceListActivity.a.1.this.a.busType));
                  j.cancelFInvoiceApply(FriendlyInvoiceListActivity.this, paramAnonymous2View, new com.ziroom.ziroomcustomer.e.a.d(FriendlyInvoiceListActivity.this, new f(com.alibaba.fastjson.e.class))
                  {
                    public void onSuccess(int paramAnonymous3Int, com.alibaba.fastjson.e paramAnonymous3e)
                    {
                      super.onSuccess(paramAnonymous3Int, paramAnonymous3e);
                      FriendlyInvoiceListActivity.this.initData();
                    }
                  });
                }
              }).setTitle("温馨提示").setContent("你确定要取消开票吗？\n").setButtonText("取消", "确定").show();
            }
          });
        }
        for (;;)
        {
          if (!paramViewGroup.payButton) {
            break label350;
          }
          this.a.btnToPay.setVisibility(0);
          this.a.btnToPay.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              com.ziroom.ziroomcustomer.payment.a.startPayActivty(FriendlyInvoiceListActivity.this, paramViewGroup.getPayAmount(), "110", paramViewGroup.getReceivableNum(), paramViewGroup.getSystemId(), paramViewGroup.getDeadLineTime());
            }
          });
          break;
          this.a.llPriceContainer.setVisibility(8);
          break label243;
          label335:
          this.a.btnCancelInvoice.setVisibility(8);
        }
        label350:
        this.a.btnToPay.setVisibility(8);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/FriendlyInvoiceListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */