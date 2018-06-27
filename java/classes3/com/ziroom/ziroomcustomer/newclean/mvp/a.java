package com.ziroom.ziroomcustomer.newclean.mvp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.ziroomcustomer.b;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanUesrIsNewMo;
import com.ziroom.ziroomcustomer.newclean.d.n;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;

public abstract interface a
{
  public static abstract interface a
    extends com.ziroom.ziroomcustomer.a
  {
    public abstract void reAgainLogin();
  }
  
  public static abstract interface b
    extends b<a.a>
  {
    public abstract MyGridView geGvChoice();
    
    public abstract CardView getCardCenter();
    
    public abstract MyGridView getGvClean();
    
    public abstract SimpleDraweeView getIvInvite();
    
    public abstract ListViewForScrollView getLvCleaner();
    
    public abstract RecyclerView getRvPraise();
    
    public abstract ConvenientBanner getmCbBanner();
    
    public abstract ConvenientBanner getmCbCenterBanner();
    
    public abstract LinearLayout getmLlChoiceTitle();
    
    public abstract LinearLayout getmLlCleanerTitle();
    
    public abstract void setCardTip(CleanUesrIsNewMo paramCleanUesrIsNewMo);
    
    public abstract void setServeOrder(n paramn);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/mvp/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */