package telran.java2022.dto;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class PostFindPeriodDto {
	LocalDate dateFrom;
	LocalDate dateTo;
}
