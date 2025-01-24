package com.waverider.Dimensions.Aether.Items.Tools;

import com.waverider.Dimensions.Aether.Items.AetherItems;
import com.waverider.Main;
import com.waverider.registry.RItems;
import net.minecraft.component.Component;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class TestTool {
    private static final RegistryKey<Item> TEST_TOOL_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Main.MOD_ID, "test_tool"));
    private static final Item TEST_TOOL = new Item(new Item.Settings().registryKey(TEST_TOOL_KEY));

    public static void registerTestTool() {
        RItems.registerItem(TEST_TOOL, TEST_TOOL_KEY);
        RItems.addToGroup(TEST_TOOL_KEY, ItemGroups.TOOLS, TEST_TOOL);
    }
}
