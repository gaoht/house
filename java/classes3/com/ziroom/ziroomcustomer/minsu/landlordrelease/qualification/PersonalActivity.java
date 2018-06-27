package com.ziroom.ziroomcustomer.minsu.landlordrelease.qualification;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuUploadPicBean;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.p;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.CustomerInfoBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.CustomerInfoBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.CustomerInfoBean.DataBean.PictruesBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.CommonSaveDescInfoActivity;
import com.ziroom.ziroomcustomer.util.ae;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PersonalActivity
  extends BaseFluxActivity
{
  Uri b;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.d.b c;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.c d;
  private Unbinder e;
  @BindView(2131691057)
  EditText et_nickname;
  @BindView(2131691058)
  EditText et_personal;
  private CustomerInfoBean f;
  private List<String> g;
  @BindView(2131691055)
  SimpleDraweeView head_pic;
  private List<String> r = new ArrayList();
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.d s;
  private e t;
  @BindView(2131690401)
  TextView tv_info_save;
  private String u;
  private String v;
  private boolean w = false;
  private TextWatcher x = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      PersonalActivity.this.validateInput();
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      PersonalActivity.a(PersonalActivity.this, true);
    }
  };
  
  private void a()
  {
    int i = com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenWidth(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    this.head_pic.setLayoutParams(localLayoutParams);
    com.freelxl.baselibrary.f.c.frescoHierarchyController(this.head_pic, ScalingUtils.ScaleType.FIT_CENTER, 2130839084);
    this.et_nickname.addTextChangedListener(this.x);
    this.et_personal.addTextChangedListener(this.x);
  }
  
  private void a(File paramFile, final int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.uploadImg(this, paramFile, paramInt, new com.ziroom.ziroomcustomer.minsu.f.s(this, new p(MinsuUploadPicBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuUploadPicBean paramAnonymousMinsuUploadPicBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuUploadPicBean);
        if (paramAnonymousMinsuUploadPicBean != null)
        {
          PersonalActivity.a(PersonalActivity.this, new e());
          PersonalActivity.b(PersonalActivity.this).put("picType", Integer.valueOf(paramInt));
          PersonalActivity.b(PersonalActivity.this).put("picUrl", paramAnonymousMinsuUploadPicBean.picUrl);
          PersonalActivity.this.head_pic.setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousMinsuUploadPicBean.picUrl));
          PersonalActivity.this.validateInput();
        }
      }
    });
  }
  
  private void b()
  {
    this.c = new com.ziroom.ziroomcustomer.minsu.landlordrelease.d.b(this);
    this.a.register(this.c);
    this.d = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.c.getInstance(this.a);
  }
  
  private void b(final int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.b.c.c = Integer.valueOf(paramInt);
    this.g = new ArrayList();
    this.g.add("相册选择");
    this.g.add("拍照");
    this.s = new com.ziroom.ziroomcustomer.minsu.landlordrelease.view.d(this, new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        int i = 1;
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        PersonalActivity.a(PersonalActivity.this).dismiss();
        if (paramAnonymousInt == 0)
        {
          paramAnonymousAdapterView = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
          paramAnonymousInt = i;
          if (paramInt == 3) {
            paramAnonymousInt = 203;
          }
          PersonalActivity.this.startActivityForResult(paramAnonymousAdapterView, paramAnonymousInt);
        }
        while (paramAnonymousInt != 1) {
          return;
        }
        paramAnonymousAdapterView = new Intent("android.media.action.IMAGE_CAPTURE");
        paramAnonymousInt = 2;
        if (paramInt == 3) {
          paramAnonymousInt = 204;
        }
        PersonalActivity.this.startActivityForResult(paramAnonymousAdapterView, paramAnonymousInt);
      }
    }, this.r, this.g);
    com.ziroom.ziroomcustomer.minsu.landlordrelease.view.d locald = this.s;
    View localView = getWindow().getDecorView();
    if (!(locald instanceof PopupWindow))
    {
      locald.showAtLocation(localView, 80, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)locald, localView, 80, 0, 0);
  }
  
  private void e()
  {
    this.d.getCustomerInfo(this);
  }
  
  private void f()
  {
    String str1 = VdsAgent.trackEditTextSilent(this.et_nickname).toString();
    String str2 = VdsAgent.trackEditTextSilent(this.et_personal).toString();
    this.d.saveCustomerInfo(this, str1, str2);
  }
  
  private void g()
  {
    if ((this.w) && (!TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.et_nickname).toString())) && (!TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.et_personal).toString())))
    {
      com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this).setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          PersonalActivity.this.finish();
        }
      }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
      return;
    }
    finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1;
    Object localObject2;
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      localObject1 = null;
      if (paramInt1 != 2) {
        break label159;
      }
      localObject2 = paramIntent.getExtras();
      if (localObject2 == null) {
        break label127;
      }
      localObject1 = ad.savePic((Bitmap)((Bundle)localObject2).get("data"));
      if ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 202))
      {
        localObject1 = new File((String)localObject1);
        if (!((File)localObject1).exists()) {
          break label291;
        }
        a((File)localObject1, com.ziroom.ziroomcustomer.minsu.b.c.c.intValue());
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4096) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("saveDesc");
        if (!TextUtils.isEmpty(paramIntent)) {
          this.et_personal.setText(paramIntent);
        }
      }
      return;
      label127:
      if ((localObject2 == null) && (paramIntent != null))
      {
        localObject1 = ad.getRealFilePath2(this, paramIntent.getData());
        break;
      }
      g.textToast(this, "无法保存");
      break;
      label159:
      if (paramInt1 == 202)
      {
        localObject1 = ad.getRealFilePath2(this, this.b);
        break;
      }
      if (paramInt1 == 1)
      {
        localObject1 = ad.getRealFilePath2(this, paramIntent.getData());
        break;
      }
      if (paramInt1 == 204)
      {
        localObject1 = ad.savePic((Bitmap)paramIntent.getExtras().get("data"));
        this.b = k.cropPic2(this, Uri.parse("file://" + (String)localObject1));
        break;
      }
      if (paramInt1 != 203) {
        break;
      }
      localObject2 = paramIntent.getData();
      localObject1 = ad.getRealFilePath2(this, (Uri)localObject2);
      this.b = k.cropPic2(this, (Uri)localObject2);
      break;
      label291:
      g.textToast(this, "图片获取失败");
    }
  }
  
  @OnClick({2131690637, 2131691055, 2131689492, 2131690401})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      g();
      return;
    case 2131691055: 
      InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
      b(3);
      return;
    case 2131690637: 
      paramView = new Intent(this, CommonSaveDescInfoActivity.class);
      paramView.putExtra("titleName", "个人介绍");
      paramView.putExtra("editTextHint", this.v);
      paramView.putExtra("saveDescText", VdsAgent.trackEditTextSilent(this.et_personal).toString());
      paramView.putExtra("editMaxNum", 500);
      paramView.putExtra("editMinNum", 70);
      startActivityForResult(paramView, 4096);
      return;
    }
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903241);
    this.e = ButterKnife.bind(this);
    a();
    b();
    e();
  }
  
  protected void onDestroy()
  {
    this.e.unbind();
    this.a.unregister(this.c);
    super.onDestroy();
  }
  
  protected void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    this.f = this.c.getCustomerInfoBean();
    parama = parama.getType();
    int i = -1;
    switch (parama.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    do
    {
      return;
      if (!parama.equals("customerInfo")) {
        break;
      }
      i = 0;
      break;
      if (!parama.equals("saveCustomerInfo")) {
        break;
      }
      i = 1;
      break;
      if (!parama.equals("customerInfo_error")) {
        break;
      }
      i = 2;
      break;
      if (!parama.equals("saveCustomerInfo_error")) {
        break;
      }
      i = 3;
      break;
    } while ((!this.f.checkSuccess(this)) || (this.f == null) || (this.f.getData() == null));
    if (ae.notNull(this.f.getData().getNickName()))
    {
      this.et_nickname.setText(this.f.getData().getNickName());
      this.w = false;
    }
    if (ae.notNull(this.f.getData().getCustomerIntroduce()))
    {
      this.et_personal.setText(this.f.getData().getCustomerIntroduce());
      this.w = false;
    }
    if (ae.notNull(this.f.getData().getPictrues().getHeadPicUrl()))
    {
      this.u = this.f.getData().getPictrues().getHeadPicUrl();
      this.head_pic.setController(com.freelxl.baselibrary.f.c.frescoController(this.f.getData().getPictrues().getHeadPicUrl()));
    }
    if (!com.ziroom.ziroomcustomer.util.s.isEmpty(this.f.getData().getPictrues().getExplain())) {
      this.r = this.f.getData().getPictrues().getExplain();
    }
    this.v = this.f.getData().getDefaultIntroduce();
    validateInput();
    return;
    if (this.f.checkSuccess(this))
    {
      g.textToast(this, "保存成功");
      finish();
      return;
    }
    g.textToast(this, this.f.message);
    return;
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("YF", "==CUSTOMERINFO_ERROR==  ");
    return;
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("YF", "==SAVECUSTOMERINFO_ERROR==  ");
    g.textToast(this, "服务器错误，稍后再试");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      g();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void validateInput()
  {
    String str1 = VdsAgent.trackEditTextSilent(this.et_nickname).toString();
    String str2 = VdsAgent.trackEditTextSilent(this.et_personal).toString();
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || ((this.t == null) && (TextUtils.isEmpty(this.u))))
    {
      this.tv_info_save.setEnabled(false);
      this.tv_info_save.setTextColor(Color.parseColor("#999999"));
      return;
    }
    this.tv_info_save.setEnabled(true);
    this.tv_info_save.setTextColor(Color.parseColor("#444444"));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/qualification/PersonalActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */