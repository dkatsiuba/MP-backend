package ch.zhaw.sml.iwi.pmis.meng.simplebackend.model;

import lombok.Data;

@Data
public class Part {
    private String name;
    private Quantity quantity;
    private EPartType type = EPartType.STANDARD;

    public void setName(String name) {
        this.name = name;
    }
    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }
    public Quantity getQuantity() {
        return quantity;
    }
    public String getName() {
        return name;
    }
    public void setType(EPartType type) {
        this.type = type;
    }
    public EPartType getType() {
        return type;
    }
}
