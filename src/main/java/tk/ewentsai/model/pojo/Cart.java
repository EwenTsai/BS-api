package tk.ewentsai.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cart {
    private int id;
    private int uid;
    private int bookId;
    private int amount;

}
