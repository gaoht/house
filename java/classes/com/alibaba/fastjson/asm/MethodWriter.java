package com.alibaba.fastjson.asm;

public class MethodWriter
  implements MethodVisitor
{
  private int access;
  private ByteVector code = new ByteVector();
  final ClassWriter cw;
  private final int desc;
  int exceptionCount;
  int[] exceptions;
  private int maxLocals;
  private int maxStack;
  private final int name;
  MethodWriter next;
  
  public MethodWriter(ClassWriter paramClassWriter, int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    if (paramClassWriter.firstMethod == null) {
      paramClassWriter.firstMethod = this;
    }
    for (;;)
    {
      paramClassWriter.lastMethod = this;
      this.cw = paramClassWriter;
      this.access = paramInt;
      this.name = paramClassWriter.newUTF8(paramString1);
      this.desc = paramClassWriter.newUTF8(paramString2);
      if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
        break;
      }
      this.exceptionCount = paramArrayOfString.length;
      this.exceptions = new int[this.exceptionCount];
      paramInt = 0;
      while (paramInt < this.exceptionCount)
      {
        this.exceptions[paramInt] = paramClassWriter.newClassItem(paramArrayOfString[paramInt]).index;
        paramInt += 1;
      }
      paramClassWriter.lastMethod.next = this;
    }
  }
  
  final int getSize()
  {
    int i = 8;
    if (this.code.length > 0)
    {
      this.cw.newUTF8("Code");
      i = 8 + (this.code.length + 18 + 0);
    }
    int j = i;
    if (this.exceptionCount > 0)
    {
      this.cw.newUTF8("Exceptions");
      j = i + (this.exceptionCount * 2 + 8);
    }
    return j;
  }
  
  final void put(ByteVector paramByteVector)
  {
    int k = 0;
    paramByteVector.putShort(this.access & 0xFFF9FFFF).putShort(this.name).putShort(this.desc);
    if (this.code.length > 0) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.exceptionCount > 0) {
        j = i + 1;
      }
      paramByteVector.putShort(j);
      if (this.code.length > 0)
      {
        i = this.code.length;
        paramByteVector.putShort(this.cw.newUTF8("Code")).putInt(i + 12 + 0);
        paramByteVector.putShort(this.maxStack).putShort(this.maxLocals);
        paramByteVector.putInt(this.code.length).putByteArray(this.code.data, 0, this.code.length);
        paramByteVector.putShort(0);
        paramByteVector.putShort(0);
      }
      if (this.exceptionCount > 0)
      {
        paramByteVector.putShort(this.cw.newUTF8("Exceptions")).putInt(this.exceptionCount * 2 + 2);
        paramByteVector.putShort(this.exceptionCount);
        i = k;
        while (i < this.exceptionCount)
        {
          paramByteVector.putShort(this.exceptions[i]);
          i += 1;
        }
      }
      return;
    }
  }
  
  public void visitEnd() {}
  
  public void visitFieldInsn(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = this.cw.newFieldItem(paramString1, paramString2, paramString3);
    this.code.put12(paramInt, paramString1.index);
  }
  
  public void visitIincInsn(int paramInt1, int paramInt2)
  {
    this.code.putByte(132).put11(paramInt1, paramInt2);
  }
  
  public void visitInsn(int paramInt)
  {
    this.code.putByte(paramInt);
  }
  
  public void visitIntInsn(int paramInt1, int paramInt2)
  {
    this.code.put11(paramInt1, paramInt2);
  }
  
  public void visitJumpInsn(int paramInt, Label paramLabel)
  {
    if (((paramLabel.status & 0x2) != 0) && (paramLabel.position - this.code.length < 32768)) {
      throw new UnsupportedOperationException();
    }
    this.code.putByte(paramInt);
    paramLabel.put(this, this.code, this.code.length - 1);
  }
  
  public void visitLabel(Label paramLabel)
  {
    paramLabel.resolve(this, this.code.length, this.code.data);
  }
  
  public void visitLdcInsn(Object paramObject)
  {
    paramObject = this.cw.newConstItem(paramObject);
    int i = ((Item)paramObject).index;
    if ((((Item)paramObject).type == 5) || (((Item)paramObject).type == 6))
    {
      this.code.put12(20, i);
      return;
    }
    if (i >= 256)
    {
      this.code.put12(19, i);
      return;
    }
    this.code.put11(18, i);
  }
  
  public void visitMaxs(int paramInt1, int paramInt2)
  {
    this.maxStack = paramInt1;
    this.maxLocals = paramInt2;
  }
  
  public void visitMethodInsn(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool;
    int i;
    if (paramInt == 185)
    {
      bool = true;
      paramString1 = this.cw.newMethodItem(paramString1, paramString2, paramString3, bool);
      i = paramString1.intVal;
      if (!bool) {
        break label80;
      }
      if (i != 0) {
        break label94;
      }
      paramInt = Type.getArgumentsAndReturnSizes(paramString3);
      paramString1.intVal = paramInt;
    }
    for (;;)
    {
      this.code.put12(185, paramString1.index).put11(paramInt >> 2, 0);
      return;
      bool = false;
      break;
      label80:
      this.code.put12(paramInt, paramString1.index);
      return;
      label94:
      paramInt = i;
    }
  }
  
  public void visitTypeInsn(int paramInt, String paramString)
  {
    paramString = this.cw.newClassItem(paramString);
    this.code.put12(paramInt, paramString.index);
  }
  
  public void visitVarInsn(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 4) && (paramInt1 != 169))
    {
      if (paramInt1 < 54) {}
      for (paramInt1 = (paramInt1 - 21 << 2) + 26 + paramInt2;; paramInt1 = (paramInt1 - 54 << 2) + 59 + paramInt2)
      {
        this.code.putByte(paramInt1);
        return;
      }
    }
    if (paramInt2 >= 256)
    {
      this.code.putByte(196).put12(paramInt1, paramInt2);
      return;
    }
    this.code.put11(paramInt1, paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/asm/MethodWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */