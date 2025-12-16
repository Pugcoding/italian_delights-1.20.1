package net.crow.italiandelight.world.feature;

import net.crow.italiandelight.ItalianDelightMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;


public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registries.PLACED_FEATURE, ItalianDelightMain.MOD_ID);


//    public static final RegistryObject<PlacedFeature> GRAPES_PLACED = PLACED_FEATURES.register("patch_wild_grapes",
//            () -> new PlacedFeature(ModConfiguredFeatures.WILD_GRAPES.getHolder().get(),
//                    List.of(RarityFilter.onAverageOnceEvery((Integer) /*Configuration.CHANCE_WILD_GRAPES.get()*/ 100), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
//
//    public static final RegistryObject<PlacedFeature> HERBS_PLACED = PLACED_FEATURES.register("patch_wild_herbs",
//            () -> new PlacedFeature(ModConfiguredFeatures.WILD_HERBS.getHolder().get(),
//                    List.of(RarityFilter.onAverageOnceEvery((Integer) /*Configuration.CHANCE_WILD_HERBS.get()*/ 100), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

//    public static final RegistryObject<PlacedFeature> OLIVE_TREE_PLACED = PLACED_FEATURES.register("olive_tree_placed",
//            () -> new PlacedFeature(ModConfiguredFeatures.OLIVE_TREE_SPAWN.getHolder().get(),
//                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.05f, 1), BlockInit.OLIVE_SAPLING.get())));//,PlacementUtils.HEIGHTMAP, BiomeFilter
//    // .biome())));

    //    public static final RegistryObject<PlacedFeature> OLIVE_TREE_CHECKED = PLACED_FEATURES.register("olive_tree_checked",
//            () -> new PlacedFeature(ModConfiguredFeatures.OLIVE_KEY.getHolder().get(),
//                    List.of(PlacementUtils.filteredByBlockSurvival(BlockInit.OLIVE_SAPLING.get()))));
    public static void register(IEventBus eventBus) {PLACED_FEATURES.register(eventBus);}
}
