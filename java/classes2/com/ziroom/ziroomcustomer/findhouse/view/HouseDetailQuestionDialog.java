package com.ziroom.ziroomcustomer.findhouse.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;

public class HouseDetailQuestionDialog
  extends DialogFragment
  implements View.OnClickListener
{
  private Context a;
  private View b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  private void a()
  {
    ImageView localImageView = (ImageView)this.b.findViewById(2131689492);
    TextView localTextView1 = (TextView)this.b.findViewById(2131689541);
    TextView localTextView2 = (TextView)this.b.findViewById(2131690073);
    TextView localTextView3 = (TextView)this.b.findViewById(2131693772);
    LinearLayout localLinearLayout = (LinearLayout)this.b.findViewById(2131693771);
    Bundle localBundle = getArguments();
    this.c = localBundle.getString("title");
    this.d = localBundle.getString("desc");
    this.e = localBundle.getString("link");
    this.f = localBundle.getString("link_title");
    localTextView1.setText(this.c);
    localTextView2.setText(this.d);
    if (TextUtils.isEmpty(this.f)) {
      localLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      localImageView.setOnClickListener(this);
      localTextView3.setOnClickListener(this);
      return;
      localLinearLayout.setVisibility(0);
      localTextView3.setText("《" + this.f + "》");
    }
  }
  
  private void b()
  {
    getDialog().requestWindowFeature(1);
    getDialog().getWindow().setWindowAnimations(2131427507);
    getDialog().getWindow().getDecorView().setPadding(0, 0, 0, 0);
    getDialog().getWindow().setBackgroundDrawableResource(2131624576);
    getDialog().getWindow().setLayout(-1, -1);
  }
  
  public static HouseDetailQuestionDialog getInstance(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HouseDetailQuestionDialog localHouseDetailQuestionDialog = new HouseDetailQuestionDialog();
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramString1);
    localBundle.putString("desc", paramString2);
    localBundle.putString("link", paramString3);
    localBundle.putString("link_title", paramString4);
    localHouseDetailQuestionDialog.setArguments(localBundle);
    return localHouseDetailQuestionDialog;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      dismiss();
      return;
    }
    JsBridgeWebActivity.start(this.a, this.c, this.e);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    b();
    this.a = getActivity();
    this.b = paramLayoutInflater.inflate(2130903795, paramViewGroup, false);
    a();
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/HouseDetailQuestionDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */