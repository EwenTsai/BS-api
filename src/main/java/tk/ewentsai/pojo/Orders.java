package tk.ewentsai.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class Orders {
    private int id;
    private int uid;
    private int number;
    private BigDecimal amount;
    private Date createTime;
}
