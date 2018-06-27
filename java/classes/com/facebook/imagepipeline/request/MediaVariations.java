package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class MediaVariations
{
  private final boolean mForceRequestForSpecifiedUri;
  private final String mMediaId;
  @Nullable
  private final List<Variant> mVariants;
  
  private MediaVariations(Builder paramBuilder)
  {
    this.mMediaId = paramBuilder.mMediaId;
    this.mVariants = paramBuilder.mVariants;
    this.mForceRequestForSpecifiedUri = paramBuilder.mForceRequestForSpecifiedUri;
  }
  
  @Nullable
  public static MediaVariations forMediaId(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return null;
    }
    return newBuilderForMediaId(paramString).build();
  }
  
  public static Builder newBuilderForMediaId(String paramString)
  {
    return new Builder(paramString, null);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MediaVariations)) {}
    do
    {
      return false;
      paramObject = (MediaVariations)paramObject;
    } while ((!Objects.equal(this.mMediaId, ((MediaVariations)paramObject).mMediaId)) || (this.mForceRequestForSpecifiedUri != ((MediaVariations)paramObject).mForceRequestForSpecifiedUri) || (!Objects.equal(this.mVariants, ((MediaVariations)paramObject).mVariants)));
    return true;
  }
  
  public String getMediaId()
  {
    return this.mMediaId;
  }
  
  @Nullable
  public List<Variant> getVariants()
  {
    return this.mVariants;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.mMediaId, Boolean.valueOf(this.mForceRequestForSpecifiedUri), this.mVariants });
  }
  
  public boolean shouldForceRequestForSpecifiedUri()
  {
    return this.mForceRequestForSpecifiedUri;
  }
  
  public String toString()
  {
    return String.format((Locale)null, "%s-%b-%s", new Object[] { this.mMediaId, Boolean.valueOf(this.mForceRequestForSpecifiedUri), this.mVariants });
  }
  
  public static class Builder
  {
    private boolean mForceRequestForSpecifiedUri = false;
    private final String mMediaId;
    private List<MediaVariations.Variant> mVariants;
    
    private Builder(String paramString)
    {
      this.mMediaId = paramString;
    }
    
    public Builder addVariant(Uri paramUri, int paramInt1, int paramInt2)
    {
      if (this.mVariants == null) {
        this.mVariants = new ArrayList();
      }
      this.mVariants.add(new MediaVariations.Variant(paramUri, paramInt1, paramInt2));
      return this;
    }
    
    public MediaVariations build()
    {
      return new MediaVariations(this, null);
    }
    
    public Builder setForceRequestForSpecifiedUri(boolean paramBoolean)
    {
      this.mForceRequestForSpecifiedUri = paramBoolean;
      return this;
    }
  }
  
  public static final class Variant
  {
    private final int mHeight;
    private final Uri mUri;
    private final int mWidth;
    
    public Variant(Uri paramUri, int paramInt1, int paramInt2)
    {
      this.mUri = paramUri;
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof Variant)) {}
      do
      {
        return false;
        paramObject = (Variant)paramObject;
      } while ((!Objects.equal(this.mUri, ((Variant)paramObject).mUri)) || (this.mWidth != ((Variant)paramObject).mWidth) || (this.mHeight != ((Variant)paramObject).mHeight));
      return true;
    }
    
    public int getHeight()
    {
      return this.mHeight;
    }
    
    public Uri getUri()
    {
      return this.mUri;
    }
    
    public int getWidth()
    {
      return this.mWidth;
    }
    
    public int hashCode()
    {
      return (this.mUri.hashCode() * 31 + this.mWidth) * 31 + this.mHeight;
    }
    
    public String toString()
    {
      return String.format((Locale)null, "%dx%d %s", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), this.mUri });
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/request/MediaVariations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */