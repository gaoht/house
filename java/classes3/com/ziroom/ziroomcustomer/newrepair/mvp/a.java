package com.ziroom.ziroomcustomer.newrepair.mvp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.ziroomcustomer.b;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newrepair.b.s.d;

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
    
    public abstract RecyclerView getRvPraise();
    
    public abstract ConvenientBanner getmCbCenterBanner();
    
    public abstract CardView getmCvCenter();
    
    public abstract LinearLayout getmLlChoiceTitle();
    
    public abstract LinearLayout getmLlStoryTitle();
    
    public abstract SimpleDraweeView getmSdvBanner();
    
    public abstract SimpleDraweeView getmSdvZiru();
    
    public abstract void setServeOrder(s.d paramd);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/mvp/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */