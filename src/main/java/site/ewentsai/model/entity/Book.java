package site.ewentsai.model.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
@Entity
@Table(name = "books")
public class Book {
        @Id
        @GeneratedValue
        private int id;
        private String bookname;
        private String author;
        private Date releaseTime;
        private String intro;
        private BigDecimal price;
        private float rate;
        @Lob  // 大对象，映射 MySQL 的 Long Text 类型
        @Column(length = 1000)
        private String aboutAuthor;
        private int stock;
        private int sales;
        private String imageAdress;
}
