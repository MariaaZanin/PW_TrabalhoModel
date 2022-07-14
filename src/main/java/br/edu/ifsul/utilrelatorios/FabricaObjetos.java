package br.edu.ifsul.utilrelatorios;

import br.edu.ifsul.modelo.Cidade;
import java.util.ArrayList;
import java.util.List;

public class FabricaObjetos {
    
      public static List<Cidade> carregaCidades(){
          
        List<Cidade> lista = new ArrayList<>();
        
        Cidade c = new Cidade();
        c.setId(26);
        c.setNome("Porto Alegre");
        c.setPais("Brasil");
        lista.add(c);
        
        return lista;
    }
    
}
