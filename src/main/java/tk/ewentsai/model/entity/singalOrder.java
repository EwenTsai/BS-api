package tk.ewentsai.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
public class singalOrder {
    @Id
    private int id;
    private int orderId;
    private int bookId;

    public singalOrder(int orderId, int bookId){
        this.orderId = orderId;
        this.bookId = bookId;
    }
}
