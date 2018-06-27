package com.ziroom.ziroomcustomer.signed.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.d.a.b;
import com.d.a.c;
import com.d.a.j;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.R.styleable;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;
import java.util.List;

public class SignerLabeledEditText
  extends RelativeLayout
{
  boolean a;
  private TextView b;
  private TextView c;
  private TextView d;
  private RelativeLayout e;
  private a f;
  private ImageView g;
  private ImageView h;
  private boolean i = false;
  private boolean j;
  private Context k;
  
  public SignerLabeledEditText(Context paramContext)
  {
    super(paramContext);
    this.k = paramContext;
  }
  
  public SignerLabeledEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.k = paramContext;
    setAttributes(paramAttributeSet);
  }
  
  @TargetApi(11)
  public SignerLabeledEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.k = paramContext;
    setAttributes(paramAttributeSet);
  }
  
  private int a(float paramFloat)
  {
    float f1 = getContext().getResources().getDisplayMetrics().density;
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(f1 * paramFloat + 0.5F);
  }
  
  private void a()
  {
    this.c.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        SignerLabeledEditText localSignerLabeledEditText;
        if (!SignerLabeledEditText.a(SignerLabeledEditText.this).isFocused())
        {
          localSignerLabeledEditText = SignerLabeledEditText.this;
          if (TextUtils.isEmpty(paramAnonymousEditable)) {
            break label106;
          }
        }
        label106:
        for (boolean bool = true;; bool = false)
        {
          SignerLabeledEditText.a(localSignerLabeledEditText, bool);
          if (SignerLabeledEditText.b(SignerLabeledEditText.this))
          {
            if (TextUtils.isEmpty(SignerLabeledEditText.c(SignerLabeledEditText.this).getText())) {
              break label153;
            }
            if (TextUtils.isEmpty(paramAnonymousEditable)) {
              break;
            }
            SignerLabeledEditText.c(SignerLabeledEditText.this).setVisibility(0);
            paramAnonymousEditable = SignerLabeledEditText.this.getLayoutParams();
            paramAnonymousEditable.height = SignerLabeledEditText.a(SignerLabeledEditText.this, 88.0F);
            SignerLabeledEditText.this.setLayoutParams(paramAnonymousEditable);
          }
          return;
        }
        SignerLabeledEditText.c(SignerLabeledEditText.this).setVisibility(8);
        paramAnonymousEditable = SignerLabeledEditText.this.getLayoutParams();
        paramAnonymousEditable.height = SignerLabeledEditText.a(SignerLabeledEditText.this, 88.0F);
        SignerLabeledEditText.this.setLayoutParams(paramAnonymousEditable);
        return;
        label153:
        SignerLabeledEditText.c(SignerLabeledEditText.this).setVisibility(8);
        paramAnonymousEditable = SignerLabeledEditText.this.getLayoutParams();
        paramAnonymousEditable.height = SignerLabeledEditText.a(SignerLabeledEditText.this, 88.0F);
        SignerLabeledEditText.this.setLayoutParams(paramAnonymousEditable);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (!TextUtils.isEmpty(this.c.getText())) {
      this.b.setVisibility(0);
    }
  }
  
  private void a(TypedArray paramTypedArray)
  {
    this.e = new RelativeLayout(this.k);
    this.e.setId(2131689484);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131689493);
    localLayoutParams.addRule(0, 2131689494);
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = paramTypedArray.getDimensionPixelSize(10, a(12.0F));
    localLayoutParams.rightMargin = paramTypedArray.getDimensionPixelSize(11, a(12.0F));
    addView(this.e, localLayoutParams);
    b(paramTypedArray);
    c(paramTypedArray);
  }
  
  private void b(TypedArray paramTypedArray)
  {
    this.b = new TextView(this.k);
    this.b.setId(2131689540);
    TextView localTextView = this.b;
    if (TextUtils.isEmpty(paramTypedArray.getString(2))) {}
    for (String str = "";; str = paramTypedArray.getString(2))
    {
      localTextView.setText(str);
      this.b.setTextColor(paramTypedArray.getColor(13, Color.parseColor("#999999")));
      this.b.setTextSize(2, 12.0F);
      this.b.setVisibility(8);
      com.d.c.a.a.wrap(this.b).setAlpha(0.0F);
      this.e.addView(this.b, -2, -2);
      return;
    }
  }
  
  private void c(TypedArray paramTypedArray)
  {
    this.j = paramTypedArray.getBoolean(17, true);
    int m = paramTypedArray.getInteger(18, Integer.MAX_VALUE);
    if (!this.j)
    {
      this.c = new EllipsizingTextView(this.k);
      this.c.setId(2131689481);
      this.c.setMaxLines(1);
      this.c.setMaxEms(m);
      this.c.setEllipsize(TextUtils.TruncateAt.END);
      if (Build.VERSION.SDK_INT < 16) {
        break label432;
      }
      this.c.setBackground(null);
      label93:
      Object localObject = paramTypedArray.getString(3);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.c.setHint((CharSequence)localObject);
      }
      a();
      this.c.setTextSize(2, 16.0F);
      this.c.setHintTextColor(paramTypedArray.getColor(15, Color.parseColor("#999999")));
      this.c.setTextColor(paramTypedArray.getColor(16, Color.parseColor("#444444")));
      this.c.setPadding(0, 0, 0, 0);
      this.c.setInputType(paramTypedArray.getInt(19, 1));
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131689540);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(12.0F * this.k.getResources().getDisplayMetrics().density));
      this.e.addView(this.c, (ViewGroup.LayoutParams)localObject);
      this.i = paramTypedArray.getBoolean(20, false);
      if (this.i)
      {
        this.d = new EllipsizingTextView(this.k);
        this.d.setId(2131689539);
        this.d.setMaxLines(1);
        if (Build.VERSION.SDK_INT < 16) {
          break label443;
        }
        this.d.setBackground(null);
      }
    }
    for (;;)
    {
      this.d.setTextSize(0, paramTypedArray.getDimension(14, n.sp2px(this.k, 16.0F)));
      this.d.setTextColor(paramTypedArray.getColor(16, Color.parseColor("#444444")));
      this.d.setPadding(0, 0, 0, 0);
      paramTypedArray = new RelativeLayout.LayoutParams(-1, -2);
      paramTypedArray.addRule(3, 2131689481);
      paramTypedArray.topMargin = 12;
      this.d.setVisibility(8);
      this.e.addView(this.d, paramTypedArray);
      return;
      this.c = new EditText(this.k);
      break;
      label432:
      this.c.setBackgroundDrawable(null);
      break label93;
      label443:
      this.d.setBackgroundDrawable(null);
    }
  }
  
  private void d(TypedArray paramTypedArray)
  {
    this.g = new ImageView(this.k);
    this.g.setId(2131689493);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramTypedArray.getDimensionPixelSize(6, -2), paramTypedArray.getDimensionPixelSize(7, -2));
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = paramTypedArray.getDimensionPixelSize(4, a(18.0F));
    Drawable localDrawable = paramTypedArray.getDrawable(0);
    if (localDrawable != null)
    {
      this.g.setImageDrawable(localDrawable);
      this.g.setVisibility(0);
      addView(this.g, localLayoutParams);
      this.h = new ImageView(this.k);
      this.h.setId(2131689494);
      localLayoutParams = new RelativeLayout.LayoutParams(paramTypedArray.getDimensionPixelSize(8, -2), paramTypedArray.getDimensionPixelSize(9, -2));
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      localLayoutParams.rightMargin = paramTypedArray.getDimensionPixelSize(5, a(16.0F));
      paramTypedArray = paramTypedArray.getDrawable(1);
      if (paramTypedArray == null) {
        break label234;
      }
      this.h.setImageDrawable(paramTypedArray);
      this.h.setVisibility(0);
    }
    for (;;)
    {
      addView(this.h, localLayoutParams);
      return;
      this.g.setVisibility(8);
      break;
      label234:
      this.h.setVisibility(8);
    }
  }
  
  private void setAttributes(AttributeSet paramAttributeSet)
  {
    setBackgroundColor(-1);
    paramAttributeSet = this.k.obtainStyledAttributes(paramAttributeSet, R.styleable.ZRCustomFloatLabeledEditText);
    d(paramAttributeSet);
    a(paramAttributeSet);
    paramAttributeSet.recycle();
  }
  
  private void setShowHint(final boolean paramBoolean)
  {
    c localc = null;
    if ((this.b.getVisibility() == 0) && (!paramBoolean))
    {
      localObject = new c();
      ((c)localObject).playTogether(new com.d.a.a[] { j.ofFloat(this.b, "translationY", new float[] { 0.0F, this.b.getHeight() / 8 }), j.ofFloat(this.b, "alpha", new float[] { 1.0F, 0.0F }) });
    }
    do
    {
      do
      {
        if (localObject != null)
        {
          ((c)localObject).addListener(new b()
          {
            public void onAnimationEnd(com.d.a.a paramAnonymousa)
            {
              super.onAnimationEnd(paramAnonymousa);
              paramAnonymousa = SignerLabeledEditText.d(SignerLabeledEditText.this);
              int i;
              if (paramBoolean)
              {
                i = 0;
                paramAnonymousa.setVisibility(i);
                paramAnonymousa = com.d.c.a.a.wrap(SignerLabeledEditText.d(SignerLabeledEditText.this));
                if (!paramBoolean) {
                  break label77;
                }
              }
              label77:
              for (float f = 1.0F;; f = 0.0F)
              {
                paramAnonymousa.setAlpha(f);
                if (!paramBoolean) {
                  SignerLabeledEditText.a(SignerLabeledEditText.this).setVisibility(0);
                }
                return;
                i = 8;
                break;
              }
            }
            
            public void onAnimationStart(com.d.a.a paramAnonymousa)
            {
              super.onAnimationStart(paramAnonymousa);
              SignerLabeledEditText.d(SignerLabeledEditText.this).setVisibility(0);
              if (!paramBoolean) {
                SignerLabeledEditText.a(SignerLabeledEditText.this).setVisibility(4);
              }
            }
          });
          ((c)localObject).start();
        }
        return;
        localObject = localc;
      } while (this.b.getVisibility() == 0);
      localObject = localc;
    } while (!paramBoolean);
    localc = new c();
    j localj = j.ofFloat(this.b, "translationY", new float[] { this.b.getHeight() / 8, 0.0F });
    if (this.c.isFocused()) {}
    for (Object localObject = j.ofFloat(this.b, "alpha", new float[] { 0.0F, 1.0F });; localObject = j.ofFloat(this.b, "alpha", new float[] { 0.0F, 1.0F }))
    {
      localc.playTogether(new com.d.a.a[] { localj, localObject });
      localObject = localc;
      break;
    }
  }
  
  public void addTextChangedListener(a parama)
  {
    if (parama != null)
    {
      this.f = parama;
      this.c.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          SignerLabeledEditText localSignerLabeledEditText = SignerLabeledEditText.this;
          if (!TextUtils.isEmpty(paramAnonymousEditable)) {}
          for (boolean bool = true;; bool = false)
          {
            SignerLabeledEditText.a(localSignerLabeledEditText, bool);
            SignerLabeledEditText.e(SignerLabeledEditText.this).afterTextChanged(paramAnonymousEditable);
            return;
          }
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          SignerLabeledEditText.e(SignerLabeledEditText.this).beforeTextChanged(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          SignerLabeledEditText.e(SignerLabeledEditText.this).onTextChanged(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
      });
    }
  }
  
  public void disposeFocus(final View paramView)
  {
    if ((this.j) && (paramView != null) && (this.c != null))
    {
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
      paramView.requestFocus();
      paramView.requestFocusFromTouch();
      setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (paramView != null)
          {
            paramView.setFocusable(false);
            paramView.setFocusableInTouchMode(false);
            paramView.clearFocus();
          }
          paramAnonymousView.setOnClickListener(null);
        }
      });
      this.c.setOnTouchListener(new View.OnTouchListener()
      {
        int a = 0;
        
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if (SignerLabeledEditText.this.hasOnClickListeners())
          {
            this.a += 1;
            if (this.a == 2) {
              SignerLabeledEditText.this.callOnClick();
            }
          }
          return false;
        }
      });
    }
  }
  
  public CharSequence getHint()
  {
    return this.b.getHint();
  }
  
  public String getText()
  {
    String str2 = this.c.getText().toString().trim();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    return str1;
  }
  
  public TextView getTextView()
  {
    return this.c;
  }
  
  public ImageView getmImgLeft()
  {
    return this.g;
  }
  
  public ImageView getmImgRight()
  {
    return this.h;
  }
  
  public void setBottomHint(CharSequence paramCharSequence)
  {
    TextView localTextView = this.c;
    Object localObject = paramCharSequence;
    if (TextUtils.isEmpty(paramCharSequence)) {
      localObject = "";
    }
    localTextView.setHint((CharSequence)localObject);
  }
  
  public void setFocusChangeListenerAvailable(boolean paramBoolean)
  {
    this.a = paramBoolean;
    if (paramBoolean) {
      this.c.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          if (TextUtils.isEmpty(SignerLabeledEditText.this.getText()))
          {
            if (paramAnonymousBoolean) {
              SignerLabeledEditText.a(SignerLabeledEditText.this, true);
            }
          }
          else {
            return;
          }
          SignerLabeledEditText.a(SignerLabeledEditText.this, false);
        }
      });
    }
  }
  
  public void setSelection(int paramInt)
  {
    if ((this.c instanceof EditText)) {
      ((EditText)this.c).setSelection(paramInt);
    }
  }
  
  public void setText(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.c.setText("");
      return;
    }
    this.c.setText(paramString);
  }
  
  public void setText(String paramString1, String paramString2)
  {
    TextView localTextView = this.d;
    Object localObject = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      localObject = "";
    }
    localTextView.setText((CharSequence)localObject);
    localObject = this.c;
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = "";
    }
    ((TextView)localObject).setText(paramString2);
  }
  
  public void setTopHint(CharSequence paramCharSequence)
  {
    TextView localTextView = this.b;
    Object localObject = paramCharSequence;
    if (TextUtils.isEmpty(paramCharSequence)) {
      localObject = "";
    }
    localTextView.setText((CharSequence)localObject);
  }
  
  public void setmImgLeft(ImageView paramImageView)
  {
    this.g = paramImageView;
  }
  
  public void setmImgRight(ImageView paramImageView)
  {
    this.h = paramImageView;
  }
  
  private static class EllipsizingTextView
    extends TextView
  {
    private final List<a> a = new ArrayList();
    private boolean b;
    private boolean c;
    private boolean d;
    private String e;
    private int f = -1;
    private float g = 1.0F;
    private float h = 0.0F;
    
    public EllipsizingTextView(Context paramContext)
    {
      super();
    }
    
    public EllipsizingTextView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public EllipsizingTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    private Layout a(String paramString)
    {
      return new StaticLayout(paramString, getPaint(), getWidth() - getPaddingLeft() - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.g, this.h, false);
    }
    
    /* Error */
    private void a()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 76	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText$EllipsizingTextView:getMaxLines	()I
      //   4: istore 4
      //   6: aload_0
      //   7: getfield 78	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText$EllipsizingTextView:e	Ljava/lang/String;
      //   10: astore 7
      //   12: iload 4
      //   14: iconst_m1
      //   15: if_icmpeq +312 -> 327
      //   18: aload_0
      //   19: aload 7
      //   21: invokespecial 80	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText$EllipsizingTextView:a	(Ljava/lang/String;)Landroid/text/Layout;
      //   24: astore 8
      //   26: aload_0
      //   27: ldc 82
      //   29: invokespecial 80	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText$EllipsizingTextView:a	(Ljava/lang/String;)Landroid/text/Layout;
      //   32: astore 9
      //   34: aload 8
      //   36: invokevirtual 85	android/text/Layout:getWidth	()I
      //   39: istore_3
      //   40: aload 9
      //   42: iconst_0
      //   43: invokevirtual 89	android/text/Layout:getLineWidth	(I)F
      //   46: fstore_2
      //   47: aload 8
      //   49: invokevirtual 92	android/text/Layout:getLineCount	()I
      //   52: iload 4
      //   54: if_icmple +273 -> 327
      //   57: aload 8
      //   59: iload 4
      //   61: iconst_1
      //   62: isub
      //   63: invokevirtual 96	android/text/Layout:getLineEnd	(I)I
      //   66: istore 5
      //   68: aload_0
      //   69: getfield 78	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText$EllipsizingTextView:e	Ljava/lang/String;
      //   72: iconst_0
      //   73: iload 5
      //   75: iconst_0
      //   76: isub
      //   77: invokevirtual 102	java/lang/String:substring	(II)Ljava/lang/String;
      //   80: astore 7
      //   82: aload 8
      //   84: iconst_0
      //   85: invokevirtual 89	android/text/Layout:getLineWidth	(I)F
      //   88: fstore_1
      //   89: iconst_0
      //   90: istore 4
      //   92: fload_1
      //   93: iload_3
      //   94: i2f
      //   95: fcmpl
      //   96: ifle +38 -> 134
      //   99: iload 4
      //   101: iconst_1
      //   102: iadd
      //   103: istore 4
      //   105: aload_0
      //   106: getfield 78	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText$EllipsizingTextView:e	Ljava/lang/String;
      //   109: iconst_0
      //   110: iload 5
      //   112: iload 4
      //   114: isub
      //   115: invokevirtual 102	java/lang/String:substring	(II)Ljava/lang/String;
      //   118: astore 7
      //   120: aload_0
      //   121: aload 7
      //   123: invokespecial 80	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText$EllipsizingTextView:a	(Ljava/lang/String;)Landroid/text/Layout;
      //   126: iconst_0
      //   127: invokevirtual 89	android/text/Layout:getLineWidth	(I)F
      //   130: fstore_1
      //   131: goto -39 -> 92
      //   134: iconst_1
      //   135: istore_3
      //   136: iload_3
      //   137: aload 7
      //   139: invokevirtual 105	java/lang/String:length	()I
      //   142: if_icmpgt +180 -> 322
      //   145: aload_0
      //   146: aload 7
      //   148: aload 7
      //   150: invokevirtual 105	java/lang/String:length	()I
      //   153: iload_3
      //   154: isub
      //   155: aload 7
      //   157: invokevirtual 105	java/lang/String:length	()I
      //   160: invokevirtual 102	java/lang/String:substring	(II)Ljava/lang/String;
      //   163: invokespecial 80	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText$EllipsizingTextView:a	(Ljava/lang/String;)Landroid/text/Layout;
      //   166: iconst_0
      //   167: invokevirtual 89	android/text/Layout:getLineWidth	(I)F
      //   170: fload_2
      //   171: fcmpl
      //   172: ifle +132 -> 304
      //   175: aload 7
      //   177: iconst_0
      //   178: iload 5
      //   180: iload 4
      //   182: isub
      //   183: iload_3
      //   184: isub
      //   185: invokevirtual 102	java/lang/String:substring	(II)Ljava/lang/String;
      //   188: astore 7
      //   190: new 107	java/lang/StringBuilder
      //   193: dup
      //   194: invokespecial 108	java/lang/StringBuilder:<init>	()V
      //   197: aload 7
      //   199: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   202: ldc 82
      //   204: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   207: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   210: astore 7
      //   212: iconst_1
      //   213: istore 6
      //   215: aload 7
      //   217: aload_0
      //   218: invokevirtual 120	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText$EllipsizingTextView:getText	()Ljava/lang/CharSequence;
      //   221: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   224: ifne +19 -> 243
      //   227: aload_0
      //   228: iconst_1
      //   229: putfield 126	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText$EllipsizingTextView:d	Z
      //   232: aload_0
      //   233: aload 7
      //   235: invokevirtual 130	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText$EllipsizingTextView:setText	(Ljava/lang/CharSequence;)V
      //   238: aload_0
      //   239: iconst_0
      //   240: putfield 126	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText$EllipsizingTextView:d	Z
      //   243: aload_0
      //   244: iconst_0
      //   245: putfield 132	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText$EllipsizingTextView:c	Z
      //   248: iload 6
      //   250: aload_0
      //   251: getfield 134	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText$EllipsizingTextView:b	Z
      //   254: if_icmpeq +67 -> 321
      //   257: aload_0
      //   258: iload 6
      //   260: putfield 134	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText$EllipsizingTextView:b	Z
      //   263: aload_0
      //   264: getfield 34	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText$EllipsizingTextView:a	Ljava/util/List;
      //   267: invokeinterface 140 1 0
      //   272: astore 7
      //   274: aload 7
      //   276: invokeinterface 146 1 0
      //   281: ifeq +40 -> 321
      //   284: aload 7
      //   286: invokeinterface 150 1 0
      //   291: checkcast 9	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText$EllipsizingTextView$a
      //   294: iload 6
      //   296: invokeinterface 154 2 0
      //   301: goto -27 -> 274
      //   304: iload_3
      //   305: iconst_1
      //   306: iadd
      //   307: istore_3
      //   308: goto -172 -> 136
      //   311: astore 7
      //   313: aload_0
      //   314: iconst_0
      //   315: putfield 126	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText$EllipsizingTextView:d	Z
      //   318: aload 7
      //   320: athrow
      //   321: return
      //   322: iconst_0
      //   323: istore_3
      //   324: goto -149 -> 175
      //   327: iconst_0
      //   328: istore 6
      //   330: goto -115 -> 215
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	333	0	this	EllipsizingTextView
      //   88	43	1	f1	float
      //   46	125	2	f2	float
      //   39	285	3	i	int
      //   4	179	4	j	int
      //   66	117	5	k	int
      //   213	116	6	bool	boolean
      //   10	275	7	localObject1	Object
      //   311	8	7	localObject2	Object
      //   24	59	8	localLayout1	Layout
      //   32	9	9	localLayout2	Layout
      // Exception table:
      //   from	to	target	type
      //   232	238	311	finally
    }
    
    public void addEllipsizeListener(a parama)
    {
      if (parama == null) {
        throw new NullPointerException();
      }
      this.a.add(parama);
    }
    
    public int getMaxLines()
    {
      return this.f;
    }
    
    public boolean isEllipsized()
    {
      return this.b;
    }
    
    protected void onDraw(Canvas paramCanvas)
    {
      if (this.c)
      {
        super.setEllipsize(null);
        a();
      }
      super.onDraw(paramCanvas);
    }
    
    protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      if (!this.d)
      {
        this.e = paramCharSequence.toString();
        this.c = true;
      }
    }
    
    public void removeEllipsizeListener(a parama)
    {
      this.a.remove(parama);
    }
    
    public void setEllipsize(TextUtils.TruncateAt paramTruncateAt) {}
    
    public void setLineSpacing(float paramFloat1, float paramFloat2)
    {
      this.h = paramFloat1;
      this.g = paramFloat2;
      super.setLineSpacing(paramFloat1, paramFloat2);
    }
    
    public void setMaxLines(int paramInt)
    {
      super.setMaxLines(paramInt);
      this.f = paramInt;
      this.c = true;
    }
    
    public static abstract interface a
    {
      public abstract void ellipsizeStateChanged(boolean paramBoolean);
    }
  }
  
  public static abstract interface a
  {
    public abstract void afterTextChanged(Editable paramEditable);
    
    public abstract void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */