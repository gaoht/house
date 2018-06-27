package com.ziroom.ziroomcustomer.social.activity.ac;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;

public class AcEnrollActivity_ViewBinding<T extends AcEnrollActivity>
  implements Unbinder
{
  protected T a;
  
  public AcEnrollActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mEtName = ((EditText)Utils.findRequiredViewAsType(paramView, 2131689810, "field 'mEtName'", EditText.class));
    paramT.mEtPhone = ((EditText)Utils.findRequiredViewAsType(paramView, 2131689811, "field 'mEtPhone'", EditText.class));
    paramT.mLvfsvQuestion = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131689814, "field 'mLvfsvQuestion'", ListViewForScrollView.class));
    paramT.mLlQuestion = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131689813, "field 'mLlQuestion'", LinearLayout.class));
    paramT.mBtnSubmit = ((Button)Utils.findRequiredViewAsType(paramView, 2131689816, "field 'mBtnSubmit'", Button.class));
    paramT.sdvMyIcon = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131689809, "field 'sdvMyIcon'", SimpleDraweeView.class));
    paramT.mEtWeixin = ((EditText)Utils.findRequiredViewAsType(paramView, 2131689812, "field 'mEtWeixin'", EditText.class));
    paramT.tvPhotoTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694518, "field 'tvPhotoTitle'", TextView.class));
    paramT.ivPhotoBackgraoud = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131694520, "field 'ivPhotoBackgraoud'", ImageView.class));
    paramT.sdvPhotoSelected = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131694521, "field 'sdvPhotoSelected'", SimpleDraweeView.class));
    paramT.flPhotoArea = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131694519, "field 'flPhotoArea'", FrameLayout.class));
    paramT.itemUploadPhoto = Utils.findRequiredView(paramView, 2131689815, "field 'itemUploadPhoto'");
  }
  
  public void unbind()
  {
    AcEnrollActivity localAcEnrollActivity = this.a;
    if (localAcEnrollActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localAcEnrollActivity.mEtName = null;
    localAcEnrollActivity.mEtPhone = null;
    localAcEnrollActivity.mLvfsvQuestion = null;
    localAcEnrollActivity.mLlQuestion = null;
    localAcEnrollActivity.mBtnSubmit = null;
    localAcEnrollActivity.sdvMyIcon = null;
    localAcEnrollActivity.mEtWeixin = null;
    localAcEnrollActivity.tvPhotoTitle = null;
    localAcEnrollActivity.ivPhotoBackgraoud = null;
    localAcEnrollActivity.sdvPhotoSelected = null;
    localAcEnrollActivity.flPhotoArea = null;
    localAcEnrollActivity.itemUploadPhoto = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/ac/AcEnrollActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */