package jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STOCK", catalog = "")
public class Stock implements Serializable {

    private static final long serialVersionUID = -6438567666899732405L;

    private Long id;
    private Item item;
    private Location location;
    private Container container;
    private Long quantity;

    @SequenceGenerator(name = "STOCK_SEQ", sequenceName = "STOCK_SEQ", allocationSize = 1)

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, precision = -127)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STOCK_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "ITEM", referencedColumnName = "ID", nullable = false)
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @ManyToOne
    @JoinColumn(name = "LOCATION", referencedColumnName = "ID")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @ManyToOne
    @JoinColumn(name = "CONTAINER", referencedColumnName = "ID")
    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    @Basic
    @Column(name = "QUANTITY", nullable = false, insertable = true, updatable = true, precision = -127)
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;

        Stock stock = (Stock) o;

        if (container != null ? !container.equals(stock.container) : stock.container != null) return false;
        if (!id.equals(stock.id)) return false;
        if (!item.equals(stock.item)) return false;
        if (location != null ? !location.equals(stock.location) : stock.location != null) return false;
        if (!quantity.equals(stock.quantity)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + item.hashCode();
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (container != null ? container.hashCode() : 0);
        result = 31 * result + quantity.hashCode();
        return result;
    }
}
