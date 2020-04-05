package site.ewentsai.model.vo;

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
    private String image_adress;
    private BigDecimal total;

    public BookVo(Object[] o,String image_adress){
        this.id = (int)o[0];
        this.bookname = (String)o[1];
        this.price = (BigDecimal) o[2];
        this.amount = (int)o[3];
        this.image_adress = image_adress;
        total = price.multiply(new BigDecimal(amount));
    }
}
