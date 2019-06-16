/*    */ package com.anotherstar.anticheat;
/*    */ 
/*    */ import cpw.mods.fml.common.network.ByteBufUtils;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ 
/*    */ public class AntiCheatSTCPacketMessage implements IMessage
/*    */ {
/*    */   public Byte[] salt;
/*    */   public AntiCheatSTCPacketMessage(){}
/*    */   public AntiCheatSTCPacketMessage(byte[] salt)
/*    */   {
/* 16 */     this.salt = salt;
/*    */   }
/*    */   
/*    */   public void fromBytes(ByteBuf buf)
/*    */   {
/* 21 */     NBTTagCompound nbt = ByteBufUtils.readTag(buf);
/* 22 */     this.salt = nbt.getByteArray("salt");
/*    */   }
/*    */
           public void toBytes(ByteBuf buf)
           {
               /* 27 */     NBTTagCompound nbt = new NBTTagCompound();
               nbt.setByteArray ("salt", this.salt);
               /* 29 */     ByteBufUtils.writeTag(buf, nbt);
           }
/*    */ }


/* Location:              D:\pro\java\AnotherStarAntiCheat.jar!\com\anotherstar\anticheat\AntiCheatSTCPacketMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */