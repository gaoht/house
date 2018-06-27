package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionResult.SuggestionInfo;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AptitudeCertifierNameActivity
  extends BaseActivity
{
  private Context a;
  @BindView(2131689941)
  ImageView aptitude_edit_delete;
  @BindView(2131689942)
  ListView aptitude_edit_list;
  private Unbinder b;
  private List<a> c;
  private AptitudeMapListAdapter d;
  @BindView(2131689934)
  EditText edit_Search;
  @BindView(2131689895)
  TextView tv_back;
  
  private void a()
  {
    this.c = ((List)getIntent().getSerializableExtra("AddressMessage"));
    if (this.c != null)
    {
      this.d = new AptitudeMapListAdapter(this.a, true, this.c);
      this.aptitude_edit_list.setAdapter(this.d);
      this.d.setOnClick(new AptitudeMapListAdapter.a()
      {
        public void onClick(a paramAnonymousa)
        {
          Intent localIntent = AptitudeCertifierNameActivity.this.getIntent();
          localIntent.putExtra("info", paramAnonymousa);
          AptitudeCertifierNameActivity.this.setResult(98, localIntent);
          AptitudeCertifierNameActivity.this.finish();
        }
      });
    }
  }
  
  private void b()
  {
    this.edit_Search.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
  }
  
  @OnClick({2131689895})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903099);
    this.a = this;
    getWindow().setSoftInputMode(4);
    this.b = ButterKnife.bind(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.b.unbind();
  }
  
  public void onGetSuggestionResult(SuggestionResult paramSuggestionResult)
  {
    if ((paramSuggestionResult == null) || (paramSuggestionResult.getAllSuggestions() == null)) {
      return;
    }
    if (this.c == null) {
      this.c = new ArrayList();
    }
    this.c.clear();
    paramSuggestionResult = paramSuggestionResult.getAllSuggestions().iterator();
    while (paramSuggestionResult.hasNext())
    {
      SuggestionResult.SuggestionInfo localSuggestionInfo = (SuggestionResult.SuggestionInfo)paramSuggestionResult.next();
      if ((localSuggestionInfo != null) && (localSuggestionInfo.key != null))
      {
        this.c.add(new a(localSuggestionInfo.key, localSuggestionInfo.city + localSuggestionInfo.district + localSuggestionInfo.key, localSuggestionInfo.pt.latitude, localSuggestionInfo.pt.longitude));
        Log.e("AptitudeEditActivity", "===== " + localSuggestionInfo.key + "    ====    " + localSuggestionInfo.city + localSuggestionInfo.district);
      }
    }
    if (this.d == null)
    {
      this.d = new AptitudeMapListAdapter(this.a, true, this.c);
      this.aptitude_edit_list.setAdapter(this.d);
      this.d.setOnClick(new AptitudeMapListAdapter.a()
      {
        public void onClick(a paramAnonymousa)
        {
          Intent localIntent = AptitudeCertifierNameActivity.this.getIntent();
          localIntent.putExtra("info", paramAnonymousa);
          AptitudeCertifierNameActivity.this.setResult(98, localIntent);
          AptitudeCertifierNameActivity.this.finish();
        }
      });
      return;
    }
    this.d.setmList(this.c);
    this.d.notifyDataSetChanged();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/AptitudeCertifierNameActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */