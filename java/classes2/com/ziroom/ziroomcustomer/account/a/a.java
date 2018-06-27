package com.ziroom.ziroomcustomer.account.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.a.b;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.account.model.Card;
import java.util.List;

public class a
  extends com.freelxl.baselibrary.a.a<Card>
  implements View.OnClickListener
{
  public a(Context paramContext, List<Card> paramList)
  {
    super(paramContext, paramList, 2130903071);
  }
  
  public void convert(b paramb, Card paramCard) {}
  
  public void convert(b paramb, Card paramCard, int paramInt)
  {
    super.convert(paramb, paramCard, paramInt);
    Object localObject;
    if (("0".equals(paramCard.bindStatus)) || ("2".equals(paramCard.bindStatus)))
    {
      if (!TextUtils.isEmpty(paramCard.outcontractCode)) {
        paramb.setText(2131689778, paramCard.outcontractCode);
      }
      paramb.setText(2131689777, "尚未绑卡，请尽快绑定！");
      paramCard = (TextView)paramb.getView(2131689779);
      localObject = this.a.getResources().getDrawable(2130838912);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
      paramCard.setCompoundDrawables(null, null, (Drawable)localObject, null);
      paramCard.setVisibility(0);
      paramCard.setText("去绑卡");
      ((SimpleDraweeView)paramb.getView(2131689776)).setController(c.frescoFromResourceController(2130840153));
      return;
    }
    if (("1".equals(paramCard.bindStatus)) || ("3".equals(paramCard.bindStatus)))
    {
      if (!TextUtils.isEmpty(paramCard.cardNum)) {
        paramb.setText(2131689778, paramCard.cardNum.replaceAll("(?<=.{4})(.{8})", "********").replaceAll(".{4}(?!$)", "$0 "));
      }
      paramb.setText(2131689777, paramCard.bankNm);
      localObject = (TextView)paramb.getView(2131689779);
      Drawable localDrawable = this.a.getResources().getDrawable(2130838912);
      localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
      ((TextView)localObject).setCompoundDrawables(null, null, localDrawable, null);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText("查看详情");
      ((SimpleDraweeView)paramb.getView(2131689776)).setController(c.frescoController(paramCard.picUrl));
      return;
    }
    if (!TextUtils.isEmpty(paramCard.cardNum)) {
      paramb.setText(2131689778, paramCard.cardNum.replaceAll("(?<=.{4})(.{8})", "********").replaceAll(".{4}(?!$)", "$0 "));
    }
    paramb.setText(2131689777, paramCard.bankNm);
    if ((paramCard.cityNm == null) || (paramCard.cityNm.equals(""))) {
      paramb.setVisibility(2131689779, 8);
    }
    for (;;)
    {
      ((SimpleDraweeView)paramb.getView(2131689776)).setController(c.frescoController(paramCard.picUrl));
      return;
      localObject = (TextView)paramb.getView(2131689779);
      ((TextView)localObject).setCompoundDrawables(null, null, null, null);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(paramCard.cityNm);
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */