package com.ziroom.ziroomcustomer.minsu.landlordrelease.qualification;

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
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.gridpasswordview.GridPasswordView;
import com.ziroom.commonlibrary.widget.gridpasswordview.GridPasswordView.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.b.d;
import com.ziroom.ziroomcustomer.minsu.f.p;
import com.ziroom.ziroomcustomer.minsu.f.q;
import com.ziroom.ziroomcustomer.minsu.f.s;
import java.util.UUID;

public class MinsuQAVCodeActivity
  extends BaseActivity
  implements View.OnClickListener, GridPasswordView.a
{
  private GridPasswordView A;
  private SimpleDraweeView B;
  private AlertDialog C;
  private Handler D = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if (paramAnonymousMessage.arg1 > 0)
      {
        MinsuQAVCodeActivity.a(MinsuQAVCodeActivity.this).setText(paramAnonymousMessage.arg1 + "S");
        Message localMessage = obtainMessage(1);
        int i = paramAnonymousMessage.arg1 - 1;
        paramAnonymousMessage.arg1 = i;
        localMessage.arg1 = i;
        sendMessageDelayed(localMessage, 1000L);
        return;
      }
      MinsuQAVCodeActivity.a(MinsuQAVCodeActivity.this).setText(MinsuQAVCodeActivity.b(MinsuQAVCodeActivity.this));
      MinsuQAVCodeActivity.a(MinsuQAVCodeActivity.this).setOnClickListener(MinsuQAVCodeActivity.this);
    }
  };
  private final int a = 60;
  private final int b = 1000;
  private final int c = 1;
  private TextView d;
  private GridPasswordView e;
  private String f;
  private String g;
  private String r;
  private String s;
  private String t;
  private String u;
  private TextView v;
  private TextView w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  private void b()
  {
    this.d.setOnClickListener(null);
    this.D.removeMessages(1);
    Message localMessage = this.D.obtainMessage(1);
    localMessage.arg1 = 60;
    localMessage.sendToTarget();
  }
  
  private void d(String paramString)
  {
    this.s = null;
    com.ziroom.ziroomcustomer.minsu.e.a.validateSmsCode(this, this.f, paramString, this.g, new s(this, new q())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        MinsuQAVCodeActivity.this.finish();
      }
    });
  }
  
  private void e()
  {
    this.C = new AlertDialog.Builder(this).create();
    View localView = LayoutInflater.from(this).inflate(2130903819, null);
    this.C.setCanceledOnTouchOutside(false);
    this.C.setCancelable(false);
    this.A = ((GridPasswordView)localView.findViewById(2131693800));
    this.B = ((SimpleDraweeView)localView.findViewById(2131693823));
    Object localObject1 = (Button)localView.findViewById(2131693670);
    Object localObject2 = (Button)localView.findViewById(2131693671);
    this.w = ((TextView)localView.findViewById(2131693824));
    this.x = ((TextView)localView.findViewById(2131693825));
    this.y = ((TextView)localView.findViewById(2131693826));
    this.z = ((TextView)localView.findViewById(2131693827));
    f();
    this.A.setPasswordVisibility(true);
    this.A.setOnPasswordChangedListener(new GridPasswordView.a()
    {
      public void onInputFinish(String paramAnonymousString) {}
      
      public void onTextChanged(String paramAnonymousString)
      {
        paramAnonymousString = paramAnonymousString.toCharArray();
        MinsuQAVCodeActivity.c(MinsuQAVCodeActivity.this);
        int i = 0;
        if (i < paramAnonymousString.length)
        {
          if (i == 0) {
            MinsuQAVCodeActivity.d(MinsuQAVCodeActivity.this).setText(paramAnonymousString[0] + "");
          }
          for (;;)
          {
            i += 1;
            break;
            if (i == 1) {
              MinsuQAVCodeActivity.e(MinsuQAVCodeActivity.this).setText(paramAnonymousString[1] + "");
            } else if (i == 2) {
              MinsuQAVCodeActivity.f(MinsuQAVCodeActivity.this).setText(paramAnonymousString[2] + "");
            } else if (i == 3) {
              MinsuQAVCodeActivity.g(MinsuQAVCodeActivity.this).setText(paramAnonymousString[3] + "");
            }
          }
        }
      }
    });
    this.A.performClick();
    this.C.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        MinsuQAVCodeActivity.a(MinsuQAVCodeActivity.this, "");
        MinsuQAVCodeActivity.a(MinsuQAVCodeActivity.this, null);
        MinsuQAVCodeActivity.a(MinsuQAVCodeActivity.this, null);
        MinsuQAVCodeActivity.h(MinsuQAVCodeActivity.this).dismiss();
        MinsuQAVCodeActivity.a(MinsuQAVCodeActivity.this, null);
        MinsuQAVCodeActivity.this.finish();
      }
    });
    this.t = UUID.randomUUID().toString();
    this.B.setController(c.frescoController(d.d + "/img/verify/code/v1?imgId=" + this.t));
    ((Button)localObject1).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuQAVCodeActivity.a(MinsuQAVCodeActivity.this, "");
        MinsuQAVCodeActivity.a(MinsuQAVCodeActivity.this, null);
        MinsuQAVCodeActivity.a(MinsuQAVCodeActivity.this, null);
        MinsuQAVCodeActivity.h(MinsuQAVCodeActivity.this).dismiss();
        MinsuQAVCodeActivity.a(MinsuQAVCodeActivity.this, null);
        MinsuQAVCodeActivity.this.finish();
      }
    });
    ((Button)localObject2).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = MinsuQAVCodeActivity.d(MinsuQAVCodeActivity.this).getText().toString();
        String str1 = MinsuQAVCodeActivity.e(MinsuQAVCodeActivity.this).getText().toString();
        String str2 = MinsuQAVCodeActivity.f(MinsuQAVCodeActivity.this).getText().toString();
        String str3 = MinsuQAVCodeActivity.g(MinsuQAVCodeActivity.this).getText().toString();
        if ((TextUtils.isEmpty(paramAnonymousView)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
        {
          g.textToast(MinsuQAVCodeActivity.this, "请输入图形验证码");
          return;
        }
        MinsuQAVCodeActivity.a(MinsuQAVCodeActivity.this, paramAnonymousView + str1 + str2 + str3);
        com.ziroom.ziroomcustomer.minsu.e.a.checkImgCode(MinsuQAVCodeActivity.this, MinsuQAVCodeActivity.i(MinsuQAVCodeActivity.this), MinsuQAVCodeActivity.j(MinsuQAVCodeActivity.this), MinsuQAVCodeActivity.k(MinsuQAVCodeActivity.this), MinsuQAVCodeActivity.l(MinsuQAVCodeActivity.this), new s(MinsuQAVCodeActivity.this, new p(String.class))
        {
          public void onFailure(Throwable paramAnonymous2Throwable)
          {
            super.onFailure(paramAnonymous2Throwable);
            MinsuQAVCodeActivity.c(MinsuQAVCodeActivity.this);
            MinsuQAVCodeActivity.n(MinsuQAVCodeActivity.this).setPassword("");
            MinsuQAVCodeActivity.b(MinsuQAVCodeActivity.this, UUID.randomUUID().toString());
            MinsuQAVCodeActivity.o(MinsuQAVCodeActivity.this).setController(c.frescoController(d.d + "/img/verify/code/v1?imgId=" + MinsuQAVCodeActivity.j(MinsuQAVCodeActivity.this)));
          }
          
          public void onSuccess(int paramAnonymous2Int, String paramAnonymous2String)
          {
            super.onSuccess(paramAnonymous2Int, paramAnonymous2String);
            MinsuQAVCodeActivity.m(MinsuQAVCodeActivity.this);
            if (MinsuQAVCodeActivity.h(MinsuQAVCodeActivity.this) != null)
            {
              if (MinsuQAVCodeActivity.h(MinsuQAVCodeActivity.this).isShowing()) {
                MinsuQAVCodeActivity.h(MinsuQAVCodeActivity.this).dismiss();
              }
              MinsuQAVCodeActivity.a(MinsuQAVCodeActivity.this, null);
              MinsuQAVCodeActivity.a(MinsuQAVCodeActivity.this, null);
              MinsuQAVCodeActivity.a(MinsuQAVCodeActivity.this, null);
            }
          }
        });
      }
    });
    this.B.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuQAVCodeActivity.b(MinsuQAVCodeActivity.this, UUID.randomUUID().toString());
        MinsuQAVCodeActivity.o(MinsuQAVCodeActivity.this).setController(c.frescoController(d.d + "/img/verify/code/v1?imgId=" + MinsuQAVCodeActivity.j(MinsuQAVCodeActivity.this)));
      }
    });
    localObject1 = this.C;
    if (!(localObject1 instanceof AlertDialog)) {
      ((AlertDialog)localObject1).show();
    }
    for (;;)
    {
      localObject1 = this.C.getWindow();
      ((Window)localObject1).clearFlags(131072);
      localObject2 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject2).width = ((int)(getResources().getDisplayMetrics().density * 245.0F + 0.5F));
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      ((Window)localObject1).setContentView(localView);
      this.A.setFocusable(true);
      this.A.setFocusableInTouchMode(true);
      this.A.requestFocus();
      return;
      VdsAgent.showDialog((AlertDialog)localObject1);
    }
  }
  
  private void f()
  {
    if ((this.w != null) && (this.x != null) && (this.y != null) && (this.z != null))
    {
      this.w.setText("");
      this.x.setText("");
      this.y.setText("");
      this.z.setText("");
    }
  }
  
  protected void a()
  {
    Intent localIntent = getIntent();
    this.f = localIntent.getStringExtra("phone");
    this.g = localIntent.getStringExtra("areaCode");
    findViewById(2131689492).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuQAVCodeActivity.this.finish();
      }
    });
    this.d = ((TextView)findViewById(2131690416));
    this.e = ((GridPasswordView)findViewById(2131691708));
    this.v = ((TextView)findViewById(2131691709));
    this.r = "重新获取";
    this.e.setPasswordVisibility(true);
    this.e.setOnPasswordChangedListener(this);
    this.e.performClick();
    e();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView.getId() == 2131690416)
    {
      b();
      e();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(4);
    setContentView(2130903339);
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.D.removeMessages(1);
  }
  
  public void onInputFinish(String paramString)
  {
    d(paramString);
  }
  
  public void onTextChanged(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.v.setVisibility(0);
      return;
    }
    this.v.setVisibility(8);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/qualification/MinsuQAVCodeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */