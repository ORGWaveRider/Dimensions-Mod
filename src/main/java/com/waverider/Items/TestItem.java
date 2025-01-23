package com.waverider.Items;

import com.waverider.Main;
import com.waverider.registry.RItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class TestItem {
    public static final RegistryKey<Item> TEST_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Main.MOD_ID, "test_item"));
    public static void init() {
            Item TEST_ITEM = RItems.register(new Item(new Item.Settings().registryKey(TEST_ITEM_KEY)), TEST_ITEM_KEY);
            RItems.addToGroup(TEST_ITEM_KEY, ItemGroups.INGREDIENTS, TEST_ITEM);
    }
}
