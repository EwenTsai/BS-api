package site.ewentsai.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "eBooks")
public class eBook {
    @Id
    private int id;
    private String bookname;
    private String downloadLink;
}
