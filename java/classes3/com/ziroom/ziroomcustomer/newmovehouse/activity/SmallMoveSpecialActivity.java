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
import com.freelxl.baselibrary.d.f.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHNeedTag;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveSpecialNeedBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.ServiceDicItem;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SmallMoveSpecialActivity
  extends BaseActivity
{
  private String a;
  private Unbinder b;
  private Context c;
  private List<ServiceDicItem> d = new ArrayList();
  private List<MoveSpecialNeedBean> e = new ArrayList();
  @BindView(2131690002)
  EditText et_remark;
  private String f;
  @BindView(2131690332)
  FlowLayout fl_like;
  private boolean g;
  private List<MHNeedTag> r = new ArrayList();
  @BindView(2131689956)
  TextView tv_commit;
  @BindView(2131691765)
  TextView tv_wordnum;
  
  private void a()
  {
    this.a = getIntent().getStringExtra("serviceInfoId");
    String str1 = getIntent().getExtras().getString("lastInput");
    String str2 = getIntent().getExtras().getString("lastTag");
    if (!TextUtils.isEmpty(str1))
    {
      this.et_remark.setText(str1);
      this.tv_wordnum.setText(str1.length() + "/");
    }
    if (!TextUtils.isEmpty(str2)) {
      this.f = str2;
    }
    f();
    this.g = getIntent().getBooleanExtra("isMovingVan", false);
    if ("8a908eb161d66afc0161fa59fd210009".equals(this.a)) {
      d("WorkOrderCharacterXmEnum");
    }
    for (;;)
    {
      this.et_remark.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          if (paramAnonymousEditable.length() > 140)
          {
            SmallMoveSpecialActivity.this.tv_wordnum.setText("140/");
            g.textToast(SmallMoveSpecialActivity.a(SmallMoveSpecialActivity.this), "字数超出限制！");
            SmallMoveSpecialActivity.this.et_remark.setText(paramAnonymousEditable.subSequence(0, 140));
            SmallMoveSpecialActivity.this.et_remark.setSelection(SmallMoveSpecialActivity.this.et_remark.length());
          }
          for (;;)
          {
            SmallMoveSpecialActivity.b(SmallMoveSpecialActivity.this);
            return;
            SmallMoveSpecialActivity.this.tv_wordnum.setText(paramAnonymousEditable.length() + "/");
          }
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      return;
      if ("2c9085f248ba3f3a0148bb156f6e0004".equals(this.a)) {
        d("WorkOrderCharacterEnum");
      } else if ("8a90a5f8593e65b501593e65b5200000".equals(this.a)) {
        d("CustomerOrderSpecialNeedTag");
      }
    }
  }
  
  private void b()
  {
    int j = 0;
    if (this.r.size() == 0) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.et_remark).toString());
      if ((i == 0) || (!bool)) {
        break;
      }
      g.textToast(this.c, "请先选择标签或者填写备注");
      return;
    }
    Object localObject2 = "";
    this.f = "";
    Object localObject1 = localObject2;
    if (this.r != null)
    {
      localObject1 = localObject2;
      if (this.r.size() > 0)
      {
        localObject1 = "";
        i = j;
        if (i < this.r.size())
        {
          if (i == 0) {
            this.f = ((MHNeedTag)this.r.get(i)).getTagName();
          }
          for (localObject1 = ((MHNeedTag)this.r.get(i)).getTagId();; localObject1 = (String)localObject1 + "," + ((MHNeedTag)this.r.get(i)).getTagId())
          {
            i += 1;
            break;
            this.f = (this.f + "," + ((MHNeedTag)this.r.get(i)).getTagName());
          }
        }
      }
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("TagStr", this.f);
    ((Intent)localObject2).putExtra("NeedTagId", (String)localObject1);
    ((Intent)localObject2).putExtra("Remark", VdsAgent.trackEditTextSilent(this.et_remark).toString());
    setResult(-1, (Intent)localObject2);
    finish();
  }
  
  private void d(String paramString)
  {
    com.ziroom.ziroomcustomer.e.n.getSmallMoveCommonDicTag(this.c, paramString, new d(this.c, new e(MoveSpecialNeedBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<MoveSpecialNeedBean> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          SmallMoveSpecialActivity.a(SmallMoveSpecialActivity.this, paramAnonymousList);
          ArrayList localArrayList = new ArrayList();
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext()) {
            localArrayList.add(((MoveSpecialNeedBean)paramAnonymousList.next()).getDictionaryValue());
          }
          SmallMoveSpecialActivity.this.getNeedFlikTag(localArrayList);
          SmallMoveSpecialActivity.c(SmallMoveSpecialActivity.this);
        }
      }
    });
  }
  
  private void e()
  {
    if (TextUtils.isEmpty(this.f)) {}
    for (;;)
    {
      return;
      String[] arrayOfString = this.f.split(",");
      int i = 0;
      while (i < this.fl_like.getChildCount())
      {
        Button localButton = (Button)this.fl_like.getChildAt(i);
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equals(localButton.getText()))
          {
            f(arrayOfString[j]);
            localButton.setBackgroundResource(2130840419);
            localButton.setTextColor(40960);
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
    if (this.r == null) {
      return;
    }
    Iterator localIterator = this.r.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals(((MHNeedTag)localIterator.next()).getTagName())) {
        localIterator.remove();
      }
    }
    f();
  }
  
  private void f()
  {
    int j = 1;
    int i;
    if ((this.r != null) && (this.r.size() > 0))
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
    if (this.g) {
      if (this.d != null) {}
    }
    Object localObject;
    MHNeedTag localMHNeedTag;
    while (this.e == null)
    {
      return;
      localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        localObject = (ServiceDicItem)localIterator.next();
        if (paramString.equals(((ServiceDicItem)localObject).getDictionaryValue()))
        {
          localMHNeedTag = new MHNeedTag();
          localMHNeedTag.setTagName(paramString);
          localMHNeedTag.setTagId(((ServiceDicItem)localObject).getDictionaryIndex() + "");
          this.r.add(localMHNeedTag);
        }
      }
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      localObject = (MoveSpecialNeedBean)localIterator.next();
      if (paramString.equals(((MoveSpecialNeedBean)localObject).getDictionaryValue()))
      {
        localMHNeedTag = new MHNeedTag();
        localMHNeedTag.setTagName(paramString);
        localMHNeedTag.setTagId(((MoveSpecialNeedBean)localObject).getDictionaryIndex() + "");
        this.r.add(localMHNeedTag);
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
        localButton.setPadding(com.ziroom.ziroomcustomer.util.n.dip2px(this.c, 12.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.c, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.c, 12.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.c, 8.0F));
        localButton.setBackgroundResource(2130840415);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, com.ziroom.ziroomcustomer.util.n.dip2px(this.c, 12.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.c, 12.0F));
        localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localButton.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            int i = 0;
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = (Button)paramAnonymousView;
            String str = paramAnonymousView.getText().toString();
            if (!((Boolean)paramAnonymousView.getTag()).booleanValue())
            {
              paramAnonymousView.setBackgroundResource(2130840419);
              paramAnonymousView.setTextColor(40960);
              paramAnonymousView.setTag(Boolean.valueOf(true));
              SmallMoveSpecialActivity.a(SmallMoveSpecialActivity.this, str);
            }
            while ((TextUtils.isEmpty(VdsAgent.trackEditTextSilent(SmallMoveSpecialActivity.this.et_remark).toString())) && (SmallMoveSpecialActivity.d(SmallMoveSpecialActivity.this) != null) && (SmallMoveSpecialActivity.d(SmallMoveSpecialActivity.this).size() > 0))
            {
              int j = 0;
              for (;;)
              {
                if (i < SmallMoveSpecialActivity.d(SmallMoveSpecialActivity.this).size())
                {
                  if ("4".equals(((MHNeedTag)SmallMoveSpecialActivity.d(SmallMoveSpecialActivity.this).get(i)).getTagId())) {
                    j = 1;
                  }
                  i += 1;
                  continue;
                  paramAnonymousView.setBackgroundResource(2130840415);
                  paramAnonymousView.setTextColor(-6710887);
                  paramAnonymousView.setTag(Boolean.valueOf(false));
                  SmallMoveSpecialActivity.b(SmallMoveSpecialActivity.this, str);
                  break;
                }
              }
              if (j == 0) {
                break label213;
              }
              SmallMoveSpecialActivity.this.et_remark.setHint("请填写您的指定师傅姓名及其他备注信息");
            }
            return;
            label213:
            SmallMoveSpecialActivity.this.et_remark.setHint("请填写您的其他备注消息");
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
    setContentView(2130903351);
    this.c = this;
    this.b = ButterKnife.bind(this);
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.b.unbind();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/SmallMoveSpecialActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */