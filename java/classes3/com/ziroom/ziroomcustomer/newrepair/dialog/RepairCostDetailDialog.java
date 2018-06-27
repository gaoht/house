package com.ziroom.ziroomcustomer.newrepair.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.home.view.ZiScroListView;
import com.ziroom.ziroomcustomer.newrepair.a.g;
import com.ziroom.ziroomcustomer.newrepair.b.k;
import java.io.Serializable;
import java.util.List;

public class RepairCostDetailDialog
  extends DialogFragment
{
  private View a;
  private ZiScroListView b;
  private TextView c;
  private g d;
  
  public static RepairCostDetailDialog getInstance()
  {
    return new RepairCostDetailDialog();
  }
  
  public static RepairCostDetailDialog getInstance(List<k> paramList, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("repairDetail", (Serializable)paramList);
    localBundle.putString("totalMoney", paramString);
    paramList = new RepairCostDetailDialog();
    paramList.setArguments(localBundle);
    return paramList;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getDialog().requestWindowFeature(1);
    getDialog().getWindow().setBackgroundDrawableResource(17170445);
    paramBundle = getArguments();
    paramViewGroup = (List)paramBundle.getSerializable("repairDetail");
    paramBundle = paramBundle.getString("totalMoney");
    this.a = paramLayoutInflater.inflate(2130903841, null);
    this.b = ((ZiScroListView)this.a.findViewById(2131691018));
    this.c = ((TextView)this.a.findViewById(2131689912));
    SpannableString localSpannableString = new SpannableString(paramBundle + "元");
    localSpannableString.setSpan(new ForegroundColorSpan(ApplicationEx.c.getResources().getColor(2131624529)), 0, paramBundle.length(), 33);
    this.c.setText(localSpannableString);
    this.d = new g(paramLayoutInflater.getContext(), paramViewGroup, true);
    this.b.setAdapter(this.d);
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/dialog/RepairCostDetailDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */