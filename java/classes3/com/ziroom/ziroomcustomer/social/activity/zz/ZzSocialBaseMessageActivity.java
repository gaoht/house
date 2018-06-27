package com.ziroom.ziroomcustomer.social.activity.zz;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.c.q;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.signed.SignerPlaceActivity;
import com.ziroom.ziroomcustomer.signed.TradeDirectActivity;
import com.ziroom.ziroomcustomer.signed.a.p;
import com.ziroom.ziroomcustomer.social.model.o;
import com.ziroom.ziroomcustomer.social.model.u;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.s;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import com.ziroom.ziroomcustomer.ziroomstation.utils.h;
import java.io.File;
import java.util.List;

public class ZzSocialBaseMessageActivity
  extends BaseActivity
{
  private p a;
  private p b;
  @BindView(2131690043)
  Button btn;
  @BindView(2131690078)
  ImageView btnBack;
  private int c = 0;
  private String d;
  private String e;
  @BindView(2131689810)
  EditText etName;
  @BindView(2131693059)
  EditText etSex;
  @BindView(2131693060)
  EditText etTime;
  private String f;
  private String g;
  @BindView(2131693056)
  SimpleDraweeView ivImage;
  @BindView(2131693057)
  LinearLayout llAddPhoto;
  @BindView(2131692247)
  LinearLayout llAddress;
  @BindView(2131690635)
  LinearLayout llCompany;
  @BindView(2131689847)
  LinearLayout llType;
  private int r;
  @BindView(2131689808)
  RelativeLayout rlTitle;
  private int s;
  @BindView(2131690150)
  ObservableScrollView svContent;
  private int t;
  @BindView(2131690053)
  TextView tvAddress;
  @BindView(2131693058)
  TextView tvCompany;
  @BindView(2131693061)
  TextView tvQuanzi;
  @BindView(2131689848)
  TextView tvType;
  private o u;
  private String v;
  @BindView(2131691494)
  View vLineBottom;
  
  private void a()
  {
    if (ae.isNull(VdsAgent.trackEditTextSilent(this.etName).toString()))
    {
      g.textToast(this, "请输入昵称");
      return;
    }
    if (ae.isNull(this.v))
    {
      g.textToast(this, "请上传封面照片");
      return;
    }
    if ((this.u == null) || (ae.isNull(this.tvAddress.getText().toString())))
    {
      g.textToast(this, "请选择圈子");
      return;
    }
    String str1 = VdsAgent.trackEditTextSilent(this.etName).toString();
    String str2 = VdsAgent.trackEditTextSilent(this.etTime).toString();
    if (VdsAgent.trackEditTextSilent(this.etSex).toString().equals("男")) {}
    for (int i = 1;; i = 2)
    {
      com.ziroom.ziroomcustomer.e.n.saveUserInfo(this, str1, str2, i, this.u.getCity_name(), this.u.getBizcircle_name(), this.v, "", this.r, this.d, this.e, this.f, this.s, this.g, this.t, "", new com.ziroom.ziroomcustomer.e.a.d(this, new com.ziroom.ziroomcustomer.e.c.d())
      {
        public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousObject);
          ApplicationEx.c.getUser().setHeadImg(ZzSocialBaseMessageActivity.b(ZzSocialBaseMessageActivity.this));
          ApplicationEx.c.getUser().setNickName(VdsAgent.trackEditTextSilent(ZzSocialBaseMessageActivity.this.etName).toString());
          ZzSocialBaseMessageActivity.this.startActivity(new Intent(ZzSocialBaseMessageActivity.this, ZzSocialConditionActivity.class));
          ZzSocialBaseMessageActivity.this.finish();
        }
      });
      return;
    }
  }
  
  private void b()
  {
    final Dialog localDialog = new Dialog(this, 2131427565);
    View localView = LayoutInflater.from(this).inflate(2130903877, null);
    Object localObject = (TextView)localView.findViewById(2131693932);
    ((TextView)localObject).setText("更换");
    ((TextView)localObject).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(ZzSocialBaseMessageActivity.this, false, 0, true, 400, 400);
        ZzSocialBaseMessageActivity.this.startActivityForResult(paramAnonymousView, 16);
        localDialog.dismiss();
      }
    });
    localView.findViewById(2131693933).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(ZzSocialBaseMessageActivity.this, ZzSocialBigPicsActivity.class);
        paramAnonymousView.putExtra("imageUrls", new String[] { ZzSocialBaseMessageActivity.b(ZzSocialBaseMessageActivity.this) });
        paramAnonymousView.putExtra("currentImageIndex", 0);
        ZzSocialBaseMessageActivity.this.startActivity(paramAnonymousView);
        localDialog.dismiss();
      }
    });
    localView.findViewById(2131690169).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localDialog.dismiss();
      }
    });
    localDialog.setContentView(localView);
    localObject = localView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = getResources().getDisplayMetrics().widthPixels;
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localDialog.getWindow().setGravity(80);
    localDialog.getWindow().setWindowAnimations(2131427566);
    localDialog.setCanceledOnTouchOutside(true);
    if (!(localDialog instanceof Dialog))
    {
      localDialog.show();
      return;
    }
    VdsAgent.showDialog((Dialog)localDialog);
  }
  
  private void d(String paramString)
  {
    com.ziroom.ziroomcustomer.e.n.UploadPic(this, com.ziroom.commonlibrary.login.a.getToken(this), new File(paramString), 1, new com.ziroom.ziroomcustomer.e.a.c(this, new q(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        ZzSocialBaseMessageActivity.a(ZzSocialBaseMessageActivity.this, (String)com.alibaba.fastjson.a.parseObject(paramAnonymousString).get("url"));
        if (ae.notNull(ZzSocialBaseMessageActivity.b(ZzSocialBaseMessageActivity.this)))
        {
          ZzSocialBaseMessageActivity.this.ivImage.setController(com.freelxl.baselibrary.f.c.frescoController(ZzSocialBaseMessageActivity.b(ZzSocialBaseMessageActivity.this)));
          ZzSocialBaseMessageActivity.this.ivImage.setVisibility(0);
          ZzSocialBaseMessageActivity.this.llAddPhoto.setVisibility(8);
        }
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          String str;
          do
          {
            do
            {
              do
              {
                return;
              } while (paramIntent == null);
              d(paramIntent.getStringExtra("path"));
              return;
            } while (paramInt2 != 200);
            str = paramIntent.getStringExtra("trade");
            this.c = paramIntent.getIntExtra("directPos", 0);
            this.a = ((p)h.parseObject(str, p.class));
            this.d = this.a.getName();
            this.r = Integer.parseInt(this.a.getId());
            if (!s.isEmpty(this.a.getAspects()))
            {
              this.b = ((p)this.a.getAspects().get(this.c));
              this.g = this.b.getName();
              this.t = Integer.parseInt(this.b.getId());
            }
            for (;;)
            {
              str = this.d;
              paramIntent = str;
              if (!TextUtils.isEmpty(this.g)) {
                paramIntent = str + this.g;
              }
              this.tvType.setText(paramIntent);
              return;
              this.b = null;
            }
          } while (paramInt2 != 200);
          paramInt1 = paramIntent.getIntExtra("signerPlaceType", -1);
          paramIntent = paramIntent.getStringExtra("signerPlace");
          if (paramInt1 == 2)
          {
            paramIntent = (com.ziroom.ziroomcustomer.signed.a.d)h.parseObject(paramIntent, com.ziroom.ziroomcustomer.signed.a.d.class);
            str = paramIntent.getName();
            this.e = paramIntent.getName();
            this.f = paramIntent.getBrand();
            this.s = Integer.parseInt(paramIntent.getId());
            this.tvCompany.setText(str);
            return;
          }
        } while (TextUtils.isEmpty(paramIntent));
        this.tvCompany.setText(paramIntent);
        this.e = paramIntent;
        return;
      } while (paramInt2 != 21);
      this.u = ((o)paramIntent.getSerializableExtra("address"));
    } while (this.u == null);
    this.tvAddress.setText(this.u.getCity_name() + this.u.getBizcircle_name());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903623);
    ButterKnife.bind(this);
    this.vLineBottom.setAlpha(0.0F);
    this.svContent.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        ZzSocialBaseMessageActivity.this.vLineBottom.setAlpha(f);
      }
    });
    com.ziroom.ziroomcustomer.e.n.requestGetUserInfo(this, "", new com.ziroom.ziroomcustomer.e.a.d(this, new f(u.class))
    {
      public void onSuccess(int paramAnonymousInt, u paramAnonymousu)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousu);
        if (paramAnonymousu == null) {
          return;
        }
        ZzSocialBaseMessageActivity.this.etName.setText(paramAnonymousu.getNick_name());
        EditText localEditText = ZzSocialBaseMessageActivity.this.etSex;
        String str;
        if (paramAnonymousu.getGender() == 1)
        {
          str = "男";
          localEditText.setText(str);
          if (!ae.notNull(paramAnonymousu.getHead_img())) {
            break label340;
          }
          ZzSocialBaseMessageActivity.this.ivImage.setVisibility(0);
          ZzSocialBaseMessageActivity.this.llAddPhoto.setVisibility(8);
          ZzSocialBaseMessageActivity.this.ivImage.setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousu.getHead_img()));
          ZzSocialBaseMessageActivity.a(ZzSocialBaseMessageActivity.this, paramAnonymousu.getHead_img());
        }
        for (;;)
        {
          ZzSocialBaseMessageActivity.this.tvCompany.setText(paramAnonymousu.getCompany());
          ZzSocialBaseMessageActivity.this.tvType.setText(paramAnonymousu.getIndustry());
          ZzSocialBaseMessageActivity.this.etTime.setText(paramAnonymousu.getBirthday());
          ZzSocialBaseMessageActivity.this.tvAddress.setText(paramAnonymousu.getCity() + paramAnonymousu.getBizcircle());
          ZzSocialBaseMessageActivity.this.tvQuanzi.setText(paramAnonymousu.getTips().getBizcircle());
          ZzSocialBaseMessageActivity.b(ZzSocialBaseMessageActivity.this, paramAnonymousu.getCompany());
          ZzSocialBaseMessageActivity.c(ZzSocialBaseMessageActivity.this, paramAnonymousu.getCompany_short());
          ZzSocialBaseMessageActivity.a(ZzSocialBaseMessageActivity.this, paramAnonymousu.getCompany_id());
          ZzSocialBaseMessageActivity.d(ZzSocialBaseMessageActivity.this, paramAnonymousu.getIndustry());
          ZzSocialBaseMessageActivity.b(ZzSocialBaseMessageActivity.this, paramAnonymousu.getIndustry_id());
          ZzSocialBaseMessageActivity.e(ZzSocialBaseMessageActivity.this, paramAnonymousu.getDirection());
          ZzSocialBaseMessageActivity.c(ZzSocialBaseMessageActivity.this, paramAnonymousu.getDirection_id());
          ZzSocialBaseMessageActivity.a(ZzSocialBaseMessageActivity.this, new o());
          ZzSocialBaseMessageActivity.a(ZzSocialBaseMessageActivity.this).setCity_name(paramAnonymousu.getCity());
          ZzSocialBaseMessageActivity.a(ZzSocialBaseMessageActivity.this).setBizcircle_name(paramAnonymousu.getBizcircle());
          return;
          str = "女";
          break;
          label340:
          ZzSocialBaseMessageActivity.this.ivImage.setVisibility(8);
          ZzSocialBaseMessageActivity.this.llAddPhoto.setVisibility(0);
        }
      }
    });
  }
  
  @OnClick({2131692247, 2131690078, 2131693057, 2131690635, 2131689847, 2131690043, 2131693056})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131692247: 
      paramView = new Intent(this, ZzSocialMyAddressActivity.class);
      paramView.putExtra("address", this.u);
      startActivityForResult(paramView, 21);
      return;
    case 2131690078: 
      finish();
      return;
    case 2131693057: 
      startActivityForResult(com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(this, false, 0, true, 400, 400), 16);
      return;
    case 2131690635: 
      startActivityForResult(new Intent(this, SignerPlaceActivity.class), 18);
      return;
    case 2131689847: 
      paramView = new Intent(this, TradeDirectActivity.class);
      if (this.a != null)
      {
        paramView.putExtra("selected", com.alibaba.fastjson.a.toJSONString(this.a));
        if (this.c == -1) {
          break label241;
        }
        if (!s.isEmpty(this.a.getAspects())) {
          paramView.putExtra("selectedDirected", com.alibaba.fastjson.a.toJSONString((p)this.a.getAspects().get(this.c)));
        }
      }
      for (;;)
      {
        startActivityForResult(paramView, 17);
        return;
        if (this.b != null) {
          paramView.putExtra("selectedDirected", com.alibaba.fastjson.a.toJSONString(this.b));
        }
      }
    case 2131690043: 
      label241:
      a();
      return;
    }
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialBaseMessageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */