package com.ziroom.ziroomcustomer.minsu.landlord.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.login.LoginActivity;
import com.ziroom.commonlibrary.login.a.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuLandlordAuthInfoActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuPersonalDataActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuWebActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHasOnlineHouseBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLandlordInfo;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLandlordInfo.Customer;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuUploadPicNewBean;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.f;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.p;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.landlord.activity.MinsuLandlordPlatformServiceActivity;
import com.ziroom.ziroomcustomer.minsu.landlord.activity.MinsuLandlordSuggestActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MinsuLLMyFragment
  extends BaseFragment
{
  Uri a;
  private View b;
  private Unbinder c;
  @BindView(2131694274)
  LinearLayout changeMode;
  private List<String> d = new ArrayList();
  private MinsuLandlordInfo e;
  private List<String> f;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.d g;
  private boolean h = false;
  private f i;
  @BindView(2131694273)
  TextView logout;
  @BindView(2131694262)
  ImageView mAngel;
  @BindView(2131691157)
  ObservableScrollView mOsv;
  @BindView(2131694269)
  RelativeLayout mRlAuthInfo;
  @BindView(2131694271)
  RelativeLayout mRlCustomerService;
  @BindView(2131691098)
  SimpleDraweeView mSdv;
  @BindView(2131694261)
  SimpleDraweeView mSdvBg;
  @BindView(2131694265)
  TextView mTvAccount;
  @BindView(2131690319)
  TextView mTvAgreement;
  @BindView(2131694270)
  TextView mTvAuthInfo;
  @BindView(2131694272)
  TextView mTvCustomerService;
  @BindView(2131694266)
  TextView mTvIncome;
  @BindView(2131691571)
  TextView mTvInfo;
  @BindView(2131690049)
  TextView mTvName;
  @BindView(2131690695)
  TextView mTvService;
  @BindView(2131691491)
  TextView mTvSuggestion;
  @BindView(2131689835)
  TextView mTvTips;
  @BindView(2131694260)
  TextView mTvUpHouseRanking;
  @BindView(2131694264)
  ImageView mYear5;
  @BindView(2131694268)
  TextView tvMinsuEva;
  @BindView(2131694263)
  TextView tv_header_msg;
  
  private void a(final int paramInt)
  {
    this.f = new ArrayList();
    this.f.add("相册选择");
    this.f.add("拍照");
    this.g = new com.ziroom.ziroomcustomer.minsu.landlordrelease.view.d(getActivity(), new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        int i = 1;
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        MinsuLLMyFragment.b(MinsuLLMyFragment.this).dismiss();
        if (paramAnonymousInt == 1)
        {
          paramAnonymousAdapterView = new Intent("android.media.action.IMAGE_CAPTURE");
          paramAnonymousInt = 2;
          if (paramInt == 3) {
            paramAnonymousInt = 204;
          }
          MinsuLLMyFragment.this.startActivityForResult(paramAnonymousAdapterView, paramAnonymousInt);
        }
        while (paramAnonymousInt != 0) {
          return;
        }
        paramAnonymousAdapterView = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        paramAnonymousInt = i;
        if (paramInt == 3) {
          paramAnonymousInt = 203;
        }
        MinsuLLMyFragment.this.startActivityForResult(paramAnonymousAdapterView, paramAnonymousInt);
      }
    }, this.d, this.f);
    com.ziroom.ziroomcustomer.minsu.landlordrelease.view.d locald = this.g;
    View localView = getActivity().getWindow().getDecorView();
    if (!(locald instanceof PopupWindow))
    {
      locald.showAtLocation(localView, 80, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)locald, localView, 80, 0, 0);
  }
  
  private void a(File paramFile, int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.uploadImg(getActivity(), paramFile, paramInt, new s(getActivity(), new p(MinsuUploadPicNewBean.class))
    {
      public void onSuccess(int paramAnonymousInt, final MinsuUploadPicNewBean paramAnonymousMinsuUploadPicNewBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuUploadPicNewBean);
        if (paramAnonymousMinsuUploadPicNewBean != null) {
          MinsuLLMyFragment.this.getActivity().runOnUiThread(new Runnable()
          {
            public void run()
            {
              MinsuLLMyFragment.this.mSdv.setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousMinsuUploadPicNewBean.picUrl));
            }
          });
        }
      }
    });
  }
  
  private void c() {}
  
  private void d()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getLlInfoCenter(getActivity(), new s(getActivity(), new p(MinsuLandlordInfo.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuLandlordInfo paramAnonymousMinsuLandlordInfo)
      {
        int i = 0;
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuLandlordInfo);
        Object localObject1;
        if (paramAnonymousMinsuLandlordInfo != null)
        {
          MinsuLLMyFragment.a(MinsuLLMyFragment.this, paramAnonymousMinsuLandlordInfo);
          MinsuLLMyFragment.a(MinsuLLMyFragment.this, paramAnonymousMinsuLandlordInfo.photoRules);
          Object localObject2 = paramAnonymousMinsuLandlordInfo.customer.nickName;
          localObject1 = localObject2;
          if (ae.isNull((String)localObject2)) {
            localObject1 = paramAnonymousMinsuLandlordInfo.customer.realName;
          }
          localObject2 = localObject1;
          if (ae.isNull((String)localObject1)) {
            localObject2 = paramAnonymousMinsuLandlordInfo.customer.customerMobile;
          }
          if (MinsuLLMyFragment.this.mTvName != null) {
            MinsuLLMyFragment.this.mTvName.setText((CharSequence)localObject2);
          }
          if ((MinsuLLMyFragment.this.mSdv != null) && (MinsuLLMyFragment.this.tv_header_msg != null))
          {
            MinsuLLMyFragment.this.mSdv.setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousMinsuLandlordInfo.userPicUrl));
            if (TextUtils.isEmpty(paramAnonymousMinsuLandlordInfo.userPicAuditMsg)) {
              break label360;
            }
            ((GenericDraweeHierarchy)MinsuLLMyFragment.this.mSdv.getHierarchy()).setOverlayImage(new ColorDrawable(1291845632));
            MinsuLLMyFragment.this.tv_header_msg.setText(paramAnonymousMinsuLandlordInfo.userPicAuditMsg);
          }
          if (MinsuLLMyFragment.this.mTvAuthInfo != null) {
            MinsuLLMyFragment.this.mTvAuthInfo.setText(paramAnonymousMinsuLandlordInfo.isAuth);
          }
          MinsuLLMyFragment.a(MinsuLLMyFragment.this);
          if (MinsuLLMyFragment.this.mYear5 != null)
          {
            localObject1 = MinsuLLMyFragment.this.mYear5;
            if (paramAnonymousMinsuLandlordInfo.isFive != 1) {
              break label399;
            }
            paramAnonymousInt = 0;
            label252:
            ((ImageView)localObject1).setVisibility(paramAnonymousInt);
          }
          if (MinsuLLMyFragment.this.mAngel != null)
          {
            localObject1 = MinsuLLMyFragment.this.mAngel;
            if (paramAnonymousMinsuLandlordInfo.isAngel != 1) {
              break label405;
            }
            paramAnonymousInt = 0;
            label287:
            ((ImageView)localObject1).setVisibility(paramAnonymousInt);
          }
          if (MinsuLLMyFragment.this.tvMinsuEva != null)
          {
            localObject1 = MinsuLLMyFragment.this.tvMinsuEva;
            if (paramAnonymousMinsuLandlordInfo.waitEvaNum <= 0) {
              break label411;
            }
          }
        }
        label360:
        label399:
        label405:
        label411:
        for (paramAnonymousInt = i;; paramAnonymousInt = 8)
        {
          ((TextView)localObject1).setVisibility(paramAnonymousInt);
          MinsuLLMyFragment.this.tvMinsuEva.setText(paramAnonymousMinsuLandlordInfo.waitEvaNum + "");
          return;
          ((GenericDraweeHierarchy)MinsuLLMyFragment.this.mSdv.getHierarchy()).setOverlayImage(new ColorDrawable(16777215));
          MinsuLLMyFragment.this.tv_header_msg.setText(null);
          break;
          paramAnonymousInt = 8;
          break label252;
          paramAnonymousInt = 8;
          break label287;
        }
      }
    });
  }
  
  private void e()
  {
    if (this.i == null)
    {
      this.i = new f(getActivity());
      this.i.init();
    }
    if (this.i != null) {
      this.i.showPop();
    }
  }
  
  private void f() {}
  
  private void g()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.hasOnlineHouse(getActivity(), new s(getActivity(), new p(MinsuHasOnlineHouseBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuHasOnlineHouseBean paramAnonymousMinsuHasOnlineHouseBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuHasOnlineHouseBean);
        if ((paramAnonymousMinsuHasOnlineHouseBean != null) && (paramAnonymousMinsuHasOnlineHouseBean.hasOnlineHouse()))
        {
          k.toMinsuImproveHouseRankActivity(MinsuLLMyFragment.this.getActivity());
          return;
        }
        ad.showPublishHouseDialog(MinsuLLMyFragment.this.getActivity());
      }
    });
  }
  
  public static void showLogoutDialog(Context paramContext, final a.a parama)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(paramContext).setTitle("提示").setContent(paramContext.getString(2131296936)).setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          com.ziroom.commonlibrary.login.a.logout(this.a, parama);
        }
      }
    }).build().show();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Uri localUri;
    Bundle localBundle;
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      localUri = null;
      if (paramInt1 != 2) {
        break label131;
      }
      localBundle = paramIntent.getExtras();
      if (localBundle == null) {
        break label89;
      }
      paramIntent = ad.savePic((Bitmap)localBundle.get("data"));
    }
    for (;;)
    {
      if ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 202))
      {
        if (TextUtils.isEmpty(paramIntent)) {
          break label299;
        }
        paramIntent = new File(paramIntent);
        if (!paramIntent.exists()) {
          break;
        }
        a(paramIntent, 3);
      }
      return;
      label89:
      if ((localBundle == null) && (paramIntent != null))
      {
        paramIntent = paramIntent.getData();
        paramIntent = ad.getRealFilePath2(getActivity(), paramIntent);
      }
      else
      {
        g.textToast(getActivity(), "无法保存");
        paramIntent = localUri;
        continue;
        label131:
        if (paramInt1 == 202)
        {
          paramIntent = ad.getRealFilePath2(getActivity(), this.a);
        }
        else if (paramInt1 == 1)
        {
          paramIntent = paramIntent.getData();
          paramIntent = ad.getRealFilePath2(getActivity(), paramIntent);
        }
        else if (paramInt1 == 204)
        {
          paramIntent = ad.savePic((Bitmap)paramIntent.getExtras().get("data"));
          this.a = k.cropPic2(this, Uri.parse("file://" + paramIntent));
        }
        else if (paramInt1 == 203)
        {
          localUri = paramIntent.getData();
          paramIntent = ad.getRealFilePath2(getActivity(), localUri);
          this.a = k.cropPic2(this, localUri);
        }
        else
        {
          paramIntent = localUri;
          if (paramInt1 == 289)
          {
            d();
            paramIntent = localUri;
          }
        }
      }
    }
    g.textToast(getActivity(), "图片获取失败");
    return;
    label299:
    g.textToast(getActivity(), "图片获取失败");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.b == null) {
      this.b = paramLayoutInflater.inflate(2130903955, paramViewGroup, false);
    }
    if (this.c == null) {
      this.c = ButterKnife.bind(this, this.b);
    }
    ButterKnife.bind(this, this.b);
    return this.b;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.c != null)
    {
      this.c.unbind();
      this.c = null;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.c != null)
    {
      this.c.unbind();
      this.c = null;
    }
  }
  
  @OnClick({2131691098, 2131690049, 2131694265, 2131694266, 2131694267, 2131690695, 2131694260, 2131691571, 2131694269, 2131689835, 2131694271, 2131691491, 2131690319, 2131694274, 2131694273})
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131690049: 
    default: 
      return;
    case 2131691098: 
      a(3);
      return;
    case 2131694274: 
      k.toMainActivity(getActivity());
      return;
    case 2131694265: 
      k.goWeb(getActivity(), com.ziroom.ziroomcustomer.minsu.b.d.g + "/personal/43e881/toMyBankAcount");
      return;
    case 2131694266: 
      k.goWeb(getActivity(), com.ziroom.ziroomcustomer.minsu.b.d.g + "/profitMgt/43e881/profit");
      return;
    case 2131694267: 
      k.toLLEvaListActivity(getActivity());
      return;
    case 2131690695: 
      Intent localIntent = new Intent(getActivity(), MinsuLandlordPlatformServiceActivity.class);
      if (this.e == null) {}
      for (paramView = "";; paramView = this.e.phone400)
      {
        localIntent.putExtra("phone400", paramView);
        startActivity(localIntent);
        return;
      }
    case 2131694260: 
      g();
      return;
    case 2131691571: 
      startActivityForResult(new Intent(getActivity(), MinsuPersonalDataActivity.class), 289);
      return;
    case 2131694269: 
      paramView = new Intent(getActivity(), MinsuLandlordAuthInfoActivity.class);
      paramView.putExtra("flag", MinsuLandlordAuthInfoActivity.b);
      if ((this.e != null) && (this.e.authCode != null) && (this.e.authCode.intValue() == 1)) {
        paramView.putExtra("flag", MinsuLandlordAuthInfoActivity.a);
      }
      for (;;)
      {
        startActivity(paramView);
        return;
        paramView.putExtra("flag", MinsuLandlordAuthInfoActivity.b);
      }
    case 2131689835: 
      paramView = new Intent(getActivity(), MinsuWebActivity.class);
      paramView.putExtra("isShowShare", false);
      paramView.putExtra("url", com.ziroom.ziroomcustomer.minsu.b.d.j + "/zhuanti/minsu/zhinan/?sourceType=1");
      paramView.putExtra("isLoadTitle", false);
      startActivity(paramView);
      return;
    case 2131694271: 
      e();
      return;
    case 2131691491: 
      startActivity(new Intent(getActivity(), MinsuLandlordSuggestActivity.class));
      return;
    case 2131690319: 
      paramView = new Intent(getActivity(), MinsuWebActivity.class);
      paramView.putExtra("isShowShare", false);
      paramView.putExtra("url", com.ziroom.ziroomcustomer.minsu.landlordrelease.c.a.f);
      paramView.putExtra("title", getString(2131297105));
      startActivity(paramView);
      return;
    }
    showLogoutDialog(getActivity(), new a.a()
    {
      public void onLogoutFinish(boolean paramAnonymousBoolean)
      {
        Intent localIntent = new Intent();
        localIntent.setClass(MinsuLLMyFragment.this.getActivity(), LoginActivity.class);
        MinsuLLMyFragment.this.getActivity().startActivityForResult(localIntent, 122);
      }
    });
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    c();
    d();
  }
  
  public void onVisibilityChangedToUser(boolean paramBoolean)
  {
    super.onVisibilityChangedToUser(paramBoolean);
    if (paramBoolean) {
      d();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/fragment/MinsuLLMyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */