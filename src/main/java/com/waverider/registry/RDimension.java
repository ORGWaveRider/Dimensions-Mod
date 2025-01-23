package com.waverider.registry;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.dimension.DimensionType;


public class RDimension {
    private static Registerable<DimensionType> context;

    public static void registerDimension(RegistryKey<DimensionType> type, DimensionType options) {
        context.register(type, options);
    }

    public static void initialize() {

    }
}
