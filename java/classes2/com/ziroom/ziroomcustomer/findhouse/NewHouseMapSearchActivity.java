package com.ziroom.ziroomcustomer.findhouse;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionResult.SuggestionInfo;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.b.p;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.widget.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NewHouseMapSearchActivity
  extends BaseActivity
  implements OnGetSuggestionResultListener
{
  private ImageView a;
  private EditText b;
  private LinearLayout c;
  private ListView d;
  private FlowLayout e;
  private int f;
  private SuggestionSearch g = null;
  private SimpleAdapter r;
  private List<String> s = new ArrayList();
  private List<Map<String, Object>> t = new ArrayList();
  private String u;
  
  private SimpleAdapter a(List<String> paramList)
  {
    this.t = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("text", str);
      this.t.add(localHashMap);
    }
    this.r = new SimpleAdapter(this, this.t, 2130904489, new String[] { "text" }, new int[] { 2131695219 });
    return this.r;
  }
  
  private void a()
  {
    this.f = getIntent().getIntExtra("requestCode", 0);
    this.a = ((ImageView)findViewById(2131690078));
    this.b = ((EditText)findViewById(2131690906));
    this.d = ((ListView)findViewById(2131690907));
    this.c = ((LinearLayout)findViewById(2131690908));
    this.e = ((FlowLayout)findViewById(2131690910));
    if ("HouseMapLocationActivity".equals(this.u)) {
      this.b.setHint("你从哪里来?");
    }
    this.a.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        NewHouseMapSearchActivity.this.finish();
      }
    });
    this.b.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() <= 0)
        {
          NewHouseMapSearchActivity.a(NewHouseMapSearchActivity.this).setVisibility(8);
          NewHouseMapSearchActivity.b(NewHouseMapSearchActivity.this).setVisibility(0);
          return;
        }
        NewHouseMapSearchActivity.c(NewHouseMapSearchActivity.this).requestSuggestion(new SuggestionSearchOption().keyword(paramAnonymousCharSequence.toString()).city(b.c));
      }
    });
    this.d.setAdapter(a(this.s));
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (String)NewHouseMapSearchActivity.d(NewHouseMapSearchActivity.this).get(paramAnonymousInt);
        if ("HouseMapLocationActivity".equals(NewHouseMapSearchActivity.e(NewHouseMapSearchActivity.this)))
        {
          NewHouseMapSearchActivity.a(NewHouseMapSearchActivity.this, paramAnonymousAdapterView);
          return;
        }
        NewHouseMapSearchActivity.b(NewHouseMapSearchActivity.this, paramAnonymousAdapterView);
      }
    });
  }
  
  private void a(String paramString, FlowLayout paramFlowLayout)
  {
    Button localButton = new Button(this);
    localButton.setText(paramString);
    localButton.setTextColor(getResources().getColor(2131624534));
    localButton.setTextSize(14.0F);
    localButton.setBackgroundDrawable(getResources().getDrawable(2130839574));
    localButton.setPadding(35, 15, 35, 15);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(40, 30, 0, 0);
    localButton.setLayoutParams(paramString);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = ((Button)paramAnonymousView).getText().toString();
        if ("HouseMapLocationActivity".equals(NewHouseMapSearchActivity.e(NewHouseMapSearchActivity.this)))
        {
          NewHouseMapSearchActivity.a(NewHouseMapSearchActivity.this, paramAnonymousView);
          return;
        }
        NewHouseMapSearchActivity.b(NewHouseMapSearchActivity.this, paramAnonymousView);
      }
    });
    paramFlowLayout.addView(localButton);
  }
  
  private void d(String paramString)
  {
    p.save(this, paramString);
    Intent localIntent = new Intent();
    localIntent.putExtra("portName", paramString);
    setResult(this.f, localIntent);
    finish();
  }
  
  private void e(String paramString)
  {
    p.save(this, paramString);
    Intent localIntent = new Intent(this, RoutePlanningActivity.class);
    localIntent.putExtra("search_node", paramString);
    localIntent.putExtra("resblock_name", getIntent().getStringExtra("resblock_name"));
    startActivity(localIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903208);
    getWindow().setSoftInputMode(4);
    this.g = SuggestionSearch.newInstance();
    this.g.setOnGetSuggestionResultListener(this);
    this.u = getIntent().getStringExtra("StartActivityName");
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.g.destroy();
  }
  
  public void onGetSuggestionResult(SuggestionResult paramSuggestionResult)
  {
    if ((paramSuggestionResult == null) || (paramSuggestionResult.getAllSuggestions() == null)) {
      return;
    }
    this.s.clear();
    paramSuggestionResult = paramSuggestionResult.getAllSuggestions().iterator();
    while (paramSuggestionResult.hasNext())
    {
      SuggestionResult.SuggestionInfo localSuggestionInfo = (SuggestionResult.SuggestionInfo)paramSuggestionResult.next();
      if ((localSuggestionInfo.key != null) && (b.c.equals(localSuggestionInfo.city.replace("市", "")))) {
        this.s.add(localSuggestionInfo.key);
      }
    }
    if (this.s.size() > 0)
    {
      this.d.setVisibility(0);
      this.c.setVisibility(8);
    }
    this.r = a(this.s);
    this.d.setAdapter(this.r);
    this.r.notifyDataSetChanged();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.e.setVisibility(0);
    Object localObject = p.query(this);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      this.e.removeAllViews();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a((String)((Iterator)localObject).next(), this.e);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/NewHouseMapSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */