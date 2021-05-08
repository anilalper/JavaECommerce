package core.abstracts;

public abstract class BaseEntity<TPrimaryKey> implements Entity{
	protected TPrimaryKey id;

	public BaseEntity() {
	}
	
	public BaseEntity(TPrimaryKey id) {
		this.id=id;
	}

	public TPrimaryKey getId() {
		return id;
	}

	public void setId(TPrimaryKey id) {
		this.id = id;
	}
}