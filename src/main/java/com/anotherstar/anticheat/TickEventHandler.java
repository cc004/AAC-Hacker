package com.anotherstar.anticheat;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayerMP;

import java.io.FileInputStream;

public class TickEventHandler {
    @SubscribeEvent
    @SideOnly(Side.SERVER)
public void onTick(TickEvent.PlayerTickEvent event)
{
    if (AntiCheat.fin.exists())
    {
        byte[] esalt;
        try{
            FileInputStream fin = new FileInputStream("D:\\in.txt");
            esalt = new byte[fin.read()];
            fin.read(esalt);
            fin.close();
            System.out.println();
            AntiCheat.antiCheatNetwork.sendTo(new AntiCheatSTCPacketMessage(esalt), (EntityPlayerMP)event.player);
        }catch(Exception e){

        }
    }
}
}
