package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.CertInfoEntity;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.CreditsBean;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.NewsignCertListBean;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.NewsignCertListBean.AuthStatusTips;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.NewsignCertListBean.CompanyBean;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.NewsignCertListBean.PersonalBean;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.signed.SignedCertInfoConfirmActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.ziroomstation.utils.h;
import java.util.Iterator;
import java.util.List;

public class ZryuSignCertificationInfoActivity
  extends BaseActivity
{
  private Unbinder a;
  private Context b;
  private CertInfoEntity c;
  @BindView(2131690109)
  TextView cert_title_tv;
  @BindView(2131690128)
  TextView certification_btn;
  @BindView(2131690129)
  TextView certification_data_title;
  @BindView(2131690135)
  TextView certification_id_left;
  @BindView(2131690136)
  TextView certification_id_right;
  @BindView(2131690125)
  ImageView certification_img;
  @BindView(2131690139)
  TextView certification_img_hint_left;
  @BindView(2131690138)
  TextView certification_img_left;
  @BindView(2131690140)
  TextView certification_img_right;
  @BindView(2131690137)
  RelativeLayout certification_img_rl;
  @BindView(2131690130)
  TextView certification_name_left;
  @BindView(2131690131)
  TextView certification_name_right;
  @BindView(2131690133)
  TextView certification_sex_left;
  @BindView(2131690134)
  TextView certification_sex_right;
  @BindView(2131690132)
  RelativeLayout certification_sex_rl;
  @BindView(2131690126)
  TextView certification_type;
  @BindView(2131690127)
  TextView certification_why;
  private int d;
  private HouseDetail e;
  private String f;
  private int g;
  private f<e> r = new f(this.b, new o())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      ZryuSignCertificationInfoActivity.a(ZryuSignCertificationInfoActivity.this, (CertInfoEntity)h.parseObject(paramAnonymouse.toJSONString(), CertInfoEntity.class));
      if (ZryuSignCertificationInfoActivity.a(ZryuSignCertificationInfoActivity.this) != null) {
        ZryuSignCertificationInfoActivity.b(ZryuSignCertificationInfoActivity.this);
      }
    }
  };
  
  private void a()
  {
    this.certification_img.setImageResource(2130838098);
    try
    {
      this.d = Integer.parseInt(this.c.user_type);
      if ((this.c.credits != null) && (this.c.credits.realNameStatus != 0)) {}
      Object localObject2;
      Object localObject1;
      switch (this.c.credits.realNameStatus)
      {
      default: 
        localObject2 = this.certification_name_right;
        if (ae.notNull(this.c.real_name))
        {
          localObject1 = this.c.real_name;
          ((TextView)localObject2).setText((CharSequence)localObject1);
          localObject2 = this.certification_id_right;
          if (!ae.notNull(c(this.c.cert_num))) {
            break label1040;
          }
          localObject1 = c(this.c.cert_num);
          ((TextView)localObject2).setText((CharSequence)localObject1);
          if (this.d != 2) {
            break label1155;
          }
          localObject1 = this.c.getNewsign_cert_list().getCompany().iterator();
        }
        break;
      case 1: 
        for (;;)
        {
          label118:
          label157:
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (CertInfoEntity.NewsignCertListBean.CompanyBean)((Iterator)localObject1).next();
            if ((localObject2 != null) && ((((CertInfoEntity.NewsignCertListBean.CompanyBean)localObject2).getCompany_type() + "").equals(this.c.getCompany_type())))
            {
              this.certification_img_left.setText(((CertInfoEntity.NewsignCertListBean.CompanyBean)localObject2).getCert_name() + "照片");
              this.certification_id_left.setText(((CertInfoEntity.NewsignCertListBean.CompanyBean)localObject2).getCert_name() + "号码");
              continue;
              if ((this.d == 1) && ("1".equals(this.c.getCert_type())))
              {
                localObject1 = new Intent(this.b, ZryuSignCertInformationActivity.class);
                ((Intent)localObject1).putExtra("phone", this.f);
                ((Intent)localObject1).putExtra("cert_info", this.c);
                ((Intent)localObject1).putExtra("detail", this.e);
                ((Intent)localObject1).putExtra("type", this.g);
                startActivity((Intent)localObject1);
                finish();
              }
            }
          }
        }
      }
      label933:
      label1040:
      do
      {
        return;
        if (this.c.getNewsign_cert_list() != null) {
          if (this.c.getNewsign_cert_list().auth_status_tips != null) {
            if (ae.notNull(this.c.getNewsign_cert_list().auth_status_tips.getIn_auth()))
            {
              this.certification_why.setText(this.c.getNewsign_cert_list().auth_status_tips.getIn_auth());
              this.certification_why.setVisibility(0);
            }
          }
        }
        for (;;)
        {
          this.certification_img.setImageResource(2130838097);
          this.certification_btn.setVisibility(0);
          this.certification_type.setText("待审核");
          break;
          this.certification_why.setVisibility(8);
          continue;
          this.certification_why.setVisibility(8);
          continue;
          this.certification_why.setVisibility(8);
        }
        if (this.c.getNewsign_cert_list() != null) {
          if (this.c.getNewsign_cert_list().auth_status_tips != null) {
            if (ae.notNull(this.c.getNewsign_cert_list().auth_status_tips.getID_card_in_auth()))
            {
              this.certification_why.setText(this.c.getNewsign_cert_list().auth_status_tips.getID_card_in_auth());
              this.certification_why.setVisibility(0);
            }
          }
        }
        for (;;)
        {
          this.certification_img.setImageResource(2130838097);
          this.certification_btn.setVisibility(8);
          this.certification_type.setText("认证中");
          break;
          this.certification_why.setVisibility(8);
          continue;
          this.certification_why.setVisibility(8);
          continue;
          this.certification_why.setVisibility(8);
        }
        if (ae.notNull(this.c.credits.realRejectReason)) {
          this.certification_why.setText(this.c.credits.realRejectReason);
        }
        for (;;)
        {
          this.certification_img.setImageResource(2130838096);
          this.certification_btn.setVisibility(0);
          this.certification_type.setText("认证失败");
          break;
          this.certification_why.setVisibility(8);
        }
        if (this.c.getNewsign_cert_list() != null) {
          if (this.c.getNewsign_cert_list().auth_status_tips != null) {
            if (ae.notNull(this.c.getNewsign_cert_list().auth_status_tips.getAuth_success())) {
              this.certification_why.setText(this.c.getNewsign_cert_list().auth_status_tips.getAuth_success());
            }
          }
        }
        for (;;)
        {
          if (this.g == 0) {
            break label933;
          }
          this.certification_type.setText("认证成功");
          localObject1 = new Intent(this.b, SignedCertInfoConfirmActivity.class);
          ((Intent)localObject1).putExtra("phone", this.f);
          ((Intent)localObject1).putExtra("cert_info", this.c);
          ((Intent)localObject1).putExtra("detail", this.e);
          ((Intent)localObject1).putExtra("type", this.g);
          startActivity((Intent)localObject1);
          finish();
          break;
          this.certification_why.setVisibility(8);
          continue;
          this.certification_why.setVisibility(8);
          continue;
          this.certification_why.setVisibility(8);
        }
        this.certification_btn.setVisibility(8);
        this.certification_img.setImageResource(2130838098);
        this.certification_type.setText("认证成功");
        break;
        localObject1 = new Intent(this.b, ZryuSignCertInformationActivity.class);
        ((Intent)localObject1).putExtra("phone", this.f);
        ((Intent)localObject1).putExtra("cert_info", this.c);
        ((Intent)localObject1).putExtra("detail", this.e);
        ((Intent)localObject1).putExtra("type", this.g);
        startActivity((Intent)localObject1);
        finish();
        break;
        localObject1 = "";
        break label118;
        localObject1 = "";
        break label157;
        this.certification_name_left.setText("企业名称");
        this.certification_sex_left.setText("企业性质");
        this.cert_title_tv.setText("企业信息认证");
        this.certification_data_title.setText("企业信息");
      } while ((ae.isNull(this.c.company_type)) || (b(this.c.company_type, this.c.newsign_cert_list.company) == null));
      this.certification_sex_right.setText(b(this.c.company_type, this.c.newsign_cert_list.company).getType());
      return;
      label1155:
      this.cert_title_tv.setText("我的实名认证");
      this.certification_data_title.setText("身份信息");
      this.certification_name_left.setText("姓名");
      if ((!ae.isNull(this.c.cert_type)) && (this.c.getNewsign_cert_list() != null))
      {
        localObject1 = a(this.c.cert_type, this.c.newsign_cert_list.personal);
        if (localObject1 != null)
        {
          this.certification_id_left.setText(((CertInfoEntity.NewsignCertListBean.PersonalBean)localObject1).getCert_name());
          if (((CertInfoEntity.NewsignCertListBean.PersonalBean)localObject1).getCert_type() == 1) {
            this.certification_img_rl.setVisibility(8);
          }
        }
      }
      this.certification_sex_left.setText("性别");
      this.certification_sex_right.setText(a(this.c.gender));
      this.certification_img_left.setText("证件照片");
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void doAuthenticate()
  {
    j.getCertInfo(this.b, com.ziroom.commonlibrary.login.a.getToken(this.b), 1, this.r);
  }
  
  @OnClick({2131690128, 2131690105})
  public void onClic(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690128: 
      paramView = new Intent(this, ZryuSignCertInformationActivity.class);
      paramView.putExtra("cert_info", this.c);
      paramView.putExtra("phone", this.f);
      paramView.putExtra("detail", this.e);
      paramView.putExtra("type", this.g);
      startActivity(paramView);
      finish();
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903126);
    this.b = this;
    this.c = ((CertInfoEntity)getIntent().getParcelableExtra("cert_info"));
    this.e = ((HouseDetail)getIntent().getSerializableExtra("detail"));
    this.f = getIntent().getStringExtra("phone");
    this.g = getIntent().getIntExtra("type", 0);
    this.a = ButterKnife.bind(this);
    if (this.c == null)
    {
      doAuthenticate();
      return;
    }
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignCertificationInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */