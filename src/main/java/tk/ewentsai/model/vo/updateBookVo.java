package tk.ewentsai.model.vo;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class updateBookVo {

    private int id;
    private String bookname;
    private String author;
    private String releaseTime;
    private String intro;
    private BigDecimal price;
    private float rate;
    private String aboutAuthor;
    private int stock;
    private int sales;

}
