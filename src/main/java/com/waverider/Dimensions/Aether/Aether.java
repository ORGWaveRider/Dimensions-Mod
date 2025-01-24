package com.waverider.Dimensions.Aether;

import com.waverider.Main;
import com.waverider.registry.RDimension;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class Aether {
    private static final RegistryKey<DimensionType> TEST_DIMENSION_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(Main.MOD_ID, "test_dimension"));

    public static void init() {
        RDimension.registerDimension(TEST_DIMENSION_KEY, new DimensionType(
                OptionalLong.of(12000),
                false,
                false,
                false,
                true,
                1.0,
                true,
                false,
                0,
                256,
                256,
                BlockTags.INFINIBURN_NETHER,
                DimensionTypes.OVERWORLD_ID,
                1.0f,
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)
        ));
    }
}
