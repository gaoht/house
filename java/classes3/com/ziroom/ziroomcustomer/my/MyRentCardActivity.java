package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.c;
import com.ziroom.ziroomcustomer.e.j;

public class MyRentCardActivity
  extends BaseActivity
{
  private final String a = "MyRentCardActivity";
  private a b;
  private Unbinder c;
  private f<b> d = new f(this, new c())
  {
    public void onSuccess(int paramAnonymousInt, b paramAnonymousb)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousb);
      MyRentCardActivity.a(MyRentCardActivity.this, new MyRentCardActivity.a(MyRentCardActivity.this, MyRentCardActivity.this, paramAnonymousb));
      if ((MyRentCardActivity.this.mLv != null) && (!MyRentCardActivity.this.isFinishing()))
      {
        MyRentCardActivity.this.mLv.setAdapter(MyRentCardActivity.a(MyRentCardActivity.this));
        MyRentCardActivity.this.mLv.setEmptyView(MyRentCardActivity.this.mFlEmpty);
      }
    }
  };
  @BindView(2131689787)
  BasicZiroomToolBar mBztb;
  @BindView(2131691788)
  FrameLayout mFlEmpty;
  @BindView(2131689817)
  ListView mLv;
  @BindView(2131691829)
  TextView mTvEmpty;
  
  private void a()
  {
    this.mBztb.setTitle(getString(2131297247));
    this.mTvEmpty.setText(getString(2131297246));
  }
  
  private void b()
  {
    j.getRentCardList(this, com.ziroom.commonlibrary.login.a.getUid(this), "2", "0", this.d);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903372);
    this.c = ButterKnife.bind(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.c.unbind();
  }
  
  static class ViewHolder
  {
    @BindView(2131690049)
    TextView mTvName;
    @BindView(2131690003)
    TextView mTvNum;
    @BindView(2131689852)
    TextView mTvTime;
    @BindView(2131689541)
    TextView mTvTitle;
    
    public ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
  
  private class a
    extends BaseAdapter
  {
    private Context b;
    private b c;
    
    public a(Context paramContext, b paramb)
    {
      this.b = paramContext;
      this.c = paramb;
    }
    
    public int getCount()
    {
      if (this.c == null) {
        return 0;
      }
      return this.c.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.c.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      e locale;
      TextView localTextView;
      if (paramView != null)
      {
        localObject = (MyRentCardActivity.ViewHolder)paramView.getTag();
        paramViewGroup = paramView;
        paramView = (View)localObject;
        locale = this.c.getJSONObject(paramInt);
        if (locale != null)
        {
          localTextView = paramView.mTvName;
          if (!locale.containsKey("name")) {
            break label251;
          }
          localObject = locale.getString("name");
          label58:
          localTextView.setText((CharSequence)localObject);
          localObject = new StringBuffer();
          if (locale.containsKey("start_time")) {
            ((StringBuffer)localObject).append(locale.getString("start_time"));
          }
          ((StringBuffer)localObject).append(" 至 ");
          if (locale.containsKey("end_time")) {
            ((StringBuffer)localObject).append(locale.getString("end_time"));
          }
          paramView.mTvTime.setText(((StringBuffer)localObject).toString());
          localTextView = paramView.mTvNum;
          if (!locale.containsKey("show_money")) {
            break label258;
          }
        }
      }
      label251:
      label258:
      for (Object localObject = locale.getString("show_money");; localObject = "")
      {
        localTextView.setText((CharSequence)localObject);
        if ((!locale.containsKey("rule")) || (TextUtils.isEmpty(locale.getString("rule")))) {
          break label265;
        }
        paramView.mTvTitle.setText(locale.getString("rule"));
        paramView.mTvTitle.setVisibility(0);
        return paramViewGroup;
        paramViewGroup = LayoutInflater.from(this.b).inflate(2130904384, paramViewGroup, false);
        paramView = new MyRentCardActivity.ViewHolder(paramViewGroup);
        paramViewGroup.setTag(paramView);
        break;
        localObject = "";
        break label58;
      }
      label265:
      paramView.mTvTitle.setVisibility(8);
      return paramViewGroup;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyRentCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */