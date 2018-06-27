package com.megvii.licensemanager;

public abstract interface ILicenseManager
{
  public abstract long checkCachedLicense();
  
  public abstract String getContext(String paramString);
  
  public abstract String getVersion();
  
  public abstract long setLicense(String paramString);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/licensemanager/ILicenseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */