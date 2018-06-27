package com.ziroom.ziroomcustomer.signed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;

public class SignerWorkCertificationView
  extends LinearLayout
{
  private Context a;
  private SimpleDraweeView b;
  private TextView c;
  private TextView d;
  
  public SignerWorkCertificationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SignerWorkCertificationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SignerWorkCertificationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }
  
  private void a()
  {
    setOrientation(0);
    View localView = LayoutInflater.from(this.a).inflate(2130904527, this, true);
    this.b = ((SimpleDraweeView)localView.findViewById(2131690097));
    this.c = ((TextView)localView.findViewById(2131690073));
    this.d = ((TextView)localView.findViewById(2131689822));
    this.c.setText("北京自如信息科技有限公司");
    this.d.setText("已签约");
  }
  
  public void setContent() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/widget/SignerWorkCertificationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */