package entity.com;

import java.math.BigDecimal;

public class eproductEntity {

	private long id;
	private String name;
	private BigDecimal price;

	public eproductEntity() {
	}

	public eproductEntity(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "eproductEntity [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
