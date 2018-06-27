package com.ziroom.ziroomcustomer.minsu.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionResult.SuggestionInfo;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.findhouse.model.MapPlanNode;
import com.ziroom.ziroomcustomer.findhouse.widget.ResblockKeywordSearchDialog.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MinsuResblockKeywordSearchDialog
  extends DialogFragment
{
  OnGetSuggestionResultListener a = new OnGetSuggestionResultListener()
  {
    public void onGetSuggestionResult(SuggestionResult paramAnonymousSuggestionResult)
    {
      if ((paramAnonymousSuggestionResult == null) || (paramAnonymousSuggestionResult.getAllSuggestions() == null))
      {
        g.textToast(MinsuResblockKeywordSearchDialog.d(MinsuResblockKeywordSearchDialog.this), "未找到相关结果");
        return;
      }
      MinsuResblockKeywordSearchDialog.a(MinsuResblockKeywordSearchDialog.this).clear();
      int i = 0;
      while (i < paramAnonymousSuggestionResult.getAllSuggestions().size())
      {
        SuggestionResult.SuggestionInfo localSuggestionInfo = (SuggestionResult.SuggestionInfo)paramAnonymousSuggestionResult.getAllSuggestions().get(i);
        if ((localSuggestionInfo.pt != null) && (localSuggestionInfo.pt.longitude != 0.0D) && (localSuggestionInfo.pt.latitude != 0.0D)) {
          MinsuResblockKeywordSearchDialog.a(MinsuResblockKeywordSearchDialog.this).add(localSuggestionInfo);
        }
        i += 1;
      }
      MinsuResblockKeywordSearchDialog.b(MinsuResblockKeywordSearchDialog.this).notifyDataSetChanged();
    }
  };
  private Context b;
  private View c;
  private EditText d;
  private TextView e;
  private ListView f;
  private a g;
  private SuggestionSearch h;
  private String i = "";
  private List<SuggestionResult.SuggestionInfo> j = new ArrayList();
  private ResblockKeywordSearchDialog.b k;
  
  private void a()
  {
    getDialog().requestWindowFeature(1);
    getDialog().getWindow().setWindowAnimations(2131427507);
    getDialog().getWindow().getDecorView().setPadding(0, 0, 0, 0);
    getDialog().getWindow().setBackgroundDrawableResource(2131624576);
    getDialog().getWindow().setLayout(-1, -1);
  }
  
  private void a(String paramString)
  {
    this.i = paramString;
    this.h.requestSuggestion(new SuggestionSearchOption().keyword(paramString).city(""));
  }
  
  private void b()
  {
    this.d = ((EditText)this.c.findViewById(2131690906));
    this.e = ((TextView)this.c.findViewById(2131690169));
    this.f = ((ListView)this.c.findViewById(2131690907));
    this.h = SuggestionSearch.newInstance();
    this.h.setOnGetSuggestionResultListener(this.a);
    this.g = new a(null);
    this.f.setAdapter(this.g);
    this.d.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (TextUtils.isEmpty(paramAnonymousEditable.toString()))
        {
          MinsuResblockKeywordSearchDialog.a(MinsuResblockKeywordSearchDialog.this).clear();
          MinsuResblockKeywordSearchDialog.b(MinsuResblockKeywordSearchDialog.this).notifyDataSetChanged();
          return;
        }
        MinsuResblockKeywordSearchDialog.a(MinsuResblockKeywordSearchDialog.this, paramAnonymousEditable.toString());
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = MinsuResblockKeywordSearchDialog.d(MinsuResblockKeywordSearchDialog.this);
        MinsuResblockKeywordSearchDialog.d(MinsuResblockKeywordSearchDialog.this);
        ((InputMethodManager)paramAnonymousView.getSystemService("input_method")).hideSoftInputFromWindow(MinsuResblockKeywordSearchDialog.c(MinsuResblockKeywordSearchDialog.this).getWindowToken(), 0);
        MinsuResblockKeywordSearchDialog.this.dismiss();
      }
    });
    this.d.requestFocus();
    new Timer().schedule(new TimerTask()
    {
      public void run()
      {
        InputMethodManager localInputMethodManager = (InputMethodManager)MinsuResblockKeywordSearchDialog.d(MinsuResblockKeywordSearchDialog.this).getSystemService("input_method");
        localInputMethodManager.showSoftInput(MinsuResblockKeywordSearchDialog.c(MinsuResblockKeywordSearchDialog.this), 2);
        localInputMethodManager.toggleSoftInput(2, 1);
      }
    }, 300L);
  }
  
  public static MinsuResblockKeywordSearchDialog newInstance()
  {
    return new MinsuResblockKeywordSearchDialog();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = paramLayoutInflater.inflate(2130904793, paramViewGroup);
    this.b = getActivity();
    a();
    b();
    return this.c;
  }
  
  public void setOnSelectListener(ResblockKeywordSearchDialog.b paramb)
  {
    this.k = paramb;
  }
  
  private class a
    extends BaseAdapter
  {
    private a() {}
    
    private void a(TextView paramTextView, String paramString)
    {
      int k = 0;
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      int j = 0;
      while (i < paramString.length())
      {
        j = paramString.indexOf(MinsuResblockKeywordSearchDialog.f(MinsuResblockKeywordSearchDialog.this), j);
        if (j == -1) {
          break;
        }
        localArrayList.add(Integer.valueOf(j));
        j += 1;
        i += 1;
      }
      paramString = new SpannableString(paramString);
      i = k;
      while (i < localArrayList.size())
      {
        paramString.setSpan(new ForegroundColorSpan(MinsuResblockKeywordSearchDialog.d(MinsuResblockKeywordSearchDialog.this).getResources().getColor(2131624588)), ((Integer)localArrayList.get(i)).intValue(), ((Integer)localArrayList.get(i)).intValue() + MinsuResblockKeywordSearchDialog.f(MinsuResblockKeywordSearchDialog.this).length(), 17);
        i += 1;
      }
      paramTextView.setText(paramString);
    }
    
    public int getCount()
    {
      return MinsuResblockKeywordSearchDialog.a(MinsuResblockKeywordSearchDialog.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return MinsuResblockKeywordSearchDialog.a(MinsuResblockKeywordSearchDialog.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = LayoutInflater.from(MinsuResblockKeywordSearchDialog.d(MinsuResblockKeywordSearchDialog.this)).inflate(2130904482, null, false);
      paramViewGroup = (TextView)paramView.findViewById(2131690049);
      TextView localTextView = (TextView)paramView.findViewById(2131694300);
      final SuggestionResult.SuggestionInfo localSuggestionInfo = (SuggestionResult.SuggestionInfo)MinsuResblockKeywordSearchDialog.a(MinsuResblockKeywordSearchDialog.this).get(paramInt);
      if (localSuggestionInfo == null) {
        return new View(MinsuResblockKeywordSearchDialog.d(MinsuResblockKeywordSearchDialog.this));
      }
      a(paramViewGroup, localSuggestionInfo.key);
      localTextView.setText(localSuggestionInfo.district);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = MinsuResblockKeywordSearchDialog.d(MinsuResblockKeywordSearchDialog.this);
          MinsuResblockKeywordSearchDialog.d(MinsuResblockKeywordSearchDialog.this);
          ((InputMethodManager)paramAnonymousView.getSystemService("input_method")).hideSoftInputFromWindow(MinsuResblockKeywordSearchDialog.c(MinsuResblockKeywordSearchDialog.this).getWindowToken(), 0);
          paramAnonymousView = new MapPlanNode();
          paramAnonymousView.setName(localSuggestionInfo.key);
          paramAnonymousView.setLatlng(localSuggestionInfo.pt);
          if (MinsuResblockKeywordSearchDialog.e(MinsuResblockKeywordSearchDialog.this) != null) {
            MinsuResblockKeywordSearchDialog.e(MinsuResblockKeywordSearchDialog.this).onSelect(paramAnonymousView);
          }
          paramAnonymousView = MinsuResblockKeywordSearchDialog.d(MinsuResblockKeywordSearchDialog.this);
          MinsuResblockKeywordSearchDialog.d(MinsuResblockKeywordSearchDialog.this);
          ((InputMethodManager)paramAnonymousView.getSystemService("input_method")).hideSoftInputFromWindow(MinsuResblockKeywordSearchDialog.c(MinsuResblockKeywordSearchDialog.this).getWindowToken(), 0);
          MinsuResblockKeywordSearchDialog.this.dismiss();
        }
      });
      return paramView;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/dialog/MinsuResblockKeywordSearchDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */