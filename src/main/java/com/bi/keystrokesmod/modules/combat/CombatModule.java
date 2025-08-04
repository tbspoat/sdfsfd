package com.bi.keystrokesmod.modules.combat; // This MUST match your folder structure

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.common.MinecraftForge; // Import MinecraftForge for event bus

@Mod(modid = CombatModule.MODID, version = CombatModule.VERSION, name = CombatModule.NAME, acceptedMinecraftVersions = "1.8.9")
public class CombatModule { // Removed 'extends Module'
    public static final String MODID = "combatmodule";
    public static final String VERSION = "1.0";
    public static final String NAME = "Combat Module";

    // New variable to track the player's hurtTime from the previous tick
    private int lastHurtTime = 0;

    // This is the main mod instance (optional, but common for easy access)
    public static CombatModule instance;

    public CombatModule() {
        instance = this; // Set the instance
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Register this class (which contains the event handler) with the MinecraftForge event bus
        MinecraftForge.EVENT_BUS.register(this);
        // Equivalent to your old onEnable for event registration
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // This method is called during initialization.
        // Any other mod setup (like registering items/blocks if you had them) would go here.
    }

    // No @Override needed here as it's not overriding a method from a superclass anymore
    // This method will be called every client tick
    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        // Ensure this runs only on the client side and at the end of the tick
        if (event.phase == TickEvent.Phase.END && Minecraft.getMinecraft().theWorld != null) {
            Minecraft mc = Minecraft.getMinecraft();
            EntityPlayerSP player = mc.thePlayer;
            if (player == null) {
                return;
            }

            // --- HIT DETECTION LOGIC ---
            // The condition now checks if hurtTime has been reset to a higher value, indicating a new hit.
            if (player.hurtTime > 0 && player.hurtTime > lastHurtTime) {
                sendHitMessage();
            }

            lastHurtTime = player.hurtTime;
            // --- END OF HIT DETECTION LOGIC ---
        }
    }

    private void sendHitMessage() {
        Minecraft mc = Minecraft.getMinecraft();
        ChatComponentText message = new ChatComponentText(
                EnumChatFormatting.RED + "[Hit Log] You were hit!"
        );
        mc.thePlayer.addChatMessage(message);
    }
}
