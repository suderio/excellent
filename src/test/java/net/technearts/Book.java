package net.technearts;

import lombok.Data;

import java.util.List;

@Data
public class Book {
    private List<Author> authors;
    private int publicationYear;
    private Long ISBN;
    private String title;

}
