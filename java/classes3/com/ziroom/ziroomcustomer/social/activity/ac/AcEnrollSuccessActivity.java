package com.ziroom.ziroomcustomer.social.activity.ac;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.threelib.ziroomshare.f;
import com.ziroom.threelib.ziroomshare.f.c;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.social.model.AcEnrollSuccess;
import com.ziroom.ziroomcustomer.social.model.AcEnrollSuccess.ButtonBean;
import com.ziroom.ziroomcustomer.social.model.AcEnrollSuccess.ShareBean;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.List;

public class AcEnrollSuccessActivity
  extends BaseActivity
{
  private String a;
  private AcEnrollSuccess b;
  @BindView(2131689492)
  ImageView mIvBack;
  @BindView(2131689824)
  LinearLayout mLlButtons;
  @BindView(2131689823)
  TextView mTvMsg;
  @BindView(2131689826)
  TextView mTvShare;
  
  private void a()
  {
    this.b = ((AcEnrollSuccess)getIntent().getParcelableExtra("success"));
    this.a = getIntent().getStringExtra("cityCode");
    if (this.b == null) {}
    final Object localObject;
    do
    {
      return;
      if (!TextUtils.isEmpty(this.b.getMessage()))
      {
        this.b.setMessage(this.b.getMessage().replaceAll("\\\\n", "\n"));
        this.mTvMsg.setText(this.b.getMessage());
      }
      if (this.b.getShare() != null)
      {
        localObject = this.b.getShare().getButton_show();
        if (!ae.isNull((String)localObject))
        {
          localObject = new SpannableString((CharSequence)localObject);
          ((SpannableString)localObject).setSpan(new UnderlineSpan(), 0, ((SpannableString)localObject).length(), 0);
          this.mTvShare.setText((CharSequence)localObject);
        }
      }
    } while ((this.b.getButton() == null) || (this.b.getButton().size() <= 0));
    int i = 0;
    label174:
    Button localButton;
    if ((i < this.b.getButton().size()) && (i < 2))
    {
      localObject = (AcEnrollSuccess.ButtonBean)this.b.getButton().get(i);
      localButton = (Button)this.mLlButtons.getChildAt(i);
      if (localObject != null) {
        break label241;
      }
      localButton.setVisibility(8);
    }
    for (;;)
    {
      i += 1;
      break label174;
      break;
      label241:
      localButton.setVisibility(0);
      localButton.setText(((AcEnrollSuccess.ButtonBean)localObject).getContent());
      localButton.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (ae.isNull(localObject.getUrl())) {}
          do
          {
            return;
            if (2 == localObject.getType())
            {
              JsBridgeWebActivity.start(AcEnrollSuccessActivity.this, "", localObject.getUrl());
              return;
            }
          } while ((1 != localObject.getType()) || (!"1".equals(localObject.getUrl())));
          AcEnrollSuccessActivity.a(AcEnrollSuccessActivity.this);
        }
      });
    }
  }
  
  private void b()
  {
    if ((this.b == null) || (this.b.getShare() == null)) {
      return;
    }
    AcEnrollSuccess.ShareBean localShareBean = this.b.getShare();
    f.newBuilder(this).setFlag(31).setShareTitle(localShareBean.getTitle()).setShareUrl(localShareBean.getUrl()).setShareContent(localShareBean.getContent()).setSharePicUrl(localShareBean.getImage()).build().show();
  }
  
  private void e()
  {
    startActivityAndFinish(new Intent(this, AcEnrollListActivityNew.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903082);
    ButterKnife.bind(this);
    a();
  }
  
  @OnClick({2131689492, 2131689826})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    }
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/ac/AcEnrollSuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */