package tk.ewentsai.model.pojo;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
@Data
@ToString
public class Book {
        private int id;
        private String bookname;
        private String author;
        private Date releaseTime;
        private String intro;
        private BigDecimal price;
        private float rate;
        private String aboutAuthor;
        private int stock;
        private int sales;
}
