package com.ziroom.ziroomcustomer.newclean.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newclean.b.c;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.d.i;
import com.ziroom.ziroomcustomer.util.w;
import java.util.ArrayList;
import java.util.List;

public class BiweeklyCleanerIdentFragment
  extends BaseFragment
{
  private c a;
  private List<i> b = new ArrayList();
  @BindView(2131693958)
  MyGridView gv_ident;
  @BindView(2131693959)
  View view_down;
  @BindView(2131693957)
  View view_up;
  
  private void c()
  {
    w.onEventToZiroomAndUmeng("biweeklyclean_cleanner_info_qualified_uv");
    String str = getArguments().getString("cleanerId");
    n.getBiweeklyCleanerIdent(getActivity(), str, new com.freelxl.baselibrary.d.c.a(new l(i.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, List<i> paramAnonymousList)
      {
        BiweeklyCleanerIdentFragment.a(BiweeklyCleanerIdentFragment.this).clear();
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          BiweeklyCleanerIdentFragment.this.view_up.setVisibility(0);
          BiweeklyCleanerIdentFragment.this.view_down.setVisibility(0);
          BiweeklyCleanerIdentFragment.a(BiweeklyCleanerIdentFragment.this, paramAnonymousList);
        }
        for (;;)
        {
          BiweeklyCleanerIdentFragment.a(BiweeklyCleanerIdentFragment.this, new c(BiweeklyCleanerIdentFragment.this.getActivity(), BiweeklyCleanerIdentFragment.a(BiweeklyCleanerIdentFragment.this)));
          BiweeklyCleanerIdentFragment.this.gv_ident.setAdapter(BiweeklyCleanerIdentFragment.b(BiweeklyCleanerIdentFragment.this));
          return;
          BiweeklyCleanerIdentFragment.this.view_up.setVisibility(8);
          BiweeklyCleanerIdentFragment.this.view_down.setVisibility(8);
        }
      }
    });
  }
  
  public static BiweeklyCleanerIdentFragment getInstance(String paramString)
  {
    BiweeklyCleanerIdentFragment localBiweeklyCleanerIdentFragment = new BiweeklyCleanerIdentFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("cleanerId", paramString);
    localBiweeklyCleanerIdentFragment.setArguments(localBundle);
    return localBiweeklyCleanerIdentFragment;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903896, paramViewGroup, false);
    ButterKnife.bind(this, paramLayoutInflater);
    c();
    return paramLayoutInflater;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/BiweeklyCleanerIdentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */