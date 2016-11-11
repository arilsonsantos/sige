package br.com.orion.model.enumarate;

import lombok.Getter;

public enum StatusEnum {

	ATIVA("Ativa"),
	SUSPENSA("Suspensa"),
	CANCELADA("Cancelada"),
	PENDENTE("Pendente");
	
//	private static final Map<Integer, StatusEnum> LOOKUP = new HashMap<>();
	
//	static{
//		for (StatusEnum e : EnumSet.allOf(StatusEnum.class)){
//			LOOKUP.put(e.descricao, e);
//		}
//	}
//	

	@Getter
	private String descricao;
	
	
	private StatusEnum(String descricao){
		this.descricao = descricao;
	}
	
//	public static StatusEnum valueOfById(Integer id){
//		return LOOKUP.get(id);
//				
//	}

	
	
	
}
