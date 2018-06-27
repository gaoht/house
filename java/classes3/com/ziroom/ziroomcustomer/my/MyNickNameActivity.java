package com.ziroom.ziroomcustomer.my;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.q;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.UserInfo;

public class MyNickNameActivity
  extends BaseActivity
{
  String a;
  private Unbinder b;
  private TextWatcher c = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      if ((paramAnonymousEditable.length() < 1) || (paramAnonymousEditable.length() > 16) || ((com.freelxl.baselibrary.f.f.notNull(MyNickNameActivity.this.a)) && (MyNickNameActivity.this.a.equals(paramAnonymousEditable.toString()))))
      {
        MyNickNameActivity.this.mBtnSave.setEnabled(false);
        MyNickNameActivity.this.mBtnSave.setTextColor(MyNickNameActivity.this.mColorGray99);
        return;
      }
      MyNickNameActivity.this.mBtnSave.setEnabled(true);
      MyNickNameActivity.this.mBtnSave.setTextColor(MyNickNameActivity.this.mColorOrangeFFA000);
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private BroadcastReceiver d = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("type", 0) == 7)
      {
        MyNickNameActivity.this.dismissProgress();
        MyNickNameActivity.this.finish();
      }
    }
  };
  private com.ziroom.ziroomcustomer.e.a.f<String> e = new com.ziroom.ziroomcustomer.e.a.f(this, new q(String.class))
  {
    public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousString);
      g.textToast(MyNickNameActivity.this, MyNickNameActivity.this.getString(2131297243));
      if (ApplicationEx.c.getUser() != null) {
        ApplicationEx.c.getUser().setNickName(MyNickNameActivity.this.a);
      }
      MyNickNameActivity.this.finish();
    }
  };
  @BindView(2131691837)
  TextView mBtnSave;
  @BindColor(2131624392)
  int mColorGray44;
  @BindColor(2131624393)
  int mColorGray99;
  @BindColor(2131624516)
  int mColorOrangeFFA000;
  @BindView(2131691057)
  TextView mEtNickName;
  @BindView(2131689895)
  ImageView tvBack;
  
  private void a()
  {
    this.tvBack.setImageResource(2130840322);
  }
  
  private void b()
  {
    this.a = getIntent().getStringExtra("nickname");
    if (!TextUtils.isEmpty(this.a))
    {
      this.mEtNickName.setText(this.a);
      CharSequence localCharSequence = this.mEtNickName.getText();
      if ((localCharSequence instanceof Spannable)) {
        Selection.setSelection((Spannable)localCharSequence, localCharSequence.length());
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968686, 2130968687);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903370);
    this.b = ButterKnife.bind(this);
    this.mEtNickName.addTextChangedListener(this.c);
    paramBundle = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.d, paramBundle);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.d);
    this.b.unbind();
    super.onDestroy();
  }
  
  @OnClick({2131689895, 2131691837, 2131691648})
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689895: 
      finish();
      return;
    case 2131691837: 
      paramView = com.ziroom.commonlibrary.login.a.getToken(this);
      this.a = this.mEtNickName.getText().toString().trim();
      j.modifyNickName(this, paramView, this.a, this.e);
      b("nickname_change_save");
      return;
    }
    this.mEtNickName.setText("");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyNickNameActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */