package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHDicTag;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHNeedTag;
import com.ziroom.ziroomcustomer.newmovehouse.model.ServiceDicItem;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MoveSpecialActivity
  extends BaseActivity
{
  private Unbinder a;
  private Context b;
  private List<ServiceDicItem> c = new ArrayList();
  private List<MHDicTag> d = new ArrayList();
  private String e;
  @BindView(2131690002)
  EditText et_remark;
  private boolean f;
  @BindView(2131690332)
  FlowLayout fl_like;
  private List<MHNeedTag> g = new ArrayList();
  @BindView(2131689956)
  TextView tv_commit;
  @BindView(2131691765)
  TextView tv_wordnum;
  
  private void a()
  {
    String str1 = getIntent().getExtras().getString("lastInput");
    String str2 = getIntent().getExtras().getString("lastTag");
    if (!TextUtils.isEmpty(str1))
    {
      this.et_remark.setText(str1);
      this.tv_wordnum.setText(str1.length() + "/");
    }
    if (!TextUtils.isEmpty(str2)) {
      this.e = str2;
    }
    f();
    this.f = getIntent().getBooleanExtra("isMovingVan", false);
    if (this.f) {
      d("CustomerOrderSpecialNeedTag");
    }
    for (;;)
    {
      this.et_remark.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          if (paramAnonymousEditable.length() > 140)
          {
            MoveSpecialActivity.this.tv_wordnum.setText("140/");
            g.textToast(MoveSpecialActivity.a(MoveSpecialActivity.this), "字数超出限制！");
            MoveSpecialActivity.this.et_remark.setText(paramAnonymousEditable.subSequence(0, 140));
            MoveSpecialActivity.this.et_remark.setSelection(MoveSpecialActivity.this.et_remark.length());
          }
          for (;;)
          {
            MoveSpecialActivity.b(MoveSpecialActivity.this);
            return;
            MoveSpecialActivity.this.tv_wordnum.setText(paramAnonymousEditable.length() + "/");
          }
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      return;
      e("WorkOrderCharacterEnum");
    }
  }
  
  private void b()
  {
    if (this.g.size() == 0) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.et_remark).toString());
      if ((i == 0) || (!bool)) {
        break;
      }
      g.textToast(this.b, "请先选择标签或者填写备注");
      return;
    }
    Object localObject2 = "";
    this.e = "";
    Object localObject1 = localObject2;
    if (this.g != null)
    {
      localObject1 = localObject2;
      if (this.g.size() > 0)
      {
        localObject2 = this.g.iterator();
        localObject1 = "";
        if (((Iterator)localObject2).hasNext())
        {
          MHNeedTag localMHNeedTag = (MHNeedTag)((Iterator)localObject2).next();
          if (this.g.size() == 1) {
            this.e = localMHNeedTag.getTagName();
          }
          for (localObject1 = localMHNeedTag.getTagId();; localObject1 = (String)localObject1 + "," + localMHNeedTag.getTagId())
          {
            break;
            this.e = (this.e + "," + localMHNeedTag.getTagName());
          }
        }
      }
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("TagStr", this.e);
    ((Intent)localObject2).putExtra("NeedTagId", (String)localObject1);
    ((Intent)localObject2).putExtra("Remark", VdsAgent.trackEditTextSilent(this.et_remark).toString());
    setResult(-1, (Intent)localObject2);
    finish();
  }
  
  private void d(String paramString)
  {
    com.ziroom.ziroomcustomer.e.n.getServiceDic(this, paramString, new com.freelxl.baselibrary.d.c.a(new l(ServiceDicItem.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, List<ServiceDicItem> paramAnonymousList)
      {
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          MoveSpecialActivity.a(MoveSpecialActivity.this, paramAnonymousList);
          ArrayList localArrayList = new ArrayList();
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext()) {
            localArrayList.add(((ServiceDicItem)paramAnonymousList.next()).getDictionaryValue());
          }
          MoveSpecialActivity.this.getNeedFlikTag(localArrayList);
          MoveSpecialActivity.c(MoveSpecialActivity.this);
        }
      }
    });
  }
  
  private void e()
  {
    if (TextUtils.isEmpty(this.e)) {}
    for (;;)
    {
      return;
      String[] arrayOfString = this.e.split(",");
      int i = 0;
      while (i < this.fl_like.getChildCount())
      {
        Button localButton = (Button)this.fl_like.getChildAt(i);
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equals(localButton.getText()))
          {
            g(arrayOfString[j]);
            localButton.setBackgroundResource(2130838211);
            localButton.setTextColor(-1);
            localButton.setTag(Boolean.valueOf(true));
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  private void e(String paramString)
  {
    com.ziroom.ziroomcustomer.e.n.getCommonDicTag(this.b, paramString, new com.freelxl.baselibrary.d.c.a(new l(MHDicTag.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, List<MHDicTag> paramAnonymousList)
      {
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          MoveSpecialActivity.b(MoveSpecialActivity.this, paramAnonymousList);
          ArrayList localArrayList = new ArrayList();
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext()) {
            localArrayList.add(((MHDicTag)paramAnonymousList.next()).getTagValue());
          }
          MoveSpecialActivity.this.getNeedFlikTag(localArrayList);
          MoveSpecialActivity.c(MoveSpecialActivity.this);
        }
      }
    });
  }
  
  private void f()
  {
    int j = 1;
    int i;
    if ((this.g != null) && (this.g.size() > 0))
    {
      i = 1;
      if (TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.et_remark).toString())) {
        break label63;
      }
    }
    for (;;)
    {
      if ((i == 0) && (j == 0)) {
        break label68;
      }
      this.tv_commit.setTextColor(40960);
      return;
      i = 0;
      break;
      label63:
      j = 0;
    }
    label68:
    this.tv_commit.setTextColor(-6710887);
  }
  
  private void f(String paramString)
  {
    if (this.g == null) {
      return;
    }
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals(((MHNeedTag)localIterator.next()).getTagName())) {
        localIterator.remove();
      }
    }
    f();
  }
  
  private void g(String paramString)
  {
    if (this.f) {
      if (this.c != null) {}
    }
    Object localObject;
    MHNeedTag localMHNeedTag;
    while (this.d == null)
    {
      return;
      localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        localObject = (ServiceDicItem)localIterator.next();
        if (paramString.equals(((ServiceDicItem)localObject).getDictionaryValue()))
        {
          localMHNeedTag = new MHNeedTag();
          localMHNeedTag.setTagName(paramString);
          localMHNeedTag.setTagId(((ServiceDicItem)localObject).getDictionaryIndex() + "");
          this.g.add(localMHNeedTag);
        }
      }
    }
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      localObject = (MHDicTag)localIterator.next();
      if (paramString.equals(((MHDicTag)localObject).getTagValue()))
      {
        localMHNeedTag = new MHNeedTag();
        localMHNeedTag.setTagName(paramString);
        localMHNeedTag.setTagId(((MHDicTag)localObject).getTagKey());
        this.g.add(localMHNeedTag);
      }
    }
    f();
  }
  
  public void getNeedFlikTag(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (String)paramList.next();
        Button localButton = new Button(this);
        localButton.setText((CharSequence)localObject);
        localButton.setTag(Boolean.valueOf(false));
        localButton.setTextColor(-6710887);
        localButton.setTextSize(12.0F);
        localButton.setPadding(com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 6.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 6.0F));
        localButton.setBackgroundResource(2130838210);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject).setMargins(0, com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 12.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 12.0F), 0);
        localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localButton.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = (Button)paramAnonymousView;
            String str = paramAnonymousView.getText().toString();
            if (!((Boolean)paramAnonymousView.getTag()).booleanValue())
            {
              paramAnonymousView.setBackgroundResource(2130838211);
              paramAnonymousView.setTextColor(-1);
              paramAnonymousView.setTag(Boolean.valueOf(true));
              MoveSpecialActivity.a(MoveSpecialActivity.this, str);
              return;
            }
            paramAnonymousView.setBackgroundResource(2130838210);
            paramAnonymousView.setTextColor(-6710887);
            paramAnonymousView.setTag(Boolean.valueOf(false));
            MoveSpecialActivity.b(MoveSpecialActivity.this, str);
          }
        });
        this.fl_like.addView(localButton);
      }
    }
  }
  
  @OnClick({2131689492, 2131689956})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    }
    b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903355);
    this.b = this;
    this.a = ButterKnife.bind(this);
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.unbind();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MoveSpecialActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */