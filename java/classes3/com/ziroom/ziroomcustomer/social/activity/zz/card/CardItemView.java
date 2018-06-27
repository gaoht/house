package com.ziroom.ziroomcustomer.social.activity.zz.card;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.f;
import com.ziroom.ziroomcustomer.social.model.p;
import com.ziroom.ziroomcustomer.util.ah;

public class CardItemView
  extends LinearLayout
{
  public SimpleDraweeView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private ImageView f;
  private LinearLayout g;
  private p h;
  
  public CardItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CardItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CardItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public p getData()
  {
    return this.h;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((SimpleDraweeView)findViewById(2131697563));
    this.b = ((TextView)findViewById(2131697564));
    this.d = ((TextView)findViewById(2131696802));
    this.c = ((TextView)findViewById(2131697566));
    this.e = ((TextView)findViewById(2131690052));
    this.f = ((ImageView)findViewById(2131697565));
    this.g = ((LinearLayout)findViewById(2131692182));
  }
  
  public void setData(p paramp)
  {
    this.h = paramp;
    if (this.h == null) {
      return;
    }
    this.b.setText(paramp.getNick());
    if (f.isNull(paramp.getCompany()))
    {
      this.d.setText(paramp.getProfession());
      this.c.setText("来自" + paramp.getBizcircle() + "的自如客");
      this.e.setText(paramp.getAge() + "岁");
      if (paramp.getGender() != 1) {
        break label284;
      }
      this.g.setBackgroundResource(2130837941);
      this.f.setImageResource(2130840296);
    }
    for (;;)
    {
      GenericDraweeHierarchy localGenericDraweeHierarchy = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(300).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setBackground(getContext().getResources().getDrawable(2130837662)).build();
      RoundingParams localRoundingParams = new RoundingParams();
      localRoundingParams.setCornersRadii(ah.dip2px(getContext(), 8.0F), ah.dip2px(getContext(), 8.0F), 0.0F, 0.0F);
      localGenericDraweeHierarchy.setRoundingParams(localRoundingParams);
      this.a.setHierarchy(localGenericDraweeHierarchy);
      this.a.setController(c.frescoController(paramp.getAvatar()));
      return;
      this.d.setText(paramp.getCompany() + "·" + paramp.getProfession());
      break;
      label284:
      this.g.setBackgroundResource(2130837942);
      this.f.setImageResource(2130840297);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/card/CardItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */