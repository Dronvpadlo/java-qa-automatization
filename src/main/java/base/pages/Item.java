package base.pages;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Item {

    private String name;

    private String description;

    private String price;
}
