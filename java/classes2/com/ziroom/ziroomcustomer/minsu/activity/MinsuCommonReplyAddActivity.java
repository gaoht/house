package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.freelxl.baselibrary.d.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCommonResult;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuImReplyCommonBean.DataBean.ListMsgBean;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import java.util.Timer;
import java.util.TimerTask;

public class MinsuCommonReplyAddActivity
  extends BaseActivity
  implements View.OnTouchListener
{
  private CommonTitle a;
  private MinsuImReplyCommonBean.DataBean.ListMsgBean b;
  private EditText c;
  
  private boolean a(EditText paramEditText)
  {
    int i = paramEditText.getScrollY();
    int j = paramEditText.getLayout().getHeight() - (paramEditText.getHeight() - paramEditText.getCompoundPaddingTop() - paramEditText.getCompoundPaddingBottom());
    if (j == 0) {}
    while ((i <= 0) && (i >= j - 1)) {
      return false;
    }
    return true;
  }
  
  private void b()
  {
    this.c = ((EditText)findViewById(2131691271));
    this.c.setOnTouchListener(this);
    if (this.b != null) {
      this.c.setText(this.b.content);
    }
  }
  
  private void e()
  {
    this.a = ((CommonTitle)findViewById(2131691272));
    this.a.showRightText(true, getString(2131296704));
    this.a.setRightTextColorSize(2131624081, 14);
    this.a.setOnRightButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuCommonReplyAddActivity.b(MinsuCommonReplyAddActivity.this);
      }
    });
    this.a.setMiddleText("");
    this.a.setLeftButtonType(4);
    this.a.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuCommonReplyAddActivity.this.finish();
      }
    });
  }
  
  private void f()
  {
    String str = VdsAgent.trackEditTextSilent(this.c).toString();
    if (TextUtils.isEmpty(str))
    {
      showToast("内容不能为空");
      return;
    }
    if (str.length() > 100)
    {
      showToast("内容不能超过100");
      return;
    }
    if (this.b != null)
    {
      com.ziroom.ziroomcustomer.minsu.e.a.editCommonReply(this, this.b.fid, str, new com.ziroom.commonlibrary.a.a(this, new d(MinsuCommonResult.class))
      {
        public void onSuccess(int paramAnonymousInt, MinsuCommonResult paramAnonymousMinsuCommonResult)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousMinsuCommonResult);
          if ((paramAnonymousMinsuCommonResult != null) && (paramAnonymousMinsuCommonResult.checkSuccess(MinsuCommonReplyAddActivity.this)))
          {
            MinsuCommonReplyAddActivity.this.showToast("编辑成功");
            MinsuCommonReplyAddActivity.this.setResult(-1);
            new Handler().postDelayed(new Runnable()
            {
              public void run()
              {
                MinsuCommonReplyAddActivity.this.finish();
              }
            }, 2000L);
          }
        }
      });
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.addCommonReply(this, str, new com.ziroom.commonlibrary.a.a(this, new d(MinsuCommonResult.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuCommonResult paramAnonymousMinsuCommonResult)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuCommonResult);
        if ((paramAnonymousMinsuCommonResult != null) && (paramAnonymousMinsuCommonResult.checkSuccess(MinsuCommonReplyAddActivity.this)))
        {
          MinsuCommonReplyAddActivity.this.showToast("添加成功");
          MinsuCommonReplyAddActivity.this.setResult(-1);
          new Handler().postDelayed(new Runnable()
          {
            public void run()
            {
              MinsuCommonReplyAddActivity.this.finish();
            }
          }, 2000L);
        }
      }
    });
  }
  
  protected void a()
  {
    this.c.requestFocus();
    new Timer().schedule(new TimerTask()
    {
      public void run()
      {
        InputMethodManager localInputMethodManager = (InputMethodManager)MinsuCommonReplyAddActivity.this.getSystemService("input_method");
        localInputMethodManager.showSoftInput(MinsuCommonReplyAddActivity.a(MinsuCommonReplyAddActivity.this), 2);
        localInputMethodManager.toggleSoftInput(2, 1);
      }
    }, 100L);
  }
  
  public void finish()
  {
    super.finish();
    k.animFinishAlpha(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903264);
    this.b = ((MinsuImReplyCommonBean.DataBean.ListMsgBean)getIntent().getSerializableExtra("data"));
    e();
    b();
  }
  
  protected void onResume()
  {
    super.onResume();
    a();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.getId() == 2131691290) && (a(this.c)))
    {
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      if (paramMotionEvent.getAction() == 1) {
        paramView.getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuCommonReplyAddActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */