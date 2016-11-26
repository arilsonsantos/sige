package br.com.orion.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import br.com.orion.model.enumarate.StatusEnum;
import lombok.Data;

@Data
@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 5, max = 100, message = "{conta.nome.Size}")
	private String nome;

	private LocalDate dataNascimento;

	private BigDecimal valor;

	@Enumerated(EnumType.STRING)
	private StatusEnum status;

	public boolean isAtiva() {
		return StatusEnum.ATIVA.equals(this.status);
	}

	public boolean isCancelada() {
		return StatusEnum.CANCELADA.equals(this.status);
	}

	public boolean isPendente() {
		return StatusEnum.PENDENTE.equals(this.status);
	}

	public boolean isSuspensa() {
		return StatusEnum.SUSPENSA.equals(this.status);
	}

	/*
	 * public void setStatusEnum(StatusEnum status){ this.idStatus =
	 * status.getId();
	 *
	 *
	 * public StatusEnum getById(Integer id){ return StatusEnum.valueOfById(id);
	 * }
	 */

}
