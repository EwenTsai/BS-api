package tk.ewentsai.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    private int id;
    private int uid;
    private int bookid;
    private int amount;

    public Cart(int uid, int bookid) {
        this.uid = uid;
        this.bookid = bookid;
        this.amount = 1;
    }

}
