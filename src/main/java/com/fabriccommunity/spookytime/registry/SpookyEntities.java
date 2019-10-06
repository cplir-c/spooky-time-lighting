package com.fabriccommunity.spookytime.registry;

import com.fabriccommunity.spookytime.SpookyTime;
import com.fabriccommunity.spookytime.component.CandyComponent;
import com.fabriccommunity.spookytime.component.CandyComponent.VillagerCandyComponent;
import com.fabriccommunity.spookytime.entity.PumpcownEntity;
import com.fabriccommunity.spookytime.entity.SpookyCactusEntity;

import nerdhub.cardinal.components.api.ComponentRegistry;
import nerdhub.cardinal.components.api.ComponentType;
import nerdhub.cardinal.components.api.event.EntityComponentCallback;

import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.registry.Registry;

public class SpookyEntities {
	public static ComponentType<CandyComponent> CANDY = ComponentRegistry.INSTANCE.registerIfAbsent(SpookyTime.id("candy"), CandyComponent.class);
	
	public static EntityType<PumpcownEntity> PUMPCOWN = register("pumpcown", FabricEntityTypeBuilder.create(EntityCategory.CREATURE, PumpcownEntity::new).size(EntityDimensions.fixed(0.9F, 1.4F)).build());
	public static EntityType<SpookyCactusEntity> SPOOKY_CACTUS = register("spooky_cactus", FabricEntityTypeBuilder.create(EntityCategory.MISC, SpookyCactusEntity::new).size(EntityDimensions.changing(0.9F, 1.0F)).build());;
	
	private SpookyEntities() {
		// NO-OP
	}
	
	public static void init() {
		EntityComponentCallback.event(VillagerEntity.class).register((player, components) -> components.put(CANDY, new VillagerCandyComponent()));
	}
	
	private static <T extends Entity> EntityType<T> register(String name, EntityType<T> entity) {
		return Registry.register(Registry.ENTITY_TYPE, SpookyTime.id(name), entity);
	}
}
