package tk.ewentsai.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    private int id;
    private int uid;
    private int bookId;
    private int amount;

}
