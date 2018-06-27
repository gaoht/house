package com.ziroom.commonlibrary.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlibrary.R.id;
import com.ziroom.commonlibrary.R.layout;

public class PassModifyActivity
  extends BaseLoginActivity
{
  private final String b = "PassModifyActivity";
  private TextView c;
  private TextView d;
  private String e;
  private String f;
  
  protected void a()
  {
    super.a();
    this.e = getIntent().getStringExtra("PassModifyActivity_email");
    this.f = getIntent().getStringExtra("PassModifyActivity_phone");
    if (!TextUtils.isEmpty(this.f))
    {
      this.c = ((TextView)findViewById(R.id.tv_phone));
      this.c.setVisibility(0);
    }
    if (!TextUtils.isEmpty(this.e))
    {
      this.d = ((TextView)findViewById(R.id.tv_email));
      this.d.setVisibility(0);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_pass_modify);
    a();
  }
  
  public void onViewClick(View paramView)
  {
    Intent localIntent = new Intent();
    if ((paramView.getId() == R.id.tv_pass) || (paramView.getId() == R.id.rl_pass))
    {
      localIntent.setClass(this, PassSettingActivity.class);
      localIntent.putExtra("PassSettingActivity_type", 4);
      startActivity(localIntent);
    }
    do
    {
      return;
      if ((paramView.getId() == R.id.tv_phone) || (paramView.getId() == R.id.rl_phone))
      {
        if (!TextUtils.isEmpty(this.f))
        {
          localIntent.setClass(this, VCodeActivity.class);
          localIntent.putExtra("ValidateCodeActivity_phone", this.f);
          localIntent.putExtra("ValidateCodeActivity_vcode_type", 1);
          localIntent.putExtra("ValidateCodeActivity_vcode_type_busi", 4);
          paramView = new Intent();
          paramView.setClass(getApplicationContext(), PassSettingActivity.class);
          paramView.putExtra("PassSettingActivity_type", 2);
          paramView.putExtra("PassSettingActivity_phone", this.f);
          localIntent.putExtra("ValidateCodeActivity_after_intent", paramView);
          startActivity(localIntent);
          return;
        }
        g.textToast(this, "该账户暂未绑定手机号");
        return;
      }
    } while ((paramView.getId() != R.id.tv_email) && (paramView.getId() != R.id.rl_email));
    if (!TextUtils.isEmpty(this.e))
    {
      localIntent.setClass(this, VCodeActivity.class);
      localIntent.putExtra("ValidateCodeActivity_email", this.e);
      localIntent.putExtra("ValidateCodeActivity_vcode_type", 2);
      localIntent.putExtra("ValidateCodeActivity_vcode_type_busi", 4);
      paramView = new Intent();
      paramView.setClass(getApplicationContext(), PassSettingActivity.class);
      paramView.putExtra("PassSettingActivity_type", 2);
      paramView.putExtra("PassSettingActivity_email", this.e);
      localIntent.putExtra("ValidateCodeActivity_after_intent", paramView);
      startActivity(localIntent);
      return;
    }
    g.textToast(this, "该账户暂未绑定邮箱");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/login/PassModifyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */