package tk.ewentsai.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BookVo {
    private int id;
    private String bookname;
    private BigDecimal price;
    private int amount;

    public BookVo(Object[] o){
        this.id = (int)o[0];
        this.bookname = (String)o[1];
        this.price = (BigDecimal) o[2];
        this.amount = (int)o[3];
    }
}
