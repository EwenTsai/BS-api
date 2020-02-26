package tk.ewentsai.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Orders {
    @Id
    private int id;
    private int uid;
    private int number;
    private BigDecimal amount;
    private Date createTime;

    public Orders(int uid, int number, BigDecimal amount){
        this.uid = uid;
        this.number = number;
        this.amount = amount;
        this.createTime = new Date();
    }
}
