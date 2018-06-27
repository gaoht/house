package com.ziroom.ziroomcustomer.social.activity.ac;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.e;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.selfsetting.SelfSettingActivity;
import com.ziroom.ziroomcustomer.social.model.AcEnrollSuccess;
import com.ziroom.ziroomcustomer.social.model.d;
import com.ziroom.ziroomcustomer.social.model.i;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AcEnrollActivity
  extends BaseActivity
{
  private String a;
  private String b;
  private boolean c;
  private String d;
  private a e;
  private com.ziroom.ziroomcustomer.e.a.f<d> f = new com.ziroom.ziroomcustomer.e.a.f(this, new com.ziroom.ziroomcustomer.e.c.f(d.class))
  {
    public void onSuccess(int paramAnonymousInt, d paramAnonymousd)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousd);
      if (paramAnonymousd != null)
      {
        Object localObject = paramAnonymousd.getUser();
        if (localObject != null)
        {
          AcEnrollActivity.this.mEtName.setText(((i)localObject).getNick_name());
          AcEnrollActivity.this.mEtPhone.setText(((i)localObject).getPhone());
          AcEnrollActivity.this.mEtWeixin.setText(((i)localObject).getWeixin());
        }
        localObject = paramAnonymousd.getQuestion();
        if ((localObject == null) || (((List)localObject).size() <= 0)) {
          break label219;
        }
        AcEnrollActivity.this.mLlQuestion.setVisibility(0);
        AcEnrollActivity.a(AcEnrollActivity.this, new AcEnrollActivity.a(AcEnrollActivity.this, (List)localObject));
        AcEnrollActivity.this.mLvfsvQuestion.setAdapter(AcEnrollActivity.a(AcEnrollActivity.this));
        paramAnonymousd = paramAnonymousd.getLife_photo();
        if ((paramAnonymousd == null) || (1 != paramAnonymousd.getUse())) {
          break label234;
        }
        AcEnrollActivity.a(AcEnrollActivity.this, true);
        AcEnrollActivity.this.itemUploadPhoto.setVisibility(0);
        AcEnrollActivity.this.tvPhotoTitle.setText(((List)localObject).size() + 1 + "." + paramAnonymousd.getTitle());
      }
      for (;;)
      {
        AcEnrollActivity.this.mBtnSubmit.setEnabled(true);
        return;
        label219:
        AcEnrollActivity.this.mLlQuestion.setVisibility(8);
        break;
        label234:
        AcEnrollActivity.this.itemUploadPhoto.setVisibility(8);
      }
    }
  };
  @BindView(2131694519)
  FrameLayout flPhotoArea;
  private com.ziroom.ziroomcustomer.e.a.f<AcEnrollSuccess> g = new com.ziroom.ziroomcustomer.e.a.f(this, new com.ziroom.ziroomcustomer.e.c.f(AcEnrollSuccess.class))
  {
    public void onSuccess(int paramAnonymousInt, AcEnrollSuccess paramAnonymousAcEnrollSuccess)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousAcEnrollSuccess);
      if (paramAnonymousAcEnrollSuccess == null) {
        return;
      }
      Intent localIntent = new Intent(AcEnrollActivity.this, AcEnrollSuccessActivity.class);
      localIntent.putExtra("success", paramAnonymousAcEnrollSuccess);
      localIntent.putExtra("cityCode", AcEnrollActivity.b(AcEnrollActivity.this));
      AcEnrollActivity.this.startActivityAndFinish(localIntent);
    }
  };
  @BindView(2131689815)
  View itemUploadPhoto;
  @BindView(2131694520)
  ImageView ivPhotoBackgraoud;
  @BindView(2131689816)
  Button mBtnSubmit;
  @BindView(2131689810)
  EditText mEtName;
  @BindView(2131689811)
  EditText mEtPhone;
  @BindView(2131689812)
  EditText mEtWeixin;
  @BindView(2131689813)
  LinearLayout mLlQuestion;
  @BindView(2131689814)
  ListViewForScrollView mLvfsvQuestion;
  @BindView(2131689809)
  SimpleDraweeView sdvMyIcon;
  @BindView(2131694521)
  SimpleDraweeView sdvPhotoSelected;
  @BindView(2131694518)
  TextView tvPhotoTitle;
  
  private void a()
  {
    this.mEtName.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable != null) {
          AcEnrollActivity.this.mEtName.setSelection(paramAnonymousEditable.length());
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.mEtPhone.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable != null) {
          AcEnrollActivity.this.mEtPhone.setSelection(paramAnonymousEditable.length());
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    b();
  }
  
  private void a(Class paramClass)
  {
    if (ApplicationEx.c.isLoginState())
    {
      startActivity(new Intent(this, paramClass));
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this);
  }
  
  private void b()
  {
    if (ApplicationEx.c.isLoginState())
    {
      UserInfo localUserInfo = ApplicationEx.c.getUser();
      if (localUserInfo != null) {
        d(localUserInfo.getHead_img());
      }
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this);
  }
  
  private void d(String paramString)
  {
    GenericDraweeHierarchy localGenericDraweeHierarchy = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(300).setPlaceholderImage(2130840439).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setFailureImage(2130840439).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build();
    RoundingParams localRoundingParams = new RoundingParams();
    localRoundingParams.setRoundAsCircle(true);
    localGenericDraweeHierarchy.setRoundingParams(localRoundingParams);
    this.sdvMyIcon.setHierarchy(localGenericDraweeHierarchy);
    this.sdvMyIcon.setController(c.frescoController(paramString));
  }
  
  private void e()
  {
    this.a = getIntent().getStringExtra("acCode");
    this.b = getIntent().getStringExtra("cityCode");
    j.acEnrollData(this, this.a, this.f);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    String str2;
    do
    {
      do
      {
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      str2 = paramIntent.getStringExtra("path");
    } while (TextUtils.isEmpty(str2));
    File localFile = new File(str2);
    paramIntent = null;
    if ((localFile.isFile()) && (localFile.exists()))
    {
      try
      {
        localFile = r.zoomImageWithQuality(new File(str2), 2048);
        paramIntent = localFile;
        if (localFile != null) {
          break label169;
        }
        dismissProgress();
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      finally
      {
        if (0 == 0)
        {
          dismissProgress();
          return;
        }
      }
    }
    else
    {
      g.textToast(this, "当前图片不存在！");
      dismissProgress();
      return;
    }
    label169:
    String str1 = com.ziroom.commonlibrary.login.a.getToken(this);
    if (paramIntent != null) {}
    for (;;)
    {
      j.uploadPhotoCommon(this, str1, paramIntent, new com.ziroom.ziroomcustomer.e.a.f(this, new o())
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          af.showToast(AcEnrollActivity.this, "上传失败，请稍候再试");
          AcEnrollActivity.this.sdvPhotoSelected.setVisibility(8);
        }
        
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          AcEnrollActivity.a(AcEnrollActivity.this, paramAnonymouse.getString("url"));
          AcEnrollActivity.this.sdvPhotoSelected.setVisibility(0);
          AcEnrollActivity.this.sdvPhotoSelected.setController(c.frescoController(AcEnrollActivity.c(AcEnrollActivity.this)));
        }
      });
      return;
      paramIntent = new File(str2);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903079);
    ButterKnife.bind(this);
    a();
    e();
  }
  
  protected void onResume()
  {
    super.onResume();
    b();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689809: 
      a(SelfSettingActivity.class);
      return;
    case 2131689816: 
      String str1 = VdsAgent.trackEditTextSilent(this.mEtName).toString().trim();
      String str2 = VdsAgent.trackEditTextSilent(this.mEtPhone).toString().trim();
      String str3 = VdsAgent.trackEditTextSilent(this.mEtWeixin).toString().trim();
      if (TextUtils.isEmpty(str1))
      {
        g.textToast(this, "请填写用户昵称");
        return;
      }
      if (TextUtils.isEmpty(str2))
      {
        g.textToast(this, "请填写手机号");
        return;
      }
      if ((str2.length() != 11) || (!ah.isMobile(str2)))
      {
        g.textToast(this, "请填写正确的手机号");
        return;
      }
      if (TextUtils.isEmpty(str3))
      {
        g.textToast(this, "请填写微信号");
        return;
      }
      paramView = null;
      if (this.e != null)
      {
        List localList = this.e.getAnswers();
        if ((localList != null) && (localList.size() >= this.e.getCount()))
        {
          paramView = localList;
          if (!localList.contains("")) {}
        }
        else
        {
          g.textToast(this, "请填写筛选问题答案");
          return;
        }
      }
      if ((this.c) && (ae.isNull(this.d)))
      {
        g.textToast(this, "请上传靓照哦~");
        return;
      }
      j.acEnrollSubmit(this, this.a, str1, str2, paramView, str3, this.d, this.g);
      return;
    case 2131689492: 
      finish();
      return;
    }
    startActivityForResult(com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(this, false, 1, false, 0, 0), 1);
  }
  
  private class a
    extends BaseAdapter
  {
    private List<String> b;
    private List<String> c;
    private LayoutInflater d;
    
    public a()
    {
      String str;
      this.b = str;
      this.d = LayoutInflater.from(AcEnrollActivity.this);
      this.c = new ArrayList();
      if ((this.b != null) && (this.b.size() > 0))
      {
        this$1 = this.b.iterator();
        while (AcEnrollActivity.this.hasNext())
        {
          str = (String)AcEnrollActivity.this.next();
          this.c.add("");
        }
      }
    }
    
    public List<String> getAnswers()
    {
      return this.c;
    }
    
    public int getCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = this.d.inflate(2130904114, paramViewGroup, false);
      paramViewGroup = (TextView)paramView.findViewById(2131690409);
      final EditText localEditText = (EditText)paramView.findViewById(2131694809);
      localEditText.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          if ((paramAnonymousEditable != null) && (paramAnonymousEditable.length() > 300))
          {
            localEditText.setText(paramAnonymousEditable.subSequence(0, 300));
            localEditText.setSelection(300);
          }
          for (;;)
          {
            AcEnrollActivity.a.a(AcEnrollActivity.a.this).set(paramInt, paramAnonymousEditable.toString());
            return;
            if ((paramAnonymousEditable != null) && (paramAnonymousEditable.length() > 0)) {
              this.b.setText(paramAnonymousEditable.length() + "/300");
            } else {
              this.b.setText("");
            }
          }
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      String str1 = (String)getItem(paramInt);
      String str2 = (String)this.c.get(paramInt);
      paramViewGroup.setText(paramInt + 1 + "." + str1);
      if (TextUtils.isEmpty(str2))
      {
        localEditText.setText("");
        return paramView;
      }
      localEditText.setText(str2);
      return paramView;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/ac/AcEnrollActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */