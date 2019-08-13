package net.technearts;

import lombok.Data;

import java.util.Date;

@Data
public class Author {
    private String name;
    private Date birth;
    private Title title;
}
