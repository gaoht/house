package com.ziroom.ziroomcustomer.account.gift;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.account.model.GiftListItemBase;
import com.ziroom.ziroomcustomer.account.model.GiftUnDrawBase;
import com.ziroom.ziroomcustomer.payment.d.b;
import com.ziroom.ziroomcustomer.payment.d.i;
import com.ziroom.ziroomcustomer.util.ac;

public class GiftDialog
  extends DialogFragment
  implements View.OnClickListener
{
  private TextView a;
  private TextView b;
  private ImageView c;
  private ImageView d;
  private GiftUnDrawBase e;
  private Context f;
  
  public GiftDialog(Context paramContext, GiftUnDrawBase paramGiftUnDrawBase)
  {
    this.e = paramGiftUnDrawBase;
    this.f = paramContext;
  }
  
  private String a(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.equals("")))
    {
      localObject = "";
      return (String)localObject;
    }
    String str = "";
    int i = 0;
    for (;;)
    {
      localObject = str;
      if (i >= paramString.length()) {
        break;
      }
      str = str + paramString.substring(i, i + 1) + "   ";
      i += 1;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    b.getOpenGiftResult(getActivity(), paramString1, paramString2, new i(getActivity(), new com.ziroom.ziroomcustomer.payment.d.a(GiftListItemBase.class))
    {
      public void onSuccess(int paramAnonymousInt, GiftListItemBase paramAnonymousGiftListItemBase)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousGiftListItemBase);
        if (paramAnonymousGiftListItemBase.status.equals("success"))
        {
          Bundle localBundle = new Bundle();
          localBundle.putSerializable("giftBase", paramAnonymousGiftListItemBase.getData());
          paramAnonymousGiftListItemBase = new Intent(GiftDialog.a(GiftDialog.this), GiftDetailsActivity.class);
          paramAnonymousGiftListItemBase.putExtras(localBundle);
          ((Activity)GiftDialog.a(GiftDialog.this)).startActivityForResult(paramAnonymousGiftListItemBase, 103);
          GiftDialog.this.dismiss();
          return;
        }
        g.textToast(GiftDialog.this.getContext(), paramAnonymousGiftListItemBase.error_message);
      }
    });
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      dismiss();
      return;
      dismiss();
    } while (this.e == null);
    a(this.e.getRecordId() + "", this.e.getMarketCode());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = super.onCreateDialog(paramBundle);
    paramBundle.getWindow().requestFeature(1);
    return paramBundle;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903792, paramViewGroup, false);
    paramViewGroup = getDialog().getWindow();
    paramViewGroup.setGravity(17);
    paramViewGroup.setWindowAnimations(2131427836);
    paramViewGroup.getDecorView().setPadding(0, 0, 0, 0);
    paramViewGroup.getDecorView().setBackgroundColor(Color.parseColor("#80000000"));
    this.c = ((ImageView)paramLayoutInflater.findViewById(2131690588));
    this.b = ((TextView)paramLayoutInflater.findViewById(2131689857));
    this.d = ((ImageView)paramLayoutInflater.findViewById(2131693766));
    this.a = ((TextView)paramLayoutInflater.findViewById(2131692908));
    this.c.setOnClickListener(this);
    this.a.setOnClickListener(this);
    if (this.e != null)
    {
      this.b.setText(a(this.e.getMarketName()));
      return paramLayoutInflater;
    }
    getActivity().finish();
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    int i = ac.getScreenWidth(getContext());
    int j = ac.getScreenHeight(getContext());
    getDialog().getWindow().setLayout(i, j);
    super.onResume();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/gift/GiftDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */