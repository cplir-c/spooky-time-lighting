package com.fabriccommunity.spookytime.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

import com.fabriccommunity.spookytime.SpookyTime;

public class SpookySounds {
	public static final SoundEvent DOOT = register("doot");
	
	public static void init() {
		// NO-OP
	}
	
	private static SoundEvent register(String name) {
		return Registry.register(Registry.SOUND_EVENT, SpookyTime.id(name), new SoundEvent(SpookyTime.id(name)));
	}
}
