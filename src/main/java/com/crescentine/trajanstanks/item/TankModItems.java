package com.crescentine.trajanstanks.item;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.TankModEntityTypes;
import com.crescentine.trajanstanks.entity.shell.ShellItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TankModItems {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TankMod.MOD_ID);
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TankMod.MOD_ID);

    //Vehicle Items
    public static final RegistryObject<Item> TANK_ITEM = ITEMS.register("tank_item", () -> new TankSpawnEgg(TankModEntityTypes.PANZER_TWO_ENTITY_TYPE, 0xFFFFFF, 0xFFFFFF, (new Item.Properties()).tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> HEAVY_TANK_ITEM = ITEMS.register("heavy_tank_item", () -> new TankSpawnEgg(TankModEntityTypes.TIGER_ENTITY_TYPE, 0xFFFFFF, 0xFFFFFF, (new Item.Properties()).tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> MEDIUM_TANK_ITEM = ITEMS.register("medium_tank_item", () -> new TankSpawnEgg(TankModEntityTypes.T34_ENTITY_TYPE, 0xFFFFFF, 0xFFFFFF, (new Item.Properties()).tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> CRUISER_MK1_ITEM = ITEMS.register("cruiser_mk1_item", () -> new TankSpawnEgg(TankModEntityTypes.CRUISERMK1_ENTITY_TYPE, 0xFFFFFF, 0xFFFFFF, (new Item.Properties()).tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> M4SHERMAN_ITEM = ITEMS.register("m4sherman_item", () -> new TankSpawnEgg(TankModEntityTypes.M4SHERMAN_ENTITY_TYPE, 0xFFFFFF, 0xFFFFFF, (new Item.Properties()).tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> ARTILLERY_ITEM = ITEMS.register("artillery_item", () -> new TankSpawnEgg(TankModEntityTypes.ARTILLERY_ENTITY_TYPE, 0x7a7873, 0x66625d, (new Item.Properties()).tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));

    //Shells
    public static final RegistryObject<Item> SHELL_ITEM = ITEMS.register("shell_item",
            () -> new ShellItem(new Item.Properties().tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> ARTILLERY_SHELL_ITEM = ITEMS.register("artillery_shell_item",
            () -> new ShellItem(new Item.Properties().tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));
}
