package net.crow.italiandelight.world.feature;

import net.crow.italiandelight.ItalianDelightMain;
import net.crow.italiandelight.init.BlockInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registries.CONFIGURED_FEATURE, ItalianDelightMain.MOD_ID);

    public static final ResourceKey<ConfiguredFeature<?, ?>> OLIVE_KEY = registerKey("olive");

//    public static final RegistryObject<ConfiguredFeature<?, ?>> OLIVE_TREE =
//            CONFIGURED_FEATURES.register("olive_tree",() ->
//                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
//                            BlockStateProvider.simple(BlockInit.OLIVE_LOG.get()),
//                            new StraightTrunkPlacer(5, 6, 3),
//                            BlockStateProvider.simple(BlockInit.OLIVE_LEAVES.get()),
//                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
//                            new TwoLayersFeatureSize(1, 0, 2)).build()));

//    public static final RegistryObject<ConfiguredFeature<?, ?>> OLIVE_TREE_SPAWN =
//            CONFIGURED_FEATURES.register("olive_tree_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
//                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
//                            ModPlacedFeatures.OLIVE_TREE_CHECKED.getHolder().get(),
//                            0.5f)), ModPlacedFeatures.OLIVE_TREE_CHECKED.getHolder().get())));

//    public static final RegistryObject<ConfiguredFeature<?, ?>> WILD_GRAPES =
//            CONFIGURED_FEATURES.register("wild_grapes", () -> new ConfiguredFeature<>(Feature.FLOWER,
//                    new RandomPatchConfiguration(64,10,2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
//                            new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.WILD_GRAPES.get()))))));
//
//    public static final RegistryObject<ConfiguredFeature<?, ?>> WILD_HERBS =
//            CONFIGURED_FEATURES.register("wild_herbs", () -> new ConfiguredFeature<>(Feature.FLOWER,
//                    new RandomPatchConfiguration(32,6,2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
//                            new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.WILD_HERBS.get()))))));

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context){
        register(context, OLIVE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockInit.OLIVE_LOG.get()),
                new StraightTrunkPlacer(5, 4, 3),

                BlockStateProvider.simple(BlockInit.OLIVE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ItalianDelightMain.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }


    public static void register(IEventBus eventBus) {CONFIGURED_FEATURES.register(eventBus);}
}
