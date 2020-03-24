package tk.ewentsai.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class OrderDetailVo {

    private String OrderId;
    private BigDecimal amount;
    private String[] booknames;

}
