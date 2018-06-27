package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
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
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.login.a.c;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.c.a;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.b.b;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.e.e.s;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.model.OwnerContractListBean;
import com.ziroom.ziroomcustomer.my.model.OwnerContractListBean.BeautyContractBean;
import com.ziroom.ziroomcustomer.my.model.OwnerContractListBean.DataBean;
import com.ziroom.ziroomcustomer.my.model.OwnerContractListBean.DeliveryBean;
import com.ziroom.ziroomcustomer.my.model.OwnerContractListBean.HouseContractBean;
import com.ziroom.ziroomcustomer.my.model.OwnerContractListBean.LoanBean;
import com.ziroom.ziroomcustomer.my.model.OwnerContractListBean.SupplyBean;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OwnerContrastListActivity
  extends BaseActivity
{
  private static final String a = OwnerContrastListActivity.class.getSimpleName();
  private Context b;
  private Unbinder c;
  private LayoutInflater d;
  private List<OwnerContractListBean> e = new ArrayList();
  private a f;
  private String g;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131692001)
  ListView lvOwnerContractList;
  private String r;
  private final int s = 2;
  @BindView(2131690620)
  ViewStub stubError;
  @BindView(2131692002)
  ViewStub stubNotOwner;
  private boolean t = true;
  private String u = "";
  private boolean v;
  private Handler w = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 0: 
        OwnerContrastListActivity.a(OwnerContrastListActivity.this, "网络故障，");
        return;
      }
      OwnerContrastListActivity.a(OwnerContrastListActivity.this);
    }
  };
  
  private View a(final LinearLayout paramLinearLayout, final List<OwnerContractListBean.SupplyBean> paramList, int paramInt)
  {
    View localView = this.d.inflate(2130904414, null, false);
    ((TextView)localView.findViewById(2131695490)).setText("查看其他" + paramInt + "个补充协议");
    localView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramLinearLayout.removeViewAt(paramLinearLayout.getChildCount() - 1);
        int i = 0;
        while (i < paramList.size())
        {
          if (i != 0)
          {
            paramAnonymousView = (OwnerContractListBean.SupplyBean)paramList.get(i);
            paramLinearLayout.addView(OwnerContrastListActivity.a(OwnerContrastListActivity.this, "", false, null, paramAnonymousView.contractUrl, OwnerContrastListActivity.j(OwnerContrastListActivity.this).getString(2131297311), paramAnonymousView.statusName, paramAnonymousView.data, paramAnonymousView.contractStatus));
          }
          i += 1;
        }
      }
    });
    return localView;
  }
  
  private View a(final OwnerContractListBean.LoanBean paramLoanBean, final OwnerContractListBean paramOwnerContractListBean)
  {
    if ((paramLoanBean == null) || ("5".equals(paramLoanBean.getContractStatus())) || ("6".equals(paramLoanBean.getContractStatus()))) {
      return new View(this.b);
    }
    View localView1 = LayoutInflater.from(this.b).inflate(2130904413, null);
    ViewHolder localViewHolder = new ViewHolder(localView1);
    localViewHolder.tvOwnerContractAddress.setVisibility(8);
    localViewHolder.tvOwnerContractName.setText("贷款合同");
    if ("未签约".equals(paramLoanBean.getStatusName())) {
      localViewHolder.tvOwnerContractStatus.setTextColor(-40350);
    }
    for (;;)
    {
      localViewHolder.tvOwnerContractStatus.setText(paramLoanBean.getStatusName());
      Iterator localIterator = paramLoanBean.getData().iterator();
      while (localIterator.hasNext())
      {
        OwnerContractListBean.DataBean localDataBean = (OwnerContractListBean.DataBean)localIterator.next();
        View localView2 = this.d.inflate(2130904411, null, false);
        TextView localTextView1 = (TextView)localView2.findViewById(2131695033);
        TextView localTextView2 = (TextView)localView2.findViewById(2131695034);
        localTextView1.setText(localDataBean.title);
        localTextView2.setText(localDataBean.value);
        localViewHolder.llOwnerContractDetail.addView(localView2);
      }
      localViewHolder.tvOwnerContractStatus.setTextColor(-6710887);
    }
    localViewHolder.tvConfirmContract.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (paramOwnerContractListBean.getHouseContract() == null) {
          return;
        }
        OwnerContrastListActivity.a(OwnerContrastListActivity.this, paramLoanBean.getLoanContractCode(), paramOwnerContractListBean.getHouseContract().getContractCode());
      }
    });
    localViewHolder.tvSeeContract.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        OwnerContrastListActivity.b(OwnerContrastListActivity.this, paramLoanBean.getContractUrl(), paramLoanBean.getIsPdf());
      }
    });
    localViewHolder.tvOpenInvoice.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        OwnerContrastListActivity.d(OwnerContrastListActivity.this, paramLoanBean.getPayPlanUrl());
      }
    });
    paramLoanBean = paramLoanBean.getContractStatus();
    int j = -1;
    int i = j;
    switch (paramLoanBean.hashCode())
    {
    default: 
      i = j;
    case 53: 
    case 54: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      return localView1;
      i = j;
      if (!paramLoanBean.equals("0")) {
        break;
      }
      i = 0;
      break;
      i = j;
      if (!paramLoanBean.equals("1")) {
        break;
      }
      i = 1;
      break;
      i = j;
      if (!paramLoanBean.equals("2")) {
        break;
      }
      i = 2;
      break;
      i = j;
      if (!paramLoanBean.equals("3")) {
        break;
      }
      i = 3;
      break;
      i = j;
      if (!paramLoanBean.equals("4")) {
        break;
      }
      i = 4;
      break;
      i = j;
      if (!paramLoanBean.equals("7")) {
        break;
      }
      i = 5;
      break;
      i = j;
      if (!paramLoanBean.equals("8")) {
        break;
      }
      i = 6;
      break;
      localViewHolder.tvConfirmContract.setVisibility(0);
      localViewHolder.tvConfirmContract.setText("查看并确认合同");
      localViewHolder.tvSeeContract.setVisibility(8);
      localViewHolder.tvOpenInvoice.setVisibility(8);
      continue;
      localViewHolder.tvConfirmContract.setVisibility(8);
      localViewHolder.tvSeeContract.setVisibility(0);
      localViewHolder.tvOpenInvoice.setVisibility(8);
      continue;
      localViewHolder.tvConfirmContract.setVisibility(8);
      localViewHolder.tvSeeContract.setVisibility(0);
      localViewHolder.tvOpenInvoice.setText("还款计划");
      localViewHolder.tvOpenInvoice.setVisibility(0);
    }
  }
  
  private View a(final String paramString1, boolean paramBoolean, final String paramString2, final String paramString3, final String paramString4, String paramString5, List<OwnerContractListBean.DataBean> paramList, String paramString6)
  {
    View localView1 = this.d.inflate(2130904415, null, false);
    ViewHolder localViewHolder = new ViewHolder(localView1);
    localViewHolder.tvOwnerContractName.setText(paramString4);
    localViewHolder.tvOwnerContractStatus.setText(paramString5);
    if ("未签约".equals(paramString5)) {
      localViewHolder.tvOwnerContractStatus.setTextColor(-40350);
    }
    for (;;)
    {
      paramString5 = paramList.iterator();
      while (paramString5.hasNext())
      {
        paramList = (OwnerContractListBean.DataBean)paramString5.next();
        View localView2 = this.d.inflate(2130904411, null, false);
        TextView localTextView1 = (TextView)localView2.findViewById(2131695033);
        TextView localTextView2 = (TextView)localView2.findViewById(2131695034);
        localTextView1.setText(paramList.title);
        localTextView2.setText(paramList.value);
        localViewHolder.llOwnerContractDetail.addView(localView2);
      }
      localViewHolder.tvOwnerContractStatus.setTextColor(-6710887);
    }
    localViewHolder.tvConfirmContract.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (OwnerContrastListActivity.j(OwnerContrastListActivity.this).getString(2131297309).equals(paramString4))
        {
          paramAnonymousView = new Intent(OwnerContrastListActivity.this, OwnerDeliveryConfirmActivity.class);
          paramAnonymousView.putExtra("contractCode", paramString1);
          OwnerContrastListActivity.this.startActivity(paramAnonymousView);
        }
        while (ae.isNull(paramString3)) {
          return;
        }
        OwnerContrastListActivity.this.toH5Page(paramString3, paramString4);
      }
    });
    localViewHolder.tvSeeContract.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (OwnerContrastListActivity.j(OwnerContrastListActivity.this).getString(2131297309).equals(paramString4))
        {
          paramAnonymousView = new Intent(OwnerContrastListActivity.this, OwnerDeliveryDetailActivity.class);
          paramAnonymousView.putExtra("contractCode", paramString1);
          OwnerContrastListActivity.this.startActivity(paramAnonymousView);
        }
        while (ae.isNull(paramString3)) {
          return;
        }
        OwnerContrastListActivity.this.toH5Page(paramString3, paramString4);
      }
    });
    localViewHolder.tvOpenInvoice.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(OwnerContrastListActivity.this, OwnerInvoiceListActivity.class);
        paramAnonymousView.putExtra("beautyContractCode", paramString2);
        paramAnonymousView.putExtra("hireContractCode", paramString1);
        OwnerContrastListActivity.this.startActivity(paramAnonymousView);
      }
    });
    if (e(paramString6))
    {
      localViewHolder.tvConfirmContract.setVisibility(0);
      localViewHolder.tvSeeContract.setVisibility(8);
    }
    while (paramBoolean)
    {
      localViewHolder.tvOpenInvoice.setVisibility(0);
      paramString1 = (LinearLayout.LayoutParams)localViewHolder.tvSeeContract.getLayoutParams();
      paramString1.width = 0;
      paramString1.weight = 1.0F;
      localViewHolder.tvSeeContract.setLayoutParams(paramString1);
      paramString1 = (LinearLayout.LayoutParams)localViewHolder.tvConfirmContract.getLayoutParams();
      paramString1.width = 0;
      paramString1.weight = 1.0F;
      localViewHolder.tvConfirmContract.setLayoutParams(paramString1);
      return localView1;
      localViewHolder.tvConfirmContract.setVisibility(8);
      localViewHolder.tvSeeContract.setVisibility(0);
    }
    localViewHolder.tvOpenInvoice.setVisibility(8);
    return localView1;
  }
  
  private void a(final ViewGroup paramViewGroup, final List<OwnerContractListBean.LoanBean> paramList, final OwnerContractListBean paramOwnerContractListBean)
  {
    TextView localTextView = new TextView(this.b);
    localTextView.setTextSize(2, 14.0F);
    localTextView.setTextColor(this.b.getResources().getColor(2131624562));
    localTextView.setGravity(17);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, ah.dip2px(this.b, 56.0F)));
    localTextView.setText("查看历史贷款合同");
    localTextView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramViewGroup.removeAllViews();
        paramAnonymousView = paramList.iterator();
        while (paramAnonymousView.hasNext())
        {
          Object localObject = (OwnerContractListBean.LoanBean)paramAnonymousView.next();
          localObject = OwnerContrastListActivity.a(OwnerContrastListActivity.this, (OwnerContractListBean.LoanBean)localObject, paramOwnerContractListBean);
          paramViewGroup.addView((View)localObject);
        }
      }
    });
    paramViewGroup.addView(localTextView);
    paramList = new ImageView(this.b);
    paramList.setLayoutParams(new ViewGroup.LayoutParams(-1, ah.dip2px(this.b, 1.0F)));
    paramList.setBackgroundColor(this.b.getResources().getColor(2131624047));
    paramViewGroup.addView(paramList);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this.b, OwnerLoanContractConfirmActivity.class);
    localIntent.putExtra("loanContractCode", paramString1);
    localIntent.putExtra("contractCode", paramString2);
    startActivity(localIntent);
  }
  
  private void b()
  {
    this.t = true;
    this.v = true;
    Map localMap1 = g.buildOCContractList(this.g, this.r, 2, this.u);
    String str = q.o + e.s.as;
    Map localMap2 = b.getHeader(this.b);
    com.freelxl.baselibrary.d.a.post(str).tag(this.b).headers(localMap2).setBodyString("application/json;charset=UTF-8", b.getParam(localMap1)).enqueue(new f(this.b, new e(OwnerContractListBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        OwnerContrastListActivity.b(OwnerContrastListActivity.this, false);
        OwnerContrastListActivity.c(OwnerContrastListActivity.this).sendEmptyMessage(0);
      }
      
      public void onSuccess(int paramAnonymousInt, List<OwnerContractListBean> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if ((paramAnonymousList == null) || (paramAnonymousList.size() < 1))
        {
          OwnerContrastListActivity.a(OwnerContrastListActivity.this, false);
          if (ae.isNull(OwnerContrastListActivity.b(OwnerContrastListActivity.this))) {
            OwnerContrastListActivity.c(OwnerContrastListActivity.this).sendEmptyMessage(1);
          }
          return;
        }
        if (paramAnonymousList.size() < 2) {
          OwnerContrastListActivity.a(OwnerContrastListActivity.this, false);
        }
        OwnerContrastListActivity.d(OwnerContrastListActivity.this).addAll(paramAnonymousList);
        OwnerContrastListActivity.this.stubError.setVisibility(8);
        OwnerContrastListActivity.this.lvOwnerContractList.setVisibility(0);
        OwnerContrastListActivity.e(OwnerContrastListActivity.this).notifyDataSetChanged();
        paramAnonymousList = (OwnerContractListBean)OwnerContrastListActivity.d(OwnerContrastListActivity.this).get(OwnerContrastListActivity.d(OwnerContrastListActivity.this).size() - 1);
        if ((paramAnonymousList != null) || (paramAnonymousList.getHouseContract() != null)) {
          OwnerContrastListActivity.b(OwnerContrastListActivity.this, paramAnonymousList.getHouseContract().getLastPageValue());
        }
        OwnerContrastListActivity.b(OwnerContrastListActivity.this, false);
      }
    });
  }
  
  private void b(final String paramString1, final String paramString2)
  {
    com.ziroom.commonlibrary.login.a.verifyToken(this.b, new a.c()
    {
      public void onVerifyFinish(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          if ("1".equals(paramString2))
          {
            ah.downloadPdf(OwnerContrastListActivity.j(OwnerContrastListActivity.this), paramString1);
            return;
          }
          JsBridgeWebActivity.start(OwnerContrastListActivity.j(OwnerContrastListActivity.this), "合同", paramString1);
          return;
        }
        com.ziroom.commonlibrary.login.a.startLoginActivity(OwnerContrastListActivity.j(OwnerContrastListActivity.this));
      }
    });
  }
  
  private void d(String paramString)
  {
    toH5Page(paramString, "");
  }
  
  private void e()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null)
    {
      this.g = localUserInfo.getUid();
      this.r = localUserInfo.getPhone();
    }
    this.f = new a(null);
    this.lvOwnerContractList.setAdapter(this.f);
    this.lvOwnerContractList.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if ((paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (OwnerContrastListActivity.this.lvOwnerContractList.getChildAt(OwnerContrastListActivity.this.lvOwnerContractList.getChildCount() - 1) != null) && (!OwnerContrastListActivity.f(OwnerContrastListActivity.this)))
        {
          d.d("ListView", "##### 滚动到底部 ######");
          if (OwnerContrastListActivity.g(OwnerContrastListActivity.this))
          {
            OwnerContrastListActivity.b(OwnerContrastListActivity.this, true);
            OwnerContrastListActivity.h(OwnerContrastListActivity.this);
          }
        }
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
  }
  
  private boolean e(String paramString)
  {
    return "wqy".equals(paramString);
  }
  
  private void f()
  {
    if (!isFinishing())
    {
      this.lvOwnerContractList.setVisibility(8);
      this.stubNotOwner.setVisibility(0);
      TextView localTextView = (TextView)findViewById(2131694446);
      localTextView.getPaint().setFlags(8);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          JsBridgeWebActivity.start(OwnerContrastListActivity.this, "", "http://yezhu.ziroom.com/m/index.html");
          OwnerContrastListActivity.this.finish();
        }
      });
    }
  }
  
  private void f(String paramString)
  {
    if (!isFinishing())
    {
      this.lvOwnerContractList.setVisibility(8);
      this.stubError.setVisibility(0);
      ((TextView)findViewById(2131690822)).setText(paramString);
      paramString = (TextView)findViewById(2131694446);
      paramString.getPaint().setFlags(8);
      paramString.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          OwnerContrastListActivity.h(OwnerContrastListActivity.this);
        }
      });
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = LayoutInflater.from(this);
    this.b = this;
    setContentView(2130903405);
    this.c = ButterKnife.bind(this);
    e();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.c.unbind();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.e.clear();
    this.u = "";
    b();
  }
  
  @OnClick({2131689492, 2131690620})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  public void toH5Page(final String paramString1, String paramString2)
  {
    com.ziroom.commonlibrary.login.a.verifyToken(this.b, new a.c()
    {
      public void onVerifyFinish(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          String str = paramString1;
          if (str.contains("?")) {}
          for (str = str + "&";; str = str + "?")
          {
            str = str + "token=" + com.ziroom.commonlibrary.login.a.getToken(OwnerContrastListActivity.j(OwnerContrastListActivity.this));
            Log.i(OwnerContrastListActivity.a(), "跳转到H5:" + str);
            JsBridgeWebActivity.start(OwnerContrastListActivity.j(OwnerContrastListActivity.this), true, "", str);
            return;
          }
        }
        com.ziroom.commonlibrary.login.a.startLoginActivity(OwnerContrastListActivity.j(OwnerContrastListActivity.this));
      }
    });
  }
  
  static class ViewHolder
  {
    @BindView(2131695489)
    View dividerBottom;
    @BindView(2131692247)
    LinearLayout llAddress;
    @BindView(2131695480)
    LinearLayout llLoanContainer;
    @BindView(2131695488)
    LinearLayout llOwnerContractContainer;
    @BindView(2131695484)
    LinearLayout llOwnerContractDetail;
    @BindView(2131690053)
    TextView tvAddress;
    @BindView(2131695486)
    TextView tvConfirmContract;
    @BindView(2131695487)
    TextView tvOpenInvoice;
    @BindView(2131695483)
    TextView tvOwnerContractAddress;
    @BindView(2131695481)
    TextView tvOwnerContractName;
    @BindView(2131695482)
    TextView tvOwnerContractStatus;
    @BindView(2131695485)
    TextView tvSeeContract;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
  
  private class a
    extends BaseAdapter
  {
    private a() {}
    
    public int getCount()
    {
      if (OwnerContrastListActivity.d(OwnerContrastListActivity.this) == null) {
        return 0;
      }
      return OwnerContrastListActivity.d(OwnerContrastListActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return OwnerContrastListActivity.d(OwnerContrastListActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = OwnerContrastListActivity.i(OwnerContrastListActivity.this).inflate(2130904413, paramViewGroup, false);
        paramViewGroup = new OwnerContrastListActivity.ViewHolder(paramView);
        paramView.setTag(paramViewGroup);
        if (OwnerContrastListActivity.d(OwnerContrastListActivity.this).size() - 1 != paramInt) {
          break label108;
        }
        paramViewGroup.dividerBottom.setVisibility(0);
      }
      final OwnerContractListBean localOwnerContractListBean;
      for (;;)
      {
        localOwnerContractListBean = (OwnerContractListBean)OwnerContrastListActivity.d(OwnerContrastListActivity.this).get(paramInt);
        if (localOwnerContractListBean != null) {
          break label120;
        }
        return new View(OwnerContrastListActivity.j(OwnerContrastListActivity.this));
        paramViewGroup = (OwnerContrastListActivity.ViewHolder)paramView.getTag();
        break;
        label108:
        paramViewGroup.dividerBottom.setVisibility(8);
      }
      label120:
      if (localOwnerContractListBean.getHouseContract() != null)
      {
        paramViewGroup.llAddress.setVisibility(0);
        paramViewGroup.tvAddress.setText(localOwnerContractListBean.getHouseContract().houseAddress);
      }
      paramViewGroup.llLoanContainer.removeAllViews();
      Object localObject1;
      if ((localOwnerContractListBean.getLoanContract() != null) && (localOwnerContractListBean.getLoanContract().size() > 0))
      {
        localObject1 = localOwnerContractListBean.getLoanContract();
        paramViewGroup.llLoanContainer.addView(OwnerContrastListActivity.a(OwnerContrastListActivity.this, (OwnerContractListBean.LoanBean)((List)localObject1).get(0), localOwnerContractListBean));
        if (((List)localObject1).size() > 1) {
          OwnerContrastListActivity.a(OwnerContrastListActivity.this, paramViewGroup.llLoanContainer, (List)localObject1, localOwnerContractListBean);
        }
      }
      paramViewGroup.tvOwnerContractName.setText(OwnerContrastListActivity.j(OwnerContrastListActivity.this).getString(2131297308));
      paramViewGroup.tvOwnerContractStatus.setText(localOwnerContractListBean.houseContract.statusName);
      if ("未签约".equals(localOwnerContractListBean.houseContract.statusName)) {
        paramViewGroup.tvOwnerContractStatus.setTextColor(-40350);
      }
      Object localObject2;
      for (;;)
      {
        paramViewGroup.tvOwnerContractAddress.setText(localOwnerContractListBean.houseContract.productType + "·" + localOwnerContractListBean.houseContract.houseAddress);
        paramViewGroup.llOwnerContractDetail.removeAllViews();
        localObject1 = localOwnerContractListBean.houseContract.data.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (OwnerContractListBean.DataBean)((Iterator)localObject1).next();
          View localView = OwnerContrastListActivity.i(OwnerContrastListActivity.this).inflate(2130904411, null, false);
          TextView localTextView1 = (TextView)localView.findViewById(2131695033);
          TextView localTextView2 = (TextView)localView.findViewById(2131695034);
          localTextView1.setText(((OwnerContractListBean.DataBean)localObject2).title);
          localTextView2.setText(((OwnerContractListBean.DataBean)localObject2).value);
          paramViewGroup.llOwnerContractDetail.addView(localView);
        }
        paramViewGroup.tvOwnerContractStatus.setTextColor(-6710887);
      }
      paramViewGroup.llOwnerContractContainer.removeAllViews();
      if ((localOwnerContractListBean.delivery != null) && (localOwnerContractListBean.delivery.size() > 0))
      {
        localObject1 = localOwnerContractListBean.delivery.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (OwnerContractListBean.DeliveryBean)((Iterator)localObject1).next();
          paramViewGroup.llOwnerContractContainer.addView(OwnerContrastListActivity.a(OwnerContrastListActivity.this, localOwnerContractListBean.houseContract.contractCode, false, null, null, OwnerContrastListActivity.j(OwnerContrastListActivity.this).getString(2131297309), ((OwnerContractListBean.DeliveryBean)localObject2).statusName, ((OwnerContractListBean.DeliveryBean)localObject2).data, ((OwnerContractListBean.DeliveryBean)localObject2).contractStatus));
        }
      }
      if ((localOwnerContractListBean.beautyContract != null) && (localOwnerContractListBean.beautyContract.size() > 0))
      {
        localObject1 = localOwnerContractListBean.beautyContract.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (OwnerContractListBean.BeautyContractBean)((Iterator)localObject1).next();
          paramViewGroup.llOwnerContractContainer.addView(OwnerContrastListActivity.a(OwnerContrastListActivity.this, localOwnerContractListBean.houseContract.contractCode, ((OwnerContractListBean.BeautyContractBean)localObject2).invoiceApply, ((OwnerContractListBean.BeautyContractBean)localObject2).beautyContractCode, ((OwnerContractListBean.BeautyContractBean)localObject2).contractUrl, OwnerContrastListActivity.j(OwnerContrastListActivity.this).getString(2131297307), ((OwnerContractListBean.BeautyContractBean)localObject2).statusName, ((OwnerContractListBean.BeautyContractBean)localObject2).data, ((OwnerContractListBean.BeautyContractBean)localObject2).contractStatus));
        }
      }
      if ((localOwnerContractListBean.supply != null) && (localOwnerContractListBean.supply.size() > 0))
      {
        paramViewGroup.llOwnerContractContainer.addView(OwnerContrastListActivity.a(OwnerContrastListActivity.this, localOwnerContractListBean.houseContract.contractCode, false, null, ((OwnerContractListBean.SupplyBean)localOwnerContractListBean.supply.get(0)).contractUrl, OwnerContrastListActivity.j(OwnerContrastListActivity.this).getString(2131297311), ((OwnerContractListBean.SupplyBean)localOwnerContractListBean.supply.get(0)).statusName, ((OwnerContractListBean.SupplyBean)localOwnerContractListBean.supply.get(0)).data, ((OwnerContractListBean.SupplyBean)localOwnerContractListBean.supply.get(0)).contractStatus));
        if (localOwnerContractListBean.supply.size() > 1) {
          paramViewGroup.llOwnerContractContainer.addView(OwnerContrastListActivity.a(OwnerContrastListActivity.this, paramViewGroup.llOwnerContractContainer, localOwnerContractListBean.supply, localOwnerContractListBean.supply.size() - 1));
        }
      }
      paramViewGroup.tvConfirmContract.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int k = 0;
          int i = 0;
          int j = k;
          if (localOwnerContractListBean.getLoanContract() != null)
          {
            j = k;
            if (localOwnerContractListBean.getLoanContract().size() > 0)
            {
              j = k;
              if (localOwnerContractListBean.getHouseContract() != null)
              {
                paramAnonymousView = localOwnerContractListBean.getLoanContract().iterator();
                final OwnerContractListBean.LoanBean localLoanBean;
                while (paramAnonymousView.hasNext())
                {
                  localLoanBean = (OwnerContractListBean.LoanBean)paramAnonymousView.next();
                  if ((localLoanBean != null) && ("0".equals(localLoanBean.getContractStatus())))
                  {
                    com.ziroom.ziroomcustomer.dialog.c.newBuilder(OwnerContrastListActivity.j(OwnerContrastListActivity.this)).setContent("您有一个贷款合同需先确认，请在确认收房合同前先确认贷款合同").setButtonText("取消").setSecondButtonText("查看贷款合同").setOnSecondClickListener(new View.OnClickListener()
                    {
                      @Instrumented
                      public void onClick(View paramAnonymous2View)
                      {
                        VdsAgent.onClick(this, paramAnonymous2View);
                        OwnerContrastListActivity.a(OwnerContrastListActivity.this, localLoanBean.getLoanContractCode(), OwnerContrastListActivity.a.1.this.a.getHouseContract().contractCode);
                      }
                    }).build().show();
                    return;
                  }
                }
                paramAnonymousView = localOwnerContractListBean.getLoanContract().iterator();
                do
                {
                  j = i;
                  if (!paramAnonymousView.hasNext()) {
                    break;
                  }
                  localLoanBean = (OwnerContractListBean.LoanBean)paramAnonymousView.next();
                } while (localLoanBean == null);
                if (!"1".equals(localLoanBean.getContractStatus())) {
                  break label265;
                }
                i = 1;
              }
            }
          }
          label265:
          for (;;)
          {
            break;
            paramAnonymousView = new Intent(OwnerContrastListActivity.this, OwnerContractConfirmActivity.class);
            paramAnonymousView.putExtra("contractCode", localOwnerContractListBean.houseContract.contractCode);
            paramAnonymousView.putExtra("isLoan", j);
            OwnerContrastListActivity.this.startActivity(paramAnonymousView);
            return;
          }
        }
      });
      paramViewGroup.tvSeeContract.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(OwnerContrastListActivity.this, OwnerContractDetailActivity.class);
          paramAnonymousView.putExtra("contractCode", localOwnerContractListBean.houseContract.contractCode);
          OwnerContrastListActivity.this.startActivity(paramAnonymousView);
        }
      });
      if (OwnerContrastListActivity.c(OwnerContrastListActivity.this, localOwnerContractListBean.houseContract.contractStatus))
      {
        paramViewGroup.tvConfirmContract.setVisibility(0);
        paramViewGroup.tvSeeContract.setVisibility(8);
        return paramView;
      }
      paramViewGroup.tvConfirmContract.setVisibility(8);
      paramViewGroup.tvSeeContract.setVisibility(0);
      return paramView;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerContrastListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */