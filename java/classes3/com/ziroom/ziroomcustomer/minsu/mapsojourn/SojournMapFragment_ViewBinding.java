package com.ziroom.ziroomcustomer.minsu.mapsojourn;

import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class SojournMapFragment_ViewBinding<T extends SojournMapFragment>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  private View j;
  private View k;
  
  public SojournMapFragment_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131690906, "field 'etSearch' and method 'onViewClicked'");
    paramT.etSearch = ((EditText)Utils.castView(localView, 2131690906, "field 'etSearch'", EditText.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691648, "field 'ivDelete' and method 'onViewClicked'");
    paramT.ivDelete = ((ImageView)Utils.castView(localView, 2131691648, "field 'ivDelete'", ImageView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690827, "field 'tvFilter' and method 'onViewClicked'");
    paramT.tvFilter = ((TextView)Utils.castView(localView, 2131690827, "field 'tvFilter'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.vDot = Utils.findRequiredView(paramView, 2131694299, "field 'vDot'");
    localView = Utils.findRequiredView(paramView, 2131692497, "field 'tvCity' and method 'onViewClicked'");
    paramT.tvCity = ((TextView)Utils.castView(localView, 2131692497, "field 'tvCity'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131694300, "field 'tvDistrict' and method 'onViewClicked'");
    paramT.tvDistrict = ((TextView)Utils.castView(localView, 2131694300, "field 'tvDistrict'", TextView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693265, "field 'tvDate' and method 'onViewClicked'");
    paramT.tvDate = ((TextView)Utils.castView(localView, 2131693265, "field 'tvDate'", TextView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689995, "field 'tvCount' and method 'onViewClicked'");
    paramT.tvCount = ((TextView)Utils.castView(localView, 2131689995, "field 'tvCount'", TextView.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.clTopbar = Utils.findRequiredView(paramView, 2131694298, "field 'clTopbar'");
    paramT.vMaskBottom = Utils.findRequiredView(paramView, 2131694297, "field 'vMaskBottom'");
    paramT.vMaskTop = Utils.findRequiredView(paramView, 2131694296, "field 'vMaskTop'");
    localView = Utils.findRequiredView(paramView, 2131694302, "field 'vBrowseRecently' and method 'onViewClicked'");
    paramT.vBrowseRecently = localView;
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131694301, "field 'vIvBackSingle' and method 'onViewClicked'");
    paramT.vIvBackSingle = localView;
    this.j = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.vFLcontent = Utils.findRequiredView(paramView, 2131694152, "field 'vFLcontent'");
    paramT.dlFiterArea = ((DrawerLayout)Utils.findRequiredViewAsType(paramView, 2131694303, "field 'dlFiterArea'", DrawerLayout.class));
    paramT.spaceBg = ((Space)Utils.findRequiredViewAsType(paramView, 2131694304, "field 'spaceBg'", Space.class));
    paramT.flFilterContent = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131694305, "field 'flFilterContent'", FrameLayout.class));
    paramView = Utils.findRequiredView(paramView, 2131689492, "method 'onViewClicked'");
    this.k = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    SojournMapFragment localSojournMapFragment = this.a;
    if (localSojournMapFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSojournMapFragment.etSearch = null;
    localSojournMapFragment.ivDelete = null;
    localSojournMapFragment.tvFilter = null;
    localSojournMapFragment.vDot = null;
    localSojournMapFragment.tvCity = null;
    localSojournMapFragment.tvDistrict = null;
    localSojournMapFragment.tvDate = null;
    localSojournMapFragment.tvCount = null;
    localSojournMapFragment.clTopbar = null;
    localSojournMapFragment.vMaskBottom = null;
    localSojournMapFragment.vMaskTop = null;
    localSojournMapFragment.vBrowseRecently = null;
    localSojournMapFragment.vIvBackSingle = null;
    localSojournMapFragment.vFLcontent = null;
    localSojournMapFragment.dlFiterArea = null;
    localSojournMapFragment.spaceBg = null;
    localSojournMapFragment.flFilterContent = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.f.setOnClickListener(null);
    this.f = null;
    this.g.setOnClickListener(null);
    this.g = null;
    this.h.setOnClickListener(null);
    this.h = null;
    this.i.setOnClickListener(null);
    this.i = null;
    this.j.setOnClickListener(null);
    this.j = null;
    this.k.setOnClickListener(null);
    this.k = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/mapsojourn/SojournMapFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */