package com.ziroom.ziroomcustomer.findhouse.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.R.styleable;
import java.util.ArrayList;
import java.util.List;

public class PasswordInputView
  extends RelativeLayout
{
  private Context a;
  private float b;
  private List<TextView> c = new ArrayList();
  private StringBuilder d = new StringBuilder();
  private int e = 6;
  private int f;
  private int g;
  private int h = 2130839616;
  private int i;
  private int j;
  private int k;
  private boolean l = true;
  
  public PasswordInputView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PasswordInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PasswordInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a(paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.b = this.a.getResources().getDisplayMetrics().density;
    setBackgroundColor(this.i);
    d();
    b();
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    AttributeSet localAttributeSet = null;
    try
    {
      paramAttributeSet = this.a.obtainStyledAttributes(paramAttributeSet, R.styleable.PasswordInputView);
      localAttributeSet = paramAttributeSet;
      this.e = paramAttributeSet.getInt(0, 6);
      localAttributeSet = paramAttributeSet;
      this.f = paramAttributeSet.getDimensionPixelSize(1, (int)TypedValue.applyDimension(1, 18.0F, this.a.getResources().getDisplayMetrics()));
      localAttributeSet = paramAttributeSet;
      this.g = paramAttributeSet.getColor(2, this.a.getResources().getColor(2131624416));
      localAttributeSet = paramAttributeSet;
      this.h = paramAttributeSet.getResourceId(3, 2130839631);
      localAttributeSet = paramAttributeSet;
      this.i = paramAttributeSet.getColor(4, this.a.getResources().getColor(2131624583));
      localAttributeSet = paramAttributeSet;
      this.j = paramAttributeSet.getColor(5, this.a.getResources().getColor(2131624046));
      localAttributeSet = paramAttributeSet;
      this.k = paramAttributeSet.getDimensionPixelSize(6, (int)TypedValue.applyDimension(1, 1.0F, this.a.getResources().getDisplayMetrics()));
      localAttributeSet = paramAttributeSet;
      this.l = paramAttributeSet.getBoolean(7, true);
      return;
    }
    finally
    {
      if (localAttributeSet != null) {
        localAttributeSet.recycle();
      }
    }
  }
  
  private void b()
  {
    final EditText localEditText = new EditText(this.a);
    localEditText.setCursorVisible(false);
    localEditText.setTextSize(1.0F);
    localEditText.setInputType(2);
    localEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.e) });
    localEditText.setTextColor(0);
    localEditText.setBackgroundColor(0);
    localEditText.setLayoutParams(getMatchParentParams());
    localEditText.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() > PasswordInputView.a(PasswordInputView.this))
        {
          localEditText.setText(paramAnonymousEditable.subSequence(0, PasswordInputView.a(PasswordInputView.this)));
          return;
        }
        PasswordInputView.b(PasswordInputView.this).delete(0, PasswordInputView.b(PasswordInputView.this).length());
        PasswordInputView.b(PasswordInputView.this).append(paramAnonymousEditable.toString());
        PasswordInputView.c(PasswordInputView.this);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    addView(localEditText);
  }
  
  private void c()
  {
    int m = 0;
    if (m < this.e)
    {
      if (this.d.length() > m) {}
      for (String str = this.d.charAt(m) + "";; str = "")
      {
        if (!str.equals(((TextView)this.c.get(m)).toString())) {
          ((TextView)this.c.get(m)).setText(str);
        }
        m += 1;
        break;
      }
    }
  }
  
  private void d()
  {
    int m = 0;
    LinearLayout localLinearLayout = new LinearLayout(this.a);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(17);
    localLinearLayout.setLayoutParams(getMatchParentParams());
    this.c.clear();
    localLinearLayout.setBackgroundResource(this.h);
    while (m < this.e)
    {
      TextView localTextView = getPasswordTextView();
      localLinearLayout.addView(localTextView);
      this.c.add(localTextView);
      if ((this.l) && (m != this.e - 1)) {
        localLinearLayout.addView(getDivider());
      }
      m += 1;
    }
    addView(localLinearLayout);
  }
  
  private View getDivider()
  {
    View localView = new View(this.a);
    localView.setLayoutParams(new LinearLayout.LayoutParams(this.k, -1));
    localView.setBackgroundColor(this.j);
    return localView;
  }
  
  private RelativeLayout.LayoutParams getMatchParentParams()
  {
    return new RelativeLayout.LayoutParams(-1, -1);
  }
  
  private TextView getPasswordTextView()
  {
    TextView localTextView = new TextView(this.a);
    localTextView.setGravity(17);
    localTextView.setTextColor(this.g);
    localTextView.setTextSize(0, this.f);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.weight = 1.0F;
    localTextView.setLayoutParams(localLayoutParams);
    return localTextView;
  }
  
  public String getPassword()
  {
    return this.d.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/widget/PasswordInputView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */