package com.ziroom.ziroomcustomer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.util.ac;
import java.util.ArrayList;
import java.util.List;

public class NavigationFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private Context a;
  private View b;
  private TextView c;
  private ImageView d;
  private List<Integer> e;
  private Bitmap f;
  private int g;
  
  private void c()
  {
    this.c = ((TextView)this.b.findViewById(2131690043));
    this.d = ((ImageView)this.b.findViewById(2131693178));
    if ((this.e != null) && (this.e.size() > 0))
    {
      if (this.g != this.e.size() - 1) {
        break label82;
      }
      this.c.setVisibility(0);
    }
    for (;;)
    {
      d();
      return;
      label82:
      this.c.setVisibility(8);
    }
  }
  
  private void d()
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(getResources(), ((Integer)this.e.get(this.g)).intValue(), localOptions);
      localOptions.inSampleSize = getScaleRatio(localOptions);
      localOptions.inJustDecodeBounds = false;
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      this.f = BitmapFactory.decodeResource(getResources(), ((Integer)this.e.get(this.g)).intValue(), localOptions);
      this.d.setImageBitmap(this.f);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void e()
  {
    this.c.setOnClickListener(this);
  }
  
  public static NavigationFragment getInstance(ArrayList<Integer> paramArrayList, int paramInt)
  {
    NavigationFragment localNavigationFragment = new NavigationFragment();
    Bundle localBundle = new Bundle();
    localBundle.putIntegerArrayList("img_list", paramArrayList);
    localBundle.putInt("position", paramInt);
    localNavigationFragment.setArguments(localBundle);
    return localNavigationFragment;
  }
  
  public int getScaleRatio(BitmapFactory.Options paramOptions)
  {
    int j = ac.getScreenWidth(this.a);
    int i = ac.getScreenHeight(this.a);
    j = (int)Math.ceil(paramOptions.outWidth / j);
    i = (int)Math.ceil(paramOptions.outHeight / i);
    if ((i > 1) && (j > 1))
    {
      if (i > j) {
        return i;
      }
      return j;
    }
    return 1;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    startActivity(new Intent(getActivity(), MainActivity.class));
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    this.g = paramBundle.getInt("position");
    this.e = paramBundle.getIntegerArrayList("img_list");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = getActivity();
    this.b = paramLayoutInflater.inflate(2130903890, null, false);
    c();
    e();
    return this.b;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.f != null)
    {
      this.f.recycle();
      this.f = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/NavigationFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */