package streamapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Month;
import java.time.Year;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Birthday {

    private Month mouth;
    @Min(1)
    @Max(30)
    private Integer day;
    private Year year;
}
