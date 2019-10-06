package com.fabriccommunity.spookytime.registry;

import com.fabriccommunity.spookytime.SpookyTime;
import com.fabriccommunity.spookytime.registry.SpookyEntities;

import dev.emi.trinkets.api.TrinketSlots;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.item.BucketItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.MushroomStewItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Rarity;

import com.fabriccommunity.spookytime.item.CandyItem;
import com.fabriccommunity.spookytime.item.PumpkinRing;
import com.fabriccommunity.spookytime.item.SkirtCostume;
import com.fabriccommunity.spookytime.item.SpookyTrumpetItem;
import com.fabriccommunity.spookytime.item.tool.ScytheItem;
import com.fabriccommunity.spookytime.item.tool.SpookiumMaterial;
import com.fabriccommunity.spookytime.util.PumpkinFoods;

public class SpookyItems {
	// Fluid Buckets
	public static final BucketItem WITCH_WATER_BUCKET = register("witch_water_bucket", new BucketItem(SpookyFluids.WITCH_WATER, new Item.Settings().recipeRemainder(Items.BUCKET).group(SpookyTime.GROUP)));
	public static final BucketItem BLOOD_BUCKET = register("blood_bucket", new BucketItem(SpookyFluids.BLOOD, new Item.Settings().recipeRemainder(Items.BUCKET).group(SpookyTime.GROUP)));
	// Spookium
	public static final Item SPOOKIUM_INGOT = register("spookium_ingot", new Item(new Item.Settings().group(SpookyTime.GROUP).rarity(Rarity.EPIC)));
	public static final Item SPOOKIUM_NUGGET = register("spookium_nugget", new Item(new Item.Settings().group(SpookyTime.GROUP).rarity(Rarity.EPIC)));
	public static final ToolMaterial SPOOKIUM = new SpookiumMaterial();
	// Artifacts
	public static final Item BLAZE_SKIRT = register("blaze_skirt", new SkirtCostume(new Item.Settings().group(SpookyTime.GROUP).maxCount(1)));
	public static final Item REAPERS_SCYTHE = register("reapers_scythe", new ScytheItem(SPOOKIUM, 3, -2.0F, new Item.Settings().group(SpookyTime.GROUP).maxCount(1).rarity(Rarity.EPIC)));
	public static final Item SOUL_BOTTLE = register("soul_bottle", new Item(new Item.Settings().group(SpookyTime.GROUP)));
	public static final Item PUMPCOWN_SPAWN_EGG = register("pumpcown_spawn_egg", new SpawnEggItem(SpookyEntities.PUMPCOWN, 8273166, 14912029, new Item.Settings().group(SpookyTime.GROUP)));
	public static final Item PUMPKIN_RING = register("pumpkin_ring", new PumpkinRing(new Item.Settings().group(SpookyTime.GROUP)));
	public static final Item SPOOKY_TRUMPET = register("spooky_trumpet", new SpookyTrumpetItem(new Item.Settings().group(SpookyTime.GROUP)));
	// Food
	public static final Item CARAMEL_APPLE = register("caramel_apple", new CandyItem(new Item.Settings().group(SpookyTime.GROUP), 5, 0.3F));
	public static final Item PUMPKIN_CANDY = register("pumpkin_candy", new CandyItem(new Item.Settings().group(SpookyTime.GROUP), 2, 0.3F));
	public static final Item RARE_CANDY = register("rare_candy", new CandyItem(new Item.Settings().group(SpookyTime.GROUP), 3, 0.3F));
	public static final Item WINGED_STRAWBERRY_CANDY = register("winged_strawberry_candy", new CandyItem(new Item.Settings().group(SpookyTime.GROUP), 1, 0.1F));
	public static final Item PEPPERMINT = register("peppermint", new CandyItem(new Item.Settings().group(SpookyTime.GROUP), 1, 0.2F));
	public static final Item BAKED_PUMPKIN_SEEDS = register("baked_pumpkin_seeds", new Item(new Item.Settings().group(SpookyTime.GROUP).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).snack().build())));
	public static final Item PUMPKIN_STEW = register("pumpkin_stew", new MushroomStewItem(new Item.Settings().group(SpookyTime.GROUP).food(new FoodComponent.Builder().hunger(7).saturationModifier(1.4f).build()).recipeRemainder(Items.BOWL)));
	
	
	private SpookyItems() {
		// NO-OP
	}
	
	public static void init() {
		TrinketSlots.addSubSlot("legs", "belt", new Identifier("trinkets", "textures/item/empty_trinket_slot_belt.png"));
		TrinketSlots.addSubSlot("hand", "ring", new Identifier("trinkets", "textures/item/empty_trinket_slot_ring.png"));
		
		PumpkinFoods.registerPumpkinFood(Items.PUMPKIN_PIE);
		PumpkinFoods.registerPumpkinFood(SpookyItems.BAKED_PUMPKIN_SEEDS);
		PumpkinFoods.registerPumpkinFood(SpookyItems.PUMPKIN_STEW);
		PumpkinFoods.registerPumpkinFood(SpookyItems.PUMPKIN_CANDY);
		PumpkinFoods.registerPumpkinFood(SpookyBlocks.TINY_PUMPKIN.asItem());
		PumpkinFoods.registerPumpkinFood(SpookyBlocks.WITCHED_PUMPKIN.asItem());
	}
	
	protected static <T extends Item> T register(String name, T item) {
		return Registry.register(Registry.ITEM, SpookyTime.id(name), item);
	}
}
