package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.ziroom.commonlibrary.login.a.c;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.d;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.adapter.OwnerContractDetailAdapter;
import com.ziroom.ziroomcustomer.my.model.OwnerContractDetailModel;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;

public class OwnerContractDetailActivity
  extends BaseActivity
{
  private static final String a = OwnerContractDetailActivity.class.getSimpleName();
  private Unbinder b;
  private String c;
  private OwnerContractDetailModel d;
  private String e;
  private Context f;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131690608)
  LinearLayout llContentContainer;
  @BindView(2131692000)
  LinearLayout owner_contract_detail_html;
  @BindView(2131691999)
  ListViewForScrollView owner_contract_detail_list;
  @BindView(2131691990)
  TextView tvContactKeeper;
  
  private void b()
  {
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    for (;;)
    {
      j.getOCContractDetail(this, g.buildOCContractDetail(str, this.c), new f(this, new d())
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          OwnerContractDetailActivity.this.q.sendEmptyMessage(0);
        }
        
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if (paramAnonymouse != null)
          {
            u.logBigData(OwnerContractDetailActivity.a(), "===ymq:" + paramAnonymouse.toString());
            OwnerContractDetailActivity.a(OwnerContractDetailActivity.this, (OwnerContractDetailModel)com.alibaba.fastjson.a.parseObject(paramAnonymouse + "", OwnerContractDetailModel.class));
            if (OwnerContractDetailActivity.a(OwnerContractDetailActivity.this) != null)
            {
              OwnerContractDetailActivity.this.llContentContainer.setVisibility(0);
              OwnerContractDetailActivity.b(OwnerContractDetailActivity.this);
              return;
            }
            OwnerContractDetailActivity.this.llContentContainer.setVisibility(4);
            return;
          }
          OwnerContractDetailActivity.this.llContentContainer.setVisibility(4);
          af.showToast(OwnerContractDetailActivity.this, "返回数据为空");
        }
      });
      return;
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
    }
  }
  
  private void e()
  {
    this.e = this.d.hireCommissionerPhone;
    if (!ae.isNull(this.e)) {
      this.tvContactKeeper.setVisibility(0);
    }
    for (;;)
    {
      this.owner_contract_detail_list.setAdapter(new OwnerContractDetailAdapter(this.d.getContractSpecial(), this));
      if (!ae.notNull(this.d.getContractItem())) {
        break;
      }
      this.owner_contract_detail_html.setVisibility(0);
      return;
      this.tvContactKeeper.setVisibility(8);
    }
    this.owner_contract_detail_html.setVisibility(8);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903404);
    this.f = this;
    this.b = ButterKnife.bind(this);
    this.c = getIntent().getStringExtra("contractCode");
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.b.unbind();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  @OnClick({2131692000, 2131689492})
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      finish();
      return;
    } while (this.d == null);
    com.ziroom.commonlibrary.login.a.verifyToken(this.f, new a.c()
    {
      public void onVerifyFinish(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          af.showToast(OwnerContractDetailActivity.this, "下载资产管理服务合同");
          String str = OwnerContractDetailActivity.a(OwnerContractDetailActivity.this).getContractItem();
          str = ah.appendGetUrlParams(OwnerContractDetailActivity.c(OwnerContractDetailActivity.this), str, true, true, true);
          ah.downloadPdf(OwnerContractDetailActivity.c(OwnerContractDetailActivity.this), str, "=");
          return;
        }
        com.ziroom.commonlibrary.login.a.startLoginActivity(OwnerContractDetailActivity.c(OwnerContractDetailActivity.this));
      }
    });
  }
  
  @OnClick({2131689492, 2131691990})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    }
    ah.callPhone(this, this.e);
  }
  
  public void toH5Page(final String paramString1, final String paramString2)
  {
    com.ziroom.commonlibrary.login.a.verifyToken(this.f, new a.c()
    {
      public void onVerifyFinish(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          String str = paramString1;
          if (str.contains("?")) {}
          for (str = str + "&";; str = str + "?")
          {
            str = str + "token=" + com.ziroom.commonlibrary.login.a.getToken(OwnerContractDetailActivity.c(OwnerContractDetailActivity.this));
            Log.i(OwnerContractDetailActivity.a(), "跳转到H5:" + str);
            JsBridgeWebActivity.start(OwnerContractDetailActivity.c(OwnerContractDetailActivity.this), paramString2, str);
            return;
          }
        }
        com.ziroom.commonlibrary.login.a.startLoginActivity(OwnerContractDetailActivity.c(OwnerContractDetailActivity.this));
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerContractDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */