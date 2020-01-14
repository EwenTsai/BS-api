package tk.ewentsai.model.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookVo {
    private int id;
    private String bookname;
    private BigDecimal price;
}
