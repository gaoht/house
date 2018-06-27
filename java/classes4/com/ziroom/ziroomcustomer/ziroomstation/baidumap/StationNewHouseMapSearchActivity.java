package com.ziroom.ziroomcustomer.ziroomstation.baidumap;

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
import android.widget.TextView;
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

public class StationNewHouseMapSearchActivity
  extends BaseActivity
  implements OnGetSuggestionResultListener
{
  private TextView a;
  private ImageView b;
  private EditText c;
  private LinearLayout d;
  private ListView e;
  private FlowLayout f;
  private int g;
  private SuggestionSearch r = null;
  private SimpleAdapter s;
  private List<String> t = new ArrayList();
  private List<Map<String, Object>> u = new ArrayList();
  private String v;
  
  private SimpleAdapter a(List<String> paramList)
  {
    this.u = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("text", str);
      this.u.add(localHashMap);
    }
    this.s = new SimpleAdapter(this, this.u, 2130904489, new String[] { "text" }, new int[] { 2131695219 });
    return this.s;
  }
  
  private void a()
  {
    this.g = getIntent().getIntExtra("requestCode", 0);
    this.a = ((TextView)findViewById(2131690169));
    this.b = ((ImageView)findViewById(2131691648));
    this.c = ((EditText)findViewById(2131690906));
    this.e = ((ListView)findViewById(2131690907));
    this.d = ((LinearLayout)findViewById(2131690908));
    this.f = ((FlowLayout)findViewById(2131690910));
    if ("HouseMapLocationActivity".equals(this.v)) {
      this.c.setHint("你从哪里来?");
    }
    this.a.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        StationNewHouseMapSearchActivity.this.finish();
      }
    });
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        StationNewHouseMapSearchActivity.a(StationNewHouseMapSearchActivity.this).setText("");
      }
    });
    this.c.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() <= 0)
        {
          StationNewHouseMapSearchActivity.b(StationNewHouseMapSearchActivity.this).setVisibility(8);
          StationNewHouseMapSearchActivity.c(StationNewHouseMapSearchActivity.this).setVisibility(0);
          return;
        }
        StationNewHouseMapSearchActivity.d(StationNewHouseMapSearchActivity.this).requestSuggestion(new SuggestionSearchOption().keyword(paramAnonymousCharSequence.toString()).city(b.c));
      }
    });
    this.e.setAdapter(a(this.t));
    this.e.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (String)StationNewHouseMapSearchActivity.e(StationNewHouseMapSearchActivity.this).get(paramAnonymousInt);
        if ("HouseMapLocationActivity".equals(StationNewHouseMapSearchActivity.f(StationNewHouseMapSearchActivity.this)))
        {
          StationNewHouseMapSearchActivity.a(StationNewHouseMapSearchActivity.this, paramAnonymousAdapterView);
          return;
        }
        StationNewHouseMapSearchActivity.b(StationNewHouseMapSearchActivity.this, paramAnonymousAdapterView);
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
        if ("HouseMapLocationActivity".equals(StationNewHouseMapSearchActivity.f(StationNewHouseMapSearchActivity.this)))
        {
          StationNewHouseMapSearchActivity.a(StationNewHouseMapSearchActivity.this, paramAnonymousView);
          return;
        }
        StationNewHouseMapSearchActivity.b(StationNewHouseMapSearchActivity.this, paramAnonymousView);
      }
    });
    paramFlowLayout.addView(localButton);
  }
  
  private void d(String paramString)
  {
    p.save(this, paramString);
    Intent localIntent = new Intent();
    localIntent.putExtra("portName", paramString);
    setResult(this.g, localIntent);
    finish();
  }
  
  private void e(String paramString)
  {
    p.save(this, paramString);
    Intent localIntent = new Intent(this, StationRoutePlanningActivity.class);
    localIntent.putExtra("search_node", paramString);
    localIntent.putExtra("resblock_name", getIntent().getStringExtra("resblock_name"));
    localIntent.putExtra("search_location", getIntent().getStringExtra("search_location"));
    startActivity(localIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903515);
    getWindow().setSoftInputMode(4);
    this.r = SuggestionSearch.newInstance();
    this.r.setOnGetSuggestionResultListener(this);
    this.v = getIntent().getStringExtra("StartActivityName");
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.r.destroy();
  }
  
  public void onGetSuggestionResult(SuggestionResult paramSuggestionResult)
  {
    if ((paramSuggestionResult == null) || (paramSuggestionResult.getAllSuggestions() == null)) {
      return;
    }
    this.t.clear();
    paramSuggestionResult = paramSuggestionResult.getAllSuggestions().iterator();
    while (paramSuggestionResult.hasNext())
    {
      SuggestionResult.SuggestionInfo localSuggestionInfo = (SuggestionResult.SuggestionInfo)paramSuggestionResult.next();
      if ((localSuggestionInfo.key != null) && (b.c.equals(localSuggestionInfo.city.replace("市", "")))) {
        this.t.add(localSuggestionInfo.key);
      }
    }
    if (this.t.size() > 0)
    {
      this.e.setVisibility(0);
      this.d.setVisibility(8);
    }
    this.s = a(this.t);
    this.e.setAdapter(this.s);
    this.s.notifyDataSetChanged();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.f.setVisibility(0);
    Object localObject = p.query(this);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      this.f.removeAllViews();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a((String)((Iterator)localObject).next(), this.f);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/baidumap/StationNewHouseMapSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */