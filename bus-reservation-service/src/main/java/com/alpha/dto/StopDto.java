/**
 * 
 */
package com.alpha.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author Anchal.Mathur
 *
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StopDto implements Comparable {
	
	 	private String code;
	    private String name;
	    private String detail;
	    
	    
	    

		public String getCode() {
			return code;
		}



		public void setCode(String code) {
			this.code = code;
		}



		public String getDetail() {
			return detail;
		}



		public void setDetail(String detail) {
			this.detail = detail;
		}



		public void setName(String name) {
			this.name = name;
		}



		public String getName() {
			return name;
		}



	@Override
	public int compareTo(Object o) {
		return this.getName().compareTo(((StopDto) o).getName());
	}

}
