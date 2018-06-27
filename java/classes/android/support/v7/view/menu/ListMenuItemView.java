package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.widget.at;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView
  extends LinearLayout
  implements o.a
{
  private j a;
  private ImageView b;
  private RadioButton c;
  private TextView d;
  private CheckBox e;
  private TextView f;
  private ImageView g;
  private Drawable h;
  private int i;
  private Context j;
  private boolean k;
  private Drawable l;
  private int m;
  private LayoutInflater n;
  private boolean o;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.listMenuViewStyle);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = at.obtainStyledAttributes(getContext(), paramAttributeSet, R.styleable.MenuView, paramInt, 0);
    this.h = paramAttributeSet.getDrawable(R.styleable.MenuView_android_itemBackground);
    this.i = paramAttributeSet.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
    this.k = paramAttributeSet.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
    this.j = paramContext;
    this.l = paramAttributeSet.getDrawable(R.styleable.MenuView_subMenuArrow);
    paramAttributeSet.recycle();
  }
  
  private void a()
  {
    this.b = ((ImageView)getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false));
    addView(this.b, 0);
  }
  
  private void b()
  {
    this.c = ((RadioButton)getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false));
    addView(this.c);
  }
  
  private void c()
  {
    this.e = ((CheckBox)getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false));
    addView(this.e);
  }
  
  private LayoutInflater getInflater()
  {
    if (this.n == null) {
      this.n = LayoutInflater.from(getContext());
    }
    return this.n;
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.g != null)
    {
      localImageView = this.g;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i1 = 0;; i1 = 8)
    {
      localImageView.setVisibility(i1);
      return;
    }
  }
  
  public j getItemData()
  {
    return this.a;
  }
  
  public void initialize(j paramj, int paramInt)
  {
    this.a = paramj;
    this.m = paramInt;
    if (paramj.isVisible()) {}
    for (paramInt = 0;; paramInt = 8)
    {
      setVisibility(paramInt);
      setTitle(paramj.a(this));
      setCheckable(paramj.isCheckable());
      setShortcut(paramj.c(), paramj.a());
      setIcon(paramj.getIcon());
      setEnabled(paramj.isEnabled());
      setSubMenuArrowVisible(paramj.hasSubMenu());
      setContentDescription(paramj.getContentDescription());
      return;
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ViewCompat.setBackground(this, this.h);
    this.d = ((TextView)findViewById(R.id.title));
    if (this.i != -1) {
      this.d.setTextAppearance(this.j, this.i);
    }
    this.f = ((TextView)findViewById(R.id.shortcut));
    this.g = ((ImageView)findViewById(R.id.submenuarrow));
    if (this.g != null) {
      this.g.setImageDrawable(this.l);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.b != null) && (this.k))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      if ((localLayoutParams.height > 0) && (localLayoutParams1.width <= 0)) {
        localLayoutParams1.width = localLayoutParams.height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean prefersCondensedTitle()
  {
    return false;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.c == null) && (this.e == null)) {}
    label51:
    label133:
    label139:
    do
    {
      return;
      Object localObject1;
      Object localObject2;
      if (this.a.isExclusiveCheckable())
      {
        if (this.c == null) {
          b();
        }
        localObject1 = this.c;
        localObject2 = this.e;
        if (!paramBoolean) {
          break label139;
        }
        ((CompoundButton)localObject1).setChecked(this.a.isChecked());
        if (!paramBoolean) {
          break label133;
        }
      }
      for (int i1 = 0;; i1 = 8)
      {
        if (((CompoundButton)localObject1).getVisibility() != i1) {
          ((CompoundButton)localObject1).setVisibility(i1);
        }
        if ((localObject2 == null) || (((CompoundButton)localObject2).getVisibility() == 8)) {
          break;
        }
        ((CompoundButton)localObject2).setVisibility(8);
        return;
        if (this.e == null) {
          c();
        }
        localObject1 = this.e;
        localObject2 = this.c;
        break label51;
      }
      if (this.e != null) {
        this.e.setVisibility(8);
      }
    } while (this.c == null);
    this.c.setVisibility(8);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.a.isExclusiveCheckable()) {
      if (this.c == null) {
        b();
      }
    }
    for (Object localObject = this.c;; localObject = this.e)
    {
      ((CompoundButton)localObject).setChecked(paramBoolean);
      return;
      if (this.e == null) {
        c();
      }
    }
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.o = paramBoolean;
    this.k = paramBoolean;
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int i1;
    if ((this.a.shouldShowIcon()) || (this.o))
    {
      i1 = 1;
      if ((i1 != 0) || (this.k)) {
        break label36;
      }
    }
    label36:
    while ((this.b == null) && (paramDrawable == null) && (!this.k))
    {
      return;
      i1 = 0;
      break;
    }
    if (this.b == null) {
      a();
    }
    if ((paramDrawable != null) || (this.k))
    {
      ImageView localImageView = this.b;
      if (i1 != 0) {}
      for (;;)
      {
        localImageView.setImageDrawable(paramDrawable);
        if (this.b.getVisibility() == 0) {
          break;
        }
        this.b.setVisibility(0);
        return;
        paramDrawable = null;
      }
    }
    this.b.setVisibility(8);
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar)
  {
    if ((paramBoolean) && (this.a.c())) {}
    for (paramChar = '\000';; paramChar = '\b')
    {
      if (paramChar == 0) {
        this.f.setText(this.a.b());
      }
      if (this.f.getVisibility() != paramChar) {
        this.f.setVisibility(paramChar);
      }
      return;
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.d.setText(paramCharSequence);
      if (this.d.getVisibility() != 0) {
        this.d.setVisibility(0);
      }
    }
    while (this.d.getVisibility() == 8) {
      return;
    }
    this.d.setVisibility(8);
  }
  
  public boolean showsIcon()
  {
    return this.o;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/menu/ListMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */