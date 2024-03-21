package com.luccasdev.project.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luccasdev.project.entities.pk.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem  implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId // para dizer que é atributo é de uma classe que tem PK composta
	private OrderItemPK id= new OrderItemPK(); //agr pode ser uma chave primaria por conta da classe aux que esta recebendo as duas chaves e smp temos q instancia-la
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {}

	public OrderItem(Order order, Product product, Integer quantity, Double price) { // nao coloco no construtor o atributo id ainda
		
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	@JsonIgnore // coloquei aqui pois é através desse metodo get que acaba chamando o pedido
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		 id.setOrder(order);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		 id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
