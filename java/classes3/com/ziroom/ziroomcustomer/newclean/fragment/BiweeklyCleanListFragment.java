package com.ziroom.ziroomcustomer.newclean.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newclean.b.e;
import com.ziroom.ziroomcustomer.newclean.d.m;
import com.ziroom.ziroomcustomer.util.u;
import java.util.List;

public class BiweeklyCleanListFragment
  extends BaseFragment
{
  private ListView a;
  private TextView b;
  private e c;
  
  private void c()
  {
    Object localObject = getArguments();
    String str1 = ((Bundle)localObject).getString("uid");
    String str2 = ((Bundle)localObject).getString("rentContractCode");
    String str3 = ((Bundle)localObject).getString("hireContractCode");
    localObject = ((Bundle)localObject).getString("month");
    n.getBiweeklyCleanListByMonth(getActivity(), str1, str2, str3, (String)localObject, new com.freelxl.baselibrary.d.c.a(new l(m.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        BiweeklyCleanListFragment.b(BiweeklyCleanListFragment.this).setEmptyView(BiweeklyCleanListFragment.a(BiweeklyCleanListFragment.this));
        if (BiweeklyCleanListFragment.c(BiweeklyCleanListFragment.this) != null) {
          BiweeklyCleanListFragment.c(BiweeklyCleanListFragment.this).setData(null);
        }
      }
      
      public void onSuccess(int paramAnonymousInt, List<m> paramAnonymousList)
      {
        u.d("sdjgkljd", "======   " + com.alibaba.fastjson.a.toJSONString(paramAnonymousList));
        BiweeklyCleanListFragment.b(BiweeklyCleanListFragment.this).setEmptyView(BiweeklyCleanListFragment.a(BiweeklyCleanListFragment.this));
        if (BiweeklyCleanListFragment.c(BiweeklyCleanListFragment.this) != null)
        {
          BiweeklyCleanListFragment.c(BiweeklyCleanListFragment.this).setData(paramAnonymousList);
          return;
        }
        BiweeklyCleanListFragment.a(BiweeklyCleanListFragment.this, new e(BiweeklyCleanListFragment.this.getActivity(), paramAnonymousList, BiweeklyCleanListFragment.this.getArguments()));
        BiweeklyCleanListFragment.b(BiweeklyCleanListFragment.this).setAdapter(BiweeklyCleanListFragment.c(BiweeklyCleanListFragment.this));
      }
    });
  }
  
  public static BiweeklyCleanListFragment getInstance(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    BiweeklyCleanListFragment localBiweeklyCleanListFragment = new BiweeklyCleanListFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("uid", paramString1);
    localBundle.putString("rentContractCode", paramString2);
    localBundle.putString("hireContractCode", paramString3);
    localBundle.putString("month", paramString4);
    localBundle.putString("phone", paramString5);
    localBundle.putString("name", paramString6);
    localBundle.putString("contractAddress", paramString7);
    localBiweeklyCleanListFragment.setArguments(localBundle);
    return localBiweeklyCleanListFragment;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.c = new e(getActivity(), null, getArguments());
    this.a.setAdapter(this.c);
    c();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903894, paramViewGroup, false);
    this.a = ((ListView)paramLayoutInflater.findViewById(2131690077));
    this.b = ((TextView)paramLayoutInflater.findViewById(2131693953));
    return paramLayoutInflater;
  }
  
  public void refreshList()
  {
    c();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/BiweeklyCleanListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */