package blockyroad.BlockyRoad.entity.boss;

import blockyroad.BlockyRoad.BlockyRoad;
import blockyroad.BlockyRoad.entity.IModEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityEnchanter extends EntityMob implements IRangedAttackMob, IModEntity {

	protected static final DataParameter<Float> SCALE_FACTOR = EntityDataManager.<Float>createKey(EntityEnchanter.class, DataSerializers.FLOAT);

	public static final ResourceLocation LOOT_TABLE = new ResourceLocation(BlockyRoad.MODID + "loot_tables/entities/enchanter/enchanter");

	private EntityAIAttackRanged aiEnchantedBlast;

	public EntityEnchanter(World world) {
		super(world);

//		DEBUG
		System.out.println("EntityBirdOfPrey constructor(), " + "on Client="
				+ world.isRemote + ", EntityID = " + getEntityId() + ", ModEntityID = " + entityUniqueID);

		this.setSize(2.8F, 4.0F);
		this.experienceValue = 262;
	}

	@Override
	protected void entityInit() {

		super.entityInit();
		dataManager.register(SCALE_FACTOR, 1.0F);
	}

	@Override
	public void clearAITasks() {
		tasks.taskEntries.clear();
		targetTasks.taskEntries.clear();
	}

	@Override
	public void setScaleFactor(float scaleFactor) {
		dataManager.set(SCALE_FACTOR, Math.abs(scaleFactor));

		//Use state to implement boss fight phases
		//dataManager.register(STATE, AIStates.STATE_TAKING_OFF);
	}

	@Override
	public float getScaleFactor() {
		return dataManager.get(SCALE_FACTOR);
	}

	@Override
	public void initEntityAI() {
		aiEnchantedBlast = new EntityAIAttackRanged(this, 1.0D, 20, 60, 15.0F);

		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(4, this.aiEnchantedBlast);
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
		// fall damage for Enchanter while in walking mode
	}

	/**
	 * Takes in the distance the entity has fallen this tick and whether its on the ground to update the fall distance
	 * and deal fall damage if landing on the ground.  Args: distanceFallenThisTick, onGround
	 *
	 * @param y          the y
	 * @param onGroundIn the on ground in
	 * @param state      the state
	 * @param pos        the pos
	 */
	@Override
	protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
		// copy code here from super
	}

	@Override
	public boolean canBeLeashedTo(EntityPlayer parPlayer) {
		return false;
	}

	@Override
	public ResourceLocation getLootTable() {
		return LOOT_TABLE;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {

	}

	@Override
	public void setSwingingArms(boolean swingingArms) {
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setFloat("scaleFactor", getScaleFactor());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		setScaleFactor(compound.getFloat("scaleFactor"));
	}

}