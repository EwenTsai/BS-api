package tk.ewentsai.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.boot.model.relational.Sequence;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class singalOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String orderId;
    private int bookId;

    @OneToMany//可选属性optional=false,表示orders不能为空。
//    @JoinColumn//设置在article表中的关联字段(外键)
    private List<Orders> orders;

    public singalOrder(String orderId, int bookId){
        this.orderId = orderId;
        this.bookId = bookId;
    }
}
