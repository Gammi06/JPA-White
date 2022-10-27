package site.metacoding.white3.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class Dog {
    private Integer id;
    private String name;
}

@Getter
@Setter
@AllArgsConstructor
class DogDto {
    private Integer id;
    private String name;
}

public class MapperTest2 {
    @Test
    public void convertTest() {
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog(1, "치와와"));
        dogList.add(new Dog(2, "비숑"));

        // stream -> 타입을 꺼내버림
        List<DogDto> dogDtoList = dogList.stream()
                .map((dog) -> new DogDto(dog.getId(), dog.getName()))
                .collect(Collectors.toList());
    }
}
