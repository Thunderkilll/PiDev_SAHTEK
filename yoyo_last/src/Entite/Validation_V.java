/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;


/**
 *
 * @author parasol
 */
public class Validation_V {
    
    int valid_id ;
    int code ;
    
    public Validation_V(int valid_id,int code)
    {
        this.valid_id=valid_id ;
        
        this.code=code ;
    }

    public int getValid_id() {
        return valid_id;
    }

    public void setValid_id(int valid_id) {
        this.valid_id = valid_id;
    }

  

   

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    
    
}
