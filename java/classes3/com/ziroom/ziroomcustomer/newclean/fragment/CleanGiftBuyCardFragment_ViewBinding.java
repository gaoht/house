package com.ziroom.ziroomcustomer.newclean.fragment;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.widget.WrapLayout;

public class CleanGiftBuyCardFragment_ViewBinding<T extends CleanGiftBuyCardFragment>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public CleanGiftBuyCardFragment_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.sdvCard = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131694925, "field 'sdvCard'", SimpleDraweeView.class));
    paramT.tvGet = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694927, "field 'tvGet'", TextView.class));
    paramT.tvMoney = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689846, "field 'tvMoney'", TextView.class));
    paramT.tvContent = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690084, "field 'tvContent'", TextView.class));
    paramT.recyclerView = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131693970, "field 'recyclerView'", RecyclerView.class));
    View localView = Utils.findRequiredView(paramView, 2131693684, "field 'tvBuy' and method 'onViewClicked'");
    paramT.tvBuy = ((TextView)Utils.castView(localView, 2131693684, "field 'tvBuy'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.lvMoneys = ((WrapLayout)Utils.findRequiredViewAsType(paramView, 2131693971, "field 'lvMoneys'", WrapLayout.class));
    localView = Utils.findRequiredView(paramView, 2131693972, "field 'tvXieyi' and method 'onViewClicked'");
    paramT.tvXieyi = ((TextView)Utils.castView(localView, 2131693972, "field 'tvXieyi'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvFullMoney = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693973, "field 'tvFullMoney'", TextView.class));
    paramT.tvPayMoney = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690551, "field 'tvPayMoney'", TextView.class));
    paramT.tvTips = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689835, "field 'tvTips'", TextView.class));
    paramT.cbAgree = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131690215, "field 'cbAgree'", CheckBox.class));
    paramT.cardView = ((CardView)Utils.findRequiredViewAsType(paramView, 2131693377, "field 'cardView'", CardView.class));
    paramT.viewBg = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694926, "field 'viewBg'", TextView.class));
  }
  
  public void unbind()
  {
    CleanGiftBuyCardFragment localCleanGiftBuyCardFragment = this.a;
    if (localCleanGiftBuyCardFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localCleanGiftBuyCardFragment.sdvCard = null;
    localCleanGiftBuyCardFragment.tvGet = null;
    localCleanGiftBuyCardFragment.tvMoney = null;
    localCleanGiftBuyCardFragment.tvContent = null;
    localCleanGiftBuyCardFragment.recyclerView = null;
    localCleanGiftBuyCardFragment.tvBuy = null;
    localCleanGiftBuyCardFragment.lvMoneys = null;
    localCleanGiftBuyCardFragment.tvXieyi = null;
    localCleanGiftBuyCardFragment.tvFullMoney = null;
    localCleanGiftBuyCardFragment.tvPayMoney = null;
    localCleanGiftBuyCardFragment.tvTips = null;
    localCleanGiftBuyCardFragment.cbAgree = null;
    localCleanGiftBuyCardFragment.cardView = null;
    localCleanGiftBuyCardFragment.viewBg = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/CleanGiftBuyCardFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */