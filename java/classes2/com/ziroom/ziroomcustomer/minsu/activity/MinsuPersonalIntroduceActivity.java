package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MinsuPersonalIntroduceActivity
  extends BaseActivity
{
  @BindView(2131690084)
  EditText etContent;
  @BindView(2131689997)
  TextView tvSubmit;
  
  private void a()
  {
    CommonTitle localCommonTitle = (CommonTitle)findViewById(2131691272);
    localCommonTitle.setLeftButtonType(0);
    localCommonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuPersonalIntroduceActivity.this.finish();
      }
    });
    localCommonTitle.setMiddleText("个人介绍");
  }
  
  private void b()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getIntroduce(this, null, new s(this, new r(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        Object localObject = com.alibaba.fastjson.a.parseObject(paramAnonymousString);
        paramAnonymousString = null;
        ((e)localObject).getJSONObject("data");
        localObject = ((Map)((e)localObject).getObject("data", Map.class)).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(paramAnonymousString)) {
            break;
          }
          paramAnonymousString = (String)localEntry.getValue();
        }
        MinsuPersonalIntroduceActivity.this.etContent.setText(paramAnonymousString);
      }
    });
  }
  
  @OnClick({2131689997})
  public void onClick()
  {
    final String str = VdsAgent.trackEditTextSilent(this.etContent).toString();
    if ((TextUtils.isEmpty(str)) || (str.trim().length() < 100))
    {
      showToast("请填写100-500字的个人介绍");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("customerIntroduce", str);
    com.ziroom.ziroomcustomer.minsu.e.a.saveIntroduce(this, localHashMap, new s(this, new r(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        MinsuPersonalIntroduceActivity.this.showToast("提交成功");
        paramAnonymousString = new Intent();
        paramAnonymousString.putExtra("introduce", str);
        MinsuPersonalIntroduceActivity.this.setResult(-1, paramAnonymousString);
        MinsuPersonalIntroduceActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setContentView(2130903322);
    ButterKnife.bind(this);
    a();
    b();
    this.etContent.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        paramAnonymousEditable = VdsAgent.trackEditTextSilent(MinsuPersonalIntroduceActivity.this.etContent).toString();
        if (TextUtils.isEmpty(paramAnonymousEditable))
        {
          MinsuPersonalIntroduceActivity.this.tvSubmit.setBackgroundColor(MinsuPersonalIntroduceActivity.this.getResources().getColor(2131624470));
          return;
        }
        if (TextUtils.isEmpty(paramAnonymousEditable.trim()))
        {
          MinsuPersonalIntroduceActivity.this.tvSubmit.setBackgroundColor(MinsuPersonalIntroduceActivity.this.getResources().getColor(2131624470));
          return;
        }
        MinsuPersonalIntroduceActivity.this.tvSubmit.setBackgroundColor(MinsuPersonalIntroduceActivity.this.getResources().getColor(2131624588));
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuPersonalIntroduceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */