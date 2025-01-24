package com.waverider.Dimensions;

import com.waverider.Dimensions.Aether.Aether;
import com.waverider.Dimensions.Aether.Blocks.AetherBlocks;
import com.waverider.Dimensions.Aether.Items.AetherItems;

public class Dimensions {

    public static void loadDimensions() {
        Aether.init();
    }

    public static void loadItems() {
        AetherItems.aetherItemsInit();

    }
    public static void loadBlocks() {
        AetherBlocks.aetherBlocksInit();
    }
}
