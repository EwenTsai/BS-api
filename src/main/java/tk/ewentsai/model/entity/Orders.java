package tk.ewentsai.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    private int id;
    private int uid;
    private int number;
    private BigDecimal amount;
    private Date createTime;
}
