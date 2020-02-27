package tk.ewentsai.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int uid;
    private int number;
    private BigDecimal amount;
    private Date createTime;
    @ManyToOne
    //级联保存、更新、删除、刷新;延迟加载。当删除用户，会级联删除该用户的所有文章
    //拥有mappedBy注解的实体类为关系被维护端
    //mappedBy="author"中的author是Article中的author属性
    private singalOrder singalOrder;

    public Orders(int uid, int number, BigDecimal amount){
        this.uid = uid;
        this.number = number;
        this.amount = amount;
        this.createTime = new Date();
    }
}
