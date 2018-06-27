package com.ziroom.ziroomcustomer.newchat.chatcenter.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.c.u;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newchat.chatcenter.a.b;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.f;
import com.ziroom.ziroomcustomer.newchat.chatcenter.views.LoadListView.a;
import com.ziroom.ziroomcustomer.newchat.chatcenter.views.MyLoadListView;
import com.ziroom.ziroomcustomer.newchat.chatcenter.views.MyViewPaper;
import java.util.ArrayList;
import java.util.List;

public class SuggAndComFrament
  extends BaseFragment
  implements LoadListView.a
{
  Context a;
  String b;
  MyViewPaper c;
  int d = 0;
  View e;
  protected boolean f = true;
  protected boolean g = false;
  private MyLoadListView h;
  private b i;
  private List<f> j = new ArrayList();
  private List<f> k;
  private int l = 1;
  
  public SuggAndComFrament(String paramString, MyViewPaper paramMyViewPaper, int paramInt)
  {
    this.b = paramString;
    this.c = paramMyViewPaper;
    this.d = paramInt;
  }
  
  private void a(int paramInt, String paramString)
  {
    n.getComplainTips(this.a, paramInt + "", "8", paramString, new com.ziroom.commonlibrary.a.a(this.a, new u(f.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        SuggAndComFrament.a(SuggAndComFrament.this).stopLoadMore();
      }
      
      public void onSuccess(int paramAnonymousInt, List<f> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        SuggAndComFrament.a(SuggAndComFrament.this).stopLoadMore();
        SuggAndComFrament.a(SuggAndComFrament.this, null);
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          SuggAndComFrament.a(SuggAndComFrament.this, paramAnonymousList);
          SuggAndComFrament.c(SuggAndComFrament.this).addAll(SuggAndComFrament.b(SuggAndComFrament.this));
          SuggAndComFrament.d(SuggAndComFrament.this).notifyDataSetChanged();
        }
        if (((SuggAndComFrament.b(SuggAndComFrament.this) == null) || (SuggAndComFrament.b(SuggAndComFrament.this).size() == 0)) && (SuggAndComFrament.this.g)) {
          g.textToast(this.b, "没有更多内容了～");
        }
        if (SuggAndComFrament.c(SuggAndComFrament.this).size() > 0) {
          SuggAndComFrament.a(SuggAndComFrament.this).setVisibility(0);
        }
        while (!SuggAndComFrament.this.g) {
          return;
        }
        SuggAndComFrament.a(SuggAndComFrament.this).setVisibility(8);
      }
    });
  }
  
  private void a(View paramView)
  {
    this.h = ((MyLoadListView)paramView.findViewById(2131696479));
    this.h.setXListViewListener(this);
    this.h.setPullLoadEnable(true);
    this.i = new b(this.a, this.j);
    this.h.setAdapter(this.i);
    this.c.setObjectForPosition(this.h, this.d);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = getContext();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.e = View.inflate(getActivity(), 2130904801, null);
    a(this.e);
    return this.e;
  }
  
  public void onLoadMore()
  {
    this.g = true;
    int m = this.l + 1;
    this.l = m;
    a(m, this.b);
  }
  
  public void onPause()
  {
    super.onPause();
    this.f = false;
  }
  
  public void onResume()
  {
    super.onResume();
    this.c.resetHeight();
    if (this.f)
    {
      this.g = false;
      a(this.l, this.b);
      return;
    }
    this.f = true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/activity/SuggAndComFrament.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */