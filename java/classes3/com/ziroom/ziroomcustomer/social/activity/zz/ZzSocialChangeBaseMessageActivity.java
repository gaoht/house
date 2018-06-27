package com.ziroom.ziroomcustomer.social.activity.zz;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.c.q;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.signed.SignerPlaceActivity;
import com.ziroom.ziroomcustomer.signed.TradeDirectActivity;
import com.ziroom.ziroomcustomer.signed.a.p;
import com.ziroom.ziroomcustomer.social.model.o;
import com.ziroom.ziroomcustomer.social.model.u.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.s;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import com.ziroom.ziroomcustomer.ziroomstation.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ZzSocialChangeBaseMessageActivity
  extends BaseActivity
{
  private int A = 0;
  private String B = "";
  private List<String> C = new ArrayList();
  private ViewTreeObserver.OnGlobalLayoutListener D = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public void onGlobalLayout()
    {
      if (ZzSocialChangeBaseMessageActivity.f(ZzSocialChangeBaseMessageActivity.this).getRootView().getHeight() - ZzSocialChangeBaseMessageActivity.f(ZzSocialChangeBaseMessageActivity.this).getHeight() <= ZzSocialChangeBaseMessageActivity.this.getWindow().findViewById(16908290).getTop())
      {
        ZzSocialChangeBaseMessageActivity.this.btn.setVisibility(0);
        return;
      }
      ZzSocialChangeBaseMessageActivity.this.btn.setVisibility(8);
    }
  };
  private boolean E = false;
  private ViewGroup F;
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
  @BindView(2131690002)
  EditText etRemark;
  private String f;
  private String g;
  @BindView(2131693056)
  SimpleDraweeView ivImage;
  @BindView(2131693063)
  View ivReset;
  @BindView(2131693057)
  LinearLayout llAddPhoto;
  @BindView(2131692247)
  LinearLayout llAddress;
  @BindView(2131690635)
  LinearLayout llCompany;
  @BindView(2131689847)
  LinearLayout llType;
  @BindView(2131693067)
  FlowLayout mFlTag;
  @BindView(2131693066)
  TextView mTvTagDesc;
  @BindView(2131690279)
  View mViewAdd;
  private int r;
  @BindView(2131690402)
  FrameLayout rlDescInfo;
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
  @BindView(2131690403)
  TextView tvCurrentNum;
  @BindView(2131690404)
  TextView tvMaxNum;
  @BindView(2131693064)
  TextView tvReset;
  @BindView(2131689541)
  TextView tvTitle;
  @BindView(2131689848)
  TextView tvType;
  private String u;
  private String v;
  @BindView(2131691494)
  View vLineBottom;
  private int w;
  private String x;
  private o y;
  private boolean z = false;
  
  private void b()
  {
    this.etRemark.addTextChangedListener(new TextWatcher()
    {
      private CharSequence b;
      private int c;
      private int d;
      
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        ZzSocialChangeBaseMessageActivity.this.tvCurrentNum.setText("" + paramAnonymousEditable.length());
        this.c = ZzSocialChangeBaseMessageActivity.this.etRemark.getSelectionStart();
        this.d = ZzSocialChangeBaseMessageActivity.this.etRemark.getSelectionEnd();
        if (this.b.length() > 100)
        {
          paramAnonymousEditable.delete(this.c - 1, this.d);
          int i = this.d;
          ZzSocialChangeBaseMessageActivity.this.etRemark.setText(paramAnonymousEditable);
          ZzSocialChangeBaseMessageActivity.this.etRemark.setSelection(i);
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.b = paramAnonymousCharSequence;
      }
    });
    n.requestGetUserInfo(this, "", new com.ziroom.ziroomcustomer.e.a.d(this, new f(com.ziroom.ziroomcustomer.social.model.u.class))
    {
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.social.model.u paramAnonymousu)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousu);
        if (paramAnonymousu == null) {
          return;
        }
        ZzSocialChangeBaseMessageActivity.this.etName.setText(paramAnonymousu.getNick_name());
        if (ae.notNull(paramAnonymousu.getHead_img()))
        {
          ZzSocialChangeBaseMessageActivity.this.ivImage.setVisibility(0);
          ZzSocialChangeBaseMessageActivity.this.llAddPhoto.setVisibility(8);
          ZzSocialChangeBaseMessageActivity.this.ivImage.setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousu.getHead_img()));
          ZzSocialChangeBaseMessageActivity.a(ZzSocialChangeBaseMessageActivity.this, paramAnonymousu.getHead_img());
          ZzSocialChangeBaseMessageActivity.this.tvCompany.setText(paramAnonymousu.getCompany());
          ZzSocialChangeBaseMessageActivity.this.tvType.setText(paramAnonymousu.getIndustry());
          ZzSocialChangeBaseMessageActivity.this.tvAddress.setText(paramAnonymousu.getCity() + paramAnonymousu.getBizcircle());
          ZzSocialChangeBaseMessageActivity.this.etRemark.setText(paramAnonymousu.getDescription());
          ZzSocialChangeBaseMessageActivity.b(ZzSocialChangeBaseMessageActivity.this, paramAnonymousu.getCompany());
          ZzSocialChangeBaseMessageActivity.c(ZzSocialChangeBaseMessageActivity.this, paramAnonymousu.getCompany_short());
          ZzSocialChangeBaseMessageActivity.a(ZzSocialChangeBaseMessageActivity.this, paramAnonymousu.getCompany_id());
          ZzSocialChangeBaseMessageActivity.d(ZzSocialChangeBaseMessageActivity.this, paramAnonymousu.getIndustry());
          ZzSocialChangeBaseMessageActivity.b(ZzSocialChangeBaseMessageActivity.this, paramAnonymousu.getIndustry_id());
          ZzSocialChangeBaseMessageActivity.e(ZzSocialChangeBaseMessageActivity.this, paramAnonymousu.getDirection());
          ZzSocialChangeBaseMessageActivity.c(ZzSocialChangeBaseMessageActivity.this, paramAnonymousu.getDirection_id());
          ZzSocialChangeBaseMessageActivity.f(ZzSocialChangeBaseMessageActivity.this, paramAnonymousu.getBirthday());
          ZzSocialChangeBaseMessageActivity.g(ZzSocialChangeBaseMessageActivity.this, paramAnonymousu.getAge());
          ZzSocialChangeBaseMessageActivity.d(ZzSocialChangeBaseMessageActivity.this, paramAnonymousu.getGender());
          ZzSocialChangeBaseMessageActivity.a(ZzSocialChangeBaseMessageActivity.this, new o());
          ZzSocialChangeBaseMessageActivity.a(ZzSocialChangeBaseMessageActivity.this).setCity_name(paramAnonymousu.getCity());
          ZzSocialChangeBaseMessageActivity.a(ZzSocialChangeBaseMessageActivity.this).setBizcircle_name(paramAnonymousu.getBizcircle());
          if ((paramAnonymousu.getTags() == null) || (paramAnonymousu.getTags().size() <= 0)) {
            break label645;
          }
          ZzSocialChangeBaseMessageActivity.this.mTvTagDesc.setVisibility(8);
          ZzSocialChangeBaseMessageActivity.this.mFlTag.setVisibility(0);
          ZzSocialChangeBaseMessageActivity.b(ZzSocialChangeBaseMessageActivity.this).clear();
          paramAnonymousInt = 0;
          label382:
          if (paramAnonymousInt >= paramAnonymousu.getTags().size()) {
            break label571;
          }
          ZzSocialChangeBaseMessageActivity.b(ZzSocialChangeBaseMessageActivity.this).add(((u.a)paramAnonymousu.getTags().get(paramAnonymousInt)).getName());
          if (!TextUtils.isEmpty(ZzSocialChangeBaseMessageActivity.c(ZzSocialChangeBaseMessageActivity.this))) {
            break label512;
          }
          ZzSocialChangeBaseMessageActivity.h(ZzSocialChangeBaseMessageActivity.this, ((u.a)paramAnonymousu.getTags().get(0)).getId() + "");
        }
        for (;;)
        {
          paramAnonymousInt += 1;
          break label382;
          ZzSocialChangeBaseMessageActivity.this.ivImage.setVisibility(8);
          ZzSocialChangeBaseMessageActivity.this.llAddPhoto.setVisibility(0);
          break;
          label512:
          if (paramAnonymousInt > 0) {
            ZzSocialChangeBaseMessageActivity.h(ZzSocialChangeBaseMessageActivity.this, ZzSocialChangeBaseMessageActivity.c(ZzSocialChangeBaseMessageActivity.this) + "," + ((u.a)paramAnonymousu.getTags().get(paramAnonymousInt)).getId());
          }
        }
        label571:
        j.addZzSocialFlke(ZzSocialChangeBaseMessageActivity.this, ZzSocialChangeBaseMessageActivity.b(ZzSocialChangeBaseMessageActivity.this), ZzSocialChangeBaseMessageActivity.this.mFlTag);
        if (ZzSocialChangeBaseMessageActivity.this.mFlTag.getChildCount() > 3) {
          ZzSocialChangeBaseMessageActivity.this.mViewAdd.setVisibility(0);
        }
        for (;;)
        {
          ZzSocialChangeBaseMessageActivity.e(ZzSocialChangeBaseMessageActivity.this, paramAnonymousu.getGender());
          return;
          ZzSocialChangeBaseMessageActivity.this.mViewAdd.setVisibility(8);
          continue;
          label645:
          ZzSocialChangeBaseMessageActivity.this.mViewAdd.setVisibility(8);
          ZzSocialChangeBaseMessageActivity.this.mTvTagDesc.setVisibility(0);
          ZzSocialChangeBaseMessageActivity.this.mFlTag.setVisibility(8);
        }
      }
    });
  }
  
  private void d(String paramString)
  {
    n.UploadPic(this, com.ziroom.commonlibrary.login.a.getToken(this), new File(paramString), 1, new com.ziroom.ziroomcustomer.e.a.c(this, new q(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        ZzSocialChangeBaseMessageActivity.a(ZzSocialChangeBaseMessageActivity.this, (String)com.alibaba.fastjson.a.parseObject(paramAnonymousString).get("url"));
        if (ae.notNull(ZzSocialChangeBaseMessageActivity.d(ZzSocialChangeBaseMessageActivity.this)))
        {
          ZzSocialChangeBaseMessageActivity.this.ivImage.setController(com.freelxl.baselibrary.f.c.frescoController(ZzSocialChangeBaseMessageActivity.d(ZzSocialChangeBaseMessageActivity.this)));
          ZzSocialChangeBaseMessageActivity.this.ivImage.setVisibility(0);
          ZzSocialChangeBaseMessageActivity.this.llAddPhoto.setVisibility(8);
          if (ZzSocialChangeBaseMessageActivity.e(ZzSocialChangeBaseMessageActivity.this))
          {
            ZzSocialChangeBaseMessageActivity.a(ZzSocialChangeBaseMessageActivity.this, false);
            ZzSocialChangeBaseMessageActivity.this.tvReset.setVisibility(8);
            ZzSocialChangeBaseMessageActivity.this.ivReset.setVisibility(8);
            ZzSocialChangeBaseMessageActivity.this.tvTitle.setTextColor(Color.parseColor("#999999"));
            ZzSocialChangeBaseMessageActivity.this.tvTitle.setText("封面照需为本人真实照片");
          }
        }
      }
    });
  }
  
  private void e()
  {
    if (this.z)
    {
      com.ziroom.commonlibrary.widget.unifiedziroom.e.newBuilder(this).setTitle("提示").setContent("头像未通过，请重新上传！").build().show();
      return;
    }
    if (VdsAgent.trackEditTextSilent(this.etRemark).toString().length() < 15)
    {
      g.textToast(this, "描述文案最少需要15个字");
      return;
    }
    if (ae.isNull(VdsAgent.trackEditTextSilent(this.etName).toString()))
    {
      g.textToast(this, "请输入昵称");
      return;
    }
    if (ae.isNull(this.u))
    {
      g.textToast(this, "请上传封面照片");
      return;
    }
    if ((this.y == null) || (ae.isNull(this.tvAddress.getText().toString())))
    {
      g.textToast(this, "请选择圈子");
      return;
    }
    n.saveUserInfo(this, VdsAgent.trackEditTextSilent(this.etName).toString(), this.x, this.w, this.y.getCity_name(), this.y.getBizcircle_name(), this.u, VdsAgent.trackEditTextSilent(this.etRemark).toString(), this.r, this.d, this.e, this.f, this.s, this.g, this.t, this.B, new com.ziroom.ziroomcustomer.e.a.d(this, new com.ziroom.ziroomcustomer.e.c.d())
    {
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        ApplicationEx.c.getUser().setHeadImg(ZzSocialChangeBaseMessageActivity.d(ZzSocialChangeBaseMessageActivity.this));
        ApplicationEx.c.getUser().setNickName(VdsAgent.trackEditTextSilent(ZzSocialChangeBaseMessageActivity.this.etName).toString());
        ZzSocialChangeBaseMessageActivity.this.setResult(-1);
        ZzSocialChangeBaseMessageActivity.this.finish();
      }
    });
  }
  
  private void f()
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
        paramAnonymousView = com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(ZzSocialChangeBaseMessageActivity.this, false, 0, true, 400, 400);
        ZzSocialChangeBaseMessageActivity.this.startActivityForResult(paramAnonymousView, 16);
        localDialog.dismiss();
      }
    });
    localView.findViewById(2131693933).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(ZzSocialChangeBaseMessageActivity.this, ZzSocialBigPicsActivity.class);
        paramAnonymousView.putExtra("imageUrls", new String[] { ZzSocialChangeBaseMessageActivity.d(ZzSocialChangeBaseMessageActivity.this) });
        paramAnonymousView.putExtra("currentImageIndex", 0);
        ZzSocialChangeBaseMessageActivity.this.startActivity(paramAnonymousView);
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
  
  protected void a()
  {
    if (this.E) {
      return;
    }
    this.F = ((ViewGroup)findViewById(2131690936));
    this.F.getViewTreeObserver().addOnGlobalLayoutListener(this.D);
    this.E = true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    label213:
    do
    {
      do
      {
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
                paramIntent = this.a.getName();
                if (!s.isEmpty(this.a.getAspects()))
                {
                  this.b = ((p)this.a.getAspects().get(this.c));
                  str = this.b.getName();
                  if (TextUtils.isEmpty(str)) {
                    break label213;
                  }
                  paramIntent = paramIntent + "/" + str;
                }
                for (;;)
                {
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
                this.s = Integer.parseInt(paramIntent.getId());
                this.tvCompany.setText(str);
                this.f = paramIntent.getBrand();
                return;
              }
            } while (TextUtils.isEmpty(paramIntent));
            this.e = paramIntent;
            this.tvCompany.setText(paramIntent);
            return;
          } while (paramInt2 != 21);
          this.y = ((o)paramIntent.getSerializableExtra("address"));
        } while (this.y == null);
        this.tvAddress.setText(this.y.getCity_name() + this.y.getBizcircle_name());
        return;
      } while (paramInt2 != -1);
      this.B = paramIntent.getStringExtra("tags");
      this.C = com.alibaba.fastjson.e.parseArray(paramIntent.getStringExtra("tagList"), String.class);
    } while ((this.C == null) || (this.C.size() <= 0));
    this.mTvTagDesc.setVisibility(8);
    this.mFlTag.setVisibility(0);
    this.mFlTag.removeAllViews();
    j.addZzSocialFlke(this, this.C, this.mFlTag);
    com.ziroom.ziroomcustomer.util.u.d("sdgkljsd", "======== " + this.mFlTag.getmLineHeight().size());
    if (this.mFlTag.getChildCount() > 3)
    {
      this.mViewAdd.setVisibility(0);
      return;
    }
    this.mViewAdd.setVisibility(8);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903625);
    ButterKnife.bind(this);
    paramBundle = getIntent().getStringExtra("title");
    String str = getIntent().getStringExtra("des");
    this.z = getIntent().getBooleanExtra("isReset", false);
    this.tvTitle.setText(paramBundle);
    if (this.z)
    {
      this.tvReset.setVisibility(0);
      this.ivReset.setVisibility(0);
      this.tvTitle.setTextColor(Color.parseColor("#FF6262"));
      this.tvTitle.setText("头像未通过，封面照需为本人真实照片");
    }
    this.etRemark.setHint(str);
    a();
    this.vLineBottom.setAlpha(0.0F);
    this.svContent.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        ZzSocialChangeBaseMessageActivity.this.vLineBottom.setAlpha(f);
      }
    });
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.E) {
      this.F.getViewTreeObserver().removeGlobalOnLayoutListener(this.D);
    }
  }
  
  @OnClick({2131692247, 2131690078, 2131693057, 2131690635, 2131689847, 2131690043, 2131693056, 2131693064, 2131693065})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131692247: 
      paramView = new Intent(this, ZzSocialMyAddressActivity.class);
      paramView.putExtra("address", this.y);
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
          break label257;
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
      e();
      return;
    case 2131693056: 
      f();
      return;
    case 2131693064: 
      label257:
      startActivityForResult(com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(this, false, 0, true, 400, 400), 16);
      return;
    }
    if (this.A == 0)
    {
      g.textToast(this, "数据刷新中");
      return;
    }
    paramView = new Intent(this, ZzSocialSelectTagActivity.class);
    paramView.putExtra("gender", this.A);
    if (this.C != null)
    {
      if (this.C.size() != 0) {
        break label388;
      }
      paramView.putExtra("selectTagList", "");
    }
    for (;;)
    {
      startActivityForResult(paramView, 22);
      return;
      label388:
      if (this.C.size() > 0) {
        paramView.putExtra("selectTagList", com.alibaba.fastjson.a.toJSONString(this.C));
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialChangeBaseMessageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */