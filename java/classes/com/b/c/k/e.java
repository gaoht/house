package com.b.c.k;

import com.b.c.g;

public class e
  extends g<f>
{
  public e(f paramf)
  {
    super(paramf);
  }
  
  public String getComponentDataDescription(int paramInt)
  {
    d locald = ((f)this.a).getComponent(paramInt);
    if (locald == null) {
      return null;
    }
    return locald.getComponentName() + " component: Quantization table " + locald.getQuantizationTableNumber() + ", Sampling factors " + locald.getHorizontalSamplingFactor() + " horiz/" + locald.getVerticalSamplingFactor() + " vert";
  }
  
  public String getDataPrecisionDescription()
  {
    String str = ((f)this.a).getString(0);
    if (str == null) {
      return null;
    }
    return str + " bits";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    case -2: 
    case -1: 
    case 2: 
    case 4: 
    case 5: 
    default: 
      return super.getDescription(paramInt);
    case -3: 
      return getImageCompressionTypeDescription();
    case 6: 
      return getComponentDataDescription(0);
    case 7: 
      return getComponentDataDescription(1);
    case 8: 
      return getComponentDataDescription(2);
    case 9: 
      return getComponentDataDescription(3);
    case 0: 
      return getDataPrecisionDescription();
    case 1: 
      return getImageHeightDescription();
    }
    return getImageWidthDescription();
  }
  
  public String getImageCompressionTypeDescription()
  {
    return a(-3, new String[] { "Baseline", "Extended sequential, Huffman", "Progressive, Huffman", "Lossless, Huffman", null, "Differential sequential, Huffman", "Differential progressive, Huffman", "Differential lossless, Huffman", "Reserved for JPEG extensions", "Extended sequential, arithmetic", "Progressive, arithmetic", "Lossless, arithmetic", null, "Differential sequential, arithmetic", "Differential progressive, arithmetic", "Differential lossless, arithmetic" });
  }
  
  public String getImageHeightDescription()
  {
    String str = ((f)this.a).getString(1);
    if (str == null) {
      return null;
    }
    return str + " pixels";
  }
  
  public String getImageWidthDescription()
  {
    String str = ((f)this.a).getString(3);
    if (str == null) {
      return null;
    }
    return str + " pixels";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/k/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */