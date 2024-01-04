package com.fastcampus.jpa.bookmanager.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//public interface BookNameAndCategory {

//String getName();
//String getCategory();
//}

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookNameAndCategory {
    private String name;
    private String category;

}
