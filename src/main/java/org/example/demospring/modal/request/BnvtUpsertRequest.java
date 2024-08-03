package org.example.demospring.modal.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BnvtUpsertRequest {
    private List<Integer> teamIds;
}
