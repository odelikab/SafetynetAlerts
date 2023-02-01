package com.openclassrooms.safetynetalerts.model;

import lombok.Data;

@Data
public class Medication {
	public enum name {
		aznol,
		hydrapermazol,
		pharmacol,
		terazine,
		noznazol,
		tetracyclaz,
		dodoxadin,
		thradox,
		ibupurin,
		noxidian,
		tradoxidine
	}
	private int quantity;

}
