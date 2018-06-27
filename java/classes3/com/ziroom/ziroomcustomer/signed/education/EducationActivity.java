package com.ziroom.ziroomcustomer.signed.education;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.widget.SignerInfoItemView;

public class EducationActivity
  extends BaseActivity
  implements a.b
{
  Unbinder a;
  a.a b;
  @BindView(2131695951)
  View commonTitleDivideLine;
  @BindView(2131695948)
  ImageView commonTitleIvBack;
  @BindView(2131695950)
  TextView commonTitleTvRightButton;
  @BindView(2131695949)
  TextView commonTitleTvTitle;
  @BindView(2131697548)
  SignerInfoItemView sivEducationType;
  @BindView(2131697546)
  SignerInfoItemView sivInYear;
  @BindView(2131697547)
  SignerInfoItemView sivOutYear;
  @BindView(2131697545)
  SignerInfoItemView sivSchoolName;
  @BindView(2131697544)
  SignerInfoItemView sivSchoolingDegree;
  @BindView(2131697549)
  TextView tvEducationHint;
  @BindView(2131697543)
  TextView tvEducationSignStatus;
  
  private void a()
  {
    this.commonTitleTvTitle.setVisibility(8);
    this.commonTitleDivideLine.setVisibility(8);
    this.sivSchoolingDegree.setEditable(false);
    this.sivSchoolName.setEditable(false);
    this.sivInYear.setEditable(false);
    this.sivOutYear.setEditable(false);
    this.sivEducationType.setEditable(false);
  }
  
  public void finishAc()
  {
    finish();
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  public boolean isActive()
  {
    return isActive();
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
    } while (-1 != paramInt2);
    paramIntent = paramIntent.getStringExtra("schoolName");
    this.sivSchoolName.setContent(paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905133);
    this.a = ButterKnife.bind(this);
    this.b = new b(this);
    a();
    this.b.initData();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.unbind();
  }
  
  @OnClick({2131695948, 2131695950, 2131697544, 2131697545, 2131697546, 2131697547, 2131697548})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131695948: 
      finish();
      return;
    case 2131695950: 
      paramView = this.sivSchoolingDegree.getContent();
      String str1 = this.sivInYear.getContent();
      String str2 = this.sivSchoolName.getContent();
      String str3 = this.sivOutYear.getContent();
      String str4 = this.sivEducationType.getContent();
      if (ae.isNull(paramView))
      {
        g.textToast(this, "请选择学历信息", 0);
        return;
      }
      if (ae.isNull(str2))
      {
        g.textToast(this, "请输入学校信息", 0);
        return;
      }
      if (ae.isNull(str1))
      {
        g.textToast(this, "请选择入学年份", 0);
        return;
      }
      if (ae.isNull(str3))
      {
        g.textToast(this, "请输入毕业年份", 0);
        return;
      }
      if (ae.isNull(str4))
      {
        g.textToast(this, "请输入教育类型", 0);
        return;
      }
      if (new Integer(str3).intValue() < new Integer(str1).intValue())
      {
        g.textToast(this, "毕业年份必须比入学年份大", 0);
        return;
      }
      this.b.submitData(a.getToken(this), str3, str1, str2, str4, paramView);
      return;
    case 2131697544: 
      this.b.getSchoolingDegree();
      return;
    case 2131697545: 
      startActivityAsDialogForResult(new Intent(this, SchoolSearchActivity.class), 1);
      return;
    case 2131697546: 
      this.b.getInYear();
      return;
    case 2131697547: 
      this.b.getOutYear();
      return;
    }
    this.b.getSchoolType();
  }
  
  public void setHintVisible(int paramInt)
  {
    this.tvEducationHint.setVisibility(paramInt);
  }
  
  public void setPresenter(a.a parama)
  {
    this.b = parama;
  }
  
  public void showEducationType(String paramString)
  {
    this.sivEducationType.setContent(paramString);
  }
  
  public void showGraduateYear(String paramString)
  {
    this.sivOutYear.setContent(paramString);
  }
  
  public void showInYear(String paramString)
  {
    this.sivInYear.setContent(paramString);
  }
  
  public void showSchool(String paramString)
  {
    this.sivSchoolName.setContent(paramString);
  }
  
  public void showSchooling(String paramString)
  {
    if (ae.notNull(paramString)) {
      this.sivSchoolingDegree.setContent(paramString);
    }
  }
  
  public void showTopRightBtn(String paramString, boolean paramBoolean)
  {
    this.commonTitleTvRightButton.setEnabled(paramBoolean);
    this.commonTitleTvRightButton.setText(paramString);
    if (paramBoolean) {
      this.commonTitleTvRightButton.setTextColor(getResources().getColor(2131624594));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/education/EducationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */