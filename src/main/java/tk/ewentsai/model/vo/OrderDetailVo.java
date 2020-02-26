package tk.ewentsai.model.vo;

import lombok.Data;
import tk.ewentsai.model.entity.singalOrder;

import java.math.BigDecimal;

@Data
public class OrderDetailVo {

    private int OrderId;
    private BigDecimal amount;
    private singalOrder[] singalOrders;

}
