package alex;

import asint.ClaseLexica;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }

  public UnidadLexica unidadId() {
     return new UnidadLexica(alex.fila(),ClaseLexica.IDEN,alex.lexema()); 
  } 
  public UnidadLexica unidadEnt() {
     return new UnidadLexica(alex.fila(),ClaseLexica.ENT,alex.lexema()); 
  } 
  public UnidadLexica unidadReal() {
     return new UnidadLexica(alex.fila(),ClaseLexica.REAL,alex.lexema()); 
  } 
  public UnidadLexica unidadSuma() {
     return new UnidadLexica(alex.fila(),ClaseLexica.MAS,"+"); 
  } 
  public UnidadLexica unidadResta() {
     return new UnidadLexica(alex.fila(),ClaseLexica.MENOS,"-"); 
  } 
  public UnidadLexica unidadMul() {
     return new UnidadLexica(alex.fila(),ClaseLexica.POR,"*"); 
  } 
  public UnidadLexica unidadDiv() {
     return new UnidadLexica(alex.fila(),ClaseLexica.DIV,"/"); 
  } 
  public UnidadLexica unidadPAp() {
     return new UnidadLexica(alex.fila(),ClaseLexica.PAP,"("); 
  } 
  public UnidadLexica unidadPCierre() {
     return new UnidadLexica(alex.fila(),ClaseLexica.PCIERRE,")"); 
  } 
  public UnidadLexica unidadIgual() {
     return new UnidadLexica(alex.fila(),ClaseLexica.IGUAL,"="); 
  } 
  public UnidadLexica unidadComa() {
     return new UnidadLexica(alex.fila(),ClaseLexica.COMA,","); 
  } 
  public UnidadLexica unidadPuntoyComa() {
     return new UnidadLexica(alex.fila(),ClaseLexica.PUNTOYCOMA,";"); 
  } 
  public UnidadLexica unidadEof() {
     return new UnidadLexica(alex.fila(),ClaseLexica.EOF,"<EOF>"); 
  }
  public UnidadLexica unidadMayor() {
	return new UnidadLexica(alex.fila(),ClaseLexica.MAYOR,alex.lexema());
}
public UnidadLexica unidadMenor() {
	return new UnidadLexica(alex.fila(),ClaseLexica.MENOR,alex.lexema());
}
public UnidadLexica unidadMayorIgual() {
	return new UnidadLexica(alex.fila(),ClaseLexica.MAYORIGUAL,alex.lexema());
}
public UnidadLexica unidadMenorIgual() {
	return new UnidadLexica(alex.fila(),ClaseLexica.MENORIGUAL,alex.lexema());
}
public UnidadLexica unidadDistinto() {
	return new UnidadLexica(alex.fila(),ClaseLexica.DISTINTO,alex.lexema());
}
public UnidadLexica unidadCAp() {
   return new UnidadLexica(alex.fila(),ClaseLexica.CAP,"["); 
} 
public UnidadLexica unidadCCierre() {
   return new UnidadLexica(alex.fila(),ClaseLexica.CCIERRE,"]"); 
} 

}
