package com.ziroom.ziroomcustomer.minsu.homecolumn;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.home.b.a.b;
import com.ziroom.ziroomcustomer.minsu.homecolumn.a.a.a.a;
import java.util.List;

public class a
  extends RecyclerView.a<a>
{
  private List<a.a.a> a;
  private Context b;
  private int c;
  
  public a(List<a.a.a> paramList, Context paramContext, int paramInt)
  {
    this.a = paramList;
    this.b = paramContext;
    this.c = paramInt;
  }
  
  public int getItemCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public void onBindViewHolder(final a parama, final int paramInt)
  {
    parama.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new a.b();
        paramAnonymousView.setTarget(((a.a.a)a.a(a.this).get(paramInt)).getTarget());
        paramAnonymousView.setImg(((a.a.a)a.a(a.this).get(paramInt)).getImg());
        paramAnonymousView.setDescription(((a.a.a)a.a(a.this).get(paramInt)).getDescription());
        paramAnonymousView.setTitle(((a.a.a)a.a(a.this).get(paramInt)).getTitle());
        paramAnonymousView.setApp(((a.a.a)a.a(a.this).get(paramInt)).getApp());
        if ((a.b(a.this) instanceof MinsuArticleColumnActivity))
        {
          if (a.c(a.this) == 2) {
            k.CmsToWebActivitySimple((MinsuArticleColumnActivity)a.b(a.this), paramAnonymousView);
          }
        }
        else {
          return;
        }
        k.CmsToWebActivity((MinsuArticleColumnActivity)a.b(a.this), paramAnonymousView);
      }
    });
    parama.b.setMaxLines(2);
    parama.c.setMaxLines(2);
    parama.b.setText(((a.a.a)this.a.get(paramInt)).getTitle());
    parama.c.setText(((a.a.a)this.a.get(paramInt)).getDescription());
    c.loadHolderImage(parama.a, ((a.a.a)this.a.get(paramInt)).getImg());
    parama.b.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        if (parama.b.getLineCount() == 2) {
          parama.c.setMaxLines(1);
        }
        parama.b.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
      }
    });
  }
  
  public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(this.b).inflate(2130904343, paramViewGroup, false));
  }
  
  public void setDatas(List<a.a.a> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  class a
    extends RecyclerView.u
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    View d;
    
    public a(View paramView)
    {
      super();
      this.d = paramView;
      this.a = ((SimpleDraweeView)paramView.findViewById(2131695112));
      this.b = ((TextView)paramView.findViewById(2131689541));
      this.c = ((TextView)paramView.findViewById(2131690071));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/homecolumn/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */