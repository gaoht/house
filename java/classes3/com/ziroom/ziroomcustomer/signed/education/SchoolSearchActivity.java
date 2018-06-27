package com.ziroom.ziroomcustomer.signed.education;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.signed.a.k;
import java.util.List;

public class SchoolSearchActivity
  extends BaseActivity
  implements c.b
{
  List<k> a;
  a b;
  private d c;
  @BindView(2131695951)
  View commonTitleDivideLine;
  @BindView(2131695948)
  ImageView commonTitleIvBack;
  @BindView(2131695950)
  TextView commonTitleTvRightButton;
  @BindView(2131695949)
  TextView commonTitleTvTitle;
  private Context d;
  @BindView(2131692471)
  EditText etSchoolNameKey;
  @BindView(2131692472)
  ImageView ivDeleteInput;
  @BindView(2131692473)
  LinearLayout llClickAdd;
  @BindView(2131692474)
  ListView lvSchoolNames;
  
  private void a()
  {
    this.commonTitleIvBack.setImageResource(2130840322);
    this.commonTitleDivideLine.setVisibility(8);
    this.commonTitleTvTitle.setVisibility(8);
    this.commonTitleTvRightButton.setVisibility(8);
    this.b = new a();
    this.lvSchoolNames.setAdapter(this.b);
    this.etSchoolNameKey.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramAnonymousCharSequence = paramAnonymousCharSequence.toString().trim();
        SchoolSearchActivity.a(SchoolSearchActivity.this).initData(paramAnonymousCharSequence);
      }
    });
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968686, 2130968687);
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  public boolean isActive()
  {
    return isActive();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903504);
    ButterKnife.bind(this);
    this.d = this;
    this.c = new d(this);
    a();
  }
  
  @OnClick({2131695948, 2131692472, 2131692473})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131695948: 
      finish();
      return;
    case 2131692472: 
      this.etSchoolNameKey.setText("");
      return;
    }
    paramView = new Intent();
    paramView.putExtra("schoolName", VdsAgent.trackEditTextSilent(this.etSchoolNameKey).toString().trim());
    setResult(-1, paramView);
    finish();
  }
  
  public void setNoResultVisiable(int paramInt)
  {
    this.llClickAdd.setVisibility(paramInt);
  }
  
  public void setPresenter(c.a parama) {}
  
  public void showSchoolList(List<k> paramList)
  {
    this.a = paramList;
    this.b.notifyDataSetChanged();
  }
  
  static class ViewHolder
  {
    @BindView(2131690049)
    TextView tvName;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
  
  public class a
    extends BaseAdapter
  {
    public a() {}
    
    public int getCount()
    {
      if (SchoolSearchActivity.this.a != null) {
        return SchoolSearchActivity.this.a.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      return SchoolSearchActivity.this.a.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(SchoolSearchActivity.b(SchoolSearchActivity.this)).inflate(2130904530, null);
        paramViewGroup = new SchoolSearchActivity.ViewHolder(paramView);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        final k localk = (k)SchoolSearchActivity.this.a.get(paramInt);
        paramViewGroup.tvName.setText(localk.getName());
        paramViewGroup.tvName.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("schoolName", localk.getName());
            SchoolSearchActivity.this.setResult(-1, paramAnonymousView);
            SchoolSearchActivity.this.finish();
          }
        });
        return paramView;
        paramViewGroup = (SchoolSearchActivity.ViewHolder)paramView.getTag();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/education/SchoolSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */