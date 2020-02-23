package tk.ewentsai.model.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
@Entity
@Table(name = "books")
public class Book {
        @Id
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
