package br.com.erudio.vo;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Edilson
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@JsonPropertyOrder({"id", "first_name", "last_name", "gender", "address", "enabled"})
public class PersonVO extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = -276717165117137620L;

	@Mapping("id")
	@JsonProperty("id")
	private long key;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	private String address;
	@JsonIgnore
	private String gender;
	private Boolean enabled;	
}
