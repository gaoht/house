package com.ziroom.ziroomcustomer.newchat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.exceptions.HyphenateException;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class SatisfactionActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String a = "";
  private RatingBar b = null;
  private Button c = null;
  private EditText d = null;
  private ProgressDialog e = null;
  private ImageView f;
  private ImageView g;
  private ImageView r;
  private ImageView s;
  private ImageView t;
  private int u = 0;
  
  private void a()
  {
    this.f = ((ImageView)findViewById(2131690054));
    this.g = ((ImageView)findViewById(2131690055));
    this.r = ((ImageView)findViewById(2131690056));
    this.s = ((ImageView)findViewById(2131690057));
    this.t = ((ImageView)findViewById(2131690058));
    this.c = ((Button)findViewById(2131689843));
    this.d = ((EditText)findViewById(2131690002));
    this.c.setOnClickListener(new a());
    findViewById(2131689492).setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    this.u = paramInt;
    if (paramInt == 1)
    {
      this.f.setImageResource(2130839757);
      this.g.setImageResource(2130839753);
      this.r.setImageResource(2130839753);
      this.s.setImageResource(2130839753);
      this.t.setImageResource(2130839753);
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        this.f.setImageResource(2130839757);
        this.g.setImageResource(2130839757);
        this.r.setImageResource(2130839753);
        this.s.setImageResource(2130839753);
        this.t.setImageResource(2130839753);
        return;
      }
      if (paramInt == 3)
      {
        this.f.setImageResource(2130839757);
        this.g.setImageResource(2130839757);
        this.r.setImageResource(2130839757);
        this.s.setImageResource(2130839753);
        this.t.setImageResource(2130839753);
        return;
      }
      if (paramInt == 4)
      {
        this.f.setImageResource(2130839757);
        this.g.setImageResource(2130839757);
        this.r.setImageResource(2130839757);
        this.s.setImageResource(2130839757);
        this.t.setImageResource(2130839753);
        return;
      }
    } while (paramInt != 5);
    this.f.setImageResource(2130839757);
    this.g.setImageResource(2130839757);
    this.r.setImageResource(2130839757);
    this.s.setImageResource(2130839757);
    this.t.setImageResource(2130839757);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690054: 
      b(1);
      return;
    case 2131690055: 
      b(2);
      return;
    case 2131690056: 
      b(3);
      return;
    case 2131690057: 
      b(4);
      return;
    case 2131690058: 
      b(5);
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903464);
    this.a = getIntent().getStringExtra("msgId");
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.e != null) && (this.e.isShowing())) {
      this.e.dismiss();
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    @Instrumented
    public void onClick(final View paramView)
    {
      VdsAgent.onClick(this, paramView);
      paramView = EMClient.getInstance().chatManager().getMessage(SatisfactionActivity.a(SatisfactionActivity.this));
      try
      {
        if (SatisfactionActivity.b(SatisfactionActivity.this) == 0)
        {
          SatisfactionActivity.this.showToast("评分不能空");
          return;
        }
        localJSONObject = paramView.getJSONObjectAttribute("weichat");
        localObject = localJSONObject.getJSONObject("ctrlArgs");
        localEMMessage = EMMessage.createTxtSendMessage("", paramView.getFrom());
        ((JSONObject)localObject).put("summary", SatisfactionActivity.b(SatisfactionActivity.this) + "");
        ((JSONObject)localObject).put("detail", VdsAgent.trackEditTextSilent(SatisfactionActivity.c(SatisfactionActivity.this)).toString());
        localJSONObject.put("ctrlType", "enquiry");
        localEMMessage.setAttribute("weichat", localJSONObject);
        SatisfactionActivity.a(SatisfactionActivity.this, new ProgressDialog(SatisfactionActivity.this));
        SatisfactionActivity.d(SatisfactionActivity.this).setMessage("请稍等...");
        localObject = SatisfactionActivity.d(SatisfactionActivity.this);
        if ((localObject instanceof ProgressDialog)) {
          break label222;
        }
        ((ProgressDialog)localObject).show();
      }
      catch (JSONException paramView)
      {
        for (;;)
        {
          final JSONObject localJSONObject;
          Object localObject;
          final EMMessage localEMMessage;
          paramView.printStackTrace();
          return;
          VdsAgent.showDialog((ProgressDialog)localObject);
        }
      }
      catch (HyphenateException paramView)
      {
        paramView.printStackTrace();
      }
      EMClient.getInstance().chatManager().sendMessage(localEMMessage);
      localEMMessage.setMessageStatusCallback(new EMCallBack()
      {
        public void onError(int paramAnonymousInt, String paramAnonymousString) {}
        
        public void onProgress(int paramAnonymousInt, String paramAnonymousString)
        {
          SatisfactionActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              if ((SatisfactionActivity.d(SatisfactionActivity.this) != null) && (SatisfactionActivity.d(SatisfactionActivity.this).isShowing())) {
                SatisfactionActivity.d(SatisfactionActivity.this).dismiss();
              }
              g.textToast(SatisfactionActivity.this.getApplicationContext(), "提交失败", 0);
            }
          });
        }
        
        public void onSuccess()
        {
          SatisfactionActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              if ((SatisfactionActivity.d(SatisfactionActivity.this) != null) && (SatisfactionActivity.d(SatisfactionActivity.this).isShowing())) {
                SatisfactionActivity.d(SatisfactionActivity.this).dismiss();
              }
              EMClient.getInstance().chatManager().getConversation(SatisfactionActivity.a.1.this.a.getFrom()).removeMessage(SatisfactionActivity.a.1.this.b.getMsgId());
              try
              {
                SatisfactionActivity.a.1.this.c.put("enable", true);
                SatisfactionActivity.a.1.this.a.setAttribute("weichat", SatisfactionActivity.a.1.this.c);
                EMClient.getInstance().chatManager().updateMessage(SatisfactionActivity.a.1.this.a);
                SatisfactionActivity.this.setResult(-1);
                SatisfactionActivity.this.finish();
                return;
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  localJSONException.printStackTrace();
                }
              }
            }
          });
        }
      });
      return;
      label222:
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/SatisfactionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */