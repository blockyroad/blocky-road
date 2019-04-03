package blockyroad.BlockyRoad;

import blockyroad.BlockyRoad.proxy.IProxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = BlockyRoad.MODID, name = BlockyRoad.NAME, version = BlockyRoad.VERSION)
public class BlockyRoad
{
    public static final String MODID = "blockyroad";
    public static final String NAME = "Blocky Road";
    public static final String VERSION = "0.1";

    private static Logger logger;
    
    @Mod.Instance(MODID)
    public static BlockyRoad instance;
    
    @SidedProxy(
    		serverSide = "blockyroad.BlockyRoad.proxy.ServerProxy",
			clientSide = "blockyroad.BlockyRoad.proxy.ClientProxy"
	)
    public static IProxy proxy;
    

    @Mod.EventHandler
	// preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry."
    public void preInit(FMLPreInitializationEvent event)
    {
		// DEBUG
		System.out.println("preInit() " + event.getModMetadata().name);

    	GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
		proxy.preInit(event);
    }

    @Mod.EventHandler
	// Do your mod setup. Build whatever data structures you care about.
	// Register network handlers
    public void init(FMLInitializationEvent event)
    {
		// DEBUG
		System.out.println("init()");

    	proxy.init(event);
    }
    
    @Mod.EventHandler
	// postInit "Handle interaction with other mods, complete your setup based on this."
    public void postInit(FMLPostInitializationEvent event) {
		// DEBUG
		System.out.println("postInit()");

    	proxy.postInit(event);
    }

	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent event)
	{
		// DEBUG
		System.out.println("Server starting");

		proxy.serverStarting(event);
	}
    
    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

		public static void registerItemModel(Item item, int meta, String id) {
			ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(BlockyRoad.MODID + ":" + id, "inventory"));
		}
    	
    	@SubscribeEvent
    	public static void registerItems(RegistryEvent.Register<Item> e) {
    		ModItems.register(e.getRegistry());
    		ModBlocks.registerItemBlocks(e.getRegistry());
    	}
    	
    	@SubscribeEvent
    	public static void registerItems(ModelRegistryEvent e) {
    		ModItems.registerModels();
    		ModBlocks.registerModels();
    	}
    	
    	@SubscribeEvent
    	public static void registerBlocks(RegistryEvent.Register<Block> e) {
    		ModBlocks.register(e.getRegistry());
    	}
    	
    	@SubscribeEvent
    	public static void registerEnchantments(RegistryEvent.Register<Enchantment> e) {
    		ModEnchantments.register(e.getRegistry());
    	}
    	
    }

    private static Logger getLogger() {
        if (logger == null) {
            final Logger tempLogger = LogManager.getLogger();
            tempLogger.error("[" + BlockyRoad.class.getSimpleName() + "]: getLogger called before logger has been initalised! Providing default logger");
            return tempLogger;
        }
        return logger;
    }

    public static void info(final Object... messages) {
        for (final Object msg : messages) {
            getLogger().info(msg);
        }
    }
}

