package blockyroad.BlockyRoad.entity;

public interface IModEntity {

	//Clears inherited AI tasks so you can define all AI tasks specifically
	void clearAITasks();

	//Sets the entity's scale factor
	void setScaleFactor(float scaleFactor);

	//Gets the entity's scale factor
	float getScaleFactor();
}
