package com.ziroom.ziroomcustomer.signed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionResult.SuggestionInfo;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AptitudeEditActivity
  extends BaseActivity
  implements OnGetSuggestionResultListener
{
  private SuggestionSearch a = null;
  @BindView(2131689946)
  LinearLayout aptitudeEdit_ll_search;
  @BindView(2131689947)
  TextView aptitudeEdit_tv_keyWord;
  @BindView(2131689944)
  ImageView aptitude_edit_clean;
  @BindView(2131689942)
  ListView aptitude_edit_list;
  @BindView(2131689943)
  EditText aptitude_edit_search;
  private List<a> b;
  private AptitudeMapListAdapter c;
  
  private void a()
  {
    this.aptitude_edit_search.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (TextUtils.isEmpty(paramAnonymousEditable.toString())) {
          AptitudeEditActivity.this.aptitudeEdit_ll_search.setVisibility(8);
        }
        if (TextUtils.isEmpty(paramAnonymousEditable.toString()))
        {
          AptitudeEditActivity.this.aptitude_edit_clean.setVisibility(8);
          return;
        }
        AptitudeEditActivity.this.aptitude_edit_clean.setVisibility(0);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AptitudeEditActivity.b(AptitudeEditActivity.this).requestSuggestion(new SuggestionSearchOption().keyword(paramAnonymousCharSequence.toString()).city(b.c));
        paramAnonymousCharSequence.toString();
      }
    });
  }
  
  @OnClick({2131689945, 2131689946, 2131689944})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689945: 
      finish();
      return;
    case 2131689946: 
      AptitudeMapActivity.c.finish();
      paramView = new Intent();
      paramView.putExtra("aptitudemap", this.aptitudeEdit_tv_keyWord.getTag().toString());
      paramView.putExtra("signerPlaceType", 1);
      setResult(200, paramView);
      finish();
      return;
    }
    VdsAgent.trackEditTextSilent(this.aptitude_edit_search).clear();
    this.c.setmList(null);
    this.c.notifyDataSetChanged();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(0);
    setContentView(2130903100);
    ButterKnife.bind(this);
    this.b = new ArrayList();
    this.a = SuggestionSearch.newInstance();
    this.a.setOnGetSuggestionResultListener(this);
    this.c = new AptitudeMapListAdapter(this, true, this.b);
    this.c.setCurrentType(1);
    this.aptitude_edit_list.setAdapter(this.c);
    this.aptitude_edit_list.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        AptitudeMapActivity.c.finish();
        paramAnonymousAdapterView = new Intent(AptitudeEditActivity.this, SignerAptitudeActivity.class);
        paramAnonymousAdapterView.putExtra("aptitudemap", com.alibaba.fastjson.a.toJSONString(AptitudeEditActivity.a(AptitudeEditActivity.this).get(paramAnonymousInt)));
        paramAnonymousAdapterView.addFlags(67108864);
        AptitudeEditActivity.this.setResult(200, paramAnonymousAdapterView);
        AptitudeEditActivity.this.finish();
      }
    });
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.destroy();
  }
  
  public void onGetSuggestionResult(SuggestionResult paramSuggestionResult)
  {
    if ((paramSuggestionResult == null) || (paramSuggestionResult.getAllSuggestions() == null))
    {
      this.aptitudeEdit_ll_search.setVisibility(0);
      ah.setTextColor(this.aptitudeEdit_tv_keyWord, "没有找到结果，点击添加", "没有找到结果，点击添加".length() - 4, 4);
      this.aptitudeEdit_tv_keyWord.setTag("" + VdsAgent.trackEditTextSilent(this.aptitude_edit_search).toString());
      this.c.setmList(null);
      return;
    }
    this.b.clear();
    paramSuggestionResult = paramSuggestionResult.getAllSuggestions().iterator();
    while (paramSuggestionResult.hasNext())
    {
      SuggestionResult.SuggestionInfo localSuggestionInfo = (SuggestionResult.SuggestionInfo)paramSuggestionResult.next();
      if ((localSuggestionInfo != null) && (localSuggestionInfo.key != null) && (localSuggestionInfo.pt != null))
      {
        this.b.add(new a(localSuggestionInfo.key, localSuggestionInfo.city + localSuggestionInfo.district + localSuggestionInfo.key, localSuggestionInfo.pt.latitude, localSuggestionInfo.pt.longitude));
        Log.e("AptitudeEditActivity", "===== " + localSuggestionInfo.key + "    ====    " + localSuggestionInfo.city + localSuggestionInfo.district);
      }
    }
    if ((this.b.size() > 0) && (this.b != null))
    {
      this.c.setmList(this.b);
      return;
    }
    this.aptitudeEdit_ll_search.setVisibility(0);
    ah.setTextColor(this.aptitudeEdit_tv_keyWord, "没有找到结果，点击添加", "没有找到结果，点击添加".length() - 4, 4);
    this.aptitudeEdit_tv_keyWord.setTag("" + VdsAgent.trackEditTextSilent(this.aptitude_edit_search).toString());
    this.c.setmList(null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/AptitudeEditActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */