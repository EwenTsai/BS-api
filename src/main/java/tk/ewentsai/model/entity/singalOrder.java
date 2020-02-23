package tk.ewentsai.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
public class singalOrder {
    @Id
    private int id;
    private int orderId;
    private int bookId;
}
