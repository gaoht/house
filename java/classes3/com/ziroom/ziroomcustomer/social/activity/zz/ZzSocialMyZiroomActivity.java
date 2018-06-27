package com.ziroom.ziroomcustomer.social.activity.zz;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
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
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.e;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.q;
import com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ZzSocialMyZiroomActivity
  extends BaseActivity
{
  private List<String> a = new ArrayList();
  private ViewTreeObserver.OnGlobalLayoutListener b = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public void onGlobalLayout()
    {
      if (ZzSocialMyZiroomActivity.c(ZzSocialMyZiroomActivity.this).getRootView().getHeight() - ZzSocialMyZiroomActivity.c(ZzSocialMyZiroomActivity.this).getHeight() <= ZzSocialMyZiroomActivity.this.getWindow().findViewById(16908290).getTop())
      {
        ZzSocialMyZiroomActivity.this.btn.setVisibility(0);
        return;
      }
      ZzSocialMyZiroomActivity.this.btn.setVisibility(8);
    }
  };
  @BindView(2131690043)
  Button btn;
  @BindView(2131690078)
  ImageView btnBack;
  private boolean c = false;
  private ViewGroup d;
  @BindView(2131690002)
  EditText etRemark;
  @BindView(2131691480)
  FrameLayout flPhoto;
  @BindView(2131693057)
  LinearLayout llAddPhoto;
  @BindView(2131690402)
  FrameLayout rlDescInfo;
  @BindView(2131689808)
  RelativeLayout rlTitle;
  @BindView(2131690150)
  ObservableScrollView svContent;
  @BindView(2131690403)
  TextView tvCurrentNum;
  @BindView(2131690404)
  TextView tvMaxNum;
  @BindView(2131691494)
  View vLineBottom;
  
  private void b()
  {
    this.flPhoto.removeViews(0, this.flPhoto.getChildCount() - 1);
    int k = (b.getScreenWidth(this) - ah.dip2px(this, 54.0F)) / 2;
    int m;
    Object localObject1;
    label113:
    Object localObject2;
    if (this.a.size() == 6)
    {
      i = 6;
      j = i / 2;
      m = i / 2;
      int n = ah.dip2px(this, 6.0F);
      int i1 = ah.dip2px(this, 24.0F);
      localObject1 = new LinearLayout.LayoutParams(b.getScreenWidth(this), m * n + (j + i % 2) * k + i1);
      this.flPhoto.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i = 0;
      if (i >= this.a.size()) {
        break label363;
      }
      localObject2 = new FrameLayout.LayoutParams(k, k);
      localObject1 = new SimpleDraweeView(this);
      if (i / 2 <= 0) {
        break label353;
      }
      j = i / 2 * ah.dip2px(this, 6.0F);
      label164:
      ((SimpleDraweeView)localObject1).setTranslationY(j + i / 2 * k + ah.dip2px(this, 24.0F));
      if (i % 2 != 1) {
        break label358;
      }
    }
    label353:
    label358:
    for (int j = ah.dip2px(this, 6.0F) + k;; j = 0)
    {
      ((SimpleDraweeView)localObject1).setTranslationX(j + ah.dip2px(this, 24.0F));
      ((SimpleDraweeView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(300).build();
      RoundingParams localRoundingParams = new RoundingParams();
      localRoundingParams.setCornersRadius(com.ziroom.ziroomcustomer.util.n.dip2px(this, 2.0F));
      ((GenericDraweeHierarchy)localObject2).setRoundingParams(localRoundingParams);
      ((SimpleDraweeView)localObject1).setHierarchy((DraweeHierarchy)localObject2);
      ((SimpleDraweeView)localObject1).setController(com.freelxl.baselibrary.f.c.frescoController((String)this.a.get(i)));
      this.flPhoto.addView((View)localObject1, i);
      ((SimpleDraweeView)localObject1).setTag(Integer.valueOf(i));
      ((SimpleDraweeView)localObject1).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ZzSocialMyZiroomActivity.a(ZzSocialMyZiroomActivity.this, ((Integer)paramAnonymousView.getTag()).intValue());
        }
      });
      i += 1;
      break label113;
      i = this.a.size() + 1;
      break;
      j = 0;
      break label164;
    }
    label363:
    if (this.a.size() == 6)
    {
      this.llAddPhoto.setVisibility(8);
      if (this.llAddPhoto.getVisibility() == 0)
      {
        localObject1 = new FrameLayout.LayoutParams(k, k);
        this.llAddPhoto.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        i = this.a.size() / 2;
        j = ah.dip2px(this, 6.0F);
        m = ah.dip2px(this, 24.0F);
        this.llAddPhoto.setTranslationY(i * (j + k) + m);
        if (this.a.size() % 2 != 0) {
          break label508;
        }
      }
    }
    label508:
    for (int i = ah.dip2px(this, 24.0F);; i = ah.dip2px(this, 30.0F) + k)
    {
      this.llAddPhoto.setTranslationX(i);
      this.flPhoto.requestLayout();
      return;
      this.llAddPhoto.setVisibility(0);
      break;
    }
  }
  
  private void b(final int paramInt)
  {
    final Dialog localDialog = new Dialog(this, 2131427565);
    View localView = LayoutInflater.from(this).inflate(2130903877, null);
    localView.findViewById(2131693932).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ZzSocialMyZiroomActivity.a(ZzSocialMyZiroomActivity.this).remove(paramInt);
        localDialog.dismiss();
        ZzSocialMyZiroomActivity.b(ZzSocialMyZiroomActivity.this);
      }
    });
    localView.findViewById(2131693933).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new String[ZzSocialMyZiroomActivity.a(ZzSocialMyZiroomActivity.this).size()];
        int i = 0;
        while (i < ZzSocialMyZiroomActivity.a(ZzSocialMyZiroomActivity.this).size())
        {
          paramAnonymousView[i] = ((String)ZzSocialMyZiroomActivity.a(ZzSocialMyZiroomActivity.this).get(i));
          i += 1;
        }
        Intent localIntent = new Intent(ZzSocialMyZiroomActivity.this, ZzSocialBigPicsActivity.class);
        localIntent.putExtra("imageUrls", paramAnonymousView);
        localIntent.putExtra("currentImageIndex", paramInt);
        ZzSocialMyZiroomActivity.this.startActivity(localIntent);
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
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    localLayoutParams.width = getResources().getDisplayMetrics().widthPixels;
    localView.setLayoutParams(localLayoutParams);
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
    com.ziroom.ziroomcustomer.e.n.UploadPic(this, com.ziroom.commonlibrary.login.a.getToken(this), new File(paramString), 0, new com.ziroom.ziroomcustomer.e.a.c(this, new q(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        paramAnonymousString = (String)com.alibaba.fastjson.a.parseObject(paramAnonymousString).get("url");
        ZzSocialMyZiroomActivity.a(ZzSocialMyZiroomActivity.this).add(paramAnonymousString);
        ZzSocialMyZiroomActivity.b(ZzSocialMyZiroomActivity.this);
        if (ZzSocialMyZiroomActivity.a(ZzSocialMyZiroomActivity.this).size() == 6) {
          ZzSocialMyZiroomActivity.this.llAddPhoto.setVisibility(8);
        }
      }
    });
  }
  
  private void e()
  {
    this.etRemark.addTextChangedListener(new TextWatcher()
    {
      private CharSequence b;
      private int c;
      private int d;
      
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        ZzSocialMyZiroomActivity.this.tvCurrentNum.setText("" + paramAnonymousEditable.length());
        this.c = ZzSocialMyZiroomActivity.this.etRemark.getSelectionStart();
        this.d = ZzSocialMyZiroomActivity.this.etRemark.getSelectionEnd();
        if (this.b.length() > 200)
        {
          paramAnonymousEditable.delete(this.c - 1, this.d);
          int i = this.d;
          ZzSocialMyZiroomActivity.this.etRemark.setText(paramAnonymousEditable);
          ZzSocialMyZiroomActivity.this.etRemark.setSelection(i);
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.b = paramAnonymousCharSequence;
      }
    });
  }
  
  private void f()
  {
    if (VdsAgent.trackEditTextSilent(this.etRemark).toString().length() < 20)
    {
      g.textToast(this, "描述文案最少需要20个字");
      return;
    }
    if (this.a.size() == 0)
    {
      g.textToast(this, "照片不能为空");
      return;
    }
    Object localObject = "";
    int i = 0;
    while (i < this.a.size())
    {
      String str = (String)this.a.get(i);
      str = (String)localObject + str;
      localObject = str;
      if (i != this.a.size() - 1) {
        localObject = str + ",";
      }
      i += 1;
    }
    com.ziroom.ziroomcustomer.e.n.saveUserHomeInfo(this, (String)localObject, VdsAgent.trackEditTextSilent(this.etRemark).toString(), new com.ziroom.ziroomcustomer.e.a.d(this, new com.ziroom.ziroomcustomer.e.c.d())
    {
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        ZzSocialMyZiroomActivity.this.setResult(-1);
        ZzSocialMyZiroomActivity.this.finish();
      }
    });
  }
  
  protected void a()
  {
    if (this.c) {
      return;
    }
    this.d = ((ViewGroup)findViewById(2131690936));
    this.d.getViewTreeObserver().addOnGlobalLayoutListener(this.b);
    this.c = true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramIntent == null);
    d(paramIntent.getStringExtra("path"));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903633);
    ButterKnife.bind(this);
    a();
    this.vLineBottom.setAlpha(0.0F);
    this.svContent.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        ZzSocialMyZiroomActivity.this.vLineBottom.setAlpha(f);
      }
    });
    e();
    paramBundle = getIntent().getStringExtra("des");
    getIntent().getStringExtra("remark");
    this.etRemark.setHint("请输入至少20字的描述文案");
    this.etRemark.setText(paramBundle);
    paramBundle = getIntent().getStringArrayListExtra("photos");
    if (paramBundle != null)
    {
      int i = 0;
      while (i < paramBundle.size())
      {
        this.a.add(paramBundle.get(i));
        i += 1;
      }
      b();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.c) {
      this.d.getViewTreeObserver().removeGlobalOnLayoutListener(this.b);
    }
  }
  
  @OnClick({2131690078, 2131693057, 2131690043})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690078: 
      finish();
      return;
    case 2131693057: 
      startActivityForResult(com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(this, false, 0, false, 400, 400), 16);
      return;
    }
    f();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialMyZiroomActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */