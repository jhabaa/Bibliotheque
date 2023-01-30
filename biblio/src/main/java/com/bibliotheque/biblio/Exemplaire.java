/**************************************************************************
* Source File	:  Exemplaire.java
* Author                   :  ABA'A  
* Project name         :  Non enregistr�* Created                 :  02/06/2021
* Modified   	:  02/06/2021
* Description	:  Definition of the class Exemplaire
**************************************************************************/

package com.bibliotheque.biblio;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;



import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Exemplaire")
@Data
@NoArgsConstructor
public  class Exemplaire  
{ 
	//Inners Classifiers
	

	//Attributes
	
	@Id
	public String code_barre;
		
	
	
	//Attributes Association
	
	
	//Operations
		
		
	
	

} //End Class Exemplaire


