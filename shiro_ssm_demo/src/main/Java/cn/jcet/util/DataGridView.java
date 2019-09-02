package cn.jcet.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class DataGridView {
	
	private Long total;
	private List<?> row;

	public DataGridView(Long total, List<?> row) {
		super();
		this.total = total;
		this.row = row;
	}
	
	

}
