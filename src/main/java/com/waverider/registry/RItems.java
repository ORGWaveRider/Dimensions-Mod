package com.waverider.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

import java.util.HashMap;

public class RItems {
    private static final HashMap<RegistryKey<Item>, Item> itemMap = new HashMap<RegistryKey<Item>, Item>();

    public static Item register(Item item, RegistryKey<Item> registryKey) {
        Item rItem = Registry.register(Registries.ITEM, registryKey.getValue(), item);
        itemMap.put(registryKey, rItem);
        return rItem;
    }


    public static void addToGroup(RegistryKey<Item> registryKey, RegistryKey<ItemGroup> group, Item item) {
        if (!itemMap.containsKey(registryKey)) {
            return;
        }
        ItemGroupEvents.modifyEntriesEvent(group).register((itemGroup) -> itemGroup.add(item));
    }
}
