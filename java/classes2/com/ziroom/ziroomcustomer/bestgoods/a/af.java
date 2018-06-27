package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.bestgoods.model.ao.c;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.List;

public class af
  extends BaseAdapter
{
  private Context a;
  private List<ao.c> b;
  
  public af(Context paramContext, List<ao.c> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  private void a(SpannableString paramSpannableString, final String paramString, int paramInt)
  {
    paramSpannableString.setSpan(new ClickableSpan()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (!TextUtils.isEmpty(paramString)) {
          ah.callPhone(af.a(af.this), paramString);
        }
        af.a(af.this, paramAnonymousView);
      }
      
      public void updateDrawState(TextPaint paramAnonymousTextPaint)
      {
        super.updateDrawState(paramAnonymousTextPaint);
        paramAnonymousTextPaint.setColor(40960);
      }
    }, paramInt, paramString.length() + paramInt, 0);
  }
  
  private void a(View paramView)
  {
    if ((paramView instanceof TextView)) {
      ((TextView)paramView).setHighlightColor(this.a.getResources().getColor(17170445));
    }
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int m = 0;
    label118:
    String str;
    Object localObject;
    label189:
    label206:
    ArrayList localArrayList;
    label230:
    int j;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = LayoutInflater.from(this.a).inflate(2130904594, null);
      paramViewGroup.a = ((ImageView)paramView.findViewById(2131694874));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695039));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131694876));
      paramViewGroup.d = paramView.findViewById(2131690678);
      paramView.setTag(paramViewGroup);
      if (this.b.size() > 0)
      {
        if (this.b.size() != 1) {
          break label392;
        }
        paramViewGroup.d.setVisibility(8);
      }
      str = ((ao.c)this.b.get(paramInt)).getAcceptStation();
      localObject = ((ao.c)this.b.get(paramInt)).getAcceptTime();
      this.b.size();
      if (paramInt != 0) {
        break label430;
      }
      paramViewGroup.a.setBackgroundResource(2130840250);
      paramViewGroup.b.setTextColor(Color.parseColor("#FFA000"));
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label454;
      }
      paramViewGroup.c.setVisibility(8);
      localObject = j.getNumbers(str);
      localArrayList = new ArrayList();
      if (localObject == null) {
        break label483;
      }
      i = 0;
      if (i >= ((List)localObject).size()) {
        break label647;
      }
      j = ((String)((List)localObject).get(i)).length();
      if ((j != 5) && (j != 8) && (j != 10) && (j != 11)) {
        break label474;
      }
    }
    label392:
    label430:
    label454:
    label474:
    label483:
    label647:
    for (int i = 1;; i = 0)
    {
      localArrayList.clear();
      j = 0;
      for (;;)
      {
        k = i;
        if (j >= ((List)localObject).size()) {
          break;
        }
        k = ((String)((List)localObject).get(j)).length();
        if ((k == 5) || (k == 8) || (k == 10) || (k == 11)) {
          localArrayList.add(((List)localObject).get(j));
        }
        j += 1;
      }
      paramViewGroup = (a)paramView.getTag();
      break;
      if (paramInt == this.b.size() - 1)
      {
        paramViewGroup.d.setVisibility(8);
        break label118;
      }
      paramViewGroup.d.setVisibility(0);
      break label118;
      paramViewGroup.a.setBackgroundResource(2130840254);
      paramViewGroup.b.setTextColor(Color.parseColor("#666666"));
      break label189;
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.setText((CharSequence)localObject);
      break label206;
      i += 1;
      break label230;
      int k = 0;
      SpannableString localSpannableString = new SpannableString(str);
      if (k != 0)
      {
        if (paramInt == 0) {}
        for (localObject = new ForegroundColorSpan(40960);; localObject = new ForegroundColorSpan(-10066330))
        {
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 34);
          if (localArrayList == null) {
            break;
          }
          paramInt = m;
          while (paramInt < localArrayList.size())
          {
            localObject = (String)localArrayList.get(paramInt);
            i = str.indexOf((String)localObject);
            u.d("sdjkgjkd", "=======    " + i);
            a(localSpannableString, (String)localObject, i);
            paramInt += 1;
          }
        }
      }
      paramViewGroup.b.setText(localSpannableString);
      paramViewGroup.b.setMovementMethod(LinkMovementMethod.getInstance());
      return paramView;
    }
  }
  
  public class a
  {
    public ImageView a;
    public TextView b;
    public TextView c;
    public View d;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */