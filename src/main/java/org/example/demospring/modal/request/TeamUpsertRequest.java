package org.example.demospring.modal.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TeamUpsertRequest {
    private String name;
    List<Integer> figureIds;
}
