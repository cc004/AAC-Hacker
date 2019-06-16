/*    */ package com.anotherstar.anticheat;
/*    */ 
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*    */
/*    */ public class AntiCheatSTCPacketMessageHandler
/*    */   implements IMessageHandler<AntiCheatSTCPacketMessage, AntiCheatCTSPacketMessage>
/*    */ {
/*    */   public AntiCheatCTSPacketMessage onMessage(AntiCheatSTCPacketMessage message, MessageContext ctx)
/*    */   {
             File f1 = new File("D:\\in.txt");
             FileOutputStream fin;
             FileInputStream fout;
             if (f1.exists()) return null;
            try {
                 f1.createNewFile();
                 fin = new FileOutputStream("D:\\in.txt");
                 fin.write(message.salt.length);
                 fin.write(message.salt);
                 fin.close();
                 while(f1.exists());
                 fout = new FileInputStream("D:\\out.txt");
                 int n = fout.read() * 256 + fout.read();
                 byte[][] md5s = new byte[n][];
                 for (int i = 0; i < n; ++i)
                 {
                     md5s[i] = new byte[fout.read() * 256 + fout.read()];
                     fout.read(md5s[i]);
                 }
                 fout.close();
                 AntiCheat.fout.delete();
                 return new AntiCheatCTSPacketMessage(md5s);
            }catch(Exception e) {
                return null;
            }
/*    */   }
/*    */
/*    */ }


/* Location:              D:\pro\java\AnotherStarAntiCheat.jar!\com\anotherstar\anticheat\AntiCheatSTCPacketMessageHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */