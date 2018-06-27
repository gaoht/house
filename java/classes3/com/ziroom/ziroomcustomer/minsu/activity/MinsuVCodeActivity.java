package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.gridpasswordview.GridPasswordView;
import com.ziroom.commonlibrary.widget.gridpasswordview.GridPasswordView.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.p;
import com.ziroom.ziroomcustomer.minsu.f.q;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import java.util.UUID;

public class MinsuVCodeActivity
  extends BaseActivity
  implements View.OnClickListener, GridPasswordView.a
{
  private SimpleDraweeView A;
  private AlertDialog B;
  private Handler C = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if (paramAnonymousMessage.arg1 > 0)
      {
        MinsuVCodeActivity.b(MinsuVCodeActivity.this).setText(paramAnonymousMessage.arg1 + MinsuVCodeActivity.a(MinsuVCodeActivity.this));
        Message localMessage = obtainMessage(1);
        int i = paramAnonymousMessage.arg1 - 1;
        paramAnonymousMessage.arg1 = i;
        localMessage.arg1 = i;
        sendMessageDelayed(localMessage, 1000L);
        return;
      }
      MinsuVCodeActivity.b(MinsuVCodeActivity.this).setText(MinsuVCodeActivity.c(MinsuVCodeActivity.this));
      MinsuVCodeActivity.b(MinsuVCodeActivity.this).setOnClickListener(MinsuVCodeActivity.this);
    }
  };
  private final int a = 60;
  private final int b = 1000;
  private final int c = 1;
  private TextView d;
  private TextView e;
  private TextView f;
  private GridPasswordView g;
  private TextView r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  private String x;
  private String y;
  private EditText z;
  
  private void b()
  {
    CommonTitle localCommonTitle = (CommonTitle)findViewById(2131691272);
    localCommonTitle.setMiddleText(getString(2131297113));
    localCommonTitle.setLeftButtonType(0);
    localCommonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuVCodeActivity.this.finish();
      }
    });
  }
  
  private void d(String paramString)
  {
    this.w = null;
    com.ziroom.ziroomcustomer.minsu.e.a.validateSmsCode(this, this.s, paramString, this.t, new s(this, new q())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        paramAnonymousString = new Intent();
        paramAnonymousString.putExtra("phone", MinsuVCodeActivity.d(MinsuVCodeActivity.this));
        MinsuVCodeActivity.this.setResult(-1, paramAnonymousString);
        MinsuVCodeActivity.this.finish();
      }
    });
  }
  
  private void e()
  {
    this.f.setOnClickListener(null);
    this.C.removeMessages(1);
    Message localMessage = this.C.obtainMessage(1);
    localMessage.arg1 = 60;
    localMessage.sendToTarget();
  }
  
  private void f()
  {
    this.B = new AlertDialog.Builder(this).create();
    View localView = LayoutInflater.from(this).inflate(2130903818, null);
    this.B.setCanceledOnTouchOutside(false);
    this.B.setCancelable(false);
    this.z = ((EditText)localView.findViewById(2131693800));
    this.A = ((SimpleDraweeView)localView.findViewById(2131693823));
    Object localObject1 = (Button)localView.findViewById(2131693670);
    Object localObject2 = (Button)localView.findViewById(2131693671);
    this.B.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        MinsuVCodeActivity.a(MinsuVCodeActivity.this, "");
        MinsuVCodeActivity.a(MinsuVCodeActivity.this, null);
        MinsuVCodeActivity.a(MinsuVCodeActivity.this, null);
        MinsuVCodeActivity.e(MinsuVCodeActivity.this).dismiss();
        MinsuVCodeActivity.a(MinsuVCodeActivity.this, null);
        MinsuVCodeActivity.this.finish();
      }
    });
    this.x = UUID.randomUUID().toString();
    this.A.setController(c.frescoController(com.ziroom.ziroomcustomer.minsu.b.d.d + "/img/verify/code/v1?imgId=" + this.x));
    ((Button)localObject1).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuVCodeActivity.a(MinsuVCodeActivity.this, "");
        MinsuVCodeActivity.a(MinsuVCodeActivity.this, null);
        MinsuVCodeActivity.a(MinsuVCodeActivity.this, null);
        MinsuVCodeActivity.e(MinsuVCodeActivity.this).dismiss();
        MinsuVCodeActivity.a(MinsuVCodeActivity.this, null);
        MinsuVCodeActivity.this.finish();
      }
    });
    ((Button)localObject2).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = VdsAgent.trackEditTextSilent(MinsuVCodeActivity.f(MinsuVCodeActivity.this)).toString().trim();
        if (TextUtils.isEmpty(paramAnonymousView)) {
          return;
        }
        MinsuVCodeActivity.a(MinsuVCodeActivity.this, paramAnonymousView);
        com.ziroom.ziroomcustomer.minsu.e.a.checkImgCode(MinsuVCodeActivity.this, "", MinsuVCodeActivity.g(MinsuVCodeActivity.this), MinsuVCodeActivity.h(MinsuVCodeActivity.this), MinsuVCodeActivity.d(MinsuVCodeActivity.this), new s(MinsuVCodeActivity.this, new p(String.class))
        {
          public void onFailure(Throwable paramAnonymous2Throwable)
          {
            super.onFailure(paramAnonymous2Throwable);
            MinsuVCodeActivity.f(MinsuVCodeActivity.this).setText("");
            MinsuVCodeActivity.b(MinsuVCodeActivity.this, UUID.randomUUID().toString());
            MinsuVCodeActivity.l(MinsuVCodeActivity.this).setController(c.frescoController(com.ziroom.ziroomcustomer.minsu.b.d.d + "/img/verify/code/v1?imgId=" + MinsuVCodeActivity.g(MinsuVCodeActivity.this)));
          }
          
          public void onSuccess(int paramAnonymous2Int, String paramAnonymous2String)
          {
            super.onSuccess(paramAnonymous2Int, paramAnonymous2String);
            com.freelxl.baselibrary.f.d.d("tag", "==========s:" + paramAnonymous2String);
            MinsuVCodeActivity.i(MinsuVCodeActivity.this).setText(MinsuVCodeActivity.this.getResources().getString(2131297021));
            if (MinsuVCodeActivity.e(MinsuVCodeActivity.this) != null)
            {
              if (MinsuVCodeActivity.e(MinsuVCodeActivity.this).isShowing()) {
                MinsuVCodeActivity.e(MinsuVCodeActivity.this).dismiss();
              }
              MinsuVCodeActivity.a(MinsuVCodeActivity.this, null);
              MinsuVCodeActivity.a(MinsuVCodeActivity.this, null);
              MinsuVCodeActivity.a(MinsuVCodeActivity.this, null);
            }
            if (!"86".equals(MinsuVCodeActivity.j(MinsuVCodeActivity.this))) {
              MinsuVCodeActivity.this.finish();
            }
            MinsuVCodeActivity.k(MinsuVCodeActivity.this);
          }
        });
      }
    });
    this.A.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuVCodeActivity.b(MinsuVCodeActivity.this, UUID.randomUUID().toString());
        MinsuVCodeActivity.l(MinsuVCodeActivity.this).setController(c.frescoController(com.ziroom.ziroomcustomer.minsu.b.d.d + "/img/verify/code/v1?imgId=" + MinsuVCodeActivity.g(MinsuVCodeActivity.this)));
      }
    });
    localObject1 = this.B;
    if (!(localObject1 instanceof AlertDialog)) {
      ((AlertDialog)localObject1).show();
    }
    for (;;)
    {
      localObject1 = this.B.getWindow();
      ((Window)localObject1).clearFlags(131072);
      localObject2 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject2).width = ((int)(getResources().getDisplayMetrics().density * 245.0F + 0.5F));
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      ((Window)localObject1).setContentView(localView);
      this.z.setFocusable(true);
      this.z.setFocusableInTouchMode(true);
      this.z.requestFocus();
      return;
      VdsAgent.showDialog((AlertDialog)localObject1);
    }
  }
  
  protected void a()
  {
    Intent localIntent = getIntent();
    this.s = localIntent.getStringExtra("phone");
    this.t = localIntent.getStringExtra("areaCode");
    this.d = ((TextView)findViewById(2131689822));
    this.e = ((TextView)findViewById(2131691707));
    this.f = ((TextView)findViewById(2131690416));
    this.g = ((GridPasswordView)findViewById(2131691708));
    this.r = ((TextView)findViewById(2131689835));
    this.e.setText(this.s + "");
    this.r.setText(getString(2131297023));
    this.u = getResources().getString(2131296985);
    this.v = getResources().getString(2131296984);
    this.g.setPasswordVisibility(true);
    this.g.setOnPasswordChangedListener(this);
    this.g.performClick();
    f();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView.getId() == 2131690416)
    {
      e();
      f();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(4);
    setContentView(2130903338);
    b();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.C.removeMessages(1);
  }
  
  public void onInputFinish(String paramString)
  {
    d(paramString);
  }
  
  public void onTextChanged(String paramString) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuVCodeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */