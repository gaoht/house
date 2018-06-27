package com.ziroom.ziroomcustomer.newrepair.mvp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.ziroomcustomer.e.c.a.e;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newrepair.a.l;
import com.ziroom.ziroomcustomer.newrepair.b.s;
import com.ziroom.ziroomcustomer.newrepair.b.s.a;
import com.ziroom.ziroomcustomer.newrepair.b.s.b;
import com.ziroom.ziroomcustomer.newrepair.b.s.e;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class b
  implements a.a
{
  private WeakReference<a.b> a;
  private List<String> b = new ArrayList();
  private l c;
  private List<s.b> d = new ArrayList();
  
  public b(a.b paramb)
  {
    this.a = new WeakReference(paramb);
    if (paramb != null) {
      paramb.setPresenter(this);
    }
  }
  
  private void a()
  {
    String str = j.getUid();
    n.getRepairProduct(((a.b)this.a.get()).getViewContext(), str, new com.ziroom.ziroomcustomer.e.a.a(((a.b)this.a.get()).getViewContext(), new com.ziroom.ziroomcustomer.e.c.m(s.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, final s paramAnonymouss)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouss);
        if (paramAnonymouss == null) {
          return;
        }
        if ((paramAnonymouss.getTopBanner() != null) && (!TextUtils.isEmpty(paramAnonymouss.getTopBanner().getPic()))) {
          j.setServePic(((a.b)b.a(b.this).get()).getmSdvBanner(), paramAnonymouss.getTopBanner().getPic());
        }
        if ((paramAnonymouss.getCategoryList() != null) && (paramAnonymouss.getCategoryList().size() > 0))
        {
          b.b(b.this).clear();
          paramAnonymousInt = 0;
          if (paramAnonymousInt < paramAnonymouss.getCategoryList().size())
          {
            if ("00000000".equals(((s.b)paramAnonymouss.getCategoryList().get(paramAnonymousInt)).getCode())) {
              j.setServePic(((a.b)b.a(b.this).get()).getmSdvZiru(), ((s.b)paramAnonymouss.getCategoryList().get(paramAnonymousInt)).getPicUrl());
            }
            for (;;)
            {
              paramAnonymousInt += 1;
              break;
              b.b(b.this).add(paramAnonymouss.getCategoryList().get(paramAnonymousInt));
            }
          }
          if ((b.b(b.this) != null) && (b.b(b.this).size() > 0))
          {
            ((a.b)b.a(b.this).get()).getmLlChoiceTitle().setVisibility(0);
            ((a.b)b.a(b.this).get()).geGvChoice().setVisibility(0);
            b.c(b.this).setData(b.b(b.this));
            if (paramAnonymouss.getOrderList() == null) {
              break label516;
            }
            ((a.b)b.a(b.this).get()).setServeOrder(paramAnonymouss.getOrderList());
          }
        }
        for (;;)
        {
          label314:
          if ((paramAnonymouss.getAdvList() != null) && (paramAnonymouss.getAdvList().size() > 0))
          {
            ((a.b)b.a(b.this).get()).getmCvCenter().setVisibility(0);
            b.d(b.this).clear();
            paramAnonymousInt = 0;
            for (;;)
            {
              if (paramAnonymousInt < paramAnonymouss.getAdvList().size())
              {
                b.d(b.this).add(((s.a)paramAnonymouss.getAdvList().get(paramAnonymousInt)).getImg());
                paramAnonymousInt += 1;
                continue;
                ((a.b)b.a(b.this).get()).geGvChoice().setVisibility(8);
                ((a.b)b.a(b.this).get()).getmLlChoiceTitle().setVisibility(8);
                break;
                ((a.b)b.a(b.this).get()).geGvChoice().setVisibility(8);
                ((a.b)b.a(b.this).get()).getmLlChoiceTitle().setVisibility(8);
                break;
                label516:
                ((a.b)b.a(b.this).get()).setServeOrder(null);
                break label314;
              }
            }
            j.setLunBoBanner(b.d(b.this), ((a.b)b.a(b.this).get()).getmCbCenterBanner());
            ((a.b)b.a(b.this).get()).getmCbCenterBanner().setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
            {
              public void onItemClick(int paramAnonymous2Int)
              {
                if (!TextUtils.isEmpty(((s.a)paramAnonymouss.getAdvList().get(paramAnonymous2Int)).getTarget()))
                {
                  String str1 = ((s.a)paramAnonymouss.getAdvList().get(paramAnonymous2Int)).getTarget();
                  String str2 = ((s.a)paramAnonymouss.getAdvList().get(paramAnonymous2Int)).getTitle();
                  String str3 = ((s.a)paramAnonymouss.getAdvList().get(paramAnonymous2Int)).getDescription();
                  String str4 = ((s.a)paramAnonymouss.getAdvList().get(paramAnonymous2Int)).getImg();
                  JsBridgeWebActivity.start(((a.b)b.a(b.this).get()).getViewContext(), str2, str1, true, str3, str4, false);
                }
              }
            });
          }
        }
        while ((paramAnonymouss.getMessageList() != null) && (paramAnonymouss.getMessageList().size() > 0))
        {
          ((a.b)b.a(b.this).get()).getRvPraise().setVisibility(0);
          paramAnonymouss = new com.ziroom.ziroomcustomer.newrepair.a.m(((a.b)b.a(b.this).get()).getViewContext(), paramAnonymouss.getMessageList());
          ((a.b)b.a(b.this).get()).getRvPraise().setLayoutManager(new LinearLayoutManager(((a.b)b.a(b.this).get()).getViewContext(), 0, false));
          ((a.b)b.a(b.this).get()).getRvPraise().setAdapter(paramAnonymouss);
          return;
          ((a.b)b.a(b.this).get()).getmCvCenter().setVisibility(8);
        }
        ((a.b)b.a(b.this).get()).getRvPraise().setVisibility(8);
      }
    });
  }
  
  private boolean b()
  {
    return (getView() != null) && (((a.b)this.a.get()).isActive());
  }
  
  public void detachView()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public Object getView()
  {
    if (this.a != null) {
      return this.a.get();
    }
    return null;
  }
  
  public void reAgainLogin()
  {
    if (b()) {
      a();
    }
  }
  
  public void start()
  {
    if (b())
    {
      this.c = new l(((a.b)this.a.get()).getViewContext(), this.d);
      ((a.b)this.a.get()).geGvChoice().setHorizontalSpacing(com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenWidth(((a.b)this.a.get()).getViewContext()) * 20 / 375);
      ((a.b)this.a.get()).geGvChoice().setAdapter(this.c);
      a();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/mvp/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */