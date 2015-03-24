package services.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement(name = "itemList", namespace = "http://www.carlos.coves.com/jaxb")
public class ItemsListXml {

    private List<ItemXml> itemList;

    public ItemsListXml() {
        this.itemList = new LinkedList<>();
    }

    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    public List<ItemXml> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemXml> itemList) {
        this.itemList = itemList;
    }
}
