package com.waverider.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

import java.util.HashMap;

public class RItems {
    private static final HashMap<RegistryKey<Item>, Item> itemMap = new HashMap<>();

    /**
     * @param item Item to register
     * @param registryKey Unique Key for item
     * @param isCompostable Whether the item is compostable
     * @param compostInc Compostable level increase
     * @param isFuel Whether the item can be used as fuel
     * @param fuelTime The amount of time the fuel burns for in seconds
     */
    public static void register(Item item, RegistryKey<Item> registryKey, boolean isCompostable, float compostInc, boolean isFuel, int fuelTime) {
        Item rItem = Registry.register(Registries.ITEM, registryKey.getValue(), item);
        itemMap.put(registryKey, rItem);
        if (isCompostable) {
            CompostingChanceRegistry.INSTANCE.add(item, compostInc);
        }
        if (isFuel) {
            FuelRegistryEvents.BUILD.register(((builder, context) -> {
                builder.add(item, fuelTime * 20);
            }));
        }
    }

    public static void registerItem(Item item, RegistryKey<Item> registryKey) {
        register(item, registryKey, false, 0.0f, false, 0);
    }

    public static void registerItemCompostable(Item item, RegistryKey<Item> registryKey, float compostInc) {
        register(item, registryKey, true, compostInc, false, 0);
    }

    public static void registerItemFuel(Item item, RegistryKey<Item> registryKey, int fuelTime) {
        register(item, registryKey, false, 0.0f, true, fuelTime);
    }



    public static void addToGroup(RegistryKey<Item> registryKey, RegistryKey<ItemGroup> group, Item item) {
        if (!itemMap.containsKey(registryKey)) {
            return;
        }
        ItemGroupEvents.modifyEntriesEvent(group).register((itemGroup) -> itemGroup.add(item));
    }
}
